package pro.sky.homeworkemployee;

import org.apache.commons.lang3.StringUtils;
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
        if(!StringUtils.isAlphaSpace(name)||!StringUtils.isAlphaSpace(surname)){
            throw new BadNameExeption();}
        //Заодно сделаем проверку и на, допустим, нажатую клавишу CapsLock - все сначала в нижний регистр, потом заглавную
        name = StringUtils.lowerCase(name);
        name = StringUtils.capitalize(name);
        surname = StringUtils.lowerCase(surname);
        surname = StringUtils.capitalize(surname);
        Employee empl = new Employee(name, surname);
        if (emploees.containsKey(createKey(name,surname))) {
            throw new EmployeeExistExeption();
        }
        emploees.put(createKey(name, surname), empl);
        return empl;
    }

    public Employee search(String name, String surname) throws EmployeeNotFound {
        name = StringUtils.lowerCase(name);
        name = StringUtils.capitalize(name);
        surname = StringUtils.lowerCase(surname);
        surname = StringUtils.capitalize(surname);
        Employee empl = new Employee(name, surname);
        if (emploees.get(createKey(name, surname)) == null) {
            throw new EmployeeNotFound();
        }
        return empl;
    }

    public Employee remove(String name, String surname) throws EmployeeNotFound {
        Employee empl = this.search(name, surname);
        emploees.remove(createKey(name, surname));
        return empl;
    }

    public String createKey(String name, String surname) {
        return name + surname;
    }
}
