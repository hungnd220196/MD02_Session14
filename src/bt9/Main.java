package bt9;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //bt1
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalTime time = LocalTime.now();
        ZonedDateTime zone = ZonedDateTime.of(today, time, ZoneId.of("Asia/Tokyo"));
        System.out.println(zone);
        ZonedDateTime zone1 = ZonedDateTime.of(today, time, ZoneId.of("Australia/Sydney"));
        System.out.println(zone1);
        ZonedDateTime zone2 = ZonedDateTime.of(today, time, ZoneId.of("America/Sao_Paulo"));
        System.out.println(zone2);
        //bt2
        LocalTime timeDate = LocalTime.now();
        System.out.println(timeDate);
        //bt3

        // Nhập hai ngày từ người dùng
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày đầu tiên (yyyy-MM-dd): ");
        String firstDateString = scanner.nextLine();
        System.out.print("Nhập ngày thứ hai (yyyy-MM-dd): ");
        String secondDateString = scanner.nextLine();

        // Chuyển đổi chuỗi ngày thành LocalDate
        LocalDate firstDate = LocalDate.parse(firstDateString);
        LocalDate secondDate = LocalDate.parse(secondDateString);

        // Tính số ngày giữa hai ngày
        long daysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);

        // In kết quả
        System.out.println("Số ngày giữa " + firstDate + " và " + secondDate + " là: " + daysBetween);


    }
}
