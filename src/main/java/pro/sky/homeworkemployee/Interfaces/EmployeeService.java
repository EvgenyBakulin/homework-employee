package pro.sky.homeworkemployee.Interfaces;

import pro.sky.homeworkemployee.Employee;
import pro.sky.homeworkemployee.Exeptions.EmployeeExistExeption;
import pro.sky.homeworkemployee.Exeptions.EmployeeNotFound;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String name, String surname, int department, int salary) throws EmployeeExistExeption;

    Employee search(String name, String surname) throws EmployeeNotFound;

    Employee remove(String name, String surname) throws EmployeeNotFound;

    Collection<Employee> getEmployees();

    String createKey(String name, String surname);

    //List<Employee>getEmployeesInDepartment(int department);


}
