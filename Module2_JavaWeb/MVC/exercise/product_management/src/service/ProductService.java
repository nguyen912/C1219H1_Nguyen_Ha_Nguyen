package service;

import model.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    List<Product> findAll();
    Product findById(int productId);
    void update(Product product);
    void remove(int productId);
}
