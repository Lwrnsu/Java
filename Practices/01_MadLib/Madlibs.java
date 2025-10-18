import java.util.Scanner;

public class Madlibs {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Input Adjective: ");
    String adjective_1 = scanner.nextLine();
    
    System.out.print("Input Adjective: ");
    String adjective_2 = scanner.nextLine();

    System.out.print("Input Type of Bird: ");
    String bird = scanner.nextLine();

    System.out.print("Input Room in a House: ");
    String roomHouse = scanner.nextLine();

    System.out.print("Input Verb(Past Tense): ");
    String verbPastTense = scanner.nextLine();

    System.out.print("Input Verb: ");
    String verb = scanner.nextLine();

    System.out.print("Input Relative's name: ");
    String relativeName = scanner.nextLine();

    System.out.print("Input Noun: ");
    String noun_1 = scanner.nextLine();

    System.out.print("Input a Liquid: ");
    String liquid = scanner.nextLine();

    System.out.print("Input a verb(ending in -ing): ");
    String verbIng_1 = scanner.nextLine();

    System.out.print("Input a part of the body (plural): ");
    String bodyPart = scanner.nextLine();

    System.out.print("Input a Plural Noun: ");
    String pluralNoun = scanner.nextLine();

    System.out.print("Input a verb(ending in -ing): ");
    String verbIng_2 = scanner.nextLine();

    System.out.print("Input a Noun: ");
    String noun_2 = scanner.nextLine();

    scanner.close();

    System.out.println("It was a " + adjective_1 + ", cold November day, I woke up to the " + adjective_2 + " smell of " + bird + " roasting in the " + roomHouse + " downstairs. I " + verbPastTense + " down the stairs to see if I could help " + verb + " the dinner. My mom said, \"See if " + relativeName + " needs a fresh " + noun_1 + ".\" So I carried a tray of glasses full of " + liquid + " into the " + verbIng_1 + " room. When I got there, I couldn't believe my " + bodyPart + "! There were " + pluralNoun + ' ' + verbIng_2 + " on the " + noun_2 + '!');



  }

}