package controll;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class GalleryServlet
 */
@WebServlet("/gallery")
@MultipartConfig(location = "C:/Users/zd2L03/temp")
public class GalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 既存の画像を取得
		File filePath = getUploadedDirectory(request);
		File[] fileList = filePath.listFiles();
		request.setAttribute("fileList", fileList);
		request.getRequestDispatcher("/WEB-INF/view/gallery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// アップロード処理
		Part part = request.getPart("file");
		long fileSize = part.getSize();
		String fileType = part.getContentType();
		String fileName = part.getSubmittedFileName();

		if (fileSize > 0) {
			File filePath = getUploadedDirectory(request);
			part.write(filePath + "/" + fileName);
		}
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("fileType", fileType);
		request.setAttribute("fileName", fileName);

	}

	private File getUploadedDirectory(HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/uploads");
		return new File(path);
	}

}
