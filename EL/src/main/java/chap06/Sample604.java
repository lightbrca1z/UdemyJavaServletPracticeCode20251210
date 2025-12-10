package chap06;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sample604
 */
@WebServlet("/Sample604")
public class Sample604 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();
		data.put("Jan","1月");
		data.put("Feb","2月");
		data.put("Mar","3月");
		request.setAttribute("data", data);
		//リクエスト・ディスパッチャーの取得
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/chap06/Sample604.jsp");
		//フォワードの処理
		dispatcher.forward(request, response);
	}

}
