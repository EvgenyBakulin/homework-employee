package pro.sky.homeworkemployee.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Этот сотрудник уже добавлен")
public class EmployeeExistExeption extends RuntimeException {
    public EmployeeExistExeption() {
        super();
    }
}
