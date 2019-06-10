package chkyass.springbootproject.rest;

import chkyass.springbootproject.entity.Employee;
import chkyass.springbootproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    // expose "/employees" and return list of emplyees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee employeeId(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if(employee == null)
            throw new RuntimeException("Employee with id= " + id + " not found");

        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {

        // if an id is passed in the json force creation of new one
        employee.setId(0);
        employeeService.save(employee);

        return employee;
    }

    @DeleteMapping("/employees")
    public String  delete(@RequestParam(value="id", required=true) int id) {
        if(employeeService.findById(id) == null)
            throw new RuntimeException("Employee id not found - " + id);

        employeeService.deleteById(id);

        return "Employee id deleted - " + id;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        employeeService.save(employee);

        return employee;
    }

}
