package sherlock.eureka.server;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableEurekaServer
public class SherlockEurekaServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SherlockEurekaServer.class).web(true).run(args);
    }

}