package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class H2Database {

    // H2 Databaseに接続するメソッド
    public static Connection getConnection() throws Exception {
        String url = "jdbc:h2:~/desktop/SQL/sukkiriShop";  // H2データベースのURL（~/testはローカルのデータベース）
        String user = "sa";  // ユーザー名
        String password = "";  // パスワード
        return DriverManager.getConnection(url, user, password);
    }

    // 商品名と価格のセレクタを取得するメソッド（店舗名を気にせず）
    public static String[] getProductSelectors() {
        String[] selectors = null;
        String query = "SELECT product_name_selector, product_price_selector FROM product_selectors LIMIT 1"; // 1件だけ取得
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                selectors = new String[2];
                selectors[0] = rs.getString("product_name_selector");
                selectors[1] = rs.getString("product_price_selector");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return selectors;  // セレクタ情報を返す
    }
}
