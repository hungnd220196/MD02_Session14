package bt2;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
        // lọc các số chẵn trong mảng
        int[] newArr = Arrays.stream(arr).filter(value -> value%2==0).toArray();
        System.out.println(Arrays.toString(newArr));

    }

}
