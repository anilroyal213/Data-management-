package Com.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//import org.apache.tomcat.util.http.fileupload.FileItem;
//import org.apache.tomcat.util.http.fileupload.FileItemFactory;
//import org.apache.tomcat.util.http.fileupload.RequestContext;
//import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
//import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

//import com.sun.tools.javac.util.List;

/**
 * Servlet implementation class UploadData
 */
@WebServlet(description = "for Uploading Data", urlPatterns = { "/UploadData" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 150, // 10MB
maxRequestSize = 1024 * 1024 * 150) // 50MB
public class UploadData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("Called UploadData");
//		response.getWriter().print("working");
		//response.getWriter().flush();
		//FileItemFactory factory = new FileItemFactory();
//		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
//		List<FileItem> iteam = upload.parseRequest((RequestContext) request);
//		Part file = request.getPart("file");
//		String filemane = file.getSubmittedFileName();
//		InputStream fileContents = file.getInputStream();
//		System.out.println(fileContents);
//		System.out.println("Started");
//		response.addHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Origin", "null");
//        Part filePart = request.getPart("file");
//        InputStream fileContent = filePart.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
//        String line;
//        System.out.println("Working");
//        while ((line = reader.readLine()) != null) {
//        System.out.println(line);
//        }
//        System.out.println("Ended");
		response.addHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin", "null");
		System.out.println("called");
		try {
			Part filePart = request.getPart("file"); // "file" should match the name used in formData.append("file", fileInput); on the frontend
			String fileName = filePart.getSubmittedFileName();
			InputStream fileContent = filePart.getInputStream();
			System.out.println("calle1d");
			// Specify the path where you want to save the uploaded file
			String uploadDirectory = "C:\\Users\\Anilvenkataramana\\Desktop\\Save Archive Files";
			File file = new File(uploadDirectory + fileName);
			try (OutputStream out = new FileOutputStream(file)) {
				System.out.println("ca2lle1d");
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = fileContent.read(buffer)) != -1) {
			out.write(buffer, 0, bytesRead);
			System.out.println("111ca2lle1d");
			}
			}
			System.out.println("c3alle1d");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().print("File uploaded successfully!");
			} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().print("Error uploading file: " + e.getMessage());
			}
		System.out.println("Ended");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
