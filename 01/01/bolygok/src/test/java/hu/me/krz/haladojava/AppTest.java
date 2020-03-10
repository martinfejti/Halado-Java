package hu.me.krz.haladojava;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
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
    
    @Test
    public void getName() {
        String name = "Nem Tom";
        
        Astronomer astronomer = new Astronomer(name);
        
        //assertTrue(astronomer.getName().equals(name));
        assertThat(astronomer.getName(), is(equalTo(name)));
    }
    
    @Ignore
    @Test
    public void getDiscoveredPlanets() {
        Astronomer astronomer = new Astronomer("Zsemleplanet");
        Point point = new Point(10, 10, 10);
        Planet planet = new Planet(point, 50, "Zsemleplanet");
        ArrayList<Planet> planets = new ArrayList<>();
        planets.add(planet);
        
        assertThat(astronomer.getDiscoveredPlanets(), is(equalTo(planets)));
    }
    
    @Test
    public void observeTheSky() {
//        String name = "Nem Tom";
//        Astronomer astronomer = new Astronomer(name);
//        
//        astronomer.observeTheSky();
//        
//        assertThat(astronomer.getDiscoveredPlanets().size(), is(equalTo(10)));
//        assertThat(astronomer.getDiscoveredPlanets().get(0).getPosition()), is(equalTo(new Point(0, 0, 0)));
//        assertThat(astronomer.getDiscoveredPlanets(),get(0).getName(), is(equalTo(String.format("%s 1", name))));
        
    }
}
