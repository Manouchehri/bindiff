package y.f.c.a;

class cy
{
    public final Object a;
    public final double b;
    public final double c;
    public double d;
    final double e;
    double f;
    double g;
    double h;
    double i;
    double j;
    public double k;
    public double l;
    public byte m;
    public final boolean n;
    public double o;
    public double p;
    public double q;
    int r;
    
    private cy(final Object a, final double n, final double b, final double c, final byte m, final double k, final double l, final double f, final double g, final boolean n2, final double o, final double p13, final double q) {
        this.i = -1.7976931348623157E308;
        this.j = Double.MAX_VALUE;
        this.o = 20.0;
        this.r = -1;
        this.h = Math.max(f, g);
        this.f = f;
        this.g = g;
        this.k = k;
        this.l = l;
        this.e = n * 0.5;
        this.a = a;
        this.d = Double.NaN;
        this.m = m;
        this.b = b;
        this.c = c;
        this.n = n2;
        this.o = o;
        this.p = p13;
        this.q = q;
    }
    
    public byte a() {
        return this.m;
    }
    
    static cy a(final Object o, final double n, final double n2, final boolean b, final double n3, final boolean b2, final double n4, final double n5) {
        return a(o, n, n2, b, n3, b2, -1.7976931348623157E308, Double.MAX_VALUE, n4, n5);
    }
    
    static cy a(final Object o, final double n, final double n2, final boolean b, final double n3, final boolean b2, final double n4, final double n5, final double n6, final double n7) {
        return a(o, n, n2, b, n3, b2, n4, n5, n6, n7, false, 0.0);
    }
    
    static cy a(final Object o, final double n, final double n2, final boolean b, final double n3, final boolean b2, final double n4, final double n5, final boolean b3, final double n6) {
        return a(o, n, n2, b, n3, b2, -1.7976931348623157E308, Double.MAX_VALUE, n4, n5, b3, n6);
    }
    
    static cy a(final Object o, final double n, final double n2, final boolean b, final double n3, final boolean b2, final double n4, final double n5, final double n6, final double n7, final boolean b3, final double n8) {
        if (n2 > n3) {
            return new cy(o, n, n3, n2, (byte)(b2 ? (b ? 0 : 2) : (b ? 1 : 3)), n4, n5, n6, n7, b3, n8, n3, n2);
        }
        return new cy(o, n, n2, n3, (byte)(b ? (b2 ? 0 : 2) : (b2 ? 1 : 3)), n4, n5, n6, n7, b3, n8, n2, n3);
    }
    
    cy(final Object o, final double n, final double n2, final double n3, final byte b, final double n4, final double n5, final double n6, final double n7, final boolean b2, final double n8, final double n9, final double n10, final cs cs) {
        this(o, n, n2, n3, b, n4, n5, n6, n7, b2, n8, n9, n10);
    }
}
