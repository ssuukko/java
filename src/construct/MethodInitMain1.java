package construct;

public class MethodInitMain1 {
    public static void main(String[] args) {
        Memberinit member1 = new Memberinit();
        member1.name = "USER1";
        member1.age = 15;
        member1.grade = 90;

        Memberinit member2 = new Memberinit();
        member2.name = "USER2";
        member2.age = 16;
        member2.grade = 80;

        Memberinit[] members = {member1, member2};

        for (Memberinit s : members) {
            System.out.println("이름: "+ s.name +"나이: "+ s.age +"성적: "+ s.grade);
        }

    }
}
