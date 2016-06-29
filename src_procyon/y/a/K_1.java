package y.a;

import y.c.*;

class K
{
    private q[] a;
    private d[] b;
    private int[] c;
    private int[] d;
    private int[] e;
    private int[] f;
    private int[] g;
    private int h;
    private int i;
    private q j;
    private q k;
    private i l;
    private int m;
    private int n;
    private int o;
    private R p;
    private boolean q;
    private y r;
    private y s;
    private L t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    
    public K() {
        this.w = 5;
        this.t = new L();
        this.q = true;
    }
    
    public int a(final i i, final q q, final q q2, final c c, final h h) {
        final boolean a = h.a;
        this.t.a();
        if (q2 == q) {
            throw new B("source == sink");
        }
        if (q.c() == 0 || q2.b() == 0) {
            this.t.b();
            return 0;
        }
        this.a(i, q, q2, c);
    Label_0059:
        while (true) {
        Label_1478_Outer:
            while (true) {
                final q a2 = this.p.a();
                Label_0205: {
                    if (a2 == null) {
                        final int m = this.m;
                        int j = 0;
                        int h2 = 0;
                    Label_0126_Outer:
                        while (j != h2) {
                            int k = 0;
                            while (true) {
                                while (k < this.h) {
                                    this.c[k] = this.h;
                                    ++k;
                                    if (!a) {
                                        if (a) {
                                            break;
                                        }
                                        continue Label_0126_Outer;
                                    }
                                    else {
                                        int l = 0;
                                        while (l < this.h) {
                                            j = this.c[l];
                                            h2 = this.h;
                                            if (a) {
                                                continue Label_0126_Outer;
                                            }
                                            if (j == h2) {
                                                this.r.add(this.a[l]);
                                                this.c[l] = this.n;
                                            }
                                            ++l;
                                            if (a) {
                                                break;
                                            }
                                        }
                                        this.m = 2;
                                        this.b();
                                        if (a) {
                                            break Label_0205;
                                        }
                                        continue Label_0059;
                                    }
                                }
                                this.a();
                                continue Label_1478_Outer;
                            }
                        }
                        break;
                    }
                }
                a2.d();
                Label_1419: {
                Label_1405:
                    while (true) {
                        int n2 = 0;
                        final int n = n2;
                        if (a2 == this.k) {
                            continue Label_0059;
                        }
                        final int n3 = this.c[n];
                        final int h3 = this.h;
                        int c2 = 0;
                        int x = 0;
                    Label_1328_Outer:
                        while (c2 != x || this.m != 1) {
                            int n4 = this.d[n];
                            final int n5 = this.c[n];
                            int n6 = Integer.MAX_VALUE;
                            int n8 = 0;
                            if (this.c[n] < this.h) {
                                final e l2 = a2.l();
                                while (l2.f()) {
                                    final L t = this.t;
                                    ++t.c;
                                    final d a3 = l2.a();
                                    final int b = a3.b();
                                    final int n7 = n8 = this.f[b] - this.e[b];
                                    if (a) {
                                        break;
                                    }
                                    Label_0510: {
                                        if (n8 != 0) {
                                            final q d = a3.d();
                                            final int d2 = d.d();
                                            final int n9 = this.c[d2];
                                            if (n9 < n5) {
                                                final L t2 = this.t;
                                                ++t2.b;
                                                if (this.d[d2] == 0) {
                                                    this.p.b(d, n9);
                                                }
                                                if (n4 <= n7) {
                                                    final int[] d3 = this.d;
                                                    final int n10 = d2;
                                                    d3[n10] += n4;
                                                    final int[] e = this.e;
                                                    final int n11 = b;
                                                    e[n11] += n4;
                                                    n4 = 0;
                                                    if (!a) {
                                                        break;
                                                    }
                                                }
                                                final int[] d4 = this.d;
                                                final int n12 = d2;
                                                d4[n12] += n7;
                                                final int[] e2 = this.e;
                                                final int n13 = b;
                                                e2[n13] += n7;
                                                n4 -= n7;
                                                if (!a) {
                                                    break Label_0510;
                                                }
                                            }
                                            if (n9 < n6) {
                                                n6 = n9;
                                            }
                                        }
                                    }
                                    l2.g();
                                    if (a) {
                                        break;
                                    }
                                }
                            }
                            int n14 = 0;
                            Label_0774: {
                                if (n8 > 0) {
                                    final e k2 = a2.k();
                                    while (k2.f()) {
                                        final L t3 = this.t;
                                        ++t3.c;
                                        final d a4 = k2.a();
                                        final int b2 = a4.b();
                                        n14 = this.e[b2];
                                        if (a) {
                                            break Label_0774;
                                        }
                                        Label_0751: {
                                            if (n14 != 0) {
                                                final q c3 = a4.c();
                                                final int d5 = c3.d();
                                                final int n15 = this.c[d5];
                                                if (n15 < n5) {
                                                    final L t4 = this.t;
                                                    ++t4.b;
                                                    if (this.d[d5] == 0) {
                                                        this.p.b(c3, n15);
                                                    }
                                                    if (n4 <= this.e[b2]) {
                                                        final int[] e3 = this.e;
                                                        final int n16 = b2;
                                                        e3[n16] -= n4;
                                                        final int[] d6 = this.d;
                                                        final int n17 = d5;
                                                        d6[n17] += n4;
                                                        n4 = 0;
                                                        if (!a) {
                                                            break;
                                                        }
                                                    }
                                                    final int[] d7 = this.d;
                                                    final int n18 = d5;
                                                    d7[n18] += this.e[b2];
                                                    n4 -= this.e[b2];
                                                    this.e[b2] = 0;
                                                    if (!a) {
                                                        break Label_0751;
                                                    }
                                                }
                                                if (n15 < n6) {
                                                    n6 = n15;
                                                }
                                            }
                                        }
                                        k2.g();
                                        if (a) {
                                            break;
                                        }
                                    }
                                }
                                this.d[n] = n4;
                            }
                            if (n14 <= 0) {
                                break;
                            }
                            c2 = this.t.c;
                            x = this.x;
                            if (a) {
                                continue Label_1478_Outer;
                            }
                            if (c2 <= x) {
                                final L t5 = this.t;
                                ++t5.a;
                                if (this.m == 1) {
                                    final int[] g = this.g;
                                    final int n19 = n5;
                                    final int n20 = g[n19] - 1;
                                    g[n19] = n20;
                                    Label_1174: {
                                        if (n20 == 0 || n6 >= this.h - 1) {
                                            this.c[n] = this.h;
                                            if (n6 >= this.h) {
                                                break;
                                            }
                                            this.s.add(a2);
                                        Label_0873:
                                            while (true) {
                                                boolean empty = this.s.isEmpty();
                                            Label_0880:
                                                while (!empty) {
                                                    final q d8 = this.s.d();
                                                    d8.d();
                                                    final L t6 = this.t;
                                                    ++t6.e;
                                                    final e l3 = d8.l();
                                                    while (l3.f()) {
                                                        final d a5 = l3.a();
                                                        final int b3 = a5.b();
                                                        final q d9 = a5.d();
                                                        final int d10 = d9.d();
                                                        final int n21 = this.e[b3];
                                                        final int n22 = this.f[b3];
                                                        if (a) {
                                                            continue Label_1328_Outer;
                                                        }
                                                        if (n21 < n22 && this.c[d10] < this.h) {
                                                            this.s.add(d9);
                                                            final int[] g2 = this.g;
                                                            final int n23 = this.c[d10];
                                                            --g2[n23];
                                                            this.c[d10] = this.h;
                                                        }
                                                        l3.g();
                                                        if (a) {
                                                            break;
                                                        }
                                                    }
                                                    final e k3 = d8.k();
                                                    while (k3.f()) {
                                                        final d a6 = k3.a();
                                                        final int b4 = a6.b();
                                                        final q c4 = a6.c();
                                                        final int d11 = c4.d();
                                                        n2 = ((empty = (this.e[b4] != 0)) ? 1 : 0);
                                                        if (a) {
                                                            continue Label_0880;
                                                        }
                                                        if (a) {
                                                            continue Label_1419;
                                                        }
                                                        if (n2 > 0 && this.c[d11] < this.h) {
                                                            this.s.add(c4);
                                                            final int[] g3 = this.g;
                                                            final int n24 = this.c[d11];
                                                            --g3[n24];
                                                            this.c[d11] = this.h;
                                                        }
                                                        k3.g();
                                                        if (a) {
                                                            break Label_1174;
                                                        }
                                                    }
                                                    continue Label_0873;
                                                }
                                                continue Label_0059;
                                            }
                                        }
                                    }
                                    this.c[n] = ++n6;
                                    final int[] g4 = this.g;
                                    final int n25 = n6;
                                    ++g4[n25];
                                    this.p.a(a2, n6);
                                    if (!a) {
                                        break;
                                    }
                                }
                                this.c[n] = ++n6;
                                this.p.a(a2, n6);
                                if (!a) {
                                    break;
                                }
                            }
                            this.x += this.v;
                            final L t7 = this.t;
                            ++t7.d;
                            this.p.c();
                            if (this.m == 1) {
                                int n26 = 0;
                                while (true) {
                                    while (n26 < this.h) {
                                        this.c[n26] = this.h;
                                        ++n26;
                                        if (!a) {
                                            if (a) {
                                                break;
                                            }
                                            continue Label_1328_Outer;
                                        }
                                        else {
                                            if (this.p.b()) {
                                                int n27 = 0;
                                                while (n27 < this.h) {
                                                    final int n28 = this.c[n27];
                                                    final int h4 = this.h;
                                                    if (a) {
                                                        continue Label_1328_Outer;
                                                    }
                                                    if (n28 == h4) {
                                                        this.r.add(this.a[n27]);
                                                        this.c[n27] = this.n;
                                                    }
                                                    ++n27;
                                                    if (a) {
                                                        break;
                                                    }
                                                }
                                                break Label_1405;
                                            }
                                            continue Label_0059;
                                        }
                                    }
                                    this.a();
                                    continue Label_1478_Outer;
                                }
                            }
                            break Label_1419;
                        }
                        continue Label_0059;
                    }
                    this.m = 2;
                    this.b();
                    if (!a) {
                        continue Label_1478_Outer;
                    }
                }
                final x a7 = this.r.a();
                while (true) {
                    while (a7.f()) {
                        this.c[a7.e().d()] = this.n;
                        a7.g();
                        if (!a) {
                            if (a) {
                                break;
                            }
                            continue Label_1478_Outer;
                        }
                        else {
                            if (a) {
                                break Label_0059;
                            }
                            continue Label_0059;
                        }
                    }
                    this.b();
                    continue;
                }
            }
            break;
        }
        if (!this.c()) {
            System.err.println("checkMaxFlow failed !");
        }
        int d12 = 0;
        while (true) {
            while (d12 < this.i) {
                final boolean u = this.u;
                if (!a) {
                    Label_1578: {
                        if (u && this.e[d12] == this.o) {
                            h.a(this.b[d12], Integer.MAX_VALUE);
                            if (!a) {
                                break Label_1578;
                            }
                        }
                        h.a(this.b[d12], this.e[d12]);
                    }
                    ++d12;
                    if (a) {
                        break;
                    }
                    continue;
                }
                else {
                    if (u && this.d[d12] >= this.o) {
                        return Integer.MAX_VALUE;
                    }
                    return this.d[d12];
                }
            }
            this.t.b();
            d12 = this.k.d();
            final boolean u2 = this.u;
            continue;
        }
    }
    
    private void a(final i l, final q j, final q k, final c c) {
        final boolean a = y.a.h.a;
        this.l = l;
        this.j = j;
        this.k = k;
        this.h = this.l.f();
        this.i = this.l.h();
        this.n = 2 * this.h - 1;
        this.m = 1;
        this.a = this.l.m();
        this.b = new d[this.i];
        this.c = new int[this.h];
        this.d = new int[this.h];
        this.e = new int[this.i];
        this.f = new int[this.i];
        if (this.q) {
            this.p = new ac(this.n);
        }
        this.s = new y();
        this.r = new y();
        this.v = this.w * this.i;
        this.x = this.v;
        this.o = 0;
        this.u = false;
        final e p4 = this.l.p();
        while (true) {
            while (p4.f()) {
                final d a2 = p4.a();
                final int b = a2.b();
                final int a3;
                final int o = a3 = c.a(a2);
                if (a) {
                    int n = 0;
                    int n2 = 0;
                    Label_0425: {
                        if (a3 != 0) {
                            this.o = this.o * this.i + 1;
                            if (this.o < 0) {
                                throw new RuntimeException("MaxFlow Error:  Integer-Overflow by infinity scaling!");
                            }
                            int i = 0;
                            while (i < this.i) {
                                n = this.f[i];
                                n2 = Integer.MAX_VALUE;
                                if (a) {
                                    break Label_0425;
                                }
                                if (n == n2) {
                                    this.f[i] = this.o;
                                }
                                ++i;
                                if (a) {
                                    break;
                                }
                            }
                        }
                        final int n3 = Integer.MAX_VALUE / this.j.c();
                        final int o2 = this.o;
                    }
                    if (n < n2) {
                        System.err.println("Warning: Integer-Overflow possible!");
                    }
                    final e m = this.j.l();
                    while (true) {
                        while (m.f()) {
                            final d a4 = m.a();
                            final int b2 = a4.b();
                            final int n5;
                            final int n4 = n5 = this.f[b2];
                            if (a) {
                                int n6 = n5;
                                while (n6 < this.h) {
                                    this.c[n6] = this.h;
                                    ++n6;
                                    if (a) {
                                        return;
                                    }
                                    if (a) {
                                        break;
                                    }
                                }
                                this.a();
                                return;
                            }
                            if (n5 != 0) {
                                this.e[b2] = n4;
                                final int[] d = this.d;
                                final int d2 = a4.d().d();
                                d[d2] += n4;
                                final int[] d3 = this.d;
                                final int d4 = this.j.d();
                                d3[d4] -= n4;
                            }
                            m.g();
                            if (a) {
                                break;
                            }
                        }
                        continue;
                    }
                }
                if (a3 < 0) {
                    throw new B("found negative capacity");
                }
                Label_0294: {
                    if (o == Integer.MAX_VALUE) {
                        this.u = true;
                        if (!a) {
                            break Label_0294;
                        }
                    }
                    if (o > this.o) {
                        this.o = o;
                    }
                }
                this.b[b] = a2;
                this.f[b] = o;
                p4.g();
                if (a) {
                    break;
                }
            }
            final boolean u = this.u;
            continue;
        }
    }
    
    private void a() {
        final boolean a = y.a.h.a;
        this.s.add(this.k);
        this.c[this.k.d()] = 0;
        (this.g = new int[this.h])[0] = 1;
    Label_0047:
        while (true) {
            while (!this.s.isEmpty()) {
                final q d = this.s.d();
                final int n = this.c[d.d()];
            Label_0223_Outer:
                while (true) {
                    int n3 = 0;
                    int n4 = 0;
                    final int n2 = n3 + n4;
                    e e = d.l();
                    while (true) {
                        while (e.f()) {
                            final d a2 = e.a();
                            final int n5 = this.e[a2.b()];
                            if (!a) {
                                if (n5 != 0) {
                                    final q d2 = a2.d();
                                    final int d3 = d2.d();
                                    if (this.c[d3] >= this.h) {
                                        this.c[d3] = n2;
                                        this.s.add(d2);
                                        final int[] g = this.g;
                                        final int n6 = n2;
                                        ++g[n6];
                                        if (this.d[d3] > 0) {
                                            this.p.a(d2, n2);
                                        }
                                    }
                                }
                                e.g();
                                if (a) {
                                    break;
                                }
                                continue Label_0223_Outer;
                            }
                            else {
                                while (true) {
                                    if (n5 == 0) {
                                        continue Label_0047;
                                    }
                                    final d a3 = e.a();
                                    final int b = a3.b();
                                    n3 = this.f[b];
                                    n4 = this.e[b];
                                    if (a) {
                                        continue Label_0223_Outer;
                                    }
                                    if (n3 != n4) {
                                        final q c = a3.c();
                                        final int d4 = c.d();
                                        if (this.c[d4] >= this.h) {
                                            this.c[d4] = n2;
                                            this.s.add(c);
                                            final int[] g2 = this.g;
                                            final int n7 = n2;
                                            ++g2[n7];
                                            if (this.d[d4] > 0) {
                                                this.p.a(c, n2);
                                            }
                                        }
                                    }
                                    e.g();
                                    if (a) {
                                        break Label_0047;
                                    }
                                    e.f();
                                    continue Label_0223_Outer;
                                }
                            }
                        }
                        e = d.k();
                        continue;
                    }
                }
            }
            break;
        }
    }
    
    private void b() {
        final boolean a = y.a.h.a;
        this.s.add(this.j);
        this.c[this.j.d()] = this.h;
    Label_0192:
        while (true) {
            this.s.isEmpty();
            int i = 0;
        Label_0040:
            while (i == 0) {
                final q d = this.s.d();
                final int n = this.c[d.d()] + 1;
                final e l = d.l();
                while (l.f()) {
                    final d a2 = l.a();
                    i = this.e[a2.b()];
                    if (a) {
                        continue Label_0040;
                    }
                    if (i != 0) {
                        final q d2 = a2.d();
                        final int d3 = d2.d();
                        if (this.c[d3] == this.n) {
                            this.c[d3] = n;
                            if (this.d[d3] > 0) {
                                this.p.a(d2, n);
                            }
                            this.s.add(d2);
                        }
                    }
                    l.g();
                    if (a) {
                        break Label_0192;
                    }
                }
                continue Label_0192;
            }
            break;
        }
    }
    
    private boolean c() {
        final boolean a = y.a.h.a;
        final int[] array = new int[this.h];
        int i = 0;
        while (true) {
        Label_0205_Outer:
            while (i < this.i) {
                final int n = this.e[i];
                if (a) {
                    int j = n;
                    while (true) {
                        while (j < this.h) {
                            final K k = this;
                            if (!a) {
                                if (this.a[j] != this.j && this.a[j] != this.k && array[j] != 0) {
                                    System.err.println("checkMaxFlow: found wrong excess!");
                                    return false;
                                }
                                ++j;
                                if (a) {
                                    break;
                                }
                                continue Label_0205_Outer;
                            }
                            else {
                                final boolean[] array2 = new boolean[k.h];
                                final y y = new y();
                                y.add(this.j);
                                array2[this.j.d()] = true;
                                int n3 = 0;
                                Label_0467: {
                                Label_0457:
                                    while (true) {
                                        y.isEmpty();
                                        int l = 0;
                                    Label_0366_Outer:
                                        while (l == 0) {
                                            final q d = y.d();
                                            d.d();
                                            e e = d.l();
                                            while (true) {
                                                while (e.f()) {
                                                    final d a2 = e.a();
                                                    final int b = a2.b();
                                                    final q d2 = a2.d();
                                                    final int d3 = d2.d();
                                                    final int n2 = this.e[b];
                                                    if (!a) {
                                                        if (n2 < this.f[b] && !array2[d3]) {
                                                            array2[d3] = true;
                                                            y.add(d2);
                                                        }
                                                        e.g();
                                                        if (a) {
                                                            break;
                                                        }
                                                        continue Label_0205_Outer;
                                                    }
                                                    else {
                                                        while (true) {
                                                            if (n2 == 0) {
                                                                continue Label_0467;
                                                            }
                                                            final d a3 = e.a();
                                                            final int b2 = a3.b();
                                                            final q c = a3.c();
                                                            final int d4 = c.d();
                                                            l = (n3 = this.e[b2]);
                                                            if (a) {
                                                                continue Label_0366_Outer;
                                                            }
                                                            if (a) {
                                                                break Label_0467;
                                                            }
                                                            if (l > 0 && !array2[d4]) {
                                                                array2[d4] = true;
                                                                y.add(c);
                                                            }
                                                            e.g();
                                                            if (a) {
                                                                break Label_0457;
                                                            }
                                                            e.f();
                                                            continue Label_0366_Outer;
                                                        }
                                                    }
                                                }
                                                e = d.k();
                                                continue;
                                            }
                                        }
                                        break;
                                    }
                                    n3 = (array2[this.k.d()] ? 1 : 0);
                                }
                                if (n3 != 0) {
                                    System.err.println("checkMaxFlow: t reachable from s!");
                                    return false;
                                }
                                return true;
                            }
                        }
                        final K k = this;
                        continue;
                    }
                }
                if (n < 0 || this.e[i] > this.f[i]) {
                    System.err.println("checkMaxFlow: found wrong flow value!");
                    return false;
                }
                final int d5 = this.b[i].c().d();
                final int d6 = this.b[i].d().d();
                final int[] array3 = array;
                final int n4 = d5;
                array3[n4] -= this.e[i];
                final int[] array4 = array;
                final int n5 = d6;
                array4[n5] += this.e[i];
                ++i;
                if (a) {
                    break;
                }
            }
            continue;
        }
    }
}
