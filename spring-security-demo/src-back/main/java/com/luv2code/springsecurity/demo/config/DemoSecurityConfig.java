package com.luv2code.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication().withUser(users.username("john").password("john").roles("EMPLOYEE"));
//        auth.inMemoryAuthentication().withUser(users.username("mary").password("mary").roles("EMPLOYEE", "MANAGER"));
//        auth.inMemoryAuthentication().withUser(users.username("admin").password("admin").roles("EMPLOYEE", "ADMIN", "MANAGER"));


        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/system/**").hasRole("ADMIN")
            .and().formLogin()
                    .loginPage("/showMyLoginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
            .and()
                .logout().permitAll()
            .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
