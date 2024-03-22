package bt6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("hung","a","b","c");
//       String newStr = list.stream().map(String::toUpperCase).toString();
//        System.out.println(newStr);
        List<String> list = new ArrayList<String>();
        list.add("hung");
        list.add("hung2");
        list.add("hung3");
        list.add("hung4");
        list.stream().map(String::toUpperCase).toList().forEach(System.out::println);

    }
}
