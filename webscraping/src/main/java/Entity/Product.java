package Entity;

public class Product {
    private String name;
    private String price;
    private String url;
    private String imageUrl;  // 画像URLを追加

    // コンストラクタ
    public Product(String name, String price, String url, String imageUrl) {
        this.name = name;
        this.price = price;
        this.url = url;
        this.imageUrl = imageUrl;  // 画像URLを初期化
    }

    // ゲッターとセッター
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;  // 画像URLを取得
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;  // 画像URLを設定
    }
}
