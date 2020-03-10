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
public class VasarlasTest 
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
        String name = "Student Name";
        Tanulo student = new Tanulo(name);
        
        assertThat(student.getName(), is(equalTo(name)));
    }
    
    @Test
    public void getMoney() {
        int money = 10000;
        String name = "Student Name";
        Tanulo student = new Tanulo(name);
        
        assertThat(student.getMoney(), is(equalTo(money)));
    }
    
}
