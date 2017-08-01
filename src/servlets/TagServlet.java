package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TagServlet
 */
@WebServlet("/tag")
public class TagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TagServlet() {
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
		// doGet(request, response);

		HttpSession session = request.getSession(false);

		if (session == null) {
			// the user is not logged in!
			// denied page
			request.getRequestDispatcher("jsp/denied.jsp").forward(request, response);
		}

		String username = (String) session.getAttribute("un");

		if (username != null) {
			response.sendRedirect(request.getHeader("Referer"));
		} else {
			// the user is not logged in!
			// denied page
			request.getRequestDispatcher("jsp/denied.jsp").forward(request, response);
		}
	}
}
