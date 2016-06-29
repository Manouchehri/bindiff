package y.f.a;

import y.a.*;
import y.f.j.*;
import y.f.*;
import y.d.*;
import java.awt.geom.*;
import y.f.e.a.*;
import y.f.e.*;
import y.c.*;
import java.util.*;
import y.g.*;

class j extends f
{
    private A v;
    private A w;
    private y x;
    private av y;
    private int z;
    private double A;
    private y B;
    private boolean C;
    private y D;
    
    j() {
        this.C = false;
        this.D = new y();
    }
    
    public void i(final boolean c) {
        this.C = c;
    }
    
    public y p() {
        return this.D;
    }
    
    public void a(final y x) {
        this.x = x;
    }
    
    public void a(final ay ay, final long n) {
        ((o)ay.z()).a(n);
    }
    
    double a(final x x, final double n) {
        this.A = Math.max(this.s / 6.283185307179586, n);
        if (this.x == null) {
            this.x = new y();
        }
        final int max = Math.max(this.x.size(), (int)(4.0 * (Math.sqrt(this.n.e()) - 1.0) + 1.0));
        this.z = this.n.e();
        this.B = new y(x);
        if (this.n.e() <= 8 || this.n.e() <= max - 1) {
            this.a(3.141592653589793 / this.n.e());
            this.D = this.B;
            return super.a(this.B.a(), n);
        }
        this.v = this.n.t();
        final ay ay = new ay(false);
        final h h = new h();
        ay.a(h);
        ay.h(true);
        final long max2 = Math.max((long)(1000.0 * Math.pow(this.n.e() - this.D.size(), 0.75)), 500L);
        final o o = new o();
        o.a(max2);
        o.a(0.05);
        o.b(0.03);
        ay.a(o);
        ay.a(new n());
        ay.a(new r(this));
        double n2 = 0.0;
        Label_0334: {
            if (this.C) {
                n2 = this.a(ay, h);
                if (f.u == 0) {
                    break Label_0334;
                }
            }
            n2 = this.a(ay, n, max, h);
        }
        final double a = this.a(ay, n2, h, this.p);
        this.n.a(this.v);
        return a;
    }
    
    private double a(final ay ay, final h h) {
        final int u = f.u;
        Label_0221: {
            if (!this.t) {
                this.D = new y();
                y.c.f b = new y.c.f();
                if (!y.a.g.c(this.n)) {
                    b = y.a.h.b(this.n);
                }
                final q q = new q();
                q.b(0.3);
                q.h(true);
                q.g(true);
                q.a(0.5);
                q.c(this.p);
                q.d(this.p);
                q.m();
                q.c(this.n);
                if (b.size() > 0) {
                    final e a = b.a();
                    while (a.f()) {
                        this.n.a(a.a());
                        a.g();
                        if (u != 0) {
                            break Label_0221;
                        }
                        if (u != 0) {
                            break;
                        }
                    }
                }
                if (!this.q) {
                    final double s = this.s();
                    final a a2 = new a();
                    a2.b(this.o / s);
                    a2.a(this.n);
                }
            }
        }
        final G g = new G();
        g.a(this.v);
        g.a(this.q);
        final Rectangle2D a3 = ae.a(this.n, this.n.o());
        final t t = new t(a3.getCenterX(), a3.getCenterY());
        final double a4 = t.a();
        final double b2 = t.b();
        final x o = this.n.o();
        while (true) {
            while (true) {
                while (o.f()) {
                    this.n.d(o.e(), -a4, -b2);
                    o.g();
                    if (u != 0) {
                        final double n = a3.getHeight() / 2.0;
                        final double n2 = a3.getWidth() / 2.0;
                        g.a(Math.sqrt(n * n + n2 * n2));
                        g.b(false);
                        if (!this.q) {
                            g.b(this.o);
                        }
                        g.c(this.n);
                        this.D = g.a();
                        return g.b();
                    }
                    if (u != 0) {
                        break;
                    }
                }
                if (this.t) {
                    continue;
                }
                g.a(this.r);
                g.b(false);
                if (u != 0) {
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    private double a(final ay ay, final double n, final int n2, final h h) {
        this.w = this.n.t();
        final y.a.p o = this.o();
        double n3 = 0.0;
        Label_0178: {
            if (this.t && o instanceof y.f.a.g) {
                this.t();
                final y.c.q b = this.D.b();
                this.a(Math.atan2(this.n.k(b) - ((y.f.a.g)o).a().b(), this.n.j(b) - ((y.f.a.g)o).a().a()));
                n3 = super.a(this.D.a(), n);
                if (f.u == 0) {
                    break Label_0178;
                }
            }
            this.a(n2, this.n.e());
            this.a(3.141592653589793 / this.D.a().k());
            n3 = super.a(this.D.a(), n);
        }
        this.q();
        (this.y = new l(this)).b(n3);
        this.y.a(0.2 * n3);
        final J j = new J(this.y, J.d, 0.0, 1.0);
        j.c(1.0);
        j.a(J.c);
        ay.a(j);
        final y.f.a.q q = new y.f.a.q(this);
        ay.c(q);
        q.b(n3);
        q.a(0.2 * n3);
        ay.b((double)this.p);
        ay.a((double)this.p);
        h.a(2.0);
        ay.a(this.n);
        ay.d(q);
        ay.b(j);
        this.n.a(this.w);
        final double s = this.s();
        this.a(s, Math.max(this.r / 2.0, this.p));
        this.r();
        final y.c.q b2 = this.D.b();
        this.a(Math.atan2(this.n.k(b2), this.n.j(b2)));
        return super.a(this.D.a(), s);
    }
    
    private double a(final ay ay, double n, final h h, final double n2) {
        final int u = f.u;
        if (this.q && this.t) {
            n = Math.max(n, this.s / 6.283185307179586);
        }
        if (this.q && n > this.A) {
            final double n3 = this.A / n;
            final a a = new a();
            a.b(n3);
            a.g(false);
            a.a(this.n);
            n = this.A;
        }
        h.c(3.0);
        ay.a(n2);
        ay.b(n2);
        final J j = new J(new aj(), J.a, 0.0, Math.max(n2, this.r));
        ((aj)j.b()).a(n2);
        j.c(0.25);
        j.a(J.j);
        ay.a(j);
        this.y = new av();
        final double max = Math.max(n2 / 2.0, this.r / 2.0);
        this.y.b(n - max);
        this.y.a(max);
        final J i = new J(this.y, J.d, 0.0, 1.0);
        ay.a(i);
        i.c(1.0);
        long e = 0L;
        Label_0313: {
            if (this.q && !this.C) {
                e = ay.s().e();
                if (u == 0) {
                    break Label_0313;
                }
            }
            e = (long)(1000.0 * Math.pow(this.n.e() - this.D.size(), 0.75));
        }
        this.a(ay, Math.max(200L, e));
        ay.a(this.n);
        if (this.q) {
            new k(new ar(42L), n2).c(this.n);
        }
        n = this.s();
        this.a(n, this.r / 2.0);
        final y.c.q b = this.D.b();
        final double atan2 = Math.atan2(this.n.k(b), this.n.j(b));
        Label_0477: {
            if (this.q) {
                this.a(atan2);
                n = super.a(this.D.a(), n);
                if (u == 0) {
                    break Label_0477;
                }
            }
            this.a(atan2);
            super.b(this.D.a(), 0.0);
        }
        double max2 = 0.0;
        final x a2 = this.D.a();
        while (true) {
            while (a2.f()) {
                final y.d.y s = this.n.s(a2.e());
                max2 = Math.max(max2, s.b());
                final double max3 = Math.max(max2, s.a());
                if (u != 0) {
                    final double n4 = max3;
                    if (n4 > 1.0) {
                        this.e(n4);
                    }
                    if (this.q) {
                        final D c = this.c(this.n.o(), n2);
                        this.a(c, n2);
                        double n5 = n;
                        final double max4 = Math.max(max2 / 5.0, 5.0);
                        int n6 = 0;
                        while (!c.isEmpty() && n6++ < 5) {
                            final double n7 = n5 + max4;
                            this.d(n7 / n5);
                            this.a(c, n2);
                            n5 = n7;
                            if (u != 0) {
                                break;
                            }
                        }
                    }
                    return n;
                }
                max2 = max3;
                a2.g();
                if (u != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    private void d(final double n) {
        final int u = f.u;
        final x o = this.n.o();
        while (o.f()) {
            final y.c.q e = o.e();
            this.n.a(e, this.n.j(e) * n, this.n.k(e) * n);
            o.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    private static y.d.y a(final y.d.y y, final double n) {
        return new y.d.y(y.c() - n, y.d() - n, y.a() + 2.0 * n, y.b() + 2.0 * n);
    }
    
    private void a(final D d, final double n) {
        final int u = f.u;
        final C m = d.m();
        while (m.f()) {
            if (!((y.f.a.p)m.d()).a(n)) {
                d.b(m);
            }
            m.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    private D c(final x x, final double n) {
        final int u = f.u;
        final D d = new D();
        final double n2 = n * 0.5;
        while (x.f()) {
            final y.c.q e = x.e();
            d.add(new m(e, a(this.n.s(e), n2)));
            x.g();
            if (u != 0) {
                break;
            }
        }
        final y.f.a.o o = new y.f.a.o(this);
        y.d.f.a(d, o);
        return o.a();
    }
    
    private void a(final int n, final int n2) {
        final int i = f.u;
        final A t = this.n.t();
        final int e = this.n.e();
        j j = null;
        Label_0083: {
            if (this.x != null) {
                for (final y.c.q q : this.x) {
                    j = this;
                    if (i != 0) {
                        break Label_0083;
                    }
                    this.v.a(q, true);
                    if (i != 0) {
                        break;
                    }
                }
            }
            j = this;
        }
        final y.c.q[] e2 = j.B.e();
        final A t2 = this.n.t();
        int n3 = 0;
        final x a = this.B.a();
        while (a.f()) {
            t2.a(a.e(), n3);
            a.g();
            ++n3;
            if (i != 0) {
                break;
            }
        }
        final boolean b = y.a.A.b(this.n);
        int n4 = 0;
        while (true) {
            do {
                Label_0169: {
                    final int length = e2.length;
                }
                int k = 0;
                int n5 = 0;
                Label_0174:
                while (k < n5) {
                    final y.c.q q2 = e2[n4];
                    final int d;
                    final int n6 = d = (this.v.d(q2) ? 1 : 0);
                    if (i == 0) {
                        Label_0376: {
                            if (n6 != 0) {
                                t.a(q2, -1);
                                if (i == 0) {
                                    break Label_0376;
                                }
                            }
                            if (b && q2.a() == 1) {
                                t.a(q2, 0);
                                if (i == 0) {
                                    break Label_0376;
                                }
                            }
                            int n7 = 0;
                            final e l = q2.j();
                            while (l.f()) {
                                final int a2 = t2.a(l.a().a(q2));
                                k = n4;
                                n5 = a2;
                                if (i != 0) {
                                    continue Label_0174;
                                }
                                int n8 = 0;
                                Label_0347: {
                                    if (k > n5) {
                                        n8 = Math.min(n4 - a2, a2 + e - n4) - 1;
                                        if (i == 0) {
                                            break Label_0347;
                                        }
                                    }
                                    n8 = Math.min(a2 - n4, e + n4 - a2) - 1;
                                }
                                n7 += n8;
                                l.g();
                                if (i != 0) {
                                    break;
                                }
                            }
                            t.a(q2, n7);
                        }
                        ++n4;
                        continue Label_0169;
                    }
                    int n9 = d;
                    while (n9 < n2) {
                        final y.c.q q3 = e2[n9];
                        if (n4 < n || t.a(q3) <= 0) {
                            this.v.a(q3, true);
                            ++n4;
                        }
                        ++n9;
                        if (i != 0) {
                            break;
                        }
                    }
                    final y d2 = new y();
                    final x a3 = this.B.a();
                    while (true) {
                        while (a3.f()) {
                            final y.c.q e3 = a3.e();
                            final int d3 = this.v.d(e3) ? 1 : 0;
                            if (i != 0) {
                                if (d3 <= n2) {
                                    this.r();
                                }
                                this.n.a(t);
                                this.n.a(t2);
                                return;
                            }
                            if (d3 != 0) {
                                d2.add(e3);
                            }
                            a3.g();
                            if (i != 0) {
                                break;
                            }
                        }
                        (this.D = d2).size();
                        continue;
                    }
                }
                break;
            } while (i == 0);
            y.g.e.a(e2, y.g.e.b(t));
            n4 = 0;
            int d = 0;
            continue;
        }
    }
    
    private void r() {
        final int u = f.u;
        if (this.D.size() >= this.z) {
            return;
        }
        final y y = new y();
        final x o = this.n.o();
        while (true) {
            while (o.f()) {
                final y.c.q e = o.e();
                final boolean d = this.v.d(e);
                if (u == 0) {
                    if (!d) {
                        y.add(e);
                    }
                    o.g();
                    if (u != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    int n = d ? 1 : 0;
                    y.a();
                Label_0360:
                    while (true) {
                        x m = null;
                        final x x = m;
                    Label_0195_Outer:
                        while (x.f()) {
                            final y.c.q e2 = x.e();
                            final y y2 = new y();
                            m = e2.m();
                            if (u == 0) {
                                final x x2 = m;
                                while (true) {
                                    while (x2.f()) {
                                        final y.c.q e3 = x2.e();
                                        final int n2;
                                        final boolean b = (n2 = (this.v.d(e3) ? 1 : 0)) != 0;
                                        if (u == 0) {
                                            if (b) {
                                                y2.add(e3);
                                            }
                                            x2.g();
                                            if (u != 0) {
                                                break;
                                            }
                                            continue Label_0195_Outer;
                                        }
                                        else {
                                            Label_0334: {
                                                if (n2 == 2) {
                                                    final y.c.q b2 = y2.b();
                                                    final y.c.q c = y2.c();
                                                    final y.c.p d2 = this.D.d(b2);
                                                    final y.c.p d3 = this.D.d(c);
                                                    if (this.D.e(d2) == d3) {
                                                        this.D.b(e2, d2);
                                                        this.v.a(e2, true);
                                                        y.remove(e2);
                                                        n = 1;
                                                        if (u == 0) {
                                                            break Label_0334;
                                                        }
                                                    }
                                                    if (this.D.e(d3) == d2) {
                                                        this.D.b(e2, d3);
                                                        this.v.a(e2, true);
                                                        y.remove(e2);
                                                        n = 1;
                                                    }
                                                }
                                            }
                                            if (this.D.size() >= this.z) {
                                                return;
                                            }
                                            x.g();
                                            if (u != 0) {
                                                break Label_0360;
                                            }
                                            continue Label_0195_Outer;
                                        }
                                    }
                                    int n2 = y2.size();
                                    continue;
                                }
                            }
                            continue Label_0360;
                        }
                        break;
                    }
                    if (n == 0) {
                        return;
                    }
                    break;
                }
            }
            continue;
        }
    }
    
    private void e(final double n) {
        final int u = f.u;
        final x o = this.n.o();
        while (o.f()) {
            final y.c.q e = o.e();
            if (!this.v.d(e)) {
                this.n.a(e, this.n.j(e) * n, this.n.k(e) * n);
            }
            o.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    private double s() {
        final int u = f.u;
        double n = 0.0;
        final x o = this.n.o();
        double max = 0.0;
        while (o.f()) {
            final y.c.q e = o.e();
            final double j = this.n.j(e);
            final double k = this.n.k(e);
            max = Math.max(n, Math.sqrt(j * j + k * k));
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
    
    private void a(final double n, final double n2) {
        final int u = f.u;
        final y d = new y();
        final x o = this.n.o();
        while (o.f()) {
            final y.c.q e = o.e();
            final double j = this.n.j(e);
            final double k = this.n.k(e);
            final double sqrt = Math.sqrt(j * j + k * k);
            if (u != 0) {
                return;
            }
            if (sqrt >= n - n2) {
                this.v.a(e, true);
            }
            if (this.v.d(e)) {
                d.add(e);
            }
            o.g();
            if (u != 0) {
                break;
            }
        }
        y.g.e.a(d, new y.f.a.k(this));
        this.D = d;
    }
    
    void b(final x x, final double n) {
        this.v = this.n.t();
        this.B = new y(x);
        final ay ay = new ay(false);
        final h h = new h();
        ay.a(h);
        ay.h(true);
        ay.a(new n());
        ay.a(new r(this));
        this.z = this.n.e();
        Label_0287: {
            if (!this.C) {
                this.a(8, this.z);
                if (this.n.e() <= 8 || this.n.e() <= this.D.size()) {
                    this.a(3.141592653589793 / this.n.e());
                    super.b(this.B.a(), 0.0);
                    this.D = this.B;
                    return;
                }
                this.a(3.141592653589793 / this.D.size());
                super.b(this.D.a(), 0.0);
                this.q();
                this.a(ay, this.o, h, this.o / Math.sqrt(this.n.e()));
                if (f.u == 0) {
                    break Label_0287;
                }
            }
            this.a(ay, h);
            this.a(ay, this.o, h, this.o / Math.sqrt(this.n.e()));
        }
        this.n.a(this.v);
    }
    
    void q() {
        final int u = f.u;
        final x o = this.n.o();
        while (o.f()) {
            final y.c.q e = o.e();
            if (!this.v.d(e)) {
                this.n.a(e, 0.0, 0.0);
            }
            o.g();
            if (u != 0) {
                break;
            }
        }
    }
    
    private void t() {
        final int u = f.u;
        final t b = this.b(this.n.o());
        double n = 0.0;
        double n2 = 0.0;
        final double n3 = this.n.e();
        final x o = this.n.o();
        while (true) {
            while (o.f()) {
                final double a = b.a(this.n.l(o.e()));
                n += a;
                final double n4 = n2 + a * a;
                if (u != 0) {
                    double n5 = n4;
                    double n6 = (n3 * n2 - n * n) / (n3 * (n3 - 1.0));
                    if (n6 < 0.0) {
                        n6 = 0.0;
                    }
                    final double sqrt = Math.sqrt(n6);
                    final y y = new y();
                    if (sqrt > 0.1) {
                        final x o2 = this.n.o();
                        while (o2.f()) {
                            final y.c.q e = o2.e();
                            final double a2 = b.a(this.n.l(e));
                            if (a2 < n5 - 2.0 * sqrt || a2 > n5 + 2.0 * sqrt) {
                                y.add(e);
                            }
                            o2.g();
                            if (u != 0) {
                                break;
                            }
                        }
                    }
                    final I i = new I(this.n);
                    i.a(y);
                    final G g = new G();
                    g.b(true);
                    g.a(b);
                    g.a(this.v);
                    g.a(false);
                    g.b(n5);
                    g.a(n5);
                    g.b(true);
                    g.c(this.n);
                    final y a3 = g.a();
                    i.f();
                    final t b2 = this.b(a3.a());
                    double n7 = 0.0;
                    final double n8 = a3.size();
                    final x a4 = a3.a();
                    while (true) {
                        while (a4.f()) {
                            n7 += b2.a(this.n.l(a4.e()));
                            a4.g();
                            if (u != 0) {
                                final x o3 = this.n.o();
                            Label_0602:
                                while (true) {
                                    while (o3.f()) {
                                        final y.c.q e2 = o3.e();
                                        final double a5 = b2.a(this.n.l(e2));
                                        if (u != 0) {
                                            final y.a.p o4 = this.o();
                                            if (o4 instanceof y.f.a.g) {
                                                ((y.f.a.g)o4).a(new t(b2.a(), b2.b()));
                                            }
                                            this.B = new y(o4.a(this.n));
                                            final x a6 = this.B.a();
                                            while (a6.f()) {
                                                final y.c.q e3 = a6.e();
                                                if (this.v.d(e3)) {
                                                    this.D.b(e3);
                                                }
                                                a6.g();
                                                if (u != 0) {
                                                    break;
                                                }
                                            }
                                            return;
                                        }
                                        if (a5 >= n5 - this.r) {
                                            this.v.a(e2, true);
                                        }
                                        o3.g();
                                        if (u != 0) {
                                            break;
                                        }
                                    }
                                    if (this.x != null) {
                                        final Iterator iterator = this.x.iterator();
                                        while (iterator.hasNext()) {
                                            this.v.a(iterator.next(), true);
                                            if (u != 0) {
                                                continue Label_0602;
                                            }
                                            if (u != 0) {
                                                break;
                                            }
                                        }
                                    }
                                    this.D = new y();
                                    continue Label_0602;
                                }
                            }
                            if (u != 0) {
                                break;
                            }
                        }
                        n5 = n7 / n8;
                        continue;
                    }
                }
                n2 = n4;
                o.g();
                if (u != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    private t b(final x x) {
        final int u = f.u;
        double n = 0.0;
        double n2 = 0.0;
        x.i();
        while (x.f()) {
            final y.c.q e = x.e();
            n += this.n.j(e);
            n2 += this.n.k(e);
            x.g();
            if (u != 0) {
                return new t(n, n2);
            }
            if (u != 0) {
                break;
            }
        }
        n /= x.k();
        n2 /= x.k();
        return new t(n, n2);
    }
    
    static y a(final j j) {
        return j.D;
    }
    
    static A b(final j j) {
        return j.w;
    }
    
    static A c(final j j) {
        return j.v;
    }
    
    static av d(final j j) {
        return j.y;
    }
}
