package y.f.d;

import y.f.b.*;
import java.util.*;
import y.c.*;
import y.g.*;
import y.f.*;
import y.d.*;

public abstract class i extends a
{
    h g;
    private static final double[][] q;
    private byte r;
    private boolean s;
    private c t;
    private double u;
    protected X h;
    protected y.c.i i;
    protected A n;
    protected Map o;
    protected A p;
    
    public i() {
        this.r = 0;
        this.s = true;
        this.t = null;
        this.u = 0.1;
    }
    
    public byte c() {
        return this.r;
    }
    
    void c(final X h, final r[] array) {
        final int f = y.f.d.a.f;
        this.h = h;
        this.o = new HashMap();
        this.t = new c(h);
        final aH b = this.b();
        final boolean b2 = this.b;
        try {
            if (this.r != 4) {
                this.a(this.d(array));
            }
            this.b(array);
            Label_0160: {
                Label_0146: {
                    if (this.s) {
                        final k[] e = this.e(array);
                        int i = 0;
                        while (i < e.length) {
                            e[i].c();
                            e[i].b();
                            final r[] a = e[i].a();
                            this.a(a, this.a(a));
                            ++i;
                            if (f != 0) {
                                return;
                            }
                            if (f != 0) {
                                break Label_0146;
                            }
                        }
                        break Label_0160;
                    }
                }
                this.a(array, this.a(array));
            }
            this.i.j();
            this.h = null;
        }
        finally {
            this.a(b);
            this.b = b2;
            this.t.c();
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
        u.a(this.r == 0 || this.r == 4);
        u.a(x, c);
    }
    
    void b(final r[] array) {
        this.i = new y.c.i();
        this.g = this.i.u();
        this.n = this.i.t();
        this.p = this.i.t();
        this.c(array);
        this.d();
    }
    
    private k[] e(final r[] array) {
        final int i = y.f.d.a.f;
        final A t = this.i.t();
        final q[] array2 = new q[array.length];
        int j = 0;
        while (j < array.length) {
            t.a(array2[j] = this.i.d(), true);
            ++j;
            if (i != 0) {
                break;
            }
        }
        final x o = this.i.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final int d = t.d(e) ? 1 : 0;
                if (i != 0) {
                    final A a = M.a(new int[d]);
                    final int a2 = y.a.h.a(this.i, a);
                    final k[] array3 = new k[a2];
                    int k = 0;
                    while (k < a2) {
                        array3[k] = new k(this);
                        ++k;
                        if (i != 0) {
                            break;
                        }
                    }
                    final int[] array4 = new int[array.length];
                    final x o2 = this.i.o();
                    while (true) {
                        do {
                            Label_0220: {
                                o2.f();
                            }
                            int l = 0;
                            Label_0227:
                            while (l != 0) {
                                final q e2 = o2.e();
                                final int d2;
                                final int n = d2 = (t.d(e2) ? 1 : 0);
                                if (i == 0) {
                                    if (n == 0) {
                                        final int a3 = a.a(e2);
                                        array4[this.p.a(e2)] = a3;
                                        array3[a3].a(e2);
                                        final e m = e2.l();
                                        while (m.f()) {
                                            final d a4 = m.a();
                                            l = a.a(a4.d());
                                            if (i != 0) {
                                                continue Label_0227;
                                            }
                                            if (l == a3) {
                                                array3[a3].a(a4);
                                            }
                                            m.g();
                                            if (i != 0) {
                                                break;
                                            }
                                        }
                                    }
                                    o2.g();
                                    continue Label_0220;
                                }
                                int n2 = d2;
                                while (true) {
                                    while (n2 < array.length) {
                                        array3[array4[n2]].a(array[n2]);
                                        ++n2;
                                        if (i != 0) {
                                            while (n2 < array2.length) {
                                                this.i.a(array2[n2]);
                                                ++n2;
                                                if (i != 0) {
                                                    break;
                                                }
                                            }
                                            return array3;
                                        }
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                    n2 = 0;
                                    continue;
                                }
                            }
                            break;
                        } while (i == 0);
                        this.i.a(t);
                        int d2 = 0;
                        continue;
                    }
                }
                if (d == 0) {
                    this.i.a(array2[this.p.a(e)], e);
                }
                o.g();
                if (i != 0) {
                    break;
                }
            }
            this.i.f();
            continue;
        }
    }
    
    abstract y a(final r[] p0);
    
    void a(final r[] array, final y y) {
        final int f = y.f.d.a.f;
        final x a = y.a();
        while (a.f()) {
            final r r = array[this.p.a(a.e())];
            ((Q)this.n.b(a.e())).g();
            r.a(true);
            a.g();
            if (f != 0) {
                break;
            }
        }
        int i = 0;
        while (i < array.length) {
            if (!array[i].c()) {
                array[i].a();
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
    }
    
    void c(final r[] array) {
        final int f = y.f.d.a.f;
        int i = 0;
        while (i < array.length) {
            final D b = array[i].b();
            Label_0123: {
                if (b != null) {
                    final C m = b.m();
                    while (m.f()) {
                        final Q q = (Q)m.d();
                        final q d = this.i.d();
                        this.n.a(d, q);
                        this.o.put(q, d);
                        this.p.a(d, i);
                        m.g();
                        if (f != 0) {
                            break Label_0123;
                        }
                        if (f != 0) {
                            break;
                        }
                    }
                }
                ++i;
            }
            if (f != 0) {
                break;
            }
        }
    }
    
    protected void d() {
        final al al = new al();
        y.g.o.a(this, "create edges in conflict graph");
        this.d(this.h);
        y.g.o.a(this, "Time: " + al);
    }
    
    protected A e() {
        final int f = y.f.d.a.f;
        final A t = this.i.t();
        final x o = this.i.o();
        A a = null;
        while (o.f()) {
            final q e = o.e();
            final Q q = (Q)this.n.b(e);
            a = t;
            if (f != 0) {
                return a;
            }
            a.a(e, this.a(q) - q.k());
            o.g();
            if (f != 0) {
                break;
            }
        }
        return a;
    }
    
    private void d(final X x) {
        final int f = y.f.d.a.f;
        final D d = new D();
        x x2 = x.o();
        while (true) {
        Label_0217:
            while (true) {
                while (x2.f()) {
                    final q e = x2.e();
                    d.add(new j(e, x.s(e), (byte)0));
                    x2.g();
                    if (f != 0) {
                        while (x2.f()) {
                            final Q q = (Q)this.n.b(x2.e());
                            final R e2 = q.e();
                            if (f != 0) {
                                return;
                            }
                            Label_0356: {
                                if (e2 instanceof y.f.C) {
                                    d.add(new j(x.a((y.f.C)e2), q, (byte)2));
                                    if (f == 0) {
                                        break Label_0356;
                                    }
                                }
                                if (e2 instanceof aj) {
                                    d.add(new j(x.a((aj)e2), q, (byte)2));
                                    if (f == 0) {
                                        break Label_0356;
                                    }
                                }
                                d.add(new j(null, q, (byte)2));
                            }
                            x2.g();
                            if (f != 0) {
                                break;
                            }
                        }
                        y.d.f.a(d, new l(this));
                        return;
                    }
                    if (f != 0) {
                        break;
                    }
                }
                final e p = x.p();
            Label_0204_Outer:
                while (p.f()) {
                    final d a = p.a();
                    final y.c.i i = x;
                    if (f == 0) {
                        final C a2 = x.l(a).a();
                        t t = (t)a2.d();
                        a2.g();
                        while (true) {
                            while (a2.f()) {
                                final t t2 = (t)a2.d();
                                d.add(new j(a, new m(t, t2), (byte)1));
                                t = t2;
                                a2.g();
                                if (f == 0) {
                                    if (f != 0) {
                                        break;
                                    }
                                    continue Label_0204_Outer;
                                }
                                else {
                                    if (f != 0) {
                                        break Label_0217;
                                    }
                                    continue Label_0204_Outer;
                                }
                            }
                            p.g();
                            continue;
                        }
                    }
                    x2 = i.o();
                    continue Label_0217;
                }
                break;
            }
            final y.c.i i = this.i;
            continue;
        }
    }
    
    double f() {
        return y.f.d.i.q[this.r][2];
    }
    
    aH d(final r[] array) {
        final y.f.d.A a = new y.f.d.A(array, this.h);
        a.b(y.f.d.i.q[this.r][0]);
        a.d(y.f.d.i.q[this.r][1]);
        a.f(y.f.d.i.q[this.r][4]);
        a.e(y.f.d.i.q[this.r][3]);
        a.g(y.f.d.i.q[this.r][5]);
        a.c(y.f.d.i.q[this.r][6]);
        a.h(y.f.d.i.q[this.r][7]);
        if (this.b) {
            a.a(this.b());
            a.a(this.u);
        }
        return a;
    }
    
    protected void a(final Q q, final Q q2, final d d) {
        if (this.r != 4) {
            this.g.a(d, y.f.d.C.a(q.d(), q2.d()));
        }
    }
    
    protected void a(final Q q, final q q2, final y.d.y y) {
        if (this.r != 4 && (this.t == null || !this.t.d(q2)) && y.d.n.a(q.d(), y, 0.001)) {
            ((y.f.d.A)this.b()).a(q, q2, y);
        }
    }
    
    protected void a(final Q q, final d d, final m m) {
        if (this.r != 4 && y.d.n.a(q.d(), m, 0.001)) {
            ((y.f.d.A)this.b()).a(q, d, m);
        }
    }
    
    static {
        q = new double[][] { { 5.0, 1.0, 1.0, 8.0, 3.0, 5.0, 2.0, 5.0 }, { 5.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 5.0 }, { 1.0, 1.0, 1.0, 8.0, 3.0, 1.0, 1.0, 5.0 }, { 1.0, 5.0, 1.0, 1.0, 1.0, 1.0, 0.0, 5.0 } };
    }
}
