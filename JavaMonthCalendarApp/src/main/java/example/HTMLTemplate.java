package example;

public class HTMLTemplate {

    // HTMLの共通部分（先頭）
    private static final String HTML_START =
            "<!DOCTYPE html>" +
            "<html lang=\"ja\">" +
            "<head>" +
            "<meta charset=\"UTF-8\">" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
            "<title>Month Calendar</title>" +
            "</head>" +
            "<body>";

    // HTMLの共通部分（末尾）
    private static final String HTML_END =
            "</body>" +
            "</html>";

    // ページ全体を組み立てるメソッド
    public static String createPage(String content) {
        return HTML_START + content + HTML_END;
    }
}