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
public class CarController {
  private List<Car> Cars = new ArrayList<Car>();

  CarController() {
    Car p1 = new Car(1, "VW", "Golf");
    Car p2 = new Car(2, "Audi", "R8");
    Car p3 = new Car(3, "Dacia", "1310");

    Cars.add(p1);
    Cars.add(p2);
    Cars.add(p3);
  }

  @RequestMapping(value="/Car", method = RequestMethod.GET)
  public List<Car> index() {
    return this.Cars;
  }

  @RequestMapping(value="/Car/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Car p : this.Cars) {
      if(p.getId() == id) {
        return new ResponseEntity<Car>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Car/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Car p : this.Cars) {
      if(p.getId() == id) {
        this.Cars.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
    @RequestMapping(value="/Car/{id}/{brand}/{model}", method = RequestMethod.POST)
	public ResponseEntity create(@PathVariable("id") int id , @PathVariable("brand") String brand, @PathVariable("model") String model) {
	
	Car p = new Car(id, brand, model);
	Cars.add(p);
	
	return new ResponseEntity<Car>(p, new HttpHeaders(), HttpStatus.OK); 
  }
  
    @RequestMapping(value="/Car/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id) {
    for(Car p : this.Cars) {
      if(p.getId() == id) {
        p.setName("Aurel", "Olteanu");
        return new ResponseEntity<Car>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}