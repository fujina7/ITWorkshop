// scripts.js

function validateForm() {
    // ユーザーID、パスワード、メールアドレス、名前、年齢の各フィールドを取得
    var userId = document.forms["registerForm"]["userId"].value;
    var password = document.forms["registerForm"]["password"].value;
    var email = document.forms["registerForm"]["email"].value;
    var name = document.forms["registerForm"]["name"].value;
    var age = document.forms["registerForm"]["age"].value;

    // ユーザーID、名前、年齢が空でないことを確認
    if (userId == "" || name == "" || age == ""  || password == "" || email == "") {
        alert("ユーザーID、パスワード、メールアドレス、名前、年齢は必須です。");
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
function limitAgeInput() {
        const inputField = document.getElementById('age');
        let value = inputField.value;

        // 最初の1文字が"0"なら削除
        if (value.length === 1 && value === '0') {
            inputField.value = '';  // "0"だけの場合は入力をクリア
            return;
        }

        // 数字以外の文字を削除
        value = value.replace(/\D/g, '');  // 数字以外を削除

        // 最初の文字が"0"の場合、それ以降の数字を入力させる
        if (value.charAt(0) === '0') {
            value = value.slice(1);  // "0"を削除
        }

        // 2桁以内に制限
        if (value.length > 2) {
            value = value.slice(0, 2);  // 最大2桁まで制限
        }

        // フィールドに制限された値を再設定
        inputField.value = value;
    }
    
function showRegistrationMessage(message) {
    if (message && message.trim() !== "") { // メッセージが空でない場合のみ表示
        alert(message); // メッセージをアラートで表示
    }
}



function goBack() {
        // main.jsp に遷移する
        window.location.href = 'main.jsp';
    }
            