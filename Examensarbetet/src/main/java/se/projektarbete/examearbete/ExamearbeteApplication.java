package se.projektarbete.examearbete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamearbeteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamearbeteApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(FocusSessionRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new FocusSession("Morgonfokus", "Moise", 25, 3));
                repository.save(new FocusSession("Pluggsession Java", "Moise", 50, 5));
                repository.save(new FocusSession("Kvällsfokus", "Anna", 25, 2));
            }
        };
    }
}

