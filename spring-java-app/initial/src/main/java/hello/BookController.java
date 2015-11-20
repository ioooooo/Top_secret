package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class BookController {
  private List<Book> Books = new ArrayList<Book>();

  BookController() {
    Book p1 = new Book(1, "MihaiEminescu","Luceafarul","Corint","Poezie", 8, 200 );
   // Book p2 = new Book(2, "Asus", "ROG");
   // Book p3 = new Book(3, "Acer", "Aspire");

    Books.add(p1);
   // Books.add(p2);
   // Books.add(p3);
  }

  @RequestMapping(value="/Book", method = RequestMethod.GET)
  public List<Book> index() {
    return this.Books;
  }

  @RequestMapping(value="/Book/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Book p : this.Books) {
      if(p.getId() == id) {
        return new ResponseEntity<Book>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Book/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Book p : this.Books) {
      if(p.getId() == id) {
        this.Books.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
    @RequestMapping(value="/Book/{id}/{autor}/{nume}/{editura}/{categorie}/{nrPagini}/{anAparitie}", method = RequestMethod.POST)
	public ResponseEntity create(@PathVariable("id") int id , @PathVariable("autor") String autor, @PathVariable("nume") String nume, @PathVariable("editura") String editura, @PathVariable("categorie") String categorie, @PathVariable("nrPagini") int nrPagini , @PathVariable("anAparitie") int anAparitie ) {
	
	Book p = new Book(id, autor, nume, editura, categorie, nrPagini, anAparitie);
	Books.add(p);
	
	return new ResponseEntity<Book>(p, new HttpHeaders(), HttpStatus.OK); 
  }
  
    @RequestMapping(value="/Book/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id) {
    for(Book p : this.Books) {
      if(p.getId() == id) {
        p.setName("DefaulAutor", "DefaulNume", "defaultEditura", "DefaultCategorie", 0, 0 );
        return new ResponseEntity<Book>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}