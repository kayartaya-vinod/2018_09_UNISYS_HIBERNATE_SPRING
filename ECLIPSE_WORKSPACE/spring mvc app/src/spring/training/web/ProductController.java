package spring.training.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;
import spring.training.entity.Product;

@RequestMapping("/api/products")
@RestController
public class ProductController {

	@Autowired
	private ProductDao htDao; // autowires by default byName (name of variable == name of bean)

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Product getProductById(@PathVariable Integer id) throws DaoException {
		return htDao.getProduct(id);
	}

	// handler for XML requests
	@RequestMapping(method = RequestMethod.GET, produces = { "application/xml" })
	public ProductList getAllProductsAsXml() throws DaoException {
		return new ProductList(htDao.getAll());
	}

	// handler for JSON requests
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
	public List<Product> getAllProducts() throws DaoException {

		List<Product> list = htDao.getAll();
		System.out.println("There are " + list.size() + " products");

		return list;
	}

}
