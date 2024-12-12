<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>出品検知アプリ</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/JisakuApp/css/style.css">
    
</head>
<body>
    <h1>出品検知</h1>

    <!-- URL入力フォーム -->
    <form action="ScrapeServlet" method="post">
        <label for="url">URLを入力してください:</label>
        <input type="text" id="url" name="url">
        <br><br>

        <!-- 開始ボタン -->
        <button type="submit" name="action" value="start" ${status == 'stopped' ? 'disabled' : ''}>開始</button>
        <!-- 停止ボタン -->
        <button type="submit" name="action" value="stop" ${status == 'stopped' ? 'disabled' : ''}>停止</button>
    </form>

    <hr>

    <%-- errorメッセージが存在する場合、表示する --%>
<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>

<%-- スクレイピング結果を表示する --%>
<c:if test="${status == 'started'}">
    <h2>出品検知を開始中...</h2>b                                                                                                                                                                                                                                                                                                                                                                                                                             
    <p>タイトル: ${title}</p>
    <p>内容: ${content}</p>
</c:if>

<c:if test="${status == 'stopped'}">
    <h2>検知機能を停止しました</h2>
</c:if>

    <hr>
    <a href="LoginServlet">ホームに戻る</a>
</body>
</html>
