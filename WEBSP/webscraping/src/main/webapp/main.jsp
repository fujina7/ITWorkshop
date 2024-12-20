<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEBスクレイピング</title>
 <!-- 外部CSSファイルの読み込み -->
    <link rel="stylesheet" type="text/css" href="css/style2.css">
    

</head>
<body>



<div class="container">
<h1>WEBスクレイピングアプリ</h1>
  <!-- エラーメッセージの表示用DIV -->
  <!-- 登録完了メッセージの表示 -->
    <c:if test="${not empty sessionScope.registrationSuccess}">
        <p style="color: green;">${sessionScope.registrationSuccess}</p>
        <!-- 登録完了メッセージを表示した後はセッションから削除 -->
        <c:remove var="registrationSuccess"/>
    </c:if>
 
<form action="LoginServlet" method="post" onsubmit="return validateForm()">
ユーザーID:<input type="text" name="userId" ><br>
パスワード<input type="text" name="pass" ><br>
<input type="submit" value="ログイン" name="action" ><br><br>
<input type="submit" value="新規アカウント作成" name="action">
</form>
</div>
</body>
</html>