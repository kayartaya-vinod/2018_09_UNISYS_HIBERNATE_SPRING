package spring.training.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.training.dao.ProductDao;
import spring.training.dao.impl.JdbcProductDao;

// This class is equivalent of "context.xml", 
// which defines one or more beans
@Configuration
public class AppConfig1 {

	@Bean
	public ProductDao dao() {
		JdbcProductDao jpd = new JdbcProductDao();
		jpd.setUsername("sa");
		jpd.setPassword("");
		jpd.setDriver("org.h2.Driver");
		jpd.setUrl("jdbc:h2:tcp://localhost/~/unisys_training_sep_18");
		return jpd;
	}
	
}
