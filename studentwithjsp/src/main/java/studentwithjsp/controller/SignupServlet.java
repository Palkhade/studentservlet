package studentwithjsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;

public class SignupServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		Student student1=new Student();
		student1.setName(name);
		student1.setAddress(address);
		student1.setEmail(email);
		student1.setPassword(password);
		student1.setPhone(phone);
		
		ServletContext context=getServletContext();
		int fees=Integer.parseInt(context.getInitParameter("fees"));
		student1.setFees(fees);
		
		StudentDao studentDao=new StudentDao();
		List<Student> students=studentDao.getAllStudent();
		boolean value=false;
		for(Student st:students)
		{
			if(email.equals(st.getEmail()))
			{
				value=true;
				break;
			}
		}
		if(value)
		{
			//email is already present
			req.setAttribute("message", "Email is aready present");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("signup.jsp");
			requestDispatcher.include(req, resp);
		}
		else
		{
			studentDao.signupStudent(student1);
			req.setAttribute("message", "Signedup successfully");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
		}
		
	}
	
}
