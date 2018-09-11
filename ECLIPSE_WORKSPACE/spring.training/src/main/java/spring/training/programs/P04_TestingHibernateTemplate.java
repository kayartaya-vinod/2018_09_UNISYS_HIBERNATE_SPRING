package spring.training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import spring.training.cfg.AppConfig5;
import spring.training.entity.Product;

public class P04_TestingHibernateTemplate {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig5.class);

		HibernateTemplate ht = ctx.getBean("ht", HibernateTemplate.class);
		Product p = ht.get(Product.class, 1);
		ctx.close();
		
		System.out.println("Name of the product = " + p.getProductName());
		System.out.println("Name of the category = " + p.getCategory().getCategoryName());
		System.out.println("Name of the supplier = " + p.getSupplier().getCompanyName());
		System.out.println("Price of the product = $" + p.getUnitPrice());
	}

}
