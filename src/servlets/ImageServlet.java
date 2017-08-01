package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/img")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageServlet() {
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

		String queryString = request.getQueryString();

		if (queryString != null) {
			String query = queryString.split("=")[1];

			// If it's a private photo...
			if (query.equals("0")) {
				// ...check if the session attribute for the user exists first
				String username = (String) request.getSession(false).getAttribute("un");

				if (username != null) {
					// If it does exist, get the username and check if that username
					// was given access to this photo
					// Retrieve the list of users the photo is given access to from the database
					// Is the user part of this list?
					// If the user is, proceed normally
					// Else, throw a denied page
					// (IMPLEMENTED NEXT TIME)

					// it's a private photo and the user doesn't have access to it, so proceed
					// normally
					request.getRequestDispatcher("jsp/view.jsp?img=0").forward(request, response);
				} else {
					// it's a private photo and the user doesn't have access to it, so throw a
					// denied page
					request.getRequestDispatcher("jsp/denied.jsp").forward(request, response);
				}
			} else {
				// it's a public photo, so proceed normally
				request.getRequestDispatcher("jsp/view.jsp?img=1").forward(request, response);
			}
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
