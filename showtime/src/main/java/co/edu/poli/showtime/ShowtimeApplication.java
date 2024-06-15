package co.edu.poli.showtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("co.edu.poli.commons")
public class ShowtimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowtimeApplication.class, args);
    }

}
