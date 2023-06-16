package jspStudent;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspStudent.DAO.StudentDao;
import jspStudent.DTO.Student;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		StudentDao dao = new StudentDao();
		List<Student> students = dao.getALLStudents();
		boolean value = false;

		for (Student student : students) {

			if (student.getStudentEmail().equals(email)) {
				value = true;
				break;
			}
		}
		if (value) {
			StudentDao dao1 = new StudentDao();
			Student student1 = dao1.loginStudent(email);
			if (student1.getStudentPassword().equals(password)) {

//					req.setAttribute("message", "LOGIN SUCCESS");
				req.setAttribute("list", students);
				RequestDispatcher dispatcher = req.getRequestDispatcher("Display.jsp");
				dispatcher.forward(req, resp);

			} else {
				req.setAttribute("message", "WRONG PASSWORD /n PLEASE ENTER VALID PASSWORD");
				RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
				dispatcher.include(req, resp);

			}

		} else {
			req.setAttribute("message", "EMAIL doesn't EXITS");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
			dispatcher.include(req, resp);
		}

	}
}
