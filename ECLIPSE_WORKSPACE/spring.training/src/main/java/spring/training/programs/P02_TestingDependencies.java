package spring.training.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;

public class P02_TestingDependencies {

	public static void main(String[] args) throws DaoException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context2.xml");
		ProductDao dao = ctx.getBean("dao", ProductDao.class);
	
		
		int pc = dao.count();
		System.out.println("There are " + pc + " products.");
		
		ctx.close();
	}

}
