package final1.ex;

public class MemberMain {

    public static void main(String[] args) {
        Member member = new Member("MyId", "Kim");
        member.print();
        member.changeData("MyId2", "seo");
        member.print();
    }
}
