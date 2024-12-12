package servlet;

import java.io.IOException;

import Entity.Login;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ログインページへ遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        String pass = request.getParameter("pass");

        // ログイン処理の実行
        Login login = new Login(userId, pass);
        LoginLogic bo = new LoginLogic();
        boolean result = bo.execute(login);

        // アクションパラメータの取得
        String action = request.getParameter("action");

        // 新規アカウント作成画面に遷移
        if ("新規アカウント作成".equals(action)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
            dispatcher.forward(request, response);
        } // 入力チェック: userId と pass が空でないことを確認
        else if (userId == null || userId.isEmpty() || pass == null || pass.isEmpty()) {
            // 入力が不足している場合はエラーメッセージを表示
            request.setAttribute("error", "ユーザーIDまたはパスワードが入力されていません。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginNG.jsp");
            dispatcher.forward(request, response);
            return; // 処理を中止
        } else if (result) {
            // ログイン成功時
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            response.sendRedirect("loginOK.jsp"); // Redirect to MainServlet
        } else {
            // ログイン失敗時にエラーメッセージをURLパラメータとして追加してリダイレクト
            response.sendRedirect("loginNG.jsp?error=1");
        }
    }
}
