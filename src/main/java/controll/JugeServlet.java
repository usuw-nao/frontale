package controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.JugeDao;
import domain.Juge;

/**
 * Servlet implementation class JugeServlet
 */
@WebServlet("/juge")
public class JugeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/juge.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		System.out.println(id);
		try {
			JugeDao jugeDao = DaoFactory.createJugeDao();
			Juge juge = 
					jugeDao.findById(id);
			System.out.println(juge.getText());
	
			request.setAttribute("Text", juge.getText());
			request.getRequestDispatcher("/WEB-INF/view/jugeResult.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
