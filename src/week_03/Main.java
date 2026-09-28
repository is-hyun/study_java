package week_03;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[] {
                new Dog("강아지"),
                new Cat("고양이"),
                new Tiger("호랑이")
        };

        for (Animal animal : animals) {
            System.out.println("동물 이름 : " + animal.name);
            System.out.print("소리 : ");
            animal.sound();
        }
    }
}
