package pro.sky.homeworkemployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class ControllerEmployees {
    public final EmployeeService employeeService;

    public ControllerEmployees(EmployeeService employeeService) {
        this.employeeService = employeeService;
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
    public Employee removeEmployee(@RequestParam(value = "name") String param1, @RequestParam(value = "surname") String param2) {
        return employeeService.remove(param1, param2);
    }

}
