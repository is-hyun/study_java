package week_02.hybrid;

public class HybridCar extends Car{

    // 메서드 1
    public int parseSpeedSetting(String input) {
        String step1 = input.trim().toUpperCase();
        // 80
        String step2 = step1.replace("SPEED : ", "").replace("KM/H", "");
        return Integer.valueOf(step2);
    }

    // 메서드 2
    @Override
    public void drive(int speed) {
        if (speed < 60) {
            System.out.printf("[EV 모드 가동] :  전기 모터로 소음 없이 %dkm/h로 주행합니다.", speed);
        } else {
            super.drive(speed);
            System.out.println(" -> [하이브리드 모드] 전기 모터가 출력을 보조합니다.");
        }
    }
}
