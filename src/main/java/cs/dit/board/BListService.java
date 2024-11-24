package cs.dit.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BListService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BListService에 오셨네요^^");
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> dtos = dao.list();
		
		request.setAttribute("dtos", dtos);

	}

}
