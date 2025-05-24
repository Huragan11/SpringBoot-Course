package huragan11.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails jack = User.builder()
                .username("jack")
                .password("{noop}123")
                .roles("EMPLOYEE")
                .build();
        UserDetails mary = User.builder()
                .username("huragan11")
                .password("{noop}123")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails james = User.builder()
                .username("james")
                .password("{noop}123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new  InMemoryUserDetailsManager(jack, mary, james);

    }
}
