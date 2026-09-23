package week_02.hybrid;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HybridCar car = new HybridCar();
        Scanner sc = new Scanner(System.in);
        System.out.print("제어 패널 입력 (Speed : ○○km/h) : ");
        String input = sc.nextLine();

        int speed = car.parseSpeedSetting(input);
        car.drive(speed);
    }
}
