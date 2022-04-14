package pro.sky.homeworkemployee;

import java.util.Objects;

public class Employee {

    private final String name;
    private final String surName;
    private int department;
    private int salary;

    public Employee(String name, String surName, int department, int salary) {
        this.name = name;
        this.surName = surName;
        this.department = department;
        this.salary = salary;
    }


    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && surName.equals(employee.surName) &&
                department == employee.department && salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, department, salary);
    }

    @Override
    public String toString() {
        return "name = " + name +
                ", surName=" + surName + "\n";
    }
}

