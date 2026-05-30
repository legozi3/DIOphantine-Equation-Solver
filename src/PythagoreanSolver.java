import java.util.Scanner;

public class PythagoreanSolver {
    public static void run(Scanner scanner) {
        System.out.println("\n=== Pythagorean Diophantine Solver (x^2 + y^2 = z^2) ===");
        System.out.println("1. Find all triples up to a bound");
        System.out.println("2. Check if (x, y, z) is a Pythagorean triple");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter upper bound: ");
            int bound = scanner.nextInt();
            System.out.println("\nPythagorean triples with x, y up to " + bound + ":");
            boolean found = false;
            for (int x = 1; x <= bound; x++) {
                for (int y = x; y <= bound; y++) {
                    int sum = x * x + y * y;
                    int z = (int) Math.sqrt(sum);
                    if (z * z == sum) {
                        System.out.println("  (" + x + ", " + y + ", " + z + ")");
                        found = true;
                    }
                }
            }
            if (!found) System.out.println("No triples found.");

        } else if (choice == 2) {
            System.out.print("Enter x: ");
            long x = scanner.nextLong();
            System.out.print("Enter y: ");
            long y = scanner.nextLong();
            System.out.print("Enter z: ");
            long z = scanner.nextLong();

            if (x * x + y * y == z * z) {
                System.out.println("(" + x + ", " + y + ", " + z + ") IS a Pythagorean triple.");
            } else {
                System.out.println("(" + x + ", " + y + ", " + z + ") is NOT a Pythagorean triple.");
            }
        } else {
            System.out.println("Invalid option! (please enter 1-2)");
        }
    }
}