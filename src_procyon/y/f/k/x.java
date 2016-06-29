package y.f.k;

import y.f.b.*;
import y.g.*;
import y.d.*;
import y.a.*;
import java.util.*;
import y.f.*;
import y.c.*;

public class x extends c
{
    public static final Object n;
    public static final Object o;
    public static final Object p;
    static final Object q;
    private A s;
    private A t;
    private double u;
    private y.c.c v;
    private y.c.c w;
    private ap x;
    private ap y;
    private ap z;
    private ap A;
    private ap B;
    protected X r;
    private I C;
    private I D;
    private J E;
    private Comparator F;
    private boolean G;
    private boolean H;
    private boolean I;
    private A J;
    private A K;
    private y.f.b.c L;
    private h M;
    private final F N;
    
    public x() {
        this.u = 2.0;
        this.D = new H();
        this.I = true;
        this.v = new y(this);
        this.w = new z(this);
        this.F = null;
        this.E = new v();
        this.C = new t();
        this.d(!this.n());
        final an an = new an();
        an.a(false);
        this.e(an);
        this.N = new F();
    }
    
    F a() {
        return this.N;
    }
    
    public boolean n() {
        return this.I;
    }
    
    protected boolean b(final X x) {
        return a(x, this.n());
    }
    
    static boolean a(final X x, final boolean b) {
        final int g = d.g;
        if (x == null) {
            return false;
        }
        y.g.I i = null;
        boolean d = false;
        Label_0201: {
            Label_0197: {
                if (b && y.f.b.c.b(x)) {
                    i = new y.g.I(x);
                    final y.c.c c = x.c(f.c);
                    final HashSet set = new HashSet<Object>();
                    final y.c.x o = x.o();
                    while (o.f()) {
                        set.add(c.b(o.e()));
                        o.g();
                        if (g != 0) {
                            break Label_0197;
                        }
                        if (g != 0) {
                            break;
                        }
                    }
                    final y.c.c c2 = x.c(f.b);
                    final y.c.c c3 = x.c(f.d);
                    final y.c.x o2 = x.o();
                    while (o2.f()) {
                        final q e = o2.e();
                        d = c3.d(e);
                        if (g != 0) {
                            break Label_0201;
                        }
                        if (d && set.contains(c2.b(e))) {
                            i.a(e);
                        }
                        o2.g();
                        if (g != 0) {
                            break;
                        }
                    }
                }
            }
            y.a.A.b(x);
        }
        final boolean b2 = d;
        if (i != null) {
            i.f();
        }
        return b2;
    }
    
    private y.c.y a(final y.f.b.c c) {
        final int g = d.g;
        final y.c.y y = new y.c.y();
        final y.c.y b = c.b(c.b());
        while (!b.isEmpty()) {
            final q d = b.d();
            if (c.e(d)) {
                y.add(d);
                b.addAll(c.b(d));
                if (g != 0) {
                    return y;
                }
                if (g != 0) {
                    break;
                }
                continue;
            }
        }
        y.n();
        return y;
    }
    
    protected void a(final X r) {
        final int g = d.g;
        if (!this.b(r)) {
            throw new B("Graph is not a tree");
        }
        final boolean b = y.f.b.c.b(r) && this.I;
        this.L = null;
        y.c.y a = null;
        y.g.I i = null;
        if (b) {
            this.L = new y.f.b.c(r);
            a = this.a(this.L);
            i = new y.g.I(r);
            i.a(a);
        }
        if (b && r.i() && !a.isEmpty()) {
            i.f();
            this.L.c();
            this.L = null;
            return;
        }
        this.r = r;
        this.s = r.t();
        this.t = r.t();
        try {
            this.x = ap.b(r, y.f.k.x.n);
            this.y = ap.b(r, y.f.k.x.o);
            this.z = ap.b(r, y.f.k.x.p);
            this.A = ap.a(r, aF.a);
            this.B = ap.a(r, aF.b);
            final y.c.f o = this.o();
            this.a(o);
            this.M = r.u();
            r.a(y.f.k.x.q, this.M);
            final e a2 = o.a();
            while (a2.f()) {
                this.M.a(a2.a(), Boolean.TRUE);
                a2.g();
                if (g != 0) {
                    break;
                }
            }
            try {
                final q d = y.a.A.d(r);
                List a6 = null;
                Label_0484: {
                    if (b) {
                        final A a3 = this.a(r, d);
                        this.J = r.t();
                        this.K = r.t();
                        final y.c.x a4 = a.a();
                        while (a4.f()) {
                            final q e = a4.e();
                            final y.c.y a5 = this.a(e, this.L);
                            final y.c.y y = (y.c.y)(a6 = a5);
                            if (g != 0) {
                                break Label_0484;
                            }
                            Label_0465: {
                                if (!y.isEmpty()) {
                                    final q a7 = a(d, a5, a3);
                                    this.K.a(e, a7);
                                    if (this.J.b(a7) == null) {
                                        this.J.a(a7, new y.c.y(e));
                                        if (g == 0) {
                                            break Label_0465;
                                        }
                                    }
                                    ((y.c.y)this.J.b(a7)).add(e);
                                }
                            }
                            a4.g();
                            if (g != 0) {
                                break;
                            }
                        }
                    }
                    a6 = this.a(d, r);
                }
                final List list = a6;
                if (b && !a.isEmpty() && r.c(y.f.k.B.h) != null) {
                    this.a(a);
                }
                this.h(d);
                this.a(r, list);
            }
            finally {
                this.a(o);
                new aI().c(r);
            }
        }
        finally {
            if (b) {
                i.f();
                final j j = new j();
                j.a(false);
                j.c(r);
                r.a(this.J);
                r.a(this.K);
                this.L.c();
                this.L = null;
            }
            this.y.e();
            this.y = null;
            this.x.e();
            this.x = null;
            this.A.e();
            this.A = null;
            this.B.e();
            this.B = null;
            this.z.e();
            this.z = null;
            if (this.M != null) {
                r.d_(y.f.k.x.q);
                r.a(this.M);
                this.M = null;
            }
            this.r.a(this.t);
            this.r.a(this.s);
            this.t = null;
            this.s = null;
            this.r = null;
        }
    }
    
    private void a(final y.c.y y) {
        final int g = d.g;
        final y.c.c c = this.r.c(y.f.k.B.h);
        final y.c.c c2 = this.r.c(y.f.b.f.e);
        if (c != null && c2 != null) {
            final A a = y.g.M.a(new double[this.r.f()]);
            final A a2 = y.g.M.a(new double[this.r.f()]);
            y.c.x x = y.a();
            while (true) {
            Label_0482_Outer:
                while (x.f()) {
                    q q = x.e();
                    final r a3 = y.d.r.a(c2.b(q));
                    Object b;
                    final r r = (r)(b = a3);
                    while (true) {
                        y.f.k.F f2 = null;
                        Label_0485: {
                            if (g == 0) {
                                Label_0441: {
                                    Label_0434: {
                                        if (r != null) {
                                            int c3 = Integer.MAX_VALUE;
                                            int c4 = Integer.MIN_VALUE;
                                            final y.c.y y2 = new y.c.y();
                                            final y.c.y y3 = new y.c.y();
                                            final y.c.x a4 = this.a(q, this.L).a();
                                            while (a4.f()) {
                                                final q e = a4.e();
                                                final y.f.k.F f = f2 = (y.f.k.F)c.b(e);
                                                if (g != 0) {
                                                    break Label_0485;
                                                }
                                                if (f2 != null) {
                                                    if (f.c() >= c4) {
                                                        if (f.c() > c4) {
                                                            c4 = f.c();
                                                            y3.clear();
                                                        }
                                                        y3.add(e);
                                                    }
                                                    if (f.c() <= c3) {
                                                        if (f.c() < c3) {
                                                            c3 = f.c();
                                                            y2.clear();
                                                        }
                                                        y2.add(e);
                                                    }
                                                }
                                                a4.g();
                                                if (g != 0) {
                                                    break;
                                                }
                                            }
                                            y.c.x x2 = y2.a();
                                            while (true) {
                                                while (x2.f()) {
                                                    final q e2 = x2.e();
                                                    a.a(e2, a.c(e2) + a3.a);
                                                    x2.g();
                                                    if (g != 0) {
                                                        while (x2.f()) {
                                                            final q e3 = x2.e();
                                                            a2.a(e3, a2.c(e3) + a3.c);
                                                            x2.g();
                                                            if (g != 0) {
                                                                break Label_0441;
                                                            }
                                                            if (g != 0) {
                                                                break;
                                                            }
                                                        }
                                                        break Label_0434;
                                                    }
                                                    if (g != 0) {
                                                        break;
                                                    }
                                                }
                                                x2 = y3.a();
                                                continue Label_0482_Outer;
                                            }
                                        }
                                    }
                                    x.g();
                                }
                                if (g != 0) {
                                    break;
                                }
                                continue Label_0482_Outer;
                            }
                            final y.f.k.F f3 = (y.f.k.F)b;
                        }
                        final y.f.k.F f4 = f2;
                        if (f4 != null) {
                            I i = this.e(q);
                            if (i instanceof O) {
                                i = ((O)i).a();
                            }
                            if (i instanceof y.f.k.B) {
                                f4.a(q, this, ((y.f.k.B)i).a(), a.c(q), a2.c(q));
                            }
                        }
                        x.g();
                        if (g != 0) {
                            return;
                        }
                        if (x.f()) {
                            q = x.e();
                            b = c.b(q);
                            continue;
                        }
                        break;
                    }
                    return;
                }
                x = this.r.o();
                continue;
            }
        }
    }
    
    private A a(final i i, final q q) {
        final int g = d.g;
        final A a = y.g.M.a(new int[i.f()]);
        final y.c.y[] a2 = b.a(i, new y.c.y(q));
        int j = 0;
    Label_0095_Outer:
        while (j < a2.length) {
            final y.c.x a3 = a2[j].a();
            while (true) {
                while (a3.f()) {
                    a.a(a3.e(), j);
                    a3.g();
                    if (g == 0) {
                        if (g != 0) {
                            break;
                        }
                        continue Label_0095_Outer;
                    }
                    else {
                        if (g != 0) {
                            break Label_0095_Outer;
                        }
                        continue Label_0095_Outer;
                    }
                }
                ++j;
                continue;
            }
        }
        return a;
    }
    
    private static q a(final q q, final q q2, final A a) {
        final int g = d.g;
        if (q == q2) {
            return q;
        }
        q q3 = q;
        q c = q2;
        while (true) {
            q c2 = null;
            while (a.a(q3) < a.a(c)) {
                c = c.g().c();
                if (g != 0) {
                    while (q3 != c) {
                        q3 = q3.g().c();
                        c2 = c.g().c();
                        if (g != 0) {
                            break;
                        }
                        c = c2;
                        if (g != 0) {
                            break;
                        }
                    }
                    return c2;
                }
                if (g != 0) {
                    break;
                }
            }
            while (a.a(q3) > a.a(c)) {
                q3 = q3.g().c();
                if (g != 0) {
                    return c2;
                }
                if (g != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    private static q a(final q q, final y.c.y y, final A a) {
        final int g = d.g;
        q b = y.b();
        final y.c.x a2 = y.a();
        q a3 = null;
        while (a2.f()) {
            b = (a3 = a(b, a2.e(), a));
            if (g != 0) {
                return a3;
            }
            if (a3 == q) {
                return q;
            }
            a2.g();
            if (g != 0) {
                break;
            }
        }
        return a3;
    }
    
    private y.c.y a(final q q, final y.f.b.c c) {
        final int g = d.g;
        final y.c.y c2 = c.c(q);
        final y.c.y y = new y.c.y();
        final y.c.x a = c2.a();
        while (a.f()) {
            final q e = a.e();
            if (!c.d(e)) {
                y.add(e);
            }
            a.g();
            if (g != 0) {
                break;
            }
        }
        return y;
    }
    
    private void h(final q q) {
        final int g = d.g;
        final q[] g2 = this.g(q);
        int i = g2.length - 1;
        while (true) {
            while (i >= 0) {
                final q q2 = g2[i];
                final int c = q2.c();
                if (g != 0) {
                    int j = c;
                    while (true) {
                        while (j < g2.length) {
                            final q q3 = g2[j];
                            this.i(q3);
                            this.s.a(q3, this.b(q3));
                            this.j(q3);
                            ++j;
                            if (g != 0) {
                                while (j >= 0) {
                                    double a = 0.0;
                                    double b = 0.0;
                                    final q q4 = g2[j];
                                    if (q4 != q) {
                                        final y.f.k.A a2 = this.a(q4.g().c());
                                        a = a2.a;
                                        b = a2.b;
                                    }
                                    final y.f.k.A a4;
                                    final y.f.k.A a3 = a4 = this.a(q4);
                                    a4.a += a;
                                    final y.f.k.A a5 = a3;
                                    a5.b += b;
                                    this.a(q4, a, b);
                                    --j;
                                    if (g != 0) {
                                        break;
                                    }
                                }
                                return;
                            }
                            if (g != 0) {
                                break;
                            }
                        }
                        j = g2.length - 1;
                        continue;
                    }
                }
                if (c > 0) {
                    final Comparator d = this.d(q2);
                    if (d != null) {
                        q2.b(d);
                    }
                    this.e(q2).a(q2, this.t);
                }
                --i;
                if (g != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    private List a(final q q, final X x) {
        final int g = d.g;
        final D d = new D();
        final D d2 = new D();
        d2.add(q);
        D d4 = null;
    Label_0149:
        while (!d2.isEmpty()) {
            final q q2 = (q)d2.j();
            final K a = this.e(q2).a(this, x, q2);
            if (a != null) {
                a.a(this.x.a(), this.y.a(), this.z.a());
                d.a(a);
            }
            y.c.d d3 = q2.f();
            Label_0150: {
                while (d3 != null) {
                    d4 = d2;
                    if (g != 0) {
                        break Label_0150;
                    }
                    d4.add(d3.d());
                    d3 = d3.g();
                    if (g != 0 || g != 0) {
                        break Label_0149;
                    }
                }
                continue;
            }
            return d4;
        }
        return d4;
    }
    
    private void a(final X x, final List list) {
        final int g = d.g;
        this.d(x);
        for (final K k : list) {
            if (k != null) {
                k.a();
                if (g != 0) {
                    break;
                }
                continue;
            }
        }
    }
    
    private void d(final X x) {
        final int g = d.g;
        if (!this.H) {
            return;
        }
        final y.c.c c = x.c(U.a);
        if (c == null) {
            return;
        }
        final e p = x.p();
        while (p.f()) {
            final y.c.d a = p.a();
            final am a2 = x.a((Object)a.d());
            final S[] array = (S[])c.b(a);
            Label_0166: {
                if (array != null) {
                    int i = 0;
                    while (i < array.length) {
                        final S s = array[i];
                        s.a(s.d() + a2.getX(), s.e() + a2.getY());
                        this.N.a(x, s);
                        ++i;
                        if (g != 0) {
                            break Label_0166;
                        }
                        if (g != 0) {
                            break;
                        }
                    }
                }
                p.g();
            }
            if (g != 0) {
                break;
            }
        }
    }
    
    private void i(final q q) {
        final int g = d.g;
        y.c.d d = q.f();
        while (d != null) {
            final y.f.k.A a = this.a(d.d());
            a.a = a.i();
            a.b = a.j();
            d = d.g();
            if (g != 0) {
                break;
            }
        }
    }
    
    private void j(final q q) {
        final int g = d.g;
        y.c.d d = q.f();
        while (d != null) {
            final y.f.k.A a = this.a(d.d());
            a.a = a.i() - a.a;
            a.b = a.j() - a.b;
            d = d.g();
            if (g != 0) {
                break;
            }
        }
    }
    
    protected y.f.k.A a(final q q) {
        return (y.f.k.A)this.s.b(q);
    }
    
    private void a(final q q, final double n, final double n2) {
        final int g = d.g;
        final y.f.k.A a = this.a(q);
        a.b(n, n2);
        y.c.d d = q.f();
    Label_0119_Outer:
        while (d != null) {
            final y.f.I b = this.r.b((Object)d);
            int i = 0;
            while (true) {
                while (i < b.pointCount()) {
                    final y.d.t point = b.getPoint(i);
                    b.setPoint(i, point.a + a.a, point.b + a.b);
                    ++i;
                    if (g == 0) {
                        if (g != 0) {
                            break;
                        }
                        continue Label_0119_Outer;
                    }
                    else {
                        if (g != 0) {
                            break Label_0119_Outer;
                        }
                        continue Label_0119_Outer;
                    }
                }
                d = d.g();
                continue;
            }
        }
    }
    
    protected y.f.k.A b(final q q) {
        final J c = this.c(q);
        final I e = this.e(q);
        c.a(this.r, q);
        final y.f.k.A a = e.a(this.v, this.w, this.r, q, (byte)this.t.a(q));
        if (this.r()) {
            new Q(q, this.r).a(a, (byte)this.t.a(q), this.u, this.a());
        }
        return a;
    }
    
    protected J c(final q q) {
        if (this.y != null) {
            final J j = (J)this.y.b(q);
            if (j != null) {
                return j;
            }
        }
        return this.E;
    }
    
    protected Comparator d(final q q) {
        if (this.z != null) {
            final Comparator comparator = (Comparator)this.z.b(q);
            if (comparator != null) {
                return comparator;
            }
        }
        return this.F;
    }
    
    protected I e(final q q) {
        I i = null;
        if (this.x != null) {
            i = (I)this.x.b(q);
        }
        if (i != null) {
            return this.a(q, i);
        }
        if (q.c() > 0) {
            return this.a(q, this.C);
        }
        return this.a(q, this.D);
    }
    
    private I a(final q q, final I i) {
        final int g = d.g;
        if (this.L != null && this.J != null && this.J.b(q) != null) {
            final y.c.c c = this.r.c(y.f.b.f.e);
            final y.c.y y = (y.c.y)this.J.b(q);
            I j = null;
            final y.c.x a = y.a();
            while (a.f()) {
                final q e = a.e();
                final r a2 = y.d.r.a((c == null) ? null : c.b(e));
                final y.c.y c2 = this.L.c(e);
                Label_0182: {
                    if (j == null) {
                        j = new O(i, e, c2, this.s, this.K, a2);
                        if (g == 0) {
                            break Label_0182;
                        }
                    }
                    j = new O(j, e, c2, this.s, this.K, a2);
                }
                a.g();
                if (g != 0) {
                    break;
                }
            }
            return j;
        }
        return i;
    }
    
    protected y.f.k.A f(final q q) {
        final y.f.k.A a = new y.f.k.A(q, this.r.a((Object)q));
        if (this.G) {
            new Q(q, this.r).a(a);
        }
        return a;
    }
    
    protected q[] g(final q q) {
        final int g = d.g;
        final ArrayList<Object> list = new ArrayList<Object>(this.r.e());
        final int[] array = new int[this.r.e()];
        final q[] m = this.r.m();
        int i = 0;
        while (true) {
            while (i < m.length) {
                final int c = m[i].c();
                array[i] = c;
                final int n = c;
                if (g == 0) {
                    if (n == 0) {
                        list.add(m[i]);
                    }
                    ++i;
                    if (g != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    int n2 = n;
                    while (!list.isEmpty()) {
                        final q q2 = list.remove(list.size() - 1);
                        if (g != 0) {
                            return m;
                        }
                        if (q2 != q) {
                            final q c2 = q2.g().c();
                            final int[] array2 = array;
                            final int d = c2.d();
                            if (--array2[d] == 0) {
                                list.add(c2);
                            }
                        }
                        m[n2++] = q2;
                        if (g != 0) {
                            break;
                        }
                    }
                    if (n2 != this.r.e()) {
                        throw new RuntimeException("Not all nodes found!");
                    }
                    return m;
                }
            }
            continue;
        }
    }
    
    protected y.c.f o() {
        final int g = d.g;
        final y.c.f e = y.a.A.e(this.r);
        final e a = e.a();
        while (a.f()) {
            this.r.c(a.a());
            a.g();
            if (g != 0) {
                break;
            }
        }
        return e;
    }
    
    protected a p() {
        return (y.c.b)this.A.d();
    }
    
    protected a q() {
        return (y.c.b)this.B.d();
    }
    
    protected void a(final y.c.f f) {
        final int g = d.g;
        p p = f.k();
        while (p != null) {
            final y.c.d d = (y.c.d)p.c();
            ae.a(this.r.g(d));
            final aE d2 = aE.d(this.r, d);
            final aE e = aE.e(this.r, d);
            this.r.c(d);
            this.p().a(d, e);
            this.q().a(d, d2);
            p = p.a();
            if (g != 0) {
                break;
            }
        }
    }
    
    public void a(final I c) {
        this.C = c;
    }
    
    public void a(final J e) {
        this.E = e;
    }
    
    public boolean r() {
        return this.H;
    }
    
    static {
        n = "y.layout.tree.GenericTreeLayouter.NODE_PLACER_DPKEY";
        o = "y.layout.tree.GenericTreeLayouter.PORT_ASSIGNMENT_DPKEY";
        p = "y.layout.tree.GenericTreeLayouter.CHILD_COMPARATOR_DPKEY";
        q = "y.layout.tree.GenericTreeLayouter.EDGE_REVERSED_DPKEY";
    }
}
