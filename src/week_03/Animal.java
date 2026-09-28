package week_03;

public class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
    }
    public void sound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}
