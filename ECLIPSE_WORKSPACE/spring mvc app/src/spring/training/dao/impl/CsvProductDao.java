package spring.training.dao.impl;

import java.util.List;

import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;
import spring.training.entity.Product;

public class CsvProductDao implements ProductDao {

	@Override
	public int count() throws DaoException {
		return 234;
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
