package client;
import dto.ProductRequest;
import entity.Product;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inventory Managment System");
        System.out.println("Shtyp 1 per to Add product");
        System.out.println("Shtyp 2 per te marre all products");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                createProduct(sc);
                break;
            case 2:
                displayAllProduct();
                break;
        }
    }

    public static void displayAllProduct(){
        ProductService productService = new ProductServiceImpl();

        for (Product product: productService.displayAllProduct()) {
            System.out.println(product);
        }

    }


    public static void createProduct(Scanner scanner) {
        ProductRequest productRequest = new ProductRequest();
        System.out.println("Ju lutem fusni emrin e produktit");
        productRequest.setName(scanner.next());
        System.out.println("Ju lutem fusni pershkrimin e produktit");
        productRequest.setDescription(scanner.next());
        System.out.println("Ju lutem fusni ID e categorise");
        productRequest.setCategoryId(scanner.nextLong());
        System.out.println("Ju lutem fusni cmimin e produktit");
        productRequest.setPrice(scanner.nextDouble());
        System.out.println("Ju lutem fusni sasine e produktit");
        productRequest.setQuantity(scanner.nextInt());
        ProductService productService = new ProductServiceImpl();
        productService.create(productRequest);
    }
}