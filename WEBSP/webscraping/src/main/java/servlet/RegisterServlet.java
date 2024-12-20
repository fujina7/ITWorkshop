package servlet;

import java.io.IOException;

import DAO.AccountDAO;
import Entity.Account;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの取得
        String userId = request.getParameter("userId");
        String pass = request.getParameter("password");
        String mail = request.getParameter("email");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        // Accountオブジェクトを作成
        Account account = new Account(userId, pass, mail, name, age);

        // 入力内容をリクエストに保存（フォームに戻すため）
        request.setAttribute("userId", userId);
        request.setAttribute("password", pass);
        request.setAttribute("email", mail);
        request.setAttribute("name", name);
        request.setAttribute("age", age);

       

        // AccountDAOを使用してアカウントを登録
        AccountDAO dao = new AccountDAO();
        boolean isSuccess = dao.registerAccount(account);

        if (isSuccess) {
            // 登録成功時の処理
            HttpSession session = request.getSession();
            session.setAttribute("registrationSuccess", "新規登録完了です！");

            // main.jspにリダイレクト
            response.sendRedirect("main.jsp");
        } else {
            // 登録失敗時の処理
            request.setAttribute("errorMessage", "登録に失敗しました。ユーザーIDがすでに存在する可能性があります。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
            dispatcher.forward(request, response);
        }
    }
}
