package bt1;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Khởi tạo mảng có 100 phần tử
        int[] arr = new int[100];

        // Tạo đối tượng Random
        Random random = new Random();

        // Điền mảng với các số ngẫu nhiên từ 1 đến 1000
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000) + 1;

        }
        int max = Arrays.stream(arr).max().getAsInt();
        // In ra các phần tử trong mảng
        System.out.println("Các phần tử trong mảng là:");
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("Số lớn nhất trong mảng là: " + max);


    }
}
