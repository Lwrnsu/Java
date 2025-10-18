import java.util.*;

public class Main {

  public static void main(String[] args) {

    try {
      var inventory = new ArrayList<String>();
      Scanner scanner = new Scanner(System.in);

      System.out.print("How many names you wish to sort? ");
      int tempNum = scanner.nextInt();
      scanner.nextLine();
      String tempHolder;

      for (int i = 0; i < tempNum; i++) {
        System.out.printf("Name #%d: ", i + 1);
        tempHolder = scanner.nextLine();
        inventory.add(tempHolder);
      }

      Collections.sort(inventory);

      for (var i : inventory) {
        System.out.println(i);
      }
    } catch (Exception e) {
      System.out.println("Error boi!");
    }
  }
}
