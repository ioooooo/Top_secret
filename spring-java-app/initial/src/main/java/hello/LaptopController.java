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
public class LaptopController {
  private List<Laptop> Laptops = new ArrayList<Laptop>();

  LaptopController() {
    Laptop p1 = new Laptop(1, "Lenovo", "Z", "i5", 15.6, 8, "1TB" );
   // Laptop p2 = new Laptop(2, "Asus", "ROG");
   // Laptop p3 = new Laptop(3, "Acer", "Aspire");

    Laptops.add(p1);
   // Laptops.add(p2);
   // Laptops.add(p3);
  }

  @RequestMapping(value="/Laptop", method = RequestMethod.GET)
  public List<Laptop> index() {
    return this.Laptops;
  }

  @RequestMapping(value="/Laptop/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Laptop p : this.Laptops) {
      if(p.getId() == id) {
        return new ResponseEntity<Laptop>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Laptop/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Laptop p : this.Laptops) {
      if(p.getId() == id) {
        this.Laptops.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
    @RequestMapping(value="/Laptop/{id}/{brand}/{model}/{cpu}/{display}/{ram}/{hdd}", method = RequestMethod.POST)
	public ResponseEntity create(@PathVariable("id") int id , @PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("cpu") String cpu, @PathVariable("display") double display, @PathVariable("ram") int ram , @PathVariable("hdd") String hdd ) {
	
	Laptop p = new Laptop(id, brand, model, cpu, display, ram, hdd);
	Laptops.add(p);
	
	return new ResponseEntity<Laptop>(p, new HttpHeaders(), HttpStatus.OK); 
  }
  
    @RequestMapping(value="/Laptop/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id) {
    for(Laptop p : this.Laptops) {
      if(p.getId() == id) {
        p.setName("DefaulName", "DefaulModel", "CpuModel", 0, 0, "TB" );
        return new ResponseEntity<Laptop>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}