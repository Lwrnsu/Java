import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) {

    File libraryDatabase = new File ("libraryDatabase.txt");
    Scanner scanner = new Scanner(System.in);
    int consoleStatus;

    try {

      do {

        System.out.println("\n--- Library Management System ---");
        System.out.println("\nHow may we help you?");
        System.out.println("\n1.Add book.");
        System.out.println("2. Remove Book.");
        System.out.println("3. Book details.");
        System.out.println("4. Update book details.");
        System.out.println("5. Borrow a book.");
        System.out.println("6. Exit.");
        consoleStatus = scanner.nextInt();

        switch (consoleStatus) {
          case 1: 
            
            break;
          case 2:

            break;
          case 3: 

            break;
          case 4: 

            break;
          case 5: 

            break;
          case 6:

            break;
          default:

            break;
        }


      } while (consoleStatus != 6);

    } catch (InputMismatchException e) {
      System.out.println("\nWrong Input! Please try again.");
    }

  }

}

class LibraryServices {

  Scanner scanner = new Scanner(System.in);

  public void addBook() {

    try {
      
      String tempBookName;
      String tempAuthor;
      int tempBookPublished;
      String confirmationStatus;

      System.out.print("\nBook Name: ");
      tempBookName = scanner.nextLine();
      System.out.print("Author: ");
      tempAuthor = scanner.nextLine();
      System.out.print("Date of Publication: ");
      tempBookPublished = scanner.nextInt();
      
      System.out.println("\nConfirmation. ");
      System.out.printf("Book Name: %s\n", tempBookName);
      System.out.printf("Book Author: %s\n", tempAuthor);
      System.out.printf("Date of Publication: %d\n", tempBookPublished);

      do {
        System.out.println("Options = \"Y\" [Confirm] || \"U\" [Update] || \"N\" [Delete]");
        System.out.print("Option: ");
        confirmationStatus = scanner.nextLine().toUpperCase();

        switch (confirmationStatus) {
          case "Y":
            addBook(tempBookName, tempAuthor, tempBookPublished);

            break;
          case "U":
            int updateStatus;
            do {

              System.out.println("\nSelect what to update: ");
              System.out.println("\n1. Book Name.");
              System.out.println("2. Book Author.");
              System.out.println("3. Date of Publication.");
              System.out.println("4. Confirm");
              updateStatus = scanner.nextInt();

              switch (updateStatus) {
                  case 1: 
                    System.out.print("\nNew Book Name: ");
                    tempBookName = scanner.nextLine();
                    break;
                  case 2:
                    System.out.print("\nNew Author: ");
                    tempAuthor = scanner.nextLine();
                    break;
                  case 3: 
                    System.out.print("\nNew Date of Publication: ");
                    tempBookPublished = scanner.nextInt();
                  case 4: 
                    break;
                  default:
                    System.out.println("\nInvalid Input. Please try again!");
                    break;
              }
            } while (updateStatus != 4);

            break;
          case "N":
            break;
          default: 
            break;
        } 
      } while (!confirmationStatus.equals("N"));

   
    } catch (Exception e) {
     
    }
    

  }

  private void addPendingBook(String tempBookName, String tempAuthor, int tempBookPublished) {
    
    try ( BufferedWriter appendBook = new BufferedWriter(new FileWriter("libraryDatabase.txt", true));) {
      appendBook.write("Book Name: ");
      appendBook.write(tempBookName);
      appendBook.write("Author: ");
      appendBook.write(tempAuthor);
      appendBook.write("Date of Publication: ");
      appendBook.write(tempBookPublished);
      appendBook.newLine();
    } catch (IOException e) {
      System.out.println("\nFile Error: Failed to Append");
    }

  }

}