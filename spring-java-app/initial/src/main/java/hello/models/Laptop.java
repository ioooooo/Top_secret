package hello;

import java.util.List;
import java.util.ArrayList;

public class Laptop {
  private String brand;
  private String model;
  private String cpu;
  private double display;
  private int ram;
  private String hdd;
  private int id;

  public Laptop() {}

  public Laptop(int id, String brand, String model, String cpu, double display, int ram , String hdd) {
	  this.brand = brand;
      this.model = model;
	  this.cpu = cpu;
	  this.display = display;
	  this.ram = ram;
	  this.hdd = hdd;
      this.id = id;
  }

  public String getBrand() {
      return this.brand;
  }

  public String getModel() {
      return this.model;
  }
  public String getCpu() {
      return this.cpu;
  }
  public double getDisplay() {
      return this.display;
  }
  public int getRam() {
    return this.ram;
  }
  public String getHdd() {
    return this.hdd;
  }
  public int getId() {
    return this.id;
  }
  
  public void setName(String brand, String model, String cpu, double display, int ram , String hdd) {
	  this.brand = brand;
      this.model = model;
	  this.cpu = cpu;
	  this.display = display;
	  this.ram = ram;
	  this.hdd = hdd;
 
  }
}