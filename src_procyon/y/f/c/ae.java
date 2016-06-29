package y.f.c;

import y.g.*;
import y.a.*;
import y.c.*;
import y.f.*;

public class ae extends a
{
    private long o;
    private int p;
    private int q;
    private boolean r;
    
    public ae() {
        this.o = Long.MAX_VALUE;
        this.p = 32000;
        this.q = 40;
        this.r = false;
    }
    
    protected void a(final y[] array, final c c) {
        final boolean i = y.f.c.a.i;
        this.a(this.g, array);
        final int[] array2 = new int[this.g.e()];
        int j = 0;
    Label_0101_Outer:
        while (j < array.length) {
            int n = 0;
            final x a = array[j].a();
            while (true) {
                while (a.f()) {
                    array2[a.e().d()] = n++;
                    a.g();
                    if (!i) {
                        if (i) {
                            break;
                        }
                        continue Label_0101_Outer;
                    }
                    else {
                        if (i) {
                            break Label_0101_Outer;
                        }
                        continue Label_0101_Outer;
                    }
                }
                ++j;
                continue;
            }
        }
        final f f = new f();
        final d[] array3 = new d[array.length - 1];
        int n2 = 0;
        do {
            int k = 0;
        Label_0129:
            while (k < array.length - 1) {
                final x a2 = array[n2].a();
                while (a2.f()) {
                    k = a2.e().c();
                    if (i) {
                        continue Label_0129;
                    }
                    if (k > 0) {
                        array3[n2] = a2.e().f();
                    }
                    a2.g();
                    if (i) {
                        break;
                    }
                }
                if (array3[n2] == null) {
                    f.add(array3[n2] = this.g.a(array[n2].b(), array[n2 + 1].b()));
                }
                ++n2;
            }
            break;
        } while (!i);
        final h b = M.b(new boolean[this.g.g()]);
        V.a(array, b, this.e, array2);
        final i l = new i();
        final h u = l.u();
        final h u2 = l.u();
        final h u3 = l.u();
        final A t = l.t();
        final q[] array4 = new q[this.g.g()];
        final q[] array5 = new q[this.g.e()];
        int n3 = 0;
        int r = 0;
        q q;
        q q2;
        int n4;
        int n5 = 0;
        int[] array6;
        x x;
        int n6;
        boolean b2;
        boolean b3;
        int n7;
        d d;
        int b4;
        q q3;
        q q4;
        q q5 = null;
        int n8;
        boolean a3;
        boolean a4;
        int n9;
        d d2;
        q q6;
        q q7;
        q q8;
        int b5;
        int[] array7;
        int n10;
        int n11;
        e p2;
        d a5;
        int b6;
        int[] array8;
        int n12;
        int[] array9;
        int n13;
        int n14 = 0;
        d d3;
        int b7;
        int n15;
        q q9;
        q q10;
        q d4;
        d a6;
        d a7;
        double n16;
        double n17;
        int n18;
        int n19;
        int n20;
        d d5;
        e m;
        x o;
        q e;
        e a8;
        x a9;
        q e2;
        int d6;
        d a10;
        int n21;
        int n22;
        d d7;
        int n23;
        x a11;
        Label_0827:Label_0834_Outer:
        while (true) {
        Label_0834:
            while (true) {
                do {
                Label_1091_Outer:
                    while (r < array.length) {
                        q = null;
                        q2 = null;
                        n4 = 0;
                        if (i) {
                            this.g.g();
                            array6 = new int[n5];
                            x = this.g.o();
                            while (true) {
                                while (x.f()) {
                                    n6 = (x.e().c() & 0x1);
                                    b2 = true;
                                Label_1779:
                                    while (true) {
                                    Label_1389:
                                        while (true) {
                                            Label_1399: {
                                                if (!i) {
                                                    b3 = (n6 == (b2 ? 1 : 0));
                                                    n7 = -x.e().c() / 2;
                                                    d = x.e().f();
                                                    while (d != null) {
                                                        b4 = d.b();
                                                        q3 = array5[d.c().d()];
                                                        q4 = array5[d.d().d()];
                                                        q5 = q3;
                                                        if (i) {
                                                            break Label_1399;
                                                        }
                                                        if (q5 != q4) {
                                                            n8 = this.q;
                                                            if (!b.d(d)) {
                                                                a3 = a(this.g, d.c());
                                                                a4 = a(this.g, d.d());
                                                                if (a3 && a4) {
                                                                    n8 = this.p;
                                                                }
                                                            }
                                                            if (b3 && n7 == 0) {
                                                                n8 += this.q * 4;
                                                            }
                                                            array6[b4] = n8;
                                                        }
                                                        d = d.g();
                                                        ++n7;
                                                        if (i) {
                                                            break;
                                                        }
                                                    }
                                                    x.g();
                                                    if (i) {
                                                        break;
                                                    }
                                                    continue Label_0834_Outer;
                                                }
                                                else {
                                                    while (true) {
                                                        if (n6 == (b2 ? 1 : 0)) {
                                                            n9 = -x.e().b() / 2;
                                                            d2 = x.e().g();
                                                            while (d2 != null) {
                                                                q6 = array5[d2.c().d()];
                                                                q7 = array5[d2.d().d()];
                                                                q8 = q6;
                                                                if (i) {
                                                                    break Label_1399;
                                                                }
                                                                if (q8 != q7) {
                                                                    if (n9 == 0) {
                                                                        b5 = d2.b();
                                                                        array7 = array6;
                                                                        n10 = b5;
                                                                        array7[n10] += this.q * 4;
                                                                    }
                                                                }
                                                                d2 = d2.h();
                                                                ++n9;
                                                                if (i) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        x.g();
                                                        if (!i) {
                                                            if (x.f()) {
                                                                n11 = (x.e().b() & 0x1);
                                                                if (!i) {
                                                                    continue Label_1091_Outer;
                                                                }
                                                                break Label_1389;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    p2 = this.g.p();
                                                    while (p2.f()) {
                                                        a5 = p2.a();
                                                        b6 = a5.b();
                                                        array8 = array6;
                                                        n12 = b6;
                                                        array8[n12] *= (int)(1.0 - 0.1 * Math.min(8, a5.c().c() + a5.d().b() - 2));
                                                        if (b.d(a5)) {
                                                            array9 = array6;
                                                            n13 = b6;
                                                            array9[n13] *= (int)0.5;
                                                        }
                                                        p2.g();
                                                        if (i) {
                                                            break;
                                                        }
                                                    }
                                                    x = this.g.o();
                                                }
                                                x.f();
                                                if (n14 == 0) {
                                                    break Label_1779;
                                                }
                                                x.e();
                                            }
                                            d3 = q5.f();
                                            while (d3 != null) {
                                                b7 = d3.b();
                                                n15 = (n14 = array6[b7]);
                                                if (i) {
                                                    continue Label_1389;
                                                }
                                                Label_1755: {
                                                    if (n14 > 0) {
                                                        q9 = array5[d3.c().d()];
                                                        q10 = array5[d3.d().d()];
                                                        d4 = l.d();
                                                        array4[b7] = d4;
                                                        a6 = l.a(d4, q9);
                                                        a7 = l.a(d4, q10);
                                                        u.a(a6, n15);
                                                        u.a(a7, n15);
                                                        n16 = 2520.0 * this.g.n(d3).a();
                                                        n17 = 2520.0 * this.g.o(d3).a();
                                                        Label_1699: {
                                                            if (n16 > n17) {
                                                                n18 = (int)Math.rint(n16 - n17);
                                                                u2.a(a6, 0);
                                                                u2.a(a7, n18);
                                                                t.a(d4, Math.min(t.a(q9), t.a(q10) - n18));
                                                                if (!i) {
                                                                    break Label_1699;
                                                                }
                                                            }
                                                            n19 = (int)Math.rint(n17 - n16);
                                                            u2.a(a6, n19);
                                                            u2.a(a7, 0);
                                                            t.a(d4, Math.min(t.a(q9) - n19, t.a(q10)));
                                                        }
                                                        if (t.a(q9) - t.a(d4) == u2.a(a6)) {
                                                            u3.a(a6, true);
                                                            if (!i) {
                                                                break Label_1755;
                                                            }
                                                        }
                                                        u3.a(a7, true);
                                                    }
                                                }
                                                d3 = d3.g();
                                                if (i) {
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        x.g();
                                        if (!i) {
                                            continue;
                                        }
                                        break;
                                    }
                                    Label_1924: {
                                        Label_1904: {
                                            Label_1876: {
                                                if (!this.r) {
                                                    n20 = 0;
                                                Label_1792:
                                                    while (n20 < array.length - 1) {
                                                        d5 = array3[n20];
                                                        if (!i) {
                                                            m = array4[d5.b()].l();
                                                            while (true) {
                                                                while (m.f()) {
                                                                    u3.a(m.a(), true);
                                                                    m.g();
                                                                    if (!i) {
                                                                        if (i) {
                                                                            break;
                                                                        }
                                                                        continue Label_0834_Outer;
                                                                    }
                                                                    else {
                                                                        if (i) {
                                                                            break Label_1876;
                                                                        }
                                                                        continue Label_1792;
                                                                    }
                                                                }
                                                                ++n20;
                                                                continue;
                                                            }
                                                        }
                                                        break Label_1904;
                                                    }
                                                }
                                            }
                                            if (this.r) {
                                                y.a.u.a(l, t, u, u2, this.o);
                                                if (!i) {
                                                    break Label_1924;
                                                }
                                            }
                                        }
                                        y.a.u.a(l, t, u, u2, u3, null, true, this.o);
                                    }
                                    o = this.g.o();
                                    while (o.f()) {
                                        e = o.e();
                                        this.g.a(e, t.a(array5[e.d()]) / 2520.0, this.g.k(e));
                                        o.g();
                                        if (i) {
                                            break;
                                        }
                                    }
                                    a8 = f.a();
                                    while (a8.f()) {
                                        this.g.a(a8.a());
                                        a8.g();
                                        if (i) {
                                            break;
                                        }
                                    }
                                    return;
                                }
                                x = this.g.o();
                                continue;
                            }
                        }
                        a9 = array[n3].a();
                        while (a9.f()) {
                            e2 = a9.e();
                            d6 = e2.d();
                            r = (this.r ? 1 : 0);
                            if (i) {
                                continue Label_1091_Outer;
                            }
                            Label_0505: {
                                if (r != 0 && a(this.g, e2) && a(this.g, e2.g().c()) && a(this.g, e2.f().d()) && !b.d(e2.g())) {
                                    array5[d6] = array5[e2.g().c().d()];
                                    if (!i) {
                                        break Label_0505;
                                    }
                                }
                                array5[d6] = l.d();
                            }
                            if (q != null) {
                                a10 = l.a(q, array5[d6]);
                                u3.a(a10, true);
                                u.a(a10, 0);
                                n21 = (int)(2520.0 * (this.g(q2) + (this.g.p(q2) + this.g.p(e2)) * 0.5));
                                u2.a(a10, n21);
                                n4 += n21;
                            }
                            t.a(array5[d6], n4);
                            q = array5[d6];
                            q2 = e2;
                            a9.g();
                            if (i) {
                                break;
                            }
                        }
                        ++n3;
                    }
                    break;
                } while (!i);
                if (!this.r) {
                    n22 = 0;
                Label_0654:
                    while (n22 < array.length - 1) {
                        d7 = array3[n22];
                        n5 = t.a(array5[d7.c().d()]) - t.a(array5[d7.d().d()]) + (int)(2520.0 * (this.g.n(d7).a() - this.g.o(d7).a()));
                        if (!i) {
                            n23 = n5;
                            a11 = array[n22 + 1].a();
                            while (true) {
                                while (a11.f()) {
                                    a(array5[a11.e().d()], t, n23);
                                    a11.g();
                                    if (!i) {
                                        if (i) {
                                            break;
                                        }
                                        continue Label_0834_Outer;
                                    }
                                    else {
                                        if (i) {
                                            continue Label_0827;
                                        }
                                        continue Label_0654;
                                    }
                                }
                                ++n22;
                                continue;
                            }
                        }
                        continue Label_0834;
                    }
                }
                break;
            }
            continue Label_0827;
        }
    }
    
    private static void a(final q q, final A a, final int n) {
        a.a(q, a.a(q) + n);
    }
    
    protected static boolean a(final X x, final q q) {
        return x.p(q) <= 1.0 && (q.b() == 1 && q.c() == 1);
    }
}
