package co.ke.collengine.springbootapiexample;

import co.ke.collengine.springbootapiexample.entity.CarParkDetails;
import co.ke.collengine.springbootapiexample.repository.CarParkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootApiExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiExampleApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(CarParkRepository repository) {
        return (args) -> {
            repository.save(new CarParkDetails("Sarit Center", "KBD455L", 1663274777, 1663274777, "blue"));
            repository.save(new CarParkDetails("Westgate", "KAD425L", 1663274777, 1663274777, "red"));
            repository.save(new CarParkDetails("Yaya Center", "KDH105L.", 1663274777, 1663274777, "white"));
        };

    }

}
