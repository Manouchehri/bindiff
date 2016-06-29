package y.h;

import y.d.*;

public abstract class el
{
    final byte a;
    final t b;
    
    protected el(final t b, final byte a) {
        this.b = b;
        this.a = a;
    }
    
    public final t b() {
        return this.b;
    }
    
    public final boolean c() {
        return (this.a & 0x2) == 0x0;
    }
    
    public final boolean d() {
        return (this.a & 0x1) == 0x0;
    }
    
    final t b(final double n, final double n2) {
        return new t(this.a(n), this.b(n2));
    }
    
    final double a(final double n) {
        if ((this.a & 0x1) == 0x0) {
            return this.b.a;
        }
        return this.b.a + n;
    }
    
    final double b(final double n) {
        if ((this.a & 0x2) == 0x0) {
            return this.b.b;
        }
        return this.b.b + n;
    }
    
    public abstract void a(final double p0, final double p1);
}
