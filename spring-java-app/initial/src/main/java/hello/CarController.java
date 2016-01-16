package hello.controllers;


import hello.models.Car;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CarController {
  private List<Car> cars = new ArrayList<Car>();

  CarController() {
    Car p1 = new Car(1, "VW", "Golf");
    Car p2 = new Car(2, "Audi", "R8");
    Car p3 = new Car(3, "Dacia", "1310");

    cars.add(p1);
    cars.add(p2);
    cars.add(p3);
  }

  @RequestMapping(value="/car", method = RequestMethod.GET)
  public List<Car> index() {
    return this.cars;
  }

  @RequestMapping(value="/car/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Car p : this.cars) {
      if(p.getId() == id) {
        return new ResponseEntity<Car>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/car/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Car p : this.cars) {
      if(p.getId() == id) {
        this.cars.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
    @RequestMapping(value="/car", method = RequestMethod.POST)
	public ResponseEntity create(@RequestBody Car p) {
	
	cars.add(p);
	String brandCar = p.getBrand();
	String modelCar = p.getModel();
        for(Car c_tmp : this.cars) {
            if(c_tmp.getBrand().equals(brandCar) && c_tmp.getModel().equals(modelCar)) {
                return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
  
    @RequestMapping(value="/car", method = RequestMethod.PUT)
  public ResponseEntity update(@RequestBody Car p) {
      int idCar = p.getId();
        for(Car c_tmp : this.cars) {
            if(c_tmp.getId()==(idCar)) {
                c_tmp.setId(p.getId());
                c_tmp.setBrand(p.getBrand());
				c_tmp.setModel(p.getModel());
                return new ResponseEntity<ArrayList<Car>>((ArrayList<Car>) cars, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}