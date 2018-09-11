package spring.training.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;
import spring.training.entity.Product;

@Component("dao")
public class JdbcProductDao implements ProductDao {

	private String driver;
	private String url;
	private String username;
	private String password;

	@Qualifier("h2Dbcp")
	@Autowired(required = false)
	private DataSource dataSource; // import from javax.sql package

	// spring uses this constructor by default when creating an object
	// from an XML configuration
	public JdbcProductDao() {
	}

	// we can ask spring to invoke this constructor, by supplying (injecting)
	// values for the private fields. This is known as constructor-injection
	public JdbcProductDao(String driver, String url, String username, String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public JdbcProductDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// A setter is also known as a mutator, writable property
	// Spring can inject values via a setter, and is called setter-injection
	// or property injection.
	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDataSource(DataSource dataSource) {
		System.out.println("setDataSource() called...");
		this.dataSource = dataSource;
	}

	// writable property called "dbcp", spring can use this for injecting value of
	// type DataSource
	public void setDbcp(DataSource dataSource) {
		System.out.println("setDbcp() called...");
		this.dataSource = dataSource;
	}

	private Connection createConnection() throws Exception {

		if (dataSource != null) {
			return dataSource.getConnection(); // a connection from the pool
		}

		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public int count() throws DaoException {
		String sql = "select count(*) from products";
		try (Connection conn = createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			rs.next();
			return rs.getInt(1);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public void addProduct(Product product) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public Product getProduct(Integer productId) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public void deleteProduct(Integer productId) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getAll() throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getProductsByCategoryId(Integer categoryId) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getProductsBySupplierId(Integer supplierId) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getProductsNotInStock() throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getProductsInStock() throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	@Override
	public List<Product> getDiscontinuedProducts() throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

}
