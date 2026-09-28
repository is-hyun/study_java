package week_03;

public class Tiger extends Animal{
    public Tiger(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("어흥");
    }
}
