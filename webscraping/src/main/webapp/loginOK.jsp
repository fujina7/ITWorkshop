<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
 <!-- 外部CSSファイルの読み込み -->
    <link rel="stylesheet" type="text/css" href="css/style2.css">

</head>
<body>
<div class="container">

<p>ようこそ<c:out value="${userId}" />さん</p>
<a href="InputServlet">アプリ起動</a>

<a href="WelcomeServlet" id="back">トップへ</a>

</div>
</body>
</html>