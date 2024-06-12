package final1;

public class ConstructInit {

    final int value; // final을 필드에 사용할 경우에는 생성자를 통해서만 값을 넣어줄 수 있음

    public ConstructInit(int value) {
        this.value = value;
    }
}
