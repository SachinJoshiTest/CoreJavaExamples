package advjavac1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student{
    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "{" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ListExamples {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student s;
        for(int i=0;i<10;i++){
            s = new Student(i+1, "Student"+(i+1));
            students.add(s);
        }
        Iterator student = students.iterator();
        while(student.hasNext()){
            System.out.println(student.next());
        }
    }
}
