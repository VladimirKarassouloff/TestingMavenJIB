package jib.server;

import jib.BaseControllerClass;
import jib.dao.BaseRepository;
import jib.model.entities.BaseModelClass;
import jib.service.BaseServiceClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackageClasses = {
                BaseServiceClass.class,
                BaseControllerClass.class,
                BaseRepository.class
        }
)
@EnableJpaRepositories(basePackageClasses = BaseRepository.class)
@EntityScan(basePackageClasses = BaseModelClass.class)
public class Server {

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }


}
