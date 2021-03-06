package uz.pdp.pcmarket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecuritySettings extends WebSecurityConfigurerAdapter {
    /**
     * This RestFULL is the clone of the pcmarket.uz (e-commerce of electronics)
     * It has been created using Spring DATA Rest and Spring Security (basic auth)
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("super_admin").password(passwordEncoder().encode("super_admin")).roles("SUPER_ADMIN")
                .and()
                .withUser("moderator").password(passwordEncoder().encode("moderator")).roles("MODERATOR")
                .and()
                .withUser("operator").password(passwordEncoder().encode("operator")).roles("OPERATOR");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * There are three roles in the system
         * SUPER_ADMIN, MODERATOR and OPERATOR.
         * SUPER_ADMIN can do anything;
         * MODERATOR can add and edit products, but cannot delete;
         * The OPERATOR works with orders, cannot delete or edit the product.
         */
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/product/**").hasAnyRole("MODERATOR", "SUPER_ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/product/**").hasAnyRole("MODERATOR", "SUPER_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/product/**").hasAnyRole("MODERATOR", "SUPER_ADMIN", "OPERATOR")
                .antMatchers(HttpMethod.DELETE, "/api/comment/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/order/**").hasAnyRole("OPERATOR", "SUPER_ADMIN")
                .antMatchers("/api/product/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/basket/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/category/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/characteristics/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/contact/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/outputProduct/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/team/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/user/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/attachment/**").hasRole("SUPER_ADMIN")
                .antMatchers("/api/supplier/**").hasRole("SUPER_ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
