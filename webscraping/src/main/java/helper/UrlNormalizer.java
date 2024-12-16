package helper;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlNormalizer {

    public static String normalizeUrl(String url) {
        try {
            // URLをURIに変換
            URI uri = new URI(url);
            
            // クエリ部分（例えば?variantId=16882955）を取り除く
            URI normalizedUri = new URI(uri.getScheme(), uri.getHost(), uri.getPath(), null, null);
            
            return normalizedUri.toString();  // 正規化したURLを返す
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return url;  // エラーが発生した場合はそのままのURLを返す
    }
}
