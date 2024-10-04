package test2;

import test.Parent;

public class Child2 extends Parent {
    public void test() {
        System.out.println(x);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
