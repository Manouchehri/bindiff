package y.f.c;

import y.g.*;
import y.d.*;
import java.util.*;
import y.f.*;
import y.c.*;

public class K extends c implements aF
{
    private byte n;
    private long u;
    private long v;
    private boolean w;
    private int x;
    private boolean y;
    private boolean z;
    private double A;
    private double B;
    private double C;
    private double D;
    private R E;
    private Q F;
    private v G;
    private ao H;
    private double I;
    static final Object o;
    static final Object p;
    static final Object q;
    static final Object r;
    static final Object s;
    static final Object t;
    private L J;
    
    public K() {
        this.n = 0;
        this.v = 2147483647L;
        this.w = true;
        this.x = 1;
        this.y = false;
        this.z = true;
        this.A = 40.0;
        this.B = 20.0;
        this.C = 10.0;
        this.D = 10.0;
        this.I = 20.0;
        this.f(false);
        this.b(false);
        this.e(true);
        this.F = new h();
        this.H = new aw();
        this.c((byte)2);
        this.b((byte)1);
    }
    
    public byte q() {
        return this.n;
    }
    
    public void b(final byte b) {
        final boolean i = y.f.c.a.i;
        y.g.o.a(this, "Set Layout style: " + b);
        Label_0143: {
            switch (b) {
                case 2: {
                    this.G = new aa();
                    if (i) {
                        break Label_0143;
                    }
                    return;
                }
                case 1: {
                    this.G = new V();
                    if (i) {
                        break Label_0143;
                    }
                    return;
                }
                case 0: {
                    this.G = new Z();
                    if (i) {
                        break Label_0143;
                    }
                    return;
                }
                case 3: {
                    this.G = new ag();
                    if (i) {
                        break Label_0143;
                    }
                    return;
                }
                case 4: {
                    this.G = new ae();
                    if (i) {
                        break Label_0143;
                    }
                    return;
                }
                case 5: {
                    this.G = new S(new ae());
                    if (i) {
                        break;
                    }
                    return;
                }
            }
        }
        this.G = new V();
    }
    
    public void c(final byte b) {
        final boolean i = y.f.c.a.i;
        Label_0156: {
            switch (b) {
                case 0: {
                    final af e = new af();
                    e.a((byte)0);
                    this.E = e;
                    return;
                }
                case 1: {
                    this.E = new aj();
                    if (i) {
                        break Label_0156;
                    }
                    return;
                }
                case 2: {
                    final af e2 = new af();
                    e2.a((byte)2);
                    this.E = e2;
                    return;
                }
                case 3: {
                    final af e3 = new af();
                    e3.a((byte)1);
                    this.E = e3;
                    return;
                }
                case 4: {
                    this.E = new g();
                    if (i) {
                        break Label_0156;
                    }
                    return;
                }
                case 5: {
                    this.E = new e();
                    if (i) {
                        break Label_0156;
                    }
                    return;
                }
                case 6: {
                    this.E = new D();
                    if (i) {
                        break;
                    }
                    return;
                }
            }
        }
        throw new IllegalArgumentException("layeringStrategy " + b + " unknown.");
    }
    
    public void a(final R e) {
        this.E = e;
    }
    
    public R a() {
        return this.E;
    }
    
    public void a(final Q f) {
        this.F = f;
    }
    
    public Q n() {
        return this.F;
    }
    
    public void a(final v g) {
        (this.G = g).c(this.B);
        this.G.d(this.A);
    }
    
    public v o() {
        return this.G;
    }
    
    public double r() {
        return this.C;
    }
    
    public double s() {
        return this.I;
    }
    
    public boolean b(final X x) {
        return true;
    }
    
    public void a(final X x) {
        final boolean i = y.f.c.a.i;
        this.u = System.currentTimeMillis();
        y.f.ae.a(x, false);
        final A t = x.t();
        final A t2 = x.t();
        y.c.c c = null;
        y.c.c c2 = x.c(K.o);
        if (c2 == null) {
            c = (c2 = x.t());
            x.a(K.o, c);
            final y.c.x o = x.o();
            while (o.f()) {
                ((A)c).a(o.e(), K.p);
                o.g();
                if (i) {
                    y.c.i.g = !y.c.i.g;
                    break;
                }
            }
        }
        final y.c.D d = new y.c.D();
        A t3 = null;
        y.c.h u = null;
        y.c.c c3 = null;
        y.c.c c4 = null;
        if (this.J != null) {
            if (x.c(ah.f_) == null) {
                throw new IllegalStateException("No DataProvider " + ah.f_ + " bound to graph!");
            }
            if (x.c(ah.k) == null) {
                throw new IllegalStateException("No DataProvider " + ah.k + " bound to graph!");
            }
            t3 = x.t();
            u = x.u();
            c3 = new ap(t3, x, ah.f_);
            c4 = new ap(u, x, ah.k);
            this.J.a(c2, t, t2, this.E, d, this.F, c3, t3, c4, u);
        }
        final y.c.h u2 = x.u();
        final f f = new f();
        final aE ae = new aE(x, t, t2, u2);
        ae.a(true);
        final x x2 = new x(x, t, t2, u2, d);
        x2.a(this.y);
        x2.b(this.z);
        if (t3 != null) {
            x2.a(t3, c3, u, c4);
        }
        final boolean b = this.q() == 1;
        x2.c(b);
        x2.a(this.r());
        x2.b(this.s());
        Label_0493: {
            if (b) {
                x2.c(this.A);
                this.G.d(0.0);
                if (!i) {
                    break Label_0493;
                }
            }
            x2.c(this.A);
            this.G.d(0.0);
        }
        this.G.c(this.B);
        this.G.a(this.C);
        this.G.b(this.D);
        this.G.a(t2);
        x2.b();
        int n = 0;
        Label_0653: {
            if (this.J != null && (this.J.a((byte)1) || this.J.b() != null)) {
                n = this.J.a(x, t, f);
                if (!i) {
                    break Label_0653;
                }
            }
            n = this.E.a(x, t, f);
            int j = 0;
            while (j < n) {
                d.add("LayerID" + j);
                ++j;
                if (i) {
                    break;
                }
            }
        }
        p p = f.k();
        while (true) {
            while (p != null) {
                u2.a(p.c(), true);
                p = p.a();
                if (i) {
                    if (this.n() instanceof h) {
                        final h h = (h)this.n();
                        h.b(this.w);
                        h.a(this.v - (System.currentTimeMillis() - this.u));
                    }
                    final y[] b2 = x2.b(ae.a(x2.a(this.a(x, t, n))));
                    this.G.a(x, b2, t);
                    x2.d(x2.c(b2));
                    ae.a(x2.f());
                    x2.c();
                    this.H.b(x, t, t2);
                    x2.d();
                    this.d(x);
                    this.a(x, f);
                    x2.e();
                    ae.c();
                    if (c != null) {
                        x.d_(K.o);
                        x.a((A)c);
                    }
                    if (c3 != null) {
                        ((ap)c3).b();
                    }
                    if (c4 != null) {
                        ((ap)c4).b();
                    }
                    if (t3 != null) {
                        x.a(t3);
                    }
                    if (u != null) {
                        x.a(u);
                    }
                    x.a(u2);
                    x.a(t2);
                    x.a(t);
                    return;
                }
                if (i) {
                    break;
                }
            }
            final int a = x2.a(x2.a(n, f));
            this.H.a(x, t, t2);
            n = x2.c(x2.b(a));
            continue;
        }
    }
    
    protected y[] a(final X x, final A a, final int n) {
        if (this.J != null && (this.J.a((byte)2) || this.J.b() != null)) {
            return this.J.a(x, a, n);
        }
        return this.F.a(x, a, n);
    }
    
    static A a(final i i) {
        return (A)i.c(K.o);
    }
    
    static Object a(final y y, final y.c.c c) {
        final boolean i = y.f.c.a.i;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        p p2 = y.k();
        Object b = null;
        while (p2 != null) {
            final Object o = b = c.b(p2.c());
            if (i) {
                return b;
            }
            Label_0122: {
                if (b == null) {
                    ++n;
                    if (!i) {
                        break Label_0122;
                    }
                }
                if (o == K.p) {
                    ++n2;
                    if (!i) {
                        break Label_0122;
                    }
                }
                if (o == K.r) {
                    ++n4;
                    if (!i) {
                        break Label_0122;
                    }
                }
                if (o == K.q) {
                    ++n5;
                    if (!i) {
                        break Label_0122;
                    }
                }
                if (o == K.s) {
                    ++n3;
                }
            }
            ++n6;
            p2 = p2.a();
            if (i) {
                break;
            }
        }
        if (n6 == n) {
            return K.p;
        }
        final int n7 = n6 - n;
        if (n7 == n3) {
            return K.s;
        }
        if (n7 == n5) {
            return K.q;
        }
        if (n7 == n3 + n5) {
            return K.q;
        }
        if (n7 == n4 + n5) {
            return K.r;
        }
        if (n7 == n2 + n5 + n3) {
            return K.p;
        }
        final Object o2 = (n4 > 0) ? K.r : K.p;
        return b;
    }
    
    private void a(final X x, final f f) {
        final boolean i = y.f.c.a.i;
        final y.c.e a = f.a();
        while (a.f()) {
            final d a2 = a.a();
            final t p2 = x.p(a2);
            final t q = x.q(a2);
            x.c(a2);
            x.b(a2, x.j(a2).g());
            x.d(a2, p2);
            x.c(a2, q);
            a.g();
            if (i) {
                break;
            }
        }
    }
    
    private void d(final X x) {
        final boolean i = y.f.c.a.i;
        final y.c.e p = x.p();
        while (p.f()) {
            final d a = p.a();
            final I g = x.g(a);
            Label_0360: {
                if (g.pointCount() > 0) {
                    final ArrayList list = new ArrayList<t>(g.pointCount());
                    final C a2 = x.l(a).a();
                    final t t = (t)a2.d();
                    a2.g();
                    double a3 = t.a();
                    double b = t.b();
                    double n = 0.0;
                    Label_0278: {
                        if (a2.f()) {
                            t t2 = (t)a2.d();
                            double a4 = t2.a();
                            double b2 = t2.b();
                            a2.g();
                            while (a2.f()) {
                                final t t3 = (t)a2.d();
                                final double a5 = t3.a();
                                final double b3 = t3.b();
                                n = dcmpl(Math.abs((a3 - a5) * (b2 - b3) / (b - b3) + a5 - a4), (double)this.x);
                                if (i) {
                                    break Label_0278;
                                }
                                if (n > 0) {
                                    list.add(t2);
                                    a3 = a4;
                                    b = b2;
                                }
                                t2 = t3;
                                a4 = a5;
                                b2 = b3;
                                a2.g();
                                if (i) {
                                    break;
                                }
                            }
                        }
                        list.size();
                    }
                    if (n < g.pointCount()) {
                        g.clearPoints();
                        int j = 0;
                        while (j < list.size()) {
                            final t t4 = list.get(j);
                            g.addPoint(t4.a, t4.b);
                            ++j;
                            if (i) {
                                break Label_0360;
                            }
                            if (i) {
                                break;
                            }
                        }
                    }
                }
                p.g();
            }
            if (i) {
                break;
            }
        }
    }
    
    public Y t() {
        if (this.J == null) {
            this.J = new L();
        }
        return this.J;
    }
    
    boolean u() {
        return this.J != null && this.t().b() != null;
    }
    
    public void v() {
        if (this.J != null) {
            this.J.c();
            this.J = null;
        }
    }
    
    static {
        o = "y.layout.hierarchic.HierarchicLayouter.NODE_TYPE_MAP_KEY";
        p = "y.layout.hierarchic.HierarchicLayouter.NORMAL_NODE_TYPE";
        q = "y.layout.hierarchic.HierarchicLayouter.BEND_NODE_TYPE";
        r = "y.layout.hierarchic.HierarchicLayouter.DUMMY_NODE_TYPE";
        s = "y.layout.hierarchic.HierarchicLayouter.LABEL_NODE_TYPE";
        t = "y.layout.hierarchic.HierarchicLayouter.SAME_LAYER_DUMMY_TYPE";
    }
}
