import polymorphism.Test;
import polymorphism.Test2;
import test.Parent;
public class HelloWorld extends Parent{

    public HelloWorld(){
        super(5);
    }

    public static void main(String[] args) {
        Test a = new Test2();
        a.test();
    }

}
