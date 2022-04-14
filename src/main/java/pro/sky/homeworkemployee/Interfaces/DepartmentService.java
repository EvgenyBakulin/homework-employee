package pro.sky.homeworkemployee.Interfaces;

import pro.sky.homeworkemployee.Employee;

import java.util.List;

public interface DepartmentService {
    List<Employee> getList();

    List<Employee> getEmployeesInDepartment(int department);

    List<Employee> getEmployeesToDepartments();

    Employee minSalaryInDepartment(int department);

    Employee maxSalaryInDepartment(int department);
}
