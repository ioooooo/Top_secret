package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Car {
  private int id;
  private String brand;
  private String model;

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
  
  public void setId(int id) {
	this.id=id;
  }
  
  public void setBrand(String brand) {
	this.brand=brand;
  }
  
  public void setModel(String model) {
	this.model=model;
  }
}