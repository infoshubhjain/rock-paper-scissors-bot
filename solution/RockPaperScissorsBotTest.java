public class RockPaperScissorsBotTest {
    public static void main(String[] args) {
        check(new int[]{4, 0, 0}, 4, -1);
        check(new int[]{5, 0, 0}, 5, 0);
        check(new int[]{3, 1, 1}, 5, 0);
        check(new int[]{3, 3, 0}, 6, -1);
        check(new int[]{2, 2, 2}, 6, -1);
        check(new int[]{0, 5, 0}, 5, 1);
        check(new int[]{0, 0, 5}, 5, 2);
        for (int move = 0; move < 3; move++) {
            if (RockPaperScissorsBot.getCounterMove(move) != (move + 1) % 3) {
                throw new AssertionError("Wrong counter for " + move);
            }
        }
        System.out.println("All bot checks passed.");
    }

    private static void check(int[] counts, int rounds, int expected) {
        int actual = RockPaperScissorsBot.findMostFrequentMove(counts, rounds);
        if (actual != expected) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
    }
}
