package pro.sky.homeworkemployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Сотрудник не найден")
public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound() {
        super();
    }
}
