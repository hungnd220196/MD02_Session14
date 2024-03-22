package btth.business.entity;
import java.time.LocalDate;

public class Employee {
    private String employeeId;
    private String employeeName;
    private Department department;
    private LocalDate birthday;
    private boolean sex;
    private double salary;
    private Employee manager;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, Department department, LocalDate birthday, boolean sex, double salary, Employee manager) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.manager = manager;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", birthday=" + birthday +
                ", sex=" + (sex ? "Nam":"Nữ") +
                ", salary=" + salary +
                ", manager=" + manager +
                '}';
    }
}