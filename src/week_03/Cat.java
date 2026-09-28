package week_03;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("야옹");
    }
}
