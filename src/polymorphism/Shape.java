package polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Shape {

    public void area(){
        System.out.println("No Implementation");
    }

    public void area(int x){
        System.out.println("Calling a random Area method for Shape");
        List<String> a = new ArrayList<>();
    }

    public void area(int x, int y){

    }

}
