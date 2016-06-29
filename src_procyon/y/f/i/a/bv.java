package y.f.i.a;

class bv
{
    private final double a;
    private final byte b;
    private final int c;
    private final boolean d;
    
    bv(final double a, final byte b, final boolean d) {
        this.a = a;
        this.b = b;
        this.c = (this.a() ? -1000 : (this.f() ? 16 : (this.e() ? 15 : (this.d() ? 10 : 0))));
        this.d = d;
    }
    
    public boolean a() {
        return (this.b & 0x20) != 0x0;
    }
    
    public boolean b() {
        return (this.b & 0x1) != 0x0;
    }
    
    public boolean c() {
        return (this.b & 0x2) != 0x0;
    }
    
    public boolean d() {
        return (this.b & 0x4) != 0x0;
    }
    
    public boolean e() {
        return (this.b & 0x8) != 0x0;
    }
    
    public boolean f() {
        return (this.b & 0x10) != 0x0;
    }
    
    public int g() {
        return this.c;
    }
    
    public boolean h() {
        return this.d;
    }
    
    public double i() {
        return this.a;
    }
}
