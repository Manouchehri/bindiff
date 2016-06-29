package y.f.d;

import y.c.*;
import y.d.*;
import java.util.*;

class C
{
    private static y a(final n n) {
        final int f = a.f;
        if (n.g() == 0.0 && n.i() == -1.0) {
            final double n2 = n.b();
            final double n3 = n.c() - n.f();
            final double n4 = n.f();
            final double n5 = n.e();
            if (f == 0) {
                return new y(n2, n3, n5, n4);
            }
        }
        if (n.g() == 0.0 && n.i() == 1.0) {
            final double n2 = n.b() - n.e();
            final double n3 = n.c();
            final double n4 = n.f();
            final double n5 = n.e();
            if (f == 0) {
                return new y(n2, n3, n5, n4);
            }
        }
        if (n.g() == 1.0 && n.i() == 0.0) {
            final double n2 = n.b();
            final double n3 = n.c();
            final double n4 = n.e();
            final double n5 = n.f();
            if (f == 0) {
                return new y(n2, n3, n5, n4);
            }
        }
        if (n.g() == -1.0 && n.i() == 0.0) {
            final double n2 = n.b() - n.e();
            final double n3 = n.c() - n.f();
            final double n4 = n.e();
            final double n5 = n.f();
            if (f == 0) {
                return new y(n2, n3, n5, n4);
            }
        }
        return null;
    }
    
    private static boolean b(final n n) {
        return (n.g() == 0.0 && n.i() == -1.0) || (n.g() == 0.0 && n.i() == 1.0) || (n.g() == -1.0 && n.i() == 0.0) || (n.g() == 1.0 && n.i() == 0.0);
    }
    
    static double a(final n n, final n n2) {
        final int f = a.f;
        if (b(n) && b(n2)) {
            return a(a(n), a(n2));
        }
        if (n.a(n, n2, 0.001) || n.a(n2, n, 0.001) || n2.equals(n)) {
            return 1.0;
        }
        final t[] b = b(n, n2);
        if (b != null) {
            double abs = 0.0;
            int i = 0;
            while (i < b.length) {
                final int n3 = (i + 1) % b.length;
                abs += (b[i].a + b[n3].a) * (b[n3].b - b[i].b);
                ++i;
                if (f != 0) {
                    return Math.max(abs / (n.e() * n.f()), abs / (n2.e() * n2.f()));
                }
                if (f != 0) {
                    break;
                }
            }
            abs = Math.abs(abs * 0.5);
            return Math.max(abs / (n.e() * n.f()), abs / (n2.e() * n2.f()));
        }
        return 0.0;
    }
    
    static double a(final n n, final y y) {
        return a(n, new n(y));
    }
    
    private static double a(final y y, final y y2) {
        if (y.b(y2) || y2.b(y) || y2.equals(y)) {
            return 1.0;
        }
        if (y.a(y, y2)) {
            final y b = b(y, y2);
            final double n = b.a * b.b;
            return Math.max(n / (y.a * y.b), n / (y2.a * y2.b));
        }
        return 0.0;
    }
    
    private static y b(final y y, final y y2) {
        final double max = Math.max(y.c, y2.c);
        final double max2 = Math.max(y.d, y2.d);
        return new y(max, max2, Math.min(y.c + y.a, y2.c + y2.a) - max, Math.min(y.d + y.b, y2.d + y2.b) - max2);
    }
    
    private static t[] b(final n n, final n n2) {
        final int f = a.f;
        final t[] a = n.a(n);
        final t[] a2 = n.a(n2);
        final D d = new D();
        int i = 0;
    Label_0027:
        while (true) {
            m m;
            boolean b;
            int j;
            t a3;
            int k;
            boolean a4;
            t[] array;
            int n3;
            y.c.C l;
            Label_0127_Outer:Label_0207_Outer:
            while (i < 4) {
                m = new m(a[i], a[(i + 1) % 4]);
                b = false;
                if (f == 0) {
                    j = (b ? 1 : 0);
                    while (true) {
                        while (j < 4) {
                            a3 = y.d.m.a(m, new m(a2[j], a2[(j + 1) % 4]));
                            if (f == 0) {
                                if (a3 != null) {
                                    d.add(a3);
                                }
                                ++j;
                                if (f != 0) {
                                    break;
                                }
                                continue Label_0127_Outer;
                            }
                            else {
                                if (f != 0) {
                                    break Label_0127_Outer;
                                }
                                continue Label_0027;
                            }
                        }
                        ++i;
                        continue Label_0207_Outer;
                    }
                }
                k = (b ? 1 : 0);
                while (true) {
                    while (k < 4) {
                        a4 = n.a(n, a2[k], 0.001);
                        if (f == 0) {
                            if (a4) {
                                d.add(a2[k]);
                            }
                            if (n.a(n2, a[k], 0.001)) {
                                d.add(a[k]);
                            }
                            ++k;
                            if (f != 0) {
                                break;
                            }
                            continue Label_0207_Outer;
                        }
                        else {
                            if (a4) {
                                return null;
                            }
                            array = new t[d.size()];
                            n3 = 0;
                            l = d.m();
                            while (l.f()) {
                                array[n3++] = (t)l.d();
                                l.g();
                                if (f != 0) {
                                    return array;
                                }
                                if (f != 0) {
                                    break;
                                }
                            }
                            Arrays.sort(array, new E(array, null));
                            return array;
                        }
                    }
                    d.isEmpty();
                    continue;
                }
            }
            continue;
        }
    }
    
    static double a(final n n, final m m) {
        final int f = a.f;
        if (b(n)) {
            return a(a(n), m);
        }
        if (!n.a(n, m, 0.001)) {
            return 0.0;
        }
        final t k = n.k();
        final double g = new m(k, n.a()).g();
        final double sqrt = Math.sqrt(n.e() * n.e() + n.f() * n.f());
        final t[] b = b(n, m);
        if (b == null) {
            final m i = m;
            if (f == 0) {
                return (3.0 * (1.0 - m.a(i, k) / g) + 1.0 * (i.g() / sqrt)) / 4.0;
            }
        }
        if (b.length == 1) {
            final m i = new m(n.a(n, m.c(), 0.001) ? m.c() : m.d(), b[0]);
            if (f == 0) {
                return (3.0 * (1.0 - m.a(i, k) / g) + 1.0 * (i.g() / sqrt)) / 4.0;
            }
        }
        final m i = new m(b[0], b[1]);
        return (3.0 * (1.0 - m.a(i, k) / g) + 1.0 * (i.g() / sqrt)) / 4.0;
    }
    
    private static t[] b(final n n, final m m) {
        final int f = a.f;
        final t[] a = n.a(n);
        final D d = new D();
        int i = 0;
        while (true) {
            while (i < a.length) {
                final t a2 = m.a(new m(a[i], a[(i + 1) % a.length]), m);
                if (f != 0) {
                    final t[] array = new t[d.size()];
                    int n2 = 0;
                    final y.c.C j = d.m();
                    t[] array2 = null;
                    while (j.f()) {
                        array2 = array;
                        if (f != 0) {
                            return array2;
                        }
                        array2[n2++] = (t)j.d();
                        j.g();
                        if (f != 0) {
                            break;
                        }
                    }
                    return array2;
                }
                Label_0100: {
                    if (a2 != null) {
                        d.add(a2);
                        if (f == 0) {
                            break Label_0100;
                        }
                    }
                    if (m.b(a[i])) {
                        d.add(a[i]);
                    }
                }
                ++i;
                if (f != 0) {
                    break;
                }
            }
            if (d.isEmpty()) {
                return null;
            }
            continue;
        }
    }
    
    private static double a(final y y, final m m) {
        final int f = a.f;
        if (!m.a(y)) {
            return 0.0;
        }
        final t t = new t(y.c + y.a * 0.5, y.d + y.b * 0.5);
        final double g = new m(t, y.e()).g();
        final double sqrt = Math.sqrt(y.a * y.a + y.b * y.b);
        final t[] b = b(y, m);
        if (b == null) {
            final m i = m;
            if (f == 0) {
                return (3.0 * (1.0 - m.a(i, t) / g) + 1.0 * (i.g() / sqrt)) / 4.0;
            }
        }
        if (b.length == 1) {
            final m i = new m(y.a(m.c()) ? m.c() : m.d(), b[0]);
            if (f == 0) {
                return (3.0 * (1.0 - m.a(i, t) / g) + 1.0 * (i.g() / sqrt)) / 4.0;
            }
        }
        final m i = new m(b[0], b[1]);
        return (3.0 * (1.0 - m.a(i, t) / g) + 1.0 * (i.g() / sqrt)) / 4.0;
    }
    
    private static t[] b(final y y, final m m) {
        final int f = a.f;
        final t e = y.e();
        final t t = new t(e.a, e.b + y.b());
        final t t2 = new t(t.a + y.a(), t.b);
        final t t3 = new t(t2.a, e.b);
        final D d = new D();
        final t a = m.a(new m(e, t), m);
        if (a != null) {
            d.add(a);
        }
        final t a2 = m.a(new m(t3, t2), m);
        if (a2 != null) {
            d.add(a2);
        }
        final t a3 = m.a(new m(e, t3), m);
        if (a3 != null) {
            d.add(a3);
        }
        final t a4 = m.a(new m(t, t2), m);
        if (a4 != null) {
            d.add(a4);
        }
        if (m.b(e)) {
            d.add(e);
        }
        if (m.b(t3)) {
            d.add(t3);
        }
        if (m.b(t)) {
            d.add(t);
        }
        if (m.b(t2)) {
            d.add(t2);
        }
        if (d.isEmpty()) {
            return null;
        }
        final t[] array = new t[d.size()];
        int n = 0;
        final y.c.C i = d.m();
        t[] array2 = null;
        while (i.f()) {
            array2 = array;
            if (f != 0) {
                return array2;
            }
            array2[n++] = (t)i.d();
            i.g();
            if (f != 0) {
                break;
            }
        }
        return array2;
    }
}
