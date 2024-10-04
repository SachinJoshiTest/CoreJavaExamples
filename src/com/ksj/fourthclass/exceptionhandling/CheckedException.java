package com.ksj.fourthclass.exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {
    public static void main(String[] args) {
        //Exceptions which should be caught else give error like FileNotFoundException

        FileReader f = null;
        try {
            //You will get the Error printed catch block if the file is not present in the specified path.
            f = new FileReader("D:\\Test\\test.txt");

            while(f.read() != -1)
            {
                System.out.println(f.read());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading test file "+ e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading test file "+ e.getMessage());
        }
    }
}
