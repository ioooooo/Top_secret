package hello.controllers;


import hello.models.Client;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ClientController {
  private List<Client> clienti = new ArrayList<Client>();

  ClientController() {
    Client p1 = new Client(1, "Viorel");
    Client p2 = new Client(2, "Augustin");
    Client p3 = new Client(3, "Adina");

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
  
    @RequestMapping(value="/client", method = RequestMethod.POST)
	public ResponseEntity create(@RequestBody Client p) {
	
	//Client p = new Client(id, name);
	
	clienti.add(p);
	String numeClient = p.getName();
        for(Client c_tmp : this.clienti) {
            if(c_tmp.getName().equals(numeClient)) {
                return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
  
    @RequestMapping(value="/client", method = RequestMethod.PUT)
	public ResponseEntity update(@RequestBody Client p) {
      int idClient = p.getId();
        for(Client c_tmp : this.clienti) {
            if(c_tmp.getId()==(idClient)) {
                c_tmp.setId(p.getId());
                c_tmp.setName(p.getName());
                return new ResponseEntity<ArrayList<Client>>((ArrayList<Client>) clienti, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}