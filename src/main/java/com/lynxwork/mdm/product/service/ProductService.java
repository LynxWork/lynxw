package com.lynxwork.mdm.product.service;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.hcm.profile.service.ProfessionService;
import com.lynxwork.mdm.product.dao.IProductDao;
import com.lynxwork.mdm.product.model.Product;


public class ProductService {
	static final Logger log = Logger.getLogger(ProfessionService.class);
	
	public List<Product> findByUserld(String productName){
		log.debug("init findByUserld");
		List<Product> productList = new ArrayList<Product>();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IProductDao productDao = daoFactory.getProductDao();
		productList = productDao.findByUserld( productName);
		log.debug("end findByUserld");
		return productList;
	}
	
	public Product findById(String productId){
		log.debug("init findById");
		Product product = new Product();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IProductDao productDao = daoFactory.getProductDao();
		product = productDao.findById(productId);
		log.debug("end findById");
		return product;
	}
	
	
}

