package tn.AymenBoughanmi.RestAPI.BaseCrudPackage;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseCrudService<MyRepository extends JpaRepository<Entity, Long>,Entity>{
	
	
	private final MyRepository repository;
	//---------------------------------------------------------------------------------
	public BaseCrudService(MyRepository repository) {
		this.repository = repository;
	}
	//---------------------------------------------------------------------------------
	public List<Entity> findAll() {
		return this.repository.findAll();
		
	}	
	//---------------------------------------------------------------------------------
	public long count() {
		return repository.count();
	}
	//---------------------------------------------------------------------------------
	public boolean save(Entity e){
		try {
		this.repository.save(e);
		return true;
		}
		catch(IllegalArgumentException  e1) {
			System.out.println("exception found");
			return false;
		}
	}
	//---------------------------------------------------------------------------------
	public boolean delete(long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	//---------------------------------------------------------------------------------
	public Optional<Entity> findById(long id) {
		return repository.findById(id);
	}
	//---------------------------------------------------------------------------------
	public boolean existById(long id) {
		return repository.existsById(id);
	}
}
