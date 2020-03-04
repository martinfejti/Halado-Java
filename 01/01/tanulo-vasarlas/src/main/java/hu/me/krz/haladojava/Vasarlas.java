package hu.me.krz.haladojava;

import java.util.ArrayList;

public class Vasarlas 
{
    public static void main( String[] args )
    {
        ArrayList<Tanulo> students = new ArrayList<Tanulo>();
        
        //create students
        for (int i = 0; i < 5; i++) {
            Tanulo student = new Tanulo("Tanulo" + i);
            students.add(student);
        }
        
        //do shipping
        for (int i = 0; i < 6; i++) {
            double avg = 0;
            int sum = 0;
            for (int j = 0; j < students.size(); j++) {
                if (students.get(j).consumption((int) (Math.random() * 1501) + 1500) == false) {
                    sum += students.get(j).getMoney();
                    System.out.println("ooo " + sum);
                    students.get(j).toString();
                } else {
                    students.get(j).decreaseNumberOfStudents();
                }
            }
            avg = sum/students.size();
            System.out.println("Atlag: " + avg);
        }
        
        System.out.println("Ennyi tanuló maradt: " + students.size());
    }
}
