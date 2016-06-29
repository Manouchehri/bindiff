package y.f.i.a;

import y.d.*;
import y.c.*;

abstract class aT implements o
{
    protected final m a;
    protected final m b;
    protected final byte c;
    protected final d d;
    q e;
    q f;
    
    protected aT(final d d, final m a, final m b) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = this.g();
    }
    
    public byte i() {
        return this.c;
    }
    
    public d j() {
        return this.d;
    }
    
    public abstract double b();
    
    public abstract double c();
    
    public abstract double d();
    
    public abstract double e();
    
    public abstract void a(final double p0);
    
    public Object f() {
        return null;
    }
    
    public abstract boolean a();
    
    public boolean k() {
        return this.c == 1 || this.c == 2;
    }
    
    private byte g() {
        final boolean b = Math.min(this.b.c().b, this.b.d().b) + 1.0E-6 < this.a.c().b;
        final boolean b2 = Math.min(this.a.c().a, this.a.d().a) + 1.0E-6 < this.b.c().a;
        if (b && !b2) {
            return 0;
        }
        if (b && b2) {
            return 1;
        }
        if (!b2) {
            return 2;
        }
        return 3;
    }
}
