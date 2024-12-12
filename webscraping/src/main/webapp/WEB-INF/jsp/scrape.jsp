<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>URL入力</title>
</head>
<body>
    <h2>スクレイピングURLを入力してください</h2>
    
    <form action="ScrapeServlet" method="post">
        <label for="url">URL:</label>
        <input type="text" id="url" name="url" />
        <input type="submit" value="スクレイピング" />
    </form>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
</body>
</html>
