package group.productsapi.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
            Product superMan = new Product(
                    "Super Man",
                    158.50,
                    123
            );
            Product staticShock = new Product(
                    "Super Shock",
                    140.50,
                    124
            );

            repository.saveAll(
                    List.of(superMan, staticShock)
            );
        };
    }
}
