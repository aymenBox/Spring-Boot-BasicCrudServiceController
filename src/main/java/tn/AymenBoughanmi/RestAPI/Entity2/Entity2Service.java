package tn.AymenBoughanmi.RestAPI.Entity2;

import org.springframework.stereotype.Service;

import tn.AymenBoughanmi.RestAPI.BaseCrudPackage.BaseCrudService;

@Service
public class Entity2Service extends BaseCrudService<Entity2Repository, Entity2> {
	
	private final Entity2Repository repository;

	public Entity2Service(Entity2Repository repository) {
		super(repository);
		this.repository=repository;
		// TODO Auto-generated constructor stub
	}

	
}
