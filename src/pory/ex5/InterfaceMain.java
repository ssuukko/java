package pory.ex5;

public class InterfaceMain {

    public static void main(String[] args) {
        //인터페이스 생성 불가
        //InterfaceAnimal interfaceAnimal = new InterfaceAnimal();

        Cat cat = new Cat();
        Cow cow = new Cow();
        Dog dog = new Dog();

        soundAnimal(cat);
        soundAnimal(cow);
        soundAnimal(dog);
    }

    public static void soundAnimal(InterfaceAnimal interfaceAnimal) {
        System.out.println("동물 이동 테스트 시작");
        interfaceAnimal.sound();
        System.out.println("동물 이동 테스트 종료");
    }
}
