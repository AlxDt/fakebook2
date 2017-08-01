package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/up")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:\\x556uf\\DLSU\\2\\3\\WEBAPDE\\MP2";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// ...check if the session attribute for the user exists first
		String username = (String) request.getSession(false).getAttribute("un");

		if (username != null) {
			// allow user to upload photo
			// upload photo in database if the file types are good
			String description = request.getParameter("description");
			boolean isPublic = request.getParameter("privacy") != null;

			if (description.equalsIgnoreCase("invalid file type")) {
				response.sendRedirect("/Fakebook/upr");
			} else {
				Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
				String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
				InputStream fileContent = filePart.getInputStream();

				File uploaded = new File(UPLOAD_DIRECTORY);
				File file = new File(uploaded, fileName);

				try (InputStream input = fileContent) {
					Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

					response.sendRedirect("img?img=" + ((isPublic) ? "1" : "0"));
				} catch (Exception ex) {
					response.sendRedirect("/Fakebook/upr");
				}
			}
		} else {
			// the user is not logged in!
			// denied page
			request.getRequestDispatcher("jsp/denied.jsp").forward(request, response);
		}
	}

}
