package org.dataJpa;

import org.dataJpa.jpa_e1.entities.Product;
import org.dataJpa.jpa_e1.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Objects;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DataJpaApplication.class, args);
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
		HashMap<String, Object> props = new HashMap<>();
		props.put("hibernate.hbm2ddl.auto", "update");  // ✅ auto create or update tables
		props.put("hibernate.show_sql", "true");

		EntityManagerFactory emf = new HibernatePersistenceProvider()
				.createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), props);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Product pro1 = new Product();
			pro1.setName("mac3");
//			em.flush();
			Product product = em.find(Product.class, 2);
			em.merge(pro1);
			em.flush();
			System.out.println(product);
			em.refresh(product);
			System.out.println(product);
			System.exit(0);
			em.getTransaction().commit();
		} finally {
			em.close();
			System.out.println("context closed!");
		}
	}

//	@Bean
//	CommandLineRunner commandLineRunner( StudentRepository studentRepository ) {
//		return args -> {
//			Student student = new Student("khalil", "ben@gmail.com", 22);
//			studentRepository.save(student);
//		};
//	}
}
