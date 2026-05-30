import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Diophantine Equation Solver ===");
            System.out.println("1. Linear (ax + by = c)");
            System.out.println("2. Pythagorean (x^2 + y^2 = z^2)");
            System.out.println("3. Pell's Equation (x^2 - ny^2 = 1)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> LinearSolver.run(scanner);
                case 2 -> PythagoreanSolver.run(scanner);
                case 3 -> PellSolver.run(scanner);
                case 4 -> running = false;
                default -> System.out.println("Invalid option! (please enter 1-4)");
            }
        }

        scanner.close();
        System.out.println("( ﾟ◡ﾟ)/");
    }
}