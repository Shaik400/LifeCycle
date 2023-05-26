package servlet_signup_login;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.studentdao;
import dto.Student;

@WebServlet("/XYZ")

public class SignupServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Student s=new Student();
		s.setName(req.getParameter("name"));
		s.setEmail(req.getParameter("email"));
		s.setPassword(req.getParameter("password"));
		s.setGender(req.getParameter("gender"));
		s.setNumber(Long.parseLong(req.getParameter("number")));
		
		
		
		studentdao dao= new studentdao();
		dao.save(s);
		
		resp.getWriter().print("<h1>Data Saved Successfully</h1>");
		req.getRequestDispatcher("login.html").include(req,resp);
	}
	}


		
