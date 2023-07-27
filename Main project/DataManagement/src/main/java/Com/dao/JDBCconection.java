package Com.dao;
import java.sql.*;

public class JDBCconection {
	private static final String url = "jdbc:sqlserver://192.168.3.125:1433;database=SQLTraining";
    private static final String userName = "AnilVenkat";
    private static final String passWord = "anRen!sql34";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static Connection conn = null;
    public JDBCconection() {
    	
    }
    public static Connection getConnection() {
    	try {
			Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, userName, passWord);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    	return conn;	
    }
    public static boolean closeConnection() throws SQLException {
    	try {
    		if(conn != null) {
        		conn.close();
        		return true;
        	}
        	else {
        		return false;
        	}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }

}
