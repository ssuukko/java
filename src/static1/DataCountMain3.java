package static1;

public class DataCountMain3 {
    public static void main(String[] args) {
        Data3 data1 = new Data3("A");
        System.out.println("A count=" + Data3.count);// 왜 Data1.이 아닌 Data3. 일까? -> Data3 클래스에 직접 접근하는 느낌


        Data3 data2 = new Data3("B");
        System.out.println("B count=" + Data3.count);

        Data3 data3 = new Data3("C");
        System.out.println("C count=" + Data3.count);

        /*Static을 사용하게 되면 메서드 영역에 counte ++*/

        //추가
        //인스턴스를 통한 접근
        Data3 data4 = new Data3("D");
        System.out.println(data4.count);// 권장 안함 -> Static 변수로 가는것 같지가 않음

        //클래스를 통한 접근
        System.out.println(Data3.count);
    }
}
