<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>スクレイピング結果</title>
    <!-- 外部CSSファイルの読み込み -->
    <link rel="stylesheet" type="text/css" href="css/style2.css">
</head>
<body>


   
    <div class="container">
     <h2>商品リスト</h2>
    <form action="ScrapeServlet" method="post">
        <label for="url">URL:</label>
        <input type="text" placeholder="URL" id="url" name="url" required/>
        <input type="submit" value="再取得" />
    </form>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
    
    <!-- ボタンとリンクを囲む親要素を追加 -->
<div id="button-container">
    <!-- 保存ボタンを追加 -->
    <form action="SaveProductsServlet" method="POST">
        <input type="hidden" name="action" value="save" />
        <button type="submit" id="save">商品情報を保存</button>
    </form>

    <a href="InputServlet" id="back">戻る</a>
</div>
</div>


    <!-- 商品リスト -->
    <div class="product-list">
        <% 
            List<Entity.Product> products = (List<Entity.Product>) request.getSession().getAttribute("products");

            if (products != null) {
                for (Entity.Product product : products) {
        %>
            <div class="product-card">
                <% if (product.getImageUrl() != null && !product.getImageUrl().equals("画像情報なし")) { %>
                    <img src="<%= product.getImageUrl() %>" alt="商品画像">
                <% } else { %>
                    <p>画像がありません。</p>
                <% } %>
                <div class="product-details">
                    <p>価格: <%= product.getPrice() %></p>
                    <a href="<%= product.getUrl() %>" id="product-link"><%= product.getName() %></a>
                </div>
            </div>
        <% 
            }
        } else {
        %>
            <p>商品情報がありません。</p>
        <% 
        }
        %>
    </div>
    
    
    <div class="container2">

    <!-- 保存ボタンを追加 -->
    <form action="SaveProductsServlet" method="POST">
        <input type="hidden" name="action" value="save" />
        <button type="submit"  id="save">商品情報を保存</button>
    </form>

    <a href="InputServlet" id="back">戻る</a>
    </div>
</body>
</html>
