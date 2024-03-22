package btth.presentation;

import btth.business.design.IDepartment;
import btth.business.designimpl.DepartmentImpl;
import btth.config.InputMethods;

public class DepartmentManagement {
    private IDepartment departmentImpl = new DepartmentImpl();

    public void displayDepartmentMenu() {
        while (true) {
            System.out.println("-----------Department Menu ------------");
            System.out.println("1. Hiển thị danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Chỉnh sửa tên phòng ban");
            System.out.println("4. Hiển thị danh sách nhân viên của phòng ban theo mã phòng");
            System.out.println("5. Xóa phòng ban (chỉ xóa khi ko có nhân viên nào) ");
            System.out.println("0. Quay lại");
            System.out.println("Nhâp lưa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    departmentImpl.showAll();
                    break;
                case 2:
                    departmentImpl.addNew();
                    break;
                case 3:
                    departmentImpl.edit();
                    break;
                case 4:
                    departmentImpl.showId();
                    break;
                case 5:
                    departmentImpl.delete();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Nha ko dung lua chọn, nhạp lại");
            }
        }
    }
}