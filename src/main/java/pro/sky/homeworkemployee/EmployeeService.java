package pro.sky.homeworkemployee;

public interface EmployeeService {
    Employee add(String name, String surname);
    Employee search(String name, String surname);
    Employee remove(String name, String surname);

    boolean isEmpty();
}
