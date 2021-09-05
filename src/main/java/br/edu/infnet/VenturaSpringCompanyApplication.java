package br.edu.infnet;

import br.edu.infnet.domain.controller.JobController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {JobController.class})
@EntityScan(basePackages = {"br.edu.infnet.domain.model"})
@EnableJpaRepositories(basePackages = {"br.edu.infnet.domain.repository"})
public class VenturaSpringCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenturaSpringCompanyApplication.class, args);
    }

}
