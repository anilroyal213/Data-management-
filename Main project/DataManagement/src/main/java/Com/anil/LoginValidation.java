package Com.anil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

/**
 * Servlet implementation class LoginValidation
 */
@WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	private static final String url = "jdbc:sqlserver://192.168.3.125:1433;database=SQLTraining";
    private static final String userName = "AnilVenkat";
    private static final String passWord = "anRen!sql34";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject object = new JSONObject();
		String entereduserName = request.getParameter("username");
		String enteredpassword = request.getParameter("password");
		boolean isAvalable = false;
		Connection conn = null;
		ResultSet rs = null;
		String password = "";
		Statement st = null;
		try {
			Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, userName, passWord);
            st = conn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		String query = "SELECT passWord from [Anil].[anilsProjectUsersData] WHERE userNmae='" + entereduserName + "';";
		try {
			rs = st.executeQuery(query);
			if(rs.next()) {
				isAvalable = true;
				password = rs.getString("passWord");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(isAvalable) {
			if(enteredpassword.equals(password)){
				HttpSession session = request.getSession();
				session.setAttribute("type", "user");
				session.setAttribute("username", entereduserName);
				object.put("username", "true");
				object.put("password", "true");
				response.getWriter().println(object.toString());
			}
			else {
				object.put("username", "true");
				object.put("password", "false");
				response.getWriter().println(object.toString());
			}
		}
		else {
			object.put("username", "false");
			object.put("password", "false");
			response.getWriter().println(object.toString());
		}
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
