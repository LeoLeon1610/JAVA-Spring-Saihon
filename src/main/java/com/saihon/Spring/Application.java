package com.saihon.Spring;

import com.saihon.Spring.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean = 
				new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter());
		//registrationBean.addUrlPatterns("/api/libroPedido/*");
		//registrationBean.addUrlPatterns("/api/categorias/*");
//		registrationBean.addUrlPatterns("/api/pedidos/*");
		//registrationBean.addUrlPatterns("/api/libros/*");
		registrationBean.addUrlPatterns("/api/usuarios/*");
		return registrationBean;
	}

}
