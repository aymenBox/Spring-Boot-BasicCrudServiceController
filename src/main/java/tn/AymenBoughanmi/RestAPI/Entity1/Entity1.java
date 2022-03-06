package tn.AymenBoughanmi.RestAPI.Entity1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import tn.AymenBoughanmi.RestAPI.Entity2.Entity2;

@Entity
public class Entity1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String data;
	
	@ManyToOne
	private Entity2 entite2;

	public long getId() {
		return id;
	}

	
	public Entity1() {
		super();
	}


	public Entity1(long id, String data, Entity2 entite2) {
		super();
		this.id = id;
		this.data = data;
		this.entite2 = entite2;
	}


	public Entity1(String data) {
		super();
		this.data = data;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	public Entity2 getEntite2() {
		return entite2;
	}


	public void setEntite2(Entity2 entite2) {
		this.entite2 = entite2;
	}

}
