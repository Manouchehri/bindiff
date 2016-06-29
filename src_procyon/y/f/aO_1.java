package y.f;

import y.c.*;
import y.d.*;

public class aO implements E
{
    private double a;
    private double b;
    private double c;
    private double d;
    private byte e;
    private static final aP f;
    private static final aP g;
    
    public aO(final byte e) {
        this.a = 1.0;
        this.b = 1.0;
        this.c = 1.0;
        this.d = 9.125;
        this.e = e;
    }
    
    public byte a() {
        return this.e;
    }
    
    public void a(final double a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    public Object c() {
        if (this.e == 1) {
            return aO.f;
        }
        return aO.g;
    }
    
    public n a(final q q, final I i, final am am, final am am2, final Object o) {
        final aP ap = (aP)((o != null) ? o : ((aP)this.c()));
        final int a = ap.a();
        final byte d = ap.d();
        final double b = ap.b();
        final z c = ap.c();
        final v a2 = ae.a(i, am, am2, this.d);
        final m a3 = a2.a((a < 0) ? (a2.h() - 1 + a) : a);
        final n n = new n(new t(0.0, 0.0), q);
        final y h = n.h();
        if (a3 == null) {
            n.e(am.getX() + h.a * 0.5, am.getY() + h.b * 0.5);
            return n;
        }
        final t c2 = a3.c();
        t d2 = a3.d();
        Label_0405: {
            if (a3.g() == 0.0) {
                final double n2 = am.getX() + am.getWidth() * 0.5 + i.getSourcePoint().a - (am2.getX() + am2.getWidth() * 0.5 + i.getTargetPoint().a);
                final double n3 = am.getY() + am.getHeight() * 0.5 + i.getSourcePoint().b - (am2.getY() + am2.getHeight() * 0.5 + i.getTargetPoint().b);
                if (n2 == 0.0 && n3 == 0.0) {
                    d2 = new t(c2.a + 1.0E-6, c2.b);
                    if (!X.j) {
                        break Label_0405;
                    }
                }
                final double sqrt = Math.sqrt(n2 * n2 + n3 * n3);
                d2 = new t(c2.a + 1.0E-6 * n2 / sqrt, c2.b + 1.0E-6 * n3 / sqrt);
            }
        }
        final t b2 = t.b(z.a(this.a(b, c2, d2, h, d), c), c2);
        n.e(b2.a() + h.a * 0.5, b2.b() + h.b * 0.5);
        return n;
    }
    
    public D a(final C c, final I i, final am am, final am am2) {
        final boolean j = X.j;
        final byte[] a = a(this.e);
        final n a2 = aW.a(c.getOrientedBox());
        final double e = a2.e();
        final double f = a2.f();
        final q q = new q(e, f);
        final D d = new D();
        final v a3 = ae.a(i, am, am2, this.d);
        final u b = a3.b();
        if (!b.f()) {
            a2.e(am.getX() + e * 0.5, am.getY() + f * 0.5);
            d.add(new B(a2, this.c(), c, false));
            return d;
        }
        final double[] array = new double[a3.h() - 1];
        final double[] array2 = new double[a3.h() - 1];
        final double a4 = this.a(a3, array, array2);
        t t = b.a();
        b.g();
        int n = 0;
        do {
            Label_0203: {
                b.f();
            }
            byte b2 = 0;
            Label_0210:
            while (b2 != 0) {
                final t t2 = t;
                t = b.a();
                final double n2 = t.a() - t2.a();
                final double n3 = t.b() - t2.b();
                final double[] a5 = this.a(n2, n3, e, f);
                int n4 = 0;
                Block_11:
                do {
                    final int length = a.length;
                Label_0274:
                    while (true) {
                        int k = 0;
                        int n5 = 0;
                        while (k < n5) {
                            boolean b3 = false;
                            b2 = a[n4];
                            if (j) {
                                continue Label_0210;
                            }
                            if (b2 == 0) {
                                b3 = true;
                            }
                            final z a6 = this.a(n2, n3, e, f, a[n4]);
                            final z b4 = z.b(a6);
                            b4.b(this.a);
                            int n6 = 0;
                            while (true) {
                                ++n6;
                                int l = 0;
                                while (l < a5.length) {
                                    final double n7 = a5[l];
                                    final t b5 = y.d.t.b(z.a(this.a(n7, t2, t, q, a[n4]), b4), t2);
                                    final double n8 = array2[n] / a4 + n7 * array[n];
                                    k = n;
                                    n5 = (a3.h() - 2) / 2;
                                    if (j) {
                                        continue Label_0274;
                                    }
                                    final aP ap = new aP((k > n5) ? (n + 1 - a3.h()) : n, n7, b4, a[n4], n8);
                                    final n n9 = new n(a2);
                                    n9.e(b5.a() + e * 0.5, b5.b() + f * 0.5);
                                    d.add(new B(n9, ap, c, b3));
                                    ++l;
                                    if (j) {
                                        break;
                                    }
                                }
                                b4.a(a6);
                                while (z.a(b4, a6).d() >= this.b || this.e == 0 || n6 >= 5) {
                                    ++n4;
                                    if (!j) {
                                        continue Block_11;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    break;
                } while (!j);
                b.g();
                ++n;
                continue Label_0203;
            }
            break;
        } while (!j);
        return d;
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
    
    public z a(final double n, final double n2, double max, double max2, final byte b) {
        if (b == 0) {
            return new z(0.0, 0.0);
        }
        final double abs = Math.abs(n);
        final double abs2 = Math.abs(n2);
        double n3 = n2 / n;
        if (Double.isNaN(n3)) {
            n3 = 1.0;
        }
        max = Math.max(0.01, max);
        max2 = Math.max(0.01, max2);
        final double n4 = max2 / max;
        final double n5 = max * 0.5;
        final double n6 = max2 * 0.5;
        if (abs2 < abs * n4) {
            final double n7 = n6 + Math.abs(n5 * n3);
            if (a(b, n, n2)) {
                return new z(0.0, -n7);
            }
            return new z(0.0, n7);
        }
        else {
            final double n8 = n5 + Math.abs(n6 / n3);
            if (b(b, n, n2)) {
                return new z(-n8, 0.0);
            }
            return new z(n8, 0.0);
        }
    }
    
    private static byte[] a(final byte b) {
        if (b == 0) {
            return new byte[] { 0 };
        }
        if (b == 1) {
            return new byte[] { 3, 4 };
        }
        throw new IllegalArgumentException("Unknown model mode " + b);
    }
    
    private double[] a(double abs, double abs2, double max, final double n) {
        final boolean j = X.j;
        abs = Math.abs(abs);
        abs2 = Math.abs(abs2);
        max = Math.max(0.01, max);
        int n2 = 0;
        Label_0070: {
            if (abs2 < abs * n / max) {
                n2 = Math.max(2, (int)Math.floor(abs / max));
                if (!j) {
                    break Label_0070;
                }
            }
            n2 = Math.max(2, (int)Math.floor(abs2 / n));
        }
        int max2 = Math.max(3, Math.min((int)(n2 + (this.c - 1.0) * (n2 - 1)), 20));
        if (max2 % 2 == 0) {
            ++max2;
        }
        final double n3 = 1.0 / (max2 - 1);
        final double[] array = new double[max2];
        int i = max2 - 2;
        while (i > 0) {
            array[i] = n3 * i;
            --i;
            if (j) {
                return array;
            }
            if (j) {
                break;
            }
        }
        array[max2 - 1] = 1.0;
        return array;
    }
    
    private t a(final double n, final t t, final t t2, final q q, final byte b) {
        final boolean j = X.j;
        final double n2 = t2.a() - t.a();
        final double n3 = t2.b() - t.b();
        final double max = Math.max(1.0E-7, Math.abs(n2));
        final double abs = Math.abs(n3);
        double n4 = n3 / n2;
        if (Double.isNaN(n4)) {
            n4 = 1.0;
        }
        final double max2 = Math.max(0.01, q.a());
        final double max3 = Math.max(0.01, q.b());
        final double n5 = max3 / max2;
        final double n6 = max2 * 0.5;
        final double n7 = max3 * 0.5;
        double n8 = 0.0;
        double n9 = 0.0;
        double n10 = 0.0;
        double n11 = 0.0;
        Label_0356: {
            if (abs < max * n5) {
                Label_0152: {
                    if (n2 > 0.0) {
                        n8 = 1.0 + n6;
                        if (!j) {
                            break Label_0152;
                        }
                    }
                    n8 = -(1.0 + n6);
                }
                n9 = n2 - n8;
                n10 = n4 * n8;
                n11 = n3 - n10;
                if (b == 0) {
                    break Label_0356;
                }
                final double n12 = n7 + Math.abs(n6 * n4);
                if (a(b, n2, n3)) {
                    n10 -= n12;
                    n11 -= n12;
                    if (!j) {
                        break Label_0356;
                    }
                }
                n10 += n12;
                n11 += n12;
                if (!j) {
                    break Label_0356;
                }
            }
            final double n13 = 1.0 / n4;
            Label_0272: {
                if (n3 > 0.0) {
                    n10 = 1.0 + n7;
                    if (!j) {
                        break Label_0272;
                    }
                }
                n10 = -(1.0 + n7);
            }
            n11 = n3 - n10;
            n8 = n10 / n4;
            n9 = n2 - n8;
            if (b != 0) {
                final double n14 = n6 + Math.abs(n7 * n13);
                if (b(b, n2, n3)) {
                    n8 -= n14;
                    n9 -= n14;
                    if (!j) {
                        break Label_0356;
                    }
                }
                n8 += n14;
                n9 += n14;
            }
        }
        final double n15 = n9 - n8;
        final double n16 = n11 - n10;
        if (n15 * n2 < 0.0 || n16 * n3 < 0.0) {
            return new t((n8 + n9) * 0.5 - n6, (n10 + n11) * 0.5 - n7);
        }
        return new t(n8 + n15 * n - n6, n10 + n16 * n - n7);
    }
    
    private static boolean a(final byte b, final double n, final double n2) {
        return b == 2 || (b != 1 && ((n > 0.0 && b == 3) || (n < 0.0 && b == 4)));
    }
    
    private static boolean b(final byte b, final double n, final double n2) {
        return b == 2 || (b != 1 && ((n2 > 0.0 && b == 4) || (n2 < 0.0 && b == 3)));
    }
    
    private double a(final v v, final double[] array, final double[] array2) {
        final boolean j = X.j;
        u u = v.b();
        if (!u.f()) {
            return 0.0;
        }
        double n = 0.0;
        t t = u.a();
        u.g();
        while (true) {
            while (u.f()) {
                final t t2 = t;
                t = u.a();
                double n2 = t2.a() - t.a();
                final double n3 = t2.b() - t.b();
                n += Math.sqrt(n2 * n2 + n3 * n3);
                u.g();
                if (j) {
                    int n4 = 0;
                    double n7 = 0.0;
                    while (u.f()) {
                        final t t3 = t;
                        t = u.a();
                        final double n5 = t3.a() - t.a();
                        final double n6 = t3.b() - t.b();
                        final double sqrt = Math.sqrt(n5 * n5 + n6 * n6);
                        array2[n4] = n2;
                        array[n4] = sqrt / n;
                        n7 = n2 + sqrt;
                        if (j) {
                            return n7;
                        }
                        n2 = n7;
                        ++n4;
                        u.g();
                        if (j) {
                            break;
                        }
                    }
                    return n7;
                }
                if (j) {
                    break;
                }
            }
            u = v.b();
            t = u.a();
            u.g();
            double n2 = 0.0;
            continue;
        }
    }
    
    static {
        f = new aP(0, 0.0, new z(0.0, 0.0), (byte)2, 0.0);
        g = new aP(0, 0.0, new z(0.0, 0.0), (byte)0, 0.0);
    }
}
