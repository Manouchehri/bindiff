package y.f.c.a;

import y.d.*;
import java.util.*;
import y.c.*;
import y.f.*;

public class d implements bx
{
    private E a;
    
    public void a(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        this.a = (E)x.c(N.w).b(x);
        final int b = au.b();
        final double[] array = new double[b];
        final double[] array2 = new double[b];
        Arrays.fill(array, Double.MAX_VALUE);
        Arrays.fill(array2, -1.7976931348623157E308);
        int i = 0;
        while (true) {
            do {
                int j = 0;
                Label_0064: {
                    j = i;
                }
                Label_0066:
                while (j < b) {
                    final aQ a = au.a(i);
                    if (!x2) {
                        p p4 = a.d().k();
                        while (p4 != null) {
                            final q q = (q)p4.c();
                            final byte b2 = (byte)(j = av.a(q).b());
                            if (x2) {
                                continue Label_0066;
                            }
                            if (b2 == 0) {
                                final double q2 = x.q(q);
                                final double n = x.n(q);
                                final double n2 = n + q2;
                                if (array2[i] < n2) {
                                    array2[i] = n2;
                                }
                                if (array[i] > n) {
                                    array[i] = n;
                                }
                            }
                            p4 = p4.a();
                            if (x2) {
                                break;
                            }
                        }
                        ++i;
                        continue Label_0064;
                    }
                    while (true) {
                        while (i < b) {
                            final double n3 = dcmpl(array[i], Double.MAX_VALUE);
                            if (x2) {
                                double n4 = n3;
                                while (true) {
                                Label_0642_Outer:
                                    while (n4 >= 0) {
                                        final double n5 = dcmpl(array2[n4], -1.7976931348623157E308);
                                        if (x2) {
                                            final double[] array3 = new double[n5];
                                            int k = 0;
                                        Label_0642:
                                            while (true) {
                                                while (k < b) {
                                                    final aQ a2 = au.a(k);
                                                    byte e;
                                                    final byte b3 = e = a2.e();
                                                    int n7;
                                                    final int n6 = n7 = 2;
                                                    if (x2) {
                                                    Label_2982:
                                                        while (true) {
                                                            int l = 0;
                                                            while (l < n7) {
                                                                final aQ a3 = au.a(k);
                                                                int n8 = 0;
                                                                int n9 = 0;
                                                                Label_0787: {
                                                                    if (a3.e() == 2) {
                                                                        n8 = k - 1;
                                                                        if (au.a(k + 1).e() == 3) {
                                                                            n9 = k + 2;
                                                                            if (!x2) {
                                                                                break Label_0787;
                                                                            }
                                                                        }
                                                                        n9 = k + 1;
                                                                        if (!x2) {
                                                                            break Label_0787;
                                                                        }
                                                                    }
                                                                    if (a3.e() == 3) {
                                                                        n9 = k + 1;
                                                                        if (au.a(k - 1).e() == 2) {
                                                                            n8 = k - 2;
                                                                            if (!x2) {
                                                                                break Label_0787;
                                                                            }
                                                                        }
                                                                        n8 = k - 1;
                                                                        if (!x2) {
                                                                            break Label_0787;
                                                                        }
                                                                    }
                                                                    n8 = k - 1;
                                                                    n9 = k + 1;
                                                                }
                                                                final double n10 = array3[k];
                                                                p p5 = a3.d().k();
                                                                Object c;
                                                                q q3 = null;
                                                                aX a4 = null;
                                                                byte b4 = 0;
                                                                byte b5;
                                                                double n11;
                                                                y.c.d d;
                                                                y.c.d d2;
                                                                A a5;
                                                                q q4;
                                                                y.c.D m;
                                                                double n12;
                                                                y.c.d d3;
                                                                y.c.d d4;
                                                                A a6;
                                                                q q5;
                                                                y.c.D m2;
                                                                y.c.d d5;
                                                                A a7;
                                                                y.c.D k2;
                                                                t t;
                                                                t t2;
                                                                p p6;
                                                                t t3;
                                                                double n13;
                                                                y.c.d d6;
                                                                A a8;
                                                                y.c.D k3;
                                                                t t4;
                                                                t t5;
                                                                p p7;
                                                                t t6;
                                                                double n14;
                                                                y.c.d g;
                                                                aE c2;
                                                                aE e2;
                                                                int n15;
                                                                y.c.D k4;
                                                                y.c.d d7;
                                                                y.c.d d8;
                                                                t t7;
                                                                t t8;
                                                                double n16;
                                                                p p8;
                                                                t t9;
                                                                t t10;
                                                                double n17;
                                                                double n18 = 0.0;
                                                                y.c.d d9;
                                                                A a9;
                                                                aX a10;
                                                                aX a11;
                                                                Object o;
                                                                Object o2;
                                                                q q6;
                                                                q q7;
                                                                y.c.d d10;
                                                                y.c.d d11;
                                                                A a12;
                                                                boolean equals;
                                                                y.c.d d12;
                                                                A a13;
                                                                boolean equals2;
                                                                y.c.D k5;
                                                                y.c.d d13 = null;
                                                                q q9;
                                                                q q8 = null;
                                                                q q11;
                                                                q q10 = null;
                                                                dg f;
                                                                Label_2723_Outer:Label_2788_Outer:
                                                                while (p5 != null) {
                                                                    c = p5.c();
                                                                    Label_0816:
                                                                    Label_2962: {
                                                                        Label_1166: {
                                                                            while (true) {
                                                                                q3 = (q)c;
                                                                                a4 = av.a(q3);
                                                                                x.j(q3);
                                                                                b4 = a4.b();
                                                                                b5 = (e = b4);
                                                                                if (x2) {
                                                                                    break Label_0642;
                                                                                }
                                                                                if (b5 == 0) {
                                                                                    break Label_2962;
                                                                                }
                                                                                if (b4 == 6) {
                                                                                    n11 = 0.0;
                                                                                    d = q3.g();
                                                                                    while (d != null) {
                                                                                        d2 = av.a(d).b();
                                                                                        a5 = av.a(d2);
                                                                                        q4 = (q)(c = a5);
                                                                                        if (x2) {
                                                                                            continue Label_0816;
                                                                                        }
                                                                                        if (q4 != null && a5.b() != null) {
                                                                                            d2 = a5.b();
                                                                                        }
                                                                                        m = x.m(d2);
                                                                                        n11 += a(m, ((t)m.f()).b, array[n9], n10);
                                                                                        d = d.h();
                                                                                        if (x2) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    x.a(q3, n11 / q3.b(), n10);
                                                                                    if (!x2) {
                                                                                        break Label_2962;
                                                                                    }
                                                                                }
                                                                                if (b4 == 7) {
                                                                                    n12 = 0.0;
                                                                                    d3 = q3.f();
                                                                                    while (d3 != null) {
                                                                                        d4 = av.a(d3).b();
                                                                                        a6 = av.a(d4);
                                                                                        q5 = (q)(c = a6);
                                                                                        if (x2) {
                                                                                            continue Label_0816;
                                                                                        }
                                                                                        if (q5 != null && a6.b() != null) {
                                                                                            d4 = a6.b();
                                                                                        }
                                                                                        m2 = x.m(d4);
                                                                                        n12 += a(m2, array2[n8], ((t)m2.i()).b, n10);
                                                                                        d3 = d3.g();
                                                                                        if (x2) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                break Label_1166;
                                                                            }
                                                                            x.a(q3, n12 / q3.c(), n10);
                                                                            if (!x2) {
                                                                                break Label_2962;
                                                                            }
                                                                        }
                                                                        if (b4 == 8) {
                                                                            d5 = a4.g();
                                                                            a7 = av.a(d5);
                                                                            if (a7.b() != null) {
                                                                                d5 = a7.b();
                                                                            }
                                                                            k2 = x.k(d5);
                                                                            k2.a(x.p((y.c.d)a4.d().c()));
                                                                            k2.b(x.q(d5));
                                                                            t = (t)k2.i();
                                                                            t2 = (t)k2.f();
                                                                            p6 = k2.l().b();
                                                                            while (p6 != null) {
                                                                                t3 = (t)p6.c();
                                                                                n13 = (e = dcmpg(t3.b, t2.b));
                                                                                if (x2) {
                                                                                    break Label_0642;
                                                                                }
                                                                                if (n13 < 0 && t3.b < n10) {
                                                                                    t2 = t3;
                                                                                    t = (t)p6.a().c();
                                                                                    if (!x2) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                p6 = p6.b();
                                                                                if (x2) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            x.a(q3, t2.a + (t.a - t2.a) * ((n10 - t2.b) / (t.b - t2.b)), n10);
                                                                            if (!x2) {
                                                                                break Label_2962;
                                                                            }
                                                                        }
                                                                        if (b4 == 9) {
                                                                            d6 = a4.g();
                                                                            a8 = av.a(d6);
                                                                            if (a8.b() != null) {
                                                                                d6 = a8.b();
                                                                            }
                                                                            k3 = x.k(d6);
                                                                            k3.b(x.q((y.c.d)a4.d().c()));
                                                                            k3.a(x.p(d6));
                                                                            t4 = (t)k3.i();
                                                                            t5 = (t)k3.f();
                                                                            p7 = k3.k().a();
                                                                            while (p7 != null) {
                                                                                t6 = (t)p7.c();
                                                                                n14 = (e = dcmpl(t6.b, t4.b));
                                                                                if (x2) {
                                                                                    break Label_0642;
                                                                                }
                                                                                if (n14 > 0 && t6.b > n10) {
                                                                                    t5 = (t)p7.b().c();
                                                                                    t4 = t6;
                                                                                    if (!x2) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                p7 = p7.a();
                                                                                if (x2) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            x.a(q3, t5.a + (t4.a - t5.a) * ((n10 - t5.b) / (t4.b - t5.b)), n10);
                                                                            if (!x2) {
                                                                                break Label_2962;
                                                                            }
                                                                        }
                                                                        if (b4 == 10) {
                                                                            g = a4.g();
                                                                            c2 = av.a(g).c();
                                                                            e2 = av.a(g).e();
                                                                            n15 = (((c2 != null && c2.c()) || (e2 != null && e2.d())) ? 1 : 0);
                                                                            k4 = x.k(g);
                                                                            d7 = (y.c.d)a4.d().c();
                                                                            d8 = (y.c.d)a4.d().a().c();
                                                                            Label_1866: {
                                                                                if (d7.a(q3) == g.c()) {
                                                                                    k4.a(x.p(d7));
                                                                                    k4.b(x.q(d8));
                                                                                    if (!x2) {
                                                                                        break Label_1866;
                                                                                    }
                                                                                }
                                                                                k4.a(x.p(d8));
                                                                                k4.b(x.q(d7));
                                                                            }
                                                                            t7 = (t)k4.f();
                                                                            t8 = (t)k4.i();
                                                                            n16 = (t7.b + t8.b) * 0.5;
                                                                            p8 = k4.k().a();
                                                                            while (p8 != null) {
                                                                                t9 = (t)p8.b().c();
                                                                                t10 = (t)p8.c();
                                                                                l = n15;
                                                                                n17 = (n7 = dcmpl(t10.b, t9.b));
                                                                                if (x2) {
                                                                                    continue Label_0646;
                                                                                }
                                                                                if (l == ((n17 > 0) ? 1 : 0)) {
                                                                                    t7 = ((t10.b < t9.b) ? t10 : t9);
                                                                                    t8 = ((t10.b > t9.b) ? t10 : t9);
                                                                                    if (t7.b < n16 && t8.b >= n16) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                p8 = p8.a();
                                                                                if (x2) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            Label_2143: {
                                                                                if (t8.b - t7.b != 0.0) {
                                                                                    n18 = t7.a + (t8.a - t7.a) * ((n10 - t7.b) / (t8.b - t7.b));
                                                                                    if (!x2) {
                                                                                        break Label_2143;
                                                                                    }
                                                                                }
                                                                                n18 = (((t)k4.f()).a + ((t)k4.i()).a) * 0.5;
                                                                            }
                                                                            x.a(q3, n18, n10);
                                                                            if (!x2) {
                                                                                break Label_2962;
                                                                            }
                                                                        }
                                                                        if (b4 == 1) {
                                                                            d9 = a4.g();
                                                                            a9 = av.a(d9);
                                                                            a10 = av.a(d9.c());
                                                                            a11 = av.a(d9.d());
                                                                            o = null;
                                                                            o2 = null;
                                                                            q6 = d9.c();
                                                                            q7 = d9.d();
                                                                            if (a9.a() == 3) {
                                                                                d10 = a9.b();
                                                                                if (d10 == null) {
                                                                                    d11 = d9.c().g();
                                                                                    d10 = av.a(d11).b();
                                                                                    a12 = av.a(d10);
                                                                                    while (d11 != null) {
                                                                                        equals = a10.a().equals(a12.g());
                                                                                        if (x2) {
                                                                                            break Label_0642;
                                                                                        }
                                                                                        if (equals && a11.a().equals(a12.h())) {
                                                                                            break;
                                                                                        }
                                                                                        d11 = d11.h();
                                                                                        d10 = av.a(d11).b();
                                                                                        a12 = av.a(d10);
                                                                                        if (x2) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    if (d11 == null) {
                                                                                        d12 = d9.d().f();
                                                                                        d10 = av.a(d12).b();
                                                                                        a13 = av.a(d10);
                                                                                        while (d12 != null) {
                                                                                            equals2 = a10.a().equals(a13.g());
                                                                                            if (x2) {
                                                                                                break Label_0642;
                                                                                            }
                                                                                            if (equals2 && a11.a().equals(a13.h())) {
                                                                                                break;
                                                                                            }
                                                                                            d12 = d12.g();
                                                                                            d10 = av.a(d12).b();
                                                                                            a13 = av.a(d10);
                                                                                            if (x2) {
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                q6 = d9.c();
                                                                                q7 = d9.d();
                                                                                d9 = d10;
                                                                                o = x.p(d9);
                                                                                o2 = x.q(d9);
                                                                            }
                                                                            else {
                                                                                if (a10.b() == 6 || a10.b() == 7) {
                                                                                    q6 = d9.c();
                                                                                    d9 = av.a(d9).b();
                                                                                    q7 = d9.d();
                                                                                    o = x.p(d9);
                                                                                }
                                                                                if (a11.b() == 6 || a11.b() == 7) {
                                                                                    q7 = d9.d();
                                                                                    d9 = av.a(d9).b();
                                                                                    q6 = d9.c();
                                                                                    o2 = x.q(d9);
                                                                                }
                                                                            }
                                                                            k5 = x.k(d9);
                                                                            Label_2840: {
                                                                            Label_2823:
                                                                                while (true) {
                                                                                Label_2805:
                                                                                    while (true) {
                                                                                        Label_2763: {
                                                                                            if (o != null) {
                                                                                                k5.a(o);
                                                                                                if (!x2) {
                                                                                                    break Label_2763;
                                                                                                }
                                                                                            }
                                                                                            d13 = q3.g();
                                                                                        Label_2746:
                                                                                            while (true) {
                                                                                                if (d13 == null) {
                                                                                                    break Label_2746;
                                                                                                }
                                                                                                q8 = (q9 = d13.c());
                                                                                                q10 = (q11 = q6);
                                                                                                if (x2) {
                                                                                                    break Label_2805;
                                                                                                }
                                                                                                if (q9 != q11) {
                                                                                                    d13 = d13.c().g();
                                                                                                    if (!x2) {
                                                                                                        continue Label_2723_Outer;
                                                                                                    }
                                                                                                }
                                                                                                break;
                                                                                            }
                                                                                            if (d13 != null) {
                                                                                                k5.a(x.p(d13));
                                                                                            }
                                                                                        }
                                                                                        if (o2 != null) {
                                                                                            k5.b(o2);
                                                                                            if (!x2) {
                                                                                                break Label_2840;
                                                                                            }
                                                                                        }
                                                                                        d13 = q3.f();
                                                                                        if (d13 == null) {
                                                                                            break Label_2823;
                                                                                        }
                                                                                        q8 = (q9 = d13.d());
                                                                                        q10 = (q11 = q7);
                                                                                        if (x2) {
                                                                                            continue Label_2788_Outer;
                                                                                        }
                                                                                        break;
                                                                                    }
                                                                                    if (q8 != q10) {
                                                                                        d13 = d13.d().f();
                                                                                        if (!x2) {
                                                                                            continue;
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                if (d13 != null) {
                                                                                    k5.b(x.q(d13));
                                                                                }
                                                                            }
                                                                            x.a(q3, a(k5, array[k], array2[k], n10), n10);
                                                                            if (!x2) {
                                                                                break Label_2962;
                                                                            }
                                                                        }
                                                                        if (b4 == 12) {
                                                                            x.a(q3, this.a.f(a4.l()).z.c, n10);
                                                                            if (!x2) {
                                                                                break Label_2962;
                                                                            }
                                                                        }
                                                                        if (b4 == 13) {
                                                                            f = this.a.f(a4.l());
                                                                            x.a(q3, f.z.c + f.z.a, n10);
                                                                        }
                                                                    }
                                                                    p5 = p5.a();
                                                                    if (x2) {
                                                                        break;
                                                                    }
                                                                }
                                                                ++k;
                                                                if (x2) {
                                                                    break;
                                                                }
                                                                break Label_0642;
                                                            }
                                                            break Label_2982;
                                                            n7 = b;
                                                            continue Label_0642_Outer;
                                                        }
                                                        final D d14 = new D();
                                                        d14.a(new e(this, x));
                                                        d14.a(x, au, av, ap);
                                                        this.a.g(au);
                                                        return;
                                                    }
                                                    Label_0631: {
                                                        if (b3 == n6) {
                                                            if (au.a(k + 1).e() == 3) {
                                                                array3[k] = (array2[k - 1] * 3.0 + array[k + 2]) * 0.25;
                                                                if (!x2) {
                                                                    break Label_0631;
                                                                }
                                                            }
                                                            array3[k] = (array2[k - 1] + array[k + 1]) * 0.5;
                                                            if (!x2) {
                                                                break Label_0631;
                                                            }
                                                        }
                                                        if (a2.e() == 3) {
                                                            if (au.a(k - 1).e() == 2) {
                                                                array3[k] = (array2[k - 2] + array[k + 1] * 3.0) * 0.25;
                                                                if (!x2) {
                                                                    break Label_0631;
                                                                }
                                                            }
                                                            array3[k] = (array2[k - 1] + array[k + 1]) * 0.5;
                                                            if (!x2) {
                                                                break Label_0631;
                                                            }
                                                        }
                                                        array3[k] = (array[k] + array2[k]) * 0.5;
                                                    }
                                                    ++k;
                                                    if (x2) {
                                                        break;
                                                    }
                                                }
                                                k = 0;
                                                continue Label_0642;
                                            }
                                        }
                                        Label_0388: {
                                            if (n5 == 0) {
                                                if (n4 < b - 1) {
                                                    array2[n4] = array[n4 + 1];
                                                    if (!x2) {
                                                        break Label_0388;
                                                    }
                                                }
                                                array2[n4] = array[n4] + 1.0;
                                            }
                                        }
                                        --n4;
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    continue;
                                }
                            }
                            Label_0314: {
                                if (n3 == 0) {
                                    if (i < 1) {
                                        array[i] = array2[i] - 1.0;
                                        if (!x2) {
                                            break Label_0314;
                                        }
                                    }
                                    if (array2[i - 1] != -1.7976931348623157E308) {
                                        array[i] = array2[i - 1] + 1.0;
                                        if (!x2) {
                                            break Label_0314;
                                        }
                                    }
                                    array[i] = array[i - 1] + 1.0;
                                }
                            }
                            ++i;
                            if (x2) {
                                break;
                            }
                        }
                        continue;
                    }
                }
                break;
            } while (!x2);
            i = 0;
            continue;
        }
    }
    
    private static final double a(final y.c.D d, final double n, final double n2, final double n3) {
        final boolean x = N.x;
        if (d.size() >= 3) {
            p p4 = d.k().a();
            while (true) {
                while (p4.a() != null) {
                    final p p5 = p4;
                    if (!x) {
                        if (((t)p5.c()).b >= n) {
                            break;
                        }
                        p4 = p4.a();
                        if (x) {
                            break;
                        }
                        continue;
                    }
                    else {
                        p b = p5;
                        double b2 = 0.0;
                        while (b.b() != null) {
                            b2 = ((t)b.c()).b;
                            if (x) {
                                return b2;
                            }
                            if (b2 <= n2) {
                                break;
                            }
                            b = b.b();
                            if (x) {
                                break;
                            }
                        }
                        if (b == p4) {
                            final double a = ((t)p4.c()).a;
                            return b2;
                        }
                        p p6 = p4.b();
                        double b3 = 0.0;
                        while (p6.a() != null) {
                            b3 = ((t)p6.c()).b;
                            if (x) {
                                return b3;
                            }
                            if (b3 >= n3) {
                                break;
                            }
                            p6 = p6.a();
                            if (x) {
                                break;
                            }
                        }
                        if (p6.b() == null) {
                            final double a2 = ((t)p6.c()).a;
                            return b3;
                        }
                        final t t = (t)p6.b().c();
                        final t t2 = (t)p6.c();
                        if (t.b != t2.b) {
                            return t.a + (t2.a - t.a) * ((n3 - t.b) / (t2.b - t.b));
                        }
                        return (t.a + t2.a) * 0.5;
                    }
                }
                d.l().b();
                continue;
            }
        }
        final t t3 = (t)d.f();
        final t t4 = (t)d.i();
        if (t4.b != t3.b) {
            return t3.a + (t4.a - t3.a) * ((n3 - t3.b) / (t4.b - t3.b));
        }
        return (t3.a + t4.a) * 0.5;
    }
}
