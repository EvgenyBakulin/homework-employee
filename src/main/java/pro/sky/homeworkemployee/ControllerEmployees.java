package pro.sky.homeworkemployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class ControllerEmployees {
    public final EmployeeService employeeService;

    public ControllerEmployees(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*Исправил, теперь возвращает пустой список*/
    @GetMapping("/get")
    public Collection<Employee> getEmployees() {
            return employeeService.getEmployees();
        }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname) {
        return employeeService.add(name, surname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname) {
        return employeeService.search(name, surname);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname) {
        return "Данные сотрудника " + employeeService.remove(name, surname) + " успешно удалены";
    }

}
