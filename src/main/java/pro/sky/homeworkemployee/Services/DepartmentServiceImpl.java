package pro.sky.homeworkemployee.Services;

import org.springframework.stereotype.Service;
import pro.sky.homeworkemployee.Employee;
import pro.sky.homeworkemployee.Exeptions.WrongDepartmentExeption;
import pro.sky.homeworkemployee.Interfaces.DepartmentService;
import pro.sky.homeworkemployee.Interfaces.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    public final EmployeeService employeeService;
    private final List<Employee> employeeList;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getList() {
        return employeeService.getEmployees().stream().
                collect(Collectors.toList());
    }

    public List<Employee> getEmployeesInDepartment(int department) {
        final List<Employee> employeesInDepartment = getList().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
        if (employeesInDepartment == null) {
            throw new WrongDepartmentExeption();
        } else {
            return employeesInDepartment;
        }
    }

    /* Я правильно понял, что
     * требуется вывод сотрудников сначала условно первого отдела, потом второго и т.д? Некая такая сортировка по
     * номеру отдела?*/
    public List<Employee> getEmployeesToDepartments() {
        List<Employee> toDepartments = getList();
        Collections.sort(toDepartments, Comparator.comparingInt(e -> e.getDepartment()));
        return toDepartments;
    }

    public Employee minSalaryInDepartment(int department) {
        final List<Employee> employeesInDepartment = getEmployeesInDepartment(department);
        Optional<Employee> min = employeesInDepartment.stream().min(Comparator.comparingInt(e -> e.getSalary()));
        return min.get();
    }

    public Employee maxSalaryInDepartment(int department) {
        final List<Employee> employeesInDepartment = getEmployeesInDepartment(department);
        Optional<Employee> max = employeesInDepartment.stream().max(Comparator.comparingInt(e -> e.getSalary()));
        return max.get();
    }
}
