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
