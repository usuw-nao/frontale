package controll;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.ReviewDao;
import dao.WatchDao;
import domain.Review;
import domain.Watch;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/Review")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId=request.getParameter("id");
		Integer id=Integer.parseInt(strId);
		
		try {
			 WatchDao watchDao = DaoFactory.createWatchDao();
			 Watch watch =watchDao.findById(id);
			
			 //request.setAttribute("watchList", watchList);
			 request.setAttribute("matchDay", watch.getMatchDay());
				request.setAttribute("game", watch.getGame());
				request.setAttribute("place", watch.getPlace());

			//ReviewDao reviewDao = DaoFactory.createReviewDao();
			//List<Review> reviews = reviewDao.findAll();
			//request.setAttribute("reviews", reviews);

			request.getRequestDispatcher("WEB-INF/view/review/updateReview.jsp").forward(request, response);
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

		try {
			// フォームからのデータを取得
			String name = request.getParameter("name");
			String text = request.getParameter("text");
			Integer evaluation = Integer.parseInt(request.getParameter("evaluation"));
			// そのデータを追加
			Review review = new Review();
			review.setName(name);
			review.setText(text);
			review.setEvaluation(evaluation);

			ReviewDao reviewDao = DaoFactory.createReviewDao();
			//List<Review> reviews = reviewDao.findAll();
			//request.setAttribute("reviews", reviews);
			reviewDao.insert(review);
			request.getSession().setAttribute("review", review);
			//フォワードではなく、同じ画面にドゥポストされるsend redirectを使用
			response.sendRedirect(request.getContextPath() + "/Review");
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
