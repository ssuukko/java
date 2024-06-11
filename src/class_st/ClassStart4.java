package class_st;

public class ClassStart4 {
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

        Student[] students = {student1, student2};

//        for (int i= 0 ; i<students.length ; i++){
//            System.out.println("이름: "+students[i].name + " 나이: " + students[i].age + " 성적: "+ students[i].grade);
//        }
        for (int i= 0 ; i<students.length ; i++){
            Student s = students[i];
            System.out.println("이름: "+s.name + " 나이: " + s.age + " 성적: "+ s.grade);
        }

        for(Student s : students){
            System.out.println("이름: "+s.name + " 나이: " + s.age + " 성적: "+ s.grade);
        }

        for (Student s : students) {
            System.out.println("이름: "+s.name + " 나이: " + s.age + " 성적: "+ s.grade);
        }

    }
}
