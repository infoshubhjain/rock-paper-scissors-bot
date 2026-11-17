# Rock, Paper, Scissors: Can You Outsmart the Bot?

## Start here

Can you change your choices before the bot catches on? In this mini project, you will complete a small Java program that counts your earlier moves and uses the most common one as its next guess. The bot starts with random moves. After five completed rounds, it counters a uniquely most frequent move. This is a simple predictive rule, not a machine learning model, and its guesses can be wrong.

Allow about two hours for reading, coding, testing, three experiments, and a short reflection. You will make **two** changes to the starter file. The completed version is in `solution/` for checking your work after you try.

## What you will build

The finished game reads a menu choice, plays a round, reports the winner, keeps score, and displays counts. Input outside 1 through 4 is rejected without adding a round.

**After you finish both TODOs**, a first round may look like this. The computer's random move and the result can differ on your run.

```text
================================
     CAN YOU OUTSMART THE BOT?
================================

Choose your move:
1. Rock
2. Paper
3. Scissors
4. Quit
Your choice: 1

Fewer than five rounds played. I chose randomly.

You chose: Rock
Computer chose: Scissors

You win!

Current statistics:
Rock: 1
Paper: 0
Scissors: 0

Score:
Player: 1
Computer: 0
Ties: 0
```

After five previous Rocks, the next round says `I think you're going to choose Rock...` and the computer plays Paper. With enough history but tied highest counts, it reports that no unique prediction is available and chooses randomly. The current choice is added to the statistics only after the round.

## What you will practice

| Concept | In this program |
| --- | --- |
| Arrays | Keep three move counts in one variable |
| Loops | Visit each count to find the largest |
| Conditionals | Check the history threshold and tied counts |
| Methods | Keep input, prediction, result, and display code separate |
| Randomness | Choose a move when there is no clear prediction |

## Set up and run

Install **Java 17 or later**. If you do not already have it, download a **JDK** for your operating system from [Eclipse Temurin](https://adoptium.net/temurin/releases/?version=17) and run its installer. In a terminal, run `java -version` and `javac -version`. Both should report version 17 or higher. If a command is missing after installation, reopen the terminal and check that the JDK's `bin` directory is on your PATH. A JRE alone does not include `javac`.

Open a terminal in this repository, then enter the starter directory:

```bash
cd starter-code
javac RockPaperScissorsBot.java
java RockPaperScissorsBot
```

`cd` changes your current directory. `javac` compiles the source into a `.class` file. `java` runs that compiled class. Edit the `.java` file and compile again after each change. To run the completed version instead, return to the repository root, enter `solution`, and use the same two commands. Compile the two directories separately because both contain a class with the same name.

Before either TODO is complete, the starter still runs, but the counts stay at zero and every computer move is random. That is expected.

In VS Code, choose **File > Open Folder** and select the `starter-code` folder itself. Open `RockPaperScissorsBot.java` in the Explorer, then choose **Terminal > New Terminal**. That terminal is already in `starter-code`, so run only `javac RockPaperScissorsBot.java` and `java RockPaperScissorsBot` from the block above. Use **File > Open File** to read the repository's `README.md` if you want it open beside the code. Opening only `starter-code` keeps the separate solution class out of your Run menu. If `java` or `javac` is not found, follow the JDK check above. In IntelliJ IDEA, open `starter-code` as the project and run its `main` method. No library or build tool is needed.

## Understand the game first

| Move | Beats |
| --- | --- |
| Rock | Scissors |
| Paper | Rock |
| Scissors | Paper |

The program uses `0` for Rock, `1` for Paper, and `2` for Scissors. Integers make it easy to index an array and cycle through moves; `MOVES` converts them back to names for display. Menu choices are 1, 2, and 3, so `getPlayerMove` translates them to 0, 1, and 2.

```java
int[] counts = new int[3];
counts[0]++; // Add one Rock
counts[1]++; // Add one Paper
counts[2]++; // Add one Scissors
```

An array stores related values at numbered positions. `new int[3]` creates three zeros. The bracketed number selects a position, and `++` increases its value by one. For example, after Rock, Paper, Rock, the array is `[2, 1, 0]`. Your TODO will use the player's move index to update one of these positions.

## How the prediction works

Suppose the **previous** moves are Rock, Rock, Paper, Rock, Scissors:

```text
Index:   0  1  2
Move:    R  P  S
Count:   3  1  1
```

Five rounds are complete. The largest count is 3, and only Rock has it. The bot predicts Rock, so it plays Paper. Five rounds is a project design choice, not a guarantee that the guess is good. With fewer than five previous rounds, it plays randomly. It also plays randomly if all three counts tie or if two share the highest count, such as `[3, 3, 0]`. A lower tie does not matter: `[3, 1, 1]` still predicts Rock.

The bot decides before it even reads the current choice. It adds that choice to `counts` only after the round. This prevents it from looking at the answer to the round it is trying to predict.

## Meet the starter code

`main(String[] args)` starts the game, keeps the array and scores, and calls the other methods once per round. It returns nothing. `findMostFrequentMove(int[] counts, int roundsPlayed)` reads completed history and returns a move index or `-1` for no unique prediction. `getCounterMove(int predictedMove)` returns the move that beats the prediction. `getPlayerMove(Scanner scanner)` then reads the current menu choice and returns its index or `-1` for Quit. `determineWinner(int playerMove, int computerMove)` returns 0 for tie, 1 for player win, or 2 for computer win. `displayStatistics(int[] counts)` prints the three counts and returns nothing.

```text
Start -> Check previous history
           | no prediction -> random move
           | prediction    -> counter move
      -> Get player move (or Quit)
      -> Determine winner -> Update score and counts
      -> Display statistics -> Next round
```

## Your two tasks

1. **TODO 1: Count the player's move.** Find the comment just after the winner is reported. Increment the array entry selected by `playerMove` exactly once. This must happen before `displayStatistics`, but after the computer has chosen. If the move index were 2, which array entry would change?
2. **TODO 2: Find the most frequent move.** Replace the placeholder `return -1` in `findMostFrequentMove`. The method should return an index only when at least five rounds are complete and one count is strictly greater than both others. Return `-1` otherwise. `main` already converts `-1` into a random move; do not choose a random move inside this method.

**Checkpoint after TODO 1:** Compile and play one Rock. The statistics should say `Rock: 1`. If they still say zero, check the array index and where you placed the increment. The bot will still choose randomly until TODO 2 is complete.

**Checkpoint after TODO 2:** Compile again. Play five Rocks, then one more. On round six, the bot should predict Rock and choose Paper. It should not predict during the first five rounds.

Pseudocode for TODO 2:

```text
if fewer than five rounds are complete, return -1
remember the index of the largest count seen so far
remember whether that largest count is tied
for each remaining count:
    if it is larger, update the best index and clear the tie
    if it equals the current largest, record a tie
return -1 if tied; otherwise return the best index
```

Hint: initialize the best index to 0, then inspect indices 1 and 2. A new larger value erases an earlier tie. For example, scanning `[2, 2, 3]` must end at Scissors, not at a tie. See [the algorithm walkthrough](teaching-materials/algorithm-walkthrough.md) for a trace before opening the solution.

## Test your work

Compile after each TODO. Use the menu to play these sequences. For random rounds, check that the displayed computer move is valid rather than expecting a specific move.

After TODO 2, run the small self-check from the `starter-code` terminal:

```bash
javac RockPaperScissorsBot.java StudentCheck.java
java StudentCheck
```

It prints `All prediction checks passed.` when the threshold, three possible leaders, and tied-count cases work. If a check fails, its message names the case to revisit. This checks your **own starter file**, not the supplied solution. It does not check TODO 1, so use the one-Rock checkpoint for that.

| Input or previous completed rounds | What to check |
| --- | --- |
| 0 to 4 valid rounds | Next move is random; no prediction message |
| Five Rocks | Round 6 predicts Rock and plays Paper |
| Rock, Rock, Rock, Paper, Scissors | Round 6 predicts Rock and plays Paper |
| Three Rocks and three Papers | Round 7 is random because the lead is tied |
| Two of each move | Round 7 is random because all counts tie |
| `9`, then `1` | Invalid choice is retried; only Rock adds a round |
| `4` | Final score appears; no new round is added |

Try each of the three possible predicted leaders: five Rocks should cause Paper, five Papers should cause Scissors, and five Scissors should cause Rock. A count displayed after a round includes that round; the prediction printed at its start uses only previous rounds.

## Experiments

Use the [experiment worksheet](teaching-materials/experiments.md) to record results.

1. **Predictable player:** Play Rock at least six times. When does the bot first choose Paper on purpose? Could you beat it by changing moves?
2. **Strategy switch:** Play Rock six times, then Scissors until the prediction changes. Count how many Scissors it takes. What does the old Rock history do?
3. **Pattern player:** Repeat Rock, Paper, Scissors in order for at least nine rounds. At which points do counts tie? Can a frequency-only bot recognize the sequence?

For an extra game challenge, try to finish ten rounds with more wins than the bot. Write down the move you used to break its prediction. This is a way to explore the algorithm, not another required feature to code.

| Strategy | When was a prediction shown? | Computer move | What happened? |
| --- | --- | --- | --- |
| Repeated Rock | | | |
| Rock then Scissors | | | |
| R, P, S pattern | | | |

## Optional challenge: sliding window prediction

Consider only the last five moves instead of every move ever played. After six Rocks followed by five Scissors, the original bot still sees Rock 6, Scissors 5 and predicts Rock. A five-move window sees five Scissors and predicts Scissors. You do not need to implement this for the project. Markov chains and sequence prediction are possible further reading after you finish.

## Reflection and submission

Answer each question in a few sentences: Why are early moves random? When can frequency counting fail? Why can old data become less useful? What change could improve the bot? Does it actually understand or know your next move?

Before submitting, check that you have:

- [ ] Completed both TODOs in `starter-code/RockPaperScissorsBot.java`.
- [ ] Compiled and run the starter program.
- [ ] Tested the cases in the table, including ties and invalid input.
- [ ] Recorded all three experiments on the worksheet.
- [ ] Answered the reflection questions.

The [Java reference](teaching-materials/java-reference.md) is available if you need a syntax reminder. The [references](resources/references.md) are optional except where marked recommended. The `solution/` and `instructor-guide.md` files contain answers, so use them after trying the tasks yourself.
