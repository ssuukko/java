package static2;

public class DecoUtil1 {

    public String deco(String str){
        String result = "*" + str + "*";
        return result;

    }
//    static을 쓰지 않게되면 MAIN함수에서 인스턴스를 생성해줘야 사용이 가능
//    -> 인스턴스가 있어야 사용가능해서  인스턴스 메소드
//    DecoUtil1 utils = new DecoUtil1();

}
