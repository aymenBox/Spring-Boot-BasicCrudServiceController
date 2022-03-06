package tn.AymenBoughanmi.RestAPI.BaseCrudPackage;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import org.springframework.http.HttpStatus;
/**
 * this class serve as the base Class for all Crud Rest Controller to be created
 * it's an abstract class to be inherited later when creating other CRUD classes 
 * use a generic service type to be later replaced with our own class service 
 * example(UserService, BookService)
 * 
 * 
 * @author Aymen
 *
 * @param <Service>
 * 
 * type of entity to be transformed later into JSON Format and methods methods 
 * @param <Entity>
 */
public abstract class BaseCrudController<Service extends BaseCrudService<?, Entity>,Entity> {
	
	private final Service service;
	//---------------------------------------------------------------------------------
	public BaseCrudController(Service service) {
		this.service = service;
	}
	//---------------------------------------------------------------------------------
	/**
	 * "/all" will return list of entity's IN JSON format
	 * @return
	 */
	@GetMapping(value="/all")
	public List<Entity> findAll(){
		return service.findAll();
		}
	//---------------------------------------------------------------------------------
	
	/**
	 * return true if entity is deleted false if not
	 * @param id
	 * @return
	 */
    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable("id") Long id) {
    	
        if(service.delete(id)) {
        	return true;
        }
        return false;
    }
  //---------------------------------------------------------------------------------
    /**
     * return count of entity's in database
     * @return
     */
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public long count() {
    	return service.count();
    }
  //---------------------------------------------------------------------------------
    /**
     * return true if saved error 404 if input is not formated
     * @param e
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean save(@RequestBody Entity e) {
    	 return service.save(e);
    }
  //---------------------------------------------------------------------------------
    /**
     * update a given entity if exists and return true else it will return false
     * @param e
     * @param id
     * @return
     */
    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean update(@RequestBody Entity e,@PathVariable("id") Long id) {
    	if(this.service.existById(id)) {
    		this.service.save(e);
    		return true;
    	}
    	return false;
    }
	//---------------------------------------------------------------------------------
    /**
     * return a given entity by id
     * @param id
     * @return
     */
	@GetMapping(value="/get/{id}")
	public Entity findById(@PathVariable("id") Long id){
		return service.findById(id).get();
		}
    

}
