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
