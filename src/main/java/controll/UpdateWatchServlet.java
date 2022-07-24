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
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updateWatch")
public class UpdateWatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);

		try {
			WatchDao watchDao = DaoFactory.createWatchDao();
			Watch watch = watchDao.findById(id);

			request.setAttribute("matchDay", watch.getMatchDay());
			request.setAttribute("game", watch.getGame());
			request.setAttribute("place", watch.getPlace());
			
			request.getRequestDispatcher("/WEB-INF/view/updateWatch.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);

		boolean isError = false;

		String game = request.getParameter("game");
		request.setAttribute("game", game);
		if (game.isBlank()) {
			request.setAttribute("gameError", "試合相手が未記入です");
			isError = true;
		} else if (game.length() > 45) {
			request.setAttribute("gameError", "45字以内で入力してください");
			isError = true;
		}

		String place = request.getParameter("place");
		request.setAttribute("place", place);
		if (place.isBlank()) {
			request.setAttribute("placeError", "試合会場が未記入です");
			isError = true;
		} else if (place.length() > 45) {
			request.setAttribute("placeError", "45字以内で入力してください");
			isError = true;
		}

		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/updateWatch.jsp").forward(request, response);
			return;
		}

		Watch watch = new Watch();
		watch.setId(id);
		watch.setGame(game);
		watch.setPlace(place);
		try {
			WatchDao watchDao = DaoFactory.createWatchDao();
			watchDao.update(watch);

			request.getRequestDispatcher("/WEB-INF/view/updateWatchDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
