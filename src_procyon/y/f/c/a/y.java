package y.f.c.a;

import y.g.*;
import java.util.*;
import y.c.*;
import y.f.*;

public class y implements bq
{
    private bP a;
    private cd b;
    private double c;
    
    public y() {
        this.c = 0.5;
    }
    
    void a(final bP a) {
        this.a = a;
    }
    
    void a(final cd b) {
        this.b = b;
    }
    
    public void a(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        this.a.a();
        final ArrayList list = new ArrayList<Object>(64);
        int n = 0;
        final x o = x.o();
        while (true) {
        Label_0518_Outer:
            while (o.f()) {
                final int n2 = n + av.a(o.e()).e();
                if (x2) {
                    final int[] array = new int[n2];
                    final int[] array2 = new int[x.e() + n / 2];
                    final int e = x.e();
                    final d[] array3 = new d[n / 2];
                    int n3 = 2;
                    int n4 = 0;
                    while (true) {
                        do {
                            int i = 0;
                        Label_2692_Outer:
                            while (i < au.b()) {
                                final aQ a = au.a(n4);
                                final int n5 = 0;
                                if (x2) {
                                    final byte[] array4 = new byte[n5];
                                    final byte[] array5 = new byte[x.g()];
                                    final int[] array6 = new int[x.g()];
                                    final int[] array7 = new int[x.g()];
                                    final cF a2 = cF.a(x, au, av, array, array2, array4, array6, array5, array7, (byte)1, (byte)0);
                                    final Comparator b = a2.b(true);
                                    final Comparator b2 = a2.b(false);
                                    final Comparator a3 = a2.a(true);
                                    final Comparator a4 = a2.a(false);
                                    final cF a5 = cF.a(array, array2, array4, array6, array5, array7, (byte)3, (byte)3);
                                    final Comparator a6 = a5.a(true);
                                    final Comparator a7 = a5.a(false);
                                    final d[] array8 = new d[n3];
                                    final D d = new D();
                                    final D d2 = new D();
                                    int n6 = 0;
                                    while (true) {
                                    Label_2692:
                                        while (true) {
                                            do {
                                                int j = 0;
                                            Label_2713_Outer:
                                                while (j < au.b()) {
                                                    final aQ a8 = au.a(n6);
                                                    int n7 = 0;
                                                    Object o2;
                                                    final p p4 = (p)(o2 = a8.d().k());
                                                Label_2713:
                                                    while (true) {
                                                        if (!x2) {
                                                            p a9 = p4;
                                                            while (a9 != null) {
                                                                final q q = (q)a9.c();
                                                                Object a10 = null;
                                                                j = (this.b.a(q) ? 1 : 0);
                                                                if (x2) {
                                                                    continue Label_2713_Outer;
                                                                }
                                                                if (j != 0) {
                                                                    a10 = this.b.a(x, q);
                                                                }
                                                                final byte b3 = av.a(q).b();
                                                                Label_2088: {
                                                                    if (b3 == 0 || b3 == 12 || b3 == 13) {
                                                                        final cb cb = new cb(x.a((Object)q));
                                                                        df df = cb.b(0);
                                                                        df df2 = cb.a(1);
                                                                        df df3 = cb.c(3);
                                                                        int n8 = 0;
                                                                        d d3 = q.g();
                                                                        while (true) {
                                                                            while (d3 != null) {
                                                                                array8[n8++] = d3;
                                                                                d3 = d3.h();
                                                                                if (!x2) {
                                                                                    if (x2) {
                                                                                        break;
                                                                                    }
                                                                                    continue Label_0518_Outer;
                                                                                }
                                                                                else {
                                                                                    d d4 = q.f();
                                                                                Label_1711:
                                                                                    while (true) {
                                                                                        while (d4 != null) {
                                                                                            array8[n8++] = d4;
                                                                                            d4 = d4.g();
                                                                                            if (x2) {
                                                                                                int k = 0;
                                                                                                while (k < 4) {
                                                                                                    final df a11 = cb.a(k);
                                                                                                    final df b4 = cb.b(k);
                                                                                                    final df c = cb.c(k);
                                                                                                    final double d5 = cb.d(k);
                                                                                                    int n9 = a11.d() + b4.d() + c.d();
                                                                                                    df a12 = null;
                                                                                                    df b5 = null;
                                                                                                    df c2 = null;
                                                                                                    final q q2 = (q)(o2 = a10);
                                                                                                    if (x2) {
                                                                                                        break Label_2713;
                                                                                                    }
                                                                                                    if (q2 != null) {
                                                                                                        a12 = ((bO)a10).a(k);
                                                                                                        b5 = ((bO)a10).b(k);
                                                                                                        c2 = ((bO)a10).c(k);
                                                                                                        n9 += a12.d() + b5.d() + c2.d();
                                                                                                    }
                                                                                                    if (n9 > 0) {
                                                                                                        final double a13 = this.a(x, av, q, k, d5, n9);
                                                                                                        final double a14 = this.a(x, av, q, k, d5, n9, a13);
                                                                                                        a11.b(a14);
                                                                                                        b4.b(a14);
                                                                                                        c.b(a14);
                                                                                                        Label_2042: {
                                                                                                            if (a10 != null) {
                                                                                                                a12.b(a14);
                                                                                                                a12.a(a13);
                                                                                                                b5.b(a14);
                                                                                                                b5.a(a12.a());
                                                                                                                a11.a(b5.a());
                                                                                                                c2.b(a14);
                                                                                                                c2.a(a13);
                                                                                                                c.a(c2.a());
                                                                                                                if (!x2) {
                                                                                                                    break Label_2042;
                                                                                                                }
                                                                                                            }
                                                                                                            a11.a(a13);
                                                                                                            c.a(a13);
                                                                                                        }
                                                                                                        a(x, a11, q);
                                                                                                        b4.a(a11.a());
                                                                                                        a(x, b4, q);
                                                                                                        a(x, c, q);
                                                                                                    }
                                                                                                    ++k;
                                                                                                    if (x2) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                break Label_2088;
                                                                                            }
                                                                                            if (x2) {
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        if (n8 > 0) {
                                                                                            y.g.e.a(array8, 0, n8, b);
                                                                                            y.g.e.a(array8, 0, n8, a3);
                                                                                            p p5 = d.k();
                                                                                            int l = 0;
                                                                                            while (true) {
                                                                                                while (l < n8) {
                                                                                                    final p p6 = p5;
                                                                                                    if (x2) {
                                                                                                        Label_1515: {
                                                                                                            if (p6 != null) {
                                                                                                                final p a15 = p5.a();
                                                                                                                d.h(p5);
                                                                                                                d2.a(p5);
                                                                                                                p5 = a15;
                                                                                                                if (x2) {
                                                                                                                    break Label_1515;
                                                                                                                }
                                                                                                                if (!x2) {
                                                                                                                    break;
                                                                                                                }
                                                                                                            }
                                                                                                            this.a(d, a7, array4, array6);
                                                                                                            this.a(ap, d, a7, array4, array6, true);
                                                                                                            p5 = d.k();
                                                                                                        }
                                                                                                        int n10 = 0;
                                                                                                        while (p5 != null) {
                                                                                                            final d d6 = (d)p5.c();
                                                                                                            final aE c3 = av.a(d6).c();
                                                                                                            final q q3 = (q)(o2 = c3);
                                                                                                            if (x2) {
                                                                                                                break Label_2713;
                                                                                                            }
                                                                                                            Label_1683: {
                                                                                                                if (q3 == null || c3.g() || c3.d()) {
                                                                                                                    if (c3 == null || !c3.a()) {
                                                                                                                        df.b(d6);
                                                                                                                    }
                                                                                                                    array4[d6.b()] = 0;
                                                                                                                    if (!x2) {
                                                                                                                        break Label_1683;
                                                                                                                    }
                                                                                                                }
                                                                                                                if (c3.e()) {
                                                                                                                    if (!c3.a()) {
                                                                                                                        df2.a(d6);
                                                                                                                    }
                                                                                                                    array4[d6.b()] = 1;
                                                                                                                    if (!x2) {
                                                                                                                        break Label_1683;
                                                                                                                    }
                                                                                                                }
                                                                                                                if (c3.f()) {
                                                                                                                    if (!c3.a()) {
                                                                                                                        df3.b(d6);
                                                                                                                    }
                                                                                                                    array4[d6.b()] = -1;
                                                                                                                }
                                                                                                            }
                                                                                                            array6[d6.b()] = ++n10;
                                                                                                            p5 = p5.a();
                                                                                                            ++n10;
                                                                                                            if (x2) {
                                                                                                                break;
                                                                                                            }
                                                                                                        }
                                                                                                        continue Label_1711;
                                                                                                    }
                                                                                                    Label_1415: {
                                                                                                        if (p6 == null) {
                                                                                                            if (d2.isEmpty()) {
                                                                                                                p5 = d.b((Object)null);
                                                                                                                if (!x2) {
                                                                                                                    break Label_1415;
                                                                                                                }
                                                                                                            }
                                                                                                            p5 = d2.k();
                                                                                                            d2.h(p5);
                                                                                                            d.a(p5);
                                                                                                        }
                                                                                                    }
                                                                                                    p5.a(array8[l]);
                                                                                                    ++l;
                                                                                                    p5 = p5.a();
                                                                                                    if (x2) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                continue Label_2692_Outer;
                                                                                            }
                                                                                        }
                                                                                        continue Label_1711;
                                                                                    }
                                                                                }
                                                                            }
                                                                            Label_1254: {
                                                                                if (n8 > 0) {
                                                                                    y.g.e.a(array8, 0, n8, b2);
                                                                                    y.g.e.a(array8, 0, n8, a4);
                                                                                    p p7 = d.k();
                                                                                    int n11 = 0;
                                                                                    while (true) {
                                                                                        while (n11 < n8) {
                                                                                            final p p8 = p7;
                                                                                            if (x2) {
                                                                                                Label_1061: {
                                                                                                    if (p8 != null) {
                                                                                                        final p a16 = p7.a();
                                                                                                        d.h(p7);
                                                                                                        d2.a(p7);
                                                                                                        p7 = a16;
                                                                                                        if (x2) {
                                                                                                            break Label_1061;
                                                                                                        }
                                                                                                        if (!x2) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    this.a(d, a6, array5, array7);
                                                                                                    this.a(ap, d, a6, array5, array7, false);
                                                                                                    p7 = d.k();
                                                                                                }
                                                                                                int n12 = 0;
                                                                                                while (p7 != null) {
                                                                                                    final d d7 = (d)p7.c();
                                                                                                    final aE e2 = av.a(d7).e();
                                                                                                    final q q4 = (q)(o2 = e2);
                                                                                                    if (x2) {
                                                                                                        break Label_2713;
                                                                                                    }
                                                                                                    Label_1229: {
                                                                                                        if (q4 == null || e2.g() || e2.c()) {
                                                                                                            if (e2 == null || !e2.a()) {
                                                                                                                df.a(d7);
                                                                                                            }
                                                                                                            array5[d7.b()] = 0;
                                                                                                            if (!x2) {
                                                                                                                break Label_1229;
                                                                                                            }
                                                                                                        }
                                                                                                        if (e2.e()) {
                                                                                                            if (!e2.a()) {
                                                                                                                df2.a(d7);
                                                                                                            }
                                                                                                            array5[d7.b()] = 1;
                                                                                                            if (!x2) {
                                                                                                                break Label_1229;
                                                                                                            }
                                                                                                        }
                                                                                                        if (e2.f()) {
                                                                                                            if (!e2.a()) {
                                                                                                                df3.b(d7);
                                                                                                            }
                                                                                                            array5[d7.b()] = -1;
                                                                                                        }
                                                                                                    }
                                                                                                    array7[d7.b()] = ++n12;
                                                                                                    p7 = p7.a();
                                                                                                    if (x2) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                break Label_1254;
                                                                                            }
                                                                                            Label_0961: {
                                                                                                if (p8 == null) {
                                                                                                    if (d2.isEmpty()) {
                                                                                                        p7 = d.b((Object)null);
                                                                                                        if (!x2) {
                                                                                                            break Label_0961;
                                                                                                        }
                                                                                                    }
                                                                                                    p7 = d2.k();
                                                                                                    d2.h(p7);
                                                                                                    d.a(p7);
                                                                                                }
                                                                                            }
                                                                                            p7.a(array8[n11]);
                                                                                            ++n11;
                                                                                            p7 = p7.a();
                                                                                            if (x2) {
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        continue Label_2692_Outer;
                                                                                    }
                                                                                }
                                                                            }
                                                                            df = cb.b(2);
                                                                            df2 = cb.c(1);
                                                                            df3 = cb.a(3);
                                                                            n8 = 0;
                                                                            continue Label_2713_Outer;
                                                                        }
                                                                    }
                                                                }
                                                                a9 = a9.a();
                                                                ++n7;
                                                                if (x2) {
                                                                    break;
                                                                }
                                                            }
                                                            ++n6;
                                                            continue Label_0518_Outer;
                                                        }
                                                        x.a((q)o2);
                                                        ++n6;
                                                        if (!x2) {
                                                            if (n6 < list.size()) {
                                                                o2 = list.get(n6);
                                                                continue Label_2713;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    return;
                                                }
                                                break;
                                            } while (!x2);
                                            int n13 = 0;
                                            while (n13 < list.size()) {
                                                final q q5 = list.get(n13);
                                                final d d8 = array3[q5.d() - e];
                                                x.e(d8);
                                                A a17 = av.a(d8);
                                                final int c4 = q5.c();
                                                if (x2) {
                                                    n6 = c4;
                                                    continue Label_2692;
                                                }
                                                Label_2675: {
                                                    if (c4 > 0) {
                                                        final d f = q5.f();
                                                        final d h = q5.h();
                                                        final A a18 = av.a(f);
                                                        final A a19 = av.a(h);
                                                        if (f.d() == d8.c()) {
                                                            if (a18.e() != a17.c()) {
                                                                a17 = ap.a(d8, true, a18.e());
                                                            }
                                                            if (a19.e() != a17.e()) {
                                                                a17 = ap.a(d8, false, a19.e());
                                                            }
                                                            x.a(d8, x.o(f));
                                                            x.b(d8, x.o(h));
                                                            if (!x2) {
                                                                break Label_2675;
                                                            }
                                                        }
                                                        if (a19.e() != a17.c()) {
                                                            a17 = ap.a(d8, true, a19.e());
                                                        }
                                                        if (a18.e() != a17.e()) {
                                                            a17 = ap.a(d8, false, a18.e());
                                                        }
                                                        x.a(d8, x.o(h));
                                                        x.b(d8, x.o(f));
                                                        if (!x2) {
                                                            break Label_2675;
                                                        }
                                                    }
                                                    final d g = q5.g();
                                                    final d m = q5.i();
                                                    final A a20 = av.a(g);
                                                    final A a21 = av.a(m);
                                                    if (g.c() == d8.c()) {
                                                        if (a20.c() != a17.c()) {
                                                            a17 = ap.a(d8, true, a20.c());
                                                        }
                                                        if (a21.c() != a17.e()) {
                                                            a17 = ap.a(d8, false, a21.c());
                                                        }
                                                        x.a(d8, x.n(g));
                                                        x.b(d8, x.n(m));
                                                        if (!x2) {
                                                            break Label_2675;
                                                        }
                                                    }
                                                    if (a21.c() != a17.c()) {
                                                        a17 = ap.a(d8, true, a21.c());
                                                    }
                                                    if (a20.c() != a17.e()) {
                                                        ap.a(d8, false, a20.c());
                                                    }
                                                    x.a(d8, x.n(m));
                                                    x.b(d8, x.n(g));
                                                }
                                                x.d(d8);
                                                ++n13;
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        continue;
                                    }
                                }
                                int n14 = n5;
                                p p9 = a.d().k();
                                while (p9 != null) {
                                    final q q6 = (q)p9.c();
                                    q q7 = null;
                                Label_0189:
                                    while (true) {
                                        q c5 = null;
                                        q7 = c5;
                                        array[q7.d()] = n4;
                                        array2[q7.d()] = n14;
                                        final aX a22 = av.a(q7);
                                        i = a22.e();
                                        if (x2) {
                                            continue Label_2692_Outer;
                                        }
                                        if (i > 0) {
                                            p p10 = a22.d();
                                            while (p10 != null) {
                                                final d d9 = (d)p10.c();
                                                c5 = d9.c();
                                                if (x2) {
                                                    continue Label_0189;
                                                }
                                                if (c5 == q7) {
                                                    final q d10 = x.d();
                                                    final A a23 = av.a(d9);
                                                    list.add(d10);
                                                    Label_0416: {
                                                        if (a23.j()) {
                                                            ap.b(d10, q7, d9, false, true);
                                                            ap.a(d10, d9.d(), d9, false, true);
                                                            n3 = Math.max(n3, d9.d().b());
                                                            if (!x2) {
                                                                break Label_0416;
                                                            }
                                                        }
                                                        ap.a(q7, d10, d9, true, false);
                                                        ap.b(d9.d(), d10, d9, true, false);
                                                        n3 = Math.max(n3, d9.d().c());
                                                    }
                                                    n3 = Math.max(2, n3);
                                                    array2[d10.d()] = -1;
                                                    array[d10.d()] = -(n4 + 1);
                                                    array3[d10.d() - e] = d9;
                                                }
                                                p10 = p10.a();
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    n3 = Math.max(n3, Math.max(q7.b(), q7.c()));
                                    p9 = p9.a();
                                    ++n14;
                                    if (x2) {
                                        break;
                                    }
                                }
                                ++n4;
                            }
                            break;
                        } while (!x2);
                        x.g();
                        continue;
                    }
                }
                n = n2;
                o.g();
                if (x2) {
                    break;
                }
            }
            final int n15 = x.e() + n / 2;
            continue;
        }
    }
    
    protected double a(final X x, final aV av, final q q, final int n, final double n2, final int n3) {
        if (n3 <= 1) {
            return n2 * 0.5;
        }
        final double b = this.b(x, av, q, n, n2, n3);
        if (b == Double.POSITIVE_INFINITY) {
            return n2 * 0.5;
        }
        return b * (n2 / (n3 - 1 + 2.0 * b));
    }
    
    protected double a(final X x, final aV av, final q q, final int n, final double n2, final int n3, final double n4) {
        if (n3 <= 1) {
            return 0.0;
        }
        return (n2 - 2.0 * n4) / (n3 - 1);
    }
    
    protected double b(final X x, final aV av, final q q, final int n, final double n2, final int n3) {
        final aY i = av.a(q).i();
        return (i != null) ? i.a(n) : this.c;
    }
    
    private static final void a(final X x, final df df, final q q) {
        final boolean x2 = N.x;
        if (df.d() > 0) {
            p p3 = df.e().k();
            while (p3 != null) {
                final d d = (d)p3.c();
                final double c = df.c();
                final double n = 0.0;
                Label_0094: {
                    if (d.c() == q) {
                        x.a(d, df.a(c, n));
                        if (!x2) {
                            break Label_0094;
                        }
                    }
                    x.b(d, df.a(c, n));
                }
                p3 = p3.a();
                if (x2) {
                    break;
                }
            }
        }
    }
    
    private void a(final D d, final Comparator comparator, final byte[] array, final int[] array2) {
        final boolean x = N.x;
        if (d.size() > 1) {
            p p4 = d.k();
            byte b = -1;
            while (b <= 1) {
                byte b2 = 0;
                byte b3 = 0;
            Label_0466:
                while (true) {
                    p p5 = null;
                    p a = p5;
                    while (a != null) {
                        b2 = array[((d)a.c()).b()];
                        b3 = b;
                        if (x) {
                            break Label_0466;
                        }
                        if (b2 >= b3) {
                            break;
                        }
                        a = a.a();
                        if (x) {
                            break;
                        }
                    }
                    if (a == null) {
                        return;
                    }
                    b = array[((d)a.c()).b()];
                    if (array2[((d)a.c()).b()] > 0) {
                        p4 = a;
                        if (!x) {
                            break;
                        }
                    }
                    p a2 = a;
                    int n = 1;
                    p p6 = a2.a();
                    while (true) {
                        while (p6 != null) {
                            final byte b4 = array[((d)p6.c()).b()];
                            final byte b5 = b;
                            if (x) {
                                if (b4 != b5) {
                                    p4 = p6;
                                    if (!x) {
                                        break Label_0466;
                                    }
                                }
                                p4 = p6.a();
                                while (p4 != null) {
                                    final byte b6 = array[((d)p4.c()).b()];
                                    final byte b7 = b;
                                    if (x) {
                                        break Label_0466;
                                    }
                                    if (b6 != b7 || array2[((d)p4.c()).b()] <= 0) {
                                        break;
                                    }
                                    p4 = p4.a();
                                    if (x) {
                                        break;
                                    }
                                }
                                do {
                                    int i = 0;
                                Label_0292:
                                    while (i > 0) {
                                        int n2 = 0;
                                        p a3 = p6;
                                        int n3 = 0;
                                        final d d2 = (d)a2.c();
                                        p5 = p6;
                                        if (x) {
                                            continue Label_0466;
                                        }
                                        p a4 = p5;
                                        while (a4 != p4) {
                                            final int n4 = i = comparator.compare(a4.c(), d2);
                                            if (x) {
                                                continue Label_0292;
                                            }
                                            Label_0393: {
                                                if (i < 0) {
                                                    if (--n2 >= n3) {
                                                        break Label_0393;
                                                    }
                                                    n3 = n2;
                                                    a3 = a4.a();
                                                    if (!x) {
                                                        break Label_0393;
                                                    }
                                                }
                                                if (n4 > 0) {
                                                    ++n2;
                                                }
                                            }
                                            a4 = a4.a();
                                            if (x) {
                                                break;
                                            }
                                        }
                                        final p p7 = a2;
                                        a2 = a2.a();
                                        Label_0454: {
                                            if (a3 != a2) {
                                                d.h(p7);
                                                if (a3 == null) {
                                                    d.a(p7);
                                                    if (!x) {
                                                        break Label_0454;
                                                    }
                                                }
                                                d.a(p7, a3);
                                            }
                                        }
                                        p6 = a3;
                                        --n;
                                    }
                                    break;
                                } while (!x);
                                break Label_0466;
                            }
                            if (b4 != b5 || array2[((d)p6.c()).b()] != 0) {
                                break;
                            }
                            ++n;
                            p6 = p6.a();
                            if (x) {
                                break;
                            }
                        }
                        if (p6 == null) {
                            return;
                        }
                        final byte b8 = array[((d)p6.c()).b()];
                        continue;
                    }
                }
                b = (byte)(b2 + b3);
                if (x) {
                    break;
                }
            }
        }
    }
    
    private void a(final aP ap, final D d, final Comparator comparator, final byte[] array, final int[] array2, final boolean b) {
        final boolean x = N.x;
        Label_0496: {
            if (d.size() > 1) {
                p p6 = d.k();
                int i = 0;
                while (true) {
                    while (p6 != null) {
                        final int n;
                        final byte b2 = (byte)(n = array[((d)p6.c()).b()]);
                        final int size;
                        final int n2 = size = -2;
                        if (!x) {
                            if (b2 != n2) {
                                break;
                            }
                            ++i;
                            p6 = p6.a();
                            if (x) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (n == size) {
                                return;
                            }
                            final p k = d.k();
                            p p7 = p6;
                            p a = k;
                        Label_0262_Outer:
                            while (i > 0) {
                                int n3 = 0;
                                p a2 = p7;
                                int n4 = 0;
                                final d d2 = (d)a.c();
                                int n5 = -1;
                                p a3 = p7;
                                while (true) {
                                    while (a3 != null) {
                                        final d d3 = (d)a3.c();
                                        final byte b3 = array[d3.b()];
                                        final int compare;
                                        final int n6 = compare = comparator.compare(d3, d2);
                                        if (!x) {
                                            Label_0234: {
                                                if (compare < 0) {
                                                    if (--n3 >= n4) {
                                                        break Label_0234;
                                                    }
                                                    n4 = n3;
                                                    a2 = a3.a();
                                                    if (!x) {
                                                        break Label_0234;
                                                    }
                                                }
                                                if (n6 > 0) {
                                                    ++n3;
                                                    if (!x) {
                                                        break Label_0234;
                                                    }
                                                }
                                                if (n4 == n3 && n5 <= 0 && b3 >= 0) {
                                                    a2 = a3;
                                                }
                                            }
                                            n5 = b3;
                                            a3 = a3.a();
                                            if (x) {
                                                break;
                                            }
                                            continue Label_0262_Outer;
                                        }
                                        else {
                                            int n7 = compare;
                                            Label_0428: {
                                                if (a2 != a) {
                                                    d.h(a3);
                                                    if (a2 == null) {
                                                        final byte b4 = array[((d)d.l().c()).b()];
                                                        if (b4 > 0) {
                                                            n7 = b4;
                                                        }
                                                        d.a(a3);
                                                        if (!x) {
                                                            break Label_0428;
                                                        }
                                                    }
                                                    byte b5 = 0;
                                                    Label_0356: {
                                                        if (a2.b() != null) {
                                                            b5 = array[((d)a2.b().c()).b()];
                                                            if (!x) {
                                                                break Label_0356;
                                                            }
                                                        }
                                                        b5 = -1;
                                                    }
                                                    final byte b6 = array[((d)a2.c()).b()];
                                                    d.a(a3, a2);
                                                    if (b5 > 0) {
                                                        n7 = b5;
                                                    }
                                                    if (b6 >= 0) {
                                                        break Label_0428;
                                                    }
                                                    n7 = b6;
                                                    if (!x) {
                                                        break Label_0428;
                                                    }
                                                }
                                                final byte b7 = array[((d)a2.c()).b()];
                                                if (b7 < 0) {
                                                    n7 = b7;
                                                }
                                            }
                                            ap.a(d2, b, (n7 == 0) ? aE.a((byte)(b ? 2 : 1)) : aE.a((byte)((n7 < 0) ? 8 : 4)));
                                            array[d2.b()] = (byte)n7;
                                            p7 = a2;
                                            --i;
                                            if (x) {
                                                break Label_0496;
                                            }
                                            continue Label_0262_Outer;
                                        }
                                    }
                                    a3 = a;
                                    a = a.a();
                                    continue;
                                }
                            }
                            return;
                        }
                    }
                    if (i != 0) {
                        final int n = i;
                        final int size = d.size();
                        continue;
                    }
                    break;
                }
                return;
            }
        }
    }
}
