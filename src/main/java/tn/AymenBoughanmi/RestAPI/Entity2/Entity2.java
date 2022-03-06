package tn.AymenBoughanmi.RestAPI.Entity2;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import tn.AymenBoughanmi.RestAPI.Entity1.Entity1;

@Entity
public class Entity2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	 String data;
	
	@OneToMany
	 Set<Entity1> entity1List;

	
	public void addEntity(Entity1 e) {
		entity1List.add(e);
	}
	
	public long getId() {
		return id;
	}

	
	public Entity2(String data ) {
		super();
		this.data = data;
	}
	


	public Entity2(long id, String data, Set<Entity1> entity1List) {
		super();
		this.id = id;
		this.data = data;
		this.entity1List = entity1List;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data ) {
		this.data = data;
	}

}
