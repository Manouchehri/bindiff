package y.f;

import y.c.*;
import y.d.*;

public class aL implements E
{
    private double a;
    private boolean b;
    private boolean c;
    private boolean d;
    private double e;
    private byte f;
    private static final z g;
    
    public byte a() {
        return this.f;
    }
    
    public void a(final double a) {
        this.a = a;
    }
    
    public boolean b() {
        return this.d;
    }
    
    public Object c() {
        return new aM(0, 0.0, false);
    }
    
    public n a(final q q, final I i, final am am, final am am2, final Object o) {
        final boolean j = X.j;
        final aM am3 = (aM)((o != null) ? o : ((aM)this.c()));
        final int a = am3.a();
        final double b = am3.b();
        final boolean c = am3.c();
        final n n = new n(new t(0.0, 0.0), q);
        n.a(6.283185307179586 - this.e);
        final v a2 = ae.a(i, am, am2, 0.0);
        if (a2.h() < 2 || (a2.h() == 2 && t.a(a2.c(), a2.d()) < 1.0E-4)) {
            Label_0208: {
                if (a2.h() < 2) {
                    final y h = n.h();
                    n.e(am.getX() + h.a * 0.5, am.getY() + h.b * 0.5);
                    if (!j) {
                        break Label_0208;
                    }
                }
                final t c2 = a2.c();
                n.e(c2.a, c2.b);
            }
            if (this.b()) {
                ae.b(n);
            }
            return n;
        }
        int n2 = 0;
        Label_0264: {
            if (a < 0) {
                n2 = Math.max(0, a2.h() - 1 + a);
                if (!j) {
                    break Label_0264;
                }
            }
            n2 = Math.min(a2.h() - 2, a);
        }
        m a3 = a2.a(n2);
        if (a3 == null) {
            final y h2 = n.h();
            n.e(am.getX() + h2.a * 0.5, am.getY() + h2.b * 0.5);
            if (this.b()) {
                ae.b(n);
            }
            return n;
        }
        final t c3 = a3.c();
        t d = a3.d();
        if (a3.g() == 0.0) {
            final double n3 = am.getX() + am.getWidth() * 0.5 + i.getSourcePoint().a - (am2.getX() + am2.getWidth() * 0.5 + i.getTargetPoint().a);
            final double n4 = am.getY() + am.getHeight() * 0.5 + i.getSourcePoint().b - (am2.getY() + am2.getHeight() * 0.5 + i.getTargetPoint().b);
            Label_0577: {
                if (n3 == 0.0 && n4 == 0.0) {
                    d = new t(c3.a + 1.0E-6, c3.b);
                    if (!j) {
                        break Label_0577;
                    }
                }
                final double sqrt = Math.sqrt(n3 * n3 + n4 * n4);
                d = new t(c3.a + 1.0E-6 * n3 / sqrt, c3.b + 1.0E-6 * n4 / sqrt);
            }
            a3 = new m(c3, d);
        }
        if (this.c) {
            n.a(b(z.d(a3.i(), aL.g) - this.e));
        }
        double n5 = 0.0;
        if (this.f != 0) {
            n5 = (c ? (-this.a) : this.a);
        }
        final n n6 = new n(n);
        Label_0706: {
            if (n2 == 0 && a(am, c3, 5.0)) {
                this.b(n6, a3, am, n5);
                if (!j) {
                    break Label_0706;
                }
            }
            this.a(n6, a3, c3, n5);
        }
        final n n7 = new n(n);
        Label_0771: {
            if (n2 >= a2.h() - 2 && a(am2, d, 5.0)) {
                this.a(n7, a3, am2, n5);
                if (!j) {
                    break Label_0771;
                }
            }
            this.a(n7, a3, d, n5);
        }
        n.a(new t(n6.b() * (1.0 - b) + n7.b() * b, n6.c() * (1.0 - b) + n7.c() * b));
        if (this.b()) {
            ae.b(n);
        }
        return n;
    }
    
    public D a(final C c, final I i, final am am, final am am2) {
        final boolean j = X.j;
        final D d = new D();
        final t[] f = ae.a(i, am, am2, 0.0).f();
        if (f.length < 2 || (f.length == 2 && t.a(f[0], f[1]) < 1.0E-4)) {
            final n n = new n(c.getOrientedBox());
            Label_0142: {
                if (f.length < 2) {
                    n.e(am.getX() + n.e() * 0.5, am.getY() - n.f() * 0.5);
                    if (!j) {
                        break Label_0142;
                    }
                }
                n.e(f[0].a, f[0].b);
            }
            d.add(new B(n, this.c(), c, false));
            return d;
        }
        int k = 0;
        while (k < f.length - 1) {
            final t t = f[k];
            t t2 = f[k + 1];
            Label_0420: {
                if (t.equals(t2)) {
                    final double n2 = am.getX() + am.getWidth() * 0.5 + i.getSourcePoint().a - (am2.getX() + am2.getWidth() * 0.5 + i.getTargetPoint().a);
                    final double n3 = am.getY() + am.getHeight() * 0.5 + i.getSourcePoint().b - (am2.getY() + am2.getHeight() * 0.5 + i.getTargetPoint().b);
                    if (n2 == 0.0 && n3 == 0.0) {
                        t2 = new t(t.a + 1.0E-4, t.b);
                        if (!j) {
                            break Label_0420;
                        }
                    }
                    final double sqrt = Math.sqrt(n2 * n2 + n3 * n3);
                    t2 = new t(t.a + 1.0E-4 * n2 / sqrt, t.b + 1.0E-4 * n3 / sqrt);
                }
            }
            final m m = new m(t, t2);
            double b = 6.283185307179586 - this.e;
            if (this.c) {
                b = b(z.d(m.i(), aL.g) - this.e);
            }
            final int n4 = (k > (f.length - 2) / 2) ? (k + 1 - f.length) : k;
            final double n5 = (this.f == 0) ? 0.0 : this.a;
            final n n6 = new n(c.getOrientedBox());
            n6.a(b);
            Label_0582: {
                if (k == 0 && a(am, t, 5.0)) {
                    this.b(n6, m, am, n5);
                    if (!j) {
                        break Label_0582;
                    }
                }
                this.a(n6, m, t, n5);
            }
            d.add(new B(n6, new aM(n4, 0.0, false), c));
            final n n7 = new n(c.getOrientedBox());
            n7.a(b);
            Label_0687: {
                if (k == f.length - 2 && a(am2, t2, 5.0)) {
                    this.a(n7, m, am2, n5);
                    if (!j) {
                        break Label_0687;
                    }
                }
                this.a(n7, m, t2, n5);
            }
            d.add(new B(n7, new aM(n4, 1.0, false), c));
            this.a(d, c, n6, n7, m, k, false);
            if (this.f == 1) {
                final n n8 = new n(c.getOrientedBox());
                n8.a(b);
                Label_0815: {
                    if (k == 0 && a(am, t, 5.0)) {
                        this.b(n8, m, am, -this.a);
                        if (!j) {
                            break Label_0815;
                        }
                    }
                    this.a(n8, m, t, -this.a);
                }
                d.add(new B(n8, new aM(n4, 0.0, true), c));
                final n n9 = new n(c.getOrientedBox());
                n9.a(b);
                Label_0926: {
                    if (k == f.length - 2 && a(am2, t2, 5.0)) {
                        this.a(n9, m, am2, -this.a);
                        if (!j) {
                            break Label_0926;
                        }
                    }
                    this.a(n9, m, t2, -this.a);
                }
                d.add(new B(n9, new aM(n4, 1.0, true), c));
                this.a(d, c, n8, n9, m, n4, true);
            }
            ++k;
            if (j) {
                break;
            }
        }
        return d;
    }
    
    private void a(final D d, final C c, final n n, final n n2, final m m, final int n3, final boolean b) {
        final boolean j = X.j;
        final t[] a = n.a(n);
        final int b2 = b(a, m);
        final m i = new m(a[b2], (b2 > 0) ? a[b2 - 1] : a[3]);
        final m k = new m(a[b2], (b2 < 3) ? a[b2 + 1] : a[0]);
        final t[] a2 = n.a(n2);
        final double a3 = t.a(a[b2], a(a2[b2], i, a[b2]));
        final int n4 = (int)Math.floor((a3 - k.g()) / k.g());
        final double a4 = t.a(a[b2], a(a2[b2], k, a[b2]));
        final int n5 = (int)Math.floor((a4 - i.g()) / i.g());
        final boolean b3 = n4 >= n5;
        final double n6 = b3 ? a3 : a4;
        final m l = b3 ? i : k;
        final m m2 = b3 ? k : i;
        int n7 = b3 ? n4 : n5;
        if (n7 > 0 && n7 % 2 == 0) {
            ++n7;
        }
        final double n8 = (n6 - (n7 + 1) * m2.g()) / (n7 + 1);
        final z i2 = m.i();
        i2.c();
        final z i3 = m2.i();
        i3.c();
        i3.b(n8 + m2.g());
        final t a5 = z.a(n.a(), i3);
        t a6 = a(a5, l, n.a(), m);
        if (a6 == null) {
            a6 = a5;
        }
        i2.b(t.a(n.a(), a6));
        t a7 = n.a();
        final double a8 = t.a(n.a(), n2.a());
        Label_0512: {
            if (n7 > 0) {
                int n9 = 0;
                while (n9 < n7) {
                    final n n10 = new n(n);
                    final t a9 = z.a(a7, i2);
                    final double a10 = t.a(n.a(), a9);
                    n10.a(a9);
                    d.add(new B(n10, new aM(n3, a10 / a8, b), c));
                    a7 = a9;
                    ++n9;
                    if (j) {
                        break Label_0512;
                    }
                }
                return;
            }
        }
        final n n11 = new n(n);
        n11.b(t.c(n2.k(), n.k()));
        d.add(new B(n11, new aM(n3, 0.5, b), c));
    }
    
    private static boolean a(final am am, final t t, final double n) {
        return am.getX() - n < t.a && am.getX() + am.getWidth() + n > t.a && am.getY() - n < t.b && am.getY() + am.getHeight() + n > t.b;
    }
    
    public Object a(final n n, final I i, final am am, final am am2) {
        if (ae.a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        final y.f.D d = new y.f.D();
        d.a(n);
        final D a = this.a(d, i, am, am2);
        if (a.isEmpty()) {
            return this.c();
        }
        final Q a2 = aW.a(a, n.k());
        return (a2 != null) ? a2.b() : this.c();
    }
    
    private static double b(double n) {
        final boolean j = X.j;
        if (n < 0.0) {
            n += 6.283185307179586;
        }
        double n2 = 0.0;
        while (n > 6.283185307179586) {
            n2 = n - 6.283185307179586;
            if (j) {
                return n2;
            }
            n = n2;
            if (j) {
                break;
            }
        }
        return n2;
    }
    
    private static byte a(final m m) {
        final double d = z.d(m.i(), aL.g);
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
        final double d = z.d(m.i(), aL.g);
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
        final boolean j = X.j;
        if (0 == this.a()) {
            n.e(t.a, t.b);
            if (!j) {
                return;
            }
        }
        z c = z.c(m.i());
        Label_0157: {
            if (this.b) {
                if (!d(n2)) {
                    break Label_0157;
                }
                c = new z(-c.a(), -c.b());
                if (!j) {
                    break Label_0157;
                }
            }
            double d = z.d(aL.g, c);
            if (d == 6.283185307179586) {
                d = 0.0;
            }
            if ((d >= 3.141592653589793 && d(n2)) || (d < 3.141592653589793 && c(n2))) {
                c = new z(-c.a(), -c.b());
            }
        }
        c.b(Math.abs(n2) + n.e() + n.f());
        final t a = z.a(t, c);
        n.e(a.a, a.b);
        final t[] a2 = n.a(n);
        double min = Double.MAX_VALUE;
        int i = 0;
        while (i < a2.length) {
            min = Math.min(min, a(m, a2[i]));
            ++i;
            if (j) {
                return;
            }
            if (j) {
                break;
            }
        }
        final z z = new z(-c.a(), -c.b());
        z.c();
        z.b(min - Math.abs(n2));
        final t a3 = y.d.z.a(a, z);
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
        final double a3 = aV.a(y, n);
        final y h = n.h();
        if (Math.abs(t.a - t2.a) > 1.0E-4 && Math.abs(t.b - t2.b) > 1.0E-4 && (a3 < 2.5 || a3 > 6.0) && (((a == 0 || a == 1) && (t2.a < y.c() - 5.0 - h.a * 0.5 || t2.a > y.c() + y.a() + 5.0 + h.a * 0.5)) || ((a == 2 || a == 3) && (t2.b < y.d() - 5.0 - h.b * 0.5 || t2.b > y.d() + y.b() + 5.0 + h.b * 0.5)))) {
            n.a(this.a(b(m), m, n, am, b, n2));
            final double a4 = aV.a(y, n);
            if (a4 < 2.5 || (a4 > a3 && a3 > 2.5)) {
                n.a(a2);
            }
        }
    }
    
    private t a(final byte b, final m m, final n n, final am am, final boolean b2, final double n2) {
        final boolean j = X.j;
        final boolean b3 = 0 == this.a();
        final n n3 = new n(n);
        final t c = m.c();
        final t d = m.d();
        final double d2 = z.d(m.i(), aL.g);
        final y h = n3.h();
        Label_1155: {
            if (b == 0) {
                boolean b4 = false;
                Label_0151: {
                    if (this.b) {
                        b4 = ((b2 && d(n2)) || (!b2 && c(n2)));
                        if (!j) {
                            break Label_0151;
                        }
                    }
                    b4 = ((c(n2) && d2 <= 1.5707963267948966) || (d(n2) && d2 > 1.5707963267948966));
                }
                double b5 = am.getY() - 5.0 - h.b() * 0.5;
                if (b5 < d.b) {
                    b5 = d.b;
                }
                n3.e(b4 ? (Math.min(c.a, d.a) - h.a) : (Math.max(c.a, d.a) + h.a), b5);
                final t t = b3 ? n3.k() : a(n.a(n3), m);
                n3.d(a(m, t, 1.0, 0.0).a - t.a, 0.0);
                if (b3) {
                    break Label_1155;
                }
                double a = a(m, new z(1.0, 0.0), Math.abs(n2));
                if (b4) {
                    a = -a;
                }
                n3.d(a, 0.0);
                if (!j) {
                    break Label_1155;
                }
            }
            if (b == 1) {
                boolean b6 = false;
                Label_0439: {
                    if (this.b) {
                        b6 = ((b2 && c(n2)) || (!b2 && d(n2)));
                        if (!j) {
                            break Label_0439;
                        }
                    }
                    b6 = ((c(n2) && d2 <= 4.71238898038469) || (d(n2) && d2 > 4.71238898038469));
                }
                double b7 = am.getY() + am.getHeight() + 5.0 + h.b() * 0.5;
                if (b7 > d.b) {
                    b7 = d.b;
                }
                n3.e(b6 ? (Math.min(c.a, d.a) - h.a) : (Math.max(c.a, d.a) + h.a), b7);
                final t t2 = b3 ? n3.k() : a(n.a(n3), m);
                n3.d(a(m, t2, 1.0, 0.0).a - t2.a, 0.0);
                if (b3) {
                    break Label_1155;
                }
                double a2 = a(m, new z(1.0, 0.0), Math.abs(n2));
                if (!b6) {
                    a2 = -a2;
                }
                n3.d(a2, 0.0);
                if (!j) {
                    break Label_1155;
                }
            }
            if (b == 2) {
                boolean d3 = false;
                Label_0701: {
                    if (this.b) {
                        d3 = ((b2 && d(n2)) || (!b2 && c(n2)));
                        if (!j) {
                            break Label_0701;
                        }
                    }
                    d3 = d(n2);
                }
                double a3 = am.getX() - 5.0 - h.a() * 0.5;
                if (a3 < d.a) {
                    a3 = d.a;
                }
                n3.e(a3, d3 ? (Math.max(c.b, d.b) + h.b) : (Math.min(c.b, d.b) - h.b));
                final t t3 = b3 ? n3.k() : a(n.a(n3), m);
                n3.d(0.0, a(m, t3, 0.0, 1.0).b - t3.b);
                if (b3) {
                    break Label_1155;
                }
                double a4 = a(m, new z(0.0, 1.0), Math.abs(n2));
                if (d3) {
                    a4 = -a4;
                }
                n3.d(0.0, a4);
                if (!j) {
                    break Label_1155;
                }
            }
            if (b == 3) {
                boolean d4 = false;
                Label_0955: {
                    if (this.b) {
                        d4 = ((b2 && c(n2)) || (!b2 && d(n2)));
                        if (!j) {
                            break Label_0955;
                        }
                    }
                    d4 = d(n2);
                }
                double a5 = am.getX() + am.getWidth() + 5.0 + h.a() * 0.5;
                if (a5 > d.a) {
                    a5 = d.a;
                }
                n3.e(a5, d4 ? (Math.max(c.b, d.b) + h.b) : (Math.min(c.b, d.b) - h.b));
                final t t4 = b3 ? n3.k() : a(n.a(n3), m);
                n3.d(0.0, a(m, t4, 0.0, 1.0).b - t4.b);
                if (!b3) {
                    double a6 = a(m, new z(0.0, 1.0), Math.abs(n2));
                    if (!d4) {
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
                if (!j) {
                    return n3.a();
                }
            }
            this.a(n3, new m(m.d(), m.c()), t5, n2);
        }
        return n3.a();
    }
    
    private static boolean c(final double n) {
        return n > 0.0 || (n == 0.0 && Double.doubleToLongBits(n) == 0L);
    }
    
    private static boolean d(final double n) {
        return n < 0.0 || (n == 0.0 && Double.doubleToLongBits(n) < 0L);
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
        final boolean j = X.j;
        double n = Double.MAX_VALUE;
        int i = 0;
        double n2 = 0.0;
        while (i < array.length) {
            final double a = a(m, array[i]);
            n2 = dcmpg(a, n);
            if (j) {
                return (int)n2;
            }
            if (n2 < 0) {
                n = a;
            }
            ++i;
            if (j) {
                break;
            }
        }
        return (int)n2;
    }
    
    private static double a(final m m, final t t) {
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
    
    private static t a(final t t, final m m, final t t2) {
        final double a = t.a();
        final double b = t.b();
        final t c = m.c();
        final t d = m.d();
        final double n = d.a() - c.a();
        final double n2 = d.b() - c.b();
        final double a2 = t2.a();
        final double b2 = t2.b();
        return e.a(a, b, a + n, b + n2, a2, b2, a2 + -n2, b2 + n);
    }
    
    private static t a(final t t, final m m, final t t2, final m i) {
        final double a = t.a();
        final double b = t.b();
        final t c = m.c();
        final t d = m.d();
        final double n = d.a() - c.a();
        final double n2 = d.b() - c.b();
        final double a2 = t2.a();
        final double b2 = t2.b();
        final t c2 = i.c();
        final t d2 = i.d();
        return e.a(a, b, a + n, b + n2, a2, b2, a2 + (d2.a() - c2.a()), b2 + (d2.b() - c2.b()));
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
