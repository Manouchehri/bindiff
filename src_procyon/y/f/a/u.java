package y.f.a;

import y.g.*;
import y.a.*;
import y.c.*;

class u implements p
{
    i a;
    boolean b;
    boolean c;
    
    public u() {
        this.b = false;
        this.c = false;
    }
    
    public x a(final i a) {
        final int u = f.u;
        this.a = a;
        y.c.f b = new y.c.f();
        if (!this.a()) {
            b = h.b(a);
        }
        if (!this.b()) {
            b.a(h.e(a));
        }
        final y c = this.c();
        while (!b.isEmpty()) {
            a.a(b.d());
            if (u != 0) {
                break;
            }
        }
        return c.a();
    }
    
    public boolean a() {
        return this.b;
    }
    
    public boolean b() {
        return this.b;
    }
    
    y c() {
        final int u = f.u;
        if (this.a.f() < 3) {
            return new y(this.a.o());
        }
        final A t = this.a.t();
        final A t2 = this.a.t();
        final y.c.h u2 = this.a.u();
        final y.g.a.h h = new y.g.a.h(this.a, new w(), 0, this.b(this.a));
        int f = this.a.f();
        final y.c.f f2 = new y.c.f();
        final y.c.f f3 = new y.c.f();
        final I i = new I(this.a);
        Label_0932: {
        Label_0922:
            while (true) {
                y.c.q e = null;
            Label_0900:
                while (true) {
                    int j = 0;
                    int n = 0;
                Label_0223_Outer:
                    while (j > n) {
                        e = h.e();
                        final Integer n2 = new Integer(f);
                        if (u == 0) {
                            x x = e.m();
                            while (true) {
                                while (x.f()) {
                                    t.a(x.e(), n2);
                                    t2.a(x.e(), false);
                                    x.g();
                                    if (u != 0) {
                                    Label_0362:
                                        while (true) {
                                            while (x.f()) {
                                                final e l = x.e().l();
                                                if (u == 0) {
                                                    final e e2 = l;
                                                    while (e2.f()) {
                                                        final d a = e2.a();
                                                        final int a2 = t.a(a.d());
                                                        final int n3 = f;
                                                        if (u != 0) {
                                                            break Label_0362;
                                                        }
                                                        if (a2 == n3) {
                                                            f3.add(a);
                                                            t2.a(a.c(), true);
                                                            t2.a(a.d(), true);
                                                        }
                                                        e2.g();
                                                        if (u != 0) {
                                                            break;
                                                        }
                                                    }
                                                    x.g();
                                                    if (u != 0) {
                                                        break;
                                                    }
                                                    continue Label_0223_Outer;
                                                    y.c.q e6 = null;
                                                    Label_0776: {
                                                        final int a2;
                                                        final int n3;
                                                        if (a2 < n3) {
                                                            y.c.q q = null;
                                                            final x m = e.m();
                                                            while (true) {
                                                                while (m.f()) {
                                                                    final y.c.q e3 = m.e();
                                                                    final int a3 = t.a(e3);
                                                                    final int n4 = f;
                                                                    if (u == 0) {
                                                                        Label_0470: {
                                                                            if (a3 == n4 && !t2.d(e3)) {
                                                                                if (q == null) {
                                                                                    q = e3;
                                                                                    if (u == 0) {
                                                                                        break Label_0470;
                                                                                    }
                                                                                }
                                                                                final d a4 = this.a.a(q, e3);
                                                                                u2.a(a4, true);
                                                                                f3.add(a4);
                                                                                q = null;
                                                                            }
                                                                        }
                                                                        m.g();
                                                                        if (u != 0) {
                                                                            break;
                                                                        }
                                                                        continue Label_0223_Outer;
                                                                    }
                                                                    else {
                                                                        if (a3 < n4) {
                                                                            int a5 = Integer.MAX_VALUE;
                                                                            y.c.q q2 = null;
                                                                            final x k = e.m();
                                                                            while (k.f()) {
                                                                                final y.c.q e4 = k.e();
                                                                                j = e4.a();
                                                                                n = a5;
                                                                                if (u != 0) {
                                                                                    continue Label_0900;
                                                                                }
                                                                                if (j < n) {
                                                                                    q2 = e4;
                                                                                    a5 = e4.a();
                                                                                }
                                                                                k.g();
                                                                                if (u != 0) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            final x m2 = e.m();
                                                                            while (m2.f()) {
                                                                                final y.c.q e5 = m2.e();
                                                                                final y.c.q q3 = q2;
                                                                                if (u != 0) {
                                                                                    break;
                                                                                }
                                                                                if (q3.c(e5) == null && q2 != e5) {
                                                                                    final d a6 = this.a.a(q2, e5);
                                                                                    u2.a(a6, true);
                                                                                    f3.add(a6);
                                                                                    if (f3.size() >= e.a() - 1) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                m2.g();
                                                                                if (u != 0) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                        break Label_0776;
                                                                    }
                                                                }
                                                                if (q != null) {
                                                                    final x m3 = e.m();
                                                                    while (m3.f()) {
                                                                        final y.c.q q4 = e6 = m3.e();
                                                                        if (u != 0) {
                                                                            break Label_0776;
                                                                        }
                                                                        if (e6 != q && q4.c(q) == null) {
                                                                            final d a7 = this.a.a(q, q4);
                                                                            u2.a(a7, true);
                                                                            f3.add(a7);
                                                                            if (u == 0) {
                                                                                break;
                                                                            }
                                                                        }
                                                                        m3.g();
                                                                        if (u != 0) {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                                f3.size();
                                                                final int n5 = e.a() - 1;
                                                                continue;
                                                            }
                                                        }
                                                    }
                                                    final x m4 = e6.m();
                                                    while (m4.f()) {
                                                        h.d(m4.e());
                                                        m4.g();
                                                        if (u != 0) {
                                                            continue Label_0932;
                                                        }
                                                        if (u != 0) {
                                                            break;
                                                        }
                                                    }
                                                    f3.a();
                                                }
                                                final e e7 = l;
                                                while (e7.f()) {
                                                    final d a8 = e7.a();
                                                    final boolean d = u2.d(a8);
                                                    if (u != 0) {
                                                        continue Label_0900;
                                                    }
                                                    if (d) {
                                                        h.c(a8.c());
                                                        h.c(a8.d());
                                                    }
                                                    e7.g();
                                                    if (u != 0) {
                                                        break;
                                                    }
                                                }
                                                break Label_0900;
                                            }
                                            f3.size();
                                            final int n6 = e.a() - 1;
                                            continue Label_0362;
                                        }
                                    }
                                    if (u != 0) {
                                        break;
                                    }
                                }
                                x = e.m();
                                continue;
                            }
                        }
                        break Label_0932;
                    }
                    break Label_0922;
                }
                f2.a(f3);
                i.a(e);
                --f;
                if (u != 0) {
                    break;
                }
            }
            i.f();
            h.b();
        }
        final e a9 = f2.a();
        while (true) {
            while (a9.f()) {
                final d a10 = a9.a();
                final i a11 = a10.a();
                if (u != 0) {
                    final y.c.f a12 = q.a(a11);
                    final y y = new y();
                    final d d2 = (d)a12.a(0);
                    final d d3 = (d)a12.a(1);
                    y.c.q q5;
                    if (d2.c() == d3.c() || d2.c() == d3.d()) {
                        q5 = d2.d();
                    }
                    else {
                        q5 = d2.c();
                    }
                    y.add(q5);
                    e e8 = a12.a();
                    while (true) {
                        while (e8.f()) {
                            q5 = e8.a().a(q5);
                            y.add(q5);
                            e8.g();
                            if (u != 0) {
                                while (e8.f()) {
                                    final d a13 = e8.a();
                                    if (u != 0) {
                                        return y;
                                    }
                                    if (!u2.d(a13) && a13.a() == null) {
                                        this.a.e(a13);
                                    }
                                    e8.g();
                                    if (u != 0) {
                                        break;
                                    }
                                }
                                this.a.a(t2);
                                this.a.a(u2);
                                this.a.a(t);
                                this.a(y);
                                return y;
                            }
                            if (u != 0) {
                                break;
                            }
                        }
                        e8 = f2.a();
                        continue;
                    }
                }
                Label_1005: {
                    if (a11 != null) {
                        if (u2.d(a10)) {
                            this.a.a(a10);
                            if (u == 0) {
                                break Label_1005;
                            }
                        }
                        this.a.d(a10);
                    }
                }
                a9.g();
                if (u != 0) {
                    break;
                }
            }
            final i a14 = this.a;
            continue;
        }
    }
    
    void a(final y y) {
        final int u = f.u;
        if (y.size() < this.a.f()) {
            final A t = this.a.t();
            y.c.p p = y.k();
            while (p != null) {
                t.a(p.c(), p);
                p = p.a();
                if (u != 0) {
                    return;
                }
                if (u != 0) {
                    break;
                }
            }
            final y.g.a.h h = new y.g.a.h(this.a, new v(t), 0, y.size(), new v(t));
        Label_0102:
            while (true) {
            Label_0312:
                while (!h.a()) {
                    final y.c.q f = h.f();
                    x x = f.m();
                    y.c.q q = null;
                    Object o2;
                    Object o = null;
                    y.c.p p2;
                    y.c.p p3;
                    Label_0154_Outer:Label_0254_Outer:
                    while (true) {
                        while (true) {
                            while (true) {
                                Label_0286: {
                                    Label_0247: {
                                        if (!x.f()) {
                                            break Label_0247;
                                        }
                                        q = x.e();
                                        o = (o2 = t.b(q));
                                        if (u != 0) {
                                            break Label_0286;
                                        }
                                        if (o2 != null) {
                                            p2 = (y.c.p)t.b(q);
                                            if (f.c((y.c.q)y.f(p2).c()) != null) {
                                                p3 = y.a(f, p2);
                                            }
                                            else {
                                                p3 = y.b(f, p2);
                                            }
                                            t.a(f, p3);
                                            if (u == 0) {
                                                break Label_0247;
                                            }
                                        }
                                        x.g();
                                        if (u == 0) {
                                            continue Label_0154_Outer;
                                        }
                                    }
                                    x = f.m();
                                    if (!x.f()) {
                                        continue Label_0102;
                                    }
                                    q = x.e();
                                    if (u != 0) {
                                        break;
                                    }
                                    o = (o2 = t.b(q));
                                }
                                if (u != 0) {
                                    continue Label_0254_Outer;
                                }
                                break;
                            }
                            if (o == null) {
                                h.c(q);
                            }
                            x.g();
                            if (u != 0) {
                                break Label_0312;
                            }
                            continue;
                        }
                    }
                    h.b();
                    return;
                }
                this.a.a(t);
                continue;
            }
        }
    }
    
    int b(final i i) {
        final int u = f.u;
        int n = 0;
        final x o = i.o();
        int max = 0;
        while (o.f()) {
            max = Math.max(n, o.e().a());
            if (u != 0) {
                return max;
            }
            n = max;
            o.g();
            if (u != 0) {
                break;
            }
        }
        return max;
    }
}
