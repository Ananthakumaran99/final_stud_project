package jspStudent.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private int studentId;
	private String studentname;
	private String studentEmail;
	private String studentPassword;
	private String studentAddress;
	private long studentphone;
	private double studentfees;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public long getStudentphone() {
		return studentphone;
	}

	public void setStudentphone(long studentphone) {
		this.studentphone = studentphone;
	}

	public double getStudentfees() {
		return studentfees;
	}

	public void setStudentfees(double studentfees) {
		this.studentfees = studentfees;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentname=" + studentname + ", studentEmail=" + studentEmail
				+ ", studentPassword=" + studentPassword + ", studentAddress=" + studentAddress + ", studentphone="
				+ studentphone + ", studentfees=" + studentfees + "]";
	}

}
