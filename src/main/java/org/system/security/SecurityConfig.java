package org.system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.system.admin.model.UserStatus;

import javax.sql.DataSource;

/**
 * Application Index Controller.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Mauro Travieso (986965)
 * @version      1.0
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

//    @Value("${spring.queries.users-query}")
//    private String usersQuery;

//    @Value("${spring.queries.roles-query}")
//    private String rolesQuery;

    // Type of authentication to be used
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
//        .usersByUsernameQuery("select email as principal, password as credentials, true from user where email=?")
//                .authoritiesByUsernameQuery("select user_email as principal, role_name as role from user_roles where user_email=?")
//        .usersByUsernameQuery("select email as principal, password as credentials, status as status, true from user where email=?")
                .usersByUsernameQuery("select email as principal, password as credentials, true from user where email=? and status='0'")
                .authoritiesByUsernameQuery("select user_email as principal, role_name as role from user_roles where user_email=?")
//                .authoritiesByUsernameQuery("select user_email as principal, permission_name as permission from user_permissions where user_email=? and permission='ACCESS_REPORT' or permission='UPLOAD_PRODUCT' or permission='UPDATE_PRODUCT'")
                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_"); // To access ROLE_ADMIN or ROLE_USER

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    // Requests that should be authenticated and not
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests()
//        .antMatchers("/register", "/", "/about", "/", "/login", "/css/**", "/webjars/**").permitAll()
//        .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
//        .defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");

        http.authorizeRequests()

                .antMatchers("/register", "/", "/about", "/", "/login", "/css/**", "/webjars/**", "/user","/cart","/user/cart", "/searchProductBySeller", "/addProduct", "/listProductByKeyword", "/productEdit")
                .permitAll()

                .antMatchers("/profile").hasAnyRole("USER,ADMIN,VENDOR,CUSTOMER,EMPLOYEE")
                .antMatchers("/users","/addTask").hasRole("ADMIN")
                .and().formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");

    }

}
