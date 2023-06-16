package jspStudent.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jspStudent.DTO.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("radha").createEntityManager();
	}

	public Student saveStudents(Student student) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(student);
		et.commit();
		return student;
	}

	public List<Student> getALLStudents() {
		EntityManager em = getEntityManager();
		Query query = em.createQuery("select a from Student a");
		List<Student> list = query.getResultList();
		return list;

	}

	public Student loginStudent(String email) {
		EntityManager em = getEntityManager();
		Query query = em.createQuery("select a from Student a where a.studentEmail=?1");
		query.setParameter(1, email);
		return (Student) query.getSingleResult();

	}

	public void deleteStudentById(int id) {
		EntityManager em = getEntityManager();
		Student student = em.find(Student.class, id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(student);
		et.commit();

	}
	
	
	public Student getStudentById(int id) {
		
		EntityManager em = getEntityManager();
		Student student = em.find(Student.class, id);
		return student;
		
	}
	public void updateStudent(int id,Student student) {
		EntityManager em = getEntityManager();
		Student student1 = em.find(Student.class, id);
		if (student1!=null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			student.setStudentId(id);
			em.merge(student);
			et.commit();
			
		}

	}
	

}
