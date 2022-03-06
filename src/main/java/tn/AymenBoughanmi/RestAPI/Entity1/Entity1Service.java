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
