package hello;

import java.util.List;
import java.util.ArrayList;

public class Book {
  private String autor;
  private String nume;
  private String editura;
  private String categorie;
  private int nrPagini;
  private int anAparitie;
  private int id;

  public Book() {}

  public Book(int id, String autor, String nume,  String editura, String categorie,  int nrPagini,   int anAparitie) {
	  this.autor = autor;
	  this.nume = nume;
      this.editura = editura;
	  this.categorie = categorie;
	  this.nrPagini = nrPagini;
	  this.anAparitie = anAparitie;
      this.id = id;
  }

  public String getAutor() {
      return this.autor;
  }

  public String getEditura() {
      return this.editura;
  }
  public String getNume() {
      return this.nume;
  }
  public String getCategorie() {
      return this.categorie;
  }
  public int getNrPagini() {
    return this.nrPagini;
  }
  public int getAnAparitie() {
    return this.anAparitie;
  }
  public int getId() {
    return this.id;
  }
  
  public void setName(String autor, String nume,  String editura, String categorie,  int nrPagini,   int anAparitie) {
	  this.autor = autor;
	  this.nume = nume;
      this.editura = editura;
	  this.categorie = categorie;
	  this.nrPagini = nrPagini;
	  this.anAparitie = anAparitie;
  }
}
