```java
package construct;

public class MethodInitMain1 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        member1.name = "user1";
        member1.age = 15;
        member1.grade = 90;

        MemberInit member2 = new MemberInit();
        member2.name = "user2";
        member2.age = 16;
        member2.grade = 80;

        MemberInit[] members = {member1, member2};

        for (MemberInit s : members) {
            System.out.println("이름:"+ s.name +" 나이:"+ s.age +" 성적:"+ s.grade);
        }

    }
}
```
```java
 MemberInit member1 = new MemberInit();
        member1.name = "user1";
        member1.age = 15;
        member1.grade = 90;
```
이 부분의 반복되니까 중복을 없애고 싶어서


```java
package construct;

public class MethodInitMain2 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        initMember(member1,"user1",15,90);

        MemberInit member2 = new MemberInit();
        initMember(member2,"user2",16,80);

        MemberInit[] members = {member1, member2};

        for (MemberInit s : members) {
            System.out.println("이름:"+ s.name +" 나이:"+ s.age +" 성적:"+ s.grade);
        }
    }

    static void initMember(MemberInit member, String name, int age, int grade){
        member.name = name;
        member.age = age;
        member.grade = grade;
    }
}
```
- **initMember**라는 메서드를 통해서 중복 제거
- 그런데 **MemberInit**의 데이터를 변경하는데 객체지향의 관점에서 **MemberInit**에 `initMember`이라는 기능을 넣은것이 좋음
- 그러므로 **initMember**는 Main에서가 아닌 **MemberInit** 클래스에서 관리
```java
package construct;

public class MemberInit {
    String name;
    int age;
    int grade;

    void initMember(MemberInit member, String name, int age, int grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
```

**생성자**
- 프로그래밍을 하다보면 객체를 생성하고 이후에 바로 초기값을 할당해야 하는 경우가 많다.
- 앞선 **initMember**와 같은 메서드를 매번 만들어야만 한다.
- 그렇기에 대부분의 객체 지향 언어는 객체를 생성하자마자 즉시 필요한 기능을 편리하게 수행하도록 `생성자`라는 기능을 제공
- 생성자를 사용하면 객체를 생성하는 시점에 즉시 필요한 기능을 수행할 수 있다.

다음 부분이 생성자이다.
```java
 MemberConstruct(String name, int age, int grade){
        System.out.println("생성자 호출="+ name + " ,age="+ age +" ,grade="+ grade);
        this.name = name;
        this.age = age;
        this.grade =grade;
    }
```
**생성자와 메서드의 차이**
- 생성자의 이름은 클래스 이름과 같아야 한다. 
- 생성자는 반환타입이 없다. 비워두어야 한다
- 나머지는 메서드와 같다.

**생성자의 장점**
- 중복 호출 제거
  - 생성자가 없던 시절에는 생성 직후 어떤 작업을 위해 메서드를 직접 한번 더 호출해야 했다.
  - 생성자가 있어서 객체를 생성하면서 동시에 생성 직후에 필요한 작업을 처리 할 수 있게 되었다.
```java
//생성자 등장 전
MemberInit member = new MemberInit(); member.initMember("user1", 15, 90);
//생성자 등장 후
MemberConstruct member = new MemberConstruct("user1", 15, 90);
```
- 제약
  - initMember()는 실수로 호출하지 않아도 프로그램이 작동한다.
    - ```java
      package construct;
    
      public class MethodInitMain3 {
          public static void main(String[] args) {
              MemberInit member1 = new MemberInit();
              member1.initMember(member1,"user1",15,90);
    
              MemberInit member2 = new MemberInit();
              //실수로 개발자가 생략
      //        member2.initMember(member2,"user2",16,80);
    
              MemberInit[] members = {member1, member2};
    
              for (MemberInit s : members) {
                  System.out.println("이름:"+ s.name +" 나이:"+ s.age +" 성적:"+ s.grade);
              }
          }
    
      }
      ```
    - ```consol
        /Users/shinseokho/Library/Java/JavaVirtualMachines/openjdk-21.0.2/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=49800:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/shinseokho/Desktop/study/java-basic/out/production/java_basic construct.MethodInitMain3
        이름:user1 나이:15 성적:90
        이름:null 나이:0 성적:0
    
        Process finished with exit code 0
        ```
  - 생성자를 쓰게 되면
    - ```java
      package construct;
    
      public class ConstructMain1 {
          public static void main(String[] args) {
              MemberConstruct member1 = new MemberConstruct("user1",15,90);
      //        MemberConstruct member2 = new MemberConstruct("user2",16,80);
              MemberConstruct member2 = new MemberConstruct();
    
              MemberConstruct[] members = {member1, member2};
    
              for (MemberConstruct s : members) {
                  System.out.println("이름:"+ s.name +" 나이:"+ s.age +" 성적:"+ s.grade);
    
              }
          }
      }
      ```
    - ```consol
      /Users/shinseokho/Desktop/study/java-basic/src/construct/ConstructMain1.java:7:35
      java: no suitable constructor found for MemberConstruct(no arguments)
          constructor construct.MemberConstruct.MemberConstruct(java.lang.String,int) is not applicable
            (actual and formal argument lists differ in length)
          constructor construct.MemberConstruct.MemberConstruct(java.lang.String,int,int) is not applicable
            (actual and formal argument lists differ in length)
      ```
      라는 에러 발생
  - 이처럼 생성자의 진짜 장점은 객체를 생성할 때 직접 정의한 생성자가 있다면 **직접 정의한 생성자를 반드시 호출**해야 한다는 점이다.