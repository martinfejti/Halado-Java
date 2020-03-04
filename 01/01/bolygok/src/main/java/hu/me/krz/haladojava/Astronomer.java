package hu.me.krz.haladojava;

import java.util.ArrayList;
import java.util.List;

public class Astronomer {

    private final String name;
    private List<Planet> planetList = new ArrayList<>();
    
    public Astronomer(String name) {
        this.name = name;
    }
    
    public List<Planet> getDiscoveredPlanets() {
        return this.planetList;
    }
    
    public void observeTheSky() {
        Point act = new Point(0,0,0);
        for (int i = 0; i < 10; i++) {
            act = act.translate(new Point(10, 0, 0));
            Planet actualPlanet = new Planet(act, (int)(Math.random() * 101), name + i);
            
            customToString(actualPlanet);
            
            planetList.add(actualPlanet);
        }
    }

    public void customToString(Planet actualPlanet) {
        System.out.println("Planet name: " + actualPlanet.getName());
        System.out.println("\tRadius: " + actualPlanet.getRadius());
        
        Point position = actualPlanet.getPosition();
        System.out.println("\tPosition: x:" + position.getX() + " y: " + position.getY() + " z: " + position.getZ() + "\n");
    }
    
    public String getName() {
        return this.name;
    }
    
}
