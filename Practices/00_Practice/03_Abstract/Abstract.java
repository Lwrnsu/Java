public class Abstract {
  
  public static void main(String[] args) {
      Male pMale = new Male();
      Female pFemale = new Female();

      pMale.personGender();
      pFemale.personGender();
  }
// ACCIDENTALLY DID A ABSTRACT POLYMORPHISM HAHAHAHAHAHA.
}

abstract class Person {
  public abstract void personGender(); // to fill a body here, you need to inherit it from other class.
}

class Male extends Person {
  public void personGender() {
    System.out.println("Person's gender is Male!"); // accessed it through a class.
  }
}

class Female extends Person {
  public void personGender() {
    System.out.println("Person's gender is Female!");
  }
}