package test;

public class A {

    private IC ic;
    public A(IC ic){

    }
    public A(){

    }

    public void print(){
        //C c = new C();
        this.ic.print();
    }
    public void setIc(IC ic) {
        this.ic = ic;
    }
}
