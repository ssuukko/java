인스턴스에 사용되는 멤버 변수 count 값은 인스턴스 끼리 서로 공유되지 않는다.
```java
package static1;

public class DataCountMain1 {
    public static void main(String[] args) {
        Data1 data1 = new Data1("A");
        System.out.println("A count=" + data1.count);
        System.out.println(data1);

        Data1 data2 = new Data1("B");
        System.out.println("B count=" + data2.count);
        System.out.println(data2);

        Data1 data3 = new Data1("C");
        System.out.println("C count=" + data3.count);
        System.out.println(data3);

        /*다 다른 힙영역안에 인스턴스로 만들어져서 count는 각 인스턴스의 값인 1*/
    }
}
```

위의 방식으로 하면 각각의 인스턴스가 생성되서 본래 원했던 count의 누적이 발생치 않음/
외부에 Counter라는 인스턴스를 두어 공용으로 사용하게 하면 count는 객체가 생성될 때 마다 값이 누적(증가)


그런데 외부에 도움을 받지 않고는 방법이 없을까?
>Static 변수(정적 변수, 클래스 변수)

