package pro.sky.homeworkemployee;

import java.util.List;

public interface EmployeeService {
    Employee add(String name, String surname) throws EmployeeExistExeption;

    Employee search(String name, String surname) throws EmployeeNotFound;

    Employee remove(String name, String surname) throws EmployeeNotFound;

    List<Employee> getList();

}
