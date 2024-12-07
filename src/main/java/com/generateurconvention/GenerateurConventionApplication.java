package com.generateurconvention;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/")
public class GenerateurConventionApplication {

    public static void main(String[] args) {
        // Démarrage de l'application Spring Boot
        ConfigurableApplicationContext context = SpringApplication.run(GenerateurConventionApplication.class, args);


        // Optionnel : Ajouter un message de démarrage personnalisé dans les logs
        System.out.println("===========================================");
        System.out.println("Application GenerateurConvention démarrée !");
        System.out.println("Swagger disponible à : http://localhost:8080/swagger-ui.html");
        System.out.println("===========================================");
    }

}
