package y.a;

import y.c.*;

class Y extends S
{
    private final double a;
    private final double b;
    private final double c;
    private final X d;
    private final V e;
    private final W f;
    
    Y(final double a, final double b, final double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = new X(null);
        this.e = new V(null);
        this.f = new W(null);
    }
    
    double a(final d[] array, final c c, final int n) {
        return this.a * this.d.a(array, c, n) + this.b * this.e.a(array, c, n) + this.c * this.f.a(array, c, n);
    }
}
