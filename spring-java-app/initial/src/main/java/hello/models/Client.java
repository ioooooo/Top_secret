package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Client {
  private String name;
  private int id;

  public Client() {}

  public Client(int id, String name) {
	  this.name = name;
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }
  
  public void setId(int id) {
		this.id=id;
  }
  
  public void setName(String name) {
	  this.name=name;
  }
  

}