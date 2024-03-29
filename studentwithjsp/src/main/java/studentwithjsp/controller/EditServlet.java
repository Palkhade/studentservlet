package studentwithjsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;
@WebServlet("/edit")
public class EditServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		int fees=Integer.parseInt(getServletContext().getInitParameter("fees"));
		
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setAddress(address);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);
		student.setFees(fees);
		
		StudentDao studentDao=new StudentDao();
		Student dbStudent=studentDao.updateStudent(student);
		
		Cookie[] cookies=req.getCookies();
		String studentWhoChanggedTheDetails=null;
		for(Cookie cookie:cookies )
		{
			if(cookie.getName().equals("studentWhoLoggedin"))
			{
				studentWhoChanggedTheDetails=cookie.getValue();
			}
		}
		req.setAttribute("name", studentWhoChanggedTheDetails);
		
		req.setAttribute("list", studentDao.getAllStudent());
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("display.jsp");
		requestDispatcher.forward(req, resp);
		
	}
}
