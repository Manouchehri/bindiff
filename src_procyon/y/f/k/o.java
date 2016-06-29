package y.f.k;

import java.util.*;
import y.f.b.*;
import y.f.*;
import y.d.*;
import y.g.*;
import y.c.*;

public class o extends c
{
    private static double n;
    private double o;
    private double p;
    private double q;
    private boolean r;
    private double t;
    private byte u;
    private boolean v;
    private int w;
    private A x;
    private byte y;
    private boolean z;
    private q[] A;
    protected X s;
    private Comparator B;
    private A C;
    
    public o() {
        this.o = 340.0;
        this.p = 360.0;
        this.q = 40.0;
        this.r = false;
        this.t = 0.5;
        this.u = 0;
        this.v = false;
        this.w = 0;
        this.y = 0;
        final ad f = this.f();
        if (f instanceof b) {
            ((b)f).a(false);
        }
    }
    
    public int a() {
        return this.w;
    }
    
    public boolean n() {
        return this.v;
    }
    
    public void g(final boolean v) {
        this.v = v;
    }
    
    public void a(int n) {
        Label_0024: {
            if (n < 1) {
                n = 1;
                if (d.g == 0) {
                    break Label_0024;
                }
            }
            if (n > 359) {
                n = 359;
            }
        }
        this.p = n;
    }
    
    public int o() {
        return (int)this.p;
    }
    
    public int p() {
        return (int)this.o;
    }
    
    public void h(final boolean r) {
        this.r = r;
    }
    
    public double q() {
        return this.t;
    }
    
    public void b(final int n) {
        this.q = n;
    }
    
    public int r() {
        return (int)this.q;
    }
    
    public boolean s() {
        return this.z;
    }
    
    public void a(final X s) {
        final int g = d.g;
        if (!y.a.A.b(s)) {
            throw new B("Graph is not a tree");
        }
        this.s = s;
        this.x = s.t();
        if (this.s()) {
            this.d(s);
        }
        final y.c.q t = this.t();
        final f a = y.a.A.a(s, t);
        this.a(t, this.x);
        ae.a(s);
        this.A = new q[s.f()];
        final x o = s.o();
        while (true) {
            while (o.f()) {
                final y.c.q e = o.e();
                if (g != 0) {
                    if (this.s()) {
                        this.e(s);
                    }
                    while (!a.isEmpty()) {
                        s.c(a.d());
                        if (g != 0) {
                            return;
                        }
                        if (g != 0) {
                            break;
                        }
                    }
                    s.a(this.x);
                    return;
                }
                Label_0181: {
                    if (e != t) {
                        this.a(e, new q(this.q + this.k(e.n().e())));
                        if (g == 0) {
                            break Label_0181;
                        }
                    }
                    this.a(e, new q(Math.max(this.q, this.w)));
                }
                o.g();
                if (g != 0) {
                    break;
                }
            }
            this.i(t);
            s.a(t, 0.0, 0.0);
            this.j(t);
            continue;
        }
    }
    
    private void d(final X x) {
        final int g = d.g;
        this.C = x.t();
        final x o = x.o();
    Label_0108_Outer:
        while (o.f()) {
            final y.c.q e = o.e();
            y y = x.s(e);
            final aj[] a_ = x.a_(e);
            int i = 0;
            while (true) {
                while (i < a_.length) {
                    y = a(y, a_[i].getBox());
                    ++i;
                    if (g == 0) {
                        if (g != 0) {
                            break;
                        }
                        continue Label_0108_Outer;
                    }
                    else {
                        final t l = x.l(e);
                        x.b(e, 2.0 * Math.floor(Math.max(l.a() - y.c(), y.c() + y.a() - l.a()) + 1.0E-5), 2.0 * Math.floor(Math.max(l.b() - y.d(), y.d() + y.b() - l.b()) + 1.0E-5));
                        x.a(e, l);
                        o.g();
                        if (g != 0) {
                            break Label_0108_Outer;
                        }
                        continue Label_0108_Outer;
                    }
                }
                this.C.a(e, x.r(e));
                continue;
            }
        }
    }
    
    private void e(final X x) {
        final int g = d.g;
        final x o = x.o();
        while (o.f()) {
            final y.c.q e = o.e();
            final t l = x.l(e);
            x.a(e, (y.d.q)this.C.b(e));
            x.a(e, l);
            o.g();
            if (g != 0) {
                return;
            }
            if (g != 0) {
                break;
            }
        }
        x.a(this.C);
    }
    
    private static y a(final y y, final y y2) {
        if (y == null || y2 == null) {
            return (y == null) ? y2 : y;
        }
        final double min = Math.min(y.c(), y2.c());
        final double max = Math.max(y.c() + y.a(), y2.c() + y2.a());
        final double min2 = Math.min(y.d(), y2.d());
        return new y(min, min2, max - min, Math.max(y.d() + y.b(), y2.d() + y2.b()) - min2);
    }
    
    private double a(final y.c.q q, final A a) {
        final int g = d.g;
        double n = this.s.p(q) * this.s.q(q);
        y.c.d d = q.f();
        while (d != null) {
            n += this.a(d.d(), a);
            d = d.g();
            if (g != 0) {
                return n;
            }
            if (g != 0) {
                break;
            }
        }
        a.a(q, n);
        return n;
    }
    
    public boolean b(final X x) {
        return y.a.A.b(x);
    }
    
    protected q e(final y.c.q q) {
        return this.A[q.d()];
    }
    
    protected y.c.q t() {
        switch (this.u) {
            case 2: {
                return y.a.A.f(this.s);
            }
            case 1: {
                return y.a.A.c(this.s);
            }
            default: {
                return y.a.A.d(this.s);
            }
        }
    }
    
    protected void b(final y.c.q q) {
        final int g = d.g;
        final double c = this.c(q);
        double f = 0.0;
    Label_0095:
        while (true) {
            f = this.f(q);
        Label_0018:
            while (f > c) {
                final x o = q.o();
                while (o.f()) {
                    final y.c.q e = o.e();
                    this.e(e);
                    final q e2 = this.e(e);
                    e2.e *= 1.0 + this.t;
                    o.g();
                    if (g != 0) {
                        continue Label_0018;
                    }
                    if (g != 0) {
                        break Label_0095;
                    }
                }
                continue Label_0095;
            }
            break;
        }
        final double n = (c - f) / (2 * q.c());
        double n2 = 0.0;
        final x o2 = q.o();
        while (o2.f()) {
            final q e3;
            final q q2 = e3 = this.e(o2.e());
            e3.b += n;
            final q q3 = q2;
            q3.c += n;
            n2 += q2.b + q2.c;
            o2.g();
            if (g != 0) {
                return;
            }
            if (g != 0) {
                break;
            }
        }
        this.a(q);
    }
    
    protected void a(final y.c.q q) {
        final int g = d.g;
        if (this.v) {
            this.d(q);
            if (g == 0) {
                return;
            }
        }
        if (this.B != null) {
            q.b(this.B);
            if (g == 0) {
                return;
            }
        }
        if (this.y == 0) {
            this.l(q);
            if (g == 0) {
                return;
            }
        }
        this.m(q);
    }
    
    static double a(final t t, final t t2) {
        return Math.atan2(t2.b - t.b, t2.a - t.a);
    }
    
    private void d(final y.c.q q) {
        final X x = (X)q.e();
        final t l = x.l(q);
        final t t = (q.b() > 0) ? x.l(q.g().c()) : null;
        q.b(new p(this, x, l, (t == null) ? 3.141592653589793 : a(l, t)));
    }
    
    private void l(final y.c.q q) {
        final int g = d.g;
        final y.c.d[] array = new y.c.d[q.c()];
        int n = 0;
        final y.c.e l = q.l();
        while (true) {
            while (l.f()) {
                array[n] = l.a();
                l.g();
                ++n;
                if (g != 0) {
                    int i = 0;
                    while (true) {
                        while (i < array.length) {
                            this.s.d(array[i]);
                            ++i;
                            if (g != 0) {
                                while (i < array.length) {
                                    final int n2 = array.length - 1 - i;
                                    if (n2 < i) {
                                        break;
                                    }
                                    this.s.e(array[i]);
                                    if (n2 == i) {
                                        break;
                                    }
                                    this.s.e(array[n2]);
                                    ++i;
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
                        i = 0;
                        continue;
                    }
                }
                if (g != 0) {
                    break;
                }
            }
            y.g.e.a(array, new s(this));
            continue;
        }
    }
    
    private void m(final y.c.q q) {
        final int g = d.g;
        final y.c.d[] array = new y.c.d[q.c()];
        int i = 0;
        final y.c.e l = q.l();
        while (true) {
            while (l.f()) {
                array[i] = l.a();
                l.g();
                ++i;
                if (g != 0) {
                    int j = 0;
                    while (true) {
                        while (j < array.length) {
                            this.s.d(array[j]);
                            ++j;
                            if (g != 0) {
                                while (true) {
                                    while (j < array.length) {
                                        this.s.e(array[j]);
                                        j += 2;
                                        if (g != 0) {
                                            if (i % 2 == 0) {
                                                --i;
                                            }
                                            while (i > 0) {
                                                this.s.e(array[i]);
                                                i -= 2;
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
                                    i = array.length - 1;
                                    continue;
                                }
                            }
                            if (g != 0) {
                                break;
                            }
                        }
                        j = 0;
                        continue;
                    }
                }
                if (g != 0) {
                    break;
                }
            }
            y.g.e.a(array, new r(this));
            continue;
        }
    }
    
    protected double c(final y.c.q q) {
        if (q.b() == 0) {
            return this.p;
        }
        if (q.c() == 2) {
            return Math.min(180.0, this.o);
        }
        return this.o;
    }
    
    protected double f(final y.c.q q) {
        final int g = d.g;
        double n = 0.0;
        this.k(q);
        final y.c.e l = q.l();
        double n4 = 0.0;
    Label_0225_Outer:
        while (l.f()) {
            final q e = this.e(l.a().d());
            final double n2 = -e.e;
            final double g2 = e.g;
            final D a = e.a;
            double n3 = 0.0;
            n4 = n3 + 1.0;
            if (g == 0) {
                double n5 = n4;
                y.c.p p = a.k();
                t t = (t)p.c();
                while (true) {
                    while (n5 > n3) {
                        final t t2 = t;
                        p = a.f(p);
                        t = (t)p.c();
                        n3 = (t.b() - t2.b()) / (t.a() - t2.a());
                        n5 = (t2.b() - g2) / (t2.a() - n2);
                        if (g != 0) {
                            t t3 = (t)p.c();
                        Label_0404:
                            while (true) {
                                while (((t)p.a().c()).a() == t3.a()) {
                                    p = p.a();
                                    t3 = (t)p.c();
                                    if (g == 0) {
                                        if (g != 0) {
                                            break;
                                        }
                                        continue Label_0225_Outer;
                                    }
                                    else {
                                        if (g != 0) {
                                            break Label_0225_Outer;
                                        }
                                        continue Label_0225_Outer;
                                    }
                                }
                                while (n5 < n3) {
                                    final t t4 = t3;
                                    p = a.e(p);
                                    t3 = (t)p.c();
                                    n3 = (t3.b() - t4.b()) / (t3.a() - t4.a());
                                    n5 = (t4.b() - g2) / (t4.a() - n2);
                                    if (g != 0) {
                                        continue Label_0404;
                                    }
                                    if (g != 0) {
                                        break;
                                    }
                                }
                                e.c = y.d.e.b(Math.atan(n5));
                                n += e.b + e.c;
                                l.g();
                                continue Label_0404;
                            }
                        }
                        if (g != 0) {
                            break;
                        }
                    }
                    e.b = -y.d.e.b(Math.atan(n5));
                    n3 = 0.0;
                    n5 = n3 - 1.0;
                    p = a.k();
                    continue;
                }
            }
            return n4;
        }
        return n4;
    }
    
    void a(final y.c.q q, final q q2) {
        this.A[q.d()] = q2;
    }
    
    void g(final y.c.q q) {
        final q e = this.e(q);
        final D a = new D();
        final double n = 2.0 * this.k(q);
        a.add(new t(0.0, 0.0));
        a.add(new t(0.0, n));
        a.add(new t(n, n));
        a.add(new t(n, 0.0));
        e.a = a;
        e.f = n / 2.0;
        e.g = n / 2.0;
    }
    
    void h(final y.c.q q) {
        final int g = d.g;
        if (q.c() == 0) {
            this.g(q);
            if (g == 0) {
                return;
            }
        }
        final q e = this.e(q);
        final double k = this.k(q);
        final D d = new D();
        d.add(new t(-k, -k));
        d.add(new t(-k, k));
        d.add(new t(k, -k));
        d.add(new t(k, k));
        final x o = q.o();
        while (o.f()) {
            d.a(this.e(o.e()).a);
            o.g();
            if (g != 0) {
                return;
            }
            if (g != 0) {
                break;
            }
        }
        final D a = y.d.e.a(d);
        double a2 = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        double a3 = -1.7976931348623157E308;
        double b2 = -1.7976931348623157E308;
        final C m = a.m();
        while (true) {
            while (m.f()) {
                final t t = (t)m.d();
                final double a4 = t.a();
                final double n = a2;
                if (g != 0) {
                    final D a5 = new D();
                    final C i = a.m();
                    while (true) {
                        while (i.f()) {
                            final t t2 = (t)i.d();
                            a5.add(new t(t2.a() - a2, t2.b() - b));
                            i.g();
                            if (g != 0) {
                                e.g = -b;
                                return;
                            }
                            if (g != 0) {
                                break;
                            }
                        }
                        e.a = a5;
                        e.f = -a2;
                        continue;
                    }
                }
                if (a4 < n) {
                    a2 = t.a();
                }
                if (t.a() > a3) {
                    a3 = t.a();
                }
                if (t.b() < b) {
                    b = t.b();
                }
                if (t.b() > b2) {
                    b2 = t.b();
                }
                m.g();
                if (g != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    void i(final y.c.q q) {
        final int g = d.g;
        if (q.c() == 0) {
            this.h(q);
            if (g == 0) {
                return;
            }
        }
        final x o = q.o();
        while (true) {
            while (o.f()) {
                this.i(o.e());
                o.g();
                if (g != 0) {
                    double n = 0.0;
                    final x o2 = q.o();
                Label_0318_Outer:
                    while (o2.f()) {
                        final q e = this.e(o2.e());
                        final double n2 = 180.0 - (360.0 - this.c(q)) / 2.0 - n - (e.c + e.d);
                        n += e.a();
                        final double a = y.d.e.a(n2);
                        final double sin = Math.sin(a);
                        final double cos = Math.cos(a);
                        if (g == 0) {
                            y.c.p p = e.a.k();
                            while (true) {
                                while (p != null) {
                                    final t t = (t)p.c();
                                    final double n3 = t.a() + e.e;
                                    final double n4 = t.b() - e.g;
                                    p.a(new t(n3 * cos - sin * n4, n3 * sin + cos * n4));
                                    p = p.a();
                                    if (g == 0) {
                                        if (g != 0) {
                                            break;
                                        }
                                        continue Label_0318_Outer;
                                    }
                                    else {
                                        if (g != 0) {
                                            break Label_0318_Outer;
                                        }
                                        continue Label_0318_Outer;
                                    }
                                }
                                final double n5 = e.f + e.e;
                                e.f = n5 * cos;
                                e.g = n5 * sin;
                                o2.g();
                                continue;
                            }
                        }
                        return;
                    }
                    this.h(q);
                    return;
                }
                if (g != 0) {
                    break;
                }
            }
            this.b(q);
            continue;
        }
    }
    
    void j(final y.c.q q) {
        final int g = d.g;
        final t l = this.s.l(q);
        double n = 0.0;
        if (q.b() > 0) {
            final t i = this.s.l(q.n().e());
            n = 3.141592653589793 + Math.atan2(i.b() - l.b(), i.a() - l.a());
        }
        final x o = q.o();
        while (o.f()) {
            final y.c.q e = o.e();
            final q e2 = this.e(e);
            if (n != 0.0) {
                final double cos = Math.cos(n);
                final double sin = Math.sin(n);
                final double f = e2.f * cos - sin * e2.g;
                final double g2 = e2.f * sin + cos * e2.g;
                e2.f = f;
                e2.g = g2;
            }
            this.s.a(e, l.a() + e2.f, l.b() + e2.g);
            this.j(e);
            o.g();
            if (g != 0) {
                break;
            }
        }
    }
    
    double k(final y.c.q q) {
        if (this.r) {
            return (this.s.p(q) + this.s.q(q)) / 4.0 + 0.5 * this.w;
        }
        return 1.41 * (Math.max(this.s.p(q), this.s.q(q)) / 2.0) + 0.5 * this.w;
    }
    
    static A a(final o o) {
        return o.x;
    }
    
    static double u() {
        return o.n;
    }
    
    static {
        o.n = 1000.0;
    }
}
