package hello;

import java.util.List;
import java.util.ArrayList;

public class Car {
  private String brand;
  private String model;
  private int id;

  public Car() {}

  public Car(int id, String brand, String model) {
	  this.brand = brand;
      this.model = model;
      this.id = id;
  }

  public String getBrand() {
      return this.brand;
  }

  public String getModel() {
      return this.model;
  }
  public int getId() {
    return this.id;
  }
  
  public void setName(String brand, String model) {
    this.brand = brand;
	this.model = model;
  }
}