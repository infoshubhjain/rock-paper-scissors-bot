# Java pocket reference for this project

| Idea | Small example | Meaning here |
| --- | --- | --- |
| Integer variable | `int rounds = 0;` | Holds a whole-number round count |
| Array | `int[] counts = new int[3];` | Creates three integer counts, initially zero |
| Array index | `counts[0]` | Reads the Rock count; indices start at zero |
| Increment | `counts[0]++;` | Adds one to the Rock count |
| For loop | `for (int i = 0; i < 3; i++) { ... }` | Visits indices 0, 1, and 2 |
| If / else | `if (rounds < 5) { ... } else { ... }` | Chooses a path based on a condition |
| Method | `static int next(int move) { return move; }` | Names reusable code and returns an integer |
| Parameter | `move` in `next(int move)` | The value passed to the method |
| Return value | `return -1;` | Sends a result back to the caller |
| Random | `random.nextInt(3)` | Gives 0, 1, or 2; create `Random random = new Random();` first |
| Modulo | `(move + 1) % 3` | Gives the remainder after division by 3, wrapping 2 back to 0 |

In Java, `==` compares integer values. `=` assigns a value. `>` means greater than. The method `findMostFrequentMove` returns `-1` as a signal that no unique prediction is available; `-1` is not an array index.

For example, Scissors is move 2. The move that beats it is `(2 + 1) % 3`, which is `3 % 3 = 0`: Rock. The `%` operator gives the remainder after division, so it wraps the move numbers back to zero. Rock similarly becomes Paper because `(0 + 1) % 3 = 1`.
