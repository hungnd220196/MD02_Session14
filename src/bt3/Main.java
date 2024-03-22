package bt3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
        int tong = Arrays.stream(arr).reduce(0,Integer::sum);
        System.out.println(tong);
    }
}
