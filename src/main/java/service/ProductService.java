package service;

import dto.ProductRequest;
import entity.Product;

import java.util.List;

public interface ProductService {
    void create (ProductRequest request);

    List<Product> displayAllProduct();
}
