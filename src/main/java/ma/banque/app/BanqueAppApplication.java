package ma.banque.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Mini banque - APIs", description = "Description", version = "1.0"))
public class BanqueAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(BanqueAppApplication.class, args);
        System.out.println("done");
    }

}
