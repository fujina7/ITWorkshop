# プロジェクト名　　webscrapingアプリ

<div id="top"></div>
## 項目

1. [プロジェクトについて](#プロジェクトについて)
2. [動作環境](#環境)
3. [デモ画面](#デモ画面)
4. [実行準備](#実行準備)

<!-- プロジェクトについて -->

## プロジェクトについて
授業の一環としてWebアプリケーションを作成しました。 <br>


・<span style="color: #ADD8E6;">ターゲットユーザー</span> <br>
　　ショップで検索した商品情報を取得して、別々のショップ同士での価格の比較を行いたい方　<br>
・<span style="color: #ADD8E6;">アプリ導入による効果</span> <br>
　　価格比較したいショップをピンポイントに選択できる　<br>
・<span style="color: #ADD8E6;">所感</span> <br>
　　アプリの機能自体は想像通りのものを実装できましたが、最終的には、保存した商品情報をブラウザ上に表示、価格順などの並び変え等の機能を実装する予定でしたが、時間が足りなく見送りました。 <br>
<p align="right">(<a href="#top">トップへ</a>)</p>

## 環境
<!-- シールド一覧 -->
<p style="display: inline">
  <!-- バックエンドの言語一覧 -->
  <img src="https://img.shields.io/badge/-java-F2C63C.svg?logo=java&style=for-the-badge">
</p>

<!-- 言語、フレームワーク、ミドルウェア、インフラの一覧とバージョンを記載 -->
- バックエンド
    - java
    - H2 Database
    - Apache Tomcat (Tomcat9_Java17)
- フロントエンド
    - HTML
    - CSS
    - javascript
    

<p align="right">(<a href="#top">トップへ</a>)</p>

## デモ画面
![TOP](images/main.png)<br>
【トップ画面】スタート画面です。<br>

![REGISTER](images/register.png)<br>
【登録画面】会員登録の画面です。<br>

![INPUT](images/input.png)<br>
【入力画面】サイトURLの入力画面です。<br>

![RESULT](images/result.png)<br>
【結果画面】サイトURL情報取得の結果画面です。 <br>

<p align="right">(<a href="#top">トップへ</a>)</p>


## 実行準備
0.　　<span style="color:rgb(187, 77, 14);">※必ず利用前にreadme.txtをご確認ください。</span>

1.　　.Githubからリポジトリをクローン <br>

2.　　Eclipseに「webscraping」をインポート <br>

3_1.　SQLフォルダをデスクトップ上に配置し、中の「ITWorkshop_test.mv.db」の名前を「ITWorkshop.mv.db」に変更する<br>
3_2.　H2 Databaseで「ITWorkshop.mv.db」を読み込み <br>
3_3.　readme.txtに従い取得するサイトの情報を追加する<br>

4.　　Tomcat9_Java17で「servlet/Main.java」を実行 <br>

補足.　/webscraping/src/main/webapp/videoフォルダ内に任意のMP4動画「background.mp4」を配置することで背景を変更できる

<p align="right">(<a href="#top">トップへ</a>)</p>