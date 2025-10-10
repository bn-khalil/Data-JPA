package data_jpa.data_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DataJpaApplication.class, args);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.getTransaction().commit();
		System.out.println("hellod");
	}

//	@Bean
//	CommandLineRunner commandLineRunner( StudentRepository studentRepository ) {
//		return args -> {
//			Student student = new Student("khalil", "ben@gmail.com", 22);
//			studentRepository.save(student);
//		};
//	}
}
