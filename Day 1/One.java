//January 27, 2026.

import java.util.Scanner;

public class One {

    public static String sentence(String name, int age) {
        String sentence = "Hello " + name + ", you will be " + age + " next year.";
        return sentence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = scanner.nextLine();
        System.out.print("What is  your age? ");
        int age = scanner.nextInt();
        System.out.print(sentence(name, age));
    }

}
