package y.f;

import java.util.*;
import y.d.*;
import java.awt.*;
import y.c.*;

public abstract class X extends i implements O
{
    public static boolean j;
    
    public X() {
    }
    
    public X(final X x, final C c) {
        super(x, c);
    }
    
    protected abstract y.g.C b();
    
    public abstract am h(final q p0);
    
    public abstract I g(final d p0);
    
    public abstract aj[] i(final q p0);
    
    public abstract y.f.C[] h(final d p0);
    
    public abstract q a(final aj p0);
    
    public abstract d a(final y.f.C p0);
    
    public am a(final Object o) {
        return this.h((q)o);
    }
    
    public I b(final Object o) {
        return this.g((d)o);
    }
    
    public aj[] a_(final Object o) {
        return this.i((q)o);
    }
    
    public y.f.C[] d(final Object o) {
        return this.h((d)o);
    }
    
    public double j(final q q) {
        final am h = this.h(q);
        return h.getX() + h.getWidth() / 2.0;
    }
    
    public double k(final q q) {
        final am h = this.h(q);
        return h.getY() + h.getHeight() / 2.0;
    }
    
    public t l(final q q) {
        return new t(this.j(q), this.k(q));
    }
    
    public double m(final q q) {
        return this.h(q).getX();
    }
    
    public double n(final q q) {
        return this.h(q).getY();
    }
    
    public t o(final q q) {
        final am h = this.h(q);
        return new t(h.getX(), h.getY());
    }
    
    public double p(final q q) {
        return this.h(q).getWidth();
    }
    
    public double q(final q q) {
        return this.h(q).getHeight();
    }
    
    public y.d.q r(final q q) {
        return new y.d.q(this.p(q), this.q(q));
    }
    
    public y s(final q q) {
        return new y(this.o(q), this.r(q));
    }
    
    public void a(final q q, final t t) {
        this.a(q, t.a(), t.b());
    }
    
    public void a(final q q, final double n, final double n2) {
        final am h = this.h(q);
        h.setLocation(n - h.getWidth() / 2.0, n2 - h.getHeight() / 2.0);
    }
    
    public void b(final q q, final double n, final double n2) {
        this.h(q).setSize(n, n2);
    }
    
    public void a(final q q, final y.d.q q2) {
        this.b(q, q2.a(), q2.b());
    }
    
    public void c(final q q, final double n, final double n2) {
        this.h(q).setLocation(n, n2);
    }
    
    public void b(final q q, final t t) {
        this.c(q, t.a(), t.b());
    }
    
    public void d(final q q, final double n, final double n2) {
        final am h = this.h(q);
        h.setLocation(h.getX() + n, h.getY() + n2);
    }
    
    public v j(final d d) {
        final boolean j = X.j;
        final I g = this.g(d);
        final ArrayList list = new ArrayList<t>(g.pointCount());
        int i = 0;
        while (i < g.pointCount()) {
            list.add(g.getPoint(i));
            ++i;
            if (j) {
                break;
            }
        }
        return new v(list);
    }
    
    public D k(final d d) {
        final boolean j = X.j;
        final I g = this.g(d);
        final D d2 = new D();
        int i = 0;
        D d3 = null;
        while (i < g.pointCount()) {
            d3 = d2;
            if (j) {
                return d3;
            }
            d3.add(g.getPoint(i));
            ++i;
            if (j) {
                break;
            }
        }
        return d3;
    }
    
    public v l(final d d) {
        final boolean j = X.j;
        final ArrayList<t> list = new ArrayList<t>();
        list.add(this.p(d));
        final u b = this.j(d).b();
        while (b.f()) {
            list.add((t)b.d());
            b.g();
            if (j) {
                return new v(list);
            }
            if (j) {
                break;
            }
        }
        list.add(this.q(d));
        return new v(list);
    }
    
    public D m(final d d) {
        final boolean j = X.j;
        final D d2 = new D();
        d2.add(this.p(d));
        final u b = this.j(d).b();
        while (b.f()) {
            d2.add(b.d());
            b.g();
            if (j) {
                return d2;
            }
            if (j) {
                break;
            }
        }
        d2.add(this.q(d));
        return d2;
    }
    
    public void a(final d d, final v v) {
        final boolean j = X.j;
        final I g = this.g(d);
        g.clearPoints();
        final u b = v.b();
        this.c(d, b.a());
        final t d2 = v.d();
        b.g();
        while (b.d() != d2) {
            final t a = b.a();
            g.addPoint(a.a(), a.b());
            b.g();
            if (j) {
                return;
            }
            if (j) {
                break;
            }
        }
        this.d(d, d2);
    }
    
    public void a(final d d, final D d2) {
        final boolean j = X.j;
        final I g = this.g(d);
        g.clearPoints();
        final C m = d2.m();
        this.c(d, (t)m.d());
        final t t = (t)d2.i();
        m.g();
        while (m.d() != t) {
            final t t2 = (t)m.d();
            g.addPoint(t2.a(), t2.b());
            m.g();
            if (j) {
                return;
            }
            if (j) {
                break;
            }
        }
        this.d(d, t);
    }
    
    public void b(final d d, final v v) {
        final boolean j = X.j;
        final I g = this.g(d);
        g.clearPoints();
        final u b = v.b();
        while (b.f()) {
            final t a = b.a();
            g.addPoint(a.a(), a.b());
            b.g();
            if (j) {
                break;
            }
        }
    }
    
    public void b(final d d, final D d2) {
        final boolean j = X.j;
        final I g = this.g(d);
        g.clearPoints();
        p p2 = d2.k();
        while (p2 != null) {
            final t t = (t)p2.c();
            g.addPoint(t.a(), t.b());
            p2 = p2.a();
            if (j) {
                break;
            }
        }
    }
    
    public void a(final d d, final t t, final t t2) {
        this.c(d, t);
        this.d(d, t2);
    }
    
    public t n(final d d) {
        return this.g(d).getSourcePoint();
    }
    
    public t o(final d d) {
        return this.g(d).getTargetPoint();
    }
    
    public void a(final d d, final t sourcePoint) {
        this.g(d).setSourcePoint(sourcePoint);
    }
    
    public void b(final d d, final t targetPoint) {
        this.g(d).setTargetPoint(targetPoint);
    }
    
    public t p(final d d) {
        final t sourcePoint = this.g(d).getSourcePoint();
        if (sourcePoint == null) {
            return this.l(d.c());
        }
        return new t(this.j(d.c()) + sourcePoint.a(), this.k(d.c()) + sourcePoint.b());
    }
    
    public t q(final d d) {
        final t targetPoint = this.g(d).getTargetPoint();
        if (targetPoint == null) {
            return this.l(d.d());
        }
        return new t(this.j(d.d()) + targetPoint.a(), this.k(d.d()) + targetPoint.b());
    }
    
    public void c(final d d, final t t) {
        this.g(d).setSourcePoint(new t(t.a() - this.j(d.c()), t.b() - this.k(d.c())));
    }
    
    public void d(final d d, final t t) {
        this.g(d).setTargetPoint(new t(t.a() - this.j(d.d()), t.b() - this.k(d.d())));
    }
    
    public f E() {
        return new f(this.p());
    }
    
    public Rectangle a() {
        final boolean j = X.j;
        double n2;
        double n = n2 = Double.MAX_VALUE;
        double n4;
        double n3 = n4 = -1.7976931348623157E308;
        final x o = this.o();
        while (true) {
            while (o.f()) {
                final t o2 = this.o(o.e());
                final X x = this;
                if (!j) {
                    final y.d.q r = this.r(o.e());
                    n2 = Math.min(o2.a(), n2);
                    n = Math.min(o2.b(), n);
                    n4 = Math.max(o2.a() + r.a(), n4);
                    n3 = Math.max(o2.b() + r.b(), n3);
                    o.g();
                    if (j) {
                        break;
                    }
                    continue;
                }
                else {
                    final e p = x.p();
                Label_0256_Outer:
                    while (p.f()) {
                        final C a = this.j(p.a()).a();
                        while (true) {
                            while (a.f()) {
                                final t t = (t)a.d();
                                n2 = Math.min(t.a(), n2);
                                n = Math.min(t.b(), n);
                                n4 = Math.max(t.a(), n4);
                                n3 = Math.max(t.b(), n3);
                                a.g();
                                if (!j) {
                                    if (j) {
                                        break;
                                    }
                                    continue Label_0256_Outer;
                                }
                                else {
                                    if (j) {
                                        break Label_0256_Outer;
                                    }
                                    continue Label_0256_Outer;
                                }
                            }
                            p.g();
                            continue;
                        }
                    }
                    if (n2 == Double.MAX_VALUE && n == Double.MAX_VALUE) {
                        return new Rectangle(0, 0, -1, -1);
                    }
                    final double floor = Math.floor(n2);
                    final double floor2 = Math.floor(n);
                    return new Rectangle((int)floor, (int)floor2, (int)(Math.ceil(n4) - floor), (int)(Math.ceil(n3) - floor2));
                }
            }
            final X x = this;
            continue;
        }
    }
}
