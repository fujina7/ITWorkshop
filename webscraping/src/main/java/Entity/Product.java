package Entity;

public class Product {
    private String name;
    private String price;
    private String url;

    // コンストラクタ
    public Product(String name, String price, String url) {
        this.name = name;
        this.price = price;
        this.url = url;
    }

    // Getterメソッド
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }
}
