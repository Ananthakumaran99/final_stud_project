package jspStudent;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspStudent.DAO.StudentDao;
import jspStudent.DTO.Student;

public class SignUpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phonenumber"));

		ServletContext context = getServletContext();
		String fee = context.getInitParameter("fees");
		double fees = Double.parseDouble(fee);

		StudentDao dao = new StudentDao();
		List<Student> list = dao.getALLStudents();
		boolean value = false;
		for (Student student : list) {
			if (student.getStudentEmail().equals(email)) {
				value = true;

				break;
			}
		}

		if (value) {
			req.setAttribute("message", "EMAIL ALREADY EXITS");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Signup.jsp");
			dispatcher.include(req, resp);
		} else {

			Student student1 = new Student();
			student1.setStudentId(id);
			student1.setStudentname(name);
			student1.setStudentEmail(email);
			student1.setStudentPassword(password);
			student1.setStudentAddress(address);
			student1.setStudentfees(fees);
			student1.setStudentphone(phone);

			StudentDao dao1 = new StudentDao();
			dao1.saveStudents(student1);
			req.setAttribute("message", "Signed In successfully");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
