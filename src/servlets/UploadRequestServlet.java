package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upr")
public class UploadRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadRequestServlet() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// ...check if the session attribute for the user exists first
		HttpSession session = request.getSession(false);

		if (session == null) {
			// the user is not logged in!
			// denied page
			request.getRequestDispatcher("jsp/denied.jsp").forward(request, response);
		}

		String username = (String) session.getAttribute("un");

		if (username != null) {
			// allow user to get to upload page
			request.getRequestDispatcher("jsp/upload.jsp").forward(request, response);
		} else {
			// the user is not logged in!
			// denied page
			request.getRequestDispatcher("jsp/denied.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
