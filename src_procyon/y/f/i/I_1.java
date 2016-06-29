package y.f.i;

import y.f.b.*;
import y.c.*;

class I extends J
{
    private final q b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    
    I(final q b, final double c, final double d, final double n, final double n2) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = n + c;
        this.f = n2 + d;
    }
    
    double a(final d d, final double n, final double n2, final double n3, final E e) {
        final i a = d.a();
        final c c = a.c(y.f.b.f.d);
        final c c2 = a.c(y.f.b.f.b);
        final c c3 = a.c(y.f.b.f.c);
        if (c2 != null && c3 != null && c != null && c.d(this.b)) {
            final Object b = c2.b(this.b);
            final Object b2 = c3.b(d.c());
            final Object b3 = c3.b(d.d());
            if ((b2 != null && b2.equals(b)) || (b3 != null && b3.equals(b))) {
                return 0.0;
            }
        }
        if (this.b == d.c() || this.b == d.d()) {
            return 0.0;
        }
        if (n >= this.c && n <= this.e && n2 <= this.f && n3 >= this.d) {
            return e.c();
        }
        return 0.0;
    }
    
    F a(final boolean b, final double n) {
        return new F(b, n, this.d, this.f, this);
    }
    
    public String toString() {
        return "NodeObject{node=" + this.b + '}';
    }
}
