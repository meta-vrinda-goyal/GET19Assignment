package com.metacube.assignment.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

 DataSource dataSource;
	
    @Autowired
	public SpringSecurityConfiguration(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	//Enable jdbc authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/welcome")
            .hasAnyRole("USER", "ADMIN").antMatchers("/getAdmin").hasAnyRole("ADMIN")
            .antMatchers("/updateAdmin").hasAnyRole("ADMIN").antMatchers("/getUser").hasAnyRole("USER")
            .antMatchers("/updateUser").hasAnyRole("USER").anyRequest().authenticated().and().formLogin()
            .loginPage("/login")
            .permitAll().defaultSuccessUrl("/welcome").failureUrl("/login?error=true").
            and().logout().permitAll();

        http.csrf().disable();
    } 
}
