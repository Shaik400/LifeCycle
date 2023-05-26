package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dto.Employee;

import java.util.List;

public class EmployeeDAO {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
    
    

    public void save(Employee employee) {
    	entityTransaction.begin();
    	entityManager.persist(employee);
    	entityTransaction.commit();
    }

   


    public Employee getEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT x FROM Employee x", Employee.class);
        return query.getResultList();
    }

    public List<Employee> searchEmployeesByName(String name) {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT x FROM Employee x WHERE x.name = :name", Employee.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Employee> searchEmployeesById(int id) {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT x FROM Employee x WHERE x.id = :id", Employee.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    
}


