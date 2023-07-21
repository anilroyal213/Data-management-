package Com.anil;
import java.sql.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sun.jdi.connect.spi.Connection;

/**
 * Servlet implementation class ImagetoDB
 */
@WebServlet("/ImagetoDB")
public class ImagetoDB extends HttpServlet {
	private static final String url = "jdbc:sqlserver://192.168.3.125:1433;database=SQLTraining";
    private static final String userName = "AnilVenkat";
    private static final String passWord = "anRen!sql34";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImagetoDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part file = request.getPart("imageFile");
		String fileName = file.getSubmittedFileName();
		InputStream fi = file.getInputStream();
		java.sql.Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,userName,passWord);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try {
        	String query = "INSERT INTO Anil.Images (Imagename,ImageData) VALUES (?,?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement .setString(1, fileName);
				statement .setBinaryStream(2, fi);
                statement.executeUpdate();
			response.getWriter().write("Image uploaded successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part file = request.getPart("imageFile");
		String fileName = file.getSubmittedFileName();
		InputStream fi = file.getInputStream();
		java.sql.Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,userName,passWord);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try {
        	String query = "INSERT INTO Anil.Images (Imagename,ImageData) VALUES (?,?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement .setString(1, fileName);
				statement .setBinaryStream(2, fi);
                statement.executeUpdate();
			response.getWriter().write("Image uploaded successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}
}
