# feature request for spring boot web framework

**Have you ever get tired of rewriting the same CRUD Services and Controllers over and over again ?** every time you create your entity and repository and there is this moment in your project where you have to create the the services business logic and the controller for all your entity like the /save /get /all /update.
don't you think it would be better if we have a class for example named **BaseCRUDService** and **BaseCRUDController** where all those end-point are just preconfigured and you could if you want customize theme for some entity only.


# My Solution 

The solution i Think we should use as probably any one of you have already used it himself , is to have tow basic class one for services and one for controllers and we could customize those classes for each entity and keep the basic CRUD operation so we don't have to write theme again.

## Examples 
for this example imagine we gave an Entity Entity1 and Entity2

	   @Entity
	public class Entity1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String data;
	
	@ManyToOne
	private Entity2 entite2;
	//basic constructor , getter , setter
----------
    @Entity
	public class Entity2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	 String data;
	
	@OneToMany
	 Set<Entity1> entity1List;
	 //basic constructor , getter , setter
---
and we have created both of repository for each entity the service For Entity2 for example would look like this:
	package tn.AymenBoughanmi.RestAPI.Entity2;

	import org.springframework.stereotype.Service;

	import tn.AymenBoughanmi.RestAPI.BaseCrudPackage.BaseCrudService;

	@Service
	public class Entity2Service extends BaseCrudService<Entity2Repository, Entity2> {
	
	private final Entity2Repository repository;

	public Entity2Service(Entity2Repository repository) {
		super(repository);
		this.repository=repository;
	}

	
	}
---
and for Entity1 :
	package tn.AymenBoughanmi.RestAPI.Entity1;

	import org.springframework.stereotype.Service;

	import tn.AymenBoughanmi.RestAPI.BaseCrudPackage.BaseCrudService;
	import tn.AymenBoughanmi.RestAPI.Entity2.Entity2;

	@Service
	public class Entity1Service extends BaseCrudService<Entity1Repository, Entity1> {
	
	private final Entity1Repository repository;

	public Entity1Service(Entity1Repository repository) {
		super(repository);
		this.repository=repository;
		// TODO Auto-generated constructor stub
	}
	
	public void setEntity2(long id,Entity2 e2) {
		Entity1 e1 = repository.getById(id);
		e1.setEntite2(e2);
		repository.save(e1);
	}

}

---
notice we haven't used any Update or delete methods for each one that's because we are extending from the **BaseCrudService** class those are already been created for us we only provide the entity type and the repository to be used bu the abstract class.


---

same thing for the Controllers logic so the Controller for Entity1 would be :
	package tn.AymenBoughanmi.RestAPI.Entity1;

	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import tn.AymenBoughanmi.RestAPI.BaseCrudPackage.BaseCrudController;

	@RestController
	@RequestMapping("/api/entity1")
	public class Entity1Controller extends BaseCrudController<Entity1Service, Entity1> {
	
	private final Entity1Service service;

	public Entity1Controller(Entity1Service service) {
		super(service);
		this.service=service;
		// TODO Auto-generated constructor stub
	}

	}

---
as you can see we only provide the @RequestMapping("/API_URL") then we get all of the end-point generated like / get/{id} for example if i Run my application i could run 
a GET request to http://localhost:8080/api/entity1/all and this will give me a json file will all the entity that are saved.
| url | description |
|--|--|
|/all  | will return list of entity's IN JSON format |
|/delete/{id}|return true if entity is deleted false if not|
|/count|return count of entity's in database|
|/save|return true if saved error 404 if input is not formated|
|/update/{id}|update a given entity if exists and return true else it will return false|



