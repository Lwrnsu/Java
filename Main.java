import java.util.Scanner;

public class Main {



  public static void main(String[] args) {
   
    Scanner scanner = new Scanner(System.in);
    Inventory inventory = new Inventory();

    Item item1 = new Item("Apples", 20);
    Item item2 = new Item("Bananas", 10);

    inventory.addItem(item1);
    inventory.addItem(item2);

    inventory.displayItem();

    scanner.close();
  }
}