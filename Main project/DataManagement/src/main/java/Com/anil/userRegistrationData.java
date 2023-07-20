package Com.anil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userRegistrationData
 */
@WebServlet("/userRegistrationData")
public class userRegistrationData extends HttpServlet {
	private static final String url = "jdbc:sqlserver://192.168.3.125:1433;database=SQLTraining";
    private static final String userName = "AnilVenkat";
    private static final String passWord = "anRen!sql34";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userRegistrationData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		//creating the preparedstatement for query execution
		PreparedStatement st = null;
		String email = request.getParameter("email");
		String DOB = request.getParameter("DOB");
		String Age = request.getParameter("Age");
		String PhNo = request.getParameter("PhNo");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String query = "INSERT INTO anilsProjectUsersData VALUES(?,?,?,?,?,?,?);";
		//Regestring the driver and creating the jdbc connection
		try {
			Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, userName, passWord);
            st = conn.prepareStatement(query);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		try {
			st.setString(1, request.getParameter("name"));
			st.setString(2, request.getParameter("DOB"));
			st.setString(3, request.getParameter("Age"));
			st.setString(4, request.getParameter("email"));
			st.setString(5, request.getParameter("PhNo"));
			st.setString(6, request.getParameter("username"));
			st.setString(7, request.getParameter("password"));
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.getWriter().append("Sucessfully Executed");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
