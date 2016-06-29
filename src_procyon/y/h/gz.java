package y.h;

import y.d.*;
import java.awt.geom.*;

public abstract class gz implements Comparable
{
    private double a;
    private az c;
    private Object d;
    public static final gz b;
    
    protected gz(final double n) {
        this(n, null);
    }
    
    protected gz(final double n, final az az) {
        this(n, az, null);
    }
    
    protected gz(final double a, final az az, final Object d) {
        this.a = a;
        this.c = ((az != null) ? az : gz.b.a(null, null));
        this.d = d;
    }
    
    public Object a() {
        return this.d;
    }
    
    public double b() {
        return this.a;
    }
    
    public abstract byte a(final t p0, final Point2D.Double p1, final byte p2);
    
    public abstract boolean a(final t p0, final t p1, final byte p2);
    
    public int compareTo(final Object o) {
        return y.g.e.a(this.b(), ((gz)o).b());
    }
    
    public az a(final e e, final t t) {
        return this.c;
    }
    
    public static gz a(final double n, final az az, final boolean b, final double n2) {
        return new gC(n, az, b, n2, null);
    }
    
    public static gz a(final double n, final az az, final boolean b, final double n2, final Object o) {
        return new gC(n, az, b, n2, o);
    }
    
    static {
        b = new gB(0.0, new gA());
    }
}
