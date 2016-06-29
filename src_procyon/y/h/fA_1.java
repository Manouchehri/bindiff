package y.h;

import y.d.*;

final class fA extends em
{
    private final eU c;
    
    fA(final eU c, final fL fl, final t t, final byte b) {
        super(fl, t, b);
        this.c = c;
    }
    
    t c(final double n, final double n2) {
        return this.c.g().a().a(this.c, this.d(n, n2));
    }
    
    boolean e() {
        return this.c != null;
    }
    
    public void a(final double n, final double n2) {
        super.a(n, n2);
        if (this.e()) {
            this.c.a(this.d(n, n2));
        }
    }
    
    private fP d(final double n, final double n2) {
        final eU c = this.c;
        return c.g().a().a(c.b(), new t(this.a(n), this.b(n2)));
    }
}
