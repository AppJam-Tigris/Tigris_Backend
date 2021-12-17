package team.appjam.tigris_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class TigrisServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TigrisServerApplication.class, args);
    }

}
