package chkyass.springbootproject.dao;

import chkyass.springbootproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {

        return entityManager.createQuery("from Employee")
                .getResultList();
    }

    @Override
    public Employee findById(int theId) {

        return entityManager.find(Employee.class, theId);
    }

    @Override
    public void save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        // update Employee with the id from db
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        entityManager.createQuery("delete from Employee where id=:employeeId")
                .setParameter("employeeId", id)
                .executeUpdate();
    }
}
