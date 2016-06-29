package y.h;

import java.util.*;
import y.g.*;
import y.c.*;
import y.h.a.*;

class hP implements cg
{
    private cg a;
    private boolean b;
    
    public hP(final cg a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    public Iterator a(final bu bu, final int n) {
        return this.a(bu, n, true);
    }
    
    public Iterator b(final bu bu, final int n) {
        return this.a(bu, n, false);
    }
    
    private Iterator a(final bu bu, final int n, final boolean b) {
        return new hQ(bu, new hN(new A(this.a(bu, b), new hK(this, bu)), new A(this.a(bu, b), new hJ(this, bu)), b), n, b);
    }
    
    private Iterator a(final bu bu, final boolean b) {
        if (b) {
            return this.a.a(bu, 3);
        }
        return this.a.b(bu, 3);
    }
    
    private boolean a(final Object o, final bu bu) {
        return (o instanceof q && this.a(bu, (q)o)) || (o instanceof d && this.a(bu, (d)o));
    }
    
    private boolean a(final bu bu, final q q) {
        if (bu.v(q) || this.c(bu, q) || this.b(bu, q)) {
            return true;
        }
        if (this.b) {
            final v c = bu.C();
            if (c != null) {
                final q n = c.n(q);
                return n != null && this.a(bu, n);
            }
        }
        return false;
    }
    
    private boolean a(final bu bu, final d d) {
        return bu.r(d) || this.b(bu, d) || this.a(bu, d.c()) || this.a(bu, d.d());
    }
    
    private boolean b(final bu bu, final q q) {
        final boolean z = fj.z;
        final fj t = bu.t(q);
        boolean b = false;
        if (t.portCount() > 0) {
            final Iterator ports = t.ports();
            while (ports.hasNext()) {
                if (ports.next().f()) {
                    b = true;
                    if (!z) {
                        return b;
                    }
                    break;
                }
            }
        }
        return b;
    }
    
    private boolean c(final bu bu, final q q) {
        final boolean z = fj.z;
        final fj t = bu.t(q);
        int i = 0;
        boolean selected = false;
        while (i < t.labelCount()) {
            selected = t.getLabel(i).isSelected();
            if (z) {
                return selected;
            }
            if (selected) {
                return true;
            }
            ++i;
            if (z) {
                break;
            }
        }
        return selected;
    }
    
    private boolean b(final bu bu, final d d) {
        final boolean z = fj.z;
        final aB i = bu.i(d);
        int j = 0;
        boolean selected = false;
        while (j < i.labelCount()) {
            selected = i.getLabel(j).isSelected();
            if (z) {
                return selected;
            }
            if (selected) {
                return true;
            }
            ++j;
            if (z) {
                break;
            }
        }
        return selected;
    }
    
    static boolean a(final hP hp, final Object o, final bu bu) {
        return hp.a(o, bu);
    }
}
