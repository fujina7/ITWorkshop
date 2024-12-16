<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Product" %>

<html>
<head>
    <title>スクレイピング結果</title>
     <!-- 外部CSSファイルの読み込み -->
    <link rel="stylesheet" type="text/css" href="css/style2.css">
    
</head>
<body>
    <h2>商品リスト</h2>
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
 
    <ul>
    <% 
        // サーブレットから渡された商品リストを取得
        List<Entity.Product> products = (List<Entity.Product>) request.getSession().getAttribute("products");

        if (products != null) {
            for (Entity.Product product : products) {
    %>
    
        <li>
        
            <% if (product.getImageUrl() != null && !product.getImageUrl().equals("画像情報なし")) { %>
               　 <img src="<%= product.getImageUrl() %>" alt="商品画像" width="200" height="200"><br>
               
            <% } else { %>
                <p>画像がありません。</p>
            <% } %>
            　価格: <%= product.getPrice() %><br>
           　<a href="<%= product.getUrl() %>"><%= product.getName() %></a><br>
            
            <!-- 2行開けるために追加 -->
<br>
<br>


            
        </li>
    <% 
            }
        } else {
    %>
        <p>商品情報がありません。</p>
    <% 
        }
    %>
    </ul>

    <a href="InputServlet" id="back">戻る</a>
</body>
</html>
