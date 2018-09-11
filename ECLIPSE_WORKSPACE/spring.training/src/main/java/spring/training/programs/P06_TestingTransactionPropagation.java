package spring.training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.training.cfg.AppConfig6;
import spring.training.dao.DaoException;
import spring.training.service.ProductManager;

public class P06_TestingTransactionPropagation {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig6.class);
		ProductManager mgr = ctx.getBean(ProductManager.class);

		try {
			mgr.updatePrices();
			System.out.println("Prices updated!");
		} catch (DaoException e) {
			System.out.println("failed due to : " + e.getMessage());
		}
		
		ctx.close();
	}
}
