
package btth.business.designimpl;

import btth.business.design.IEmployee;
import btth.business.entity.Department;
import btth.business.entity.Employee;
import btth.config.InputMethods;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeImpl implements IEmployee {
    public List<Department> departmentList;
    public List<Employee> employeeList;

    public EmployeeImpl(List<Department> departmentList) {
        this.departmentList = this.departmentList;
        this.employeeList = new ArrayList<>();
    }


    private Employee findEmployeeById(String employeeId) {
        return employeeList.stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void showAll() {
        employeeList.forEach(employee -> System.out.println("Employee ID: " + employee.getEmployeeId() + ", Employee Name: " + employee.getEmployeeName()));
    }


    @Override
    public void addNew() {
        System.out.println("Nhập vào số lượng cần thêm");
        byte count = InputMethods.getByte();

        // duyệt
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhập thông tin cho nhân viên thứ " + i);
            Employee employee = inputData(true);
            // thêm vào list
            employeeList.add(employee);
        }
        System.out.println("Đa thêm thanh công " + count + " nhân viên");
    }

    @Override
    public void edit() {
        System.out.println("Nhập id của nhân viên cần sử thông tin");
        String idEdit = InputMethods.getString();
        Employee employeeEdit = findEmployeeById(idEdit);
        if (employeeEdit == null) {
            System.err.println("Khong tim thay");
        } else {
            // hiển thi thông tin cũ
            System.out.println("thông tin cũ là :");
            System.out.println(employeeEdit);
            System.out.println("Nhập thông tin mới");
            employeeEdit = inputData(false);
            employeeEdit.setEmployeeId(idEdit); // ko thay đổi id
            // set nó la vào danh sách
            employeeList.set(employeeList.indexOf(findEmployeeById(idEdit)),employeeEdit);
            System.out.println("Đã cập nhật thông tin");
        }
    }

    @Override
    public void showId() {
        System.out.println("Nhập id của nhân viên cần hiển thị");
        String idShow = InputMethods.getString();
        Employee employeeToshow = findEmployeeById(idShow);
        if (employeeToshow == null) {
            System.err.println("Không tìm thấy");
        } else {
            System.out.println(employeeToshow);
        }

    }

    @Override
    public void delete() {
        System.out.println("Nhập id của nhân viên cần xóa");
        String idDel = InputMethods.getString();
        Employee employeeDel = findEmployeeById(idDel);
        if (employeeDel == null) {
            System.err.println("Khong tim thay");
        } else {
            employeeList.remove(employeeDel);
            System.out.println("Xóa thanh công");
        }
    }

    @Override
    public Employee inputData(boolean isAdd) {
        Employee newEm = new Employee();
        System.out.println("Nhập mã nhân viên :");
        newEm.setEmployeeId(InputMethods.getString());
        System.out.println("Nhập tên nhân viên:");
        newEm.setEmployeeName(InputMethods.getString());
        System.out.println("Nhập nagy sinh(dd-MM-yyyy) :");
        newEm.setBirthday(InputMethods.getLocalDate());
        System.out.println("Nhập giới tính (1: Nam) và (2:Nữ) :");
        newEm.setSex(InputMethods.getBoolean());
        System.out.println("Nhập lương :");
        newEm.setSalary(InputMethods.getDouble());
//        System.out.println("Nhập quản lý :");
        return newEm;

    }

    //Thống kê số lượng nhân viên trung bình của mỗi phòng
    public double averageEmployeesPerDepartment() {
        if (departmentList.isEmpty()) {
            System.out.println("Không có bộ phận nào.");
            return 0;
        }
        int totalEmployees = departmentList.stream().mapToInt(Department::getTotalMembers).sum();
        double average = (double) totalEmployees / departmentList.size();
        System.out.println("Số lượng trung bình nhân viên trên mỗi bộ phận là: " + average);
        return average;
    }

    // phòng có số lượng nhân viên đông nhất
    public List<Department> topDepartmentsByEmployeeCount(int n) {
        return departmentList.stream()
                .sorted(Comparator.comparingInt(Department::getTotalMembers).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    //người quản lý nhiều  nhân viên nhất
    public Employee managerWithMostEmployees() {
        return employeeList.stream()
                .filter(employee -> employee.getManager() != null)
                .collect(Collectors.groupingBy(Employee::getManager, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    //nhân viên có tuổi cao nhất công ty

    public List<Employee> topEmployeesByAge(int n) {
        return employeeList.stream()
                .sorted(Comparator.comparing(employee -> employee.getBirthday().getYear()))
                .limit(n)
                .collect(Collectors.toList());
    }

}
