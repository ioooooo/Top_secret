package hello;

import java.util.List;
import java.util.ArrayList;

public class Client {
  private String firstName;
  private String lastName;
  private int id;

  public Client() {}

  public Client(int id, String firstName, String lastName) {
	  this.firstName = firstName;
      this.lastName = lastName;
      this.id = id;
  }

  public String getFirstName() {
      return this.firstName;
  }

  public String getLastName() {
      return this.lastName;
  }
  public int getId() {
    return this.id;
  }
  
  public void setName(String firstName, String lastName) {
    this.firstName = firstName;
	this.lastName = lastName;
  }
}