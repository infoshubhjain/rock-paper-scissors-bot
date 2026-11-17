import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsBot {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final int MIN_HISTORY = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // Index 0 is Rock, 1 is Paper, and 2 is Scissors.
        int[] counts = new int[3];
        // Only valid, completed rounds count toward the prediction threshold.
        int roundsPlayed = 0;
        // Keep the three possible outcomes separately.
        int playerScore = 0;
        int computerScore = 0;
        int ties = 0;

        System.out.println("================================");
        System.out.println("     CAN YOU OUTSMART THE BOT?");
        System.out.println("================================");

        while (true) {
            // Choose from completed history before reading this round's choice.
            int predictedMove = findMostFrequentMove(counts, roundsPlayed);
            int computerMove;
            if (predictedMove == -1) {
                computerMove = random.nextInt(3);
            } else {
                computerMove = getCounterMove(predictedMove);
            }

            int playerMove = getPlayerMove(scanner);
            if (playerMove == -1) {
                break;
            }

            if (predictedMove == -1) {
                if (roundsPlayed < MIN_HISTORY) {
                    System.out.println("\nFewer than five rounds played. I chose randomly.");
                } else {
                    System.out.println("\nThe highest move counts are tied. I chose randomly.");
                }
            } else {
                System.out.println("\nI think you're going to choose " + MOVES[predictedMove] + "...");
            }

            System.out.println("\nYou chose: " + MOVES[playerMove]);
            System.out.println("Computer chose: " + MOVES[computerMove]);

            int result = determineWinner(playerMove, computerMove);
            if (result == 0) {
                System.out.println("\nIt's a tie!");
                ties++;
            } else if (result == 1) {
                System.out.println("\nYou win!");
                playerScore++;
            } else {
                System.out.println("\nThe computer wins!");
                computerScore++;
            }

            counts[playerMove]++;
            roundsPlayed++;
            displayStatistics(counts);
            System.out.println("\nScore:");
            System.out.println("Player: " + playerScore);
            System.out.println("Computer: " + computerScore);
            System.out.println("Ties: " + ties);
            System.out.println("\n-------------------------------");
        }

        System.out.println("\n========== FINAL SCORE ==========");
        System.out.println("Player: " + playerScore);
        System.out.println("Computer: " + computerScore);
        System.out.println("Ties: " + ties);
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // Read one menu choice; invalid input is retried without playing a round.
    private static int getPlayerMove(Scanner scanner) {
        while (true) {
            System.out.println("\nChoose your move:");
            System.out.println("1. Rock\n2. Paper\n3. Scissors\n4. Quit");
            System.out.print("Your choice: ");
            if (!scanner.hasNextLine()) return -1;
            String input = scanner.nextLine().trim();
            if (input.equals("4")) return -1;
            if (input.equals("1")) return 0;
            if (input.equals("2")) return 1;
            if (input.equals("3")) return 2;
            System.out.println("Invalid choice. Please try again.");
        }
    }

    // Return the only leading move, or -1 when no unique prediction is available.
    static int findMostFrequentMove(int[] counts, int roundsPlayed) {
        if (roundsPlayed < MIN_HISTORY) return -1;
        int best = 0; // Index of the largest count seen so far.
        boolean tied = false; // A later larger count clears an earlier tie.
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > counts[best]) {
                best = i;
                tied = false;
            } else if (counts[i] == counts[best]) {
                tied = true;
            }
        }
        return tied ? -1 : best;
    }

    // Move numbers cycle Rock -> Paper -> Scissors -> Rock.
    static int getCounterMove(int predictedMove) {
        return (predictedMove + 1) % 3;
    }

    // 0 means tie, 1 means player wins, and 2 means computer wins.
    private static int determineWinner(int playerMove, int computerMove) {
        if (playerMove == computerMove) return 0;
        return (playerMove + 1) % 3 == computerMove ? 2 : 1;
    }

    // Show the updated counts after the round is complete.
    private static void displayStatistics(int[] counts) {
        System.out.println("\nCurrent statistics:");
        for (int i = 0; i < MOVES.length; i++) {
            System.out.println(MOVES[i] + ": " + counts[i]);
        }
    }
}
