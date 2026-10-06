package week_04;

public class Warehouse {

    private int num = 1;
    private int max_cap = 5;
    private int now_cap = 0;

    public synchronized void produce() throws InterruptedException {
        while (now_cap >= max_cap) {
            wait();

        }
        now_cap++;
        System.out.println("[" + num + "] 제품 생산 완료 | 창고 현황 : " + now_cap);
        num++;
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (now_cap <= 0) {
            wait();
        }
        now_cap--;
        System.out.println("[" + num + "] 제품 소비 완료 | 창고 현황 : " + now_cap);
        num++;
        notifyAll();
    }
}
