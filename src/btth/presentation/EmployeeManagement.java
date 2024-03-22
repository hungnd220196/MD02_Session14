package btth.presentation;

import btth.business.design.IEmployee;
import btth.business.designimpl.EmployeeImpl;
import btth.config.InputMethods;

import static btth.business.designimpl.DepartmentImpl.departmentList;

public class EmployeeManagement {
    private IEmployee employeeImpl = new EmployeeImpl(departmentList);

    public EmployeeManagement() {

    }

    public void displayEmployeeMenu() {
        while (true) {
            System.out.println("-----------Employee Menu ------------");
            System.out.println("1. HIển thị danh sách thông tin tất cả nhân viên(mã nhân viên và tên)");
            System.out.println("2. Xem chi tiết thông tin nhân viên theo mã nhân viên (toàn bộ thông tin)");
            System.out.println("3. Thêm mới nhân viên");
            System.out.println("4. Chỉnh sửa thông tin nhân viên");
            System.out.println("5. Xóa nhân viên ");
            System.out.println("6. Thống kê số lượng nhân viên trung bình của mỗi phòng ");
            System.out.println("7. Tìm ra 5 phòng có số lượng nhân viên đông nhất");
            System.out.println("8. Tìm ra người quản lý nhiều  nhân viên nhất");
            System.out.println("9. Tìm ra 5 nhân viên có tuổi cao nhất công ty");
            System.out.println("10. Tìm ra 5 nhân viên hưởng lương cao nhất");
            System.out.println("0. Quay lại");
            System.out.println("Nhâp lưa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    employeeImpl.showAll();
                    break;
                case 2:
                    employeeImpl.showId();
                    break;
                case 3:
                    employeeImpl.addNew();
                    break;
                case 4:
                    employeeImpl.edit();
                    break;
                case 5:
                    employeeImpl.delete();
                    break;
                case 6:
                    employeeImpl.averageEmployeesPerDepartment();
                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 0:
                    return;
                default:
                    System.err.println("Nha ko dung lua chọn, nhạp lại");
            }
        }
    }
}