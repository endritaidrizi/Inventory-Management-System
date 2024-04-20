package service;

import config.HibernateConfig;
import converter.ProductConverter;
import dao.ProductDao;
import dao.ProductDaoImpl;
import dto.ProductRequest;
import entity.Product;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.function.AvgFunction;
import validator.ProductValidator;

import java.util.List;

public class ProductServiceImpl implements ProductService {
     SessionFactory sessionFactory= HibernateConfig.getSessionFactory();

    ProductDao productDao=new ProductDaoImpl(sessionFactory);
    @Override
    public void create(ProductRequest request) {//metoda create ka qellim te krijoje prod ne db
        // 1. therras valdidator
        ProductValidator.validateProduct(request);
        //2. bej konvertimin ne entitet qe te bej ruajtjen ne db
        Product product= ProductConverter.convertToEntity(request);
        //3. therras dao per persistencen
        productDao.save(product);
    }

    @Override
    public List<Product> displayAllProduct() {

        return productDao.findAll();
    }

}
