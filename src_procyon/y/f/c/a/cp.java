package y.f.c.a;

import y.f.*;
import y.c.*;

class cp implements z
{
    public static final Object a;
    public static final Object b;
    public static final Object c;
    public static final Object d;
    private c e;
    private c f;
    private c g;
    private c h;
    private boolean i;
    
    public void a(final X x, final aU au, final aV av) {
        this.e = x.c(cp.a);
        this.f = x.c(cp.b);
        this.g = x.c(cp.c);
        this.h = x.c(cp.d);
        this.i = (this.g != null || this.h != null || this.e != null || this.f != null);
    }
    
    public void b(final X x, final aU au, final aV av) {
        this.g = null;
        this.h = null;
        this.e = null;
        this.f = null;
        this.i = false;
    }
    
    public double a(final X x, final aQ aq, final aV av, final q q, final q q2) {
        if (!this.i) {
            return 0.0;
        }
        return Math.max(((this.e != null && q2 != null) ? this.e.c(q2) : 0.0) + ((this.f != null && q != null) ? this.f.c(q) : 0.0), Math.max((this.g != null && q2 != null) ? this.g.c(q2) : 0.0, (this.h != null && q != null) ? this.h.c(q) : 0.0));
    }
    
    static {
        a = "y.layout.hierarchic.incremental.BorderBasedDDC.LEFT_BORDER_DPKEY";
        b = "y.layout.hierarchic.incremental.BorderBasedDDC.RIGHT_BORDER_DPKEY";
        c = "y.layout.hierarchic.incremental.BorderBasedDDC.LEFT_MIN_DISTANCE_DPKEY";
        d = "y.layout.hierarchic.incremental.BorderBasedDDC.RIGHT_MIN_DISTANCE_DPKEY";
    }
}
