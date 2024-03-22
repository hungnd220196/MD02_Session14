package bt5;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
        System.out.println("Mời người dùng nhập ");
        int number = scanner.nextInt();
        int[] newArr = Arrays.stream(arr).filter(e -> e > number).toArray();
        System.out.println(Arrays.toString(newArr));
    }
}
