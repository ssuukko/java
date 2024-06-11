package construct.ex;

public class BookMain {

    public static void main(String[] args) {
        //기본 생성자 사용
        Book book1 = new Book();
        book1.displayInfo();

        //title 과 author만을 매겨변수 받는 생성자
        Book book2 = new Book("Hello Java", "Seo");
        book2.displayInfo();

        //title 과 author, page를 매겨변수 받는 생성자
        Book book3 = new Book("JPA 프로그래밍", "kim", 700);
        book3.displayInfo();



    }
}
