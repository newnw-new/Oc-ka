package Product;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(Product product) {
        this.name = product.name;
        this.price = product.price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String Description() {
        return "Название: " + name + " Цена: " + price;
    }

}
