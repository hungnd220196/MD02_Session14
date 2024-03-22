package btth.business.design;

import btth.business.entity.Department;
import btth.business.entity.Employee;

import java.sql.Date;
import java.util.List;

public interface IEmployee extends IGenegicDesign<Employee,Integer>{
    double averageEmployeesPerDepartment();
}