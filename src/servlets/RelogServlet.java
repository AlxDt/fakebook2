package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RelogServlet
 */
@WebServlet("/re")
public class RelogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RelogServlet() {
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

		// get cookies
		Cookie[] cookies = request.getCookies();
		String username = null;

		// check is username cookie exists
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie currentCookie = cookies[i];

				if (currentCookie.getName().equals("username")) {
					username = currentCookie.getValue();
					currentCookie.setMaxAge(60 * 60 * 24 * 7 * 3);
					currentCookie.setHttpOnly(true);
					response.addCookie(currentCookie);
				}
			}
		}

		// if exists
		if (username != null) {
			// use cookie value and set it as attr to session
			request.getSession().setAttribute("un", username);

			// go to index.jsp
			request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		} else {
			// else
			// kill session
			request.getSession().invalidate();
			
			// user had not visited website, or logged out, or not remembered
			// go to index.jsp
			response.sendRedirect("jsp/index.jsp");
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
