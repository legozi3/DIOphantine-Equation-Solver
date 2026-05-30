import java.util.Scanner;

public class LinearSolver {
    public static void run(Scanner scanner) {
        System.out.println("\n=== Linear Diophantine Solver (ax + by = c) ===");
        System.out.print("Enter a: ");
        long a = scanner.nextLong();
        System.out.print("Enter b: ");
        long b = scanner.nextLong();
        System.out.print("Enter c: ");
        long c = scanner.nextLong();

        long gcd = gcd(Math.abs(a), Math.abs(b));

        if (c % gcd != 0) {
            System.out.println("No solutions exist. gcd(" + a + ", " + b + ") = " + gcd + " does not divide " + c);
            return;
        }

        long[] ext = extendedGCD(Math.abs(a), Math.abs(b));
        long x0 = ext[1] * (c / gcd);
        long y0 = ext[2] * (c / gcd);

        //adjust signs if a or b were negative
        if (a < 0) x0 = -x0;
        if (b < 0) y0 = -y0;

        long kCoX = b / gcd;
        long kCoY = a / gcd;

        System.out.println("\nSolutions exist! gcd = " + gcd);
        System.out.println("Particular solution: x = " + x0 + ", y = " + y0);
        System.out.println("General solution:");
        System.out.println("  x = " + x0 + " + " + kCoX + "k");
        System.out.println("  y = " + y0 + " - " + kCoY + "k");
        System.out.println("where k is any integer.");
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    //returns [gcd, x, y] such that a*x + b*y = gcd
    private static long[] extendedGCD(long a, long b) {
        if (b == 0) return new long[]{a, 1, 0};
        long[] r = extendedGCD(b, a % b);
        return new long[]{r[0], r[2], r[1] - (a / b) * r[2]};
    }
}