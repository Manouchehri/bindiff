package y.f.i.a;

import y.g.*;
import y.f.*;
import y.a.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import y.c.*;
import y.d.*;

class aN
{
    private static final double a;
    private static final Object b;
    private static final Object c;
    private double d;
    private double e;
    private Z f;
    
    public void a(final double d) {
        this.d = d;
    }
    
    public void b(final double e) {
        this.e = e;
    }
    
    public void a(final f f, final ac ac, final Z f2) {
        final int i = ab.a;
        this.f = f2;
        final X a = f2.a();
        final h b = M.b();
        final D d = new D();
        final D d2 = new D();
        e e = f.a();
        while (true) {
        Label_0443:
            while (true) {
                do {
                    Label_0045: {
                        e.f();
                    }
                    boolean k = false;
                    Label_0052:
                    while (k) {
                        d d3 = e.a();
                        final w a2 = ac.a(d3);
                        final w w2;
                        final w w = w2 = a2;
                        if (i == 0) {
                            if (w != null) {
                                final aR ar = new aR(this, a2);
                                b.a(d3, ar);
                                final aS[] a3 = ar.a();
                                int j = 0;
                                while (j < a3.length) {
                                    k = a3[j].k();
                                    if (i != 0) {
                                        continue Label_0052;
                                    }
                                    Label_0166: {
                                        if (k) {
                                            d.add(a3[j]);
                                            if (i == 0) {
                                                break Label_0166;
                                            }
                                        }
                                        d2.add(a3[j]);
                                    }
                                    ++j;
                                    if (i != 0) {
                                        break;
                                    }
                                }
                            }
                            e.g();
                            continue Label_0045;
                        }
                        final Object b2;
                        final aR ar2 = (aR)b2;
                        if (i == 0) {
                            if (ar2 != null) {
                                a.b(d3, ar2.b());
                            }
                            e.g();
                            if (i == 0) {
                                if (e.f()) {
                                    d3 = e.a();
                                    b.b(d3);
                                    continue Label_0443;
                                }
                            }
                            this.f = null;
                        }
                        return;
                    }
                    break;
                } while (i == 0);
                e = a.p();
                do {
                    Label_0193: {
                        e.f();
                    }
                    boolean b3 = false;
                    Label_0200:
                    while (b3) {
                        final d d3 = e.a();
                        final Object b2 = b.b(d3);
                        if (i == 0) {
                            if (b2 == null && y.b(d3, a)) {
                                final v l = a.l(d3);
                                m m = null;
                                final s j2 = l.j();
                                while (j2.f()) {
                                    final m a4 = j2.a();
                                    b3 = a4.b();
                                    if (i != 0) {
                                        continue Label_0200;
                                    }
                                    if (b3 || a4.a()) {
                                        Label_0361: {
                                            if (m != null && m.a() != a4.a()) {
                                                final aQ aq = new aQ(this, m, a4, d3);
                                                if (aq.k()) {
                                                    d.add(aq);
                                                    if (i == 0) {
                                                        break Label_0361;
                                                    }
                                                }
                                                d2.add(aq);
                                            }
                                        }
                                        m = a4;
                                    }
                                    j2.g();
                                    if (i != 0) {
                                        break;
                                    }
                                }
                            }
                            e.g();
                            continue Label_0193;
                        }
                        continue Label_0443;
                    }
                    break;
                } while (i == 0);
                break;
            }
            this.a(a, d, -45);
            this.a(a, d2, 45);
            e = f.a();
            continue;
        }
    }
    
    private void a(final X x, final D d, final int n) {
        final int a = ab.a;
        if (d == null || d.isEmpty()) {
            return;
        }
        final Rectangle a2 = x.a();
        final AffineTransform affineTransform = new AffineTransform();
        final double n2 = a2.x + a2.width / 2;
        final double n3 = a2.y + a2.height / 2;
        affineTransform.translate(n2, n3);
        affineTransform.rotate(y.d.e.a(n));
        affineTransform.translate(-n2, -n3);
        final i a3 = this.a(d, affineTransform);
        final A a4 = M.a();
        u.a(a3, a4, a3.c(aN.c), a3.c(aN.b));
        final C m = d.m();
        while (m.f()) {
            final aT at = (aT)m.d();
            if (!at.a()) {
                at.a(Math.abs(a4.a(at.f) - a4.a(at.e)) * aN.a);
            }
            m.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private i a(final D d, final AffineTransform affineTransform) {
        final int a = ab.a;
        final i i = new i();
        final h b = M.b();
        i.a(aN.b, b);
        final h b2 = M.b();
        i.a(aN.c, b2);
        final y.c.y y = new y.c.y();
        final A a2 = M.a();
        final HashMap<Object, q> hashMap = new HashMap<Object, q>();
        final Point2D.Double double1 = new Point2D.Double();
        final A a3 = M.a();
        final C m = d.m();
        while (m.f()) {
            final aT at = (aT)m.d();
            final double b3 = at.b();
            final double c = at.c();
            double1.setLocation(b3, c);
            affineTransform.transform(double1, double1);
            if (a != 0) {
                return i;
            }
            Integer n = null;
            Label_0202: {
                if (at.i() == 1 || at.i() == 3) {
                    n = new Integer((int)Math.floor(double1.getX()));
                    if (a == 0) {
                        break Label_0202;
                    }
                }
                n = new Integer((int)Math.ceil(double1.getX()));
            }
            if (!at.a()) {
                q d2 = hashMap.get(n);
                if (d2 == null) {
                    d2 = i.d();
                    hashMap.put(n, d2);
                    a2.a(d2, (int)n);
                    y.add(d2);
                }
                at.e = d2;
            }
            double1.setLocation((b3 + at.d()) / 2.0, (c + at.e()) / 2.0);
            affineTransform.transform(double1, double1);
            Integer n2 = null;
            Label_0377: {
                if (at.i() == 1 || at.i() == 3) {
                    n2 = new Integer((int)Math.ceil(double1.getX()));
                    if (a == 0) {
                        break Label_0377;
                    }
                }
                n2 = new Integer((int)Math.floor(double1.getX()));
            }
            q d3 = hashMap.get(n2);
            if (d3 == null) {
                d3 = i.d();
                hashMap.put(n2, d3);
                a2.a(d3, (int)n2);
                y.add(d3);
            }
            final q d4 = i.d();
            a3.a(d4, (int)n2);
            at.f = d4;
            Label_0708: {
                if (at.a()) {
                    b2.a(i.a(d3, d4), 100000);
                    if (a == 0) {
                        break Label_0708;
                    }
                }
                if (n - n2 == 0) {
                    b2.a(i.a(at.e, d4), 100000);
                    if (a == 0) {
                        break Label_0708;
                    }
                }
                final q d5 = i.d();
                final int n3 = n - n2;
                d d6 = null;
                d d7 = null;
                Label_0655: {
                    if (n3 > 0) {
                        i.a(d4, at.e);
                        i.a(d3, d5);
                        d6 = i.a(d5, d4);
                        d7 = i.a(d5, at.e);
                        if (a == 0) {
                            break Label_0655;
                        }
                    }
                    i.a(at.e, d4);
                    i.a(d5, d3);
                    d6 = i.a(d4, d5);
                    d7 = i.a(at.e, d5);
                }
                b2.a(d6, 1);
                b.a(d7, Math.min((int)Math.ceil(this.e / 2.0), Math.abs(n3)));
                b2.a(d7, 1);
            }
            m.g();
            if (a != 0) {
                break;
            }
        }
        this.a(i, y, a2);
        this.a(d, i, b, b2, a3);
        return i;
    }
    
    private void a(final i i, final y.c.y y, final A a) {
        final int a2 = ab.a;
        y.sort(new aO(this, a));
        final h h = (h)i.c(aN.b);
        final h h2 = (h)i.c(aN.c);
        q q = null;
        final x a3 = y.a();
        while (a3.f()) {
            final q e = a3.e();
            if (q != null) {
                final d a4 = i.a(q, e);
                h2.a(a4, 100000);
                h.a(a4, a.a(e) - a.a(q));
            }
            q = e;
            a3.g();
            if (a2 != 0) {
                break;
            }
        }
    }
    
    private void a(final D d, final i i, final h h, final h h2, final c c) {
        y.d.f.a(d, new aP(this, i, h, h2, c));
    }
    
    private double a(final aT at, final aT at2) {
        return Math.max(this.f.c().a(at.j()).c(), this.f.c().a(at2.j()).c());
    }
    
    static double a(final aN an, final aT at, final aT at2) {
        return an.a(at, at2);
    }
    
    static double a(final aN an) {
        return an.d;
    }
    
    static {
        a = Math.sqrt(2.0);
        b = "y.layout.router.polyline.Polyliner.MIN_EDGE_LENGTH_DPKEY";
        c = "y.layout.router.polyline.Polyliner.EDGE_WEIGHT_DPKEY";
    }
}
