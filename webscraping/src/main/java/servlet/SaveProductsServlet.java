package servlet;

import java.io.IOException;
import java.util.List;

import DAO.ProductDAO;  // ProductDAOクラスをインポート
import Entity.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SaveProductsServlet")
public class SaveProductsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 保存ボタンが押されたかどうかを確認
        String action = request.getParameter("action");

        // 保存ボタンが押された場合
        if ("save".equals(action)) {
            // セッションから商品リストを取得
            List<Product> products = (List<Product>) request.getSession().getAttribute("products");

            // 商品リストが存在する場合、保存処理を行う
            if (products != null && !products.isEmpty()) {
                // 商品リストをデータベースに保存
                ProductDAO.saveProducts(products);
                request.setAttribute("message", "商品情報が保存されました！");
            } else {
                request.setAttribute("error", "商品情報が空です。");
            }
        }

        // 保存後の結果をJSPに表示するため、JSPページに転送
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
