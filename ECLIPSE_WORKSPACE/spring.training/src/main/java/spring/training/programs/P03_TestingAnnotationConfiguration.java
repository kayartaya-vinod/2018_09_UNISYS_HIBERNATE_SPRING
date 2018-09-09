package spring.training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.training.cfg.AppConfig4;
import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;

public class P03_TestingAnnotationConfiguration {

	public static void main(String[] args) throws DaoException {
		AnnotationConfigApplicationContext ctx;

		// create a spring-container using an annotation configuration
		// java class "AppConfig1".
		// Spring creates an instance of AppConfig1, and using that it calls
		// all the functions that are annotated with @Bean, collects the return
		// value from each one of them, and keeps as singleton beans in the
		// container. By default, the name of the function is the name of the bean as well.
		ctx = new AnnotationConfigApplicationContext(AppConfig4.class);
		
		ProductDao dao = ctx.getBean("dao", ProductDao.class);
		int pc = dao.count();
		
		System.out.println("There are " + pc + " products.");
		
		ctx.close();
	}

}
