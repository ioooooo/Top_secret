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
public class ClientController {
  private List<Client> clienti = new ArrayList<Client>();

  ClientController() {
    Client p1 = new Client(1, "Viorel", "Costin");
    Client p2 = new Client(2, "Augustin", "Stanescu");
    Client p3 = new Client(3, "Adina", "Buriceanu");

    clienti.add(p1);
    clienti.add(p2);
    clienti.add(p3);
  }

  @RequestMapping(value="/client", method = RequestMethod.GET)
  public List<Client> index() {
    return this.clienti;
  }

  @RequestMapping(value="/client/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Client p : this.clienti) {
      if(p.getId() == id) {
        return new ResponseEntity<Client>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/client/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Client p : this.clienti) {
      if(p.getId() == id) {
        this.clienti.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
    @RequestMapping(value="/client/{id}/{firstName}/{lastName}", method = RequestMethod.POST)
	public ResponseEntity create(@PathVariable("id") int id , @PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
	
	Client p = new Client(id, firstName, lastName);
	clienti.add(p);
	
	return new ResponseEntity<Client>(p, new HttpHeaders(), HttpStatus.OK); 
  }
  
    @RequestMapping(value="/client/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id) {
    for(Client p : this.clienti) {
      if(p.getId() == id) {
        p.setName("Aurel", "Olteanu");
        return new ResponseEntity<Client>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}