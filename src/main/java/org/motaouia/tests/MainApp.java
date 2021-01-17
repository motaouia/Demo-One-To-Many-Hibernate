package org.motaouia.tests;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.motaouia.entities.Department;
import org.motaouia.entities.Employee;
import org.motaouia.utils.HibernateUtils;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
	      Transaction transaction = null;
	      try {
	    	  session = HibernateUtils.getSessionFactory().openSession();
		      transaction = session.beginTransaction();
		         //transaction.begin();
		         //session.getTransaction();

	         Department department = new Department();
	         department.setName("IT Department");

	         Employee employee1 = new Employee();
	         employee1.setName("Adam");
	         employee1.setDesignation("Manager");
	         employee1.setDepartment(department);

	         Employee employee2 = new Employee();
	         employee2.setName("Miller");
	         employee2.setDesignation("Software Engineer");
	         employee2.setDepartment(department);

	         Employee employee3 = new Employee();
	         employee3.setName("Smith");
	         employee3.setDesignation("Associate  Engineer");
	         employee3.setDepartment(department);

	         department.getEmployees().add(employee1);
	         department.getEmployees().add(employee2);
	         department.getEmployees().add(employee3);

	         session.persist(department);

	         transaction.commit();
	      } catch (Exception e) {
	         if (transaction != null) {
	            transaction.rollback();
	         }
	         e.printStackTrace();
	      } finally {
	         if (session != null) {
	            session.close();
	         }
	      }

	      HibernateUtils.shutdown();

	}

}
