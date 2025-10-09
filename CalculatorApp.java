import java.util.Scanner;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    double divide(int a, int b) {
        try {
            if (b == 0)
                throw new ArithmeticException("Cannot divide by zero!");
            return (double) a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}

public class CalculatorApp {
    Scanner sc = new Scanner(System.in);
    Calculator calc = new Calculator();

    void performAddition() {
        System.out.println("Choose addition type:");
        System.out.println("1. Two Integers");
        System.out.println("2. Two Doubles");
        System.out.println("3. Three Integers");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter two integers: ");
                int a = sc.nextInt(), b = sc.nextInt();
                System.out.println("Result: " + calc.add(a, b));
                break;
            case 2:
                System.out.print("Enter two doubles: ");
                double x = sc.nextDouble(), y = sc.nextDouble();
                System.out.println("Result: " + calc.add(x, y));
                break;
            case 3:
                System.out.print("Enter three integers: ");
                int p = sc.nextInt(), q = sc.nextInt(), r = sc.nextInt();
                System.out.println("Result: " + calc.add(p, q, r));
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    void performSubtraction() {
        System.out.print("Enter two integers: ");
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println("Result: " + calc.subtract(a, b));
    }

    void performMultiplication() {
        System.out.print("Enter two doubles: ");
        double a = sc.nextDouble(), b = sc.nextDouble();
        System.out.println("Result: " + calc.multiply(a, b));
    }

    void performDivision() {
        System.out.print("Enter two integers: ");
        int a = sc.nextInt(), b = sc.nextInt();
        double result = calc.divide(a, b);
        if (b != 0) {
            System.out.println("Result: " + result);
        }
    }

    void mainMenu() {
        while (true) {
            System.out.println("\n=== Calculator Application ===");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performSubtraction();
                    break;
                case 3:
                    performMultiplication();
                    break;
                case 4:
                    performDivision();
                    break;
                case 5:
                    System.out.println("Thank you for using the Calculator!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorApp().mainMenu();
    }
}
