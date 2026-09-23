package week_02.hybrid;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        HybridCar2 car = new HybridCar2();
        Scanner sc = new Scanner(System.in);
        System.out.print("제어 패널 입력 (Speed : ○○km/h) : ");
        String input = sc.nextLine();

        car.drive(input);
    }
}
