class Vehicle {
  
  protected String carBrand = "Ford";

}

class Inheritance extends Vehicle {

  private String carModel = "Mustang";

  public static void main(String[] args) {
      
    Inheritance myCar = new Inheritance();

    System.out.println(myCar.carBrand + " " + myCar.carModel);

  }


}