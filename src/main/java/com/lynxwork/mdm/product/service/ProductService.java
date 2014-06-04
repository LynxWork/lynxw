package com.lynxwork.mdm.product.service;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.hcm.profile.service.ProfessionService;
import com.lynxwork.mdm.factory.MasterDataDaoFactory;
import com.lynxwork.mdm.product.dao.IProductDao;
import com.lynxwork.mdm.product.model.Product;
import com.lynxwork.persistance.exception.SaveEntityException;


public class ProductService {
	static final Logger log = Logger.getLogger(ProfessionService.class);
	
	public List<Product> findByProductld(String countryId){
		log.debug("init findByUserld");
		List<Product> productList = new ArrayList<Product>();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IProductDao productDao = daoFactory.getProductDao();
		productList = productDao.findByPersonld( countryId);
		log.debug("end findByUserld");
		return productList;
	}
	
	public ObjectId saveProduct(Product product) throws SaveEntityException{
		MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IProductDao productDao = masterDatadaoFactory.getProductDao();
		ObjectId oid = productDao.save(product);
		return oid;
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
	
	public Product findProductByUserId(String userId){
		Product product = new Product();
		MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IProductDao ProductDao = masterDatadaoFactory.getProductDao();
		ProductDao.findById(userId);
		return product;
	}
	
	
}

