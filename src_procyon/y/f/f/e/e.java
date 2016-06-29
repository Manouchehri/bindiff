package y.f.f.e;

import y.c.*;

class e
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
    private g l;
    private boolean m;
    private boolean n;
    private f o;
    private h[] p;
    private int[] q;
    private int r;
    
    public e() {
        this.l = new g();
        this.m = false;
        this.n = true;
    }
    
    public int a(final i i, final c c, final c c2, final c c3, final c c4, final y.c.h h, final A a) {
        final int j = a.a;
        this.l.a();
        this.a(i, c, c2, c3, c4);
        int n = 0;
        int n2 = 0;
        final y.c.e p7 = this.a.p();
        while (true) {
        Label_0305_Outer:
            while (p7.f()) {
                final int b = p7.a().b();
                final int abs;
                final int n3 = abs = Math.abs(this.d[b]);
                final int n4 = n;
                if (j == 0) {
                    if (abs > n4) {
                        n = n3;
                    }
                    if (this.c[b] > n2) {
                        n2 = this.c[b];
                    }
                    p7.g();
                    if (j != 0) {
                        i.g = !i.g;
                        break;
                    }
                    continue;
                }
                else {
                    if (abs < n4) {
                        throw new RuntimeException("Internal error: maxPathCost overflow!");
                    }
                    final int n5 = n * this.j;
                    final y.c.f f = new y.c.f();
                    final q k = this.a.k();
                    final x o = this.a.o();
                    while (true) {
                        while (o.f()) {
                            final q e = o.e();
                            if (j != 0) {
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
                                    if (j != 0) {
                                        break;
                                    }
                                }
                                final y.c.e a2 = f.a();
                                while (a2.f()) {
                                    final int b2 = a2.a().b();
                                    array3[b2] = Integer.MAX_VALUE;
                                    array4[b2] = n5;
                                    array5[b2] = Integer.MAX_VALUE;
                                    a2.g();
                                    if (j != 0) {
                                        break;
                                    }
                                }
                                final y.c.f f2 = new y.c.f();
                                final y.c.e p8 = this.a.p();
                                while (true) {
                                    while (p8.f()) {
                                        final d a3 = p8.a();
                                        final int b3 = a3.b();
                                        final int d2 = a3.c().d();
                                        final int d3 = a3.d().d();
                                        final int n7 = array3[b3];
                                        if (j != 0) {
                                            int n8 = n7;
                                        Label_1401_Outer:
                                            while (true) {
                                            Label_1401:
                                                while (true) {
                                                    while (n2 * this.i / (this.j * this.j) >= n8) {
                                                        n8 *= 2;
                                                        if (j != 0) {
                                                            f2.a();
                                                            final y.c.e p9;
                                                            final y.c.e e2 = p9;
                                                            while (true) {
                                                            Label_1544_Outer:
                                                                while (e2.f()) {
                                                                    final d a4 = e2.a();
                                                                    final int b4 = a4.b();
                                                                    if (j != 0) {
                                                                        int n9 = b4;
                                                                        y.c.e e3 = f.a();
                                                                        while (true) {
                                                                            while (e3.f()) {
                                                                                final int n10 = this.h[e3.a().b()];
                                                                                if (j != 0) {
                                                                                    Label_1604: {
                                                                                        while (true) {
                                                                                            if (n10 != 0) {
                                                                                                this.a.a(e3.a());
                                                                                                e3.g();
                                                                                                if (j != 0) {
                                                                                                    break Label_1604;
                                                                                                }
                                                                                                if (j == 0) {
                                                                                                    e3.f();
                                                                                                    continue Label_1544_Outer;
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                        if (n9 == 0) {
                                                                                            throw new RuntimeException("Internal error: no feasible flow found!");
                                                                                        }
                                                                                    }
                                                                                    int n11 = 0;
                                                                                    final y.c.e p10 = this.a.p();
                                                                                    while (true) {
                                                                                        while (p10.f()) {
                                                                                            final d a5 = p10.a();
                                                                                            final int b5 = a5.b();
                                                                                            final int[] h2 = this.h;
                                                                                            final int n12 = b5;
                                                                                            h2[n12] += this.b[b5];
                                                                                            final int n13 = n11 + this.h[b5] * this.d[b5];
                                                                                            if (j != 0) {
                                                                                                int n14 = n13;
                                                                                                int l = 0;
                                                                                                while (true) {
                                                                                                    int n17 = 0;
                                                                                                    while (l < this.j) {
                                                                                                        final int n15 = this.g[l];
                                                                                                        if (j != 0) {
                                                                                                            if (n15 != 0) {
                                                                                                                final int[] array6 = new int[this.j];
                                                                                                                int n16 = 0;
                                                                                                                while (n16 < this.j) {
                                                                                                                    n17 = array6[n16];
                                                                                                                    if (j != 0) {
                                                                                                                        return n17;
                                                                                                                    }
                                                                                                                    if (n17 == 0 && !this.a(n16, array6)) {
                                                                                                                        throw new RuntimeException("Internal error: negative cost cycle found!");
                                                                                                                    }
                                                                                                                    ++n16;
                                                                                                                    if (j != 0) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                            this.l.b();
                                                                                                            return n17;
                                                                                                        }
                                                                                                        if (n15 < n14) {
                                                                                                            n14 = this.g[l];
                                                                                                        }
                                                                                                        ++l;
                                                                                                        if (j != 0) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    if (a != null) {
                                                                                                        final x o3 = this.a.o();
                                                                                                        while (o3.f()) {
                                                                                                            final q e4 = o3.e();
                                                                                                            a.a(e4, this.g[e4.d()] - n14);
                                                                                                            o3.g();
                                                                                                            if (j != 0) {
                                                                                                                return n17;
                                                                                                            }
                                                                                                            if (j != 0) {
                                                                                                                break;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    final boolean m = this.m;
                                                                                                    continue;
                                                                                                }
                                                                                            }
                                                                                            n11 = n13;
                                                                                            h.a(a5, this.h[b5]);
                                                                                            p10.g();
                                                                                            if (j != 0) {
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
                                                                                if (j != 0) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            e3 = f.a();
                                                                            continue;
                                                                        }
                                                                    }
                                                                    final int n18 = b4;
                                                                    this.h[n18] = array3[n18] - this.h[n18];
                                                                    this.a.c(a4);
                                                                    e2.g();
                                                                    if (j != 0) {
                                                                        break;
                                                                    }
                                                                }
                                                                continue;
                                                            }
                                                        }
                                                        if (j != 0) {
                                                            break;
                                                        }
                                                    }
                                                    do {
                                                        int n19 = 0;
                                                    Label_0765:
                                                        while (n19 > 0) {
                                                            final g l2 = this.l;
                                                            ++l2.a;
                                                            final y.c.e p9 = this.a.p();
                                                            if (j == 0) {
                                                                final y.c.e e5 = p9;
                                                                while (e5.f()) {
                                                                    final d a6 = e5.a();
                                                                    final int b6 = a6.b();
                                                                    final int d4 = a6.c().d();
                                                                    final int d5 = a6.d().d();
                                                                    final int n20 = array4[b6] + this.g[d4] - this.g[d5];
                                                                    n19 = array5[b6];
                                                                    if (j != 0) {
                                                                        continue Label_0765;
                                                                    }
                                                                    Label_1000: {
                                                                        if (n19 >= n8 && n20 < 0) {
                                                                            final int[] array7 = array;
                                                                            final int n21 = d5;
                                                                            array7[n21] += array5[b6];
                                                                            final int[] array8 = array;
                                                                            final int n22 = d4;
                                                                            array8[n22] -= array5[b6];
                                                                            this.h[b6] = array3[b6];
                                                                            array5[b6] = 0;
                                                                            if (j == 0) {
                                                                                break Label_1000;
                                                                            }
                                                                        }
                                                                        if (this.h[b6] >= n8 && n20 > 0) {
                                                                            final int[] array9 = array;
                                                                            final int n23 = d4;
                                                                            array9[n23] += this.h[b6];
                                                                            final int[] array10 = array;
                                                                            final int n24 = d5;
                                                                            array10[n24] -= this.h[b6];
                                                                            this.h[b6] = 0;
                                                                            array5[b6] = array3[b6];
                                                                        }
                                                                    }
                                                                    e5.g();
                                                                    if (j != 0) {
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
                                                                            q a7 = null;
                                                                            d6 = a7.d();
                                                                            if (j == 0) {
                                                                                final int n25 = d6;
                                                                                while (array[n25] >= n8) {
                                                                                    final g l3 = this.l;
                                                                                    ++l3.b;
                                                                                    final q q2 = a7 = this.a(q, n8, array4, array5, this.h, array, array2);
                                                                                    if (j != 0) {
                                                                                        continue Label_1042;
                                                                                    }
                                                                                    if (a7 == null) {
                                                                                        break;
                                                                                    }
                                                                                    final int d7 = q2.d();
                                                                                    int n26 = array[n25];
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
                                                                                                    int n27 = 0;
                                                                                                    Label_1197: {
                                                                                                        if (q3 == d9.d()) {
                                                                                                            n27 = array5[b7];
                                                                                                            q3 = d9.c();
                                                                                                            if (j == 0) {
                                                                                                                break Label_1197;
                                                                                                            }
                                                                                                        }
                                                                                                        n27 = this.h[b7];
                                                                                                        q3 = d9.d();
                                                                                                    }
                                                                                                    if (n27 >= n26) {
                                                                                                        break;
                                                                                                    }
                                                                                                    n26 = n27;
                                                                                                    if (j != 0) {
                                                                                                        break Label_1237;
                                                                                                    }
                                                                                                    if (j == 0) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                if (n26 > -array[d7]) {
                                                                                                    n26 = -array[d7];
                                                                                                }
                                                                                            }
                                                                                            q3 = q2;
                                                                                            while (q3 != q) {
                                                                                                final d d10 = array2[q3.d()];
                                                                                                final int b8 = d10.b();
                                                                                                final q q4 = q3;
                                                                                                final q d8 = d10.d();
                                                                                                if (j != 0) {
                                                                                                    continue Label_1132;
                                                                                                }
                                                                                                if (q4 == d8) {
                                                                                                    final int[] h3 = this.h;
                                                                                                    final int n28 = b8;
                                                                                                    h3[n28] += n26;
                                                                                                    final int[] array11 = array5;
                                                                                                    final int n29 = b8;
                                                                                                    array11[n29] -= n26;
                                                                                                    q3 = d10.c();
                                                                                                    if (j == 0) {
                                                                                                        continue Label_0305_Outer;
                                                                                                    }
                                                                                                }
                                                                                                final int[] h4 = this.h;
                                                                                                final int n30 = b8;
                                                                                                h4[n30] -= n26;
                                                                                                final int[] array12 = array5;
                                                                                                final int n31 = b8;
                                                                                                array12[n31] += n26;
                                                                                                q3 = d10.d();
                                                                                                if (j != 0) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            break Label_1348;
                                                                                        }
                                                                                    }
                                                                                    final int[] array13 = array;
                                                                                    final int n32 = n25;
                                                                                    array13[n32] -= n26;
                                                                                    final int[] array14 = array;
                                                                                    final int n33 = d7;
                                                                                    array14[n33] += n26;
                                                                                    if (j != 0) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            }
                                                                            break Label_1389;
                                                                        }
                                                                        o4.g();
                                                                        if (j == 0) {
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
                                                    } while (j == 0);
                                                    break;
                                                }
                                                continue Label_1401_Outer;
                                            }
                                        }
                                        if (n7 != Integer.MAX_VALUE) {
                                            array3[b3] = this.c[b3];
                                            array4[b3] = this.d[b3];
                                            final int n34 = this.b[b3];
                                            if (n34 != 0) {
                                                final int[] array15 = array;
                                                final int n35 = d2;
                                                array15[n35] -= n34;
                                                final int[] array16 = array;
                                                final int n36 = d3;
                                                array16[n36] += n34;
                                                final int[] array17 = array3;
                                                final int n37 = b3;
                                                array17[n37] -= n34;
                                            }
                                            array5[b3] = array3[b3];
                                            if (array4[b3] < 0) {
                                                f2.add(a3);
                                                final int[] array18 = array;
                                                final int n38 = d2;
                                                array18[n38] -= array3[b3];
                                                final int[] array19 = array;
                                                final int n39 = d3;
                                                array19[n39] += array3[b3];
                                                array4[b3] = -array4[b3];
                                                this.a.c(a3);
                                            }
                                        }
                                        p8.g();
                                        if (j != 0) {
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
                            if (j != 0) {
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
            final int n40 = Integer.MAX_VALUE / this.j;
            continue;
        }
    }
    
    private void a(final i a, final c c, final c c2, final c c3, final c c4) {
        final int a2 = a.a;
        this.a = a;
        this.i = this.a.h();
        this.j = this.a.f();
        this.b = new int[this.i];
        this.c = new int[this.i];
        this.d = new int[this.i];
        this.e = new int[this.j];
        this.f = new int[this.j];
        this.o = new f(this.j);
        this.p = new h[this.j];
        this.q = new int[this.j];
        int n = 0;
        this.k = 1;
        final x o = this.a.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final int d = e.d();
                this.p[d] = new h(e, d);
                this.e[d] = c4.a(e);
                n += this.e[d];
                final int n2 = this.e[d];
                if (a2 != 0) {
                    if (n2 != 0) {
                        System.err.println("Warning: supply constraint broken!");
                    }
                    final y.c.e p5 = this.a.p();
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
                        if (a2 != 0) {
                            break;
                        }
                    }
                    return;
                }
                if (n2 > 0) {
                    this.k += this.e[d];
                }
                o.g();
                if (a2 != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    private q a(final q q, final int n, final int[] array, final int[] array2, final int[] array3, final int[] array4, final d[] array5) {
        final int a = y.f.f.e.a.a;
        int i = 0;
        while (i < this.j) {
            this.f[i] = Integer.MAX_VALUE;
            ++i;
            if (a != 0) {
                break;
            }
        }
        q q2 = null;
        final int d = q.d();
        this.f[d] = 0;
        this.o.a();
        this.o.a(0, this.p[d]);
        this.r = 0;
    Label_0078:
        while (!this.o.c()) {
            final g l = this.l;
            ++l.c;
            final h b = this.o.b();
            this.o.a(b);
            final q b2 = b.b;
            final int c = b.c;
            this.q[this.r++] = c;
            final int n2 = array4[c];
            int n3 = -n;
            int j = 0;
        Label_0158:
            while (j > n3) {
                final int n4 = this.f[c] + this.g[c];
                d d2 = b2.f();
                while (d2 != null) {
                    final int b3 = d2.b();
                    j = array2[b3];
                    n3 = n;
                    if (a != 0) {
                        continue Label_0158;
                    }
                    if (j >= n) {
                        final int d3 = d2.d().d();
                        final int n5 = n4 - this.g[d3] + array[b3];
                        if (n5 < this.f[d3]) {
                            Label_0310: {
                                if (this.f[d3] == Integer.MAX_VALUE) {
                                    this.o.a(n5, this.p[d3]);
                                    if (a == 0) {
                                        break Label_0310;
                                    }
                                }
                                this.o.a(this.p[d3], n5);
                            }
                            this.f[d3] = n5;
                            array5[d3] = d2;
                        }
                    }
                    d2 = d2.g();
                    if (a != 0) {
                        break;
                    }
                }
                for (d d4 = b2.g(); d4 != null; d4 = d4.h()) {
                    final int b4 = d4.b();
                    final int n6 = array3[b4];
                    n3 = n;
                    if (a != 0) {
                        continue Label_0158;
                    }
                    if (n6 >= n) {
                        final int d5 = d4.c().d();
                        final int n7 = n4 - this.g[d5] - array[b4];
                        if (n7 < this.f[d5]) {
                            Label_0463: {
                                if (this.f[d5] == Integer.MAX_VALUE) {
                                    this.o.a(n7, this.p[d5]);
                                    if (a == 0) {
                                        break Label_0463;
                                    }
                                }
                                this.o.a(this.p[d5], n7);
                            }
                            this.f[d5] = n7;
                            array5[d5] = d4;
                        }
                    }
                }
                continue Label_0078;
            }
            q2 = b2;
            break;
        }
        if (q2 != null) {
            final int n8 = this.f[q2.d()];
            int k = this.r - 1;
            while (k >= 0) {
                final int n9 = this.q[k];
                final int[] g = this.g;
                final int n10 = n9;
                g[n10] += this.f[n9] - n8;
                --k;
                if (a != 0) {
                    break;
                }
            }
        }
        return q2;
    }
    
    private boolean a(final int n, final int[] array) {
        final int i = y.f.f.e.a.a;
        int j = 0;
        while (true) {
            while (j < this.j) {
                this.f[j] = Integer.MAX_VALUE;
                ++j;
                if (i != 0) {
                    int n2 = 0;
                    while (true) {
                        do {
                            Label_0050: {
                                final int n3 = this.a.f() - 1;
                            }
                            int k = 0;
                            int n4 = 0;
                            Label_0061:
                            while (k <= n4) {
                                final y.c.e p2 = this.a.p();
                                if (i == 0) {
                                    final y.c.e e = p2;
                                    while (e.f()) {
                                        final d a = e.a();
                                        final int b = a.b();
                                        final int d = a.c().d();
                                        final int d2 = a.d().d();
                                        k = this.h[b];
                                        n4 = this.c[b];
                                        if (i != 0) {
                                            continue Label_0061;
                                        }
                                        if (k < n4 && this.f[d] != Integer.MAX_VALUE) {
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
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                    ++n2;
                                    continue Label_0050;
                                }
                                final y.c.e e2 = p2;
                                while (e2.f()) {
                                    final d a2 = e2.a();
                                    final int b2 = a2.b();
                                    final int d3 = a2.c().d();
                                    final int d4 = a2.d().d();
                                    final int n8;
                                    final int n7 = n8 = this.f[d3];
                                    if (i != 0) {
                                        return n8 != 0;
                                    }
                                    if (n7 != Integer.MAX_VALUE && this.h[b2] < this.c[b2] && this.f[d4] > this.f[d3] + this.d[b2]) {
                                        return false;
                                    }
                                    if (this.f[d4] != Integer.MAX_VALUE && this.h[b2] > 0 && this.f[d3] > this.f[d4] - this.d[b2]) {
                                        return false;
                                    }
                                    e2.g();
                                    if (i != 0) {
                                        break;
                                    }
                                }
                                int n8 = true ? 1 : 0;
                                return n8 != 0;
                            }
                            break;
                        } while (i == 0);
                        this.a.p();
                        continue;
                    }
                }
                if (i != 0) {
                    break;
                }
            }
            this.f[n] = 0;
            array[n] = 1;
            continue;
        }
    }
}
