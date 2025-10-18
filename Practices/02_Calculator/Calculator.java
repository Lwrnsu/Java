import java.util.Scanner;

public class Calculator {

  public static void main(String[] args) {

    String status = "Y";
    int firstNumber;
    char operator;
    int secondNumber;
    int result;
    Scanner scanner = new Scanner(System.in);

    System.out.println("\n--- Calculator ---");

    while (!status.equals("N")) {

      System.out.print("\nCalculate? [Y/N]: ");
      status = scanner.nextLine().toUpperCase();

      if (status.equals("Y")) {

        System.out.print("First Number: ");
        firstNumber = scanner.nextInt();

        do {
          System.out.print("Operator [+, -, *, /]: ");
          operator = scanner.next().charAt(0);
        } while (operator != '+' && operator != '-' && operator != '*' && operator != '/');

        System.out.print("Second Number: ");
        secondNumber = scanner.nextInt(); 
        
        switch (operator) {
             case '+':
                result = add(firstNumber, secondNumber);
                System.out.printf("Result: %d", result);
              break;
             case '-': 
                result = sub(firstNumber, secondNumber);
                System.out.printf("Result: %d", result);
              break;
             case '*':
                result = mul(firstNumber, secondNumber);
                System.out.printf("Result: %d", result);
              break;
             case '/':
                result = div(firstNumber, secondNumber);
                System.out.printf("Result: %d", result);
              break;
        }
      }
    }
    scanner.close();
  }

  static int add(int firstNumber, int secondNumber) {
    return firstNumber + secondNumber;
  }

  static int sub(int firstNumber, int secondNumber) {
    return firstNumber - secondNumber;
  }

  static int mul(int firstNumber, int secondNumber) {
    return firstNumber - secondNumber;
  }

  static int div(int firstNumber, int secondNumber) {
    return firstNumber - secondNumber;
  }
}