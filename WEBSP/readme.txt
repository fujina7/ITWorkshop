
＊＊＊＊＊＊＊＊　重要事項　＊＊＊＊＊＊＊＊


※重要なお知らせ:

WEBスクレイピングを通じて商品情報を取得する際は、必ず各サイトの利用規約を事前にご確認ください。
一部のサイトでは、スクレイピング行為が禁止されている場合があり、規約に反する行為は法的な問題を引き起こす可能性もあります。
利用規約に記載された制限に従い、許可されていないサイトに対してスクレイピングを行わないようご注意ください。

本ツールの利用により発生したいかなる問題についても、制作者は一切の責任を負いません。
サイトの利用規約については、必ず最新の内容を確認し、遵守するようお願いいたします。
スクレイピングを行う前に、対象となるサイトの利用規約に関して十分に理解し、違法行為を避けるようお願い申し上げます。
万が一、利用規約に違反する行為により問題が発生した場合でも、規約に違反した行為によって生じた法的問題やその他のトラブルについて、制作者は一切責任を負いませんので、あらかじめご了承ください。

＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊

初回利用の場合、該当サイトの情報をこちら【PRODUCT_SELECTORS】にご登録してからご使用ください。




【PRODUCT_SELECTORS】


・ID　=　"連番で登録されます。"
  
・STORE_NAME　=　"該当サイト名（どのような名前でも可）"

・PRODUCT_NAME_SELECTOR  =　"該当サイト商品名のクラス名等"

・PRODUCT_PRICE_SELECTOR　=　"該当サイト商品値段のクラス名等"

・SITE_NAME 　=　"該当サイトのURL"
　
・PRODUCT_IMAGE_SELECTOR 　=　"該当サイト商品画像のクラス名等"










　　その他登録項目一覧


【ACCOUNTS】
　アプリ起動後に「新規会員登録画面」にて登録された情報が登録されます
  
『登録内容』

・ USER_ID =　"ユーザーID"

・ PASS  =　"パスワード"

・ MAIL  =　"メールアドレス"

・ NAME  =　"名前"	

・ AGE   =　"年齢"




【PRODUCTS】
　・スクレイピング機能実行後に、[保存ボタン]を押した場合、取得した商品情報が登録されます。

『登録内容』

・ ID =　"登録数に応じて増加します"

・ NAME  =　"商品名"

・ PRICE  =　"商品の値段"

・ PRODUCT_URL  =　"商品URL"	

・ IMAGE_URL   =　"商品画像URL"





＿＿＿＿＿【H2DBの操作コード】＿＿＿＿＿＿＿＿


サイト情報の追記・編集

【追記コード】

insert into PRODUCT_SELECTORS
 (ID , STORE_NAME , PRODUCT_NAME_SELECTOR , PRODUCT_PRICE_SELECTOR,  SITE_NAME , PRODUCT_IMAGE_SELECTOR  )
values(,'','','','','')



【上書き編集コード】
update PRODUCT_SELECTORS
set  PRODUCT_NAME_SELECTOR   ='',
PRODUCT_PRICE_SELECTOR  ='',
PRODUCT_IMAGE_SELECTOR  =''
where id =






H2DBにおける商品価格の並び替え：

【昇順コード】

SELECT * FROM products 
ORDER BY CAST(REPLACE(REPLACE(REPLACE(REPLACE(price, ',', ''), '円', ''), '〜', ''), '¥ ', '') AS DECIMAL) ASC;


【降順コード】

SELECT * FROM products 
ORDER BY CAST(REPLACE(REPLACE(REPLACE(REPLACE(price, ',', ''), '円', ''), '〜', ''), '¥ ', '') AS DECIMAL) DESC;







