package org.dataJpa;

import org.dataJpa.jpa_e1.entities.*;
import org.dataJpa.jpa_e1.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
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
/*			Product pro1 = new Product();
			pro1.setName("mac3");
			em.flush();
			Product product = em.find(Product.class, 2);
			em.merge(pro1);
			em.flush();
			System.out.println(product);
			em.refresh(product);
			System.out.println(product);*/


/*			relationships
					OneToOne*/

/*			Person person = new Person();
			person.setName("bn");

			Passport passport = new Passport();
			passport.setPassportNumber("BN3212");

			person.setPassport(passport);
			passport.setPerson(person);

			em.persist(person);
			em.persist(passport);

			System.out.println(person);*/

			/*			relationships
					OneToMany && ManyToOne */

			Post post = new Post();
			post.setContent("jakarta api persistance");

			Comment comment = new Comment();
			comment.setMessage("very good one!");

			comment.setPost(post);
			post.setComments(List.of(comment));

			em.persist(post);
			em.persist(comment);

			System.out.println(post);
			System.out.println(comment);

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
