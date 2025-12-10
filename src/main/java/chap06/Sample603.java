package chap06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sample603
 */
@WebServlet("/Sample603")
public class Sample603 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> data = new ArrayList<String>();
		data.add("JSP");
		data.add("and");
		data.add("Servlet");
		request.setAttribute("data", data);
		//リクエスト・ディスパッチャーの取得
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/chap06/Sample603.jsp");
		//フォワード処理
		dispatcher.forward(request, response);
	}

}
