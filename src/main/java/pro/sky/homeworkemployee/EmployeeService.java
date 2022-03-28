package pro.sky.homeworkemployee;

public interface EmployeeService {
    Employee add(String name, String surname) throws FullMassivExeption;
    Employee search(String name, String surname) throws EmployeeNotFound;
    Employee remove(String name, String surname) throws EmployeeNotFound;

    boolean isEmpty();
}
