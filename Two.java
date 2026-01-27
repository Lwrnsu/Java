//January 27, 2026

import java.util.Scanner;

public class Two {
    
    public static int sum(int[] numbers) {
        int total = 0;
        for(int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return total;
    }

    public static int average(int[] numbers) {
        int total = sum(numbers);
        int average = total / numbers.length;
        return average;
    }

    public static int max(int[] numbers) {
        int max = numbers[0];
        for(int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for(int i = 0; i < numbers.length; i++) {
            System.out.print("Enter an integer: ");
            numbers[i] = sc.nextInt();
        }
        System.out.println("Sum: " + sum(numbers));
        System.out.println("Average: " + average(numbers));
        System.out.println("Max:" + max(numbers));
    }
}
