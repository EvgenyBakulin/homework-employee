package pro.sky.homeworkemployee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
/*Поскольку по условиям задачи не нужно никаких ID, сделаем и ключ и значение объектом Emplioyee
 * Возвращать везде будем ключ*/
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> emploees;

    public EmployeeServiceImpl() {
        this.emploees = new HashMap<>();
    }

    public Collection<Employee> getEmployees() {
        return emploees.values();
    }

    public Employee add(String name, String surname) throws EmployeeExistExeption {
        Employee empl = new Employee(name, surname);
        if (emploees.containsKey(createKey(name, surname))) {
            throw new EmployeeExistExeption();
        }
        emploees.put(createKey(name, surname), empl);
        return empl;
    }

    public Employee search(String name, String surname) throws EmployeeNotFound {
        Employee empl = new Employee(name, surname);
        if (emploees.get(createKey(name, surname)) == null) {
            throw new EmployeeNotFound();
        }
        return empl;
    }

    //Не хочу containsKey. Мне нравится так)
    public Employee remove(String name, String surname) throws EmployeeNotFound {
        Employee empl = this.search(name, surname);
        emploees.remove(createKey(name, surname));
        return empl;
    }

    public String createKey(String name, String surname) {
        return name + surname;
    }
}
