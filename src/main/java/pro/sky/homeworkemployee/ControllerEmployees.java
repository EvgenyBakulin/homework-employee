package pro.sky.homeworkemployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homeworkemployee.Interfaces.DepartmentService;
import pro.sky.homeworkemployee.Interfaces.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class ControllerEmployees {
    public final EmployeeService employeeService;
    public final DepartmentService departmentService;

    public ControllerEmployees(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/get")
    public Collection<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/department/all")
    public List<Employee> getEmployeesInDepartment(@RequestParam(value = "departmrntID") int department) {
        return departmentService.getEmployeesInDepartment(department);
    }

    @GetMapping("/department/min-salary")
    public Employee minSalaryInDepartment(@RequestParam(value = "departmentID") int department) {
        return departmentService.minSalaryInDepartment(department);
    }

    @GetMapping("/department/max-salary")
    public Employee maxSalaryInDepartment(@RequestParam(value = "departmentID") int department) {
        return departmentService.maxSalaryInDepartment(department);
    }

    @GetMapping("/departments/all")
    public List<Employee> getEmployeesToDepartments() {
        return departmentService.getEmployeesToDepartments();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam(value = "name") String name,
                                @RequestParam(value = "surname") String surname,
                                @RequestParam(value = "departmentID") int department,
                                @RequestParam(value = "salary") int salary) {
        return employeeService.add(name, surname, department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "surname") String surname) {
        return employeeService.search(name, surname);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "surname") String surname) {
        return "Данные сотрудника " + employeeService.remove(name, surname) + " успешно удалены";
    }

}

