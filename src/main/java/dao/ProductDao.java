package dao;

import entity.Product;

import java.util.List;

public interface ProductDao {
   //metodat e save dhe find
    void save(Product product);
    List<Product> findAll();
     Product findById(Long id);
}
