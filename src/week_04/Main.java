package week_04;

public class Main {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        // 1. 생산자 스레드
        Thread producer = new Thread(() -> {
            while(true) {
                try {
                    warehouse.produce();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("생산자 스레드 종료");
                    break;
                }
            }
        }, "생산자");

        // 2. 소비자 스레드
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    warehouse.consume();
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    System.out.println("소비자 스레드 종료");
                    break;
                }
            }
        }, "소비자");

        producer.start();
        consumer.start();

    }
}
