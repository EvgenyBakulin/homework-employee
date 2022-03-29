package pro.sky.homeworkemployee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> emploees;

    EmployeeServiceImpl() {
        this.emploees = new ArrayList<Employee>();
    }

    public List<Employee> getList() {
        return emploees;
    }

    public Employee add(String name, String surname) throws EmployeeExistExeption {
        Employee empl = new Employee(name, surname);
        if (!emploees.isEmpty()) {
            for (Employee i : emploees) {
                if (i.equals(empl)) {
                    throw new EmployeeExistExeption();
                }
            }
        }
        emploees.add(empl);
        return empl;
    }

    public Employee search(String name, String surname) throws EmployeeNotFound {
        Employee empl = new Employee(name, surname);
        int count = -1;
        for (Employee i : emploees) {
            if (i.equals(empl)) {
                count = 0;
            }
        }
        if (count == -1) {
            throw new EmployeeNotFound();
        }
        return empl;
    }

    //Здесь добавим просто предыдущий метод, а исключение в нём уже есть
    public Employee remove(String name, String surname) throws EmployeeNotFound {
        Employee empl = this.search(name, surname);
        Iterator iter = emploees.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(empl)) {
                iter.remove();
            }
        }
        return empl;
    }

}
