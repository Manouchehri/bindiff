package y.f.f.e;

import y.f.f.b.*;
import y.f.*;
import y.g.*;
import y.f.h.*;
import y.d.*;
import y.c.*;
import java.util.*;

public class i implements d
{
    private X a;
    private N b;
    private X c;
    private D d;
    private short e;
    private int f;
    private A g;
    private h h;
    private h i;
    private h j;
    
    public void a(final D b) {
        this.a = (X)b.g();
        this.b = b;
    }
    
    public void a(final short e) {
        this.e = e;
    }
    
    public void a(final int f) {
        this.f = f;
    }
    
    public D b() {
        return this.d;
    }
    
    public void a() {
        final int i = y.f.f.e.a.a;
        final y.c.d a = this.b.i().a().a();
        this.c = new w();
        this.d = new D(this.c);
        this.g = M.a(new Object[this.a.e()]);
        this.h = M.b(new Object[this.a.g()]);
        final x o = this.a.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                if (i != 0) {
                    final x o2 = this.a.o();
                    do {
                        Label_0214: {
                            o2.f();
                        }
                        int j = 0;
                        Label_0220:
                        while (j != 0) {
                            final q e2 = o2.e();
                            if (e2.c() != 0) {
                                final e l = e2.l();
                                final y.c.d a2 = l.a();
                                q q = (q)this.i.b(a2);
                                l.b();
                                while (l.f()) {
                                    final y.c.d a3 = l.a();
                                    final q q2 = (q)this.i.b(a3);
                                    final q q3 = (q)this.j.b(a3);
                                    final y.c.d a4 = this.a(q, q2);
                                    j = e2.c();
                                    if (i != 0) {
                                        continue Label_0220;
                                    }
                                    if (j > 4) {
                                        this.g.a(e2, a4);
                                    }
                                    q = (q)this.i.b(a3);
                                    this.h.a(a3, this.c.a(q2, q3));
                                    if (a3 == a2) {
                                        break;
                                    }
                                    l.b();
                                    if (i != 0) {
                                        break;
                                    }
                                }
                            }
                            o2.g();
                            continue Label_0214;
                        }
                        break;
                    } while (i == 0);
                    final e p = this.a.p();
                    while (true) {
                        while (p.f()) {
                            final y.c.d a5 = p.a();
                            final i k = this;
                            if (i != 0) {
                                final r m = k.d.m();
                                this.c.a("y.layout.orthogonal.general.NodeSplitter.NODE_FACES", m);
                                Label_0819: {
                                    try {
                                        this.d.l();
                                        this.d.b(this.d.i((y.c.d)this.h.b(a)));
                                        final y.f.h.q h = this.d.h();
                                        while (h.f()) {
                                            m.a(h.a(), false);
                                            h.g();
                                            if (i != 0) {
                                                break Label_0819;
                                            }
                                            if (i != 0) {
                                                break;
                                            }
                                        }
                                        final x o3 = this.a.o();
                                        while (o3.f()) {
                                            final q e3 = o3.e();
                                            if (i != 0) {
                                                break;
                                            }
                                            if (e3.c() > 4) {
                                                final p i2 = this.d.i((y.c.d)this.g.b(e3));
                                                this.g.a(e3, i2);
                                                m.a(i2, true);
                                            }
                                            o3.g();
                                            if (i != 0) {
                                                break;
                                            }
                                        }
                                    }
                                    catch (Exception ex) {
                                        System.err.println("Internal Error in Face calculation !");
                                        ex.printStackTrace(System.err);
                                    }
                                }
                                final y.f.h.q h2 = this.d.h();
                                while (h2.f()) {
                                    final p p2 = (p)h2.d();
                                    Label_0937: {
                                        if (m.d(p2)) {
                                            final e a6 = p2.a();
                                            while (a6.f()) {
                                                final y.c.d a7 = a6.a();
                                                this.d.m(this.d.h(a7));
                                                this.d.e(a7);
                                                a6.g();
                                                if (i != 0) {
                                                    break Label_0937;
                                                }
                                                if (i != 0) {
                                                    break;
                                                }
                                            }
                                        }
                                        h2.g();
                                    }
                                    if (i != 0) {
                                        break;
                                    }
                                }
                                return;
                            }
                            Label_0527: {
                                if (this.b.n(a5)) {
                                    this.d.m((y.c.d)this.h.b(a5));
                                    if (i == 0) {
                                        break Label_0527;
                                    }
                                }
                                this.d.e((y.c.d)this.h.b(a5));
                            }
                            this.d.b((y.c.d)this.h.b(a5), (y.c.d)this.h.b(this.b.h(a5)));
                            p.g();
                            if (i != 0) {
                                break;
                            }
                        }
                        final i k = this;
                        continue;
                    }
                }
                if (e.c() < 5) {
                    this.g.a(e, this.c.d());
                }
                o.g();
                if (i != 0) {
                    break;
                }
            }
            this.i = M.b(new Object[this.a.g()]);
            this.j = M.b(new Object[this.a.g()]);
            this.a(this.i, this.j);
            continue;
        }
    }
    
    private y.c.d a(final q q, final q q2) {
        if (q.equals(q2)) {
            return null;
        }
        final y.c.d a = this.c.a(q, q2);
        final e l = q2.l();
        y.c.d d = null;
        Label_0085: {
            if (!l.f()) {
                d = this.c.a(q2, q);
                if (y.f.f.e.a.a == 0) {
                    break Label_0085;
                }
            }
            l.g();
            d = this.c.a(q2, l.a(), q, null, 1, 0);
        }
        this.d.b(a, d);
        return d;
    }
    
    private void a(final h h, final h h2) {
        final int a = y.f.f.e.a.a;
        final x o = this.a.o();
    Label_0013:
        while (true) {
        Label_0102_Outer:
            while (o.f()) {
                final e l = o.e().l();
                if (a == 0) {
                    final e e = l;
                    while (true) {
                        while (e.f()) {
                            final y.c.d a2 = e.a();
                            h.a(a2, this.a(a2));
                            e.g();
                            if (a == 0) {
                                if (a != 0) {
                                    break;
                                }
                                continue Label_0102_Outer;
                            }
                            else {
                                if (a != 0) {
                                    break Label_0102_Outer;
                                }
                                continue Label_0013;
                            }
                        }
                        o.g();
                        continue;
                    }
                }
                final e e2 = l;
                while (e2.f()) {
                    final y.c.d a3 = e2.a();
                    final y.c.d h3 = this.b.h(a3);
                    h2.a(a3, h.b(h3));
                    h2.a(h3, h.b(a3));
                    e2.g();
                    if (a != 0) {
                        break;
                    }
                }
                return;
            }
            this.a.p();
            continue;
        }
    }
    
    private q a(final y.c.d d) {
        if (d.c().c() < 5) {
            final q q = (q)this.g.b(d.c());
            if (y.f.f.e.a.a == 0) {
                return q;
            }
        }
        return this.c.d();
    }
    
    public void c() {
        final int a = y.f.f.e.a.a;
        final A t = this.a.t();
        final x o = this.a.o();
        while (true) {
        Label_0855:
            while (true) {
                while (o.f()) {
                    final q e = o.e();
                    final y.c.D d = new y.c.D();
                    final int c = e.c();
                    final int n = 4;
                    if (a != 0) {
                        int c2 = 0;
                        Label_1056: {
                            if (c == n) {
                                final e p = this.a.p();
                                while (p.f()) {
                                    final y.c.d a2 = p.a();
                                    final List e2 = this.c.j((y.c.d)this.h.b(a2)).e();
                                    c2 = a2.c().c();
                                    if (a != 0) {
                                        break Label_1056;
                                    }
                                    if (c2 > 4) {
                                        e2.add(0, this.c.l((q)this.i.b(a2)));
                                    }
                                    if (a2.d().c() > 4) {
                                        e2.add(this.c.l((q)this.j.b(a2)));
                                    }
                                    this.a.b(a2, new v(e2));
                                    this.a.a(a2, new t(0.0, 0.0));
                                    this.a.b(a2, new t(0.0, 0.0));
                                    p.g();
                                    if (a != 0) {
                                        break;
                                    }
                                }
                            }
                            final short e3 = this.e;
                        }
                        if (c2 == 0) {
                            final e p2 = this.a.p();
                            while (p2.f()) {
                                final y.c.d a3 = p2.a();
                                this.a.c(a3, this.c.l((q)this.i.b(a3)));
                                this.a.d(a3, this.c.l((q)this.j.b(a3)));
                                this.a.b(a3, this.c.j((y.c.d)this.h.b(a3)));
                                p2.g();
                                if (a != 0) {
                                    return;
                                }
                                if (a != 0) {
                                    break;
                                }
                            }
                        }
                        this.a.a(t);
                        return;
                    }
                    Label_0180: {
                        Label_0165: {
                            Label_0135: {
                                if (c > n) {
                                    final e a4 = ((p)this.g.b(e)).a();
                                    while (a4.f()) {
                                        d.add(this.c.l(a4.a().c()));
                                        a4.g();
                                        if (a != 0) {
                                            break Label_0180;
                                        }
                                        if (a != 0) {
                                            break Label_0135;
                                        }
                                    }
                                    break Label_0165;
                                }
                            }
                            d.add(this.c.l((q)this.g.b(e)));
                        }
                        t.a(e, d);
                        o.g();
                    }
                    if (a != 0) {
                        break;
                    }
                }
                final x o2 = this.a.o();
            Label_0372_Outer:
                while (o2.f()) {
                    final q e4 = o2.e();
                    int n2 = Integer.MAX_VALUE;
                    int n3 = Integer.MIN_VALUE;
                    int n4 = Integer.MAX_VALUE;
                    int n5 = Integer.MIN_VALUE;
                    final y.c.D d2 = (y.c.D)t.b(e4);
                    if (a == 0) {
                        final C m = d2.m();
                        while (true) {
                            while (m.f()) {
                                final t t2 = (t)m.d();
                                final double n6 = dcmpg(t2.a(), (double)n2);
                                if (a == 0) {
                                    if (n6 < 0) {
                                        n2 = (int)t2.a();
                                    }
                                    if (t2.b() < n4) {
                                        n4 = (int)t2.b();
                                    }
                                    if (t2.a() > n3) {
                                        n3 = (int)t2.a();
                                    }
                                    if (t2.b() > n5) {
                                        n5 = (int)t2.b();
                                    }
                                    m.g();
                                    if (a != 0) {
                                        break;
                                    }
                                    continue Label_0372_Outer;
                                }
                                else {
                                    Label_0751: {
                                        if (n6 == 1) {
                                            this.a.b(e4, this.f * 0.5, this.f * 0.5);
                                            final y y = new y();
                                            final y y2 = new y();
                                            final y y3 = new y();
                                            final y y4 = new y();
                                            Label_0737: {
                                                if (e4.c() > 4) {
                                                    final e a5 = ((p)this.g.b(e4)).a();
                                                    while (true) {
                                                        while (a5.f()) {
                                                            final t l = this.c.l(a5.a().c());
                                                            final double n7 = dcmpl(l.a(), (double)n2);
                                                            if (a == 0) {
                                                                if (n7 > 0 && l.a() < n3) {
                                                                    if (l.b() == n4) {
                                                                        y.add(new Integer((int)l.a()));
                                                                    }
                                                                    if (l.b() == n5) {
                                                                        y2.add(new Integer((int)l.a()));
                                                                    }
                                                                }
                                                                if (l.b() > n4 && l.b() < n5) {
                                                                    if (l.a() == n2) {
                                                                        y3.add(new Integer((int)l.b()));
                                                                    }
                                                                    if (l.a() == n3) {
                                                                        y4.add(new Integer((int)l.b()));
                                                                    }
                                                                }
                                                                a5.g();
                                                                if (a != 0) {
                                                                    break;
                                                                }
                                                                continue Label_0372_Outer;
                                                            }
                                                            else {
                                                                this.a.a(e4, n7, this.a(y3, y4, n4, n5));
                                                                if (a != 0) {
                                                                    break Label_0737;
                                                                }
                                                                break Label_0751;
                                                            }
                                                        }
                                                        this.a(y, y2, n2, n3);
                                                        continue;
                                                    }
                                                }
                                            }
                                            this.a.a(e4, n2, n4);
                                        }
                                    }
                                    if (this.e == 0) {
                                        this.a.b(e4, n3 - n2 + this.f * 0.5, n5 - n4 + this.f * 0.5);
                                        this.a.c(e4, n2 - this.f * 0.25, n4 - this.f * 0.25);
                                    }
                                    o2.g();
                                    if (a != 0) {
                                        break Label_0855;
                                    }
                                    continue Label_0372_Outer;
                                }
                            }
                            final short e5 = this.e;
                            continue;
                        }
                    }
                    final short e6 = this.e;
                    continue Label_0855;
                }
                break;
            }
            this.d.b();
            continue;
        }
    }
    
    private int a(final y.c.D d, final y.c.D d2, final int n, final int n2) {
        final int a = y.f.f.e.a.a;
        final y.c.D d3 = new y.c.D();
        if (d.size() == 0 && d2.size() == 0) {
            return (n2 + n) / 2;
        }
        if (d.size() > 0 && d2.size() == 0) {
            return this.a(d);
        }
        if (d.size() == 0 && d2.size() > 0) {
            return this.a(d2);
        }
        C c = d.m();
        while (true) {
            while (c.f()) {
                d3.add(c.d());
                c.g();
                if (a != 0) {
                    while (c.f()) {
                        final int n3 = d3.add(c.d()) ? 1 : 0;
                        if (a != 0) {
                            return n3;
                        }
                        c.g();
                        if (a != 0) {
                            break;
                        }
                    }
                    return this.a(d3);
                }
                if (a != 0) {
                    break;
                }
            }
            c = d2.m();
            continue;
        }
    }
    
    private int a(final y.c.D d) {
        final int a = y.f.f.e.a.a;
        d.sort(new j(this));
        final C m = d.m();
        int i = 0;
        while (i < d.size() / 2) {
            final Object d2;
            final C c = (C)(d2 = m);
            if (a != 0) {
                return (int)d2;
            }
            c.g();
            ++i;
            if (a != 0) {
                break;
            }
        }
        Object d2 = m.d();
        return (int)d2;
    }
}
