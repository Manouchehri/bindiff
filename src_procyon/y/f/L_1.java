package y.f;

import y.d.*;

public class L
{
    double a;
    double b;
    double c;
    
    public L() {
        this(50.0, 0.0, 0.0);
    }
    
    public L(final double a, final double b, final double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double a() {
        return this.c;
    }
    
    public String toString() {
        return this.getClass() + " radius=" + this.a + "  theta(deg)=" + e.b(this.b);
    }
}
