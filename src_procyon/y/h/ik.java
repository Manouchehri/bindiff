package y.h;

import y.c.*;
import y.f.*;
import y.d.*;

class ik
{
    private double a;
    private boolean b;
    private boolean c;
    private double d;
    private byte e;
    private boolean f;
    private static final z g;
    
    public ik() {
        this.a = 5.0;
        this.b = true;
        this.c = false;
        this.d = 0.0;
        this.f = false;
        this.e = 0;
    }
    
    public byte a() {
        return this.e;
    }
    
    public void a(final byte e) {
        this.e = e;
    }
    
    public double b() {
        return this.a;
    }
    
    public void a(final double a) {
        this.a = a;
    }
    
    public boolean c() {
        return this.b;
    }
    
    public void a(final boolean b) {
        this.b = b;
    }
    
    public boolean d() {
        return this.c;
    }
    
    public void b(final boolean c) {
        this.c = c;
    }
    
    public double e() {
        return this.d;
    }
    
    public void b(final double d) {
        this.d = d;
    }
    
    public boolean f() {
        return this.f;
    }
    
    public void c(final boolean f) {
        this.f = f;
    }
    
    public n a(final q q, final I i, final am am, final am am2, final gv gv) {
        final boolean z = fj.z;
        final int a = gv.a();
        final double b = gv.b();
        final n n = new n(new t(0.0, 0.0), q);
        n.a(6.283185307179586 - this.d);
        final v a2 = ae.a(i, am, am2, 0.0);
        if (a2.h() < 2 || (a2.h() == 2 && t.a(a2.c(), a2.d()) < 1.0E-4)) {
            Label_0179: {
                if (a2.h() < 2) {
                    final y h = n.h();
                    n.e(am.getX() + h.a * 0.5, am.getY() + h.b * 0.5);
                    if (!z) {
                        break Label_0179;
                    }
                }
                final t c = a2.c();
                n.e(c.a, c.b);
            }
            if (this.d()) {
                ae.b(n);
            }
            return n;
        }
        int n2 = 0;
        Label_0235: {
            if (a < 0) {
                n2 = Math.max(0, a2.h() - 1 + a);
                if (!z) {
                    break Label_0235;
                }
            }
            n2 = Math.min(a2.h() - 2, a);
        }
        m a3 = a2.a(n2);
        if (a3 == null) {
            final y h2 = n.h();
            n.e(am.getX() + h2.a * 0.5, am.getY() + h2.b * 0.5);
            if (this.d()) {
                ae.b(n);
            }
            return n;
        }
        final t c2 = a3.c();
        t d = a3.d();
        if (a3.g() == 0.0) {
            final double n3 = am.getX() + am.getWidth() * 0.5 + i.getSourcePoint().a - (am2.getX() + am2.getWidth() * 0.5 + i.getTargetPoint().a);
            final double n4 = am.getY() + am.getHeight() * 0.5 + i.getSourcePoint().b - (am2.getY() + am2.getHeight() * 0.5 + i.getTargetPoint().b);
            Label_0548: {
                if (n3 == 0.0 && n4 == 0.0) {
                    d = new t(c2.a + 1.0E-6, c2.b);
                    if (!z) {
                        break Label_0548;
                    }
                }
                final double sqrt = Math.sqrt(n3 * n3 + n4 * n4);
                d = new t(c2.a + 1.0E-6 * n3 / sqrt, c2.b + 1.0E-6 * n4 / sqrt);
            }
            a3 = new m(c2, d);
        }
        if (this.b) {
            n.a(c(y.d.z.d(a3.i(), ik.g) - this.d));
        }
        final double abs = Math.abs(gv.c());
        final n n5 = new n(n);
        this.a(n5, a3, c2, abs);
        if (n2 == 0 && this.a(am, n5)) {
            this.b(n5, a3, am, abs);
        }
        final n n6 = new n(n);
        this.a(n6, a3, d, abs);
        if (n2 >= a2.h() - 2 && this.a(am2, n6)) {
            this.a(n6, a3, am2, abs);
        }
        if (t.a(n5.a(), n6.a()) < 1.0E-4) {
            final z j = a3.i();
            j.c();
            n6.d(j.a(), j.b());
        }
        t t = null;
        Label_0959: {
            if (0.0 > b || b > 1.0) {
                final double n7 = n6.b() - n5.b();
                final double n8 = n6.c() - n5.c();
                final double sqrt2 = Math.sqrt(n7 * n7 + n8 * n8);
                final double n9 = (sqrt2 != 0.0) ? (b / sqrt2) : 0.0;
                double n10 = 0.0;
                double n11 = 0.0;
                Label_0894: {
                    if (b < 0.0) {
                        n10 = n5.b() + n9 * n7;
                        n11 = n5.c() + n9 * n8;
                        if (!z) {
                            break Label_0894;
                        }
                    }
                    n10 = n6.b() + n9 * n7;
                    n11 = n6.c() + n9 * n8;
                }
                t = new t(n10, n11);
                if (!z) {
                    break Label_0959;
                }
            }
            t = new t(n5.b() * (1.0 - b) + n6.b() * b, n5.c() * (1.0 - b) + n6.c() * b);
        }
        n.a(t);
        if (this.d()) {
            ae.b(n);
        }
        return n;
    }
    
    private gv g() {
        return this.a(0, 0.0);
    }
    
    private gv a(final int n, final double n2) {
        return new gv(n, n2, this.b(), this.f(), this.a(), this.e());
    }
    
    public D a(final C c, final I i, final am am, final am am2, final Object o) {
        final boolean z = fj.z;
        final D d = new D();
        final v a = ae.a(i, am, am2, 0.0);
        if (a.h() < 2 || (a.h() == 2 && a.a(0).g() < 1.0E-4)) {
            final n n = new n(c.getOrientedBox());
            Label_0145: {
                if (a.h() < 2) {
                    n.e(am.getX() + n.e() * 0.5, am.getY() - n.f() * 0.5);
                    if (!z) {
                        break Label_0145;
                    }
                }
                n.e(a.c().a, a.c().b);
            }
            if (this.d()) {
                ae.b(n);
            }
            d.add(new B(n, this.g(), c, false));
            return d;
        }
        final double n2 = (c.getModelParameter() == null) ? this.b() : ((gv)o).c();
        final n[] array = new n[a.h() - 1];
        final n[] array2 = new n[a.h() - 1];
        int j = 0;
        while (true) {
            while (j < a.h() - 1) {
                array[j] = new n(0.0, 0.0, 0.0, 0.0);
                array2[j] = new n(0.0, 0.0, 0.0, 0.0);
                this.a(a, j, c.getOrientedBox().d(), i, am, am2, array[j], array2[j], n2);
                final double n3 = dcmpg(t.a(array[j].a(), array2[j].a()), 1.0E-4);
                if (z) {
                    double n4 = n3;
                    while (n4 < a.h() - 1) {
                        final t k = array[n4].k();
                        final t l = array2[n4].k();
                        final double n5 = l.a() - k.a();
                        final double n6 = l.b() - k.b();
                        final int n7 = (int)((n4 > (a.h() - 2) / 2) ? (n4 + 1 - a.h()) : n4);
                        final boolean b = a.h() == 2;
                        final double[] a2 = this.a((int)n4, a, array, array2);
                        Label_0623: {
                            if (a2[0] > 0.0) {
                                d.add(new B(array[n4].f(n5 * a2[0], n6 * a2[0]), this.a(n7, a2[0]), c));
                                if (!z) {
                                    break Label_0623;
                                }
                            }
                            d.add(new B(array[n4], this.a(n7, 0.0), c));
                        }
                        final int n8 = b ? -1 : n7;
                        Label_0726: {
                            if (a2[1] < 1.0) {
                                d.add(new B(array[n4].f(n5 * a2[1], n6 * a2[1]), this.a(n8, a2[1]), c));
                                if (!z) {
                                    break Label_0726;
                                }
                            }
                            d.add(new B(array2[n4], this.a(n8, 1.0), c));
                        }
                        if (a2[0] < 0.5 && a2[1] > 0.5) {
                            final n n9 = new n(array[n4]);
                            n9.b(t.c(array2[n4].k(), k));
                            if (this.d()) {
                                ae.b(n9);
                            }
                            d.add(new B(n9, this.a(n7, 0.5), c));
                        }
                        ++n4;
                        if (z) {
                            break;
                        }
                    }
                    return d;
                }
                if (n3 < 0) {
                    final z m = a.a(j).i();
                    m.c();
                    array2[j].d(m.a(), m.b());
                }
                if (this.d()) {
                    ae.b(array[j]);
                    ae.b(array2[j]);
                }
                ++j;
                if (z) {
                    break;
                }
            }
            continue;
        }
    }
    
    private static double c(double n) {
        final boolean z = fj.z;
        if (n < 0.0) {
            n += 6.283185307179586;
        }
        double n2 = 0.0;
        while (n > 6.283185307179586) {
            n2 = n - 6.283185307179586;
            if (z) {
                return n2;
            }
            n = n2;
            if (z) {
                break;
            }
        }
        return n2;
    }
    
    private static byte a(final m m) {
        final double d = z.d(m.i(), ik.g);
        if (d >= 0.7853981633974483 && d < 2.356194490192345) {
            return 0;
        }
        if (d >= 2.356194490192345 && d < 3.9269908169872414) {
            return 2;
        }
        if (d >= 3.9269908169872414 && d < 5.497787143782138) {
            return 1;
        }
        return 3;
    }
    
    private static byte b(final m m) {
        final double d = z.d(m.i(), ik.g);
        if (d >= 0.7853981633974483 && d < 2.356194490192345) {
            if (d <= 1.5707963267948966) {
                return 3;
            }
            return 2;
        }
        else if (d >= 2.356194490192345 && d < 3.9269908169872414) {
            if (d <= 3.141592653589793) {
                return 0;
            }
            return 1;
        }
        else if (d >= 3.9269908169872414 && d < 5.497787143782138) {
            if (d <= 4.71238898038469) {
                return 2;
            }
            return 3;
        }
        else {
            if (d <= 3.141592653589793) {
                return 0;
            }
            return 1;
        }
    }
    
    private void a(final n n, final m m, final t t, final double n2) {
        final boolean z = fj.z;
        if (0 == this.a()) {
            n.e(t.a, t.b);
            if (!z) {
                return;
            }
        }
        z c = y.d.z.c(m.i());
        if (2 == this.a()) {
            c = new z(-c.a(), -c.b());
        }
        c.b(Math.abs(n2) + n.e() + n.f());
        final t a = y.d.z.a(t, c);
        n.e(a.a, a.b);
        double n3 = Double.MAX_VALUE;
        Label_0183: {
            if (this.f) {
                n3 = b(m, n.k());
                if (!z) {
                    break Label_0183;
                }
            }
            final t[] a2 = n.a(n);
            int i = 0;
            while (i < a2.length) {
                n3 = Math.min(n3, b(m, a2[i]));
                ++i;
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
        }
        final z z2 = new z(-c.a(), -c.b());
        z2.c();
        z2.b(n3 - Math.abs(n2));
        final t a3 = y.d.z.a(a, z2);
        n.e(a3.a, a3.b);
    }
    
    private void a(final n n, final m m, final am am, final double n2) {
        this.a(n, m.d(), m.c(), am, false, n2);
    }
    
    private void b(final n n, final m m, final am am, final double n2) {
        this.a(n, m.c(), m.d(), am, true, n2);
    }
    
    private void a(final n n, final t t, final t t2, final am am, final boolean b, final double n2) {
        final y y = new y(am.getX(), am.getY(), am.getWidth(), am.getHeight());
        final m m = new m(t, t2);
        final byte a = a(m);
        final t a2 = this.a(a, m, n, am, b, n2);
        n.a(a2);
        final double a3 = a(y, n);
        final y h = n.h();
        if (Math.abs(t.a - t2.a) > 1.0E-4 && Math.abs(t.b - t2.b) > 1.0E-4 && (a3 < 2.5 || a3 > 6.0) && (((a == 0 || a == 1) && (t2.a < y.c() - 5.0 - h.a * 0.5 || t2.a > y.c() + y.a() + 5.0 + h.a * 0.5)) || ((a == 2 || a == 3) && (t2.b < y.d() - 5.0 - h.b * 0.5 || t2.b > y.d() + y.b() + 5.0 + h.b * 0.5)))) {
            n.a(this.a(b(m), m, n, am, b, n2));
            final double a4 = a(y, n);
            if (a4 < 2.5 || (a4 > a3 && a3 > 2.5)) {
                n.a(a2);
            }
        }
    }
    
    private static double a(final y y, final n n) {
        return hB.a(y, n);
    }
    
    private t a(final byte b, final m m, final n n, final am am, final boolean b2, final double n2) {
        final boolean z = fj.z;
        final boolean b3 = 0 == this.a();
        final n n3 = new n(n);
        final t c = m.c();
        final t d = m.d();
        final y h = n3.h();
        Label_1027: {
            if (b == 0) {
                final boolean b4 = (b2 && this.a() == 2) || (!b2 && this.a() == 1);
                double b5 = am.getY() - 5.0 - h.b() * 0.5;
                if (b5 < d.b) {
                    b5 = d.b;
                }
                n3.e(b4 ? (Math.min(c.a, d.a) - h.a) : (Math.max(c.a, d.a) + h.a), b5);
                final t t = (b3 || this.f) ? n3.k() : a(n.a(n3), m);
                n3.d(a(m, t, 1.0, 0.0).a - t.a, 0.0);
                if (b3) {
                    break Label_1027;
                }
                double a = a(m, new z(1.0, 0.0), Math.abs(n2));
                if (b4) {
                    a = -a;
                }
                n3.d(a, 0.0);
                if (!z) {
                    break Label_1027;
                }
            }
            if (b == 1) {
                final boolean b6 = (b2 && this.a() == 1) || (!b2 && this.a() == 2);
                double b7 = am.getY() + am.getHeight() + 5.0 + h.b() * 0.5;
                if (b7 > d.b) {
                    b7 = d.b;
                }
                n3.e(b6 ? (Math.min(c.a, d.a) - h.a) : (Math.max(c.a, d.a) + h.a), b7);
                final t t2 = (b3 || this.f) ? n3.k() : a(n.a(n3), m);
                n3.d(a(m, t2, 1.0, 0.0).a - t2.a, 0.0);
                if (b3) {
                    break Label_1027;
                }
                double a2 = a(m, new z(1.0, 0.0), Math.abs(n2));
                if (!b6) {
                    a2 = -a2;
                }
                n3.d(a2, 0.0);
                if (!z) {
                    break Label_1027;
                }
            }
            if (b == 2) {
                final boolean b8 = (b2 && this.a() == 2) || (!b2 && this.a() == 1);
                double a3 = am.getX() - 5.0 - h.a() * 0.5;
                if (a3 < d.a) {
                    a3 = d.a;
                }
                n3.e(a3, b8 ? (Math.max(c.b, d.b) + h.b) : (Math.min(c.b, d.b) - h.b));
                final t t3 = (b3 || this.f) ? n3.k() : a(n.a(n3), m);
                n3.d(0.0, a(m, t3, 0.0, 1.0).b - t3.b);
                if (b3) {
                    break Label_1027;
                }
                double a4 = a(m, new z(0.0, 1.0), Math.abs(n2));
                if (b8) {
                    a4 = -a4;
                }
                n3.d(0.0, a4);
                if (!z) {
                    break Label_1027;
                }
            }
            if (b == 3) {
                final boolean b9 = (b2 && this.a() == 1) || (!b2 && this.a() == 2);
                double a5 = am.getX() + am.getWidth() + 5.0 + h.a() * 0.5;
                if (a5 > d.a) {
                    a5 = d.a;
                }
                n3.e(a5, b9 ? (Math.max(c.b, d.b) + h.b) : (Math.min(c.b, d.b) - h.b));
                final t t4 = (b3 || this.f) ? n3.k() : a(n.a(n3), m);
                n3.d(0.0, a(m, t4, 0.0, 1.0).b - t4.b);
                if (!b3) {
                    double a6 = a(m, new z(0.0, 1.0), Math.abs(n2));
                    if (!b9) {
                        a6 = -a6;
                    }
                    n3.d(0.0, a6);
                }
            }
        }
        if (t.a(n3.k(), c) > t.a(n3.k(), d)) {
            final t t5 = new t((c.a + d.a) / 2.0, (c.b + d.b) / 2.0);
            if (b2) {
                this.a(n3, m, t5, n2);
                if (!z) {
                    return n3.a();
                }
            }
            this.a(n3, new m(m.d(), m.c()), t5, n2);
        }
        return n3.a();
    }
    
    private static double a(final m m, final z z, final double n) {
        double d = z.d(m.i(), z);
        if (d == 1.5707963267948966) {
            return n;
        }
        if (d > 1.5707963267948966) {
            d = 3.141592653589793 - d;
        }
        return n / Math.sin(d);
    }
    
    private static t a(final t[] array, final m m) {
        return array[b(array, m)];
    }
    
    private static int b(final t[] array, final m m) {
        final boolean z = fj.z;
        double n = Double.MAX_VALUE;
        int i = 0;
        double n2 = 0.0;
        while (i < array.length) {
            final double b = b(m, array[i]);
            n2 = dcmpg(b, n);
            if (z) {
                return (int)n2;
            }
            if (n2 < 0) {
                n = b;
            }
            ++i;
            if (z) {
                break;
            }
        }
        return (int)n2;
    }
    
    private static double a(final m m, final n n) {
        final boolean z = fj.z;
        final t[] a = n.a(n);
        final double a2 = a(m, a[0]);
        if (a2 == 0.0) {
            return 0.0;
        }
        int i = 1;
        while (true) {
            while (i < a.length) {
                final double a3;
                final double n2 = a3 = a(m, a[i]);
                if (z) {
                    double n3 = a3;
                    int j = 0;
                    double min = 0.0;
                    while (j < a.length) {
                        min = Math.min(n3, b(m, a[j]));
                        if (z) {
                            return min;
                        }
                        n3 = min;
                        ++j;
                        if (z) {
                            break;
                        }
                    }
                    return min;
                }
                if (a3 == 0.0 || n2 != a2) {
                    return 0.0;
                }
                ++i;
                if (z) {
                    break;
                }
            }
            continue;
        }
    }
    
    private static double a(final m m, final t t) {
        final t c = m.c();
        final t d = m.d();
        final double n = (d.a() - c.a()) * (t.b() - c.b()) - (d.b() - c.b()) * (t.a() - c.a());
        if (Double.isNaN(n)) {
            return n;
        }
        if (n > 0.0) {
            return 1.0;
        }
        if (n < -0.0) {
            return -1.0;
        }
        return n;
    }
    
    private static double b(final m m, final t t) {
        final t c = m.c();
        final t d = m.d();
        final double n = d.a - c.a;
        final double n2 = d.b - c.b;
        final double n3 = t.a - c.a;
        final double n4 = t.b - c.b;
        final double n5 = n3 * n + n4 * n2;
        double n6 = n3 * n3 + n4 * n4 - n5 * n5 / (n * n + n2 * n2);
        if (n6 < 0.0) {
            n6 = 0.0;
        }
        return Math.sqrt(n6);
    }
    
    private double[] a(final int n, final v v, final n[] array, final n[] array2) {
        final boolean z = fj.z;
        final double[] array3 = { 0.0, 1.0 };
        final t[] f = v.f();
        final double sqrt = Math.sqrt(array[n].f() * array[n].f() + array[n].e() * array[n].e());
        final double n2 = 30.0 + sqrt;
        final double a = t.a(array[n].k(), array2[n].k());
        Label_0466: {
            if (n > 0) {
                final z z2 = new z(f[n + 1], f[n]);
                final z z3 = new z(f[n - 1], f[n]);
                t t = y.d.e.a(array[n - 1].k(), z3, array[n].k(), z2);
                if (t != null) {
                    final double d = y.d.z.d(z2, z3);
                    if ((this.a() == 1 && d < 3.141592653589793) || (this.a() == 2 && d > 3.141592653589793)) {
                        final double a2 = y.d.t.a(f[n], f[n + 1]);
                        final double a3 = y.d.t.a(f[n - 1], f[n]);
                        if (a3 + sqrt < a2 && y.d.t.a(f[n], t) > a3) {
                            final m m = new m(f[n - 1], y.d.z.a(f[n - 1], y.d.z.c(z2)));
                            final n n3 = new n(array2[n]);
                            final double a4 = a(m, n3);
                            if (a4 > 0.0) {
                                final z z4 = new z(f[n], f[n + 1]);
                                z4.c();
                                z4.b(a4);
                                n3.d(z4.a(), z4.b());
                            }
                            t = n3.k();
                        }
                        if (y.d.t.a(f[n], t) > a2) {
                            array3[0] = 1.0;
                            if (!z) {
                                break Label_0466;
                            }
                        }
                        final double a5 = y.d.t.a(t, array[n].k());
                        if (a5 >= a) {
                            break Label_0466;
                        }
                        array3[0] = a5 / a;
                        if (!z) {
                            break Label_0466;
                        }
                    }
                    if (y.d.t.a(t, array2[n].k()) > a) {
                        array3[0] = -Math.min(Math.abs(n2), y.d.t.a(t, array[n].k()));
                    }
                }
            }
        }
        Label_0870: {
            if (n < f.length - 2) {
                final z z5 = new z(f[n], f[n + 1]);
                final z z6 = new z(f[n + 2], f[n + 1]);
                t t2 = y.d.e.a(array[n + 1].k(), z6, array[n].k(), z5);
                if (t2 != null) {
                    final double d2 = y.d.z.d(z6, z5);
                    if ((this.a() == 1 && d2 < 3.141592653589793) || (this.a() == 2 && d2 > 3.141592653589793)) {
                        final double a6 = t.a(f[n], f[n + 1]);
                        final double a7 = t.a(f[n + 2], f[n + 1]);
                        if (a7 + sqrt < a6 && t.a(f[n + 1], t2) > a7) {
                            final m i = new m(f[n + 2], y.d.z.a(f[n + 2], y.d.z.c(z5)));
                            final n n4 = new n(array[n]);
                            final double a8 = a(i, n4);
                            if (a8 > 0.0) {
                                final z z7 = new z(f[n + 1], f[n]);
                                z7.c();
                                z7.b(a8);
                                n4.d(z7.a(), z7.b());
                            }
                            t2 = n4.k();
                        }
                        if (t.a(f[n + 1], t2) > a6) {
                            array3[1] = 0.0;
                            if (!z) {
                                break Label_0870;
                            }
                        }
                        final double n5 = t.a(t2, array[n].k()) / a;
                        if (n5 >= 1.0) {
                            break Label_0870;
                        }
                        array3[1] = n5;
                        if (!z) {
                            break Label_0870;
                        }
                    }
                    if (t.a(t2, array[n].k()) / a > 1.0) {
                        array3[1] = Math.max(1.0001, Math.min(Math.abs(n2), t.a(t2, array2[n].k())));
                    }
                }
            }
        }
        if (array3[0] > array3[1]) {
            final double n6 = array3[0];
            array3[0] = array3[1];
            array3[1] = n6;
        }
        return array3;
    }
    
    public gv a(final n n, final I i, final am am, final am am2, final gv gv, final byte b, final boolean b2) {
        final boolean z = fj.z;
        final v a = ae.a(i, am, am2, 0.0);
        final int h = a.h();
        if (h < 2 || (h == 2 && a.a(0).g() < 1.0E-4)) {
            return this.g();
        }
        double n2 = Double.MAX_VALUE;
        double n3 = Double.MAX_VALUE;
        gv gv2 = null;
        double[] a2 = null;
        final t k = n.k();
        int n4 = -1;
        Label_0152: {
            if (b == 1 || b == 2 || (gv != null && gv.e() == this.a())) {
                if (gv.a() < 0) {
                    n4 = Math.max(0, h - 1 + gv.a());
                    if (!z) {
                        break Label_0152;
                    }
                }
                n4 = Math.min(h - 2, gv.a());
            }
        }
        final n[] array = new n[a.h() - 1];
        final n[] array2 = new n[a.h() - 1];
        final double[] array3 = new double[a.h() - 1];
        int j = 0;
        while (j < h - 1) {
            array[j] = new n(0.0, 0.0, 0.0, 0.0);
            array2[j] = new n(0.0, 0.0, 0.0, 0.0);
            final m a3 = a.a(j);
            array3[j] = ((2 != b && gv != null) ? gv.c() : ((this.a() == 0) ? this.b() : this.a(n, a3)));
            this.a(a, j, n.d(), i, am, am2, array[j], array2[j], array3[j]);
            ++j;
            if (z) {
                break;
            }
        }
        int l = 0;
        while (true) {
            while (true) {
                while (l < h - 1) {
                    final int a4 = b;
                    final byte b3 = 1;
                    if (!z) {
                        if (b != b3 || (b == 1 && n4 == l)) {
                            final t m = array[l].k();
                            t t = array2[l].k();
                            if (y.d.t.a(m, t) < 1.0E-4) {
                                final z i2 = a.a(l).i();
                                i2.c();
                                t = y.d.z.a(t, i2);
                            }
                            final t a5 = a(k, m, new z(t, m));
                            final double n5 = a5.a - m.a;
                            final double n6 = a5.b - m.b;
                            double n7 = t.a - m.a;
                            double n8 = t.b - m.b;
                            if (n7 == 0.0 && n8 == 0.0) {
                                n7 = 1.0;
                                n8 = 0.0;
                            }
                            double n9 = 0.0;
                            Label_0589: {
                                if (n7 < 1.0E-4 && n7 > -1.0E-4) {
                                    n9 = n6 / n8;
                                    if (!z) {
                                        break Label_0589;
                                    }
                                }
                                if (n8 < 1.0E-4 && n8 > -1.0E-4) {
                                    n9 = n5 / n7;
                                    if (!z) {
                                        break Label_0589;
                                    }
                                }
                                n9 = (n5 / n7 + n6 / n8) / 2.0;
                            }
                            final double[] a6 = this.a(l, a, array, array2);
                            if (n9 < 0.0) {
                                n9 = -Math.sqrt(n5 * n5 + n6 * n6);
                            }
                            Label_0699: {
                                if (2 != b && gv != null) {
                                    if (n4 == l && gv.b() < 0.0) {
                                        n9 = Math.max(n9, gv.b());
                                        a6[0] = Math.min(a6[0], gv.b());
                                        if (!z) {
                                            break Label_0699;
                                        }
                                    }
                                    n9 = Math.max(a6[0], n9);
                                }
                            }
                            if (n9 > 1.0) {
                                final double n10 = t.a - a5.a;
                                final double n11 = t.b - a5.b;
                                n9 = Math.max(Math.sqrt(n10 * n10 + n11 * n11), 1.0000001);
                            }
                            Label_0826: {
                                if (2 != b && gv != null) {
                                    if (n4 == l && gv.b() > 1.0) {
                                        n9 = Math.min(n9, gv.b());
                                        a6[1] = Math.max(a6[1], gv.b());
                                        if (!z) {
                                            break Label_0826;
                                        }
                                    }
                                    n9 = Math.min(a6[1], n9);
                                }
                            }
                            final gv gv3 = new gv((n9 > 1.0 || l == h - 2) ? (l + 1 - h) : l, n9, array3[l], this.f(), this.a(), this.e());
                            final double a7 = y.d.t.a(this.a(n.d(), i, am, am2, gv3).k(), k);
                            double abs = Math.abs(gv3.c());
                            final m a8 = a.a(l);
                            final double g = a8.g();
                            final t a9 = a(k, a8.c(), a8.i());
                            final double a10 = y.d.t.a(m, a9);
                            final double a11 = y.d.t.a(t, a9);
                            Label_1040: {
                                if (a10 > g && a11 < a10) {
                                    abs += 1.1 * Math.abs(a11);
                                    if (!z) {
                                        break Label_1040;
                                    }
                                }
                                if (a11 > g && a10 < a11) {
                                    abs += 1.1 * Math.abs(a10);
                                }
                            }
                            if (b == 2 && n4 != l) {
                                abs += 5.0;
                            }
                            if (a7 + 1.0E-4 < n2 || (a7 < 1.0E-4 && abs < n3)) {
                                gv2 = gv3;
                                n2 = a7;
                                n3 = abs;
                                a2 = a6;
                            }
                        }
                        ++l;
                        if (z) {
                            break;
                        }
                        continue;
                    }
                    else {
                        final int a12 = a4 + b3;
                        final int n12 = a12;
                        final n n13 = array[n12];
                        final n n14 = array2[n12];
                        final t k2 = n13.k();
                        final t k3 = n14.k();
                        Label_1444: {
                            if (gv == null) {
                                final n[] array4 = new n[a.h() - 1];
                                final n[] array5 = new n[a.h() - 1];
                                final double[] array6 = new double[a.h() - 1];
                                int n15 = 0;
                                while (true) {
                                    while (n15 < h - 1) {
                                        array4[n15] = new n(0.0, 0.0, 0.0, 0.0);
                                        array5[n15] = new n(0.0, 0.0, 0.0, 0.0);
                                        final m a13 = a.a(n15);
                                        final double[] array7 = array6;
                                        final int n16 = n15;
                                        if (z) {
                                            array7[n16] = Math.max(a2[1], gv2.b());
                                            break Label_1444;
                                        }
                                        array7[n16] = ((gv2 != null) ? gv2.c() : ((this.a() == 0) ? this.b() : this.a(n, a13)));
                                        this.a(a, n15, n.d(), i, am, am2, array4[n15], array5[n15], gv2.c());
                                        ++n15;
                                        if (z) {
                                            break;
                                        }
                                    }
                                    a2 = this.a(n12, a, array4, array5);
                                    if (gv2.b() < 0.0) {
                                        a2[0] = Math.min(a2[0], gv2.b());
                                    }
                                    if (gv2.b() > 1.0) {
                                        a2[1] = Math.max(a2[1], gv2.b());
                                    }
                                    a2[0] = Math.min(a2[0], gv2.b());
                                    continue;
                                }
                            }
                        }
                        final double[] array8 = new double[4];
                        Label_1612: {
                            if (a2[0] < 0.0) {
                                final z z2 = new z(k3, k2);
                                z2.c();
                                z2.b(a2[0]);
                                array8[0] = k2.a() + z2.a();
                                array8[1] = k2.b() + z2.b();
                                if (!z) {
                                    break Label_1612;
                                }
                            }
                            if (a2[0] > 0.0) {
                                final double n17 = k3.a() - k2.a();
                                final double n18 = k3.b() - k2.b();
                                array8[0] = k2.a() + n17 * a2[0];
                                array8[1] = k2.b() + n18 * a2[0];
                                if (!z) {
                                    break Label_1612;
                                }
                            }
                            array8[0] = k2.a();
                            array8[1] = k2.b();
                        }
                        Label_1775: {
                            if (a2[1] > 1.0) {
                                final z z3 = new z(k3, k2);
                                z3.c();
                                z3.b(a2[1]);
                                array8[2] = k3.a() + z3.a();
                                array8[3] = k3.b() + z3.b();
                                if (!z) {
                                    break Label_1775;
                                }
                            }
                            if (a2[1] < 1.0) {
                                final double n19 = k3.a() - k2.a();
                                final double n20 = k3.b() - k2.b();
                                array8[2] = k2.a() + n19 * a2[1];
                                array8[3] = k2.b() + n20 * a2[1];
                                if (!z) {
                                    break Label_1775;
                                }
                            }
                            array8[2] = k3.a();
                            array8[3] = k3.b();
                        }
                        if (b2) {
                            final gv gv4 = new gv(gv2.a(), gv2.b(), gv2.c(), gv2.d(), gv2.e(), (gv2.f() - y.d.z.d(new z(1.0, 0.0), a.a(n12).i())) % 6.283185307179586);
                            gv4.a(array8[0], array8[1], array8[2], array8[3]);
                            return gv4;
                        }
                        gv2.a(array8[0], array8[1], array8[2], array8[3]);
                        return gv2;
                    }
                }
                if (gv2.a() < 0) {
                    final int a4 = gv2.a();
                    continue;
                }
                break;
            }
            final int a12 = gv2.a();
            continue;
        }
    }
    
    private double a(final n n, final m m) {
        final n n2 = new n(n);
        final t k = n.k();
        if (this.c()) {
            n2.a(c(z.d(m.i(), ik.g) - n2.j()));
            n2.b(k);
        }
        final double d = z.d(m.i(), new m(m.c(), k).i());
        final double n3 = this.f ? b(m, k) : a(m, n2);
        if (d > 3.141592653589793) {
            return -n3;
        }
        return n3;
    }
    
    private static t a(final t t, final t t2, final z z) {
        final double n = t.a - t2.a;
        final double n2 = t.b - t2.b;
        final double a = z.a();
        final double b = z.b();
        final double n3 = (n * a + n2 * b) / (a * a + b * b);
        return new t(t2.a + n3 * a, t2.b + n3 * b);
    }
    
    private void a(final v v, final int n, final q q, final I i, final am am, final am am2, final n n2, final n n3, final double n4) {
        m a = v.a(n);
        final t c = a.c();
        t d = a.d();
        if (a.g() == 0.0) {
            final double n5 = am.getX() + am.getWidth() * 0.5 + i.getSourcePoint().a - (am2.getX() + am2.getWidth() * 0.5 + i.getTargetPoint().a);
            final double n6 = am.getY() + am.getHeight() * 0.5 + i.getSourcePoint().b - (am2.getY() + am2.getHeight() * 0.5 + i.getTargetPoint().b);
            Label_0255: {
                if (n5 == 0.0 && n6 == 0.0) {
                    d = new t(c.a + 1.0E-4, c.b);
                    if (!fj.z) {
                        break Label_0255;
                    }
                }
                final double sqrt = Math.sqrt(n5 * n5 + n6 * n6);
                d = new t(c.a + 1.0E-4 * n5 / sqrt, c.b + 1.0E-4 * n6 / sqrt);
            }
            a = new m(c, d);
        }
        double c2 = 6.283185307179586 - this.d;
        if (this.b) {
            c2 = c(z.d(a.i(), ik.g) - this.d);
        }
        n2.a(q);
        n2.a(c2);
        this.a(n2, a, c, n4);
        if (n == 0 && this.a(am, n2)) {
            this.b(n2, a, am, n4);
        }
        n3.a(q);
        n3.a(c2);
        this.a(n3, a, d, n4);
        if (n == v.h() - 2 && this.a(am2, n3)) {
            this.a(n3, a, am2, n4);
        }
    }
    
    private boolean a(final am am, final n n) {
        return n.a(n, new y(am.getX(), am.getY(), am.getWidth(), am.getHeight()), 5.0);
    }
    
    private static t a(final m m, final t t, final double n, final double n2) {
        final t d = m.d();
        final t c = m.c();
        final double a = t.a();
        final double b = t.b();
        return e.a(d.a(), d.b(), c.a(), c.b(), a, b, a + n, b + n2);
    }
    
    static {
        g = new z(1.0, 0.0);
    }
}
