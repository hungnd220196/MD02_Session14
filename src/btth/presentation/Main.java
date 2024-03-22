package btth.presentation;

import btth.config.InputMethods;

public class Main {
    private static EmployeeManagement employeeManagement = new EmployeeManagement();
    private static DepartmentManagement departmentManagement = new DepartmentManagement();

    public static void main(String[] args) {
        while (true) {
            System.out.println("MENU");
            System.out.println("1.Quản lý phòng ban");
            System.out.println("2.Quản lý nhân viên");
            System.out.println("Nhâp lưa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    departmentManagement.displayDepartmentMenu();
                    break;
                case 2:
                    employeeManagement.displayEmployeeMenu();
                    break;
                default:
                    System.err.println("Nhập sai");
            }
        }
    }
}