package y.f;

import y.g.*;
import y.d.*;
import java.util.*;
import y.c.*;

public class Y implements C
{
    private static final C a;
    
    public q a(final i i, final q q) {
        final i e = q.e();
        if (e instanceof X) {
            final X x = (X)e;
            final am h = x.h(q);
            final q d = i.d();
            final X x2 = (X)i;
            final am h2 = x2.h(d);
            h2.setSize(h.getWidth(), h.getHeight());
            h2.setLocation(h.getX(), h.getY());
            this.a(x, q, x2, d);
            return d;
        }
        return Y.a.a(i, q);
    }
    
    protected void a(final X x, final q q, final X x2, final q q2) {
        final boolean j = X.j;
        if (x2 instanceof w) {
            final aj[] i = x.i(q);
            final w w = (w)x2;
            final aj[] array = new aj[i.length];
            int k = 0;
            while (k < i.length) {
                array[k] = this.a(i[k]);
                ++k;
                if (j) {
                    return;
                }
                if (j) {
                    break;
                }
            }
            w.a(q2, array);
        }
    }
    
    protected aj a(final aj aj) {
        final ak ak = new ak();
        ak.a(aj.a());
        ak.setModelParameter(aj.getModelParameter());
        ak.a(aj.getOrientedBox());
        return ak;
    }
    
    public d a(final i i, final q q, final q q2, final d d) {
        final boolean j = X.j;
        final i a = d.a();
        if (a instanceof X) {
            final X x = (X)i;
            final d a2 = x.a(q, q2);
            final I g = x.g(a2);
            final X x2 = (X)a;
            final I g2 = x2.g(d);
            g.setSourcePoint(g2.getSourcePoint());
            g.setTargetPoint(g2.getTargetPoint());
            int k = 0;
            while (k < g2.pointCount()) {
                final t point = g2.getPoint(k);
                g.addPoint(point.a(), point.b());
                ++k;
                if (j) {
                    return a2;
                }
                if (j) {
                    break;
                }
            }
            this.a(x2, d, x, a2);
            return a2;
        }
        return Y.a.a(i, q, q2, d);
    }
    
    protected void a(final X x, final d d, final X x2, final d d2) {
        final boolean j = X.j;
        if (x2 instanceof w) {
            final y.f.C[] h = x.h(d);
            final w w = (w)x2;
            final y.f.C[] array = new y.f.C[h.length];
            int i = 0;
            while (i < h.length) {
                array[i] = this.a(h[i]);
                ++i;
                if (j) {
                    return;
                }
                if (j) {
                    break;
                }
            }
            w.a(d2, array);
        }
    }
    
    protected y.f.C a(final y.f.C c) {
        final D d = new D();
        d.a(c.getLabelModel());
        d.setModelParameter(c.getModelParameter());
        d.a(c.getPreferredPlacementDescriptor());
        d.a(c.getOrientedBox());
        return d;
    }
    
    public void a(final i i, final i j) {
    }
    
    public void a(final i i, final i j, final Map map, final Map map2) {
    }
    
    static {
        a = new k();
    }
}
