package spring.training.dao.impl;

import spring.training.dao.DaoException;
import spring.training.dao.ProductDao;

public class CsvProductDao implements ProductDao {

	@Override
	public int count() throws DaoException {
		return 234;
	}

}
