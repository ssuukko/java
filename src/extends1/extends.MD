**상속 관계**
- 기존 클래스의 메서드를 새로운 클래스에서 재사용하게 해준다.
- 속성과 기능을 그대로 물려받는다.
- 상속을 하려면 `extends`해주면 되는데 `extends` **대상은 하나만 선택**할 수 있다.

**부모 클래스 (슈퍼 클래스)** : 상속을 통해 자신의 필드와 메서드를 클래스에 제공하는 클래스
**자식 클래스 (서브 클래스)** : 부모 클래스로부터 필드와 메서드를 상속받는 클래스

자식 클래스는 부모 클래스의 기능을 물려받기 때문에 접근할 수 있지만, 그 반대는 아니다.\
부모 코드를 보면 자식에 대한 정보가 없다. 하지만 자식 클래스의 코드에는 `extends Car`를 통해 부모를 알고 있다.

두가지 부모를 갖는 다중상속은 허용하지 않는다.\
단적인 예를 들어 비행기와 차를 상속받아 하늘을 나는 자동차를 만든다고 가정했을 때
두 move를 호출했을 때 두 부모의 move 중 어떤것을 사용해야 할지 애매한 문제가 발생한다.

```java
ElectricCar electricCar = new ElectricCar();
```
- new ElectricCar()를 호출하면 ElectricCar 뿐만 아니라 상속 관계에 있는 Car까지 함께 포함해서 인스턴스 생성
- 다만 참조값은 하나

```java
electricCar.charge();
```
electricCar.charge();를 호출하게 되면 상속관계의 경우 부모와 자식이 하나의 참조값에 들어있다.\
이런 경우 `호출하는 변수의 타입(클래스)을 기준으로 선택`한다.
`electricCar` 변수의 타입이 ElectricCar 이므로 인스턴스의 내부에 같은 타입인 ElectricCar를 통해서 charge()호출

```java
electricCar.move();
```
electricCar.charge();를 호출하게 되면 상속관계의 경우 부모와 자식이 하나의 참조값에 들어있다.\
이런 경우 `호출하는 변수의 타입(클래스)을 기준으로 선택`한다.
`electricCar` 변수의 타입이 ElectricCar 이므로 인스턴스의 내부에 같은 타입인 ElectricCar에 move()가 없다면
부모 클래스로 가서 move()를 찾고 호출

**상속과 메서드 오버라이딩**
- 부모 타입의 기능을 자식에서는 다르게 재정의 하고 싶을 때 사용
- 부모에게서 상속받은 기능을 자식이 **재정의 하는 것을 메서드 오버라이딩(Overriding)**

```java
package extends1.overriding;

public class Car {

    public void move(){
        System.out.println("차를 이동합니다.");
    }

    //추가
    public void openDoor(){
        System.out.println("문을 엽니다.");
    }

}

```
위에 move()라는 메서드가 존재
```java
 package extends1.overriding;

public class ElectricCar extends Car {
    @Override
    public void move(){
        System.out.println("전기차가 빠르게 이동합니다.");
    }

    public void charge(){
        System.out.println("충전합니다.");
    }
}
```
Car를 상속 받았지만 move()라는 기능을 재정의 하고 싶어서 `@Override`를 붙이고 overriding

**메서드 오버로딩과 오버라이딩**
- 메서드오버로딩(Overloading)
  - 메서드 이름이 같고 매개변수(파라미터)가 다른 메서드를 여러개 정의하는 것
  - 같은 이름의 메서드를 여러개 정의하는 것
- 메서드오버라이딩(Overriding)
  - 하위 클래스에서 상위 클래스의 메서드를 재정의 하는 것

**super**
부모와 자식의 필드명이 같거나 메서드가 오버라이딩 되어 있으면, 자식에서 부모의 필드나 메서드를 호출할 수 없다.
>강의 설명 중 Main에서 method를 부르면 먼저 자식에게서 찾고 없으면 부모에서 찾는다고 함

`super`키워드를 사용하면 부모를 참조할 수 있다.

**super 생성자**
상속 관계에서 인스턴스를 생성하면 결국 메모리 내부에는 자식과 부모클래스가 각각 다 만들어진다.\
`Child`를 만들면 `Parent`까지 함께 만들어진다.
따라서 각각의 생성자도 모두 호출되어야 한다.

`규칙`**상속 관계를 사용하면 자식 클래스에서 부모 클래스의 생성자를 반드시 호출해야 한다.**\
상송 관계에서 부보의 생성자를 호출할 때 ``super``를 사용하면 된다.

- 상속 관계의 생성자 호출은 결과적으로 부모에서 자식순서로 실행된다. 
- 상속 관계에서 자식 클래스의 생성자 첫줄은 반드시 super를 호출해야 한다. 단 기본 생성자인 경우에는 생략 가능

