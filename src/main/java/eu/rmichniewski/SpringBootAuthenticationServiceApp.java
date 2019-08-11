package eu.rmichniewski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringBootAuthenticationServiceApp
 *
 * @author Ertan Toker
 */
//@EnableDiscoveryClient
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringBootAuthenticationServiceApp
{

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootAuthenticationServiceApp.class, args);
    }
}
