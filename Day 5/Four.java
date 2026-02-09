/*
    January 31, 2026
    Task: Day 5 - OOP I
*/

import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    private String student_name;
    private int age;
    private float grade;

    public Student(String student_name, int age, float grade) {
        if (student_name == null || student_name.isEmpty()) {
            throw new IllegalArgumentException("Wrong Input!");
        } else if (age > 100 || age < 0) {
            throw new IllegalArgumentException("Wrong Input!");
        } else if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Wrong Input!");
        }

        this.student_name = student_name;
        this.age = age;
        this.grade = grade;
    }

    public String student_summary() {
        return "Name: " + student_name + "\nAge: " + age + "\nGrade: " + grade;
    }
}

class Four {

    public static void main(String[] args) {
        Student data = null;
        Scanner scan = new Scanner(System.in);
        boolean program_status = true;
        
        System.out.println("--------------------------------------------------");
        System.out.println("STUDENT DATABASE (TOTAL OF 10 STUDENTS ONLY)");
        System.out.println("--------------------------------------------------");

        while (program_status) {
            try {
                System.out.println("Services:");
                System.out.println("1. Add Student.");
                System.out.println("2. View Students.");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int user_input = scan.nextInt();
                scan.nextLine();

                switch (user_input) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String student_name = scan.nextLine().trim();

                        System.out.print("Enter student age: ");
                        int student_age = scan.nextInt();

                        System.out.print("Enter student grade: ");
                        float student_grade = scan.nextFloat();

                        data = new Student(student_name, student_age, student_grade);
                        break;
                    case 2:
                        System.out.println(data.student_summary());
                        break;
                    case 3:
                        program_status = false;
                        break;
                    default:
                        System.out.println("Invalid Input!");
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid Input!");
                scan.nextLine();
            } catch (NullPointerException e) {
                System.out.println("No Object Found!");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong Input!");
                scan.nextLine();
            }
        }
    }
}