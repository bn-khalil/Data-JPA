package data_jpa.data_jpa;

import data_jpa.data_jpa.jpa_e1.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DataJpaApplication.class, args);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Product product = new Product();

			product.setId(1L);
			product.setName("mac");

			em.persist(product);
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
