인스턴스가 필요한 이유는 멤버 변수(인스턴스 변수)등을 사용하는 목적이 큰데
DecoUtill1은 단순히 기능만 제공만 제공한다.


DecoUtill2는 메세드 앞에 static이 붙어있다. 이렇게 하면 정적 메서드는 정적 변수처럼 
인스턴스 생성 없이 클래스 명을 통해서 호출할 수 있다.
```java
String deco = DecoUtil2.deco(s);
```

정적 메서드는 공용 기능

static 메서드 본인은 static이 붙여있는 것만 사용할 수있음
```java
    public static void staticCall(){
//        instanceValue++; //인스턴스 변수 접근, compile error
//        instanceMethod(); //인스턴스 메서드 접근, compile error

        staticValue++; //정적 변수에 접근
        staticMethod(); //정적 메소드에 접근
    }
```
그러나 모든 곳은 static을 호출할 수 있다.
```java
public void instanceCall(){
instanceValue++; //인스턴스 변수 접근
instanceMethod(); //인스턴스 메서드 접근

        staticValue++;//정적 변수에 접근
        staticMethod();//정적 메소드에 접근
    }
```