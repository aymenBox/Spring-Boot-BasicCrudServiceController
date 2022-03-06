package tn.AymenBoughanmi.RestAPI.Entity2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.AymenBoughanmi.RestAPI.BaseCrudPackage.BaseCrudController;

@RestController
@RequestMapping("/api/entity2")
public class Entity2Controller extends BaseCrudController<Entity2Service, Entity2> {
	
	private final Entity2Service service;

	public Entity2Controller(Entity2Service service) {
		super(service);
		this.service=service;
		// TODO Auto-generated constructor stub
	}

}
