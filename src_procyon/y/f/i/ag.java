package y.f.i;

import y.c.*;

class ag
{
    private double c;
    private double d;
    private double e;
    private byte f;
    private long g;
    private Object h;
    public D a;
    public D b;
    
    public ag(final double c, final double d, final double e, final byte f, final long g) {
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.a = new D();
        this.b = new D();
    }
    
    public boolean equals(final Object o) {
        return o instanceof ag && ((ag)o).g == this.g;
    }
    
    public int hashCode() {
        return (int)(this.g ^ this.g >>> 32);
    }
    
    public void a(final boolean b, final ao ao) {
        if (b) {
            this.a.add(ao);
            if (v.f == 0) {
                return;
            }
        }
        this.b.add(ao);
    }
    
    public void a(final Object h) {
        this.h = h;
    }
    
    public double a() {
        return this.c;
    }
    
    public double b() {
        return this.d;
    }
    
    public double c() {
        return this.e;
    }
    
    public byte d() {
        return this.f;
    }
    
    public long e() {
        return this.g;
    }
    
    public Object f() {
        return this.h;
    }
    
    public String toString() {
        return ((this.f == 8) ? "OPEN;" : "CLOSE;") + this.c + ";[" + this.d + ".." + this.e + "]" + ";#" + this.g;
    }
}
