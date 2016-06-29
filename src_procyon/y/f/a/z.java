package y.f.a;

import java.util.*;
import y.c.*;
import y.g.*;
import y.f.*;
import y.d.*;
import y.a.*;

class z extends c
{
    private int n;
    private int o;
    private int p;
    private X q;
    private HashMap r;
    private y.c.c s;
    private y.c.c t;
    private y.c.c u;
    private byte v;
    private byte w;
    
    z() {
        this.n = 10;
        this.o = 10;
        this.p = 1;
        this.v = 0;
        this.w = 1;
    }
    
    public void a(final int n) {
        this.n = n;
    }
    
    public void b(final int o) {
        this.o = o;
    }
    
    private D a(final q q) {
        if (this.t == null) {
            return null;
        }
        return (D)this.t.b(q);
    }
    
    private D a(final d d) {
        if (this.u == null) {
            return null;
        }
        return (D)this.u.b(d);
    }
    
    private boolean b(final q q) {
        return this.s == null || this.s.a(q) == 0;
    }
    
    private boolean c(final q q) {
        return this.s != null && this.s.a(q) == 1;
    }
    
    public void a(final X q) {
        int u = y.f.a.f.u;
        this.r = new HashMap();
        this.q = q;
        this.s = q.c("NODE_SHAPE_DP");
        this.t = q.c("NODE_TO_LABEL_BOXES");
        this.u = q.c("EDGE_TO_MULTI_EDGES");
        this.o = Math.max(1, this.o);
        this.p = Math.max(1, this.p);
        final q a = this.a();
        final y.c.f a2 = A.a(q, a);
        final e a3 = a2.a();
        while (a3.f()) {
            ae.a(q.g(a3.a()));
            a3.g();
            if (u != 0) {
                break;
            }
        }
        final y y = new y(q.o());
        final y.c.A t = q.t();
        this.b(a, t);
        final y.c.A t2 = q.t();
        this.a(a, t2);
        final y.c.A t3 = q.t();
        this.a(t3);
        y.sort(new F(t, t2, t3));
        final D n = this.n();
        final y.c.A t4 = q.t();
        final x a4 = y.a();
        while (a4.f()) {
            final q e = a4.e();
            if (e != a) {
                this.a(this.f(e), t4, n);
            }
            a4.g();
            if (u != 0) {
                break;
            }
        }
        final e a5 = a2.a();
        while (true) {
            while (a5.f()) {
                final d a6 = a5.a();
                q.c(a6);
                ae.a(q.g(a6));
                a5.g();
                if (u != 0) {
                    if (y.c.i.g) {
                        y.f.a.f.u = ++u;
                    }
                    return;
                }
                if (u != 0) {
                    break;
                }
            }
            q.a(t4);
            q.a(t3);
            q.a(t);
            q.a(t2);
            continue;
        }
    }
    
    private void a(final y.c.A a) {
        final int i = y.f.a.f.u;
        final x o = this.q.o();
        while (o.f()) {
            final q e = o.e();
            Label_0286: {
                x a4 = null;
                if (e.c() > 4) {
                    final t l = this.q.l(e);
                    final t t = (e.b() > 0) ? this.q.l(e.g().c()) : null;
                    final y.f.a.A a2 = new y.f.a.A(this, l, (t == null) ? 3.141592653589793 : b(l, t));
                    final y.c.f f = new y.c.f(e.l());
                    f.sort(a2);
                    final y y = new y();
                    final e a3 = f.a();
                    while (a3.f()) {
                        y.add(a3.a().d());
                        a3.g();
                        if (i != 0) {
                            break Label_0286;
                        }
                        if (i != 0) {
                            break;
                        }
                    }
                    int n = 1;
                    do {
                        Label_0190: {
                            y.isEmpty();
                        }
                        boolean b = false;
                        Label_0195:
                        while (!b) {
                            boolean b2 = true;
                            a4 = y.a();
                            if (i == 0) {
                                final x x = a4;
                                while (x.f()) {
                                    b = b2;
                                    if (i != 0) {
                                        continue Label_0195;
                                    }
                                    if (b) {
                                        a.a(y.b(x), n);
                                    }
                                    b2 = !b2;
                                    x.g();
                                    if (i != 0) {
                                        break;
                                    }
                                }
                                ++n;
                                continue Label_0190;
                            }
                            break;
                        }
                        break;
                    } while (i == 0);
                }
                a4.g();
            }
            if (i != 0) {
                break;
            }
        }
    }
    
    private static double b(final t t, final t t2) {
        return Math.atan2(t2.b - t.b, t2.a - t.a);
    }
    
    private t a(final m m) {
        return y.d.t.c(m.c(), m.d());
    }
    
    private void a(final d d, final y.c.A a, final D d2) {
        final int u = y.f.a.f.u;
        final q d3 = d.d();
        final y.c.A a2 = M.a(new boolean[this.q.f()]);
        final y e = this.e(d3);
        final x a3 = e.a();
        while (a3.f()) {
            a2.a(a3.e(), true);
            a3.g();
            if (u != 0) {
                break;
            }
        }
        m m = new m(this.q.q(d), this.q.p(d));
        final D[] a4 = this.a(a2, this.a(m, e, this.o), d2);
        while (m.g() > 10.0) {
            this.a(e.a(), a);
            final t c = m.c();
            final t a5 = this.a(m);
            ae.a(this.q, e.a(), a5.a() - c.a(), a5.b() - c.b());
            if (this.a(d, a4)) {
                m = new m(this.a(m), m.d());
                if (u == 0) {
                    continue;
                }
            }
            m = new m(m.c(), this.a(m));
            this.b(e.a(), a);
            if (u != 0) {
                break;
            }
        }
    }
    
    private D[] a(final y.c.A a, final y.d.y y, final D d) {
        final int u = y.f.a.f.u;
        final D[] array = new D[2];
        array[this.v] = new D();
        array[this.w] = new D();
        final C m = d.m();
        while (m.f()) {
            final B b = (B)m.d();
            Label_0648: {
                if (b.e()) {
                    final q q = (q)b.i();
                    final boolean d2 = a.d(q);
                    if (d2) {
                        final y.d.y s = this.q.s(q);
                        final y.d.y a2 = a(s, this.o);
                        b.a((o)a2);
                        b.a(s);
                        b.a(d2);
                        if (!y.d.y.a(a2, y)) {
                            break Label_0648;
                        }
                        array[this.v].add(b);
                        array[this.w].add(b);
                        if (u == 0) {
                            break Label_0648;
                        }
                    }
                    if (b.c()) {
                        final y.d.y s2 = this.q.s(q);
                        b.a((o)s2);
                        b.a(s2);
                        b.a(false);
                        if (!y.d.y.a(s2, y)) {
                            break Label_0648;
                        }
                        array[this.w].add(b);
                        if (u == 0) {
                            break Label_0648;
                        }
                    }
                    if (!y.d.y.a(b.h(), y)) {
                        break Label_0648;
                    }
                    array[this.w].add(b);
                    if (u == 0) {
                        break Label_0648;
                    }
                }
                if (b.g()) {
                    final boolean d3 = a.d(b.i());
                    if (d3 || b.c()) {
                        final t l = this.q.l((q)b.i());
                        final y.d.y d4 = b.d();
                        final y.d.y y2 = new y.d.y(l.a() + d4.c(), l.b() + d4.d(), d4.a(), d4.b());
                        b.a((o)y2);
                        b.a(d3);
                        if (!y.d.y.a(y2, y)) {
                            break Label_0648;
                        }
                        if (d3) {
                            array[this.v].add(b);
                        }
                        array[this.w].add(b);
                        if (u == 0) {
                            break Label_0648;
                        }
                    }
                    if (!y.d.y.a(b.h(), y)) {
                        break Label_0648;
                    }
                    array[this.w].add(b);
                    if (u == 0) {
                        break Label_0648;
                    }
                }
                final d d5 = (d)b.i();
                final boolean b2 = a.d(d5.c()) || a.d(d5.d());
                if (b2 || b.c()) {
                    final m i = b.a() ? b.b().a(this.q) : this.b(d5);
                    b.a(i);
                    b.a(b2);
                    if (!y.d.y.a(i.h(), y)) {
                        break Label_0648;
                    }
                    if (b2) {
                        array[this.v].add(b);
                    }
                    array[this.w].add(b);
                    if (u == 0) {
                        break Label_0648;
                    }
                }
                if (y.d.y.a(b.h(), y)) {
                    array[this.w].add(b);
                }
            }
            m.g();
            if (u != 0) {
                break;
            }
        }
        return array;
    }
    
    private y.d.y a(final m m, final y y, final double n) {
        final int u = y.f.a.f.u;
        final double n2 = m.d().a() - m.c().a();
        final double n3 = m.d().b() - m.c().b();
        double n4 = Double.MAX_VALUE;
        double n5 = Double.MAX_VALUE;
        double n6 = -1.7976931348623157E308;
        double n7 = -1.7976931348623157E308;
        final x a = y.a();
        while (a.f()) {
            final am h = this.q.h(a.e());
            Label_0185: {
                if (n2 > 0.0) {
                    n4 = Math.min(n4, h.getX());
                    n6 = Math.max(n6, h.getX() + h.getWidth() + n2);
                    if (u == 0) {
                        break Label_0185;
                    }
                }
                n4 = Math.min(n4, h.getX() + n2);
                n6 = Math.max(n6, h.getX() + h.getWidth());
            }
            Label_0275: {
                if (n3 > 0.0) {
                    n5 = Math.min(n5, h.getY());
                    n7 = Math.max(n7, h.getY() + h.getHeight() + n3);
                    if (u == 0) {
                        break Label_0275;
                    }
                }
                n5 = Math.min(n5, h.getY() + n3);
                n7 = Math.max(n7, h.getY() + h.getHeight());
            }
            a.g();
            if (u != 0) {
                break;
            }
        }
        return new y.d.y(n4 - n, n5 - n, n6 - n4 + 2.0 * n, n7 - n5 + 2.0 * n);
    }
    
    private void a(final x x, final y.c.A a) {
        final int u = y.f.a.f.u;
        while (x.f()) {
            final q e = x.e();
            a.a(e, this.q.l(e));
            x.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    private void b(final x x, final y.c.A a) {
        final int u = y.f.a.f.u;
        while (x.f()) {
            final q e = x.e();
            this.q.a(e, (t)a.b(e));
            x.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    private double d(final q q) {
        return Math.max(this.q.p(q), this.q.q(q)) * 0.5;
    }
    
    private boolean a(final d d, final D[] array) {
        final int u = y.f.a.f.u;
        if (y.d.t.a(this.q.p(d), this.q.q(d)) < this.n) {
            return false;
        }
        final D a = this.a(d);
        double n = 0.0;
        if (a != null) {
            final C m = a.m();
            while (m.f()) {
                n = dcmpg(((y.f.a.C)m.d()).a(this.q).g(), (double)this.n);
                if (u != 0) {
                    return n == 0;
                }
                if (n < 0) {
                    return false;
                }
                m.g();
                if (u != 0) {
                    break;
                }
            }
        }
        this.a(array, d);
        return n == 0;
    }
    
    private boolean a(final B b, final B b2) {
        final q q = (q)b.i();
        final q q2 = (q)b2.i();
        if (!y.d.y.a(b.h(), b2.h())) {
            return false;
        }
        if (this.b(q) && this.b(q2)) {
            return true;
        }
        if (this.c(q) && this.c(q2)) {
            return y.d.t.a(this.q.l(q), this.q.l(q2)) - Math.max(b.h().a(), b.h().b()) * 0.5 - Math.max(b2.h().a(), b2.h().b()) * 0.5 < 0.0;
        }
        final B b3 = this.b(q) ? b : b2;
        final B b4 = this.c(q) ? b : b2;
        final double a = b3.h().a();
        final double b5 = b3.h().b();
        return y.d.t.a(this.q.l(q), this.q.l(q2)) - Math.max(b4.h().a(), b4.h().b()) * 0.5 - Math.sqrt(b5 * b5 + a * a) * 0.5 < 0.0;
    }
    
    private boolean a(final q q, final m m) {
        if (!y.d.y.a(this.q.s(q), m.h())) {
            return false;
        }
        if (this.c(q)) {
            final double n = a(m, this.q.l(q)) - this.d(q) - this.p;
            if (y.f.a.f.u == 0) {
                return n < 0.0;
            }
        }
        final double n = a(m, this.q.l(q)) - y.d.t.a(this.q.l(q), this.q.o(q)) - this.p;
        return n < 0.0;
    }
    
    private static y.d.y a(final y.d.y y, final double n) {
        final t e = y.e();
        return new y.d.y(e.a() - n, e.b() - n, y.a() + 2.0 * n, y.b() + 2.0 * n);
    }
    
    private boolean b(final B b, final B b2) {
        final q q = (q)b.i();
        final y.d.y h = b2.h();
        return y.d.y.a(b.d(), h) && (this.b(q) || y.d.t.a(this.q.l(q), new t(h.c() + h.a() * 0.5, h.d() + h.b() * 0.5)) - Math.max(b.d().a(), b.d().b()) * 0.5 - Math.sqrt(h.b() * h.b() + h.a() * h.a()) * 0.5 < 0.0);
    }
    
    private boolean c(final B b, final B b2) {
        return b.c() + b2.c();
    }
    
    private static double a(final m m, final t t) {
        final double a = m.c().a;
        final double a2 = m.d().a;
        final double b = m.c().b;
        final double b2 = m.d().b;
        final double a3 = t.a();
        final double b3 = t.b();
        final double n = a2 - a;
        final double n2 = b2 - b;
        double n3 = a3 - a;
        double n4 = b3 - b;
        double n5 = 0.0;
        Label_0158: {
            if (n3 * n + n4 * n2 > 0.0) {
                n3 = n - n3;
                n4 = n2 - n4;
                final double n6 = n3 * n + n4 * n2;
                if (n6 <= 0.0) {
                    n5 = 0.0;
                    if (f.u == 0) {
                        break Label_0158;
                    }
                }
                n5 = n6 * n6 / (n * n + n2 * n2);
            }
        }
        final double n7 = n3 * n3 + n4 * n4 - n5;
        if (n7 < 0.0) {
            return 0.0;
        }
        return Math.sqrt(n7);
    }
    
    private boolean a(final D[] array, final d d) {
        final int u = y.f.a.f.u;
        double n = Double.MAX_VALUE;
        double n2 = Double.MAX_VALUE;
        double n3 = -1.7976931348623157E308;
        double n4 = -1.7976931348623157E308;
        final C m = array[this.v].m();
        while (m.f()) {
            final B b = (B)m.d();
            Label_0453: {
                if (b.e()) {
                    final y.d.y s = this.q.s((q)b.i());
                    final y.d.y a = a(s, this.o);
                    b.a(s);
                    b.a((o)a);
                    n = Math.min(n, a.c());
                    n2 = Math.min(n2, a.d());
                    n3 = Math.max(n3, a.c() + a.a());
                    n4 = Math.max(n4, a.d() + a.b());
                    if (u == 0) {
                        break Label_0453;
                    }
                }
                if (b.f()) {
                    final d d2 = (d)b.i();
                    m i = null;
                    Label_0228: {
                        if (b.a()) {
                            i = b.b().a(this.q);
                            if (u == 0) {
                                break Label_0228;
                            }
                        }
                        i = this.b(d2);
                    }
                    b.a(i);
                    if (d2 == d && !b.a()) {
                        break Label_0453;
                    }
                    final y.d.y h = i.h();
                    n = Math.min(n, h.c());
                    n2 = Math.min(n2, h.d());
                    n3 = Math.max(n3, h.c() + h.a());
                    n4 = Math.max(n4, h.d() + h.b());
                    if (u == 0) {
                        break Label_0453;
                    }
                }
                final t l = this.q.l((q)b.i());
                final y.d.y d3 = b.d();
                final y.d.y y = new y.d.y(l.a() + d3.c(), l.b() + d3.d(), d3.a(), d3.b());
                b.a((o)y);
                n = Math.min(n, y.c());
                n2 = Math.min(n2, y.d());
                n3 = Math.max(n3, y.c() + y.a());
                n4 = Math.max(n4, y.d() + y.b());
            }
            m.g();
            if (u != 0) {
                break;
            }
        }
        final y.d.y y2 = new y.d.y(n, n2, n3 - n, n4 - n2);
        final D d4 = new D();
        final C j = array[this.w].m();
        while (j.f()) {
            final B b2 = (B)j.d();
            Label_0570: {
                if (b2.c()) {
                    d4.add(b2);
                    if (u == 0) {
                        break Label_0570;
                    }
                }
                if (y.d.y.a(b2.h(), y2)) {
                    d4.add(b2);
                }
            }
            j.g();
            if (u != 0) {
                break;
            }
        }
        final E e = new E(this, false);
        y.d.f.a(d4, e);
        return e.a();
    }
    
    private D n() {
        final int u = y.f.a.f.u;
        final D d = new D();
        int n = 1;
        final x o = this.q.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                d.add(new B(this, e, n++, this.q.s(e), this.q.s(e), (byte)0));
                final z z = this;
                if (u != 0) {
                    final e p = z.q.p();
                    while (p.f()) {
                        final d a = p.a();
                        d.add(new B(this, a, n++, this.b(a), (byte)1));
                        final D a2 = this.a(a);
                        Label_0396: {
                            if (a2 != null && !a2.isEmpty()) {
                                final C m = a2.m();
                                while (m.f()) {
                                    final y.f.a.C c = (y.f.a.C)m.d();
                                    d.add(new B(this, a, n++, c.a(this.q), (byte)1, c));
                                    m.g();
                                    if (u != 0) {
                                        break Label_0396;
                                    }
                                    if (u != 0) {
                                        break;
                                    }
                                }
                            }
                            p.g();
                        }
                        if (u != 0) {
                            break;
                        }
                    }
                    y.d.f.a(d, new E(this, true));
                    return d;
                }
                final D a3 = this.a(e);
                Label_0232: {
                    if (a3 != null && !a3.isEmpty()) {
                        final t l = this.q.l(e);
                        final C i = a3.m();
                        while (i.f()) {
                            final y.d.y y = (y.d.y)i.d();
                            d.add(new B(this, e, n++, new y.d.y(l.a() + y.c(), l.b() + y.d(), y.a(), y.b()), y, (byte)2));
                            i.g();
                            if (u != 0) {
                                break Label_0232;
                            }
                            if (u != 0) {
                                break;
                            }
                        }
                    }
                    o.g();
                }
                if (u != 0) {
                    break;
                }
            }
            final z z = this;
            continue;
        }
    }
    
    private m b(final d d) {
        return new m(this.q.p(d), this.q.q(d));
    }
    
    private y e(final q q) {
        final y y = new y(q);
        a(q, y);
        return y;
    }
    
    private static void a(final q q, final y y) {
        final int u = f.u;
        final x o = q.o();
        while (o.f()) {
            final q e = o.e();
            y.b(e);
            a(e, y);
            o.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    private d f(final q q) {
        final e k = q.k();
        if (k.k() > 1) {
            System.out.println("wrong tree structure: node " + q + " has multiple parents");
        }
        return k.f() ? k.a() : null;
    }
    
    public void a(final q q, final y.c.A a) {
        this.c(q, a);
    }
    
    private double c(final q q, final y.c.A a) {
        final int u = y.f.a.f.u;
        double n = this.q.p(q) * this.q.q(q);
        d d = q.f();
        while (d != null) {
            n += this.c(d.d(), a);
            d = d.g();
            if (u != 0) {
                return n;
            }
            if (u != 0) {
                break;
            }
        }
        a.a(q, n);
        return n;
    }
    
    public void b(final q q, final y.c.A a) {
        b.a(this.q, new y(q), a);
    }
    
    public q a() {
        return A.d(this.q);
    }
    
    public boolean b(final X x) {
        return A.b(x) && y.a.h.c(x);
    }
    
    static X a(final z z) {
        return z.q;
    }
    
    static double a(final t t, final t t2) {
        return b(t, t2);
    }
    
    static HashMap b(final z z) {
        return z.r;
    }
    
    static boolean a(final z z, final B b, final B b2) {
        return z.b(b, b2);
    }
    
    static boolean b(final z z, final B b, final B b2) {
        return z.c(b, b2);
    }
    
    static boolean c(final z z, final B b, final B b2) {
        return z.a(b, b2);
    }
    
    static boolean a(final z z, final q q, final m m) {
        return z.a(q, m);
    }
}
