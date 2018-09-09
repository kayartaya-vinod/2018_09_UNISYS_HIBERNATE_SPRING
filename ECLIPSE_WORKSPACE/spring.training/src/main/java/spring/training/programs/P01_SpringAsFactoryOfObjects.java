package spring.training.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;

public class P01_SpringAsFactoryOfObjects {

	public static void main(String[] args) throws DaoException {
		// a variable representing the spring container
		ClassPathXmlApplicationContext ctx;
		
		// an instance of spring container
		// At this time, spring container creates instances for all 
		// bean definitions found in the XML, and for each class, 
		// there will always be a SINGLE object (singleton)
		ctx = new ClassPathXmlApplicationContext("context1.xml");
		System.out.println("Spring container instantiated!");
		
		System.out.println("Getting an object of ProductDao interface");
		ProductDao dao = ctx.getBean("dao", ProductDao.class);
		System.out.println("Got an object of ProductDao interface");
		
		
		ProductDao dao1 = ctx.getBean("dao", ProductDao.class);
		

		System.out.println("dao == dao1 is " + (dao==dao1));
		
		
		int pc = dao.count();
		
		System.out.println("There are " + pc + " products.");
		// close when application is about to terminate
		ctx.close();
	}

}
