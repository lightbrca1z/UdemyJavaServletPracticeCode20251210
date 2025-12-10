package mvc;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードをUTF-8に設定
		request.setCharacterEncoding("UTF-8");
		// 遷移するページ名を示すpageNameの初期化
		String pageName = "";
		
		// 登録フォームからの送信かどうかをチェック
		String newUserName = request.getParameter("newuser");
		String newUserPass = request.getParameter("newpass");
		
		if(newUserName != null && !newUserName.trim().equals("") && newUserPass != null
				&& !newUserPass.trim().equals("")) {
			// 登録処理
			// LoginBeansオブジェクトの生成
			LoginBeans newlogbean = new LoginBeans();
			//newUserNameを代入
			newlogbean.setUsername(newUserName);
			//newUserPAssを代入
			newlogbean.setUserpass(newUserPass);
			//registerUserメソッドの呼び出し
			newlogbean.registerUser();
			// pageNameに遷移するページ先を代入
			pageName = "Registered.jsp";
		} else {
			// ログイン処理
			// フォームに入力されたユーザー名をuserNameに代入
			String userName = request.getParameter("username");
			//フォームに入力されたパスワードをuserPassに代入
			String userPass = request.getParameter("password");
			
			if(userName != null && !userName.trim().equals("") && userPass != null && !userPass.trim().equals("")) {
				//LoginBeansオブジェクトの生成
				LoginBeans logbean = new LoginBeans();
				
				// userNameを代入
				logbean.setUsername(userName);
				// userPassを代入
				logbean.setUserpass(userPass);
				
				//ユーザー名とパスワードが正しい場合
				if(logbean.isCorrectPass()) {
					//pageNameに遷移するページ先を代入
					pageName = "MenuPage.jsp";
					
					//リクエスト・オブジェクトにlogbeanを登録
					request.setAttribute("user_info", logbean);
				} else {
					// ログイン失敗
					pageName = "LoginForm.jsp";
				}
			} else {
				// パラメータが不足している場合
				pageName = "LoginForm.jsp";
			}
		}
		
		//処理をpageNameに遷移
		getServletConfig().getServletContext().getRequestDispatcher("/jsp/" + pageName)
		.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext().getRequestDispatcher("/jsp/LoginForm.jsp")
		.forward(request, response);
	}

}
