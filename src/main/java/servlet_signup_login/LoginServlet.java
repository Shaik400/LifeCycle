package servlet_signup_login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.studentdao;
import dto.Student;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
        
		studentdao dao=new studentdao();
		Student student;
		try{
			long mobile=Long.parseLong(email);
			student=dao.fetch(mobile);
		}
		catch(NumberFormatException e){
			
			student =dao.fetch(email);
		}

		
		if(student==null) {
			resp.getWriter().print("<h1>Invalid Email</h1> ");
			req.getRequestDispatcher("login.html").include(req, resp);
		}else {
			if(student.getPassword().equals(password)) {
				resp.getWriter().print("<h1>Login Success</h1> ");
				req.setAttribute("student", student);
				req.setAttribute("list", dao.fetch());
				req.getRequestDispatcher("success.jsp").include(req, resp);
				
//				
//				resp.getWriter().print("<table border='1'>"
//						+"<tr>"
//						+"<th>ID</th>"
//						+"<th>Name</th>"
//						+"<th>Moile</th>"
//						+"<th>E-mail</th>"
//						+"<th>Gender</th>"
//						+"</tr>" 
//						+"<tr>"
//						+"<th>"+student.getId()+"</th>"
//						+"<th>"+student.getName()+"</th>"
//						+"<th>"+student.getPhone()+"</th>"
//						+"<th>"+student.getEmail()+"</th>"
//						+"<th>"+student.getGender()+"</th>"
//						+"</tr>"
//						+"</table>");
//resp.getWriter().print("</div></br></br> ");
//				
//				resp.getWriter().print("<div style='background-color:green'> ");
//				resp.getWriter().print(" <table border='1'>"
//						+ " <tr>"
//						+ "<th>id</th>"
//						+ "<th>name</th>"
//						+ "<th>gender</th>"
//						+ "<th>email</th>"
//						+ "<th>phone</th> "
//						+ "</tr>");
//				List<Student> list1=dao.fetch();  //calling the list fecth method from studentDao
//				for(Student student2:list1 ) {
//				resp.getWriter().print("<tr>"
//							+ "<td>"+student2.getId()+"</td>"
//							+ "<td>"+student2.getName()+"</td>"
//							+ "<td>"+student2.getGender()+"</td>"
//							+ "<td>"+student2.getEmail()+"</td>"
//							+ "<td>"+student2.getPhone()+"</td>"
//							+ "</tr>");
//				}
//			  resp.getWriter().print( "</table>"); //we want records to be print the records so we should write outside for each loop
			  

			}else {
				resp.getWriter().print("<h1>Wrong Password</h1> ");
				req.getRequestDispatcher("login.html").include(req, resp); 
			}
		}

	}
}