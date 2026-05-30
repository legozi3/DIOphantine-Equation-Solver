import java.util.Scanner;

public class PellSolver {
    public static void run(Scanner scanner) {
        System.out.println("\n=== Pell's Equation Solver (x^2 - ny^2 = 1) ===");
        System.out.print("Enter n: ");
        long n = scanner.nextLong();

        //checks if n is a perfect square
        long sqrtN = (long) Math.sqrt(n);
        if (sqrtN * sqrtN == n) {
            System.out.println("n = " + n + " is a perfect square. No positive integer solutions exist.");
            return;
        }
        long y = 1;
        while (true) {
            long val = 1 + n * y * y;
            long x = (long) Math.sqrt(val);
            if (x * x == val) {
                System.out.println("Fundamental solution:");
                System.out.println("  x = " + x + ", y = " + y);
                return;
            }
            y++;
        }
    }
}