package y.g;

import java.awt.geom.*;

public class w implements V
{
    private double a;
    private double b;
    
    protected w(final double a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    public double a() {
        return this.a;
    }
    
    public double b() {
        return this.b;
    }
    
    public static w a(final double n, final double n2) {
        return new w(n, n2);
    }
    
    public static an a(final Point2D point2D) {
        return new x(point2D);
    }
}
