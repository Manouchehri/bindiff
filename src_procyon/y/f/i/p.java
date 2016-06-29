package y.f.i;

import y.c.*;

class p extends y.g.p
{
    private final byte a;
    private final c b;
    private final c d;
    private final A e;
    private final c f;
    private final n g;
    
    p(final n g, final byte a, final c b, final c d, final A e, final c f) {
        this.g = g;
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public boolean d(final Object o) {
        final d d = (d)o;
        if (this.a == 2 && !this.b.d(d)) {
            return false;
        }
        if (this.a == 4) {
            if (!this.d.d(d.c()) && !this.d.d(d.d())) {
                return false;
            }
        }
        else if (this.e.d(d.c())) {
            return false;
        }
        return this.f.d(d.c()) || this.f.d(d.d());
    }
}
