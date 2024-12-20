<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会員登録</title>
    <link rel="stylesheet" type="text/css" href="css/style2.css">
</head>
<body>
 <div class="background-video">
        <video autoplay muted loop id="background-video">
            <source src="video/background.mp4" type="video/mp4">
        </video>
    </div>

    <div class="container">
        <h2>会員登録</h2>

        <!-- エラーメッセージを表示 -->
        <c:if test="${not empty errorMessage}">
            <p style="color: red;">${errorMessage}</p>
        </c:if>

        <!-- 会員登録フォーム -->
        <form name="registerForm" action="RegisterServlet" method="post" onsubmit="return validateForm()">
            <label for="userId">ユーザーID:</label>
            <input type="text" name="userId" id="userId" value="${userId}" >
            
            <label for="password">パスワード:</label>
            <input type="password" name="password" id="password" value="${password}" >

            <label for="email">メールアドレス:</label>
            <input type="email" name="email" id="email" value="${email}" >

            <label for="name">名前:</label>
            <input type="text" name="name" id="name" value="${name}" >

            <label for="age">年齢:</label>
            <input type="number" name="age" id="age" value="${age}" >

            <input type="submit" value="登録">
            <input type="button" value="戻る" id="back" onclick="goBack()">
        </form>

        

    </div>
<script src="js/script.js" type="text/javascript"></script>
</body>
</html>
