package y.h;

import y.d.*;

final class dq implements fP
{
    private final dp c;
    private final double d;
    private final double e;
    private final double f;
    private final double g;
    double a;
    double b;
    
    dq(final dp c, final t t, final t t2) {
        this.c = c;
        this.d = t.a();
        this.e = t.b();
        this.a = this.d;
        this.b = this.e;
        this.f = t2.a();
        this.g = t2.b();
    }
    
    public fO a() {
        return this.c;
    }
    
    void a(final double n, final double n2) {
        this.a = n * this.d + n2 * this.f;
        this.b = n * this.e + n2 * this.g;
    }
}
