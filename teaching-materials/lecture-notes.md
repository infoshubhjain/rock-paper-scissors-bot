# Opening lecture (10 to 15 minutes)

**Goal:** Students can explain what the bot knows before each round and why a guess may fail. Do not show the solution code yet.

## 0 to 3 minutes: What can a program predict?

Ask: "If I always play Rock, what would you play next time?" A predictive algorithm uses earlier observations to make a guess about a future event. It does not read the player's mind. Our rule is to guess the most common earlier move and play the counter.

## 3 to 6 minutes: Count with an array

Write `int[] counts = new int[3];` on the board. Label its positions 0 Rock, 1 Paper, 2 Scissors. Each valid round adds one to exactly one position. Ask students to update `[0, 0, 0]` after Rock, Rock, Paper, Rock, Scissors. Answer: `[3, 1, 1]`.

A frequency is simply the number of times an event was observed. The largest count here is 3. Rock is the only move with that count.

## 6 to 10 minutes: Decide before seeing the current move

After the five moves above, the bot guesses Rock and plays Paper. Walk through the order: inspect **previous** counts, pick computer move, read the player's current choice, decide the winner, then add the player's choice. Ask: "What goes wrong if we add the current move before guessing?" The bot would use information from the same round it claims to predict.

If fewer than five rounds are complete, or the highest counts tie, the bot picks randomly. Five is an instructional threshold, not a statistical guarantee. Ask whether `[3, 3, 0]` has a unique leader (no) and whether `[3, 1, 1]` does (yes).

## 10 to 15 minutes: Limits and handoff

Ask: "What if the player switches from Rock to Scissors?" Old Rocks keep their lead until enough Scissors accumulate. Ask: "What if the player cycles Rock, Paper, Scissors?" Counts often tie, though the sequence is predictable to a person. Students will implement the count update and the unique leader check, then test these limits in the worksheet.
