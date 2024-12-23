<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEBスクレイピング</title>
 <!-- 外部CSSファイルの読み込み -->
    <link rel="stylesheet" type="text/css" href="css/style2.css">
    <script src="js/script.js" type="text/javascript"></script>

</head>
<body>

 <div class="background-video">
        <video autoplay muted loop id="background-video">
            <source src="video/background.mp4" type="video/mp4">
        </video>
    </div>



<div class="container">
<h1>WEBスクレイピングアプリ</h1>
  <!-- エラーメッセージの表示用DIV -->
  <%
    // セッションからメッセージを取得
    String registrationSuccess = (String) session.getAttribute("registrationSuccess");

    // メッセージが存在すればJavaScriptで表示
    if (registrationSuccess != null) {
%>
    <script type="text/javascript">
        // メッセージをアラートで表示
        alert('<%= registrationSuccess %>');
    </script>
<%
        // メッセージをセッションから削除
        session.removeAttribute("registrationSuccess");
    }
%>
    
  
 
 
<form action="LoginServlet" method="post" onsubmit="return validateForm()">
ID:<input type="text" placeholder="ユーザーID" name="userId" ><br>
パスワード:<input type="password" placeholder="パスワード" name="pass" ><br>
<input type="submit" value="ログイン" name="action" ><br><br>
<input type="submit" value="新規アカウント作成" name="action">
</form>
</div>


</body>
</html>