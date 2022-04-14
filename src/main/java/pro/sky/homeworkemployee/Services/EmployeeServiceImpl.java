package pro.sky.homeworkemployee.Services;

import org.springframework.stereotype.Service;
import pro.sky.homeworkemployee.Employee;
import pro.sky.homeworkemployee.Exeptions.EmployeeExistExeption;
import pro.sky.homeworkemployee.Exeptions.EmployeeNotFound;
import pro.sky.homeworkemployee.Interfaces.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> emploees;

    public EmployeeServiceImpl() {
        this.emploees = new HashMap<>();
    }

    public Collection<Employee> getEmployees() {
        return emploees.values();
    }

    public Employee add(String name, String surname, int department, int salary) throws EmployeeExistExeption {
        Employee empl = new Employee(name, surname,department, salary);
        if (emploees.containsKey(createKey(name, surname))) {
            throw new EmployeeExistExeption();
        }
        emploees.put(createKey(name, surname), empl);
        return empl;
    }

    public Employee search(String name, String surname) throws EmployeeNotFound {
        //Employee empl = new Employee(name, surname, department, salary);
        if (emploees.get(createKey(name, surname)) == null) {
            throw new EmployeeNotFound();
        }
        return emploees.get(createKey(name,surname));
    }

    public Employee remove(String name, String surname) throws EmployeeNotFound {
        Employee empl = this.search(name, surname);
        emploees.remove(createKey(name, surname));
        return empl;
    }

    /*public List<Employee>getEmployeesInDepartment(int department) {
        final List<Employee> employeesInDepartment = emploees.values().stream()
                .filter(e->e.getDepartment()==department)
                .collect(Collectors.toList());
        return employeesInDepartment;
    }*/

    public String createKey(String name, String surname) {
        return name + surname;
    }
}
