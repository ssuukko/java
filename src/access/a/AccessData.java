package access.a;

public class AccessData {

    public int publicField;
    int defaultField;
    private int privateField;

    public void publicMethod() {
        System.out.println("publicMethod 호출" + publicField);
    }

     void defaultMethod(){
        System.out.println("defaultField 호출" + defaultField);

    }

    private void privateMethod(){
        System.out.println("privateField 호출" + privateField);

    }

    public void innerMethod(){
        System.out.println("내부 호출");
        publicField = 100;
        defaultField = 100;
        privateField = 100;
        publicMethod();
        defaultMethod();
        privateMethod();

    }
}
