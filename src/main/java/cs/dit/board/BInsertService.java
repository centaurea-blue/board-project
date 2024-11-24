package cs.dit.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BInsertService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 입력한 게시글을 데이터베이스에 넣는 코드
		request.setCharacterEncoding("utf-8");

		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");

		System.out.println(subject);
		
		BoardDto dto = new BoardDto(0, subject, content, writer, null); 
		BoardDao dao = new BoardDao();
		dao.insert(dto);
		
		//response.sendRedirect("list.jsp");
	}

}
