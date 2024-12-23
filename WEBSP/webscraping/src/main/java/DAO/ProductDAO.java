package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entity.Product;
import helper.UrlNormalizer;

public class ProductDAO {

    // H2データベースに接続するメソッド
    private static Connection getConnection() throws SQLException {
        String url = "jdbc:h2:~/desktop/WEBSP/SQL_WS/ITWorkshop";  // H2データベースのURL
        String user = "sa";  // ユーザー名
        String password = "";  // パスワード
        return DriverManager.getConnection(url, user, password);
    }

    // 商品情報をデータベースに保存するメソッド
    public static void saveProduct(Product product) {
        // 商品のURLが既に存在するか確認するSQLクエリ
        String checkQuery = "SELECT COUNT(*) FROM products WHERE product_url = ?";

        try (Connection conn = getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {

            // 商品URLを正規化
            String normalizedUrl = UrlNormalizer.normalizeUrl(product.getUrl());

            // 正規化されたURLをチェック
            checkStmt.setString(1, normalizedUrl);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                // URLが存在しない場合のみ商品を挿入
                String insertQuery = "INSERT INTO products (name, price, product_url, image_url) VALUES (?, ?, ?, ?)";
                try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                    insertStmt.setString(1, product.getName());
                    insertStmt.setString(2, product.getPrice());
                    insertStmt.setString(3, normalizedUrl); // 正規化されたURLを保存
                    insertStmt.setString(4, product.getImageUrl());  // 画像URLを保存
                    insertStmt.executeUpdate();
                    System.out.println("商品情報がデータベースに保存されました: " + product.getName());
                }
            } else {
                System.out.println("URLが重複しているため保存されませんでした: " + product.getUrl());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 商品リストを一括でデータベースに保存するメソッド
    public static void saveProducts(List<Product> products) {
        for (Product product : products) {
            // 商品URLを正規化してから保存
            String normalizedUrl = UrlNormalizer.normalizeUrl(product.getUrl());
            saveProductWithNormalizedUrl(product, normalizedUrl);
        }
    }

    // 商品URLを正規化して保存するメソッド
    private static void saveProductWithNormalizedUrl(Product product, String normalizedUrl) {
        // 商品情報をデータベースに保存するメソッド
        // 商品のURLが既に存在するか確認するSQLクエリ
        String checkQuery = "SELECT COUNT(*) FROM products WHERE product_url = ?";

        try (Connection conn = getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {

            // 正規化されたURLをチェック
            checkStmt.setString(1, normalizedUrl);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                // URLが存在しない場合のみ商品を挿入
                String insertQuery = "INSERT INTO products (name, price, product_url, image_url) VALUES (?, ?, ?, ?)";
                try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                    insertStmt.setString(1, product.getName());
                    insertStmt.setString(2, product.getPrice());
                    insertStmt.setString(3, normalizedUrl); // 正規化されたURLを保存
                    insertStmt.setString(4, product.getImageUrl());  // 画像URLを保存
                    insertStmt.executeUpdate();
                    System.out.println("商品情報がデータベースに保存されました: " + product.getName());
                }
            } else {
                System.out.println("URLが重複しているため保存されませんでした: " + product.getUrl());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
