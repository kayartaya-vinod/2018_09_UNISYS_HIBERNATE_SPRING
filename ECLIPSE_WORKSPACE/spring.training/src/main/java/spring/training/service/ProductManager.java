package spring.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;
import spring.training.entity.Product;

@Service
public class ProductManager {

	@Autowired
	@Qualifier("htDao")
	private ProductDao dao;

	@Transactional(readOnly = false, rollbackFor = { DaoException.class })
	public void updatePrices() throws DaoException {
		Product p1, p2, p3;

		p1 = dao.getProduct(1);
		p1.setUnitPrice(18.0);
		dao.updateProduct(p1);

		p2 = dao.getProduct(2);
		p2.setUnitPrice(18.0);
		dao.updateProduct(p2);

		p3 = dao.getProduct(3);
		p3.setUnitPrice(-18.0);		// should cancel transaction
		dao.updateProduct(p3);

	}

}
