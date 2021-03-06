package demo_springjwt.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http
        .cors() // Ngăn chặn request từ một domain khác
            .and()
        .authorizeRequests()
            .antMatchers("/login", "/register").permitAll()
            .antMatchers(HttpMethod.GET, "/api/**").permitAll()
        	.antMatchers("/admin", "/admin/**").hasAuthority("ADMIN")
        	.antMatchers("/free").hasAnyAuthority("ADMIN", "USER", "AUTHOR", "EDITOR")
        	.antMatchers("/api/book/*").hasAnyAuthority("AUTHOR")
        	.antMatchers("/user", "/book", "/book/**").hasAnyAuthority("USER")
        	.antMatchers("/editor").hasAnyAuthority("EDITOR")
            .anyRequest().authenticated();

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }
}
