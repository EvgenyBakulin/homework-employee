package pro.sky.homeworkemployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class ControllerEmployees {
    public final EmployeeService employeeService;

    public ControllerEmployees(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*Я понимаю, что логики в контроллере быть не должно, но добавить исключение хотелось,
    не выводить же пустые скобки.Выбрасывать исключение в геттере, как я понимаю, неправильно,
    он же универсальный, может и пустой список возвращать, мало ли для чего. А делать специальный геттер с исключением,
    по-моему, тоже не очень*/
    @GetMapping("/get")
    public List<Employee> getList() {
        if (employeeService.getList().isEmpty()) {
            throw new ListIsEmptyExeption();
        } else {
            return employeeService.getList();
        }
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam(value = "name") String param1, @RequestParam(value = "surname") String param2) {
        return employeeService.add(param1, param2);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam(value = "name") String param1, @RequestParam(value = "surname") String param2) {
        return employeeService.search(param1, param2);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam(value = "name") String param1, @RequestParam(value = "surname") String param2) {
        return "Данные сотрудника " + employeeService.remove(param1, param2).toString() + " успешно удалены";
    }

}
