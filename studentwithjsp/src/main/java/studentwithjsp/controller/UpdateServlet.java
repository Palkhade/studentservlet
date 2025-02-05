package studentwithjsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao dao=new StudentDao();
		Student student=dao.findStudentByID(id);
		HttpSession httpSession=req.getSession();
		String name=(String)httpSession.getAttribute("studentNameWhoLoogedin");
		if(name!=null)
		{
			req.setAttribute("student", student);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("edit.jsp");
			requestDispatcher.forward(req, resp);
		}
		else
		{
			req.setAttribute("message", "Hey Scammer plz login first then come here");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
