package chkyass.springbootproject.dao;

import chkyass.springbootproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee employee);
    public void deleteById(int id);

}
