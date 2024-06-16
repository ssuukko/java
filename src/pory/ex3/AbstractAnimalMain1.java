package pory.ex3;

public class AbstractAnimalMain1 {

    public static void main(String[] args) {
        //추상클래스 생성 불가
        //AbstractAnimal abstractAnimal = new AbstractAnimal();

        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();
        Duck duck = new Duck();

        cat.sound();
        cat.move();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(cow);
        soundAnimal(duck);
    }

    public static void soundAnimal(AbstractAnimal abstractAnimal) {
        System.out.println("동물 소리 테스트 시작");
        abstractAnimal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
