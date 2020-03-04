package hu.me.krz.haladojava;

public final class Point {

    private final long x;
    private final long y;
    private final long z;
    
    public Point(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }
    
    public Point translate(Point newPoint) {
        long newX = x + newPoint.x;
        long newY = y + newPoint.y;
        long newZ = z + newPoint.z;
        
        return new Point(newX, newY, newZ);
    }
}
