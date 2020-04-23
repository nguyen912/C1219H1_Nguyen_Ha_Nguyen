package model;

public class Product {
    //id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất
    private String id;
    private String name;
    private long price;
    private String description;
    private String productionCompany;

    public Product() {
    }

    public Product(String id, String name, long price, String description, String productionCompany) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.productionCompany = productionCompany;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }
}
