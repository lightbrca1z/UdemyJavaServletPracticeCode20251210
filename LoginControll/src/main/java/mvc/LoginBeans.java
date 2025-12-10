package mvc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoginBeans {
	
	//ユーザー名の変数
	private String username;
	//パスワードの変数
	private String userpass;
	//コンストラクタ
	public LoginBeans() {}
	
	public void registerUser() {
		try {
			//「ユーザー名.txt」に書き込むためのFileWriterオブジェクトの生成
			FileWriter fno = new FileWriter(username + ".txt");
			//ファイルにuserpassを出力
			fno.write(userpass);
			//FileWriterオブジェクトのfnoを閉じる
			fno.close();
		}catch (IOException e) {
			
		}
	}
	
	public boolean isCorrectPass() {
		try {
			//「ユーザー名.txt」を読み込むためのFileReaderオブジェクトの生成
			FileReader reader = new FileReader(username + ".txt");
			// BufferReaderオブジェクトのbrの生成
			BufferedReader br = new BufferedReader(reader);
			//「ユーザー名.txt」の一行をpassに代入
			String pass = br.readLine();
			//入力されたパスワードが正しい場合
			
			if(userpass.equals(pass)) {
				//BufferedReaderオブジェクトのbrを閉じる
				br.close();
				//FileReaderオブジェクトのreaderを閉じる
				reader.close();
				//trueを返す
				return true;
			}
			else{
				//BufferedReaderオブジェクトのbrを閉じる
				br.close();
				//FileReaderオブジェクトのreaderを閉じる
				reader.close();
				//falseを返す
				return false;
			}
		}catch(IOException e) {
			return false;
		}
	}
	
	//ユーザー名のゲッター
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String userNameFrmCon) {
		this.username = userNameFrmCon;
	}
	
	//パスワードのゲッター
	public String getUserpass() {
		return userpass;
	}

	
	public void setUserpass(String userPassFrmCon) {
		//パスワードの代入
		this.userpass = userPassFrmCon;
	}
}
