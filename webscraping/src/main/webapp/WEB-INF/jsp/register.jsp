<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会員登録</title>
    
    <!-- 外部CSSファイルの読み込み -->
    <link rel="stylesheet" type="text/css" href="css/style2.css">
</head>
<body>

    <div class="container">
        <h2>会員登録</h2>
       

        <!-- 会員登録フォーム -->
        <form name="registerForm" action="RegisterServlet" method="post" onsubmit="return validateForm()">
            <label for="userId">ユーザーID:</label>
            <input type="text" name="userId" id="userId" required>

            <label for="password">パスワード:</label>
            <input type="password" name="password" id="password" required>

            <label for="email">メールアドレス:</label>
            <input type="email" name="email" id="email" required>

            <label for="name">名前:</label>
            <input type="text" name="name" id="name" required>

            <label for="age">年齢:</label>
            <input type="number" name="age" id="age" required>

            <input type="submit" value="登録">
           <input type="button" value="戻る" id="back" onclick="window.history.back()">
        </form> 

    </div>

    <!-- 外部JavaScriptファイルの読み込み -->
    <script type="text/javascript" src="../js/script.js"></script>

</body>
</html>
