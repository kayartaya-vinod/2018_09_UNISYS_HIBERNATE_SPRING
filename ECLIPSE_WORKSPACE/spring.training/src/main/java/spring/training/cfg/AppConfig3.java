package spring.training.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.training.dao.ProductDao;
import spring.training.dao.impl.JdbcProductDao;

@Configuration
public class AppConfig3 {

	@Bean(name = {"dao", "jdbc-dao"})
	public ProductDao productDao(DataSource ds) { // dependency injection 
		// return new JdbcProductDao(basicDataSource()); // manual wiring
		// return new JdbcProductDao(ds); // manual wiring using constructor
		JdbcProductDao jpd = new JdbcProductDao();
		jpd.setDataSource(ds); // manual wiring using setter
		return jpd;
	}
	
	@Bean(name= {"dbcp", "dataSource"})
	public DataSource basicDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("org.h2.Driver");
		bds.setUrl("jdbc:h2:tcp://localhost/~/unisys_training_sep_18");
		bds.setUsername("sa");
		bds.setPassword("");
		bds.setInitialSize(10);
		bds.setMaxTotal(100);
		bds.setMaxWaitMillis(2000);
		bds.setMaxIdle(50);
		bds.setMinIdle(10);
		
		return bds;
	}
}



