// January 29, 2026
// the task is for day 4, because it there is no task in day 3.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Three {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        } else {
            return a / b;
        }
    }

    public static int get_number(Scanner scan) {
        System.out.print("Enter Number: ");
        int num = scan.nextInt();
        return num;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int user_input = 0;
        int a;
        int b;
        do {
            try {
                System.out.println("Calculator :/");
                System.out.println("Choose service: ");
                System.out.print(" 1. Add\n 2. Subtract \n 3. Multiply\n 4. Divide\n 5. Exit\n");
                System.out.print("Enter number: ");
                user_input = scan.nextInt();

                switch (user_input) {
                    case 1:
                        a = get_number(scan);
                        b = get_number(scan);
                        System.out.print(add(a, b));
                        break;
                    case 2:
                        a = get_number(scan);
                        b = get_number(scan);
                        System.out.print(subtract(a, b));
                        break;
                    case 3:
                        a = get_number(scan);
                        b = get_number(scan);
                        System.out.print(multiply(a, b));
                        break;
                    case 4:
                        a = get_number(scan);
                        b = get_number(scan);
                        System.out.print(divide(a, b));
                        break;
                    case 5:
                        System.out.print("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid!");
                        break;
            }
            } catch (InputMismatchException e) {
                System.out.print("Invalid Input.");
                scan.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("You cannot divide something with 0");
            }
        } while (user_input != 5);
    }
}
