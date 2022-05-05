package pro.sky.homeworkemployee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homeworkemployee.Exeptions.WrongDepartmentExeption;
import pro.sky.homeworkemployee.Interfaces.DepartmentService;
import pro.sky.homeworkemployee.Interfaces.EmployeeService;
import pro.sky.homeworkemployee.Services.DepartmentServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static pro.sky.homeworkemployee.CollectionsForTests.LIST_1;
import static pro.sky.homeworkemployee.CollectionsForTests.LIST_2;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeServiceMock;
    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void isCorrectGetEmployeesInDepartment() {
        when(employeeServiceMock.getEmployees()).thenReturn(LIST_1);
        List<Employee> expectedResult = new ArrayList<>();
        expectedResult.add(LIST_1.get(1));
        Assertions.assertEquals(out.getEmployeesInDepartment(4), expectedResult);
        Assertions.assertThrows(WrongDepartmentExeption.class,()->out.getEmployeesInDepartment(9));
    }

    @Test
    public void isCorrectGetEmployeesToDepartments() {
        List<Employee> expected = new ArrayList<>();
        expected.add(LIST_1.get(1));
        expected.add(LIST_1.get(0));
        when(employeeServiceMock.getEmployees()).thenReturn(expected);
        Assertions.assertEquals(out.getEmployeesToDepartments(), expected);

    }

    @Test
    public void isCorrsectMinSalaryInDepartment(){
        when(employeeServiceMock.getEmployees()).thenReturn(LIST_2);
        Assertions.assertThrows(WrongDepartmentExeption.class,()->out.getEmployeesInDepartment(11));
        Assertions.assertEquals(out.minSalaryInDepartment(4),LIST_2.get(0));
    }

    @Test
    public void isCorrsectMaxSalaryInDepartment(){
        when(employeeServiceMock.getEmployees()).thenReturn(LIST_2);
        Assertions.assertThrows(WrongDepartmentExeption.class,()->out.getEmployeesInDepartment(10));
        Assertions.assertEquals(out.maxSalaryInDepartment(4),LIST_2.get(1));
    }
}
