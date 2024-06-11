package class_st;

public class ClassStart3 {
    public static void main(String[] args) {
        Student student1;// Student 타입을 받을수 있는 student1 변수 선언
        student1 = new Student();//Student를 기반으로 메모리에 실제 Student 객체를 생성
        student1.name = "학생1";
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 16;
        student2.grade = 80;

        System.out.println(student1);
        System.out.println(student2);


        System.out.println("이름: "+student1.name + " 나이: " + student1.age + "성적: "+ student1.grade);
        System.out.println("이름: "+student2.name + " 나이: " + student2.age + "성적: "+ student2.grade);

    }
}
