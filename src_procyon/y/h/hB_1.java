package y.h;

import y.d.*;

class hB
{
    private static boolean a(final n n) {
        return (n.g() == 0.0 && n.i() == -1.0) || (n.g() == 0.0 && n.i() == 1.0) || (n.g() == -1.0 && n.i() == 0.0) || (n.g() == 1.0 && n.i() == 0.0);
    }
    
    private static y b(final n n) {
        final boolean z = fj.z;
        if (n.g() == 0.0 && n.i() == -1.0) {
            final double n2 = n.b();
            final double n3 = n.c() - n.f();
            final double n4 = n.f();
            final double n5 = n.e();
            if (!z) {
                return new y(n2, n3, n5, n4);
            }
        }
        if (n.g() == 0.0 && n.i() == 1.0) {
            final double n2 = n.b() - n.e();
            final double n3 = n.c();
            final double n4 = n.f();
            final double n5 = n.e();
            if (!z) {
                return new y(n2, n3, n5, n4);
            }
        }
        if (n.g() == 1.0 && n.i() == 0.0) {
            final double n2 = n.b();
            final double n3 = n.c();
            final double n4 = n.e();
            final double n5 = n.f();
            if (!z) {
                return new y(n2, n3, n5, n4);
            }
        }
        if (n.g() == -1.0 && n.i() == 0.0) {
            final double n2 = n.b() - n.e();
            final double n3 = n.c() - n.f();
            final double n4 = n.e();
            final double n5 = n.f();
            if (!z) {
                return new y(n2, n3, n5, n4);
            }
        }
        return null;
    }
    
    static double a(final y y, final n n) {
        if (a(n)) {
            return a(y, b(n));
        }
        if (n.a(n, y, 0.001)) {
            return 0.0;
        }
        return a(y, n.a(n));
    }
    
    static double a(final y y, final y y2) {
        if (y.a(y, y2)) {
            return 0.0;
        }
        final double a = a(y, y2, false);
        final double a2 = a(y, y2, true);
        return Math.sqrt(a * a + a2 * a2);
    }
    
    private static double a(final y y, final y y2, final boolean b) {
        return a(b ? y.c() : y.d(), b ? (y.c() + y.a()) : (y.d() + y.b()), b ? y2.c() : y2.d(), b ? (y2.c() + y2.a()) : (y2.d() + y2.b()));
    }
    
    private static double a(final double n, final double n2, final double n3, final double n4) {
        if (n4 < n) {
            return n4 - n;
        }
        if (n2 < n3) {
            return n3 - n2;
        }
        return 0.0;
    }
    
    static double a(final m m, final m i) {
        if (m.a(m, i) != null) {
            return 0.0;
        }
        return Math.min(Math.min(Math.min(a(m, i.c()), a(m, i.d())), a(i, m.c())), a(i, m.d()));
    }
    
    private static double a(final y y, final t[] array) {
        final boolean z = fj.z;
        final t e = y.e();
        final t t = new t(e.a, e.b + y.b());
        final t t2 = new t(t.a + y.a(), t.b);
        final t t3 = new t(t2.a, e.b);
        final m[] array2 = { new m(e, t), new m(t3, t2), new m(e, t3), new m(t, t2) };
        double min = Double.MAX_VALUE;
        int i = 0;
    Label_0210_Outer:
        while (i < array.length) {
            final m m = new m(array[i], array[(i + 1) % array.length]);
            int j = 0;
            while (true) {
                while (j < array2.length) {
                    min = Math.min(min, a(m, array2[j]));
                    ++j;
                    if (!z) {
                        if (z) {
                            break;
                        }
                        continue Label_0210_Outer;
                    }
                    else {
                        if (z) {
                            break Label_0210_Outer;
                        }
                        continue Label_0210_Outer;
                    }
                }
                ++i;
                continue;
            }
        }
        return min;
    }
    
    static double a(final m m, final t t) {
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
                    if (!fj.z) {
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
}
