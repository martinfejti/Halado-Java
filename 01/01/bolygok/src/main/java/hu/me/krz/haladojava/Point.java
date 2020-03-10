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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (x ^ (x >>> 32));
        result = prime * result + (int) (y ^ (y >>> 32));
        result = prime * result + (int) (z ^ (z >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (z != other.z)
            return false;
        return true;
    }
}
