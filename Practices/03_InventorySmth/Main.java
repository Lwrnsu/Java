import java.util.*;

public class Main {

  public static void main(String[] args) {
   
  try {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> myInteger = new ArrayList<Integer>();

    System.out.print("How many numbers to place? ");
    int statusNum = scanner.nextInt();

    int tempNum;

    for (int i = 0; i < statusNum; i++) {
      System.out.printf("Number #%d: ", i + 1);
      tempNum = scanner.nextInt();
      myInteger.add(tempNum);
    }

    for (Integer i : myInteger) {
      System.out.printf("%d\n", i);
    }
  } catch (Exception e) {
    System.out.println("Error guys");
    }
  }
}