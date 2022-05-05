package pro.sky.homeworkemployee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.homeworkemployee.Exeptions.EmployeeExistExeption;
import pro.sky.homeworkemployee.Exeptions.EmployeeNotFound;
import pro.sky.homeworkemployee.Interfaces.EmployeeService;
import pro.sky.homeworkemployee.Services.EmployeeServiceImpl;

import java.util.*;
import java.util.stream.Stream;

public class EmployeeServiceTest {
    EmployeeService out = new EmployeeServiceImpl();
    @Test
    public void isCorrectGetEmployees(){
        Employee e1 =  out.add("Ivan","Ivanov",4,50000);
        Employee e2 = out.add("Petr","Ivanov",5,50000);
        List<Employee> actual = out.getEmployees();
        List<Employee> expected = new ArrayList<>();
        expected.add(e1);
        expected.add(e2);
        Assertions.assertEquals(actual,expected);
    }
    @Test
    public void isCorrectWorkOfAdd(){
        Employee result = out.add("Ivan","Ivanov",4,50000);
        Assertions.assertTrue(out.getEmployees().contains(result));
        Assertions.assertThrows(EmployeeExistExeption.class,()->out.add("Ivan","Ivanov",5,50000));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void isCorrectWorkOfSearch(String name, String surname){
        Employee result = out.add("Ivan","Ivanov",4,50000);
        Assertions.assertEquals(out.search("Ivan","Ivanov"),result);
        Assertions.assertThrows(EmployeeNotFound.class,()->out.search("Petr","Petrov"));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void isCorrectWorkOfRemove(String name, String surname){
        Employee result = out.add("Ivan","Ivanov",4,50000);
        Employee result1 = out.add("Ivan","Petrov",5,40000);
        Assertions.assertEquals(out.remove("Ivan","Ivanov"),result);
        Assertions.assertThrows(EmployeeNotFound.class,()->out.search("Petr","Petrov"));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void isCorrectWorkOfCreateKey(String name, String surname){
        String result = out.createKey("Ivan","Ivanov");
        Assertions.assertEquals(result,"IvanIvanov");
    }
    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(Arguments.of("Ivan", "Ivanov"),
                Arguments.of("Ivan", "Ivanov"),
                Arguments.of("Ivan","Petrov"),
                Arguments.of("Petr","Petrov"),
                Arguments.of("Ivan", "Petrov")
        );
    }
}
