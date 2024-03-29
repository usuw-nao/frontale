package controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.LoginDao;
import domain.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp")
				.forward(request, response);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String userId = request.getParameter("userId");
			String pass = request.getParameter("pass");
			LoginDao loginDao = DaoFactory.createLoginDao();
			Login login = loginDao.findByUserIdAndPass(userId, pass);

			if (login != null) {
				HttpSession session = request.getSession();
				request.getSession().setAttribute("userId", login.getUserId());
				request.getRequestDispatcher("/WEB-INF/view/login.jsp")
						.forward(request, response);
			} else {
				request.setAttribute("error", true);
				request.getRequestDispatcher("/index.jsp")
						.forward(request, response);

			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
