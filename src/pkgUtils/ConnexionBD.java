package pkgUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	private static String url = "jdbc:mysql://127.0.0.1:3306/p33-final";
	private static String pwd = "root";
	private static String user = "root";
	
	private static Connection conn = null;
				
	
	
	

	public static Connection getConn() {
		return conn;
	}



	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return conn;
	}
	
	public static void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	
}
