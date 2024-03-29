package studentwithjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		StudentDao studentDao=new StudentDao();
		List<Student> students=studentDao.getAllStudent();
		boolean value=false;
		String pass=null;
		String studentName=null;
		for(Student student:students)
		{
			if(email.equals(student.getEmail()))
			{
				value=true;
				pass=student.getPassword();
				//cookies concept
				studentName=student.getName();
				break;
			}
		}
		if(value)
		{
			if(pass.equals(password))
			{
				//create one cookie
				Cookie cookie=new Cookie("studentWhoLoggedin", studentName);
				resp.addCookie(cookie);
				//HttpSession
				HttpSession httpSession=req.getSession();
				httpSession.setAttribute("studentNameWhoLoogedin", studentName);
				
				req.setAttribute("list", students);
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("display.jsp");
				requestDispatcher.forward(req, resp);
				
			}
			else
			{
				req.setAttribute("message", "Invalid Password");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
				requestDispatcher.include(req, resp);
			}
		}
		else
		{
			req.setAttribute("message", "Invalid Email");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
			requestDispatcher.include(req, resp);
		}
		
		
	}
}
