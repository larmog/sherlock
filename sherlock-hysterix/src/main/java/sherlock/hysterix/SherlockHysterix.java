package sherlock.hysterix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import com.netflix.hystrix.contrib.javanica.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Configuration
@EnableAutoConfiguration
@EnableHystrix
@RestController
@ComponentScan
@EnableHystrixDashboard
public class SherlockHysterix {
    @Autowired
    private UserIntegration userIntegration;

    public static void main(String[] args) {
        new SpringApplicationBuilder(SherlockHysterix.class).web(true).run(args);
    }

    @RequestMapping("/users")
    public List<Map<String, Object>> users() {
        Map<String, Object> parameters = Collections.emptyMap();
        return userIntegration.getUsers(parameters);
    }

}

@Component
class UserIntegration {

    @HystrixCommand(fallbackMethod = "defaultStores")
    public List<Map<String, Object>> getUsers(Map<String, Object> parameters) {
        throw new RuntimeException("Hystrix error");
    }

    public List<Map<String, Object>> defaultStores(Map<String, Object> parameters) {
        Map<String, Object> defaultUser = new HashMap<>();
        defaultUser.put("id", 1L);
        defaultUser.put("firstname", "default");
        defaultUser.put("lastname", "default");
        return Arrays.asList(defaultUser);
    }
}
