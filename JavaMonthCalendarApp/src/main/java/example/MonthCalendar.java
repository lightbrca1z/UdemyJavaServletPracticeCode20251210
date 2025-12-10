package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MonthCalendar
 */
@WebServlet("/MonthCalendar")
public class MonthCalendar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // 閏年・平年の月別日数
    private int[][] monthDays = {
            // 閏年の月別日数
            {31,29,31,30,31,30,31,31,30,31,30,31},
            // 平年の月別日数
            {31,28,31,30,31,30,31,31,30,31,30,31},
    };
    
    // 年
    private int year;
    // 月（0:1月 ～ 11:12月）
    private int month;
    // 日
    private int day;
    // 曜日（1:日 ～ 7:土）
    private int dayOfWeek;
    // 配列 monthDays から今年の月別日数の組み合わせを選択するための変数
    // 0:閏年, 1:平年
    private int leapDays;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // ★まず表示する年月を決めて、フィールドにセット
        getCalendar(request);
        
        // 出力データのコンテントタイプと文字コードの設定
        response.setContentType("text/html; charset=UTF-8");
        
        // PrintWriter オブジェクトの生成
        PrintWriter out = response.getWriter();
        
        // 前月・翌月の年月を計算
        int prevYear = year;
        int prevMonth = month - 1;
        if (prevMonth < 0) {
            prevMonth = 11;
            prevYear--;
        }
        
        int nextYear = year;
        int nextMonth = month + 1;
        if (nextMonth > 11) {
            nextMonth = 0;
            nextYear++;
        }

        StringBuilder content = new StringBuilder();

        // ===== ナビゲーションボタン部分 =====
        content.append("<div style=\"text-align:center; margin:10px;\">");
        
        // 前の月ボタン
        content.append("<form action=\"MonthCalendar\" method=\"get\" style=\"display:inline; margin-right:10px;\">")
               .append("<input type=\"hidden\" name=\"year\" value=\"").append(prevYear).append("\">")
               .append("<input type=\"hidden\" name=\"month\" value=\"").append(prevMonth + 1).append("\">")
               .append("<input type=\"submit\" value=\"◀ 前の月\">")
               .append("</form>");
        
        // 今月へ戻るボタン
        content.append("<form action=\"MonthCalendar\" method=\"get\" style=\"display:inline; margin:0 10px;\">")
               .append("<input type=\"submit\" value=\"今月\">")
               .append("</form>");
        
        // 次の月ボタン
        content.append("<form action=\"MonthCalendar\" method=\"get\" style=\"display:inline; margin-left:10px;\">")
               .append("<input type=\"hidden\" name=\"year\" value=\"").append(nextYear).append("\">")
               .append("<input type=\"hidden\" name=\"month\" value=\"").append(nextMonth + 1).append("\">")
               .append("<input type=\"submit\" value=\"次の月 ▶\">")
               .append("</form>");
        
        content.append("</div>");

        // 見出し（年・月）
        content.append("<h1 align=\"center\">")
               .append(year).append("年")
               .append(month + 1).append("月</h1>");

        // カレンダー本体
        content.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"1\">");
        content.append("<tr>"
                + "<th bgcolor=\"pink\">日</th>"
                + "<th bgcolor=\"lightcyan\">月</th>"
                + "<th bgcolor=\"lightcyan\">火</th>"
                + "<th bgcolor=\"lightcyan\">水</th>"
                + "<th bgcolor=\"lightcyan\">木</th>"
                + "<th bgcolor=\"lightcyan\">金</th>"
                + "<th bgcolor=\"lightcyan\">土</th>"
                + "</tr>");
        
        content.append("<tr valign=\"top\">");
        
        // 先月ぶんの空白（1:日 ～ 7:土）
        for (int i = 1; i < dayOfWeek; i++) {
            content.append("<td bgcolor=\"lightyellow\"><br></td>");
        }
        
        // 今月の日付を出力
        for (int i = 1; i <= monthDays[leapDays][month]; i++) {
            // 土曜日を過ぎたら改行
            if (dayOfWeek == 8) {
                dayOfWeek = 1;
                content.append("</tr><tr valign=\"top\">");
            }
            // 日曜日をピンク
            if (dayOfWeek == 1) {
                content.append("<td bgcolor=\"pink\">").append(i).append("</td>");
            }
            // 土曜日を水色
            else if (dayOfWeek == 7) {
                content.append("<td bgcolor=\"lightcyan\">").append(i).append("</td>");
            }
            // 平日を白
            else {
                content.append("<td bgcolor=\"white\">").append(i).append("</td>");
            }
            
            // 曜日を一つ進める
            dayOfWeek++;
        }
        
        // 月末の後ろの空白を埋める
        for (int i = dayOfWeek; i <= 7; i++) {
            content.append("<td bgcolor=\"lightyellow\"><br></td>");
        }
        content.append("</tr>");
        content.append("</table>");
       
        out.println(HTMLTemplate.createPage(content.toString()));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    /**
     * 表示する年月をリクエストパラメータから取得して
     * year / month / dayOfWeek / leapDays をセットする
     */
    private void getCalendar(HttpServletRequest request) {
        // year, month パラメータ（month は 1～12 で受け取る想定）
        String yearParam = request.getParameter("year");
        String monthParam = request.getParameter("month");
        
        GregorianCalendar calendar;
        
        if (yearParam != null && monthParam != null) {
            try {
                int y = Integer.parseInt(yearParam);
                int m = Integer.parseInt(monthParam) - 1; // 0～11 に変換
                // 指定年月の1日でカレンダー生成
                calendar = new GregorianCalendar(y, m, 1);
            } catch (NumberFormatException e) {
                // パラメータが不正なら現在日時にフォールバック
                calendar = new GregorianCalendar();
            }
        } else {
            // パラメータ無しなら現在日時
            calendar = new GregorianCalendar();
        }
        
        // 年月日をセット
        year  = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH); // 0～11
        day   = calendar.get(GregorianCalendar.DATE);
        
        // 当月1日の曜日を取得（1:日 ～ 7:土）
        GregorianCalendar thisMonth = new GregorianCalendar(year, month, 1);
        dayOfWeek = thisMonth.get(GregorianCalendar.DAY_OF_WEEK);
        
        // 閏年判定（0:閏年, 1:平年）
        if (calendar.isLeapYear(year)) {
            leapDays = 0;
        } else {
            leapDays = 1;
        }
    }
}
