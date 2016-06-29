package y.f.d;

import y.f.b.*;
import y.g.*;
import java.util.*;
import y.c.*;
import y.d.*;
import y.f.*;

public abstract class a extends y.f.a
{
    public static final Object a;
    private aH g;
    private boolean h;
    private boolean i;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private Object t;
    protected boolean b;
    c c;
    D d;
    boolean e;
    private boolean u;
    private static final n[] v;
    private static final am w;
    public static int f;
    
    protected a() {
        this.g = null;
        this.h = false;
        this.i = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = true;
        this.s = false;
        this.t = null;
        this.b = false;
        this.e = false;
        this.u = false;
        this.g = new W();
    }
    
    public aH b() {
        return this.g;
    }
    
    public void c(final X x) {
        if (this.a() != null) {
            this.a().c(x);
        }
        this.b(x);
    }
    
    private void d(final X x) {
        this.a((y.c.n)x, x);
    }
    
    private void a(final y.c.n n, final O o) {
        final int f = y.f.d.a.f;
        y.c.c c = n.c(y.f.b.f.d);
        if (c == null) {
            c = y.g.q.a(Boolean.FALSE);
        }
        final Iterator x = n.x();
        while (x.hasNext()) {
            final Object next = x.next();
            if (!c.d(next)) {
                this.a(o, next);
                if (f == 0) {
                    continue;
                }
            }
            this.b(o, next);
            if (f != 0) {
                break;
            }
        }
    }
    
    protected void a(final O o, final Object o2) {
        final am a = o.a(o2);
        if (a.getWidth() == 0.0 || a.getHeight() == 0.0) {
            throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        }
    }
    
    protected void b(final O o, final Object o2) {
        final am a = o.a(o2);
        if (a.getWidth() == 0.0 || a.getHeight() == 0.0) {
            throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        }
    }
    
    public void b(final X x) {
        this.a(x, this.t);
    }
    
    public void a(final X x, final Object o) {
        this.a(x, x.c(o));
    }
    
    private void a(final X x, final y.c.c c) {
        if (x.c("y.layout.labeling.ABSTRACT_LABELING_ALGORITHM_NODE_SIZE_CHECKED_DPKEY") == null) {
            this.d(x);
        }
        try {
            if (x.c(y.f.b.f.d) != null) {
                this.c = new c(x);
            }
            final r[] b = this.b(x, c);
            this.c(x, b);
            this.a(b);
            if (this.o) {
                this.a(x, c, b.length);
            }
        }
        finally {
            if (this.c != null) {
                this.c.c();
                this.c = null;
            }
        }
    }
    
    void a(final X x, final y.c.c c, final int n) {
        final int f = y.f.d.a.f;
        final u u = new u();
        final int n2 = x.f() + x.h() + n;
        Label_0077: {
            if (n2 > 5000) {
                u.c(20.0);
                if (f == 0) {
                    break Label_0077;
                }
            }
            if (n2 > 1000) {
                u.c(10.0);
                if (f == 0) {
                    break Label_0077;
                }
            }
            u.c(5.0);
        }
        u.b(35.0);
        u.a(5.0);
        u.b(true);
        u.c(true);
        u.a(false);
        u.a(x, c);
    }
    
    private static boolean a(final y y, final aj aj) {
        return n.a(new n(y), aj.getOrientedBox(), 0.001) && !a(aj.a());
    }
    
    private static boolean a(final al al) {
        final int f = y.f.d.a.f;
        if (al instanceof M) {
            return true;
        }
        int i = 0;
        boolean a = false;
        while (i < y.f.d.a.v.length) {
            a = n.a(y.f.d.a.v[i], al.a(y.f.d.a.v[i].d(), y.f.d.a.w, al.a(y.f.d.a.v[i], y.f.d.a.w)), 1.0);
            if (f != 0) {
                return a;
            }
            if (!a) {
                return false;
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
        return a;
    }
    
    private r[] b(final X x, final y.c.c c) {
        final int i = y.f.d.a.f;
        final y.c.c c2 = x.c(y.f.d.a.a);
        final r[] array = new r[e(x)];
        int n = 0;
        final x o = x.o();
        while (true) {
            do {
                Label_0031: {
                    o.f();
                }
                boolean q = false;
                Label_0038:
                while (q) {
                    final y.c.q e = o.e();
                    final y s = x.s(e);
                    final X x2 = x;
                    if (i == 0) {
                        final aj[] j = x.i(e);
                        int k = 0;
                        while (k < j.length) {
                            array[n] = new t(n, j[k]);
                            q = this.q;
                            if (i != 0) {
                                continue Label_0038;
                            }
                            final boolean b = !q || (!this.p && a(s, j[k])) || (c != null && !c.d(j[k]));
                            array[n].a(b);
                            array[n].a(y.f.d.s.a(x, e, j[k], (c2 == null) ? null : ((al)c2.b(j[k])), b));
                            ++k;
                            ++n;
                            if (i != 0) {
                                break;
                            }
                        }
                        o.g();
                        continue Label_0031;
                    }
                    final e p2 = x2.p();
                    do {
                        Label_0248:
                        p2.f();
                        boolean r = false;
                        Label_0255:
                        while (r) {
                            final d a = p2.a();
                            final C[] h = x.h(a);
                            if (i == 0) {
                                int l = 0;
                                while (l < h.length) {
                                    array[n] = new y.f.d.q(n, h[l]);
                                    r = this.r;
                                    if (i != 0) {
                                        continue Label_0255;
                                    }
                                    final boolean b2 = !r || (c != null && !c.d(h[l]));
                                    array[n].a(b2);
                                    array[n].a(y.f.d.n.a(x, a, h[l], (c2 == null) ? null : ((E)c2.b(h[l])), b2, this.s, this.u));
                                    ++l;
                                    ++n;
                                    if (i != 0) {
                                        break;
                                    }
                                }
                                p2.g();
                                continue Label_0248;
                            }
                            return array;
                        }
                        break;
                    } while (i == 0);
                    this.a(x, array);
                    this.b(x, array);
                    return array;
                }
                break;
            } while (i == 0);
            final X x2 = x;
            continue;
        }
    }
    
    void a(final X x, final r[] array) {
        final int i = y.f.d.a.f;
        final D d = new D();
        final x o = x.o();
        while (true) {
        Label_0155_Outer:
            while (o.f()) {
                final int add = d.add(new y.f.d.c(x.s(o.e()), o.e())) ? 1 : 0;
                if (i != 0) {
                    int j = add;
                Label_0079:
                    while (true) {
                    Label_0149_Outer:
                        while (j < array.length) {
                            final D b = array[j].b();
                            if (i == 0) {
                                final y.c.C m = b.m();
                                while (true) {
                                    while (m.f()) {
                                        d.add(m.d());
                                        m.g();
                                        if (i == 0) {
                                            if (i != 0) {
                                                break;
                                            }
                                            continue Label_0149_Outer;
                                        }
                                        else {
                                            if (i != 0) {
                                                break Label_0149_Outer;
                                            }
                                            continue Label_0079;
                                        }
                                    }
                                    ++j;
                                    continue Label_0155_Outer;
                                }
                            }
                            y.d.f.a(b, new y.f.d.d(x, this.c));
                            if (this.i) {
                                int n = 0;
                                do {
                                    double n2 = 0.0;
                                    Label_0180: {
                                        n2 = n;
                                    }
                                    Label_0182:
                                    while (n2 < array.length) {
                                        final D b2 = array[n].b();
                                        p p2 = b2.k();
                                        while (p2 != null) {
                                            final double n3 = n2 = dcmpl(((Q)p2.c()).i(), 0.0);
                                            if (i != 0) {
                                                continue Label_0182;
                                            }
                                            if (n3 > 0) {
                                                b2.h(p2);
                                            }
                                            p2 = p2.a();
                                            if (i != 0) {
                                                break;
                                            }
                                        }
                                        ++n;
                                        continue Label_0180;
                                    }
                                    break;
                                } while (i == 0);
                            }
                            return;
                        }
                        continue;
                    }
                }
                o.g();
                if (i != 0) {
                    break;
                }
            }
            final int add = 0;
            continue;
        }
    }
    
    void b(final X x, final r[] array) {
        final int f = y.f.d.a.f;
        final D d = new D();
        int i = 0;
    Label_0016:
        while (true) {
        Label_0227:
            while (true) {
                D b;
                D d2;
                y.c.C m;
                p p2;
                double n2;
                double n;
                D b2;
                Label_0086_Outer:Label_0245_Outer:Label_0229_Outer:
                while (i < array.length) {
                    d2 = (b = array[i].b());
                    if (f == 0) {
                        m = b.m();
                        while (true) {
                            while (m.f()) {
                                d.add(m.d());
                                m.g();
                                if (f == 0) {
                                    if (f != 0) {
                                        break;
                                    }
                                    continue Label_0086_Outer;
                                }
                                else {
                                    if (f != 0) {
                                        break Label_0086_Outer;
                                    }
                                    continue Label_0016;
                                }
                            }
                            ++i;
                            continue Label_0245_Outer;
                        }
                    }
                Label_0229:
                    while (true) {
                        Label_0300: {
                            while (true) {
                                p2 = b.k();
                                while (p2 != null) {
                                    n = (n2 = dcmpl(((Q)p2.c()).j(), 0.0));
                                    if (f != 0) {
                                        break Label_0229;
                                    }
                                    if (n > 0) {
                                        d2.h(p2);
                                    }
                                    p2 = p2.a();
                                    if (f != 0) {
                                        break;
                                    }
                                }
                                break Label_0300;
                                if (n2 < array.length) {
                                    d2 = (b2 = array[i].b());
                                    continue Label_0229_Outer;
                                }
                                break;
                            }
                            return;
                        }
                        ++i;
                        if (f == 0) {
                            n2 = i;
                            continue Label_0229;
                        }
                        break;
                    }
                    return;
                }
                final e p3 = x.p();
            Label_0196_Outer:
                while (p3.f()) {
                    final v c = ae.c(x, p3.a());
                    if (f == 0) {
                        final y.d.s j = c.j();
                        while (true) {
                            while (j.f()) {
                                d.add(new y.f.d.e(j.a(), p3.a()));
                                j.g();
                                if (f == 0) {
                                    if (f != 0) {
                                        break;
                                    }
                                    continue Label_0196_Outer;
                                }
                                else {
                                    if (f != 0) {
                                        break Label_0227;
                                    }
                                    continue Label_0196_Outer;
                                }
                            }
                            p3.g();
                            continue;
                        }
                    }
                    if (this.h) {
                        i = 0;
                        continue Label_0227;
                    }
                    return;
                }
                break;
            }
            y.d.f.a(d, new b(x, this.n));
            continue;
        }
    }
    
    private static int e(final X x) {
        final int f = y.f.d.a.f;
        int n = 0;
        final x o = x.o();
        while (o.f()) {
            n += x.i(o.e()).length;
            o.g();
            if (f != 0) {
                break;
            }
        }
        final e p = x.p();
        int n2 = 0;
        while (p.f()) {
            n2 = n + x.h(p.a()).length;
            if (f != 0) {
                return n2;
            }
            n = n2;
            p.g();
            if (f != 0) {
                break;
            }
        }
        return n2;
    }
    
    public void a(final aH g) {
        this.g = g;
        if (g == null) {
            this.b = false;
            if (y.f.d.a.f == 0) {
                return;
            }
        }
        this.b = true;
    }
    
    public double a(final Q q) {
        if (this.g != null) {
            return this.g.a(q);
        }
        final Object l = q.l();
        if (l instanceof aO) {
            final double n = 1.0 - Math.abs((0.5 - ((aP)l).e()) * 2.0);
            if (y.f.d.a.f == 0) {
                return n;
            }
        }
        return 1.0;
    }
    
    abstract void c(final X p0, final r[] p1);
    
    private void a(final r[] array) {
        final int f = y.f.d.a.f;
        if (!this.e) {
            return;
        }
        Label_0043: {
            if (this.d == null) {
                this.d = new D();
                if (f == 0) {
                    break Label_0043;
                }
            }
            this.d.clear();
        }
        int i = 0;
    Label_0109_Outer:
        while (i < array.length) {
            final y.c.C m = array[i].b().m();
            while (true) {
                while (m.f()) {
                    this.d.add(m.d());
                    m.g();
                    if (f == 0) {
                        if (f != 0) {
                            break;
                        }
                        continue Label_0109_Outer;
                    }
                    else {
                        if (f != 0) {
                            break Label_0109_Outer;
                        }
                        continue Label_0109_Outer;
                    }
                }
                ++i;
                continue;
            }
        }
    }
    
    static {
        a = "y.layout.labeling.AbstractLabelingAlgorithm.LABEL_MODEL_DPKEY";
        v = new n[] { new n(15.0, 5.0, 30.0, 10.0, 1.0, 0.0), new n(-15.0, -15.0, 100.0, 30.0, 0.5, 0.5), new n(50.0, 90.0, 40.0, 15.0, 0.0, -1.0) };
        w = new y.f.x(0.0, 0.0, 30.0, 30.0);
    }
}
