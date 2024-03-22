package btth.business.designimpl;

import btth.business.design.IDepartment;
import btth.business.entity.Department;
import btth.business.entity.Employee;
import btth.config.InputMethods;
import java.util.ArrayList;
import java.util.List;

public class DepartmentImpl implements IDepartment {
    public static List<Department> departmentList = new ArrayList<>();

    private Department findDepartmentById(String departmentId) {
        return departmentList.stream()
                .filter(department -> department.getDepartmentId().equals(departmentId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void showAll() {
        departmentList.forEach(department -> System.out.println("Department ID: " + department.getDepartmentId() + ", Department Name: " + department.getDepartmentName()+ ", Department Total Members: " + department.getTotalMembers()));
    }

    @Override
    public void addNew() {
        System.out.println("Nhập vào số lượng cần thêm");
        byte count = InputMethods.getByte();
        // duyệt
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhập thông tin cho phòng ban thứ " + i);
            Department department = inputData(true);
            // thêm vào list
            departmentList.add(department);
        }
        System.out.println("Đã thêm thành công " + count + " phòng ban");
    }

    @Override
    public void edit() {
        System.out.println("Nhập id của phòng ban cần sử thông tin");
        String idEdit = InputMethods.getString();
        Department departmentEdit = findDepartmentById(idEdit);
        if (departmentEdit == null) {
            System.err.println("Không tìm thấy");
        } else {
            // hiển thi thông tin cũ
            System.out.println("thông tin cũ là :");
            System.out.println(departmentEdit);
            System.out.println("Nhập thông tin mới");
            departmentEdit= inputData(false);
            departmentEdit.setDepartmentId(idEdit); // ko thay đổi id
            // set nó la vào danh sách
            departmentList.set(departmentList.indexOf(findDepartmentById(idEdit)),departmentEdit);
            System.out.println("Đã cập nhật thông tin");
        }
    }

    @Override
    public void showId() {
        System.out.println("Nhập id của phòng ban cần hiển thị");
        String idShow = InputMethods.getString();
        Department departmentTshow = findDepartmentById(idShow);
        if (departmentTshow == null) {
            System.err.println("Không có phong ban nào");
        } else {
            System.out.println(departmentTshow);
        }
    }

    @Override
    public void delete() {
        System.out.println("Nhập id của phòng ban cần xóa");
        String idDel = InputMethods.getString();
        Department departmentDel = findDepartmentById(idDel);
        if (departmentDel == null) {
            System.err.println("Không tim thấy");
        } else {
            departmentList.remove(departmentDel);
            System.out.println("Xóa thanh công");
        }
    }

    @Override
    public Department inputData(boolean isAdd) {
        Department newDep = new Department();
        System.out.println("Nhập mã phòng ban :");
        newDep.setDepartmentId(InputMethods.getString());
        System.out.println("Nhập tên phòng ban:");
        newDep.setDepartmentName(InputMethods.getString());
        System.out.println("Tổng số nhân viên trong phòng");
        newDep.setTotalMembers(InputMethods.getInteger());
        return newDep;
    }
}