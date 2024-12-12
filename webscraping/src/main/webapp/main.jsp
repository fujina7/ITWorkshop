<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <!-- エラーメッセージの表示用DIV -->
  
 
<form action="LoginServlet" method="post" onsubmit="return validateForm()">
ユーザーID:<input type="text" name="userId" ><br>
パスワード<input type="text" name="pass" ><br>
<input type="submit" value="ログイン" name="action" ><br><br>
<input type="submit" value="新規アカウント作成" name="action">
</form>
</div>


<script src="js/script.js"></script>
</body>
</html>