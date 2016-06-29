package y.f.c.a;

import y.a.*;
import y.g.*;
import y.f.c.*;
import y.f.*;
import y.c.*;
import java.util.*;
import y.d.*;

public class N extends c
{
    private aT y;
    private bx z;
    private bq A;
    private br B;
    private z C;
    private aZ D;
    private Map E;
    public static final Object n;
    public static final Object o;
    public static final Object p;
    public static final Object q;
    public static final Object r;
    public static final Object s;
    public static final Object t;
    static final Object u;
    static final Object v;
    static final Object w;
    private long F;
    public static boolean x;
    
    public N() {
        this.E = new HashMap();
        this.F = Long.MAX_VALUE;
        this.f(false);
        this.b(false);
        this.e(false);
        this.d(false);
        final ad a = this.a();
        this.c(a);
        if (a != null) {
            this.c(true);
        }
        final an an = new an();
        an.a(false);
        this.e(an);
    }
    
    protected ad a() {
        final V v = new V();
        v.b(false);
        v.c(true);
        return v;
    }
    
    protected aT n() {
        return new aW(new aj());
    }
    
    public void a(final long n) {
        this.F = Math.max(0L, n);
    }
    
    protected bx o() {
        return new r();
    }
    
    protected z p() {
        return new q();
    }
    
    protected bq q() {
        return new y();
    }
    
    protected br r() {
        return null;
    }
    
    protected aZ s() {
        return new by();
    }
    
    public void a(final aT y) {
        if (y == null) {
            throw new NullPointerException();
        }
        this.y = y;
    }
    
    public aT t() {
        if (this.y == null) {
            this.y = this.n();
        }
        return this.y;
    }
    
    public void a(final bx z) {
        if (z == null) {
            throw new NullPointerException();
        }
        this.z = z;
    }
    
    public bx u() {
        if (this.z == null) {
            this.z = this.o();
        }
        return this.z;
    }
    
    public aZ v() {
        if (this.D == null) {
            this.D = this.s();
        }
        return this.D;
    }
    
    public bq w() {
        if (this.A == null) {
            this.A = this.q();
        }
        return this.A;
    }
    
    public void a(final br b) {
        this.B = b;
    }
    
    public br x() {
        if (this.B == null) {
            this.B = this.r();
        }
        return this.B;
    }
    
    public z y() {
        if (this.C == null) {
            this.C = this.p();
        }
        return this.C;
    }
    
    public boolean b(final X x) {
        return true;
    }
    
    public Object a(final Object o) {
        return this.E.get(o);
    }
    
    public void a(final Object o, final Object o2) {
        if (o2 == null) {
            this.E.remove(o);
            if (!N.x) {
                return;
            }
        }
        this.E.put(o, o2);
    }
    
    private static f a(final l l) {
        final boolean x = N.x;
        if (g.a(l)) {
            return new f();
        }
        y.c.c c = l.c(M.n);
        if (c == null) {
            c = y.g.q.a(new Integer(1));
        }
        final h b = y.g.M.b();
        final e p = l.p();
        while (p.f()) {
            final d a = p.a();
            b.a(a, c.a(a));
            p.g();
            if (x) {
                break;
            }
        }
        final f f = new f();
        Label_0317: {
        Label_0304:
            while (true) {
                final f a2;
                (a2 = y.a.c.a(l, true)).isEmpty();
                int i = 0;
            Label_0116:
                while (i == 0) {
                    a2.size();
                    int n2 = 0;
                Label_0124:
                    while (true) {
                        int a3 = 0;
                        int n = 0;
                        if (a3 == n) {
                            final d b2 = a2.b();
                            f.add(b2);
                            l.a(b2);
                            if (!x) {
                                continue Label_0317;
                            }
                        }
                        n2 = Integer.MAX_VALUE;
                        final e a4 = a2.a();
                        while (a4.f()) {
                            final int n3 = a3 = b.a(a4.a());
                            n = n2;
                            if (x) {
                                continue Label_0124;
                            }
                            if (a3 < n) {
                                n2 = n3;
                            }
                            a4.g();
                            if (x) {
                                break;
                            }
                        }
                        break;
                    }
                    final e a5 = a2.a();
                    while (a5.f()) {
                        final d a6 = a5.a();
                        final int n4 = b.a(a6) - n2;
                        b.a(a6, n4);
                        if (x) {
                            break Label_0317;
                        }
                        i = n4;
                        if (x) {
                            continue Label_0116;
                        }
                        if (i == 0) {
                            f.add(a6);
                            l.a(a6);
                        }
                        a5.g();
                        if (x) {
                            break Label_0304;
                        }
                    }
                    continue Label_0317;
                }
                break;
            }
            f.sort(new aF(c));
        }
        final e a7 = f.a();
        while (a7.f()) {
            final d a8 = a7.a();
            l.b(a8);
            Label_0375: {
                if (!g.a(l)) {
                    l.a(a8);
                    if (!x) {
                        break Label_0375;
                    }
                }
                f.b(a7);
            }
            a7.g();
            if (x) {
                break;
            }
        }
        return f;
    }
    
    public void a(final X x) {
        final boolean x2 = N.x;
        if (x == null || x.i()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final y.c.c c = x.c(M.n);
        final f f = new f();
        X x3 = null;
        Label_0127: {
            if (c != null) {
                final l l = new l(x);
                final e a = a(l).a();
                while (a.f()) {
                    final d d = (d)l.i(a.a());
                    x3 = x;
                    if (x2) {
                        break Label_0127;
                    }
                    x.c(d);
                    f.add(d);
                    a.g();
                    if (x2) {
                        break;
                    }
                }
            }
            x3 = x;
        }
        final h u = x3.u();
        final A t = x.t();
        final ax ax = new ax(t, u);
        final aU a2 = this.a(ax);
        final y.f.c.a.C g = this.G();
        final y.c.c j = this.j(x);
        final y.c.c a3 = this.a(x, this.g(x));
        final y.c.c c2 = x.c(U.a);
        ap ap = null;
        h u2 = null;
        if (c2 != null) {
            u2 = x.u();
            ap = new ap(u2, x, U.a);
        }
        final au au = new au(x, a2, ax, g, t, u, this.f(x), this.e(x), a3, j, u2, ap);
        final aT d2 = this.D();
        this.a(x, au);
        final A t2 = x.t();
        x.a(cp.a, t2);
        final A t3 = x.t();
        x.a(cp.b, t3);
        final E a4 = this.a(x, ax, a3);
        final cd a5 = this.A();
        final bP a6 = this.a(ax, au);
        final dp e = this.E();
        final cq f2 = this.F();
        final de b = this.B();
        final dC a7 = this.a(a6, a4);
        final bx z = this.z();
        final aT t4 = this.t();
        final bx u3 = this.u();
        final aZ v = this.v();
        final z y = this.y();
        final bq w = this.w();
        if (w instanceof y) {
            ((y)w).a(a6);
            ((y)w).a(a5);
        }
        final br x4 = this.x();
        final F f3 = new F();
        f3.b(x);
        final cB a8 = this.a(f3);
        cB.a(a8, x);
        final db c3 = this.C();
        e.a(c3);
        au.a(a7);
        au.a(f2);
        au.a(a5);
        au.a(a6);
        au.a(e);
        au.a(a4);
        final boolean equals = Boolean.TRUE.equals(this.a("HierarchicLayouter.considerNodeLabelsForSelfloops"));
        final boolean equals2 = Boolean.TRUE.equals(this.a("HierarchicLayouter.considerNodeLabelsForDrawing"));
        final boolean equals3 = Boolean.TRUE.equals(this.a("HierarchicLayouter.considerNodeLabelsForRouting"));
        final boolean equals4 = Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.automaticEdgeGroupingEnabled"));
        final boolean equals5 = Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.backloopRoutingEnabled"));
        final boolean equals6 = Boolean.TRUE.equals(this.a("HierarchicLayouter.keepLayeringForGroupsWithSwimlanes"));
        final boolean equals7 = Boolean.TRUE.equals(this.a("HierarchicLayouter.stopAfterLayering"));
        final boolean equals8 = Boolean.TRUE.equals(this.a("HierarchicLayouter.stopAfterSequencing"));
        final A t5 = x.t();
        x.a(N.t, t5);
        x.a(N.w, y.g.q.a(a4));
        final bR h = this.h(x);
        x.a(N.v, y.g.q.a(h));
        try {
            final A a9 = y.g.M.a();
            Label_0790: {
                if (this.K() && this.H()) {
                    final y.f.b.c c4 = new y.f.b.c(x);
                    final x o = x.o();
                    while (true) {
                        while (o.f()) {
                            final y.c.q e2 = o.e();
                            final y.f.b.c c5 = c4;
                            if (x2) {
                                c5.c();
                                break Label_0790;
                            }
                            if (c5.d(e2)) {
                                a9.a(e2, x.r(e2));
                                x.b(e2, 1.0, 1.0);
                            }
                            o.g();
                            if (x2) {
                                break;
                            }
                        }
                        continue;
                    }
                }
            }
            a4.b();
            a5.a(x);
            final bk c6 = bk.c(x);
            this.a(t4, (this.F == Long.MAX_VALUE) ? Long.MAX_VALUE : ((long)(this.F * 0.2)));
            y.c.c c9 = null;
            Label_1201: {
                Label_1199: {
                    if (this.H()) {
                        final boolean b2 = c6 != null && a4.k();
                        I a10 = null;
                        final y.c.c c7 = x.c(bk.b);
                        final y.c.c c8 = x.c(y.f.b.f.c);
                        if (b2) {
                            a4.c();
                            final A a11 = y.g.M.a();
                            final A a12 = y.g.M.a();
                            a10 = this.a(x, c6, a11, a12);
                            x.a(bk.b, new O(this, c7, a12));
                            x.a(y.f.b.f.c, new S(this, a11, new Object(), c8));
                            a4.b();
                        }
                        new al(this, t4, d2, j, t5, false).a(x, a2, ax);
                        Label_1137: {
                            if (this.K()) {
                                a4.c();
                                final x o2 = x.o();
                                while (o2.f()) {
                                    final y.c.q e3 = o2.e();
                                    final A a13 = (A)(c9 = a9);
                                    if (x2) {
                                        break Label_1201;
                                    }
                                    if (a13.b(e3) != null) {
                                        x.a(e3, (y.d.q)a9.b(e3));
                                    }
                                    o2.g();
                                    if (x2) {
                                        break;
                                    }
                                }
                                a4.b();
                                if (!x2) {
                                    break Label_1137;
                                }
                            }
                            if (this.J()) {
                                new aD(null).a(x, a2, ax);
                            }
                        }
                        if (!b2) {
                            break Label_1199;
                        }
                        a4.c();
                        a10.f();
                        x.a(bk.b, c7);
                        x.a(y.f.b.f.c, c8);
                        a4.b();
                        if (!x2) {
                            break Label_1199;
                        }
                    }
                    this.a(x, j, t4, a2, ax, d2, t5, a4);
                }
                c9 = c;
            }
            Label_1273: {
                if (c9 != null) {
                    final e a14 = f.a();
                    while (a14.f()) {
                        x.c(a14.a());
                        a14.g();
                        if (x2) {
                            break Label_1273;
                        }
                        if (x2) {
                            break;
                        }
                    }
                }
                this.b(x, a2);
                a4.a(a2);
                c3.b(x, a2, ax);
            }
            if (!bk.d(x) && x.c(aR.a) == null && !equals6) {
                a4.f(a2);
                a4.a(a2);
            }
            Label_1509: {
                if (c6 != null) {
                    final y.c.c c10 = x.c(bk.b);
                    if (c6 != null && c10 != null) {
                        bt a15 = c6.a(0);
                        int i = 0;
                    Label_1356:
                        while (i < a2.b()) {
                            final aQ a16 = a2.a(i);
                            bt c11 = null;
                            if (x2) {
                                break Label_1509;
                            }
                            final x a17 = a16.d().a();
                            while (a17.f()) {
                                final bh bh = (bh)c10.b(a17.e());
                                if (x2) {
                                    continue Label_1356;
                                }
                                if (bh != null) {
                                    c11 = bh.c();
                                    break;
                                }
                                a17.g();
                            }
                            if (c11 == null) {
                                c11 = a15;
                            }
                            a16.a(c11);
                            a15 = c11;
                            ++i;
                            if (x2) {
                                break;
                            }
                        }
                    }
                }
                a4.c(a2, au);
                a4.a(x, ax);
            }
            if (equals5) {
                bS.a(x, a2, ax, au);
            }
            if (equals4) {
                bQ.a(x, a2, ax, au);
            }
            g.a(x, ax);
            e.a(x, a2, ax, au, u2, ap);
            a(x4, x, a2, ax, au);
            a4.a(a2);
            a7.e(x, a2, ax, au);
            a4.i(a2);
            a4.j(a2);
            a4.k(a2);
            a4.a(a2);
            a6.a(x);
            f2.a(x, a2, ax, au);
            a4.b(a2);
            a4.c(a2);
            a4.b(a2, au);
            a4.a(a2, au);
            a4.a(a2, a5);
            int a19 = 0;
            Label_1975: {
                if (!equals7) {
                    final long currentTimeMillis2 = System.currentTimeMillis();
                    final long n = this.F - (currentTimeMillis2 - currentTimeMillis);
                    final long n2 = (this.F == Long.MAX_VALUE) ? Long.MAX_VALUE : ((long)Math.max(Math.floor(n * 0.4), Math.floor(this.F * 0.3)));
                    this.a(u3, n2);
                    y.f.c.a.ah a18 = null;
                    if (j != null) {
                        a18 = this.a(x, a2, ax, j, a4);
                    }
                    u3.a(x, a2, ax, au);
                    a4.g(a2);
                    c3.a(x, a2, ax);
                    if (h != null) {
                        h.a(x, a2, ax);
                    }
                    if (a18 != null) {
                        a4.a(t5);
                        a4.e();
                        this.a(a18, t5, x, a2, ax);
                        a4.a(a2);
                        a4.c(a2);
                        a4.g(a2);
                    }
                    this.a(z, (n2 == Long.MAX_VALUE) ? Long.MAX_VALUE : Math.max(0L, n2 - System.currentTimeMillis() + currentTimeMillis2));
                    z.a(x, a2, ax, au);
                    a4.o(a2);
                    a19 = a6.a(x, a2, ax, au);
                    this.b(x4, x, a2, ax, au);
                    if (!x2) {
                        break Label_1975;
                    }
                }
                a19 = 0;
            }
            final List a20 = a8.a(x, a2, ax, au);
            a4.d(a2, au);
            a4.m(a2);
            c3.a(x, a2, ax);
            if (h != null) {
                h.a(x, a2, ax);
            }
            a6.b(x, a2, ax, au);
            if (a19 > 0) {
                a6.a(x, a2, ax, au);
            }
            a4.l(a2);
            c3.a(x, a2, ax);
            if (h != null) {
                h.a(x, a2, ax);
            }
            a4.n(a2);
            a5.a(x, ax);
            w.a(x, a2, ax, au);
            b.a(x, ax, (byte)1, equals);
            a5.a(x, a2, ax);
            v.a(x, ax, a2);
            a7.a(x, a2, ax, au);
            b.a(x, ax, (byte)2, equals2);
            if (!equals7 && !equals8) {
                y.a(x, a2, ax);
                final long n3 = this.F - (System.currentTimeMillis() - currentTimeMillis);
                this.a(v, (this.F == Long.MAX_VALUE) ? Long.MAX_VALUE : ((long)Math.max(Math.floor(n3 * 0.7), Math.floor(this.F * 0.3))));
                try {
                    v.a(x, ax, a2, y);
                }
                finally {
                    f3.c(x);
                    y.b(x, a2, ax);
                }
            }
            a7.c(x, a2, ax, au);
            if (!equals7 && !equals8) {
                b.a(x, ax, (byte)3, equals3);
                final long n4 = this.F - (System.currentTimeMillis() - currentTimeMillis);
                this.a(a7, (this.F == Long.MAX_VALUE) ? Long.MAX_VALUE : ((long)Math.max(n4, Math.floor(this.F * 0.2))));
                a7.a(x, a2, ax);
            }
            a7.b(x, a2, ax, au);
            a6.b(x);
            a7.d(x, a2, ax, au);
            a8.a(x, a2, ax, au, a20);
            a4.i();
            f2.a(x, ax);
            a4.a(x);
            a7.f(x, a2, ax, au);
            final HashSet set = new HashSet();
            e.a(x, a2, ax, set);
            a8.b(x, a2, ax);
            this.i(x);
            e.a(x, ax, set);
            g.b(x, ax);
            a4.c();
            a4.e(a2);
            a5.b(x);
            a5.b(x, a2, ax);
            a4.j();
            a4.h(a2);
            a8.a(x, a2, ax);
            this.a(x, a2);
            this.a(x, a2, ax);
        }
        finally {
            if (h != null) {
                h.a();
            }
            if (a4 != null) {
                a4.f();
            }
            if (e != null) {
                e.a(x);
            }
            cB.a((i)x);
            if (ap != null) {
                ap.b();
                x.a(u2);
            }
            x.a(u);
            x.a(t);
            x.a(t5);
            x.d_(N.t);
            x.d_(N.v);
            x.d_(N.w);
            x.d_(cp.a);
            x.a(t2);
            x.d_(cp.b);
            x.a(t3);
        }
    }
    
    private void b(final X x, final aU au) {
        final boolean x2 = N.x;
        if (bk.d(x)) {
            final y.c.c c = x.c(bk.b);
            final A a = y.g.M.a();
            final int[] array = new int[au.b()];
            int n = 0;
            int i = 0;
        Label_0041:
            while (true) {
            Label_0188_Outer:
                while (i < au.b()) {
                    final aQ a2 = au.a(i);
                    int n2 = 0;
                    int n3 = 0;
                    if (!x2) {
                        final x a3 = a2.d().a();
                        while (true) {
                            while (a3.f()) {
                                final y.c.q e = a3.e();
                                a.a(e, i);
                                final bh bh = (bh)c.b(e);
                                if (!x2) {
                                    if (bh != null) {
                                        n3 += bh.c().a();
                                        ++n2;
                                    }
                                    a3.g();
                                    if (x2) {
                                        break;
                                    }
                                    continue Label_0188_Outer;
                                }
                                else {
                                    if (x2) {
                                        break Label_0188_Outer;
                                    }
                                    continue Label_0041;
                                }
                            }
                            if (n2 > 0) {
                                n = n3 / n2;
                            }
                            array[i] = n;
                            ++i;
                            continue;
                        }
                    }
                    final y.c.q[] m = x.m();
                    final aH ah = new aH(c, a, array);
                    y.g.e.a(m, ah);
                    int n4 = 0;
                    aQ aq = au.a((byte)0, n4);
                    int j = 0;
                    while (j < m.length) {
                        final y.c.q q = m[j];
                        if (j > 0 && ah.compare(m[j - 1], q) != 0) {
                            ++n4;
                            aq = au.a((byte)0, n4);
                        }
                        aq.a(q);
                        ++j;
                        if (x2) {
                            break;
                        }
                    }
                    return;
                }
                while (au.b() > 0) {
                    au.b(0);
                    if (x2) {
                        return;
                    }
                    if (x2) {
                        break;
                    }
                }
                continue;
            }
        }
    }
    
    private void a(final dC dc, final long n) {
        if (dc instanceof bY) {
            ((bY)dc).a(n);
        }
    }
    
    private void a(final aT at, final long n) {
        Object o = at;
        if (o instanceof aW) {
            o = ((aW)o).a();
        }
        if (o instanceof ba) {
            o = ((ba)o).a();
        }
        if (o instanceof aj) {
            ((aj)o).a(n);
        }
    }
    
    private void a(final bx bx, final long n) {
        if (bx instanceof r) {
            ((r)bx).a(n);
            if (!N.x) {
                return;
            }
        }
        if (bx instanceof bT) {
            ((bT)bx).a(n);
        }
    }
    
    private void a(final aZ az, final long n) {
        if (az instanceof by) {
            ((by)az).a(n);
        }
    }
    
    private void a(final X x, final y.c.c c, final aT at, final aU au, final aV av, final aT at2, final A a, final E e) {
        final boolean x2 = N.x;
        final f f = new f();
        final f f2 = new f();
        final h b = y.g.M.b();
        if (this.I() && e != null && e.k()) {
            e.c();
            this.a(x, f2, e, null);
            this.a(x, f, f2, e, null, b);
            e.b();
        }
        final y.f.c.a.ah a2 = this.a(x, c, e, b);
        final A a3 = y.g.M.a();
        Label_0300: {
            Label_0276: {
                Label_0246: {
                    if (at instanceof m) {
                        while (true) {
                            for (final y.c.q q : a2.a) {
                                x.d(q);
                                a3.a(q, true);
                                if (x2) {
                                    for (final y.c.q q2 : a2.a) {
                                        a3.a(q2, false);
                                        x.c(q2);
                                        if (x2) {
                                            break Label_0300;
                                        }
                                        if (x2) {
                                            break Label_0246;
                                        }
                                    }
                                    break Label_0276;
                                }
                                if (x2) {
                                    break;
                                }
                            }
                            ((m)at).a(a3);
                            at.a(x, au, av);
                            continue;
                        }
                    }
                }
                x.a("AspectRatioComponentLayerer.GROUPING_SUPPORT", y.g.q.a(e));
                at.a(x, au, av);
                x.d_("AspectRatioComponentLayerer.GROUPING_SUPPORT");
            }
            this.b(x, au);
            this.a(at2, x, au, av, a2, a, a3);
        }
        if (this.I() && e != null && e.k()) {
            e.c();
            this.a(x, f, f2);
            e.b();
        }
    }
    
    private void a(final X x, final f f, final f f2) {
        final boolean x2 = N.x;
        e e = f.a();
        while (true) {
            while (e.f()) {
                x.a(e.a());
                e.g();
                if (x2) {
                    while (e.f()) {
                        x.e(e.a());
                        e.g();
                        if (x2) {
                            break;
                        }
                    }
                    return;
                }
                if (x2) {
                    break;
                }
            }
            e = f2.a();
            continue;
        }
    }
    
    private void a(final X x, final f f, final f f2, final E e, final y.c.q q, final h h) {
        final boolean x2 = N.x;
        Label_0364: {
            if (q != null) {
                final y.c.y g = e.g(q);
                final e a = new f(q.k()).a();
                while (a.f()) {
                    final d a2 = a.a();
                    final y.c.q c = a2.c();
                    if (x2) {
                        break Label_0364;
                    }
                    if (c != q) {
                        Label_0176: {
                            Label_0169: {
                                Label_0156: {
                                    if (e.d(c)) {
                                        final x a3 = e.g(c).a();
                                        while (a3.f()) {
                                            this.a(g, x, a3.e(), f, h, true);
                                            a3.g();
                                            if (x2) {
                                                break Label_0176;
                                            }
                                            if (x2) {
                                                break Label_0156;
                                            }
                                        }
                                        break Label_0169;
                                    }
                                }
                                this.a(g, x, c, f, h, true);
                            }
                            f2.add(a2);
                        }
                        x.d(a2);
                    }
                    a.g();
                    if (x2) {
                        break;
                    }
                }
                final e a4 = new f(q.l()).a();
                while (a4.f()) {
                    final d a5 = a4.a();
                    final y.c.q d = a5.d();
                    if (d != q) {
                        Label_0346: {
                            Label_0339: {
                                Label_0326: {
                                    if (e.d(d)) {
                                        final x a6 = e.g(d).a();
                                        while (a6.f()) {
                                            this.a(g, x, a6.e(), f, h, false);
                                            a6.g();
                                            if (x2) {
                                                break Label_0346;
                                            }
                                            if (x2) {
                                                break Label_0326;
                                            }
                                        }
                                        break Label_0339;
                                    }
                                }
                                this.a(g, x, d, f, h, false);
                            }
                            f2.add(a5);
                        }
                        x.d(a5);
                    }
                    a4.g();
                    if (x2) {
                        break;
                    }
                }
            }
        }
        final x a7 = e.h(q).a();
        while (a7.f()) {
            final y.c.q e2 = a7.e();
            if (e.d(e2)) {
                this.a(x, f, f2, e, e2, h);
            }
            a7.g();
            if (x2) {
                break;
            }
        }
    }
    
    private void a(final X x, final f f, final E e, final y.c.q q) {
        final boolean x2 = N.x;
        Label_0253: {
            if (q != null) {
                final Set a = this.a(e, q);
                a.add(q);
                f f2 = new f();
                d d = q.g();
                while (true) {
                Label_0162:
                    while (true) {
                        while (d != null) {
                            final boolean contains = a.contains(d.c());
                            if (x2) {
                                while (true) {
                                    if (contains) {
                                        f2.add(d);
                                    }
                                    d = d.g();
                                    if (!x2) {
                                        if (d != null) {
                                            a.contains(d.d());
                                            continue;
                                        }
                                    }
                                    break;
                                }
                                final e a2 = f2.a();
                                while (a2.f()) {
                                    final d a3 = a2.a();
                                    f.add(a3);
                                    x.d(a3);
                                    a2.g();
                                    if (x2) {
                                        break;
                                    }
                                }
                                break Label_0253;
                            }
                            if (contains) {
                                f2.add(d);
                            }
                            d = d.h();
                            if (x2) {
                                break;
                            }
                        }
                        final e a4 = f2.a();
                        while (a4.f()) {
                            final d a5 = a4.a();
                            f.add(a5);
                            x.d(a5);
                            a4.g();
                            if (x2) {
                                d = q.f();
                                continue Label_0162;
                            }
                            if (x2) {
                                break;
                            }
                        }
                        break;
                    }
                    f2 = new f();
                    continue;
                }
            }
        }
        final x a6 = e.h(q).a();
        while (a6.f()) {
            final y.c.q e2 = a6.e();
            if (e.d(e2)) {
                this.a(x, f, e, e2);
            }
            a6.g();
            if (x2) {
                break;
            }
        }
    }
    
    private Set a(final E e, final y.c.q q) {
        if (!e.k()) {
            return null;
        }
        final HashSet set = new HashSet();
        e.a(q, new T(this, q, set));
        return set;
    }
    
    private void a(final y.c.y y, final X x, final y.c.q q, final f f, final h h, final boolean b) {
        final boolean x2 = N.x;
        final x a = y.a();
        while (a.f()) {
            final y.c.q e = a.e();
            if (e != q) {
                d d = null;
                Label_0067: {
                    if (b) {
                        d = x.a(q, e);
                        if (!x2) {
                            break Label_0067;
                        }
                    }
                    d = x.a(e, q);
                }
                f.add(d);
                h.a(d, true);
            }
            a.g();
            if (x2) {
                break;
            }
        }
    }
    
    private y.c.c j(final X x) {
        final y.c.c d = this.d(x);
        if (d != null) {
            return new az(d, null);
        }
        return null;
    }
    
    protected y.c.c d(final X x) {
        return x.c(N.n);
    }
    
    protected y.c.c e(final X x) {
        return x.c(N.o);
    }
    
    protected y.c.c f(final X x) {
        return x.c(N.p);
    }
    
    protected y.c.c g(final X x) {
        return x.c(N.q);
    }
    
    private y.c.c a(final X x, final y.c.c c) {
        final boolean x2 = N.x;
        if (c == null) {
            return null;
        }
        final y.c.c c2 = x.c(y.f.b.f.b);
        final y.c.c c3 = x.c(y.f.b.f.c);
        final y.c.c c4 = x.c(y.f.b.f.d);
        if (c2 != null && c3 != null && c4 != null) {
            final aB ab = new aB(x, c, c4, null);
            ab.a(x, c2, c3);
            final x a = ab.a();
            while (a.f()) {
                ab.b(a.e(), ab.a(a.e()));
                a.g();
                if (x2) {
                    return aB.a(ab);
                }
                if (x2) {
                    break;
                }
            }
            ab.a(x);
            return aB.a(ab);
        }
        return c;
    }
    
    protected void a(final X x, final aP ap) {
        final boolean x2 = N.x;
        final y.f.b.c c = new y.f.b.c(x);
        final y.c.c c2 = x.c(y.f.b.f.d);
        x.a(y.f.b.f.d, new y.f.c.a.U(this, c));
        try {
            final x o = x.o();
        Label_0122_Outer:
            while (o.f()) {
                final y.c.q e = o.e();
                ap.c(e);
                d d = e.f();
                while (true) {
                    while (d != null) {
                        ap.a(d);
                        d = d.g();
                        if (!x2) {
                            if (x2) {
                                break;
                            }
                            continue Label_0122_Outer;
                        }
                        else {
                            if (x2) {
                                break Label_0122_Outer;
                            }
                            continue Label_0122_Outer;
                        }
                    }
                    o.g();
                    continue;
                }
            }
        }
        finally {
            Label_0193: {
                if (c2 != null) {
                    x.a(y.f.b.f.d, c2);
                    if (!x2) {
                        break Label_0193;
                    }
                }
                x.d_(y.f.b.f.d);
            }
            c.c();
        }
    }
    
    protected bx z() {
        final bT bt = new bT();
        bt.a(this.E);
        return bt;
    }
    
    protected aU a(final aV av) {
        return new ac(av);
    }
    
    cd A() {
        return new cd();
    }
    
    bP a(final aV av, final aP ap) {
        final bP bp = new bP(av, ap);
        bp.a(this.E);
        return bp;
    }
    
    E a(final X x, final aV av, final y.c.c c) {
        final E e = new E(x, av, c);
        final Object a = this.a("GroupingSupport.minimumGroupDistance");
        if (a instanceof Number) {
            e.a(((Number)a).doubleValue());
        }
        return e;
    }
    
    de B() {
        return new de();
    }
    
    cB a(final F f) {
        return new cB(f);
    }
    
    db C() {
        return new db();
    }
    
    bR h(final X x) {
        if (x.c(bw.a) == null) {
            return null;
        }
        return new dt(Boolean.TRUE.equals(this.a("HierarchicLayouter.keepInterGroupConstraints")));
    }
    
    dC a(final bP bp, final E e) {
        final bY by = new bY(bp, e);
        by.a(this.E);
        return by;
    }
    
    protected aT D() {
        return new m(new af());
    }
    
    dp E() {
        return new dp();
    }
    
    cq F() {
        return new cq();
    }
    
    protected y.f.c.a.C G() {
        return new ay();
    }
    
    private static void a(final br br, final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        if (br != null) {
            br.optimizeAfterLayering(x, au, av, ap);
        }
        final aE a = aE.a((byte)2, true);
        final aE a2 = aE.a((byte)1, true);
        final aE a3 = aE.a((byte)2, false);
        final aE a4 = aE.a((byte)1, false);
        final e p5 = x.p();
        while (p5.f()) {
            final d a5 = p5.a();
            final y.f.c.a.A a6 = av.a(a5);
            final aX a7 = av.a(a5.c());
            final aX a8 = av.a(a5.d());
            final int n = a8.j() - a7.j();
            Label_0430: {
                if (n != 0) {
                    final B k = a6.k();
                    Label_0285: {
                        if (a7.b() == 0 && !a(a5.c()) && (a6.d() == null || br == null) && (k == null || !k.f()) && (a6.c() == null || a6.c().g())) {
                            if (a6.c() != null && a6.c().a()) {
                                ap.a(a5, true, (n > 0) ? a : a2);
                                if (!x2) {
                                    break Label_0285;
                                }
                            }
                            ap.a(a5, true, (n > 0) ? a3 : a4);
                        }
                    }
                    if (a8.b() == 0 && (a6.f() == null || br == null) && !a(a5.d()) && (k == null || !k.g()) && (a6.e() == null || a6.e().g())) {
                        if (a6.e() != null && a6.e().a()) {
                            ap.a(a5, false, (n > 0) ? a2 : a);
                            if (!x2) {
                                break Label_0430;
                            }
                        }
                        ap.a(a5, false, (n > 0) ? a4 : a3);
                    }
                }
            }
            p5.g();
            if (x2) {
                break;
            }
        }
    }
    
    private static boolean a(final y.c.q q) {
        final y.c.c c = q.e().c(y.f.ay.a);
        return c != null && c.b(q) != null;
    }
    
    private void b(final br br, final X x, final aU au, final aV av, final aP ap) {
        if (br != null) {
            br.optimizeAfterSequencing(x, au, av, ap);
        }
    }
    
    private y.f.c.a.ah a(final X x, final aU au, final aV av, final y.c.c c, final E e) {
        final boolean x2 = N.x;
        final y.f.c.a.ah ah = new y.f.c.a.ah();
        final A t = x.t();
        int n = 0;
        while (true) {
        Label_0612:
            while (true) {
            Label_0647:
                while (true) {
                    do {
                        int i = 0;
                        Label_0023: {
                            i = n;
                        }
                        Label_0025:
                        while (i < au.b()) {
                            y.c.y y = au.a(n).d();
                            final p k = y.k();
                            if (!x2) {
                                p a = k;
                                while (a != null) {
                                    final y.c.q q = (y.c.q)a.c();
                                    final aX a2 = av.a(q);
                                    final byte b = (byte)(i = a2.b());
                                    if (x2) {
                                        continue Label_0025;
                                    }
                                    if (b == 0 && (a2.c().a() == 0 || a2.c().a() == 1)) {
                                        t.a(q, true);
                                    }
                                    a = a.a();
                                    if (x2) {
                                        break;
                                    }
                                }
                                ++n;
                                continue Label_0023;
                            }
                            p a3 = k;
                            Label_0824: {
                            Label_0614:
                                while (true) {
                                    while (a3 != null) {
                                        final y.c.q q2 = (y.c.q)a3.c();
                                        final int d = t.d(q2) ? 1 : 0;
                                        if (x2) {
                                            break Label_0614;
                                        }
                                        Label_0804: {
                                            if (d != 0) {
                                                d d2 = q2.g();
                                                while (true) {
                                                    while (d2 != null) {
                                                        x.d(d2);
                                                        ah.d.add(d2);
                                                        d2 = d2.h();
                                                        if (x2) {
                                                            while (true) {
                                                                while (d2 != null) {
                                                                    x.d(d2);
                                                                    ah.d.add(d2);
                                                                    d2 = d2.g();
                                                                    if (x2) {
                                                                        ah.b.add(q2);
                                                                        break Label_0804;
                                                                    }
                                                                    if (x2) {
                                                                        break;
                                                                    }
                                                                }
                                                                x.c(q2);
                                                                y.h(a3);
                                                                continue;
                                                            }
                                                        }
                                                        if (x2) {
                                                            break;
                                                        }
                                                    }
                                                    d2 = q2.f();
                                                    continue;
                                                }
                                            }
                                        }
                                        a3 = a3.a();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    Label_0816: {
                                        break Label_0816;
                                        final int d;
                                        if (d < au.b()) {
                                            y = au.a(n).d();
                                            y.k();
                                            continue Label_0647;
                                        }
                                        break Label_0824;
                                    }
                                    ++n;
                                    if (!x2) {
                                        continue Label_0614;
                                    }
                                    break;
                                }
                            }
                            final e p5 = x.p();
                            while (p5.f()) {
                                final d a4 = p5.a();
                                if (x2) {
                                    return ah;
                                }
                                if (c.b(a4) != null) {
                                    x.d(a4);
                                    ah.d.add(a4);
                                }
                                p5.g();
                                if (x2) {
                                    break;
                                }
                            }
                            e.c(au);
                            x.a(t);
                            return ah;
                        }
                        break;
                    } while (!x2);
                    n = 0;
                    do {
                        int j = 0;
                    Label_0167:
                        while (j < au.b()) {
                            final y.c.y y = au.a(n).d();
                            final p l = y.k();
                            if (x2) {
                                continue Label_0647;
                            }
                            p a5 = l;
                            while (a5 != null) {
                                final y.c.q q3 = (y.c.q)a5.c();
                                j = (b(q3, av.a(q3), av, c, t) ? 1 : 0);
                                if (x2) {
                                    continue Label_0167;
                                }
                                if (j != 0) {
                                    t.a(q3, true);
                                }
                                a5 = a5.a();
                                if (x2) {
                                    break;
                                }
                            }
                            ++n;
                        }
                        break;
                    } while (!x2);
                    n = 0;
                    do {
                        int a6 = 0;
                    Label_0283:
                        while (a6 < au.b()) {
                            final y.c.y y = au.a(n).d();
                            final p m = y.k();
                            if (x2) {
                                continue Label_0647;
                            }
                            p a7 = m;
                            while (a7 != null) {
                                final y.c.q q4 = (y.c.q)a7.c();
                                a6 = (a(q4, av.a(q4), av, c, t) ? 1 : 0);
                                if (x2) {
                                    continue Label_0283;
                                }
                                if (a6 != 0) {
                                    t.a(q4, true);
                                }
                                a7 = a7.a();
                                if (x2) {
                                    break;
                                }
                            }
                            ++n;
                        }
                        break;
                    } while (!x2);
                    n = 0;
                    do {
                        int c2 = 0;
                    Label_0399:
                        while (c2 < au.b()) {
                            final y.c.y y = au.a(n).d();
                            final p k2 = y.k();
                            if (x2) {
                                continue Label_0647;
                            }
                            p a8 = k2;
                            while (a8 != null) {
                                final y.c.q q5 = (y.c.q)a8.c();
                                c2 = (c(q5, av.a(q5), av, c, t) ? 1 : 0);
                                if (x2) {
                                    continue Label_0399;
                                }
                                if (c2 != 0) {
                                    t.a(q5, true);
                                }
                                a8 = a8.a();
                                if (x2) {
                                    break;
                                }
                            }
                            ++n;
                        }
                        break;
                    } while (!x2);
                    break;
                }
                e.b(au, t);
                final e p6 = x.p();
                while (p6.f()) {
                    final d a9 = p6.a();
                    final int d3 = t.d(a9.c()) ? 1 : 0;
                    if (x2) {
                        n = d3;
                        continue Label_0612;
                    }
                    if (d3 != 0 || t.d(a9.d())) {
                        x.d(a9);
                        ah.d.add(a9);
                    }
                    p6.g();
                    if (x2) {
                        break;
                    }
                }
                break;
            }
            continue;
        }
    }
    
    private static final boolean a(final y.c.q q, final aX ax, final aV av, final y.c.c c, final A a) {
        final boolean x = N.x;
        if (ax.b() == 6) {
            if (a.d(q)) {
                return true;
            }
            d d = q.g();
            boolean d2 = false;
            while (d != null) {
                boolean b = d2 = a.d(d.c());
                if (x) {
                    return d2;
                }
                if (!d2) {
                    final d b2 = av.a(d).b();
                    b = (a.d(b2.d()) || a(b2.c(), av.a(b2.c()), av, c, a));
                    if (!b) {
                        b = (c.b(b2) != null);
                    }
                }
                if ((b || x) && !x) {
                    break;
                }
                d = d.h();
                if (x) {
                    break;
                }
            }
            return d2;
        }
        else {
            if (ax.b() != 7) {
                return false;
            }
            if (a.d(q)) {
                return true;
            }
            d d3 = q.f();
            boolean d4 = false;
            while (d3 != null) {
                boolean b3 = d4 = a.d(d3.d());
                if (x) {
                    return d4;
                }
                if (!d4) {
                    final d b4 = av.a(d3).b();
                    b3 = (a.d(b4.c()) || a(b4.d(), av.a(b4.d()), av, c, a));
                    if (!b3) {
                        b3 = (c.b(b4) != null);
                    }
                }
                if ((b3 || x) && !x) {
                    break;
                }
                d3 = d3.g();
                if (x) {
                    break;
                }
            }
            return d4;
        }
    }
    
    private static final boolean b(final y.c.q q, final aX ax, final aV av, final y.c.c c, final A a) {
        if (ax.b() == 8) {
            boolean b = a.d(ax.f()) || a.d(ax.g().c()) || a.d(ax.g().d());
            if (!b) {
                final d g = ax.g();
                b = (c.b(g) != null);
                if (!b) {
                    final y.f.c.a.A a2 = av.a(g);
                    if (a2 != null && a2.b() != null) {
                        b = (c.b(a2.b()) != null);
                    }
                }
            }
            return b;
        }
        if (ax.b() == 9) {
            boolean b2 = a.d(ax.f()) || a.d(ax.g().c()) || a.d(ax.g().d());
            if (!b2) {
                final d g2 = ax.g();
                b2 = (c.b(g2) != null);
                if (!b2) {
                    final y.f.c.a.A a3 = av.a(g2);
                    if (a3 != null && a3.b() != null) {
                        b2 = (c.b(a3.b()) != null);
                    }
                }
            }
            return b2;
        }
        return false;
    }
    
    private static final boolean c(final y.c.q q, final aX ax, final aV av, final y.c.c c, final A a) {
        final boolean x = N.x;
        boolean b = false;
        Label_0412: {
            switch (ax.b()) {
                default: {
                    return false;
                }
                case 8: {
                    b = a.d(ax.f());
                    if (b) {
                        break;
                    }
                    b = (c.b(ax.g()) != null);
                    if (b) {
                        break;
                    }
                    b = a.d(((d)ax.d().c()).c());
                    if (x) {
                        break Label_0412;
                    }
                    break;
                }
                case 9: {
                    b = a.d(ax.f());
                    if (b) {
                        break;
                    }
                    b = (c.b(ax.g()) != null);
                    if (b) {
                        break;
                    }
                    b = a.d(((d)ax.d().c()).d());
                    if (x) {
                        break Label_0412;
                    }
                    break;
                }
                case 10: {
                    if (c.b(ax.g()) != null) {
                        return true;
                    }
                    final p d = ax.d();
                    final d d2 = (d)d.c();
                    b = (c.b(d2) != null);
                    if (b) {
                        break;
                    }
                    b = a.d(d2.a(q));
                    if (b) {
                        break;
                    }
                    final d d3 = (d)d.a().c();
                    b = (c.b(d3) != null);
                    if (b) {
                        break;
                    }
                    b = a.d(d3.a(q));
                    if (x) {
                        break Label_0412;
                    }
                    break;
                }
                case 1: {
                    final d g = ax.g();
                    b = (c.b(g) != null);
                    if (!b) {
                        b = (a.d(g.c()) || a.d(g.d()));
                        break;
                    }
                    break;
                }
            }
        }
        return b;
    }
    
    private void a(final y.f.c.a.ah ah, final a a, final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        int i = 0;
        while (true) {
            while (i < ah.b.size()) {
                final y.c.q q = ah.b.get(i);
                final int f;
                final int n = f = (x.f(q) ? 1 : 0);
                if (x2) {
                    int j = f;
                    while (j < ah.d.size()) {
                        final d d = ah.d.get(j);
                        x.e(d);
                        x.b((Object)d).clearPoints();
                        ++j;
                        if (x2) {
                            break;
                        }
                    }
                    return;
                }
                if (n == 0) {
                    x.d(q);
                    au.a(av.a(q).j()).a(q);
                    a.a(q, true);
                }
                ++i;
                if (x2) {
                    break;
                }
            }
            int f = 0;
            continue;
        }
    }
    
    protected void a(final X x, final aU au) {
        final boolean x2 = N.x;
        final y.c.c c = x.c(N.r);
        if (c != null) {
            final int n = (c instanceof a) ? 1 : 0;
            int n2 = 0;
            int n3 = 0;
            do {
                int i = 0;
            Label_0031:
                while (i < au.b()) {
                    final aQ a = au.a(n3);
                    if (a.e() != 2) {
                        if (a.e() != 3) {
                            p p2 = a.d().k();
                            while (p2 != null) {
                                final y.c.q q = (y.c.q)p2.c();
                                i = n;
                                if (x2) {
                                    continue Label_0031;
                                }
                                Label_0160: {
                                    if (i != 0) {
                                        ((a)c).a(q, n2);
                                        if (!x2) {
                                            break Label_0160;
                                        }
                                    }
                                    final Object b = c.b(q);
                                    if (b instanceof aO) {
                                        ((aO)b).a(n2);
                                    }
                                }
                                p2 = p2.a();
                                if (x2) {
                                    break;
                                }
                            }
                            ++n2;
                        }
                    }
                    ++n3;
                }
                break;
            } while (!x2);
        }
    }
    
    protected void a(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final y.c.c c = x.c(N.s);
        if (c != null) {
            final boolean b = c instanceof a;
            int n = 0;
            do {
                int i = 0;
                Label_0029: {
                    i = n;
                }
                Label_0031:
                while (i < au.b()) {
                    final aQ a = au.a(n);
                    if (a.e() != 2) {
                        if (a.e() != 3) {
                            int n2 = 0;
                            p p3 = a.d().k();
                            while (p3 != null) {
                                final y.c.q q = (y.c.q)p3.c();
                                final byte b2 = (byte)(i = av.a(q).b());
                                if (x2) {
                                    continue Label_0031;
                                }
                                Label_0191: {
                                    if (b2 == 0) {
                                        if (b) {
                                            ((a)c).a(q, n2);
                                            ++n2;
                                            if (!x2) {
                                                break Label_0191;
                                            }
                                        }
                                        final Object b3 = c.b(q);
                                        if (b3 instanceof aO) {
                                            ((aO)b3).a(n2);
                                            ++n2;
                                        }
                                    }
                                }
                                p3 = p3.a();
                                if (x2) {
                                    break;
                                }
                            }
                        }
                    }
                    ++n;
                    continue Label_0029;
                }
                break;
            } while (!x2);
        }
    }
    
    private y.f.c.a.ah a(final X x, final y.c.c c, final E e, final y.c.c c2) {
        final boolean x2 = N.x;
        final y.f.c.a.ah ah = new y.f.c.a.ah();
        if (c != null) {
            final x o = x.o();
            while (o.f()) {
                final y.c.q e2 = o.e();
                if (x2) {
                    return ah;
                }
                Label_0130: {
                    if (e == null || !e.d(e2)) {
                        final Z z = (Z)c.b(e2);
                        if (z != null) {
                            if (z.g == 0) {
                                ah.a.add(e2);
                                if (!x2) {
                                    break Label_0130;
                                }
                            }
                            if (z.g == 1) {
                                ah.b.add(e2);
                            }
                        }
                    }
                }
                o.g();
                if (x2) {
                    break;
                }
            }
            int i = 0;
        Label_0384:
            while (true) {
            Label_0253_Outer:
                while (i < ah.a.size()) {
                    final y.c.q q = ah.a.get(i);
                    final e j = q.j();
                    if (!x2) {
                        final e e3 = j;
                        while (true) {
                            while (e3.f()) {
                                final d a = e3.a();
                                ah.c.add(a);
                                x.d(a);
                                e3.g();
                                if (!x2) {
                                    if (x2) {
                                        break;
                                    }
                                    continue Label_0253_Outer;
                                }
                                else {
                                    if (x2) {
                                        break Label_0253_Outer;
                                    }
                                    continue Label_0384;
                                }
                            }
                            x.c(q);
                            ++i;
                            continue;
                        }
                    }
                    final e e4 = j;
                    while (e4.f()) {
                        final d a2 = e4.a();
                        final Z z2 = (Z)c.b(a2);
                        Label_0490: {
                            if (!c2.d(a2)) {
                                if (z2 != null) {
                                    if (z2.g == 1) {
                                        ah.d.add(a2);
                                        x.d(a2);
                                        if (!x2) {
                                            break Label_0490;
                                        }
                                    }
                                    ah.c.add(a2);
                                    x.d(a2);
                                }
                            }
                        }
                        e4.g();
                        if (x2) {
                            break;
                        }
                    }
                    return ah;
                }
                int n = 0;
                do {
                    int k = 0;
                Label_0263:
                    while (k < ah.b.size()) {
                        final e l = ah.b.get(n).j();
                        if (x2) {
                            continue Label_0384;
                        }
                        final e e5 = l;
                        while (e5.f()) {
                            final d a3 = e5.a();
                            k = (c2.d(a3) ? 1 : 0);
                            if (x2) {
                                continue Label_0263;
                            }
                            if (k == 0) {
                                ah.d.add(a3);
                                x.d(a3);
                            }
                            e5.g();
                            if (x2) {
                                break;
                            }
                        }
                        ++n;
                    }
                    break;
                } while (!x2);
                x.p();
                continue Label_0384;
            }
        }
        return ah;
    }
    
    private y.f.c.a.ah b(final X x, final y.c.c c) {
        final boolean x2 = N.x;
        final y.f.c.a.ah ah = new y.f.c.a.ah();
        if (c != null) {
            final x o = x.o();
            while (o.f()) {
                final y.c.q e = o.e();
                final Z z = (Z)c.b(e);
                if (x2) {
                    return ah;
                }
                if (z != null && z.g == 0) {
                    ah.a.add(e);
                }
                o.g();
                if (x2) {
                    break;
                }
            }
            int i = 0;
        Label_0100:
            while (true) {
            Label_0205_Outer:
                while (i < ah.a.size()) {
                    final y.c.q q = ah.a.get(i);
                    final e j = q.j();
                    if (!x2) {
                        final e e2 = j;
                        while (true) {
                            while (e2.f()) {
                                final d a = e2.a();
                                ah.c.add(a);
                                x.d(a);
                                e2.g();
                                if (!x2) {
                                    if (x2) {
                                        break;
                                    }
                                    continue Label_0205_Outer;
                                }
                                else {
                                    if (x2) {
                                        break Label_0205_Outer;
                                    }
                                    continue Label_0100;
                                }
                            }
                            x.c(q);
                            ++i;
                            continue;
                        }
                    }
                    final e e3 = j;
                    while (e3.f()) {
                        final d a2 = e3.a();
                        final Z z2 = (Z)c.b(a2);
                        if (z2 != null && z2.g != 1) {
                            ah.c.add(a2);
                            x.d(a2);
                        }
                        e3.g();
                        if (x2) {
                            break;
                        }
                    }
                    return ah;
                }
                x.p();
                continue;
            }
        }
        return ah;
    }
    
    private void a(final aT at, final X x, final aU au, final aV av, final y.f.c.a.ah ah, final a a, final A a2) {
        final boolean x2 = N.x;
        for (final y.c.q q : ah.a) {
            x.d(q);
            a.a(q, true);
            if (x2) {
                break;
            }
        }
        int i = 0;
    Label_0203:
        while (true) {
            while (i < ah.c.size()) {
                final d d2;
                final d d = d2 = ah.c.get(i);
                if (x2) {
                    Label_0283: {
                        while (true) {
                            final d d3 = d2;
                            if (!x.f(d3.c()) || !x.f(d3.d())) {
                                break Label_0283;
                            }
                            x.e(d3);
                            ah.d.remove(i);
                            if (x2) {
                                break Label_0283;
                            }
                            if (i < ah.d.size()) {
                                final d d4 = ah.d.get(i);
                                continue;
                            }
                            break;
                        }
                        return;
                    }
                    ++i;
                    if (!x2) {
                        continue Label_0203;
                    }
                    return;
                }
                if (d2 != null && x.f(d.c()) && x.f(d.d())) {
                    x.e(d);
                    ah.c.remove(i);
                    if (!x2) {
                        continue;
                    }
                }
                ++i;
                if (x2) {
                    break;
                }
            }
            if (ah.a.size() > 0) {
                if (at instanceof m) {
                    ((m)at).a(a2);
                }
                at.a(x, au, av);
            }
            i = 0;
            continue Label_0203;
        }
    }
    
    private void a(final aT at, final X x, final aU au, final aV av, final y.f.c.a.ah ah, final a a, final y.f.b.c c, final y.c.q q) {
        final boolean x2 = N.x;
        for (final y.c.q q2 : ah.a) {
            if (c.a(q2) == q) {
                x.d(q2);
                a.a(q2, true);
                if (x2) {
                    break;
                }
                continue;
            }
        }
        int i = 0;
    Label_0199:
        while (true) {
            while (i < ah.c.size()) {
                final d d2;
                final d d = d2 = ah.c.get(i);
                if (x2) {
                    Label_0279: {
                        while (true) {
                            final d d3 = d2;
                            if (!x.f(d3.c()) || !x.f(d3.d())) {
                                break Label_0279;
                            }
                            x.e(d3);
                            ah.d.remove(i);
                            if (x2) {
                                break Label_0279;
                            }
                            if (i < ah.d.size()) {
                                final d d4 = ah.d.get(i);
                                continue;
                            }
                            break;
                        }
                        return;
                    }
                    ++i;
                    if (!x2) {
                        continue Label_0199;
                    }
                    return;
                }
                if (d2 != null && x.f(d.c()) && x.f(d.d())) {
                    x.e(d);
                    ah.c.remove(i);
                    if (!x2) {
                        continue;
                    }
                }
                ++i;
                if (x2) {
                    break;
                }
            }
            if (ah.a.size() > 0) {
                at.a(x, au, av);
            }
            i = 0;
            continue Label_0199;
        }
    }
    
    protected void i(final X x) {
        final boolean x2 = N.x;
        final e p = x.p();
        while (p.f()) {
            final d a = p.a();
            final y.f.I g = x.g(a);
            Label_0365: {
                if (g.pointCount() > 0) {
                    final ArrayList list = new ArrayList<t>(g.pointCount());
                    final C a2 = x.l(a).a();
                    final t t = (t)a2.d();
                    a2.g();
                    double a3 = t.a();
                    double b = t.b();
                    double n = 0.0;
                    Label_0282: {
                        if (a2.f()) {
                            t t2 = (t)a2.d();
                            double a4 = t2.a();
                            double b2 = t2.b();
                            a2.g();
                            while (a2.f()) {
                                final t t3 = (t)a2.d();
                                final double a5 = t3.a();
                                final double b3 = t3.b();
                                n = dcmpl(Math.abs((a3 - a5) * (b2 - b3) / (b - b3) + a5 - a4), 0.5);
                                if (x2) {
                                    break Label_0282;
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
                                if (x2) {
                                    break;
                                }
                            }
                        }
                        list.size();
                    }
                    if (n < g.pointCount()) {
                        g.clearPoints();
                        int i = 0;
                        while (i < list.size()) {
                            final t t4 = list.get(i);
                            g.addPoint(t4.a, t4.b);
                            ++i;
                            if (x2) {
                                break Label_0365;
                            }
                            if (x2) {
                                break;
                            }
                        }
                    }
                }
                p.g();
            }
            if (x2) {
                break;
            }
        }
    }
    
    private boolean H() {
        return Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.enabled"));
    }
    
    private boolean I() {
        return Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.considerGroupNodeEdges"));
    }
    
    private boolean J() {
        return Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.compactionEnabled"));
    }
    
    private boolean K() {
        return Boolean.TRUE.equals(this.a("y.layout.hierarchic.incremental.HierarchicLayouter.useAspectRatioLayerer"));
    }
    
    private byte L() {
        return ((Number)this.a("y.layout.hierarchic.incremental.HierarchicLayouter.RecursiveGroupLayerer.alignment")).byteValue();
    }
    
    private I a(final X x, final bk bk, final A a, final A a2) {
        final boolean x2 = N.x;
        final I i = new I(x);
        if (bk != null && y.f.b.c.b(x)) {
            final y.f.b.c c = new y.f.b.c(x);
            final y.c.c c2 = x.c(bk.b);
            if (c2 != null) {
                final A a3 = y.g.M.a();
                x x3 = x.o();
                while (true) {
                    while (x3.f()) {
                        final y.c.q e = x3.e();
                        final boolean d = c.d(e);
                        if (!x2) {
                            Label_0315: {
                                Label_0308: {
                                    if (d) {
                                        bh bh = null;
                                        final y.c.y c3 = c.c(e);
                                        final x a4 = c3.a();
                                        while (true) {
                                            while (a4.f()) {
                                                final y.c.q e2 = a4.e();
                                                final boolean d2 = a3.d(e2);
                                                if (x2) {
                                                    Label_0297: {
                                                        if (d2) {
                                                            final x a5 = c3.a();
                                                            while (a5.f()) {
                                                                a.a(a5.e(), true);
                                                                a5.g();
                                                                if (x2) {
                                                                    break Label_0315;
                                                                }
                                                                if (x2) {
                                                                    break Label_0297;
                                                                }
                                                            }
                                                            break Label_0308;
                                                        }
                                                    }
                                                    a2.a(e, bh);
                                                    break Label_0308;
                                                }
                                                if (d2) {
                                                    a3.a(e, true);
                                                    if (!x2) {
                                                        break;
                                                    }
                                                }
                                                final bh bh2 = (bh)c2.b(e2);
                                                if (bh2 != null) {
                                                    if (bh == null) {
                                                        bh = bh2;
                                                    }
                                                    if (bh.c() != bh2.c()) {
                                                        a3.a(e, true);
                                                        if (!x2) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                a4.g();
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                            a3.d(e);
                                            continue;
                                        }
                                    }
                                }
                                x3.g();
                            }
                            if (x2) {
                                break;
                            }
                            continue;
                        }
                        else {
                            while (true) {
                                if (!d) {
                                    return i;
                                }
                                final y.c.q e3 = x3.e();
                                if (a3.d(e3)) {
                                    i.a(e3);
                                }
                                x3.g();
                                if (x2) {
                                    return i;
                                }
                                x3.f();
                                continue;
                            }
                        }
                    }
                    x3 = x.o();
                    continue;
                }
            }
        }
        return i;
    }
    
    static void a(final N n, final X x, final y.c.c c, final aT at, final aU au, final aV av, final aT at2, final A a, final E e) {
        n.a(x, c, at, au, av, at2, a, e);
    }
    
    static byte a(final N n) {
        return n.L();
    }
    
    static y.f.c.a.ah a(final N n, final X x, final y.c.c c) {
        return n.b(x, c);
    }
    
    static void a(final N n, final X x, final aU au) {
        n.b(x, au);
    }
    
    static void a(final N n, final aT at, final X x, final aU au, final aV av, final y.f.c.a.ah ah, final a a, final y.f.b.c c, final y.c.q q) {
        n.a(at, x, au, av, ah, a, c, q);
    }
    
    static void a(final N n, final aT at, final X x, final aU au, final aV av, final y.f.c.a.ah ah, final a a, final A a2) {
        n.a(at, x, au, av, ah, a, a2);
    }
    
    static {
        n = "y.layout.hierarchic.incremental.HierarchicLayouter.INCREMENTAL_HINTS_DPKEY";
        o = "y.layout.hierarchic.incremental.HierarchicLayouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY";
        p = "y.layout.hierarchic.incremental.HierarchicLayouter.NODE_LAYOUT_DESCRIPTOR_DPKEY";
        q = "y.layout.hierarchic.incremental.HierarchicLayouter.SWIMLANE_DESCRIPTOR_DPKEY";
        r = "y.layout.hierarchic.incremental.HierarchicLayouter.LAYER_VALUE_HOLDER_DPKEY";
        s = "y.layout.hierarchic.incremental.HierarchicLayouter.SEQUENCE_VALUE_HOLDER_DPKEY";
        t = "y.layout.hierarchic.incremental.HierarchicLayouter.INCREMENTAL_NODES_DPKEY";
        u = "y.layout.hierarchic.incremental.HierarchicLayouter.NODE_PORT_SIZE_DPKEY";
        v = "y.layout.hierarchic.incremental.HierarchicLayouter.constraintSupport_DPKEY";
        w = "groupingSupport";
    }
}
