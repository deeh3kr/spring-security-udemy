package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * /account secured
     * /loans secured
     * /cards secured
     * /balance secured
     * /notices not-secured
     * /contact not-secured
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/account").authenticated()
                .antMatchers("/balance").authenticated()
                .antMatchers("/loans").authenticated()
                .antMatchers("/cards").authenticated()
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/welcome").permitAll()
                .and()
                .formLogin()
                .and()
                .csrf().disable()
                .httpBasic();

        //deny all request----------------------------------------

//        http.authorizeRequests()
//                .anyRequest().denyAll().and()
//                .formLogin().and().httpBasic();

        //permit all requests-----------------------------------------
//
//        http.authorizeRequests().anyRequest().permitAll().and()
//                .formLogin().and().httpBasic();

    }


    //inMemory User -----------------------------------------------------------------
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("password")
//                .authorities("admin").and().withUser("user1").password("password1")
//                .authorities("read").and().passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }

    //----------------------------------------------------------------------------


    //inMemory user details manager -----------------------------------------------------
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails userDetails = User.withUsername("admin").password("password").authorities("admin").build();
//        UserDetails userDetails1 = User.withUsername("user").password("password").authorities("read").build();
//        inMemoryUserDetailsManager.createUser(userDetails);
//        inMemoryUserDetailsManager.createUser(userDetails1);
//        auth.userDetailsService(inMemoryUserDetailsManager);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//-------------------------------------------------------------------------



    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
