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

****멤버머서드****
- 인스턴스 메서드 : static이 붙지 않은 멤버 메서드
- 클래스 메서드 : static이 붙은 메서드


```java
//인스턴스를 통한 접근
DecoData data3 = new DecoData();
data3.staticCall();

//클래스를 통한 접근
staticCall();
```
위와 아래의 실행 결과는 같다.\
하지만 위에것은 static 메서드를 실행함에 있어 굳이 인스턴스를 거친다.\
뿐만아니라 타인이 봤을떄 밑에것이 바로 static 메서드에 접근한다는 것을 쉽게 알 수 있다.

 