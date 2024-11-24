package cs.dit.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		response.setContentType("text/html; charset=UTF-8");
		
		
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		System.out.println("command : " + com);
		
		String viewPage ="";
		
		if(com != null && com.trim().equals("index")) {
			viewPage = "/WEB-INF/view/index.jsp";
			
		}else if(com != null && com.equals("list")) {
			BoardService service = new BListService();
			service.execute(request, response);
			
			viewPage = "/WEB-INF/view/list.jsp";
		
		}else if(com != null && com.equals("insertForm")) {
			viewPage = "/WEB-INF/view/insertForm.jsp";
		
		}else if(com != null && com.equals("insert")) {
			BoardService service = new BInsertService();
			service.execute(request, response);
			System.out.println("다녀왔네요");
			
			viewPage = "list.do";
			
		
		}else if(com != null && com.equals("update")) {
			viewPage = "/WEB-INF/view/updateForm.jsp";
		
		}else if(com != null && com.equals("delete")) {
			viewPage = "/WEB-INF/view/deletePro.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
