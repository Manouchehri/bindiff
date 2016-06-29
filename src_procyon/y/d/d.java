package y.d;

import y.c.*;

public class d
{
    p a;
    double b;
    double c;
    double d;
    
    d(final double c, final double b, final double d) {
        this.c = c;
        this.b = b;
        this.d = d;
    }
    
    static d a(final double n, final double n2, final double n3) {
        return new d(n, n2, n3);
    }
    
    public double a(final double n) {
        if (n == this.c || this.d == 0.0) {
            return this.b;
        }
        return this.b + (n - this.c) * this.d;
    }
    
    public double a() {
        final p a = this.a.a();
        if (a == null) {
            return Double.MAX_VALUE;
        }
        return ((d)a.c()).c;
    }
    
    public final d b() {
        if (this.a.b() != null) {
            return (d)this.a.b().c();
        }
        return null;
    }
    
    public String toString() {
        return "Segment [" + this.c + " - " + this.a() + "], value=" + this.b + ", slope=" + this.d;
    }
}
