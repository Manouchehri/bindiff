package y.f.i;

import y.g.*;
import y.d.*;
import y.c.*;
import java.util.*;

class S
{
    private Map a;
    private List b;
    private List c;
    private double d;
    private double e;
    private double f;
    private double g;
    private Map h;
    private List i;
    private Map j;
    private Set k;
    private c l;
    private c m;
    private double n;
    private double o;
    private boolean p;
    private double q;
    private double r;
    private double s;
    private double t;
    private Comparator u;
    private double v;
    private double w;
    private Comparator x;
    private U[] y;
    private U[] z;
    private D A;
    private D B;
    private double C;
    private double D;
    
    public void a(final double v) {
        this.v = v;
    }
    
    public void b(final double w) {
        this.w = w;
    }
    
    public S() {
        this.e = -1.7976931348623157E308;
        this.f = Double.MAX_VALUE;
        this.g = 10.0;
        this.h = new HashMap();
        this.i = new ArrayList();
        this.j = new HashMap();
        this.k = new HashSet();
        this.o = 10.0;
        this.p = true;
        this.q = 1.0;
        this.r = 0.5;
        this.a = new HashMap(11);
        this.b = new ArrayList(62);
        this.c = new ArrayList(62);
    }
    
    public void a(final Comparator u) {
        this.u = u;
    }
    
    public void a() {
        this.s = 0.0;
        this.k.clear();
        this.j.clear();
        this.i.clear();
        this.h.clear();
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.t = 0.0;
        this.d = -1.0;
    }
    
    public void c(final double n) {
        this.n = n;
    }
    
    public void a(final c l) {
        this.l = l;
    }
    
    public void b(final c m) {
        this.m = m;
    }
    
    public U a(final Object o, final double n, final double n2, final double n3, final boolean b, final double n4, final boolean b2, final boolean b3) {
        final U a = this.a(o, n, n2, n3, b, n4, b2);
        a.a(b3);
        return a;
    }
    
    public U a(final Object o, final double n, final double n2, final double n3, final boolean b, final double n4, final boolean b2) {
        final int f = y.f.i.v.f;
        U u = null;
        Label_0052: {
            if (n3 > n4) {
                u = U.a(o, n, n2, n4, b2, n3, b);
                if (f == 0) {
                    break Label_0052;
                }
            }
            u = U.a(o, n, n2, n3, b, n4, b2);
        }
        this.a.put(o, u);
        Label_0103: {
            if (U.a(u) == 3) {
                this.b.add(u);
                if (f == 0) {
                    break Label_0103;
                }
            }
            this.c.add(u);
        }
        this.k.add(o);
        return u;
    }
    
    public void b() {
        final int f = y.f.i.v.f;
        if (this.h.size() > 0) {
            this.f();
        }
        this.y = new U[this.b.size()];
        this.z = new U[this.c.size()];
        this.C = Double.MAX_VALUE;
        this.D = -1.7976931348623157E308;
        int i = this.b.size() - 1;
        while (true) {
            while (i >= 0) {
                final U u = this.b.get(i);
                this.D = Math.max(this.D, U.b(u));
                this.C = Math.min(this.C, U.c(u));
                this.y[i] = u;
                --i;
                if (f != 0) {
                    while (i >= 0) {
                        final U u2 = this.c.get(i);
                        this.D = Math.max(this.D, U.b(u2));
                        this.C = Math.min(this.C, U.c(u2));
                        this.z[i] = u2;
                        --i;
                        if (f != 0) {
                            return;
                        }
                        if (f != 0) {
                            break;
                        }
                    }
                    this.x = new V(this.u);
                    y.g.e.a(this.y, this.x);
                    y.g.e.a(this.z, this.x);
                    this.e();
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            i = this.c.size() - 1;
            continue;
        }
    }
    
    private void e() {
        final int f = y.f.i.v.f;
        this.A = new D();
        Label_0295: {
            Label_0235: {
                if (this.l != null) {
                    if (this.l.b(this.l.e()) > this.C) {
                        this.A.a(new T(this.C, -this.f, 0.0, this.t, false));
                    }
                    d d = this.l.e();
                    while (true) {
                        while (d != null) {
                            final double a = this.l.a(d);
                            final double b = this.l.b(d);
                            final double n = dcmpl(a, Double.MAX_VALUE);
                            if (f == 0) {
                                double n2 = 0.0;
                                Label_0137: {
                                    if (n == 0) {
                                        n2 = -this.f;
                                        if (f == 0) {
                                            break Label_0137;
                                        }
                                    }
                                    n2 = -a;
                                }
                                this.A.b(new T(b, n2, 0.0, this.t, false));
                                d = this.l.e(d);
                                if (f != 0) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (n >= 0) {
                                    break Label_0295;
                                }
                                this.A.b(new T(this.D, -this.f, 0.0, this.t, false));
                                if (f != 0) {
                                    break Label_0235;
                                }
                                break Label_0295;
                            }
                        }
                        final double n3 = dcmpg(this.l.b(this.l.f()), this.D);
                        continue;
                    }
                }
            }
            this.A.a(new T(this.C, -this.f, 0.0, this.t, false));
            this.A.b(new T(this.D, -this.f, 0.0, this.t, false));
        }
        this.B = new D();
        Label_0521: {
            if (this.m != null) {
                if (this.m.b(this.m.e()) > this.C) {
                    this.B.a(new T(this.C, this.e, 0.0, this.t, false));
                }
                d d2 = this.m.e();
                while (true) {
                    while (d2 != null) {
                        final double a2 = this.m.a(d2);
                        final double b2 = this.m.b(d2);
                        final double n4 = dcmpl(a2, -1.7976931348623157E308);
                        if (f == 0) {
                            double e = 0.0;
                            Label_0424: {
                                if (n4 == 0) {
                                    e = this.e;
                                    if (f == 0) {
                                        break Label_0424;
                                    }
                                }
                                e = a2;
                            }
                            this.B.b(new T(b2, e, 0.0, this.t, false));
                            d2 = this.m.e(d2);
                            if (f != 0) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (n4 >= 0) {
                                return;
                            }
                            this.B.b(new T(this.D, this.e, 0.0, this.t, true));
                            if (f != 0) {
                                break Label_0521;
                            }
                            return;
                        }
                    }
                    final double n5 = dcmpg(this.m.b(this.m.f()), this.D);
                    continue;
                }
            }
        }
        this.B.a(new T(this.C, this.e, 0.0, this.t, true));
        this.B.b(new T(this.D, this.e, 0.0, this.t, true));
    }
    
    private double b(final D d, final D d2) {
        final int f = y.f.i.v.f;
        p p2 = d.k();
        p p3 = d2.k();
        double max = -1.7976931348623157E308;
        while (p2 != null && p3 != null) {
            final T t = (T)p2.c();
            final T t2 = (T)p3.c();
            max = Math.max(max, Math.max(t.e, t2.e) - (-(t2.c + t2.d) - (t.c + t.d)));
            if (p2.a() != null && p3.a() != null) {
                if (((T)p2.a().c()).b < ((T)p3.a().c()).b) {
                    p2 = p2.a();
                    if (f == 0) {
                        continue;
                    }
                }
                p3 = p3.a();
                if (f == 0) {
                    continue;
                }
            }
            if (p3.a() != null) {
                p3 = p3.a();
                if (f == 0) {
                    continue;
                }
            }
            if (p2.a() == null) {
                break;
            }
            p2 = p2.a();
            if (f != 0) {
                break;
            }
        }
        return -max;
    }
    
    public double a(final D d, final D d2) {
        double max = Math.max(this.s, -this.b(d, d2));
        if (max == -1.7976931348623157E308) {
            max = 0.0;
        }
        return max;
    }
    
    public void c() {
        final int f = y.f.i.v.f;
        this.b();
        int i = 0;
        while (true) {
            while (i < this.y.length) {
                final U u = this.y[i];
                final int b;
                final int n = b = (u.b() ? 1 : 0);
                if (f != 0) {
                    int j = b;
                    while (true) {
                        while (j < this.z.length) {
                            final S s = this;
                            if (f != 0) {
                                final D a = s.a(this.A);
                                final D a2 = this.a(this.B);
                                int k = 0;
                                while (true) {
                                    while (k < this.z.length) {
                                        final U u2 = this.z[k];
                                        final int b2;
                                        final int n2 = b2 = (u2.b() ? 1 : 0);
                                        if (f != 0) {
                                            int l = b2;
                                            while (true) {
                                                while (l >= 0) {
                                                    final U u3 = this.y[l];
                                                    final int b3;
                                                    final int n3 = b3 = (u3.b() ? 1 : 0);
                                                    if (f != 0) {
                                                        int n4 = b3;
                                                        while (true) {
                                                            while (n4 < this.y.length) {
                                                                final U u4 = this.y[n4];
                                                                final int b4;
                                                                final int n5 = b4 = (u4.b() ? 1 : 0);
                                                                if (f != 0) {
                                                                    int n6 = b4;
                                                                    while (n6 >= 0) {
                                                                        final U u5 = this.z[n6];
                                                                        if (f != 0) {
                                                                            return;
                                                                        }
                                                                        if (u5.b()) {
                                                                            final double e = u5.e();
                                                                            final double f2 = u5.f();
                                                                            u5.c(-e);
                                                                            u5.b(-f2);
                                                                            final double d = u5.d();
                                                                            this.a(a, u5, d, true);
                                                                            u5.a(-u5.d());
                                                                            u5.a((u5.d() + d) * 0.5);
                                                                            u5.b(e);
                                                                            u5.c(f2);
                                                                        }
                                                                        --n6;
                                                                        if (f != 0) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    this.s = Math.max(this.s, this.a(this.B, a));
                                                                    return;
                                                                }
                                                                if (n5 != 0) {
                                                                    final double e2 = u4.e();
                                                                    final double f3 = u4.f();
                                                                    u4.c(-e2);
                                                                    u4.b(-f3);
                                                                    final double d2 = u4.d();
                                                                    this.a(a, u4, d2, true);
                                                                    u4.a(-u4.d());
                                                                    u4.a((U.d(u4) + d2) * 0.5);
                                                                    u4.b(e2);
                                                                    u4.c(f3);
                                                                }
                                                                ++n4;
                                                                if (f != 0) {
                                                                    break;
                                                                }
                                                            }
                                                            int b4 = this.z.length - 1;
                                                            continue;
                                                        }
                                                    }
                                                    if (n3 != 0) {
                                                        this.a(a2, u3, 0.0, false);
                                                    }
                                                    --l;
                                                    if (f != 0) {
                                                        break;
                                                    }
                                                }
                                                this.s = Math.max(this.s, this.a(a2, this.A));
                                                int b3 = 0;
                                                continue;
                                            }
                                        }
                                        if (n2 != 0) {
                                            this.a(a2, u2, 0.0, false);
                                        }
                                        ++k;
                                        if (f != 0) {
                                            break;
                                        }
                                    }
                                    int b2 = this.y.length - 1;
                                    continue;
                                }
                            }
                            final U u6 = this.z[j];
                            if (u6.a() == 0 && !u6.b()) {
                                this.a(this.B, u6, 0.0, false);
                            }
                            ++j;
                            if (f != 0) {
                                break;
                            }
                        }
                        final S s = this;
                        continue;
                    }
                }
                if (n == 0) {
                    final double e3 = u.e();
                    final double f4 = u.f();
                    u.c(-e3);
                    u.b(-f4);
                    this.a(this.A, u, 0.0, false);
                    u.a(-u.d());
                    u.b(e3);
                    u.c(f4);
                }
                ++i;
                if (f != 0) {
                    break;
                }
            }
            int b = 0;
            continue;
        }
    }
    
    private D a(final D d) {
        final int f = y.f.i.v.f;
        final D d2 = new D(d);
        p p = d2.k();
        while (p != null) {
            p.a(((T)p.c()).clone());
            p = p.a();
            if (f != 0) {
                break;
            }
        }
        return d2;
    }
    
    public double d() {
        return this.s;
    }
    
    private void f() {
        final int i = y.f.i.v.f;
        int n = this.i.size() - 1;
        do {
            double n2 = 0.0;
            Label_0017: {
                n2 = n;
            }
            Label_0018:
            while (n2 >= 0) {
                double c = Double.MAX_VALUE;
                double b = -1.7976931348623157E308;
                double max = -1.7976931348623157E308;
                double min = Double.MAX_VALUE;
                boolean b2 = true;
                boolean b3 = true;
                final D d = this.i.get(n);
                double max2 = 0.0;
                double max3 = 0.0;
                p p = d.k();
                while (p != null) {
                    final U u = (U)p.c();
                    max = Math.max(max, u.e());
                    min = Math.min(min, u.f());
                    max3 = Math.max(max3, u.a);
                    max2 = Math.max(max2, U.e(u));
                    final double n3 = n2 = dcmpg(U.c(u), c);
                    if (i != 0) {
                        continue Label_0018;
                    }
                    if (n3 < 0) {
                        c = U.c(u);
                        final byte a = u.a();
                        b2 = (a == 2 || a == 0);
                    }
                    if (U.b(u) > b) {
                        b = U.b(u);
                        final byte a2 = u.a();
                        b3 = (a2 == 1 || a2 == 0);
                    }
                    this.k.add(u.c());
                    p = p.a();
                    if (i != 0) {
                        break;
                    }
                }
                final U a3 = U.a(d, max3 * 2.0, max2, c, b2, b, b3);
                a3.b(max);
                a3.c(min);
                this.a.put(d, a3);
                Label_0341: {
                    if (U.a(a3) == 3) {
                        this.b.add(a3);
                        if (i == 0) {
                            break Label_0341;
                        }
                    }
                    this.c.add(a3);
                }
                --n;
                continue Label_0017;
            }
            break;
        } while (i == 0);
    }
    
    public double a(final Object o) {
        final double d = this.b(o).d();
        if (Double.isNaN(d)) {
            return this.n;
        }
        return d;
    }
    
    private void a(final D d, final U u, final double n, final boolean b) {
        final int f = y.f.i.v.f;
        if (this.p && Math.abs(U.b(u) - U.c(u)) < this.r) {
            u.a(Double.NaN);
            return;
        }
        final byte a = u.a();
        final T t = new T(U.c(u), 0.0, u.a, U.e(u), a == 0 || a == 2);
        final T t2 = new T(U.b(u), 0.0, u.a, U.e(u), a == 1 || a == 0);
        p p4 = d.k();
        T t3 = (T)p4.c();
        double n2 = t3.c + t3.d + Math.max(t3.e, U.e(u));
        T t4 = t3;
        while (true) {
            while (U.c(u) - u.a > t3.b + t3.d) {
                n2 = t3.c + t3.d + Math.max(t3.e, U.e(u));
                t4 = t3;
                p4 = p4.a();
                t3 = (T)p4.c();
                if (f != 0) {
                    while (p4 != null && U.c(u) > t3.b) {
                        n2 = Math.max(n2, t3.c + t3.d + Math.max(t3.e, U.e(u)));
                        t4 = t3;
                        p4 = p4.a();
                        t3 = (T)p4.c();
                        if (f != 0) {
                            break;
                        }
                    }
                    final p a2 = d.a(t, p4);
                    while (true) {
                        while (U.b(u) >= t3.b) {
                            t4 = t3;
                            n2 = Math.max(t3.c + t3.d + Math.max(t3.e, U.e(u)), n2);
                            d.h(p4);
                            final p a3;
                            p4 = (a3 = p4.a());
                            if (f != 0) {
                                final double n3;
                                Label_0737: {
                                    if (a3 != null) {
                                        n3 = dcmpl(U.b(u) + u.a, t3.b - t3.d);
                                        if (f != 0) {
                                            break Label_0737;
                                        }
                                        if (n3 > 0) {
                                            n2 = Math.max(t3.c + t3.d + Math.max(t3.e, U.e(u)), n2);
                                            p4 = p4.a();
                                            if (p4 != null) {
                                                t3 = (T)p4.c();
                                                if (f == 0) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if (a2.b() != null) {
                                        final T t5 = (T)a2.b().c();
                                        if (t5.b + this.q > U.c(u) && t5.a != t.a && a2.b().b() != null) {
                                            final T t6 = (T)a2.b().b().c();
                                            n2 = Math.max(n2, t6.c + t6.d + Math.max(t6.e, U.e(u)));
                                        }
                                    }
                                    if (a2.a() != null) {
                                        final T t7 = (T)a2.a().c();
                                        if (t7.b - this.q < U.b(u) && t7.a != t2.a) {
                                            n2 = Math.max(n2, t7.c + t7.d + Math.max(t7.e, U.e(u)));
                                        }
                                    }
                                    final double n4 = dcmpl(this.v, 0.0);
                                }
                                if (n3 > 0) {
                                    n2 = Math.ceil((n2 - this.w) / this.v) * this.v + this.w;
                                    if (b && Math.abs(((n2 + n) * 0.5 - this.w) % this.v) > 0.0) {
                                        n2 += this.v;
                                    }
                                }
                                final double n5 = n2 + u.a;
                                a2.a(new T(U.c(u), n5, u.a * 2.0, U.e(u), U.a(u) == 2 || U.a(u) == 0));
                                d.b(new T(U.b(u), t4.c, t4.d * 2.0, t4.e, U.a(u) == 0 || U.a(u) == 1), a2);
                                u.a(n5);
                                if (n5 - u.f() > this.s) {
                                    this.s = Math.max(this.s, n5 - u.f());
                                }
                                this.d = Math.max(this.d, n5);
                                return;
                            }
                            if (a3 == null) {
                                break;
                            }
                            t3 = (T)p4.c();
                            if (f != 0) {
                                break;
                            }
                        }
                        continue;
                    }
                }
                if (f != 0) {
                    break;
                }
            }
            n2 = Math.max(n2, u.e());
            continue;
        }
    }
    
    private U b(final Object o) {
        final U u = this.a.get(o);
        if (u != null) {
            return u;
        }
        final Object value = this.j.get(o);
        if (value != null) {
            return (U)this.a.get(value);
        }
        throw new IllegalArgumentException("No such key registered!");
    }
}
