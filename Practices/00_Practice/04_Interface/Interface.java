public class Interface {
  
  public static void main(String[] args) {
      
    Male pMale = new Male();

    pMale.pGender();
    pMale.pName();
    pMale.pAge();

  }

}

interface Person {
  public void pGender();
  public void pName();
  public void pAge();
}

class Male implements Person {
  public void pGender() {
    System.out.println("Gender: Male");
  }
  public void pName() {
    System.out.println("Name: Lwrnsu");
  }
  public void pAge() {
    System.out.println("Age: 18");
  }
}