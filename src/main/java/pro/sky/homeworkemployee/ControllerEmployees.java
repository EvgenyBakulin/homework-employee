package pro.sky.homeworkemployee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEmployees {
    @GetMapping
    public String hello() {
        return "Hello";
    }
}
