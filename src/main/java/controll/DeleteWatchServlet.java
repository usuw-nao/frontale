package controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.WatchDao;
import domain.Watch;

/**
 * Servlet implementation class DeleteWatchServlet
 */
@WebServlet("/deleteWatch")
public class DeleteWatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);

		try {
			WatchDao watchDao = DaoFactory.createWatchDao();
			Watch watch = watchDao.findById(id);

			request.setAttribute("watch", watch);
			request.getRequestDispatcher("/WEB-INF/view/deleteWatch.jsp")
					.forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);

		Watch watch = new Watch();
		watch.setId(id);

		try {
			WatchDao watchDao = DaoFactory.createWatchDao();
			watchDao.delete(watch);

			request.getRequestDispatcher("/WEB-INF/view/deleteWatchDone.jsp")
					.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}
}