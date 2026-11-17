# Experiment worksheet

Name: ____________________   Date: ____________________

Run your completed starter program for each experiment. Restart it between experiments so the counts begin at zero. Record what you actually see; random results can vary. The tables highlight key rounds; use the totals below them to tally **every** round with a prediction. In the "Guess right?" column, compare the bot's predicted move with your actual move. Write `N/A` when it chose randomly.

## 1. Predictable player

Choose Rock for at least six rounds. On which round does the bot first say it predicts Rock? What move does it play then?

| Round | Counts before (R, P, S) | Bot guess | My move | Guess right? | Bot move / result |
| ---: | --- | --- | --- | --- | --- |
| 1 | | | | | |
| 5 | | | | | |
| 6 | | | | | |

Correct guesses / predicted rounds: ______ / ______

Observation: ____________________________________________________________

## 2. Strategy switch

Play Rock six times. Then play Scissors until the bot predicts Scissors. Note any round where the highest counts tie.

| Scissors played | Counts before (R, P, S) | Bot guess | My move | Guess right? | Result |
| ---: | --- | --- | --- | --- | --- |
| 1 | | | | | |
| 6 | | | | | |
| 7 | | | | | |
| 8 | | | | | |

How many Scissors were needed before the bot changed its prediction? __________

Correct guesses / predicted rounds: ______ / ______

## 3. Pattern player

Repeat Rock, Paper, Scissors three times. At the start of which rounds are the counts tied? Does the bot recognize the order of the moves?

| Round | Counts before (R, P, S) | Bot guess | My move | Guess right? | Result |
| ---: | --- | --- | --- | --- | --- |
| 6 | | | | | |
| 7 | | | | | |
| 8 | | | | | |
| 9 | | | | | |

Correct guesses / predicted rounds: ______ / ______

Answer: _________________________________________________________________

## Compare predictions

A prediction is **accurate** when the guessed move matches what you actually play, even if the computer does not win. Count only rounds where the bot showed a prediction. Were the guesses more accurate in experiment 1 or 3? Why? ___________________________________________

Optional thought experiment: If the bot used only the last five moves, what would it predict after six Rocks followed by five Scissors? Original algorithm: __________  Five-move window: __________. Which reacts faster, and what information does it discard? ______________________________
