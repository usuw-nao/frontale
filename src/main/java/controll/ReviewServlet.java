package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.ReviewDao;
import domain.Review;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/Review")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId=request.getParameter("id");
		Integer id=Integer.parseInt(strId);
		try {
			ReviewDao reviewDao=DaoFactory.createReviewDao();
			Review review=reviewDao.findById(id);
			request.setAttribute("name",review.getName());
			request.setAttribute("text", review.getText());
			request.setAttribute("revaluation", review.getRevaluation());
			request.getRequestDispatcher("/WEB-INF/view/review/updateReview.jsp")
			.forward(request, response);
		}catch(Exception e) {
			throw new ServletException(e);
			
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String text=request.getParameter("text");
		System.out.println("kokodayo!");
		//try {
			//Review 
			//findAllを持ってくる
		//}
		
		
		
		
	}

}
