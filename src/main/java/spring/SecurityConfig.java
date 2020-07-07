/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring;

import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ISLEM
 */
/*@Configuration
@EnableWebSecurity*/
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

    /*@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("javainuse")
                .password("javainuse").roles("USER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("USER")
                .and().formLogin().loginPage("/login.jsp")
                .failureUrl("/login.jsp?error=1").loginProcessingUrl("/login")
                .permitAll().and().logout()
                .logoutSuccessUrl("/listEmployees.html");

    }*/

}
