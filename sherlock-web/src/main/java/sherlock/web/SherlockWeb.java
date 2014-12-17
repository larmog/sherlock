package sherlock.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.security.oauth2.sso.EnableOAuth2Sso;
import org.springframework.cloud.security.oauth2.sso.OAuth2SsoConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sherlock Web application.
 */
@SpringBootApplication
@RestController
@EnableOAuth2Sso
@EnableZuulProxy
public class SherlockWeb {

    public static void main(String[] args) {
        SpringApplication.run(SherlockWeb.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "<html><body><a href='dashboard/'>dashboard</a><br/><a href='login'>login</a></body></html>";
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "<html><body>Dashboard Yay!</body></html>";
    }

    @Component
    public static class LoginConfigurer extends OAuth2SsoConfigurerAdapter {
        @Override
        public void match(RequestMatchers matchers) {
            matchers.antMatchers("/dashboard/**");
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().authenticated();
        }
    }
}
