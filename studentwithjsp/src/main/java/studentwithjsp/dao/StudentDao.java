package studentwithjsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentwithjsp.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public List<Student> getAllStudent()
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("Select u from Student u");
		return query.getResultList();
	}
	
	public void signupStudent(Student student)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
			
	}

	public void deleteStudent(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student=entityManager.find(Student.class, id);
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		
	}

	public Student updateStudent(Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}

	public Student findStudentByID(int id) {
		
		EntityManager entityManager=getEntityManager();
		Student student=entityManager.find(Student.class, id);
		return student;
	}
}
