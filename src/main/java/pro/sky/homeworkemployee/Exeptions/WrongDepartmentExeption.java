package pro.sky.homeworkemployee.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Отдел не найден")
public class WrongDepartmentExeption extends RuntimeException {
    public WrongDepartmentExeption() {
        super();
    }
}
