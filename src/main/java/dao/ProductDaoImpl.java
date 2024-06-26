package dao;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDaoImpl  implements ProductDao {

    private final SessionFactory sessionFactory;

    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product product) {

        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (Exception e) {
            System.out.println(e.getCause());
        }

    }



    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT a FROM Product a", Product.class).getResultList();
    }


    @Override
    public Product findById(Long id) {
        return null;
    }
}
