package hu.me.krz.haladojava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Proba 
{
    public static void main( String[] args )
    {
        System.out.println("Irjon be egy szamot!");
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        sc.close();
        
        Diak[] students = new Diak[arraySize];
        for (int i = 0; i<arraySize; i++) {
            Diak student = new Diak((int)(Math.random() * 6), ((int) (Math.random() * 8) + 18), "Diak" + i);
            students[i] = student;
        }
        
        Arrays.sort(students);
        for (int i = 0; i<arraySize; i++) {
//            System.out.println("\n" + students[i].getName());
//            System.out.println(students[i].getAge());
//            System.out.println(students[i].getNumberOfPuska());
            students[i].toString();
        }
    }
}
