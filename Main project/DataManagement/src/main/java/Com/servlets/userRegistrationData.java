package Com.servlets;

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
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String DOB = request.getParameter("DOB");
//		int Age = Integer.parseInt(request.getParameter("Age"));
//		String PhNo = request.getParameter("PhNo");
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
		String query = "INSERT INTO Anil.anilsProjectUsersData(name,dob,age,email,phoneNumber,userNmae,passWord,isDelete,createdOn,createdBy) VALUES(?,?,?,?,?,?,?, 0,GETUTCDATE(),?);";
		//Regestring the driver and creating the jdbc connection
		try {
			Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, userName, passWord);
            st = conn.prepareStatement(query);
        } catch (SQLException | ClassNotFoundException e) {
            //e.printStackTrace();
        }
		catch(Exception e) {
			response.getWriter().println("Error occured when Creating the connection");
		}
		try {
			st.setString(1, request.getParameter("name"));
			st.setString(2, request.getParameter("DOB"));
			st.setInt(3, Integer.parseInt(request.getParameter("Age")));
			st.setString(4, request.getParameter("email"));
			st.setString(5, request.getParameter("PhNo"));
			st.setString(6, request.getParameter("username"));
			st.setString(7, request.getParameter("password"));
			st.setString(8, request.getParameter("username"));
			st.execute();
			response.getWriter().println("Registration done Sucessfully");
		} catch (SQLException e) {
			//e.printStackTrace();
			response.getWriter().println("SQL Error occured");
		}
		catch (Exception e) {
			//e.printStackTrace();
			response.getWriter().println("Error occured");
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					response.getWriter().println("Error occured when closing the connection");
				}
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
