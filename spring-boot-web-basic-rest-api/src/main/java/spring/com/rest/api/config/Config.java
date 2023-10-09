package spring.com.rest.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class Config {
//private static final String[] WHITE_LIST_URLS= {
//		"/users",
//		"/register"
//		
//		
//};
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
//        http.cors()
//        .and()
//        .csrf()
//        .disable()
//        .authorizeHttpRequests()
//      .requestMatchers(WHITE_LIST_URLS)
//        .permitAll();
    	http
        .cors()
        .and()
        .csrf()
        .disable()
        .authorizeRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers(HttpMethod.GET, "/users").permitAll()
                .requestMatchers(HttpMethod.POST, "/register").permitAll()
// Temporary access
               // .anyRequest().authenticated()
        );




        return http.build();
    }
}
