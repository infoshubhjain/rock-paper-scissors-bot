# Prediction algorithm walkthrough

Open this when TODO 2 feels unclear. The method receives `counts` and `roundsPlayed`. It returns a move index (0, 1, or 2) only when one move has the highest count after at least five completed rounds. It returns `-1` otherwise. `main` handles the random fallback.

## Worked example

Previous moves: Rock, Rock, Paper, Rock, Scissors.

```text
Array index:       0       1        2
Move:            Rock    Paper   Scissors
Counts:            3       1        1
```

There are five completed rounds. Scan the array to find the highest count:

| Step | Count seen | Best index | Tied? | Reason |
|---|---:|---:|---|---|
| Start at index 0 | 3 | 0 | No | First value is the best so far |
| Inspect index 1 | 1 | 0 | No | 1 is below 3 |
| Inspect index 2 | 1 | 0 | No | 1 is below 3 |

Return 0, which means Rock. The counter move is Paper. The current player's choice has not been added yet.

## Pseudocode

```text
if roundsPlayed < 5: return -1
bestIndex = 0
tied = false
for index from 1 through 2:
    if counts[index] > counts[bestIndex]:
        bestIndex = index
        tied = false
    else if counts[index] == counts[bestIndex]:
        tied = true
if tied: return -1
return bestIndex
```

The `tied = false` after a larger value matters. For `[2, 2, 3]`, indices 0 and 1 tie briefly, then index 2 wins uniquely. For `[3, 3, 1]`, the highest count stays tied. For `[2, 2, 2]`, all three tie. The five-round check comes first, so `[4, 0, 0]` still returns `-1` when only four rounds have finished.

## Debugging checklist

- Are you returning an **index**, rather than the count itself?
- Are you checking the **highest** count for a tie? A tie among lower counts does not matter.
- Does a new higher count clear an earlier tie?
- Is the current move added only after the computer chooses?
- Did you increment the count once per valid round, with no increment for invalid input or Quit?

To trace a bug, write the counts after each completed round. Immediately before round six, five numbers should have been added across the three entries in total.
