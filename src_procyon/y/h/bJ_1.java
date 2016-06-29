package y.h;

import y.f.*;
import y.h.b.*;
import y.b.*;

class bJ extends bS
{
    private volatile e i;
    private volatile d j;
    private final bQ k;
    private final Runnable l;
    private final bI m;
    
    bJ(final bI m, final ch ch, final bu bu, final ah ah, final boolean b, final bQ k, final Runnable l) {
        super(m, ch, bu, ah, b);
        this.m = m;
        this.k = k;
        this.l = l;
    }
    
    protected void a(final l l) {
        final v v = this.h.get((bI.b == null) ? (bI.b = bI.a("y.h.b.v")) : bI.b);
        if (v != null) {
            v.f(this.e);
        }
        (this.i = this.m.k()).b(true);
        this.j = this.m.a(this.d, this.e, l.C());
        if (this.j != null) {
            if (this.m.e().isEasedExecution()) {
                this.j = y.b.b.a(this.j);
            }
            this.i.a(this.d);
            this.i.a(new bN(this));
            if (!fj.z) {
                return;
            }
        }
        this.m.a(this.e, l.C());
    }
    
    protected void b(final l l) {
        if (this.i != null && this.j != null) {
            this.i.a(this.j);
        }
    }
    
    protected void a() {
        super.a();
        if (this.b != null && this.k != null) {
            this.k.a(this.b);
        }
        if (this.l != null) {
            this.l.run();
        }
    }
}
