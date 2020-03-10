package hu.me.krz.haladojava;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ProbaTest 
{
    /**
     * Rigorous Test :-)
     */
    @Ignore
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Ignore
    @Test
    public void getName() {
        String name = "diak name";
        
        Diak student = new Diak((int)(Math.random() * 6), ((int) (Math.random() * 8) + 18),name);
        assertThat(student.getName(), is(equalTo(name)));
    }
    
    @Ignore
    @Test
    public void getNumberOfPuska() {
        Diak student = new Diak((int)(Math.random() * 6), ((int) (Math.random() * 8) + 18),"Diak Name");
        int numberOfPuska = student.getNumberOfPuska();
        
        // numberOfPuska += 1; test if not equal
        
        assertThat(student.getNumberOfPuska(), is(equalTo(numberOfPuska)));
    }
    
    @Test
    public void getAge() {
        Diak student = new Diak((int)(Math.random() * 6), ((int) (Math.random() * 8) + 18), "Random Diak Name");
        int age = student.getAge();
        
        // age += 1; to test if not equal
        
        assertThat(student.getAge(), is(equalTo(age)));
    }
}
