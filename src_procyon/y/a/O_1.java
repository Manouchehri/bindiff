package y.a;

import y.g.a.*;
import y.c.*;
import java.util.*;

class O
{
    private i a;
    private int[] b;
    private int[] c;
    private int[] d;
    private int[] e;
    private int[] f;
    private int[] g;
    private int[] h;
    private int i;
    private int j;
    private int k;
    private P l;
    private boolean m;
    private g n;
    private boolean o;
    
    public O() {
        this.l = new P();
        this.m = false;
        this.o = true;
    }
    
    public int a(final i i, final c c, final c c2, final c c3, final c c4, final h h, final A a) {
        final boolean a2 = h.a;
        this.l.a();
        this.a(i, c, c2, c3, c4);
        int n = 0;
        int n2 = 0;
        final e p7 = this.a.p();
        while (true) {
        Label_0305_Outer:
            while (p7.f()) {
                final int b = p7.a().b();
                final int abs;
                final int n3 = abs = Math.abs(this.d[b]);
                final int n4 = n;
                if (!a2) {
                    if (abs > n4) {
                        n = n3;
                    }
                    if (this.c[b] > n2) {
                        n2 = this.c[b];
                    }
                    p7.g();
                    if (a2) {
                        i.g = !i.g;
                        break;
                    }
                    continue;
                }
                else {
                    if (abs < n4) {
                        throw new RuntimeException("MinCostFlow Error: maxPathCost overflow!");
                    }
                    final int n5 = n * this.j;
                    final f f = new f();
                    final q k = this.a.k();
                    final x o = this.a.o();
                    while (true) {
                        while (o.f()) {
                            final q e = o.e();
                            if (a2) {
                                final int[] array = new int[this.j];
                                final d[] array2 = new d[this.j];
                                final int[] array3 = new int[this.i];
                                final int[] array4 = new int[this.i];
                                final int[] array5 = new int[this.i];
                                final x o2 = this.a.o();
                                while (o2.f()) {
                                    final int d = o2.e().d();
                                    final int n6 = this.e[d];
                                    final int abs2 = Math.abs(n6);
                                    if (abs2 > n2) {
                                        n2 = abs2;
                                    }
                                    array[d] = n6;
                                    o2.g();
                                    if (a2) {
                                        break;
                                    }
                                }
                                final e a3 = f.a();
                                while (a3.f()) {
                                    final int b2 = a3.a().b();
                                    array3[b2] = Integer.MAX_VALUE;
                                    array4[b2] = n5;
                                    array5[b2] = Integer.MAX_VALUE;
                                    a3.g();
                                    if (a2) {
                                        break;
                                    }
                                }
                                final f f2 = new f();
                                final e p8 = this.a.p();
                                while (true) {
                                    while (p8.f()) {
                                        final d a4 = p8.a();
                                        final int b3 = a4.b();
                                        final int d2 = a4.c().d();
                                        final int d3 = a4.d().d();
                                        final int n7 = array3[b3];
                                        if (a2) {
                                            int n8 = n7;
                                        Label_1401_Outer:
                                            while (true) {
                                            Label_1401:
                                                while (true) {
                                                    while (n2 * this.i / (this.j * this.j) >= n8) {
                                                        n8 *= 2;
                                                        if (a2) {
                                                            f2.a();
                                                            final e p9;
                                                            final e e2 = p9;
                                                            while (true) {
                                                            Label_1544_Outer:
                                                                while (e2.f()) {
                                                                    final d a5 = e2.a();
                                                                    final int b4 = a5.b();
                                                                    if (a2) {
                                                                        int n9 = b4;
                                                                        e e3 = f.a();
                                                                        while (true) {
                                                                            while (e3.f()) {
                                                                                final int n10 = this.h[e3.a().b()];
                                                                                if (a2) {
                                                                                    Label_1604: {
                                                                                        while (true) {
                                                                                            if (n10 != 0) {
                                                                                                this.a.a(e3.a());
                                                                                                e3.g();
                                                                                                if (a2) {
                                                                                                    break Label_1604;
                                                                                                }
                                                                                                if (!a2) {
                                                                                                    e3.f();
                                                                                                    continue Label_1544_Outer;
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                        if (n9 == 0) {
                                                                                            throw new RuntimeException("MinCostFlow Error: no feasible flow found!");
                                                                                        }
                                                                                    }
                                                                                    int n11 = 0;
                                                                                    final e p10 = this.a.p();
                                                                                    while (true) {
                                                                                        while (p10.f()) {
                                                                                            final d a6 = p10.a();
                                                                                            final int b5 = a6.b();
                                                                                            final int[] h2 = this.h;
                                                                                            final int n12 = b5;
                                                                                            h2[n12] += this.b[b5];
                                                                                            final int n13 = n11 + this.h[b5] * this.d[b5];
                                                                                            if (a2) {
                                                                                                int n14 = n13;
                                                                                                int j = 0;
                                                                                                while (true) {
                                                                                                    int n16 = 0;
                                                                                                    while (j < this.j) {
                                                                                                        final int n15 = this.g[j];
                                                                                                        if (a2) {
                                                                                                            if (n15 != 0) {
                                                                                                                final int[] array6 = new int[this.j];
                                                                                                                int l = 0;
                                                                                                                while (l < this.j) {
                                                                                                                    n16 = array6[l];
                                                                                                                    if (a2) {
                                                                                                                        return n16;
                                                                                                                    }
                                                                                                                    if (n16 == 0 && !this.a(l, array6)) {
                                                                                                                        throw new RuntimeException("MinCostFlow check Error: found negative cost cycle!");
                                                                                                                    }
                                                                                                                    ++l;
                                                                                                                    if (a2) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                            this.l.b();
                                                                                                            return n16;
                                                                                                        }
                                                                                                        if (n15 < n14) {
                                                                                                            n14 = this.g[j];
                                                                                                        }
                                                                                                        ++j;
                                                                                                        if (a2) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    if (a != null) {
                                                                                                        final x o3 = this.a.o();
                                                                                                        while (o3.f()) {
                                                                                                            final q e4 = o3.e();
                                                                                                            a.a(e4, this.g[e4.d()] - n14);
                                                                                                            o3.g();
                                                                                                            if (a2) {
                                                                                                                return n16;
                                                                                                            }
                                                                                                            if (a2) {
                                                                                                                break;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    final boolean m = this.m;
                                                                                                    continue;
                                                                                                }
                                                                                            }
                                                                                            n11 = n13;
                                                                                            h.a(a6, this.h[b5]);
                                                                                            p10.g();
                                                                                            if (a2) {
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        continue;
                                                                                    }
                                                                                }
                                                                                if (n10 != 0) {
                                                                                    n9 = 0;
                                                                                }
                                                                                e3.g();
                                                                                if (a2) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            e3 = f.a();
                                                                            continue;
                                                                        }
                                                                    }
                                                                    final int n17 = b4;
                                                                    this.h[n17] = array3[n17] - this.h[n17];
                                                                    this.a.c(a5);
                                                                    e2.g();
                                                                    if (a2) {
                                                                        break;
                                                                    }
                                                                }
                                                                continue;
                                                            }
                                                        }
                                                        if (a2) {
                                                            break;
                                                        }
                                                    }
                                                    do {
                                                        int n18 = 0;
                                                    Label_0765:
                                                        while (n18 > 0) {
                                                            final P l2 = this.l;
                                                            ++l2.a;
                                                            final e p9 = this.a.p();
                                                            if (!a2) {
                                                                final e e5 = p9;
                                                                while (e5.f()) {
                                                                    final d a7 = e5.a();
                                                                    final int b6 = a7.b();
                                                                    final int d4 = a7.c().d();
                                                                    final int d5 = a7.d().d();
                                                                    final int n19 = array4[b6] + this.g[d4] - this.g[d5];
                                                                    n18 = array5[b6];
                                                                    if (a2) {
                                                                        continue Label_0765;
                                                                    }
                                                                    Label_1000: {
                                                                        if (n18 >= n8 && n19 < 0) {
                                                                            final int[] array7 = array;
                                                                            final int n20 = d5;
                                                                            array7[n20] += array5[b6];
                                                                            final int[] array8 = array;
                                                                            final int n21 = d4;
                                                                            array8[n21] -= array5[b6];
                                                                            this.h[b6] = array3[b6];
                                                                            array5[b6] = 0;
                                                                            if (!a2) {
                                                                                break Label_1000;
                                                                            }
                                                                        }
                                                                        if (this.h[b6] >= n8 && n19 > 0) {
                                                                            final int[] array9 = array;
                                                                            final int n22 = d4;
                                                                            array9[n22] += this.h[b6];
                                                                            final int[] array10 = array;
                                                                            final int n23 = d5;
                                                                            array10[n23] -= this.h[b6];
                                                                            this.h[b6] = 0;
                                                                            array5[b6] = array3[b6];
                                                                        }
                                                                    }
                                                                    e5.g();
                                                                    if (a2) {
                                                                        break;
                                                                    }
                                                                }
                                                                final x o4 = this.a.o();
                                                            Label_1389:
                                                                while (true) {
                                                                    while (o4.f()) {
                                                                        final q e6;
                                                                        final q q = e6 = o4.e();
                                                                        int d6 = 0;
                                                                    Label_1042:
                                                                        while (true) {
                                                                            q a8 = null;
                                                                            d6 = a8.d();
                                                                            if (!a2) {
                                                                                final int n24 = d6;
                                                                                while (array[n24] >= n8) {
                                                                                    final P l3 = this.l;
                                                                                    ++l3.b;
                                                                                    final q q2 = a8 = this.a(q, n8, array4, array5, this.h, array, array2);
                                                                                    if (a2) {
                                                                                        continue Label_1042;
                                                                                    }
                                                                                    if (a8 == null) {
                                                                                        break;
                                                                                    }
                                                                                    final int d7 = q2.d();
                                                                                    int n25 = array[n24];
                                                                                    q q3 = q2;
                                                                                Label_1348:
                                                                                    while (true) {
                                                                                    Label_1132:
                                                                                        while (true) {
                                                                                            Label_1237: {
                                                                                                final q q4;
                                                                                                final q d8;
                                                                                                if (q4 != d8) {
                                                                                                    final d d9 = array2[q3.d()];
                                                                                                    final int b7 = d9.b();
                                                                                                    int n26 = 0;
                                                                                                    Label_1197: {
                                                                                                        if (q3 == d9.d()) {
                                                                                                            n26 = array5[b7];
                                                                                                            q3 = d9.c();
                                                                                                            if (!a2) {
                                                                                                                break Label_1197;
                                                                                                            }
                                                                                                        }
                                                                                                        n26 = this.h[b7];
                                                                                                        q3 = d9.d();
                                                                                                    }
                                                                                                    if (n26 >= n25) {
                                                                                                        break;
                                                                                                    }
                                                                                                    n25 = n26;
                                                                                                    if (a2) {
                                                                                                        break Label_1237;
                                                                                                    }
                                                                                                    if (!a2) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                if (n25 > -array[d7]) {
                                                                                                    n25 = -array[d7];
                                                                                                }
                                                                                            }
                                                                                            q3 = q2;
                                                                                            while (q3 != q) {
                                                                                                final d d10 = array2[q3.d()];
                                                                                                final int b8 = d10.b();
                                                                                                final q q4 = q3;
                                                                                                final q d8 = d10.d();
                                                                                                if (a2) {
                                                                                                    continue Label_1132;
                                                                                                }
                                                                                                if (q4 == d8) {
                                                                                                    final int[] h3 = this.h;
                                                                                                    final int n27 = b8;
                                                                                                    h3[n27] += n25;
                                                                                                    final int[] array11 = array5;
                                                                                                    final int n28 = b8;
                                                                                                    array11[n28] -= n25;
                                                                                                    q3 = d10.c();
                                                                                                    if (!a2) {
                                                                                                        continue Label_0305_Outer;
                                                                                                    }
                                                                                                }
                                                                                                final int[] h4 = this.h;
                                                                                                final int n29 = b8;
                                                                                                h4[n29] -= n25;
                                                                                                final int[] array12 = array5;
                                                                                                final int n30 = b8;
                                                                                                array12[n30] += n25;
                                                                                                q3 = d10.d();
                                                                                                if (a2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            break Label_1348;
                                                                                        }
                                                                                    }
                                                                                    final int[] array13 = array;
                                                                                    final int n31 = n24;
                                                                                    array13[n31] -= n25;
                                                                                    final int[] array14 = array;
                                                                                    final int n32 = d7;
                                                                                    array14[n32] += n25;
                                                                                    if (a2) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            }
                                                                            break Label_1389;
                                                                        }
                                                                        o4.g();
                                                                        if (!a2) {
                                                                            continue Label_0305_Outer;
                                                                        }
                                                                        n8 = d6;
                                                                        continue Label_0765;
                                                                    }
                                                                    continue Label_1389;
                                                                }
                                                            }
                                                            continue Label_1401;
                                                        }
                                                        break;
                                                    } while (!a2);
                                                    break;
                                                }
                                                continue Label_1401_Outer;
                                            }
                                        }
                                        if (n7 != Integer.MAX_VALUE) {
                                            array3[b3] = this.c[b3];
                                            array4[b3] = this.d[b3];
                                            final int n33 = this.b[b3];
                                            if (n33 != 0) {
                                                final int[] array15 = array;
                                                final int n34 = d2;
                                                array15[n34] -= n33;
                                                final int[] array16 = array;
                                                final int n35 = d3;
                                                array16[n35] += n33;
                                                final int[] array17 = array3;
                                                final int n36 = b3;
                                                array17[n36] -= n33;
                                            }
                                            array5[b3] = array3[b3];
                                            if (array4[b3] < 0) {
                                                f2.add(a4);
                                                final int[] array18 = array;
                                                final int n37 = d2;
                                                array18[n37] -= array3[b3];
                                                final int[] array19 = array;
                                                final int n38 = d3;
                                                array19[n38] += array3[b3];
                                                array4[b3] = -array4[b3];
                                                this.a.c(a4);
                                            }
                                        }
                                        p8.g();
                                        if (a2) {
                                            break;
                                        }
                                    }
                                    continue;
                                }
                            }
                            if (e != k) {
                                f.add(this.a.a(e, k));
                                f.add(this.a.a(k, e));
                            }
                            o.g();
                            if (a2) {
                                break;
                            }
                        }
                        this.i = this.a.h();
                        this.g = new int[this.j];
                        this.h = new int[this.i];
                        continue;
                    }
                }
            }
            final int n39 = Integer.MAX_VALUE / this.j;
            continue;
        }
    }
    
    public int a(final i i, final c c, final c c2, final c c3, final h h, final A a) {
        return this.a(i, i.u(), c, c2, c3, h, a);
    }
    
    public int a(final i i, final q q, final q q2, final c c, final c c2, final h h, final A a) {
        final int a2 = new K().a(i, q, q2, c, h);
        final A t = i.t();
        t.a(q, a2);
        t.a(q2, -a2);
        return this.a(i, c, c2, t, h, a);
    }
    
    private void a(final i a, final c c, final c c2, final c c3, final c c4) {
        final boolean a2 = y.a.h.a;
        this.a = a;
        this.i = this.a.h();
        this.j = this.a.f();
        this.b = new int[this.i];
        this.c = new int[this.i];
        this.d = new int[this.i];
        this.e = new int[this.j];
        this.f = new int[this.j];
        if (this.o) {
            this.n = new j(this.a);
        }
        int n = 0;
        this.k = 1;
        final x o = this.a.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final int d = e.d();
                this.e[d] = c4.a(e);
                n += this.e[d];
                final int n2 = this.e[d];
                if (a2) {
                    if (n2 != 0) {
                        System.err.println("Warning: supply constraint broken!");
                    }
                    final e p5 = this.a.p();
                    while (p5.f()) {
                        final d a3 = p5.a();
                        final int b = a3.b();
                        this.d[b] = c3.a(a3);
                        if (c != null) {
                            this.b[b] = c.a(a3);
                        }
                        this.c[b] = c2.a(a3);
                        if (this.b[b] < 0 || this.c[b] < 0) {
                            throw new B("found negative capacity");
                        }
                        if (this.b[b] > this.c[b]) {
                            throw new B("found lCap > uCap");
                        }
                        if (this.c[b] == Integer.MAX_VALUE) {
                            this.c[b] = this.k;
                            if (this.b[b] == Integer.MAX_VALUE) {
                                throw new B("found infinite lCap");
                            }
                        }
                        p5.g();
                        if (a2) {
                            break;
                        }
                    }
                    return;
                }
                if (n2 > 0) {
                    this.k += this.e[d];
                }
                o.g();
                if (a2) {
                    break;
                }
            }
            continue;
        }
    }
    
    private q a(final q q, final int n, final int[] array, final int[] array2, final int[] array3, final int[] array4, final d[] array5) {
        final boolean a = y.a.h.a;
        this.n.d();
        int i = 0;
        while (i < this.j) {
            this.f[i] = Integer.MAX_VALUE;
            ++i;
            if (a) {
                break;
            }
        }
        q q2 = null;
        final ArrayList list = new ArrayList<q>(200);
        this.f[q.d()] = 0;
        this.n.a(q, 0);
    Label_0079:
        while (!this.n.a()) {
            final P l = this.l;
            ++l.c;
            final q c = this.n.c();
            final int d = c.d();
            list.add(c);
            final int n2 = array4[d];
            int n3 = -n;
            int j = 0;
        Label_0137:
            while (j > n3) {
                final int n4 = this.f[d] + this.g[d];
                d d2 = c.f();
                while (d2 != null) {
                    final int b = d2.b();
                    j = array2[b];
                    n3 = n;
                    if (a) {
                        continue Label_0137;
                    }
                    if (j >= n) {
                        final q d3 = d2.d();
                        final int d4 = d3.d();
                        final int n5 = n4 - this.g[d4] + array[b];
                        if (n5 < this.f[d4]) {
                            Label_0283: {
                                if (this.f[d4] == Integer.MAX_VALUE) {
                                    this.n.a(d3, n5);
                                    if (!a) {
                                        break Label_0283;
                                    }
                                }
                                this.n.b(d3, n5);
                            }
                            this.f[d4] = n5;
                            array5[d4] = d2;
                        }
                    }
                    d2 = d2.g();
                    if (a) {
                        break;
                    }
                }
                for (d d5 = c.g(); d5 != null; d5 = d5.h()) {
                    final int b2 = d5.b();
                    final int n6 = array3[b2];
                    n3 = n;
                    if (a) {
                        continue Label_0137;
                    }
                    if (n6 >= n) {
                        final q c2 = d5.c();
                        final int d6 = c2.d();
                        final int n7 = n4 - this.g[d6] - array[b2];
                        if (n7 < this.f[d6]) {
                            Label_0430: {
                                if (this.f[d6] == Integer.MAX_VALUE) {
                                    this.n.a(c2, n7);
                                    if (!a) {
                                        break Label_0430;
                                    }
                                }
                                this.n.b(c2, n7);
                            }
                            this.f[d6] = n7;
                            array5[d6] = d5;
                        }
                    }
                }
                continue Label_0079;
            }
            q2 = c;
            break;
        }
        q q3 = null;
        if (q2 != null) {
            final int n8 = this.f[q2.d()];
            int k = 0;
            while (k < list.size()) {
                q3 = list.get(k);
                if (a) {
                    break;
                }
                final int d7 = q3.d();
                final int[] g = this.g;
                final int n9 = d7;
                g[n9] += this.f[d7] - n8;
                ++k;
                if (a) {
                    break;
                }
            }
        }
        return q3;
    }
    
    private boolean a(final int n, final int[] array) {
        final boolean a = y.a.h.a;
        int i = 0;
        while (true) {
            while (i < this.j) {
                this.f[i] = Integer.MAX_VALUE;
                ++i;
                if (a) {
                    int n2 = 0;
                    while (true) {
                        do {
                            Label_0050: {
                                final int n3 = this.a.f() - 1;
                            }
                            int j = 0;
                            int n4 = 0;
                            Label_0061:
                            while (j <= n4) {
                                final e p2 = this.a.p();
                                if (!a) {
                                    final e e = p2;
                                    while (e.f()) {
                                        final d a2 = e.a();
                                        final int b = a2.b();
                                        final int d = a2.c().d();
                                        final int d2 = a2.d().d();
                                        j = this.h[b];
                                        n4 = this.c[b];
                                        if (a) {
                                            continue Label_0061;
                                        }
                                        if (j < n4 && this.f[d] != Integer.MAX_VALUE) {
                                            final int n5 = this.f[d] + this.d[b];
                                            if (this.f[d2] > n5) {
                                                this.f[d2] = n5;
                                                array[d2] = 1;
                                            }
                                        }
                                        if (this.h[b] > 0 && this.f[d2] != Integer.MAX_VALUE) {
                                            final int n6 = this.f[d2] - this.d[b];
                                            if (this.f[d] > n6) {
                                                this.f[d] = n6;
                                                array[d] = 1;
                                            }
                                        }
                                        e.g();
                                        if (a) {
                                            break;
                                        }
                                    }
                                    ++n2;
                                    continue Label_0050;
                                }
                                final e e2 = p2;
                                while (e2.f()) {
                                    final d a3 = e2.a();
                                    final int b2 = a3.b();
                                    final int d3 = a3.c().d();
                                    final int d4 = a3.d().d();
                                    final int n8;
                                    final int n7 = n8 = this.f[d3];
                                    if (a) {
                                        return n8 != 0;
                                    }
                                    if (n7 != Integer.MAX_VALUE && this.h[b2] < this.c[b2] && this.f[d4] > this.f[d3] + this.d[b2]) {
                                        return false;
                                    }
                                    if (this.f[d4] != Integer.MAX_VALUE && this.h[b2] > 0 && this.f[d3] > this.f[d4] - this.d[b2]) {
                                        return false;
                                    }
                                    e2.g();
                                    if (a) {
                                        break;
                                    }
                                }
                                int n8 = true ? 1 : 0;
                                return n8 != 0;
                            }
                            break;
                        } while (!a);
                        this.a.p();
                        continue;
                    }
                }
                if (a) {
                    break;
                }
            }
            this.f[n] = 0;
            array[n] = 1;
            continue;
        }
    }
}
