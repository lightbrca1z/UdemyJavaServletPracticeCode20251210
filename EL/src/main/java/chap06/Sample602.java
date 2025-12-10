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
 * Servlet implementation class Sample602
 */
@WebServlet("/Sample602")
public class Sample602 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字コードの指定
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータの設定
		request.setAttribute("data", "ABC");
		//セッションの生成と値の設定
		HttpSession session = request.getSession(true);
		session.setAttribute("data", "あいうえお");
		//リクエスト・ディスパッチャーの取得
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/chap06/Sample602.jsp");
		//フォワードの処理
		dispatcher.forward(request, response);
	}

}
