/*

    February 1, 2026
    Day 6 of Java - OOP Advanced I
    Lesson tackled: Inheritance, Composition, Interface, Abstract, and Dependency Injection.

    Task:
    1. You're designing a Payment System:
    2. There are different payment methods: Cash, GCash, CreditCard.
    3. All payment methods can process payment (interface rule).
    4. Some methods share common behavior, like validating amount (abstract class).
    5. PaymentProcessor uses dependency injection to receive any payment method.
    Bonus: Add a User class that has a payment method (composition).

    Design: User -> What type of payment? -> PaymentProcessor -> PaymentProcessor(Type of Payment) -> 
    Validate(Payment) -> Payment

*/

// Imports
import java.util.InputMismatchException;
import java.util.Scanner;

// Classes

interface Payment {
    void pay(double amount);
}

abstract class Validate {
    public void validate(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}

class CreditCardPayment extends Validate implements Payment{
    public void pay(double amount) {
        validate(amount);
        System.out.println("Paying via Cash: " + amount);
    }
}

class GCashPayment extends Validate implements Payment{
    public void pay(double amount) {
        validate(amount);
        System.out.println("Paying via GCash: " + amount);
    }
}

class CashPayment extends Validate implements Payment{
    public void pay(double amount) {
        validate(amount);
        System.out.println("Paying via Credit Card: " + amount);
    }
}

class PaymentProcessor{
    Payment payment;
    public PaymentProcessor(Payment payment) {
        this.payment = payment;
    }

    public void process(double amount) {
        payment.pay(amount);
    }
}

class User {
    private PaymentProcessor payment_processor;
    private double amount;

    public User(double amount, PaymentProcessor payment_processor) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        
        this.payment_processor = payment_processor;
        this.amount = amount;
    }
    
    public void process() {
        payment_processor.process(amount);
    }
}

public class Five { 

    public static double get_amount(Scanner scan) {
        while (true) {
            try {
                System.out.print("Enter amount: ");
                double amount = scan.nextInt();
                if (amount <= 0) {
                    throw new IllegalArgumentException();
                }
                return amount;
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid amount.");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter number above 0.");
            }
        }
    }

    public static void service_pay(Scanner scan) {

        boolean service_pay_status = true;
        Payment payment;
        PaymentProcessor processor;
        User user;

        while (service_pay_status) {
            try {
                System.out.println("What type of payment? ");
                System.out.println("1. Cash");
                System.out.println("2. GCash");
                System.out.println("3. Credit Card");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                int payment_type = scan.nextInt();


                if (payment_type > 4 || payment_type < 1) {
                    throw new IllegalArgumentException();
                }

                switch (payment_type) {
                    case 1:
                        payment = new CashPayment();
                        processor = new PaymentProcessor(payment);
                        user = new User(get_amount(scan), processor);
                        user.process();
                        break;
                    case 2:
                        payment = new GCashPayment();
                        processor = new PaymentProcessor(payment);
                        user = new User(get_amount(scan), processor);
                        user.process();
                        break;
                    case 3:
                        payment = new CreditCardPayment();
                        processor = new PaymentProcessor(payment);
                        user = new User(get_amount(scan), processor);
                        user.process();
                        break;
                    case 4:
                        System.out.println("Exited.");
                        service_pay_status = false;
                        break;
                    default:
                        System.out.println("Invalid Input! Please try again.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println(e + ": Invalid Input! Please input [1 - 4].");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e + ": Invalid input! Please input [1 - 4].");
            }
        }
    }

    public static void main(String[] args) {

        // Objects & Variables
        Scanner scan = new Scanner(System.in);
        boolean program_status = true;

        while (program_status) {
            try {
                
                System.out.println("---------- PAYMENT PROCESSOR ----------");
                System.out.println("Services: ");
                System.out.println("1. Pay.");
                System.out.println("2. Last payment transaction.");
                System.out.println("3. Exit");
                System.out.print("Enter Choice: ");
                int user_input = scan.nextInt();

                switch (user_input) {
                    case 1:
                        service_pay(scan);
                        break;
                    case 2:
                        System.out.println("2");
                        break;
                    case 3:
                        System.out.println("Exited.");
                        program_status = false;
                        break;
                    default:
                        System.out.println("Invalid Input! Please Try Again.");
                        break;
                }
                

            } catch (InputMismatchException e) {
                System.out.println("Please input number [1 - 3].");
                scan.nextLine();
            }
        }
    }
}
