package converter;

import dto.ProductRequest;
import entity.Product;

public class ProductConverter {
    public static Product
    convertToEntity(ProductRequest request) {
        Product product = new Product();
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        return product;
    }
}