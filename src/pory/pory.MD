**다형성**
- 다양한 형태, 여러 형태
- 한 객체가 여러 타입의 객체로 취급될 수 있는 능력
- 보통 하나의 객체는 하나의 타입으로 고정, 그런데 다형성을 사용하면 하나의 객체가 다른 타입으로 사용될 수 있음

**다형적 참조**
- 부모 타입의 변수가 자식 인스턴스 참조
  - ```java
      //부모 변수가 자식 인스턴스 참조(다형적 참조)
      System.out.println("Parent -> Child");
      Parent poly = new Child();
      poly.parentMethod();
    ```
- 부모 타입은 자식 타입을 담을 수 있다.
  - Parent poly 부모 타입이다. new Child()를 통해 생성된 결과는 Child 타입이다.
    Parent poly = new Child(); : 성공
- 반대로 자식 타입은 부모 타입을 담을 수 없다.
  - Child child1 = new Parent();     : 실패

```java
        //자식의 기능은 호출 할 수 없다.
        Parent poly = new Child();
        poly.childMethod();
```
1. 참조값을 통해 인스턴스를 찾는다.
2. 다음으로 인스턴스 안에서 실행할 타입을 찾는다.
3. 호출자 poly는 Parent 타입이다.
4. 따라서 Parent 클래스부터 시작해서 기능을 찾는다.
5. 그건더 상속 관계는 부모 방향으로 찾아 올라갈 수 는 있지만 자식 방향으로 찾아 내려갈 수는 없다.
6. 따라서 컴파일 오류

**다운캐스팅**
그럼에도 자식의 메소드를 실행하고 싶다면
```java
    public static void main(String[] args) {
        //부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent poly = new Child(); //x001
        //단 자식의 기능은 호출할 수 없다. 컴파일 오류 발생
        //poly.childMethod();

        //다운캐스팅(부모 타입 -> 자식 타입)
        Child child = (Child) poly; //x001
        child.childMethod();
    }
```
1. Child child = (Child) poly; 다운캐스팅을 통해 부모타입을 자식 타입으로 변환한 다음에 대입 시도
2. Child child = (Child) child; //x001 참조값을 읽은 다음 자식 타입으로 지정
3. Child child = x001 최종 결과

**캐스팅의 정류**
- 일시적 다운 캐스팅
- 업캐스팅

**캐스팅이 불가능한 경우**
객체를 생성하면 본인과 본인의 부모만 생성
```java
     Parent parent2 = new Parent();
     Child child2 = (Child) parent2; // 런타임 오류 - ClassCastException
     child2.childMethod(); // 실행 불가
```
1. Parent 타입의 객체 생성
2. 메모리 상에는 자식 타입이 존재하지 않는다.
3. Child 타입으로 다운 캐스팅, 메모리 상에는 Child 존재하지 않는다.
4. 그러므로 오류 발생

**업캐스팅이 안전하고 다운캐스팅이 위험한 이유**
- 업캐스팅은 객체를 생성하면 해당 타입의 상위 부모 타입은 모두 함꼐 생성한다.
- 위로만 타입을 변경하는 업캐스팅은 메모리 상에 인스턴스가 모두 존재하기 때문에 항상 안전하다.
- 다운캐스팅의 경우 인스턴스에 존재하지 않는 하위 타입으로 캐스팅하는 문제 발생
- 객체를 생성하면 부모 타입은 모두 함께 생성되지만 자식 타입은 생성되지 않는다.

**컴파일 오류 vs 런타임 오류**
- **컴파일 오류**
  - 변수명 오타, 잘못된 클래스 이름 사용 등 자바 프로그램을 실행하기 전에 발생하는 오류
  - IDE에서 즉시 확인할 수 있기 때문에 안전하고 좋은 오류다.
- **런타임 오류**
  - 프로그램이 실행되고 있는 시점에 발생하는 오류
  - 보통 고객이 해당 프로그램을 실행하는 도중 발생
  - 매우 안종은 오류

**instanceof**
- 참조하는 대상이 다양하기 때문에 어떤 인스턴스를 참조하고 있는지 확인
  - instanceof 키워드는 오른쪽 대상의 자식 타임을 왼쪽에서 참조하는 경우에도 true 반환
    - ```java
        parent instanceof Parent //parent는 Child의 인스턴스
        new Parent() instanceof Parent // parent가 Parent의 인스턴스를 참조하는 경우 : true
        new Child() instanceof Parent // parent가 Child 인스턴스를 참조하는 경우 : true
      ```
    - ```java
      new Parent() instanceof Parent
      Parent p = new Parent() //같은 타입 true

      new Child() instanceof Parent
      Parent p = new Child() //부모는 자식을 담을 수 있다. true
      
      new Parent() instanceof Child
      Child c = new Parent() //자식은 부모를 담을 수 없다. false new Child() instanceof Child
      Child c = new Child() //같은 타입 true
      ```
 
**Pattern Matching for instanceof**
기존
```java
 private static void call (Parent parent) {
        parent.parentMethod();
        if (parent instanceof Child) {
            System.out.println("Child 인스턴스 맞음");
            Child child = (Child) parent;
            child.childMethod();
        }
    }
```
변수 생성
```java
 private static void call (Parent parent) {
        parent.parentMethod();
        //Child 인스턴스인 경우 childMethod() 실행
        if (parent instanceof Child child) {
            System.out.println("Child 인스턴스 맞음");
            child.childMethod();
        }
    }
```

**다형성과 메서드 오버라이딩**
**오버라이딩 된 메서드가 항상 우선권을 가진다**

**추상 클래스**
- 동물(Animal)과 같이 부모 클래스는 제공하지만, 실제 생성되면 안되는 클래스를 추상 클래스라 한다.
- 이름 그대로 추상적인 개념을 제공하는 클래스.
- 실체인 인스턴스가 존재하지 않는다.
- 추상 클래스는 클래스를 선언할 때 `abstract` 키워드를 붙여주면 된다.
- 추상 클래스 덕분에 실수로 Animal 인스턴스를 생성할 문제를 근본적으로 방지해준다.

**추상 메서드**
- 부모 클래스를 상속 받는 클래스가 반드시 오버라이딩 해야 하는 메서드를 부모 클래스에 정의 할 수 있다.
- 추상 메서드가 하나라도 있는 클래스는 무조건 추상 클래스여야 함
- 실체는 존재하지 않고, 메서드 바디가 없다.
- 메서드 앞에 `abstract` 키워드를 붙여주면 된다.
- 추상 메세드 덕분에 새로운 동물의 클래스를 만들때 실수로 sound()를 오버라이딩 하지 않을 문제를 근본적으로 방지해준다.

**순수 추상 클래스**
- 모든 메서드가 추상 메서드인 추상 클래스
- 상속하는 클래스는 모든 메세드를 구현해야 한다.
- 인스턴스를 생성할 수 없다.

**인터페이스**
- 자바는 순수 추상 클래스를 더 편리하게 사용할 수 있는 인터페이스 기능을 제공
- class가 아닌 `interface`키워드 사용하면 된다.
- 인터페이스의 모든 메서드는 모두 `public`, `abstract`이다.
- 메서드에 public abstract 는 생략 가능
- 다중 구현(다중 상속)을 지원한다.
- 인터페이스에서 멤버 변수는 public, static, final이 모두 포함되었다고 간주

**상속 vs 구현**
- 부모 클래스의 기능을 자식 클래스가 상속 받을때, 클래스는 상속받는다고 표현하지만, 부모 인터페이스의 기능을 자식이 상속 받을 때는 인터페이스를 구현한다고 표현
- 상속은 이름 그대로 부모의 기능을 물려받는 것이 목적
- 인터페이스는 모든 메서드가 추상 메서드다. 따라서 물려받을 수 있는 기능이 없고, 오히려 인터페이스에 정의한 모든 메서드를 자식이 오버라이딩 해서 기능을 구현해야 한다.

**인터페이스를 사용해야 하는 이유**
- **제약**
  - 인터페이스를 구현하는 곳에서 인터페이스의 메서드를 반드시 구현해라는 규약(제약)을 주는 것이다.
  - 순수 추상 클래스의 경우 미래에 실행 가능한 메서드를 끼워 넣을수 있다. 그러면 추가된 기능을 자식이 구현하거나 구현하지 않을수 있고 더는 순수한 추상 클래스가 아니다.
  - 인터페이스는 모든 메서드가 추상 메서드이다.
  - 이런 문제를 원천 차단
- **다중 구현**
  - 자바에서 클래스 상속은 부모를 하나만 지정할 수 있다.
  - 반면 인터페이스는 부모를 여러명 두는 다중 구현(다중 상속)이 가능하다.

**OCP 원칙**
좋은 객체 지향 설계 원칙
- Open for extension : 새로운 기능의 추가나 변경 사항이 생겼을 때, 기존 코드는 확장할 수 있다.
- Closed for modification : 기존의 코드는 수정하지 않아야 한다. 
- 확장에는 열려있고, 변경에는 닫혀 있다
- 기존의 코드 수정 없이 새로운 기능을 추가할 수 있다.

**전략 패턴(Strategy pattern)**
- 디자인 패턴
- 알고리즘을 클라이언트 코드의 변경 없이 쉽게 교체할 수 있다.
- Car 인터페이스가 바로 전략을 정의하는 인터페이스가 되고 각각의 차량이 구체적인 구현
- 전략을 클라이언트 코드(Driver)의 변경 없이 쉽게 교체할 수 있다.
