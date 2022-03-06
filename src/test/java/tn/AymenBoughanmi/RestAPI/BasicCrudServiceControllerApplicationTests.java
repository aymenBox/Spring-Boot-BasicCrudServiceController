package tn.AymenBoughanmi.RestAPI;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.AymenBoughanmi.RestAPI.Entity1.Entity1;
import tn.AymenBoughanmi.RestAPI.Entity1.Entity1Service;
import tn.AymenBoughanmi.RestAPI.Entity2.Entity2;
import tn.AymenBoughanmi.RestAPI.Entity2.Entity2Service;

@SpringBootTest
class BasicCrudServiceControllerApplicationTests {

	@Autowired
	private Entity1Service entity1Service;
	@Autowired
	private Entity2Service entity2Service;
	
	@Test
	void contextLoads() {
		assertThat(entity1Service).isNotNull();
		assertThat(entity2Service).isNotNull();
	}
	
	@Test
	void TestInsertingData() {
		for (int i = 0; i < 10; i++) {
			Entity1 e1= new Entity1("entity1 Data");
			Entity2 e2 = new Entity2("entity2 data");
			entity1Service.save(e1);
			entity2Service.save(e2);
		}
		assertThat(entity1Service.count()).isGreaterThan(0);
		assertThat(entity2Service.count()).isGreaterThan(0);

	}

}
