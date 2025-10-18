class Polymorphism {
  
  public static void main(String[] args) {

    Person neutralPerson = new Person();
    Person malePerson = new Male();
    Person femalePerson = new Female();

    neutralPerson.isGender();
    malePerson.isGender();
    femalePerson.isGender();

  }

}

class Person {

  public void isGender() {
    System.out.println("I am a person!");
  }

}

class Male extends Person{
  public void isGender() {
    System.out.println("I am a Male!");
  }
}

class Female extends Person {
  public void isGender() {
    System.out.println("I am a Female!");
  }
}