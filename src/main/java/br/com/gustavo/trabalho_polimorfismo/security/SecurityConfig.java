package br.com.gustavo.trabalho_polimorfismo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth.requestMatchers("/login", "/css/**","/js/**").permitAll()
                        .requestMatchers("/admin/**")
                        .hasAnyRole("ADMIN")
                        

                        .requestMatchers("/usuario/**")
                        .hasAnyRole("ADMIN", "USER", "USER_VENDEDOR")

                        .requestMatchers("/painel_vendedor/**")
                        .hasAnyRole("ADMIN", "USER_VENDEDOR")

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/inicio", true)
                        .permitAll()
                        .usernameParameter("email")
                        .passwordParameter("senha")
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout"));

            return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
