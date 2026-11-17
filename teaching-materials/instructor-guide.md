# Instructor guide (contains answers)

This file is for course staff. Students should start with the root README and the starter code. Share the solution after they have attempted the two TODOs.

## Audience and goals

Intended for beginning university CS students who know variables, loops, methods, and basic arrays. No AI, statistics, or testing framework background is required. Students should leave able to maintain counts in an array, identify a unique maximum, explain the random fallback, and distinguish prediction from certainty.

Expected total time: up to two hours. Suggested schedule: 10 minutes setup, 15 minute lecture, 15 minutes starter walkthrough, 35 minutes coding, 20 minutes testing, 15 minutes experiments, 10 minutes reflection and submission.

## What the starter already provides

`main` runs the game, chooses a computer move from completed history **before** reading the player's current choice, tracks scores, and prints counts. It explains whether a random move came from insufficient history or from having no unique prediction. `getPlayerMove` validates the menu input. `getCounterMove` and `determineWinner` handle game rules. Only the count update and unique maximum method are missing. The starter compiles and plays as a random bot before students edit it, but its displayed counts stay zero.

## Expected TODO solutions

TODO 1 is `counts[playerMove]++;` after the winner is calculated and before statistics display. There should be one increment per valid round.

For TODO 2, first return `-1` when `roundsPlayed < MIN_HISTORY`. Set `best = 0` and `tied = false`. Scan indices 1 and 2. A strictly larger count updates `best` and clears `tied`. An equal count sets `tied` to true. At the end, return `-1` if tied, otherwise `best`. See `solution/RockPaperScissorsBot.java` for the complete code. The method does not call `Random`; `main` handles the fallback.

Students can run `StudentCheck.java` from `starter-code` after TODO 2. Its failure message identifies the relevant threshold, leader, or tie case. The one-Rock checkpoint in the README checks TODO 1 separately.

## Hints in increasing detail

1. Ask students what `counts[playerMove]` points to when the menu choice was 3. The method converts that choice to index 2.
2. For the predictor, ask them to write the result for `[3, 1, 1]`, `[3, 3, 0]`, and `[2, 2, 3]` before coding.
3. Suggest keeping two variables, one for the current best index and one for whether the best is tied.
4. Trace `[2, 2, 3]` to show why a later higher count must clear an earlier tie.

Common mistakes: comparing a count to an index, treating lower-count ties as ambiguous, updating history before the prediction, incrementing counts on invalid input, expecting a fixed random result, and testing a six-round case without restarting between experiments.

## Expected experiment observations

- Five previous Rocks cause the first deliberate Paper on round six. Earlier Paper moves, if any, are random coincidences.
- After six Rocks, Scissors catches Rock after six new Scissors, giving a tie. After the seventh Scissors, Scissors leads. The prediction changes on the **next** round, the eighth Scissors round.
- In a Rock, Paper, Scissors cycle, counts tie after each complete cycle. The bot ignores order, so it cannot exploit the cycle as a sequence.

Accuracy means the predicted move equals the player's actual move. It is different from a win, since a random move can win and a deliberate counter can lose after a strategy switch.

Optional extensions: count only the last five moves, compare prediction accuracy against a random bot, or look for short repeated sequences. Keep these outside the required two-hour work.
