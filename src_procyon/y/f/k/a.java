package y.f.k;

import java.util.*;
import y.f.b.*;
import java.awt.geom.*;
import y.f.*;
import y.d.*;
import y.c.*;

public class a extends c
{
    public static final Object n;
    public static final Object o;
    public static final Object p;
    public static final Object q;
    public static final Object r;
    public static final Object s;
    public static final Object t;
    public static final Object u;
    public static final Object v;
    private A y;
    private U z;
    protected X w;
    private double A;
    private double B;
    private double C;
    private double D;
    private Object E;
    private Object F;
    private double G;
    Comparator x;
    
    public a() {
        this.A = 10.0;
        this.B = 10.0;
        this.C = 5.0;
        this.D = 1.41;
        this.E = a.q;
        this.F = a.u;
        this.G = 20.0;
        final ad f = this.f();
        if (f instanceof b) {
            ((b)f).a(false);
        }
    }
    
    public void a(final double a) {
        this.A = a;
    }
    
    public void b(final double b) {
        this.B = b;
    }
    
    public void a(final X w) {
        final int g = d.g;
        if (!y.a.A.b(w)) {
            throw new B("Graph is not a tree");
        }
        ae.a(w);
        this.w = w;
        final f e = y.a.A.e(w);
        this.z = new U(w);
        final q a = this.z.a();
        this.y = w.t();
        this.c(a);
        this.d(a);
        w.a(this.y);
        while (!e.isEmpty()) {
            final y.c.d d = e.d();
            ae.a(w.g(d));
            w.c(d);
            if (g != 0) {
                return;
            }
            if (g != 0) {
                break;
            }
        }
        ae.b(w);
    }
    
    public boolean b(final X x) {
        return y.a.A.b(x);
    }
    
    protected double a(final q q) {
        final y.c.c c = this.w.c(a.n);
        if (c == null) {
            return this.a();
        }
        final Object b = c.b(q);
        if (b instanceof Number) {
            return ((Number)b).doubleValue();
        }
        return this.a();
    }
    
    private y.f.k.b c(final q q) {
        final int g = d.g;
        final y.f.k.b b = new y.f.k.b();
        this.y.a(q, b);
        if (!this.z.a(q)) {
            final Object b2 = this.b((Object)q);
            final Object a = this.a((Object)q);
            final x o = q.o();
            while (o.f()) {
                this.c(o.e());
                o.g();
                if (g != 0) {
                    return b;
                }
                if (g != 0) {
                    break;
                }
            }
            final y.d.q a2 = this.a(q, this.a(q));
            Label_0637: {
                if (y.f.k.a.p.equals(b2)) {
                    b.b = this.w.q(q) + 2.0 * this.G + a2.b();
                    b.a = Math.max(this.w.p(q), a2.a());
                    if (g == 0) {
                        break Label_0637;
                    }
                }
                final double p = this.w.p(q);
                final double q2 = this.w.q(q);
                final double n = Math.max(p, a2.a() + 2.0 * this.G) * (q2 + a2.b() + 2.0 * this.G);
                final double n2 = (p + 2.0 * this.G + a2.a()) * Math.max(q2, a2.b() + 2.0 * this.G);
                double b3 = 0.0;
                Label_0332: {
                    if (b.f > 1 || y.f.k.a.u.equals(a)) {
                        b3 = 2.0 * this.G + a2.b();
                        if (g == 0) {
                            break Label_0332;
                        }
                    }
                    b3 = this.B + a2.b();
                }
                Label_0388: {
                    if (this.G < p) {
                        Math.max(p, a2.a() + 2.0 * this.G);
                        if (g == 0) {
                            break Label_0388;
                        }
                    }
                    Math.max(p, a2.a() + this.G + p);
                }
                double a3 = 0.0;
                Label_0625: {
                    if (y.f.k.a.q.equals(b2)) {
                        if (n < n2) {
                            b3 += q2;
                            if (this.G < p) {
                                a3 = Math.max(p, a2.a() + 2.0 * this.G);
                                if (g == 0) {
                                    break Label_0625;
                                }
                            }
                            a3 = Math.max(p, a2.a() + this.G + p);
                            if (g == 0) {
                                break Label_0625;
                            }
                        }
                        b.g = true;
                        b3 = Math.max(b3, q2);
                        a3 = p + a2.a() + 2.0 * this.G;
                        if (g == 0) {
                            break Label_0625;
                        }
                    }
                    if (y.f.k.a.r.equals(b2)) {
                        b.g = true;
                        b3 = Math.max(b3, q2);
                        a3 = p + a2.a() + 2.0 * this.G;
                        if (g == 0) {
                            break Label_0625;
                        }
                    }
                    b3 += q2;
                    if (this.G < p) {
                        a3 = Math.max(p, a2.a() + 2.0 * this.G);
                        if (g == 0) {
                            break Label_0625;
                        }
                    }
                    a3 = Math.max(p, a2.a() + this.G + p);
                }
                b.a = a3;
                b.b = b3;
            }
            b.e = a2;
            if (g == 0) {
                return b;
            }
        }
        b.a = this.w.p(q);
        b.b = this.w.q(q);
        return b;
    }
    
    private y.d.q a(final q q, final double n) {
        final int g = d.g;
        double a = this.A;
        double b = this.B;
        final Object a2 = this.a((Object)q);
        final Rectangle2D.Double[] array = new Rectangle2D.Double[q.c()];
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        int n2 = 0;
        final x a3 = new y(this.b(q)).a();
        int f = 0;
        Object b5 = null;
        Label_0520: {
            Label_0510: {
                Label_0278: {
                    if (y.f.k.a.u.equals(a2)) {
                        b += this.G;
                        final x x = a3;
                        while (true) {
                            while (x.f()) {
                                final y.f.k.b b2 = (y.f.k.b)this.y.b(x.e());
                                final Rectangle2D.Double[] array2 = array;
                                if (g != 0) {
                                    f = ae.a(array2, double1, n, 1);
                                    n2 = 0;
                                    a3.i();
                                    final y.f.k.b b3 = (y.f.k.b)a3;
                                    while (((C)b3).f()) {
                                        final y.f.k.b b4 = (y.f.k.b)this.y.b(((x)b3).e());
                                        final Rectangle2D.Double double2 = array[n2++];
                                        b4.c = double2.x;
                                        b4.d = double2.y;
                                        final x x2 = (x)(b5 = b3);
                                        if (g != 0) {
                                            break Label_0520;
                                        }
                                        x2.g();
                                        if (g != 0) {
                                            break Label_0278;
                                        }
                                    }
                                    break Label_0510;
                                }
                                array2[n2++] = new Rectangle2D.Double(0.0, 0.0, b2.a + a, b2.b + b);
                                x.g();
                                if (g != 0) {
                                    break;
                                }
                            }
                            continue;
                        }
                    }
                }
                a += this.G;
                final x x3 = a3;
                while (true) {
                    while (x3.f()) {
                        final y.f.k.b b6 = (y.f.k.b)this.y.b(x3.e());
                        final Rectangle2D.Double[] array3 = array;
                        if (g != 0) {
                            f = ae.a(array3, double1, 1.0 / n, 1);
                            double1.setFrame(double1.getY(), double1.getX(), double1.getHeight(), double1.getWidth());
                            int n3 = 0;
                            a3.i();
                            final x x4 = a3;
                            while (x4.f()) {
                                final y.f.k.b b7 = (y.f.k.b)this.y.b(x4.e());
                                final Rectangle2D.Double double3 = array[n3++];
                                b7.c = double3.y;
                                b7.d = double3.x;
                                final y.f.k.b b8 = (y.f.k.b)(b5 = x4);
                                if (g != 0) {
                                    break Label_0520;
                                }
                                ((C)b8).g();
                                if (g != 0) {
                                    break;
                                }
                            }
                            break Label_0510;
                        }
                        array3[n2++] = new Rectangle2D.Double(0.0, 0.0, b6.b + b, b6.a + a);
                        x3.g();
                        if (g != 0) {
                            break;
                        }
                    }
                    continue;
                }
            }
            b5 = this.y.b(q);
        }
        ((y.f.k.b)b5).f = f;
        return new y.d.q(double1.getWidth() - double1.getX() - a, double1.getHeight() - double1.getY() - b);
    }
    
    protected x b(final q q) {
        if (this.x != null) {
            q.b(this.x);
        }
        return q.o();
    }
    
    private void d(final q q) {
        final int g = d.g;
        final y.f.k.b b = (y.f.k.b)this.y.b(q);
        final Object b2 = this.b((Object)q);
        final Object a = this.a((Object)q);
        double n = 0.0;
        double n2 = 0.0;
        Label_0327: {
            if (y.f.k.a.p.equals(b2)) {
                n = this.w.n(q) + this.w.q(q) + 2.0 * this.G;
                n2 = this.w.j(q) - b.e.a() / 2.0;
                if (g == 0) {
                    break Label_0327;
                }
            }
            final double p = this.w.p(q);
            if (b.g) {
                Label_0172: {
                    if (b.f > 1 || y.f.k.a.u.equals(a)) {
                        n = this.w.n(q) + 2.0 * this.G;
                        if (g == 0) {
                            break Label_0172;
                        }
                    }
                    n = this.w.n(q) + this.B;
                }
                n2 = this.w.m(q) + p + 2.0 * this.G;
                if (g == 0) {
                    break Label_0327;
                }
            }
            Label_0275: {
                if (b.f > 1 || y.f.k.a.u.equals(a)) {
                    n = this.w.n(q) + this.w.q(q) + 2.0 * this.G;
                    if (g == 0) {
                        break Label_0275;
                    }
                }
                n = this.w.n(q) + this.w.q(q) + this.B;
            }
            if (this.G < p) {
                n2 = this.w.m(q) + 2.0 * this.G;
                if (g == 0) {
                    break Label_0327;
                }
            }
            n2 = this.w.m(q) + this.G + p;
        }
        final e l = q.l();
        while (l.f()) {
            final y.c.d a2 = l.a();
            final q d = a2.d();
            final y.f.k.b b3 = (y.f.k.b)this.y.b(d);
            this.w.c(d, n2 + b3.c, n + b3.d);
            if (!this.z.a(d)) {
                this.d(d);
            }
            final I g2 = this.w.g(a2);
            g2.clearPoints();
            this.a(g2, q, d, b2, a);
            l.g();
            if (g != 0) {
                break;
            }
        }
    }
    
    protected void a(final I i, final q q, final q q2, final Object o, final Object o2) {
        final int g = d.g;
        final y.f.k.b b = (y.f.k.b)this.y.b(q);
        final double p5 = this.w.p(q);
        final double q3 = this.w.q(q);
        if (a.p.equals(o)) {
            final double j = this.w.j(q);
            final double n = this.w.n(q) + q3 + this.G;
            i.addPoint(j, n);
            if (a.u.equals(o2)) {
                final double n2 = this.w.n(q2) - this.G;
                i.addPoint(j, n2);
                i.addPoint(this.w.j(q2), n2);
                if (g == 0) {
                    return;
                }
            }
            double n3 = 0.0;
            Label_0204: {
                if (this.w.j(q2) < j) {
                    n3 = this.w.m(q2) + this.w.p(q2) + this.G;
                    if (g == 0) {
                        break Label_0204;
                    }
                }
                n3 = this.w.m(q2) - this.G;
            }
            i.addPoint(n3, n);
            i.addPoint(n3, this.w.k(q2));
            if (g == 0) {
                return;
            }
        }
        double n4 = 0.0;
        double n5 = 0.0;
        Label_0366: {
            if (b.g) {
                i.setSourcePoint(new t(0.0, -q3 / 2.0 + this.C));
                n4 = this.w.m(q) + p5 + this.G;
                n5 = this.w.n(q) + this.C;
                if (g == 0) {
                    break Label_0366;
                }
            }
            i.setSourcePoint(new t(-p5 / 2.0 + this.C, 0.0));
            n4 = this.w.m(q) + this.C;
            n5 = this.w.n(q) + q3 + this.G;
        }
        i.addPoint(n4, n5);
        if (a.u.equals(o2)) {
            final double n6 = this.w.n(q2) - this.G;
            i.addPoint(n4, n6);
            i.addPoint(this.w.j(q2), n6);
            if (g == 0) {
                return;
            }
        }
        final double n7 = this.w.m(q2) - this.G;
        i.addPoint(n7, n5);
        i.addPoint(n7, this.w.k(q2));
    }
    
    protected Object a(final Object o) {
        final y.c.c c = this.w.c(a.t);
        if (c == null) {
            return this.o();
        }
        final Object b = c.b(o);
        if (b != null) {
            return b;
        }
        return this.o();
    }
    
    protected Object b(final Object o) {
        final y.c.c c = this.w.c(a.o);
        if (c == null) {
            return this.n();
        }
        final Object b = c.b(o);
        if (b != null) {
            return b;
        }
        return this.n();
    }
    
    public double a() {
        return this.D;
    }
    
    public Object n() {
        return this.E;
    }
    
    public void c(final Object e) {
        this.E = e;
    }
    
    public Object o() {
        return this.F;
    }
    
    public void c(final double g) {
        this.G = g;
    }
    
    static {
        n = "y.layout.tree.ARTreeLayouter.RATIO";
        o = "y.layout.tree.ARTreeLayouter.ROOT_PLACEMENT";
        p = "y.layout.tree.ARTreeLayouter.PLACEMENT_TOP";
        q = "y.layout.tree.ARTreeLayouter.PLACEMENT_CORNER";
        r = "y.layout.tree.ARTreeLayouter.PLACEMENT_CORNER_SIDE";
        s = "y.layout.tree.ARTreeLayouter.PLACEMENT_CORNER_TOP";
        t = "y.layout.tree.ARTreeLayouter.ROUTING_POLICY";
        u = "y.layout.tree.ARTreeLayouter.ROUTING_HORIZONTAL";
        v = "y.layout.tree.ARTreeLayouter.ROUTING_VERTICAL";
    }
}
