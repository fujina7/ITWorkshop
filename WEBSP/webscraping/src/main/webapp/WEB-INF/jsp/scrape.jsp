<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>URL入力</title>
     <!-- 外部CSSファイルの読み込み -->
    <link rel="stylesheet" type="text/css" href="css/style2.css">
    
</head>
<body>
 <div class="background-video">
        <video autoplay muted loop id="background-video">
            <source src="video/background.mp4" type="video/mp4">
        </video>
    </div>

<div class="container">
    <h2>スクレイピングURLを入力してください</h2>
    
    <form action="ScrapeServlet" method="post">
        <label for="url">URL:</label>
        <input type="text" placeholder="URL" id="url" name="url" required/>
        <input type="submit" value="取得開始" />
    </form>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
     <a href="LogoutServlet" id="back">ログアウト</a>
     </div>
     
     <script src="js/script.js" type="text/javascript"></script>
</body>
</html>
