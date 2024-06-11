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
