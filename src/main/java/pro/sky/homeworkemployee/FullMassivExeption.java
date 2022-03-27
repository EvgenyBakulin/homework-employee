package pro.sky.homeworkemployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Список сотрудников переполнен")
public class FullMassivExeption extends RuntimeException{
    public FullMassivExeption() {super();}
}
