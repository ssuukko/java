package pory.ex4;

public class Cat extends AbstractAnimal {
    @Override
    public void sound() {
        System.out.println("야옹");
    }

    @Override
    public void move() {
        System.out.println("고양이의 이동");
    }
}
