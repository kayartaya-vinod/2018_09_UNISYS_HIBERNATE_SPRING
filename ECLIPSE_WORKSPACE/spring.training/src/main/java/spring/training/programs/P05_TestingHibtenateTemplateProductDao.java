package spring.training.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.training.cfg.AppConfig6;
import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;
import spring.training.entity.Product;

public class P05_TestingHibtenateTemplateProductDao {

	public static void main(String[] args) throws DaoException {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig6.class);

		ProductDao dao = ctx.getBean("htDao", ProductDao.class);
		System.out.println("dao is an instanceof " + dao.getClass());

		Product p = dao.getProduct(1);
		System.out.println("Name   = " + p.getProductName());
		System.out.println("Price  = $" + p.getUnitPrice());
		
		try {
			p.setUnitPrice(p.getUnitPrice() + 1);
			dao.updateProduct(p);
		} catch (DaoException e) {
			System.out.println("Could not update product due to an error: " + e.getMessage());
		}

		List<Product> list = dao.getProductsByPriceRange(50.0, 200.0);
		System.out.println("There are " + list.size() + " products between $50 and $200.");

		list = dao.getProductsByPriceRange(200.0, 50.0);
		System.out.println("There are " + list.size() + " products between $200 and $50.");

		int pc = dao.count();
		System.out.println("There are " + pc + " products.");

		ctx.close();
	}

}
