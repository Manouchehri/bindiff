package y.f.i;

import y.f.b.*;
import java.util.*;
import y.d.*;
import y.f.*;
import y.c.*;

public class n extends a
{
    boolean a;
    static final Object b;
    boolean c;
    
    public n() {
        this.a = false;
        this.c = true;
    }
    
    public n(final ah ah) {
        super(ah);
        this.a = false;
        this.c = true;
    }
    
    public void c(final X x) {
        final int f = v.f;
        final v b = this.b();
        final y.c.c c = x.c(y.f.b.f.d);
        Label_1599: {
            if (!y.f.b.c.c(x) && b != null) {
                boolean c2 = this.c;
                if (b.k() <= 0.0) {
                    c2 = false;
                }
                final h u = x.u();
                final h u2 = x.u();
                final y.c.f f2 = new y.c.f();
                final y y = new y();
                final A t = x.t();
                if (c2) {
                    x.a(n.b, t);
                }
                final c c3 = new c(x);
                final HashSet<d> set = new HashSet<d>();
                Object o = x.o();
                while (true) {
                Label_1491_Outer:
                    while (((C)o).f()) {
                        final q e = ((x)o).e();
                        final y.c.c c4 = c;
                        if (f != 0) {
                            final y.c.c c5 = c4;
                            final y.c.c c6 = x.c(b.b());
                            final byte p = b.p();
                            final o o2 = new o(this, p, c5, c6, t);
                            b.b((byte)2);
                            x.a(o, o2);
                            this.a().c(x);
                            x.a(o, new p(this, p, c5, c6, t, c));
                            final y.c.f f3 = new y.c.f(f2.a());
                            final HashSet<Object> set2 = new HashSet<Object>();
                            final y.c.f f4 = new y.c.f();
                        Label_0839_Outer:
                            while (true) {
                                f4.clear();
                                set2.clear();
                                y.c.p p2 = f3.k();
                                while (true) {
                                    while (p2 != null) {
                                        final d d = (d)p2.c();
                                        final boolean contains = set2.contains(d.c());
                                        if (f == 0) {
                                            if (!contains) {
                                                if (!set2.contains(d.d())) {
                                                    Label_0730: {
                                                        if (!x.f(d.c())) {
                                                            q q = c3.a(d.c());
                                                            while (q != null) {
                                                                set2.add(q);
                                                                q = c3.a(q);
                                                                if (f != 0) {
                                                                    break Label_0730;
                                                                }
                                                                if (f != 0) {
                                                                    break;
                                                                }
                                                            }
                                                            set2.addAll(c3.c(d.c()));
                                                        }
                                                    }
                                                    Label_0814: {
                                                        if (!x.f(d.d())) {
                                                            q q2 = c3.a(d.d());
                                                            while (q2 != null) {
                                                                set2.add(q2);
                                                                q2 = c3.a(q2);
                                                                if (f != 0) {
                                                                    break Label_0814;
                                                                }
                                                                if (f != 0) {
                                                                    break;
                                                                }
                                                            }
                                                            set2.addAll(c3.c(d.d()));
                                                        }
                                                        f4.add(d);
                                                    }
                                                    f3.h(p2);
                                                }
                                            }
                                            p2 = p2.a();
                                            if (f != 0) {
                                                break;
                                            }
                                            continue Label_0839_Outer;
                                        }
                                        else {
                                            if (contains) {
                                                break Label_0839_Outer;
                                            }
                                            e e2 = f4.a();
                                        Label_1184:
                                            while (true) {
                                                e2.f();
                                                while (true) {
                                                    while (true) {
                                                        final boolean f5;
                                                        Label_0969: {
                                                            final boolean d2;
                                                            if (d2) {
                                                                final d a = e2.a();
                                                                f5 = x.f(a.c());
                                                                if (f != 0) {
                                                                    break Label_0969;
                                                                }
                                                                if (!f5) {
                                                                    x.d(a.c());
                                                                }
                                                                if (!x.f(a.d())) {
                                                                    x.d(a.d());
                                                                }
                                                                if (!x.f(a)) {
                                                                    x.e(a);
                                                                }
                                                                e2.g();
                                                                if (f == 0) {
                                                                    break;
                                                                }
                                                            }
                                                            this.a().c(x);
                                                            e2 = f4.a();
                                                            e2.f();
                                                        }
                                                        if (!f5) {
                                                            break Label_1184;
                                                        }
                                                        final d a2 = e2.a();
                                                        final boolean d2 = c.d(a2.c());
                                                        if (f != 0) {
                                                            continue Label_0839_Outer;
                                                        }
                                                        if (d2) {
                                                            final q d3 = x.d();
                                                            x.b(d3, 5.0, 5.0);
                                                            final D m = x.m(a2);
                                                            x.a(d3, (t)m.f());
                                                            final q c7 = a2.c();
                                                            x.a(a2, d3, a2.d());
                                                            x.a(a2, m);
                                                            u.a(a2, c7);
                                                        }
                                                        if (c.d(a2.d())) {
                                                            final q d4 = x.d();
                                                            x.b(d4, 5.0, 5.0);
                                                            final D i = x.m(a2);
                                                            x.a(d4, (t)i.i());
                                                            final q d5 = a2.d();
                                                            x.a(a2, a2.c(), d4);
                                                            x.a(a2, i);
                                                            u2.a(a2, d5);
                                                        }
                                                        e2.g();
                                                        if (f != 0) {
                                                            break Label_1184;
                                                        }
                                                        continue Label_1491_Outer;
                                                    }
                                                }
                                            }
                                            final x a3 = y.a();
                                        Label_1191:
                                            while (true) {
                                                a3.f();
                                                boolean f6 = false;
                                                while (f6) {
                                                    f6 = x.f(a3.e());
                                                    if (f == 0 && f == 0) {
                                                        if (f6) {
                                                            x.c(a3.e());
                                                        }
                                                        a3.g();
                                                        continue Label_1191;
                                                    }
                                                }
                                                continue Label_0839_Outer;
                                            }
                                        }
                                    }
                                    f4.isEmpty();
                                    continue Label_1491_Outer;
                                }
                            }
                            x x2 = y.a();
                            while (true) {
                                while (x2.f()) {
                                    final boolean f7 = x.f(x2.e());
                                    if (f == 0) {
                                        if (!f7) {
                                            x.d(x2.e());
                                        }
                                        x2.g();
                                        if (f != 0) {
                                            break;
                                        }
                                        continue Label_1491_Outer;
                                    }
                                    else {
                                        y.c.c c8 = null;
                                        Label_1560: {
                                            while (true) {
                                                if (f7) {
                                                    final A a4 = (A)(c8 = t);
                                                    if (f != 0) {
                                                        break Label_1560;
                                                    }
                                                    if (a4.d(x2.e())) {
                                                        x.a(x2.e());
                                                    }
                                                    x2.g();
                                                    if (f == 0) {
                                                        x2.f();
                                                        continue Label_1491_Outer;
                                                    }
                                                }
                                                break;
                                            }
                                            b.b(p);
                                            x.d_(o);
                                            c8 = c5;
                                        }
                                        if (c8 != null) {
                                            x.a(o, c5);
                                        }
                                        x.a(u);
                                        x.a(u2);
                                        x.a(t);
                                        c3.c();
                                        if (f != 0) {
                                            break Label_1599;
                                        }
                                        return;
                                    }
                                }
                                final e a5 = f2.a();
                                while (a5.f()) {
                                    final d a6 = a5.a();
                                    q c9 = (q)u.b(a6);
                                    q c10 = null;
                                    q d6 = null;
                                    if (f != 0) {
                                        return;
                                    }
                                    Label_1380: {
                                        if (c9 == null) {
                                            c9 = a6.c();
                                            if (f == 0) {
                                                break Label_1380;
                                            }
                                        }
                                        c10 = a6.c();
                                    }
                                    q d7 = (q)u2.b(a6);
                                    Label_1418: {
                                        if (d7 == null) {
                                            d7 = a6.d();
                                            if (f == 0) {
                                                break Label_1418;
                                            }
                                        }
                                        d6 = a6.d();
                                    }
                                    final D j = x.m(a6);
                                    x.a(a6, c9, d7);
                                    x.a(a6, j);
                                    if (c10 != null) {
                                        x.a(c10);
                                    }
                                    if (d6 != null && d6 != c10) {
                                        x.a(d6);
                                    }
                                    a5.g();
                                    if (f != 0) {
                                        break;
                                    }
                                }
                                x2 = x.o();
                                continue;
                            }
                        }
                        Label_0437: {
                            if (c4.d(e)) {
                                final e k = e.j();
                                while (true) {
                                    while (k.f()) {
                                        final d a7 = k.a();
                                        final boolean add = set.add(a7);
                                        if (f != 0) {
                                            if (add) {
                                                final q d8 = x.d();
                                                final am h = x.h(e);
                                                x.b(d8, b.t(), b.t());
                                                x.a(d8, h.getX(), h.getY());
                                                final D d9 = new D();
                                                d9.add(new t(h.getX() + h.getWidth(), h.getY()));
                                                d9.add(new t(h.getX() + h.getWidth(), h.getY() + h.getHeight()));
                                                d9.add(new t(h.getX(), h.getY() + h.getHeight()));
                                                x.b(x.a(d8, d8), d9);
                                                t.a(d8, true);
                                            }
                                            x.c(e);
                                            break Label_0437;
                                        }
                                        if (add) {
                                            f2.add(a7);
                                        }
                                        k.g();
                                        if (f != 0) {
                                            break;
                                        }
                                    }
                                    y.add(e);
                                    continue;
                                }
                            }
                        }
                        ((C)o).g();
                        if (f != 0) {
                            break;
                        }
                    }
                    o = b.c();
                    x.c(o);
                    continue;
                }
            }
        }
        this.a().c(x);
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
    
    static {
        b = "GroupNodeRouterStage#GROUP_BORDER_NODE_DBKEY";
    }
}
