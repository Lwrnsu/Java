import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) {

    File libraryDatabase = new File ("libraryDatabase.txt");
    LibraryServices libraryService = new LibraryServices();
    Scanner scanner = new Scanner(System.in);
    int consoleStatus;

    try {

      do {

        System.out.println("\n--- Library Management System ---");
        System.out.println("\nHow may we help you?");
        System.out.println("\n1. Add book.");
        System.out.println("2. Remove Book.");
        System.out.println("3. Book details.");
        System.out.println("4. Update book details.");
        System.out.println("5. Borrow a book.");
        System.out.println("6. Exit.");
        System.out.print("\nEnter your choice: ");
        consoleStatus = scanner.nextInt();

        switch (consoleStatus) {
          case 1: 
            libraryService.addBook();
            break;
          case 2:
            libraryService.removeBook();
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
  HashMap<String, OtherInfo> dataArray = new HashMap<>();

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
      scanner.nextLine();
      
      do {

        System.out.println("\nConfirmation. ");
        System.out.printf("Book Name: %s\n", tempBookName);
        System.out.printf("Book Author: %s\n", tempAuthor);
        System.out.printf("Date of Publication: %d\n", tempBookPublished);
        System.out.println("Options = \"Y\" [Confirm] || \"U\" [Update] || \"N\" [Delete]");
        System.out.print("Option: ");
        confirmationStatus = scanner.nextLine().toUpperCase();

        switch (confirmationStatus) {
          case "Y":
            addPendingBook(tempBookName, tempAuthor, tempBookPublished);
            break;
          case "U":
            int updateStatus;
            do {
        
              System.out.println("\nSelect what to update: ");
              System.out.println("\n1. Book Name.");
              System.out.println("2. Book Author.");
              System.out.println("3. Date of Publication.");
              System.out.println("4. Confirm");
              System.out.print("\nEnter your choice: ");
              updateStatus = scanner.nextInt();
              scanner.nextLine();

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
                    System.out.println("Confirmed!");
                    break;
                  default:
                    System.out.println("\nInvalid Input. Please try again!");
                    break;
              }
            } while (updateStatus != 4);

            break;
          case "N":
            System.out.println("\nProcess removed.");
            break;
          default: 
            System.out.println("\nInvalid Input. Try again!");
            break;
        } 
      } while (!confirmationStatus.equals("Y") && !confirmationStatus.equals("N"));
    } catch (InputMismatchException e) {
      System.out.println("\nInvalid Input. Please try again!");
    }
  }

  private void addPendingBook(String tempBookName, String tempAuthor, int tempBookPublished) {

    try (BufferedWriter appendBook = new BufferedWriter(new FileWriter("libraryDatabase.txt"))) {

      dataArray.put(tempBookName, new OtherInfo(tempAuthor, tempBookPublished));
      for(Map.Entry<String, OtherInfo> i : dataArray.entrySet()) {
        String key = i.getKey();
        OtherInfo values = i.getValue();

        appendBook.write("Book Name: " + key + ", Author: " + values.tempAuthor + ", Date of Publication: " + values.tempBookPublished);
        appendBook.newLine();
      }

    } catch (IOException e) {
      System.out.println("\nFile Error: Failed to Append");
    }
  }

  public void removeBook() {

    try (BufferedReader readStorage = new BufferedReader(new FileReader("libraryDatabase.txt"))) {
      
      if (!dataArray.isEmpty()) {

        String line;
        while( (line = readStorage.readLine()) != null) {
          int tempNum = 1;
          System.out.printf("%d. %s", tempNum, line);
          tempNum++;
        }
        
        String tempRemove;

        do {
          System.out.print("\nWrite the name of the book you want to remove [Q to return]:  ");
          tempRemove = scanner.nextLine();

          if (dataArray.containsKey(tempRemove)) {
            String removeStatus;

            System.out.println("\nDo you wish to remove the following book?");
            System.out.printf("\nBook Name: %s\nAuthor: %s\nDate of Publication: %d\n", tempRemove, dataArray.get(tempRemove).tempAuthor, dataArray.get(tempRemove).tempBookPublished);
            System.out.print("Enter your choice [Y/N]: ");
            removeStatus = scanner.nextLine().toUpperCase();

            if (removeStatus.equals("Y")) {
              dataArray.remove(tempRemove);
            } else {
              System.out.println("\nProcess cancelled.");
            }

          } else if (tempRemove.equals("Q") || tempRemove.equals("q")) {
            System.out.println("\nReturned.");
          } else {
            System.out.println( "\nInvalid Book Name. Please try again!");
          }

        } while (!tempRemove.equals("Q") && !tempRemove.equals("q") && !dataArray.containsKey(tempRemove));

      } else {
        System.out.println("There is no book, please add a book to continue.");
      }
    } catch (IOException e) {
      System.out.println("\nFile Error: Reading Process Failed.");
    }
 }
}

class OtherInfo {

  String tempAuthor;
  int tempBookPublished;

  public OtherInfo(String tempAuthor, int tempBookPublished) {
    this.tempAuthor = tempAuthor;
    this.tempBookPublished = tempBookPublished;
  }
}
