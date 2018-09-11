package spring.training.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.training.entity.Product;

public interface ProductDao {

	// CRUD operations
	@Transactional(readOnly = false, rollbackFor = { DaoException.class })
	public void addProduct(Product product) throws DaoException;

	public Product getProduct(Integer productId) throws DaoException;

	@Transactional(readOnly = false, rollbackFor = { DaoException.class }, propagation=Propagation.MANDATORY)
	public void updateProduct(Product product) throws DaoException;

	@Transactional(readOnly = false, rollbackFor = { DaoException.class })
	public void deleteProduct(Integer productId) throws DaoException;

	// Queries

	public List<Product> getAll() throws DaoException;

	public List<Product> getProductsByCategoryId(Integer categoryId) throws DaoException;

	public List<Product> getProductsBySupplierId(Integer supplierId) throws DaoException;

	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException;

	public List<Product> getProductsNotInStock() throws DaoException;

	public List<Product> getProductsInStock() throws DaoException;

	public List<Product> getDiscontinuedProducts() throws DaoException;

	public int count() throws DaoException;
}
