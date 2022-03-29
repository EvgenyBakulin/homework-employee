package pro.sky.homeworkemployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Список сотрудников пуст")
public class ListIsEmptyExeption extends RuntimeException {
    public ListIsEmptyExeption() {
        super();
        System.out.println("Список сотрудников пуст");
    }
}
