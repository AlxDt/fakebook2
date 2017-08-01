package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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

		// get the input of the user
		String username = request.getParameter("uname");
		String password = request.getParameter("pword");
		boolean remember = request.getParameter("remember") != null;

		// check if they are valid
		if (!username.equals("") && !password.equals("")) {
			// session.add(uname)
			request.getSession().setAttribute("un", username);

			// add cookie(uname)
			if (remember) {
				Cookie usernameCookie = new Cookie("username", username);
				usernameCookie.setMaxAge(60 * 60 * 24 * 7 * 3);
				response.addCookie(usernameCookie);
			}

			// go to index.jsp
			request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		} else {
			// EEK! go back to register
			response.sendRedirect("html/register.html");
		}
	}

}
