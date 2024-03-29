package studentwithjsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithjsp.dao.StudentDao;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		StudentDao dao=new StudentDao();
		dao.deleteStudent(id);
		req.setAttribute("list", dao.getAllStudent());
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("display.jsp");
		requestDispatcher.forward(req, resp);
	}
}
