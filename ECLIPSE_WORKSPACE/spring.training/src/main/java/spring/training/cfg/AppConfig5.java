package spring.training.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import spring.training.entity.Category;
import spring.training.entity.Product;
import spring.training.entity.Supplier;

@Configuration
public class AppConfig5 {

	@Bean
	public DataSource mysqlDbcp() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/northwind");
		bds.setUsername("root");
		bds.setPassword("root");
		bds.setInitialSize(10);
		bds.setMaxTotal(100);
		bds.setMaxWaitMillis(2000);
		bds.setMaxIdle(50);
		bds.setMinIdle(10);
		return bds;
	}

	@Bean 
	public DataSource h2Dbcp() {
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

	@Bean
	public LocalSessionFactoryBean sessionFactory(@Qualifier("h2Dbcp") DataSource ds) { // dependency injection
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();

		// db information
		lsfb.setDataSource(ds); // manual wiring
		
		Properties props = new Properties();
		props.setProperty("hibernate.dailect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "true");
		
		// additional Hibernate properties
		lsfb.setHibernateProperties(props);

		// list of entity classes
		lsfb.setAnnotatedClasses(Category.class, Supplier.class, Product.class);
		
		return lsfb;
	}
	
	@Bean
	public HibernateTemplate ht(SessionFactory sf) {
		return new HibernateTemplate(sf);
	}
}







