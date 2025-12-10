package chap06;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class sample601
 */
@WebServlet("/Sample601")
public class Sample601 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字コードの指定
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメーターの指定。
		request.setAttribute("data1", 123);
		//セッションの生成と値の設定
		HttpSession session = request.getSession(true);
		session.setAttribute("data3", "あいうえお");
		//リクエスト・ディスパッチャーの取得
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/chap06/Sample601.jsp");
		//フォワードの処理。
		dispatcher.forward(request, response);
	}

}
