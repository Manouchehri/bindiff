package y.f;

import java.util.*;
import y.c.*;

public class l extends X
{
    private A a;
    private h b;
    private A h;
    private h i;
    private Map k;
    private Map l;
    private A m;
    private Map n;
    private h o;
    private Map p;
    private Map q;
    private n r;
    private O s;
    private static final Object t;
    private static final Object u;
    
    public l(final X x) {
        this(x, x);
    }
    
    public l(final n r, final O s) {
        this.k = new HashMap();
        this.l = new HashMap();
        this.r = r;
        this.s = s;
        this.a = this.t();
        this.h = this.t();
        this.b = this.u();
        this.i = this.u();
        this.m = this.t();
        this.o = this.u();
        this.p = new HashMap();
        this.n = new HashMap();
        this.q = new HashMap();
        this.c(r);
        this.b(r);
        this.a(r);
        this.a(ah.f_, new m(this, r.c(ah.f_)));
        this.a(ah.k, new y.f.n(this, r.c(ah.k)));
    }
    
    private void a(final n n) {
        final boolean j = X.j;
        final Object[] z = n.z();
        int i = 0;
        while (i < z.length) {
            final c c = n.c(z[i]);
            Label_0150: {
                if (((A)c).getClass() == y.f.l.t) {
                    this.a(z[i], new t(this, (A)c));
                    if (!j) {
                        break Label_0150;
                    }
                }
                if (((A)c).getClass() == y.f.l.u) {
                    this.a(z[i], new r(this, (h)c));
                    if (!j) {
                        break Label_0150;
                    }
                }
                if (c instanceof a) {
                    this.a(z[i], new s(this, c));
                    if (!j) {
                        break Label_0150;
                    }
                }
                this.a(z[i], new q(this, c));
            }
            ++i;
            if (j) {
                break;
            }
        }
    }
    
    private void b(final n n) {
        final boolean j = X.j;
        final Iterator y = n.y();
        while (y.hasNext()) {
            this.e(y.next());
            if (j) {
                break;
            }
        }
    }
    
    public d e(final Object o) {
        final boolean j = X.j;
        final d a = this.a(this.q.get(this.r.b_(o)), this.q.get(this.r.c_(o)));
        this.o.a(a, o);
        this.q.put(o, a);
        this.b.a(a, new u(this.s.b(o)));
        final C[] d = this.s.d(o);
        final C[] array = new C[d.length];
        int i = 0;
        while (i < array.length) {
            final D d2 = new D();
            d2.a(d[i].getOrientedBox());
            d2.setModelParameter(d[i].getModelParameter());
            d2.a(d[i].getLabelModel());
            d2.a(d[i].getPreferredPlacementDescriptor());
            array[i] = d2;
            this.l.put(array[i], a);
            this.p.put(array[i], d[i]);
            ++i;
            if (j) {
                return a;
            }
            if (j) {
                break;
            }
        }
        this.i.a(a, array);
        return a;
    }
    
    protected y.g.C b() {
        return new o(this);
    }
    
    private void c(final n n) {
        final boolean j = X.j;
        final Iterator x = n.x();
        while (x.hasNext()) {
            this.f(x.next());
            if (j) {
                break;
            }
        }
    }
    
    public y.c.q f(final Object o) {
        final boolean j = X.j;
        final y.c.q d = this.d();
        this.q.put(o, d);
        this.m.a(d, o);
        this.a.a(d, new x(this.s.a(o)));
        final aj[] a_ = this.s.a_(o);
        final aj[] array = new aj[a_.length];
        int i = 0;
        while (i < array.length) {
            final ak ak = new ak();
            ak.a(a_[i].getOrientedBox());
            ak.setModelParameter(a_[i].getModelParameter());
            ak.a(a_[i].a());
            array[i] = ak;
            this.k.put(array[i], d);
            this.n.put(array[i], a_[i]);
            ++i;
            if (j) {
                return d;
            }
            if (j) {
                break;
            }
        }
        this.h.a(d, array);
        return d;
    }
    
    public am h(final y.c.q q) {
        am am = (am)this.a.b(q);
        if (am == null) {
            am = new x();
            this.a.a(q, am);
        }
        return am;
    }
    
    public I g(final d d) {
        I i = (I)this.b.b(d);
        if (i == null) {
            i = new u();
            this.b.a(d, i);
        }
        return i;
    }
    
    public aj[] i(final y.c.q q) {
        aj[] array = (aj[])this.h.b(q);
        if (array == null) {
            array = new aj[0];
            this.h.a(q, array);
        }
        return array;
    }
    
    public C[] h(final d d) {
        C[] array = (C[])this.i.b(d);
        if (array == null) {
            array = new C[0];
            this.i.a(d, array);
        }
        return array;
    }
    
    public y.c.q a(final aj aj) {
        return this.k.get(aj);
    }
    
    public d a(final C c) {
        return this.l.get(c);
    }
    
    public O C() {
        return new p(this);
    }
    
    public void D() {
        final boolean j = X.j;
        final y.c.x o = this.o();
        while (true) {
            while (o.f()) {
                final y.c.q e = o.e();
                final Object b = this.m.b(e);
                final l l = this;
                if (j) {
                    final e p = l.p();
                Label_0192:
                    while (p.f()) {
                        final d a = p.a();
                        final Object b2 = this.o.b(a);
                        final I g = this.g(a);
                        Label_0409: {
                            if (g != null) {
                                final I b3 = this.s.b(b2);
                                b3.setSourcePoint(g.getSourcePoint());
                                b3.setTargetPoint(g.getTargetPoint());
                                Label_0351: {
                                    if (b3.pointCount() != g.pointCount()) {
                                        b3.clearPoints();
                                        int i = 0;
                                        while (i < g.pointCount()) {
                                            final y.d.t point = g.getPoint(i);
                                            b3.addPoint(point.a(), point.b());
                                            ++i;
                                            if (j) {
                                                continue Label_0192;
                                            }
                                            if (j) {
                                                break Label_0351;
                                            }
                                        }
                                        break Label_0409;
                                    }
                                }
                                int k = 0;
                                while (k < g.pointCount()) {
                                    final y.d.t point2 = g.getPoint(k);
                                    b3.setPoint(k, point2.a(), point2.b());
                                    ++k;
                                    if (j) {
                                        continue Label_0192;
                                    }
                                    if (j) {
                                        break;
                                    }
                                }
                            }
                        }
                        final C[] h = this.h(a);
                        Label_0483: {
                            if (h != null) {
                                final C[] d = this.s.d(b2);
                                int n = 0;
                                while (n < d.length) {
                                    d[n].setModelParameter(h[n].getModelParameter());
                                    ++n;
                                    if (j) {
                                        break Label_0483;
                                    }
                                    if (j) {
                                        break;
                                    }
                                }
                            }
                            p.g();
                        }
                        if (j) {
                            break;
                        }
                    }
                    return;
                }
                final am h2 = this.h(e);
                if (h2 != null) {
                    final am a2 = this.s.a(b);
                    a2.setSize(h2.getWidth(), h2.getHeight());
                    a2.setLocation(h2.getX(), h2.getY());
                }
                final aj[] m = this.i(e);
                Label_0182: {
                    if (m != null) {
                        final aj[] a_ = this.s.a_(b);
                        int n2 = 0;
                        while (n2 < a_.length) {
                            a_[n2].setModelParameter(m[n2].getModelParameter());
                            ++n2;
                            if (j) {
                                break Label_0182;
                            }
                            if (j) {
                                break;
                            }
                        }
                    }
                    o.g();
                }
                if (j) {
                    break;
                }
            }
            final l l = this;
            continue;
        }
    }
    
    public Object i(final d d) {
        return this.o.b(d);
    }
    
    static A a(final l l) {
        return l.m;
    }
    
    static h b(final l l) {
        return l.o;
    }
    
    static Map c(final l l) {
        return l.n;
    }
    
    static Map d(final l l) {
        return l.p;
    }
    
    static Map e(final l l) {
        return l.q;
    }
    
    static {
        final i i = new i();
        final A t2 = i.t();
        t = t2.getClass();
        i.a(t2);
        final h u2 = i.u();
        u = u2.getClass();
        i.a(u2);
    }
}
