// Run after TODO 2. This checks your predictor without playing many rounds.
public class StudentCheck {
    public static void main(String[] args) {
        check(new int[]{4, 0, 0}, 4, -1, "fewer than five rounds");
        check(new int[]{5, 0, 0}, 5, 0, "Rock leads");
        check(new int[]{0, 5, 0}, 5, 1, "Paper leads");
        check(new int[]{0, 0, 5}, 5, 2, "Scissors leads");
        check(new int[]{3, 1, 1}, 5, 0, "lower counts tie");
        check(new int[]{3, 3, 0}, 6, -1, "two highest counts tie");
        check(new int[]{2, 2, 2}, 6, -1, "all counts tie");
        check(new int[]{2, 2, 3}, 7, 2, "later count breaks a tie");
        System.out.println("All prediction checks passed.");
    }

    private static void check(int[] counts, int rounds, int expected, String caseName) {
        int actual = RockPaperScissorsBot.findMostFrequentMove(counts, rounds);
        if (actual != expected) {
            throw new AssertionError(caseName + ": expected " + moveName(expected)
                + ", got " + moveName(actual));
        }
    }

    private static String moveName(int move) {
        if (move == -1) return "no prediction";
        String[] names = {"Rock", "Paper", "Scissors"};
        if (move < 0 || move >= names.length) return "invalid move " + move;
        return names[move];
    }
}
