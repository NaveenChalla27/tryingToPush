package com.mindtree.charlieonline.food.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
  public AuthenticationProvider authProvider(){
	DaoAuthenticationProvider provider=new 	DaoAuthenticationProvider();
	provider.setUserDetailsService(userDetailsService);
	provider.setPasswordEncoder(new BCryptPasswordEncoder());
	return provider;
  }
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().
	        disable()
	            .authorizeRequests()
	            .antMatchers("/**","/request","/menuList")
	            .permitAll()
	            .anyRequest()
	            .authenticated()
	            .and()
	            .httpBasic();
//		 http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().httpBasic()
//			.and().formLogin().loginPage("/login").permitAll().and().logout().invalidateHttpSession(true)
//			.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/home").permitAll();
	    }
	}

