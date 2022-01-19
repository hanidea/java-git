package test;

public class Container {
    public void getBean(){
        IC ic = new C();
        A a = new A(ic);
        A a1 = new A();
        a1.setIc(ic);
    }
}
