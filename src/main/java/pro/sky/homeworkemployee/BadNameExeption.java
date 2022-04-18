package pro.sky.homeworkemployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Неправильное имя")
public class BadNameExeption extends RuntimeException{
    public BadNameExeption(){
        super();
    }
}
