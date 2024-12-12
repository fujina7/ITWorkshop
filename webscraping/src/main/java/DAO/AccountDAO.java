package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Account;
import Entity.Login;

public class AccountDAO {
    // データベース接続に使用する情報
    private final String JDBC_URL = "jdbc:h2:~/desktop/SQL/sukkiriShop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "";

    // ログイン情報をもとにアカウントを取得するメソッド
    public Account findByLogin(Login login) {
        Account account = null;
        // JDBCドライバを読み込む
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }

        // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNTS WHERE USER_ID = ? AND PASS = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, login.getUserId());
            pStmt.setString(2, login.getPass());

            // SELECTを実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();

            if (rs.next()) {
                // ユーザーが存在したらデータを取得
                // そのユーザーを表すAccountインスタンスを生成
                String userId = rs.getString("USER_ID");
                String pass = rs.getString("PASS");
                String mail = rs.getString("MAIL");
                String name = rs.getString("NAME");
                int age = rs.getInt("AGE");
                account = new Account(userId, pass, mail, name, age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return account;
    }

    // 新しいアカウントを登録するメソッド
    public boolean registerAccount(Account account) {
        // アカウント登録のためのSQL文
        String sql = "INSERT INTO ACCOUNTS (USER_ID, PASS, MAIL, NAME, AGE) VALUES (?, ?, ?, ?, ?)";

        // JDBCドライバを読み込む
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }

        // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, account.getUserId());  // ユーザーID
            pStmt.setString(2, account.getPass());    // パスワード
            pStmt.setString(3, account.getMail());    // メール
            pStmt.setString(4, account.getName());    // 名前
            pStmt.setInt(5, account.getAge());        // 年齢

            int rowsAffected = pStmt.executeUpdate(); // INSERTを実行

            // 1行以上挿入された場合、成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // 失敗した場合はfalseを返す
        }
    }
}
