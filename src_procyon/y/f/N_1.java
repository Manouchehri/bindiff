package y.f;

public class N
{
    double a;
    double b;
    double c;
    double d;
    
    public N() {
        this(0.0, 0.0, 0.0, -1.0);
    }
    
    public N(final double n, final double n2) {
        this(n, n2, 0.0, -1.0);
    }
    
    N(final double a, final double b, final double c, final double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
