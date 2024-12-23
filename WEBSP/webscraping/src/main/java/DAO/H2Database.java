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
        String url = "jdbc:h2:~/desktop/WEBSP/SQL_WS/ITWorkshop";  // H2データベースのURL
        String user = "sa";  // ユーザー名
        String password = "";  // パスワード
        return DriverManager.getConnection(url, user, password);
    }

    public static List<String[]> getProductSelectors() {
        List<String[]> selectorsList = new ArrayList<>();
        String query = "SELECT product_name_selector, product_price_selector, product_image_selector FROM product_selectors";  // 画像クラス名を追加

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String[] selectors = new String[3];  // 3つのカラム（商品名、価格、画像クラス名）
                selectors[0] = rs.getString("product_name_selector");
                selectors[1] = rs.getString("product_price_selector");
                selectors[2] = rs.getString("product_image_selector");  // 画像クラス名を取得
                selectorsList.add(selectors);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return selectorsList;  // すべてのセレクタ情報をリストとして返す
    }


}
