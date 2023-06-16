package jspStudent;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspStudent.DAO.StudentDao;
import jspStudent.DTO.Student;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
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

		Student student = new Student();
		student.setStudentId(id);
		student.setStudentname(name);
		student.setStudentEmail(email);
		student.setStudentPassword(password);
		student.setStudentAddress(address);
		student.setStudentfees(fees);
		student.setStudentphone(phone);

		StudentDao dao = new StudentDao();
		dao.updateStudent(id, student);

		List<Student> students = dao.getALLStudents();
		req.setAttribute("list", students);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Display.jsp");
		dispatcher.forward(req, resp);
	}

}
