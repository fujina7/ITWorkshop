// scripts.js

function validateForm() {
    // ユーザーID、パスワード、メールアドレス、名前、年齢の各フィールドを取得
    var userId = document.forms["registerForm"]["userId"].value;
    var password = document.forms["registerForm"]["password"].value;
    var email = document.forms["registerForm"]["email"].value;
    var name = document.forms["registerForm"]["name"].value;
    var age = document.forms["registerForm"]["age"].value;

    // ユーザーID、名前、年齢が空でないことを確認
    if (userId == "" || name == "" || age == "") {
        alert("ユーザーID、名前、年齢は必須です。");
        return false;
    }

    // パスワードが4桁以上の数字であることを確認
    var passwordRegex = /^[a-zA-Z0-9!@#$%^&*]{4,}$/; // 4文字以上の英数字および一部記号
    if (!passwordRegex.test(password)) {
        alert("パスワードは4桁以上の数字でなければなりません。");
        return false;
    }

    // メールアドレスの形式を確認
    var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailRegex.test(email)) {
        alert("メールアドレスの形式が正しくありません。");
        return false;
    }

    // すべての検証が通った場合はフォームを送信
    return true;
}
