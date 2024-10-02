package Controller;

import java.io.IOException;
import java.sql.SQLException;

import DAOImpl.ProductDAOImpl;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductListController
 */
@WebServlet(urlPatterns = { "/productList" })
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAOImpl productDAOImpl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductListController() {
		super();
		// TODO Auto-generated constructor stub
		productDAOImpl = new ProductDAOImpl(Persistence.createEntityManagerFactory("phoneStore"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setAttribute("ds", productDAOImpl.getAllProducts());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ModelList.jsp");
		dispatcher.forward(request, response);
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
