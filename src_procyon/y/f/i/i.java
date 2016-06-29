package y.f.i;

import y.g.*;
import y.d.*;
import java.util.*;
import java.io.*;
import y.c.*;
import y.f.*;
import java.awt.geom.*;

public class i extends a
{
    static final Object a;
    static final Object b;
    static final Object c;
    private boolean d;
    private double e;
    
    public i(final ah ah) {
        this.d = false;
        this.e = 15.0;
        this.a(ah);
    }
    
    public void c(final X x) {
        final int f = v.f;
        final v b = this.b();
        if (b == null) {
            throw new IllegalStateException("No OrthogonalEdgeRouter in coreLayouter");
        }
        if (!this.a(x, b)) {
            this.a().c(x);
            return;
        }
        final c c = x.c(ax.a);
        final c c2 = x.c(ax.b);
        final h a = this.a(x, c);
        final h a2 = this.a(x, c2);
        final c c3 = x.c(aF.a);
        final c c4 = x.c(aF.b);
        if (c == null && c2 == null && (c3 != null || c4 != null)) {
            final e p = x.p();
            while (p.f()) {
                final d a3 = p.a();
                final aE ae = (aE)c3.b(a3);
                if (ae != null) {
                    ax ax = y.f.ax.a(ae);
                    if (ae.a()) {
                        final t n = x.n(a3);
                        ax = y.f.ax.a(n.a, n.b, ax.a());
                    }
                    final D d = new D();
                    d.add(ax);
                    a.a(a3, d);
                }
                final aE ae2 = (aE)c4.b(a3);
                if (ae2 != null) {
                    ax ax2 = ax.a(ae2);
                    if (ae2.a()) {
                        final t o = x.o(a3);
                        ax2 = ax.a(o.a, o.b, ax2.a());
                    }
                    final D d2 = new D();
                    d2.add(ax2);
                    a2.a(a3, d2);
                }
                p.g();
                if (f != 0) {
                    break;
                }
            }
        }
        final l l = new l(x);
        l.a();
        final c c5 = x.c(aF.d);
        final D d3 = new D();
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        final x o2 = x.o();
    Label_0380:
        while (true) {
            q e;
            e k;
            d a4;
            Object b2;
            f f2;
            A a5;
            A a6;
            ar ar;
            h a7;
            I i;
            m m;
            C j;
            boolean f4 = false;
            Object d4;
            f f5 = null;
            y a8 = null;
            f f6 = null;
            e a9;
            d a10;
            f f7;
            D d5;
            q d6;
            Serializable s;
            RectangularShape a11;
            byte b3;
            t t;
            y a12;
            e a13;
            d a14;
            int contains;
            double j2;
            d b4;
            c c6;
            ax a15;
            Point2D.Double double1;
            Point2D.Double double2;
            q d7;
            d a16;
            D d8;
            ax a17;
            D d9;
            e a18;
            d a19;
            D m2;
            D d10;
            e k2;
            x a20;
            int n2;
            D d11;
            k k3;
            C m3;
            f f8;
            q q;
            d f9;
            D m4;
            t t2;
            t t3;
            Object c7;
            Object b5 = null;
            Object c8 = null;
            e a21;
            d a22;
            D m5;
            Label_0603_Outer:Label_2613_Outer:
            while (o2.f()) {
                e = o2.e();
                hashMap.clear();
                if (f == 0) {
                    k = e.k();
                    while (k.f()) {
                        a4 = k.a();
                        if (f != 0) {
                            continue Label_0380;
                        }
                        if (c5 != null && (b2 = c5.b(a4)) != null && !a4.e()) {
                            f2 = hashMap.get(b2);
                            if (f2 == null) {
                                f2 = new f();
                                hashMap.put(b2, f2);
                            }
                            f2.add(a4);
                        }
                        k.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    while (true) {
                        for (final f f3 : hashMap.values()) {
                            if (f3.size() > 1) {
                                d3.add(f3);
                                if (f == 0) {
                                    if (f != 0) {
                                        break;
                                    }
                                    continue Label_0603_Outer;
                                }
                                else {
                                    if (f != 0) {
                                        break Label_0603_Outer;
                                    }
                                    continue Label_0380;
                                }
                            }
                        }
                        o2.g();
                        continue Label_2613_Outer;
                    }
                }
                a5 = M.a();
                a6 = M.a();
                x.a(y.f.i.i.a, a5);
                l.a(a, a2);
                x.a(ax.a, a);
                x.a(ax.b, a2);
                if (x.c(aF.a) != null) {
                    x.d_(aF.a);
                }
                if (x.c(aF.b) != null) {
                    x.d_(aF.b);
                }
                ar = new ar(x, b);
                ar.c();
                a7 = ar.a();
                i = new I(x);
                i.a();
                m = new m();
                j = d3.m();
                Label_2110: {
                    while (true) {
                        j.f();
                    Label_1089_Outer:
                        while (f4) {
                            d4 = j.d();
                        Label_0795:
                            while (true) {
                                f5 = (f)d4;
                                a8 = this.a(f5.a(), true);
                                f6 = new f();
                                if (f == 0) {
                                    a9 = f5.a();
                                    while (a9.f()) {
                                        a10 = a9.a();
                                        f7 = (f)(d4 = a7);
                                        if (f != 0) {
                                            continue Label_0795;
                                        }
                                        if (f7 != null && a7.d(a10)) {
                                            f6.add(a10);
                                        }
                                        a9.g();
                                        if (f != 0) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                break Label_2110;
                            }
                            Label_2069: {
                                if (f6.isEmpty()) {
                                    f5.clear();
                                    a8.clear();
                                    if (f == 0) {
                                        break Label_2069;
                                    }
                                }
                                d5 = null;
                                d6 = f5.b().d();
                                s = null;
                                a11 = null;
                                if (d5 != null) {
                                    b3 = y.f.i.ah.a(x, d6, d5);
                                    t = (t)d5.f();
                                    s = new Point2D.Double(t.a, t.b);
                                }
                                else {
                                    b3 = y.f.i.ah.a(x, d6, f5);
                                }
                                a12 = y.f.i.ah.a(x, d6, a8, b3, this.e);
                                a13 = f5.a();
                                while (true) {
                                    while (a13.f()) {
                                        a14 = a13.a();
                                        contains = (a12.contains(a14.c()) ? 1 : 0);
                                        if (f == 0) {
                                            if (contains == 0) {
                                                f5.b(a13);
                                                a8.remove(a14.c());
                                            }
                                            a13.g();
                                            if (f != 0) {
                                                break;
                                            }
                                            continue Label_1089_Outer;
                                        }
                                        else {
                                            if (contains <= 1) {
                                                break Label_2069;
                                            }
                                            I.a(x, f5.a());
                                            Label_1440: {
                                                if (d5 == null) {
                                                    Label_1171: {
                                                        Label_1182: {
                                                            Label_1193: {
                                                                switch (b3) {
                                                                    case 2: {
                                                                        m.a((byte)0);
                                                                        if (f != 0) {
                                                                            break Label_1171;
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 1: {
                                                                        m.a((byte)2);
                                                                        if (f != 0) {
                                                                            break Label_1182;
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 4: {
                                                                        m.a((byte)1);
                                                                        if (f != 0) {
                                                                            break Label_1193;
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 8: {
                                                                        m.a((byte)3);
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    m.b(x);
                                                    a11 = y.f.i.ah.a(x, d6, a12, (byte)2);
                                                    j2 = x.j(d6);
                                                    b4 = f5.b();
                                                    c6 = x.c(ax.b);
                                                    if (c6 != null) {
                                                        a15 = this.a((Collection)c6.b(b4));
                                                        if (a15 != null && a15.b()) {
                                                            j2 = x.j(b4.d()) + a15.c();
                                                        }
                                                    }
                                                    s = new Point2D.Double(j2, a11.getMaxY());
                                                    Label_1406: {
                                                        if (b.q()) {
                                                            ((Point2D.Double)s).y = (int)Math.floor((((Point2D.Double)s).y - Math.max(this.e, b.s())) / b.s()) * b.s();
                                                            while (((Point2D.Double)s).y < a11.getMinY()) {
                                                                double1 = (Point2D.Double)s;
                                                                double1.y += Math.max(1, b.s());
                                                                if (f != 0) {
                                                                    continue Label_2110;
                                                                }
                                                                if (f != 0) {
                                                                    break Label_1406;
                                                                }
                                                            }
                                                            break Label_1440;
                                                        }
                                                    }
                                                    double2 = (Point2D.Double)s;
                                                    double2.y -= Math.min(a11.getHeight() / 2.0, Math.max(this.e, b.t()));
                                                }
                                            }
                                            d7 = x.d();
                                            Label_1487: {
                                                if (b3 == 1 || b3 == 2) {
                                                    a5.a(d7, y.f.i.i.c);
                                                    if (f == 0) {
                                                        break Label_1487;
                                                    }
                                                }
                                                a5.a(d7, y.f.i.i.b);
                                            }
                                            x.b(d7, Math.max(b.t(), 4.0), Math.max(0.5 * b.t(), 2.0));
                                            x.a(d7, ((Point2D.Double)s).x, ((Point2D.Double)s).y);
                                            a6.a(d7, a11);
                                            a16 = x.a(d7, d6);
                                            Label_1737: {
                                                if (d5 == null) {
                                                    d8 = new D();
                                                    d8.add(ax.a(aE.a((byte)0, true)));
                                                    a.a(a16, d8);
                                                    a17 = this.a((Collection)a2.b(f5.b()));
                                                    if (a17 != null) {
                                                        d9 = new D();
                                                        d9.add(a17);
                                                        a2.a(a16, d9);
                                                    }
                                                    x.d(a16, x.q(f5.b()));
                                                    f5.b();
                                                    if (a7 == null) {
                                                        break Label_1737;
                                                    }
                                                    a7.a(a16, true);
                                                    if (f == 0) {
                                                        break Label_1737;
                                                    }
                                                }
                                                x.a(a16, d5);
                                                if (a7 != null) {
                                                    a7.a(a16, false);
                                                }
                                            }
                                            a18 = f5.a();
                                            while (true) {
                                                while (a18.f()) {
                                                    a19 = a18.a();
                                                    m2 = null;
                                                    d10 = d5;
                                                    if (f != 0) {
                                                        if (d10 == null) {
                                                            m.d(x);
                                                        }
                                                        k2 = d7.k();
                                                        while (k2.f()) {
                                                            x.d(k2.a());
                                                            k2.g();
                                                            if (f != 0) {
                                                                continue Label_2110;
                                                            }
                                                            if (f != 0) {
                                                                break;
                                                            }
                                                        }
                                                        a20 = a8.a();
                                                        while (a20.f()) {
                                                            f4 = x.f(a20.e());
                                                            if (f != 0) {
                                                                continue Label_1089_Outer;
                                                            }
                                                            if (f4) {
                                                                x.c(a20.e());
                                                            }
                                                            a20.g();
                                                            if (f != 0) {
                                                                break;
                                                            }
                                                        }
                                                        i.a(d7);
                                                        break Label_2069;
                                                    }
                                                    Label_1860: {
                                                        if (d10 != null && a7 != null && !a7.d(a19)) {
                                                            m2 = x.m(a19);
                                                            n2 = 0;
                                                            while (n2 < d5.size() - 1) {
                                                                m2.j();
                                                                ++n2;
                                                                if (f != 0) {
                                                                    break Label_1860;
                                                                }
                                                                if (f != 0) {
                                                                    break;
                                                                }
                                                            }
                                                            if (m2.size() < 2) {
                                                                m2 = null;
                                                            }
                                                        }
                                                        x.a(a19, a19.c(), d7);
                                                    }
                                                    if (m2 != null) {
                                                        x.a(a19, m2);
                                                    }
                                                    x.b(a19, y.d.t.c);
                                                    d11 = new D();
                                                    d11.add(ax.a(aE.a((byte)0, true)));
                                                    a2.a(a19, d11);
                                                    if (a7 != null) {
                                                        a7.a(a19, true);
                                                    }
                                                    a18.g();
                                                    if (f != 0) {
                                                        break;
                                                    }
                                                }
                                                continue Label_2613_Outer;
                                            }
                                        }
                                    }
                                    f5.size();
                                    continue Label_2613_Outer;
                                }
                            }
                            j.g();
                            if (f != 0) {
                                break;
                            }
                            continue Label_2110;
                        }
                        break;
                    }
                    i.f();
                    this.a(x, a5, a6, y.f.i.i.c);
                    this.a(x, a5, a6, y.f.i.i.b);
                }
                k3 = new k();
                k3.a(x, a5);
                this.a().c(x);
                k3.a(x);
                m3 = d3.m();
                while (true) {
                    while (m3.f()) {
                        f8 = (f)m3.d();
                        if (f != 0) {
                            if (c != null) {
                                x.a(ax.a, c);
                            }
                            if (c2 != null) {
                                x.a(ax.b, c2);
                            }
                            if (c3 != null) {
                                x.a(aF.a, c3);
                            }
                            if (c4 != null) {
                                x.a(aF.b, c4);
                            }
                            return;
                        }
                        if (f8.size() > 1) {
                            q = f8.b().d();
                            f9 = q.f();
                            m4 = x.m(f9);
                            t2 = (t)m4.g();
                            t3 = (t)m4.f();
                            a5.b(q);
                            c7 = y.f.i.i.c;
                        Label_2246:
                            while (true) {
                                Label_2326: {
                                    if (b5 == c8) {
                                        if (y.f.i.ah.b(t2, t3)) {
                                            m4.g();
                                        }
                                        t3 = new t(t3.a, x.k(q));
                                        if (f == 0) {
                                            break Label_2326;
                                        }
                                    }
                                    if (y.f.i.ah.a(t2, t3)) {
                                        m4.g();
                                    }
                                    t3 = new t(x.j(q), t3.b);
                                }
                                m4.a(t3);
                                a21 = f8.a();
                                while (a21.f()) {
                                    a22 = a21.a();
                                    m5 = x.m(a22);
                                    t2 = (t)m5.j();
                                    q = a22.d();
                                    t3 = (t)m5.i();
                                    b5 = a5.b(q);
                                    c8 = y.f.i.i.c;
                                    if (f != 0) {
                                        continue Label_2246;
                                    }
                                    Label_2492: {
                                        if (b5 == c8) {
                                            if (y.f.i.ah.b(t2, t3)) {
                                                m5.j();
                                            }
                                            t3 = new t(t3.a, x.k(q));
                                            if (f == 0) {
                                                break Label_2492;
                                            }
                                        }
                                        if (y.f.i.ah.a(t2, t3)) {
                                            m5.j();
                                        }
                                        t3 = new t(x.j(q), t3.b);
                                    }
                                    m5.b(t3);
                                    m5.addAll(m4);
                                    x.a(a22, a22.c(), f9.d());
                                    x.a(a22, m5);
                                    a21.g();
                                    if (f != 0) {
                                        break;
                                    }
                                }
                                break;
                            }
                            x.a(q);
                        }
                        m3.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    a(x, x.p());
                    x.d_(y.f.i.i.a);
                    l.b();
                    ar.e();
                    x.a(a);
                    x.a(a2);
                    x.d_(ax.a);
                    x.d_(ax.b);
                    continue;
                }
            }
            if (d3.isEmpty()) {
                l.b();
                x.a(a);
                x.a(a2);
                this.a().c(x);
                return;
            }
            continue;
        }
    }
    
    private ax a(final Collection collection) {
        final int f = v.f;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ax ax = null;
        ax ax3 = null;
        for (final ax ax2 : collection) {
            if (ax == null) {
                ax = ax2;
            }
            if (!ax2.b()) {
                ax3 = ax2;
                if (f == 0) {
                    ax = ax3;
                    break;
                }
                return ax3;
            }
        }
        return ax3;
    }
    
    y a(final e e, final boolean b) {
        final int f = v.f;
        final y y = new y();
        y y2 = null;
        while (e.f()) {
            y2 = y;
            if (f != 0) {
                return y2;
            }
            y2.add(b ? e.a().c() : e.a().d());
            e.g();
            if (f != 0) {
                break;
            }
        }
        return y2;
    }
    
    v b() {
        final int f = v.f;
        ah ah = this.a();
        while (ah instanceof ad) {
            if (ah instanceof v) {
                return (v)ah;
            }
            ah = ((v)ah).a();
            if (f != 0) {
                break;
            }
        }
        return null;
    }
    
    boolean a(final X x, final v v) {
        return x.c(aF.c) != null || x.c(aF.d) != null;
    }
    
    h a(final X x, final c c) {
        final int f = v.f;
        final h u = x.u();
        h h = null;
        if (c != null) {
            final e p2 = x.p();
            while (p2.f()) {
                final d a = p2.a();
                h = u;
                if (f != 0) {
                    break;
                }
                h.a(a, c.b(a));
                p2.g();
                if (f != 0) {
                    break;
                }
            }
        }
        return h;
    }
    
    static void a(final X x, final e e) {
        final int f = v.f;
    Label_0146_Outer:
        while (e.f()) {
            final d a = e.a();
            final D m = x.m(a);
            final p k = m.k();
            t t = (t)k.c();
            final p a2 = k.a();
            t t2 = (t)a2.c();
            p p2 = a2.a();
            while (true) {
                while (p2 != null) {
                    final t t3 = (t)p2.c();
                    final boolean d = y.d.e.d(t, t2, t3);
                    if (f == 0) {
                        Label_0132: {
                            if (d) {
                                m.h(p2.b());
                                t2 = t3;
                                if (f == 0) {
                                    break Label_0132;
                                }
                            }
                            t = t2;
                            t2 = t3;
                        }
                        p2 = p2.a();
                        if (f != 0) {
                            break;
                        }
                        continue Label_0146_Outer;
                    }
                    else {
                        if (d) {
                            x.a(a, m);
                        }
                        e.g();
                        if (f != 0) {
                            break Label_0146_Outer;
                        }
                        continue Label_0146_Outer;
                    }
                }
                continue;
            }
        }
    }
    
    void a(final X x, final A a, final A a2, final Object o) {
        final int f = v.f;
        final w w = new w();
        final A t = w.t();
        final x o2 = x.o();
        while (o2.f()) {
            final q e = o2.e();
            Label_0186: {
                if (a.b(e) == o && a2.b(e) != null) {
                    final q d = w.d();
                    t.a(d, e);
                    final Rectangle2D rectangle2D = (Rectangle2D)a2.b(e);
                    if (o == i.c) {
                        w.b(d, rectangle2D.getWidth(), x.q(e));
                        w.c(d, rectangle2D.getX(), x.n(e));
                        if (f == 0) {
                            break Label_0186;
                        }
                    }
                    w.b(d, x.p(e), rectangle2D.getWidth());
                    w.c(d, x.m(e), rectangle2D.getX());
                }
            }
            o2.g();
            if (f != 0) {
                break;
            }
        }
        final y.f.e.l l = new y.f.e.l();
        l.b(true);
        l.a(5.0);
        l.c(w);
        final x o3 = w.o();
        while (o3.f()) {
            final q e2 = o3.e();
            final q q = (q)t.b(e2);
            Label_0324: {
                if (q != null) {
                    if (o == i.c) {
                        x.c(q, x.m(q), w.n(e2));
                        if (f == 0) {
                            break Label_0324;
                        }
                    }
                    x.c(q, w.m(e2), x.n(q));
                }
            }
            o3.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    static {
        a = "EdgeGroupRouterStage#BUSNODE_DPKEY";
        b = "VERTICAL_BUS";
        c = "HORIZONTAL_BUS";
    }
}
