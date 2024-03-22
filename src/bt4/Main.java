package bt4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Bước 1: Tạo một danh sách chuỗi
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("f");
        strings.add("e");
        strings.add("c");

        // Bước 2: Sử dụng Stream API và phương thức sorted() để sắp xếp danh sách theo thứ tự bảng chữ cái
        List<String> sortedStrings = strings.stream()
                .sorted()
                .collect(Collectors.toList());

        // In ra danh sách đã sắp xếp
        System.out.println("Danh sách sau khi sắp xếp:");
        sortedStrings.forEach(System.out::println);
    }


}
