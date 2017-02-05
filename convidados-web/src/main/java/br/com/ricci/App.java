package br.com.ricci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

/*
 * Funcional, porem estamos utilizando a configuracao do application.properties
 * 	
	@Bean
	public DataSource buildDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();				
		dataSource.setUrl("jdbc:mysql://localhost:3306/convidados");
		dataSource.setUsername("root");
		dataSource.setPassword("root");				
		return dataSource;
	}
*/
}
