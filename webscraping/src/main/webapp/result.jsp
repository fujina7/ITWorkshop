<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Product" %>

<html>
<head>
    <title>スクレイピング結果</title>
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
                <a href="<%= product.getUrl() %>"><%= product.getName() %></a><br>
                価格: <%= product.getPrice() %><br>
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
</body>
</html>
