package Com.anil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * Servlet implementation class ViewHistory
 */
@WebServlet(description = "for viewing the users history", urlPatterns = { "/ViewHistory" })
public class ViewHistory extends HttpServlet {
	private static final String url = "jdbc:sqlserver://192.168.3.125:1433;database=SQLTraining";
    private static final String userName = "AnilVenkat";
    private static final String passWord = "anRen!sql34";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("View History").append(request.getContextPath());
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
		String query = "SELECT ";
		boolean dataAvalable = false;
		try {
			rs = st.executeQuery(query);
			if(rs.next()) {
				JSONArray jsarray = new JSONArray();
				dataAvalable = true;
				do {
					
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(dataAvalable) {
			
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
