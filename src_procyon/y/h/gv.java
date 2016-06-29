package y.h;

import y.d.*;

public class gv
{
    private final double a;
    private final double b;
    private final double c;
    private final int d;
    private final byte e;
    private final boolean f;
    private m g;
    
    gv(final double n, final double n2) {
        this(0, 0.0, n, false, (byte)0, n2);
    }
    
    public gv(final int d, final double a, final double n, final boolean f, final byte e, final double c) {
        this.d = d;
        this.a = a;
        this.b = Math.abs(n);
        this.f = f;
        this.e = e;
        this.c = c;
    }
    
    public int a() {
        return this.d;
    }
    
    public double b() {
        return this.a;
    }
    
    public double c() {
        return this.b;
    }
    
    public boolean d() {
        return this.f;
    }
    
    public byte e() {
        return this.e;
    }
    
    public double f() {
        return this.c;
    }
    
    void a(final double n, final double n2, final double n3, final double n4) {
        this.g = new m(new t(n, n2), new t(n3, n4));
    }
    
    m g() {
        return this.g;
    }
}
