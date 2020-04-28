package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer, Product>productMap = new HashMap<>();
    static {
        init();
    }
    private static void init() {
        Product product1 = new Product(1, "Fan", 200000, "BH 12 thang", "Seko");
        Product product2 = new Product(2, "Watch", 200000, "BH 12 thang", "Seko");
        Product product3 = new Product(3, "Fridge", 200000, "BH 12 thang", "Seko");
        Product product4 = new Product(4, "Glass", 200000, "BH 12 thang", "Seko");
        Product product5 = new Product(5, "Book", 200000, "BH 12 thang", "Seko");

        productMap.put(product1.getId(), product1);
        productMap.put(product2.getId(), product2);
        productMap.put(product3.getId(), product3);
        productMap.put(product4.getId(), product4);
        productMap.put(product5.getId(), product5);
    }
    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        productList.addAll(productMap.values());
        return productList;
    }

    @Override
    public Product findById(int productId) {
        return productMap.get(productId);
    }

    @Override
    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void remove(int productId) {
        productMap.remove(productId);
    }
}
