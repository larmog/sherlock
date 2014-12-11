package sherlock.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigServer
@EnableEurekaClient
public class SherlockConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(SherlockConfigServer.class, args);
    }

}
