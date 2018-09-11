package spring.training.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;
import spring.training.entity.Product;

@Repository("htDao")
@SuppressWarnings("unchecked")
public class HibernateTemplateProductDao implements ProductDao {

	@Autowired(required = false)
	private HibernateTemplate template;

	@Override
	public void addProduct(Product product) throws DaoException {
		template.persist(product);
	}

	@Override
	public Product getProduct(Integer productId) throws DaoException {
		return template.get(Product.class, productId);
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		if (product.getUnitPrice() < 0)
			throw new DaoException("Price can not be negative!");
		template.merge(product);
	}

	@Override
	public void deleteProduct(Integer productId) throws DaoException {
		Product p = getProduct(productId);
		if (p == null)
			throw new DaoException("Invalid id for deletion!");
		template.delete(p);
	}

	@Override
	public List<Product> getAll() throws DaoException {
		return (List<Product>) template.find("from Product");
	}

	@Override
	public List<Product> getProductsByCategoryId(Integer categoryId) throws DaoException {
		return (List<Product>) template.find("from Product where category.categoryId=?", categoryId);
	}

	@Override
	public List<Product> getProductsBySupplierId(Integer supplierId) throws DaoException {
		return (List<Product>) template.find("from Product where supplier.supplierId=?", supplierId);
	}

	@Override
	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
		return (List<Product>) template.find("from Product where unitPrice between ? and ?", min, max);
	}

	@Override
	public List<Product> getProductsNotInStock() throws DaoException {
		return (List<Product>) template.find("from Product where unitsInStock = 0");
	}

	@Override
	public List<Product> getProductsInStock() throws DaoException {
		return (List<Product>) template.find("from Product where unitsInStock > 0");
	}

	@Override
	public List<Product> getDiscontinuedProducts() throws DaoException {
		return (List<Product>) template.find("from Product where discontinued=1");
	}

	@Override
	public int count() throws DaoException {
		DetachedCriteria crit = DetachedCriteria.forClass(Product.class);
		crit.setProjection(Projections.rowCount());
		return new Integer(template.findByCriteria(crit).get(0).toString());
	}

}
