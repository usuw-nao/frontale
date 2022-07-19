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
 * Servlet implementation class AddWatchServlet
 */
@WebServlet("/addWatch")
public class AddWatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addWatch.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//Integer id = Integer.parseInt(request.getParameter("id"));
		String game = request.getParameter("game");
		String place = request.getParameter("place");

		//Map<String, String> mW = new HashMap<String, String>();
		//mW.put("サンフレッチェ広島", "エディオンスタジアム");
		//mW.put("浦和レッズ", "埼玉スタジアム");
		//mW.put("鹿島アントラーズ", "茨城県立鹿島サッカースタジアム");
		//mW.put("セレッソ大阪", "ヨドコウ桜スタジアム");
		//mW.put("ベガルタ仙台", "ユアテックスタジアム");
		//mW.put("FC東京", "味の素スタジアム");
		//mW.put("横浜マリノス", "日産スタジアム");
		//mW.put("ガンバ大阪", "パナソニックスタジアム吹田");
		//mW.put("北海道コンサドーレ札幌", "札幌ドーム");

		Watch watch = new Watch();
		//watch.setId(id);
		watch.setGame(game);
		watch.setPlace(place);

		try {
			WatchDao watchDao = DaoFactory.createWatchDao();
			watchDao.insert(watch);
			request.getRequestDispatcher("/WEB-INF/view/addWatchDone.jsp")
					.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
