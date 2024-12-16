package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import DAO.H2Database;
import DAO.ProductDAO;  // ProductSaverをインポート
import Entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ScrapeServlet")
public class ScrapeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // スクレイピング処理（起動時に1回だけ実行）
    private void startScraping(String url, HttpServletRequest request) {
        // 商品情報を取得するためにスクレイピングを実行
        List<Product> products = scrapeProducts(url);

        // セッションに結果を保存
        HttpSession session = request.getSession();
        session.setAttribute("products", products);

        // 商品情報をデータベースに保存
        ProductDAO.saveProducts(products);  // 商品情報を一括でデータベースに保存

        // デバッグ用: セッションに保存された商品数を確認
        System.out.println("Saved " + products.size() + " products to session and database.");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");

        if (url != null && !url.isEmpty()) {
            // スクレイピングを一度だけ開始する
            startScraping(url, request);  // URLを渡す
            response.sendRedirect("result.jsp");  // 結果表示ページに遷移
        } else {
            // エラーメッセージ
            request.setAttribute("error", "URLが正しくありません。");
            request.getRequestDispatcher("/scrape.jsp").forward(request, response);
        }
    }

    // 商品情報をスクレイピングするメソッド（例：Jsoupを使用）
    private List<Product> scrapeProducts(String url) {
        List<Product> products = new ArrayList<>();
        try {
            // H2データベースからセレクタ情報を取得
            List<String[]> selectorsList = H2Database.getProductSelectors(); 
            if (selectorsList == null || selectorsList.isEmpty()) {
                throw new Exception("セレクタ情報が見つかりませんでした。");
            }

            // Jsoupを使ってHTMLを解析
            Document doc = Jsoup.connect(url).get();

            // 各セレクタ情報でスクレイピングを実行
            for (String[] selectors : selectorsList) {
                String productNameSelector = selectors[0]; 
                String productPriceSelector = selectors[1];
                String productImageSelector = selectors[2];  // 画像のクラス名（例: image--4OaFX）

                // セレクタを使って商品情報を取得
                Elements productElements = doc.select(productNameSelector);
                Elements priceElements = doc.select(productPriceSelector);
                Elements imageElements = doc.select("img." + productImageSelector);  // 画像クラス名を使って画像要素を取得

                int count = 0;
                for (int i = 0; i < productElements.size(); i++) {
                    if (count >= 25) {
                        break;
                    }

                    // 商品名を取得
                    String name = productElements.get(i).text();

                    // 価格を取得
                    String price = (i < priceElements.size()) ? priceElements.get(i).text() : "価格情報なし";

                    // 画像URLを取得（src属性）
                    String imageUrl = (i < imageElements.size()) ? imageElements.get(i).attr("src") : "画像情報なし";

                    // 相対URLを絶対URLに変換
                    if (!imageUrl.startsWith("http")) {
                        imageUrl = url + imageUrl;  // 相対URLを絶対URLに変換
                    }

                    // 商品URL（詳細ページ）の取得
                    String relativeUrl = productElements.get(i).select("a").attr("href");
                    String productUrl = relativeUrl.startsWith("http") ? relativeUrl : url + relativeUrl;

                    // 商品情報をProductオブジェクトとして格納
                    products.add(new Product(name, price, productUrl, imageUrl));
                    count++;
                    
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
