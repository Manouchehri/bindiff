package y.f.i;

class U
{
    private final Object b;
    private final double c;
    private final double d;
    private double e;
    final double a;
    private final double f;
    private double g;
    private double h;
    private final byte i;
    private boolean j;
    
    private U(final Object b, final double n, final double f, final double c, final double d, final byte i, final double n2, final double n3) {
        final int f2 = v.f;
        this.b(n2);
        this.c(n3);
        this.a = n * 0.5;
        this.f = f;
        this.b = b;
        this.a(Double.NaN);
        this.i = i;
        this.c = c;
        this.d = d;
        Label_0110: {
            switch (i) {
                case 0:
                case 3: {
                    this.b(false);
                    if (f2 != 0) {
                        break Label_0110;
                    }
                    return;
                }
                case 1:
                case 2: {
                    this.b(true);
                    if (f2 != 0) {
                        break;
                    }
                    return;
                }
            }
        }
        this.b(true);
    }
    
    public byte a() {
        return this.i;
    }
    
    static U a(final Object o, final double n, final double n2, final double n3, final boolean b, final double n4, final boolean b2) {
        return a(o, n, n2, n3, b, n4, b2, -1.7976931348623157E308, Double.MAX_VALUE);
    }
    
    static U a(final Object o, final double n, final double n2, final double n3, final boolean b, final double n4, final boolean b2, final double n5, final double n6) {
        if (n3 > n4) {
            return new U(o, n, n2, n4, n3, (byte)(b2 ? (b ? 0 : 2) : (b ? 1 : 3)), n5, n6);
        }
        return new U(o, n, n2, n3, n4, (byte)(b ? (b2 ? 0 : 2) : (b2 ? 1 : 3)), n5, n6);
    }
    
    public void a(final boolean b) {
        this.b(b);
    }
    
    public boolean b() {
        return this.j;
    }
    
    public Object c() {
        return this.b;
    }
    
    public double d() {
        return this.e;
    }
    
    public void a(final double e) {
        this.e = e;
    }
    
    public double e() {
        return this.g;
    }
    
    public void b(final double g) {
        this.g = g;
    }
    
    public double f() {
        return this.h;
    }
    
    public void c(final double h) {
        this.h = h;
    }
    
    public void b(final boolean j) {
        this.j = j;
    }
    
    static byte a(final U u) {
        return u.i;
    }
    
    static double b(final U u) {
        return u.d;
    }
    
    static double c(final U u) {
        return u.c;
    }
    
    static double d(final U u) {
        return u.e;
    }
    
    static double e(final U u) {
        return u.f;
    }
}
