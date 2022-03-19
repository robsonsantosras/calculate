package boasentregas.calculate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = { "boasentregas.calculate", "boasentregas.security"})
@EnableMongoRepositories({"boasentregas.calculate.repositories","boasentregas.security.repositories"})
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
