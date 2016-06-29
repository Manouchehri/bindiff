package y.f.i;

import y.g.*;
import y.c.*;

class o extends p
{
    private final byte a;
    private final c b;
    private final c d;
    private final A e;
    private final n f;
    
    o(final n f, final byte a, final c b, final c d, final A e) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
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
        return true;
    }
}
