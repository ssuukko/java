package static2;

public class DecoMain1 {

    public static void main(String[] args) {
        String s = "hello java";
        DecoUtil1 utils = new DecoUtil1();
        String deco = utils.deco(s);

        System.out.println("before deco: " + s);
        System.out.println("after: " + deco);
    }
//    static을 사용했기 때문에 MAIN함수에서 속성같이 사용 가능
//    String deco = DecoUtil2.deco(s);
}
