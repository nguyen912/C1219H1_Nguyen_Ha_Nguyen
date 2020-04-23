package services;

import model.Product;

import javax.servlet.jsp.el.ImplicitObjectELResolver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer, Product> productMap = new HashMap<>();
    //id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất
    static {
        productMap.put(1, new Product(1, "Fan", 200000, "Warranty 12 months", "Seko"));
        productMap.put(2, new Product(2, "Sofa", 5000000, "No warranty", "Tien Hung"));
        productMap.put(3, new Product(3, "Fridge", 7000000, "Warranty 12 months", "Sanyo"));
        productMap.put(4, new Product(4, "Table", 2000000, "No warranty", "Duc Hoang"));
        productMap.put(5, new Product(5, "Smartphone", 2500000, "Warranty 18 months", "Vsmart"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
