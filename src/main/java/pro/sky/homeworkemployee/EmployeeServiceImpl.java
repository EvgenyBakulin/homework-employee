package pro.sky.homeworkemployee;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
/*Поскольку по условиям задачи не нужно никаких ID, сделаем и ключ и значение объектом Emplioyee
* Возвращать везде будем ключ*/
public class EmployeeServiceImpl implements EmployeeService {
    private Map<Employee, Employee> emploees;

    EmployeeServiceImpl() {
        this.emploees = new HashMap<>();
    }

    public Set<Employee> getMap() {
        return emploees.keySet();
    }

    public Employee add(String name, String surname) throws EmployeeExistExeption {

        Employee empl = new Employee(name, surname);
        try {
            emploees.put(empl, empl);
        } catch (EmployeeExistExeption e) {
        }
        ;
        return empl;
    }

    public Employee search(String name, String surname) throws EmployeeNotFound {
        Employee empl = new Employee(name, surname);
        if (emploees.get(empl) == null) {
            throw new EmployeeNotFound();
        }
        return empl;
    }

    //Не хочу containsKey. Мне нравится так)
    public Employee remove(String name, String surname) throws EmployeeNotFound {
        Employee empl = this.search(name, surname);
        emploees.remove(empl);
        return empl;
    }

}
