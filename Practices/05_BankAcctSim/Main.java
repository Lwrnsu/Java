import java.util.*;
public class Main {
  
  private int userBalance;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Main bankService = new Main();
    int bankStatus;
    int tempNum;

    try {  
     
      do {

      System.out.println("\n--- Bank ---");
      System.out.println("\nWhat service do you need?");
      System.out.println("\n1. Deposit");
      System.out.println("2. Withdraw");
      System.out.println("3. Check Balance");
      System.out.println("4. Exit.");
      System.out.print("\nEnter your choice: ");
      bankStatus = scanner.nextInt();
    
      switch (bankStatus) {
        case 1:
          System.out.print("\nInput desire amount to deposit: ");
          tempNum = scanner.nextInt();
          bankService.bankDeposit(tempNum);

          break;
        case 2:
          System.out.print("\nInput desire amount to withdraw: ");
          tempNum = scanner.nextInt();

          if (bankService.checkBalance() > tempNum) {
            bankService.bankWithdraw(tempNum);
          } else {
            System.out.println("\nInsufficient Balance. Please try again!");
          }
          break;
        case 3:
          System.out.printf("\nYour balance is: $%d", bankService.checkBalance());
          break;
        case 4:
          System.out.println("\nThank you! Have a great day!");
          break;
        default: 
          System.out.println("\nYou did not enter the numbers from 1-4. Please try again!");
          break;
        }
      } while (bankStatus != 4);
    } catch (InputMismatchException e) {
      System.out.println("\nInputted a string, not an integer!");
    }

  }

  public int checkBalance() {
    return userBalance;
  }

  public int bankDeposit(int pending) {
    userBalance += pending;
    return userBalance;
  }

  public int bankWithdraw(int pending) {
    userBalance -= pending;
    return userBalance;
  }

}
