package y.f.g;

class c
{
    private double e;
    private byte f;
    public static byte a;
    public static byte b;
    public static byte c;
    public static byte d;
    
    c(final double e, final byte f) {
        this.f = f;
        this.e = e;
    }
    
    public byte a() {
        return this.f;
    }
    
    public double b() {
        return this.e;
    }
    
    static {
        y.f.g.c.a = 0;
        y.f.g.c.b = 1;
        y.f.g.c.c = 2;
        y.f.g.c.d = 3;
    }
}
