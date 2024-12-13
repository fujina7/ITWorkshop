package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class H2Database {

    // H2 Databaseに接続するメソッド
    public static Connection getConnection() throws Exception {
        String url = "jdbc:h2:~/desktop/SQL/sukkiriShop";  // H2データベースのURL（~/testはローカルのデータベース）
        String user = "sa";  // ユーザー名
        String password = "";  // パスワード
        return DriverManager.getConnection(url, user, password);
    }

    public static List<String[]> getProductSelectors() {
        List<String[]> selectorsList = new ArrayList<>();
        String query = "SELECT product_name_selector, product_price_selector FROM product_selectors";  // すべてのセレクタ情報を取得
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String[] selectors = new String[2];
                selectors[0] = rs.getString("product_name_selector");
                selectors[1] = rs.getString("product_price_selector");
                selectorsList.add(selectors);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return selectorsList;  // すべてのセレクタ情報をリストとして返す
    }


    
 // すべての商品セレクタ情報を取得するメソッド
    public static List<String[]> getAllProductSelectors() {
        List<String[]> selectorsList = new ArrayList<>();
        String query = "SELECT product_name_selector, product_price_selector FROM product_selectors";  // すべてのセレクタ情報を取得
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String[] selectors = new String[2];
                selectors[0] = rs.getString("product_name_selector");
                selectors[1] = rs.getString("product_price_selector");
                selectorsList.add(selectors);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return selectorsList;  // すべてのセレクタ情報をリストとして返す
    }
}
    

