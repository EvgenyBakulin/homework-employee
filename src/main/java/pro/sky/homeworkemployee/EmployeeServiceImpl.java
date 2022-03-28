package pro.sky.homeworkemployee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Employee[] emploees;

    EmployeeServiceImpl() {
        this.emploees = new Employee[10];
    }

    public Employee add(String name, String surname) throws FullMassivExeption{
        Employee empl = new Employee(name, surname);
       /*Придётся проводить проверку: не обязательно сотрудник будет добавлен в конец,
          может и на первое пустое место
           */
        if (!this.isEmpty()) {
            for (Employee i : emploees) {
                if (i != null && i.equals(empl)) {
                    throw new EmployeeExistExeption();
                }
            }
        }
        int count = -1;
        try {
            for (int i = 0; i < emploees.length; i++) {
                if (emploees[i] == null) {
                    emploees[i] = empl;
                    count = i;
                    break;
                }
            }
        } catch (RuntimeException e) {
            throw new FullMassivExeption();
        }
        return emploees[count];
    }

    public Employee search(String name, String surname) throws EmployeeNotFound{
        Employee empl = new Employee(name, surname);
        int count = -1;
        for (int i = 0; i < emploees.length; i++) {
            if (emploees[i] != null && emploees[i].equals(empl)) {
                count = i;
            }
        }
        if (count == -1) {
            throw new EmployeeNotFound();
        }
        return emploees[count];
    }

    //Здесь добавим просто предыдущий метод, а исключение в нём уже есть
    public Employee remove(String name, String surname) throws EmployeeNotFound{
        Employee empl = this.search(name, surname);
        for (int i = 0; i < emploees.length; i++) {
            if (emploees[i] != null && emploees[i].equals(empl)) {
                emploees[i] = null;
            }
        }
        return empl;
    }

    public boolean isEmpty() {
        int count = 0;
        for (Employee i : emploees) {
            if (i != null) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
