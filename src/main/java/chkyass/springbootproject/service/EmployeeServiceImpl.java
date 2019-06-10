package chkyass.springbootproject.service;

import chkyass.springbootproject.dao.EmployeeDAO;
import chkyass.springbootproject.dao.EmployeeRepository;
import chkyass.springbootproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    // use default bean id corresponding classname starting with lowercase
    @Qualifier("employeeDAOJpaImpl")
    EmployeeDAO employeeDAO;

    @Autowired
    EmployeeRepository employeeRepository;
    //JpaRepository<Employee, Integer> emp

    @Override
    //@Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    //@Transactional
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        if (result.isPresent())
            return result.get();
        return null;
    }

    @Override
    //@Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    //@Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
