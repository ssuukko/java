final 키워드는 이름 그대로 끝
- 더는 값을 변경할 수 없음을 뜻한다.
- class, method를 포함한 여러 곳에 붙을 수 있다.

```java
System.out.println("필드 초기화");
FieldInit fieldInit1 = new FieldInit();
FieldInit fieldInit2 = new FieldInit();
FieldInit fieldInit3 = new FieldInit();
System.out.println(fieldInit1.value);
System.out.println(fieldInit2.value);
System.out.println(fieldInit3.value);
//이미 fieldInit에 10이 final
```
이렇게 되면 인스턴스에 10이 계속 할당됨 중복

그렇기에 


```java
package final1;

public class FieldInit {
    
    static final int CONST_VALUE = 10; 
    final int value = 10;
}

```
static final int CONST_VALUE = 10; 라는 공용 변수를 사용(중복 방지)

**상수**는 변하지 않고 항상 일정한 수, 대문자로 표현, 구분은 `_`로 표현
- 상수는 기능이 아니라 고정된 값 자체를 사용하는 것이 목적이.
- 상수는 값을 바꿀 수 없다. 필드에 직접 접근해도 데이터가 변하는 문제가 발생하지 않는다.

```java
package final1;

public class ConstantMain1 {

    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 " + 999);
        int currentUserCount = 999;
        process(currentUserCount++);
        process(currentUserCount++);
        process(currentUserCount++);
    }

    private static void process(int currentUserCount) {
        System.out.println("참여자 수" + currentUserCount);
        if (currentUserCount > 999) {
            System.out.println("대기자로 등록합니다.");
        }else{
            System.out.println("게임에 참여합니다.");
        }
    }
}
```
```java
package final1;

public class ConstantMain1 {

    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 " + 2000);
        int currentUserCount = 2000;
        process(currentUserCount++);
        process(currentUserCount++);
        process(currentUserCount++);
    }

    private static void process(int currentUserCount) {
        System.out.println("참여자 수" + currentUserCount);
        if (currentUserCount > 2000) {
            System.out.println("대기자로 등록합니다.");
        }else{
            System.out.println("게임에 참여합니다.");
        }
    }
}
```
>위와 같은 코드를 설계한 경우 1000이라는 숫자가 무엇을 의미하는지? 바로 확인할 수 없고,
> 참여자의 수용 인원을 2000이라는 수로 바꾸고 싶을 경우 2번째 코드처럼 모든 코드를 바꿔야 한다.

```java
package final1;

public class ConstantMain1 {

    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 " + Constant.MAX_USERS);
        int currentUserCount = 999;
        process(currentUserCount++);
        process(currentUserCount++);
        process(currentUserCount++);
    }

    private static void process(int currentUserCount) {
        System.out.println("참여자 수" + currentUserCount);
        if (currentUserCount > Constant.MAX_USERS) {
            System.out.println("대기자로 등록합니다.");
        }else{
            System.out.println("게임에 참여합니다.");
        }
    }
}
```
```java
package final1;

public class Constant {
//수학 상수
public static final double PI = 3.14;
//시간 상수
public static final int HOURS_IN_DAY = 24;
public static final int MINUTES_IN_HOURS = 60;
public static final int SECONDS_IN_HOURS = 60;
//애플리케이션 설정 상수
public static final int MAX_USERS = 2000;
}
```
>하지만 상수 MAX_USERS를 가져올 경우 Constant에 public static final int MAX_USERS = 2000; 으로만 바꿔주면 된다.