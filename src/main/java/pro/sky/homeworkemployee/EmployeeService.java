package pro.sky.homeworkemployee;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EmployeeService {
    Employee add(String name, String surname) throws EmployeeExistExeption;

    Employee search(String name, String surname) throws EmployeeNotFound;

    Employee remove(String name, String surname) throws EmployeeNotFound;

    Set<Employee> getMap();

}
