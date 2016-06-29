package y.f.f.d;

import y.g.a.*;
import java.util.*;
import y.c.*;

public class N implements v
{
    private i a;
    private int[] b;
    private int[] c;
    private int[] d;
    private int[] e;
    private int[] f;
    private a[] g;
    private int h;
    private int i;
    private O j;
    private g k;
    private A l;
    private ArrayList m;
    private ArrayList n;
    private d[] o;
    private d[] p;
    private d[][] q;
    private d[][] r;
    
    public N() {
        this.j = new O();
    }
    
    public int a(final i a, final q q, final q q2, final h h, final h h2, final int n, final ArrayList list, final ArrayList n2, final h h3, final h h4) {
        final boolean p10 = y.f.f.d.o.p;
        this.h = a.h();
        this.i = a.f();
        this.a = a;
        this.b = new int[this.h];
        this.c = new int[this.h];
        this.d = new int[this.i];
        this.g = new a[this.h];
        this.e = new int[this.i];
        this.f = new int[this.h];
        final Object[] array = new Object[this.i];
        final int[] array2 = new int[this.h];
        this.o = new d[this.h];
        this.p = new d[this.h];
        this.q = new d[2][4];
        this.r = new d[2][4];
        this.n = n2;
        this.m = new ArrayList(a.f());
        this.j.a();
        this.k = new y.g.a.d(a);
        int i = 0;
        while (true) {
            do {
                int j = 0;
            Label_0771_Outer:
                while (j < list.size()) {
                    final a a2 = list.get(i);
                    final e b = a2.b();
                    if (p10) {
                        final e e = b;
                        while (true) {
                            while (e.f()) {
                                final d a3 = e.a();
                                final int b2 = a3.b();
                                this.c[b2] = h.a(a3);
                                array2[b2] = this.b[b2];
                                this.o[a3.b()] = (d)h4.b(a3);
                                this.p[a3.b()] = (d)h3.b(a3);
                                e.g();
                                if (p10) {
                                    final int n4;
                                    int n3 = n4;
                                    final e p11 = this.a.p();
                                    while (p11.f()) {
                                        final d a4 = p11.a();
                                        final int b3 = a4.b();
                                        n3 += this.f[b3] * this.c[b3];
                                        h2.a(a4, this.f[b3]);
                                        p11.g();
                                        if (p10) {
                                            return n3;
                                        }
                                        if (p10) {
                                            break;
                                        }
                                    }
                                    this.j.b();
                                    return n3;
                                }
                                if (p10) {
                                    break;
                                }
                            }
                            while (i >= 1) {
                                final O k = this.j;
                                ++k.a;
                                this.a(q, q2, this.c, array2, this.f, array);
                                final int n4 = i;
                                if (!p10) {
                                    int n5 = n4;
                                    q q3 = q2;
                                Label_0755:
                                    while (true) {
                                    Label_0495:
                                        while (true) {
                                            while (true) {
                                                Label_0611: {
                                                    q q4 = null;
                                                    q d = null;
                                                    if (q4 == d) {
                                                        break Label_0611;
                                                    }
                                                    final Object o = array[q3.d()];
                                                    if (!(o instanceof d)) {
                                                        throw new RuntimeException("Unknown predecesor type !");
                                                    }
                                                    final d d2 = (d)o;
                                                    final int b4 = d2.b();
                                                    int n6 = 0;
                                                    Label_0590: {
                                                        if (q3 == d2.d()) {
                                                            n6 = array2[b4];
                                                            q3 = d2.c();
                                                            if (!p10) {
                                                                break Label_0590;
                                                            }
                                                        }
                                                        n6 = this.f[b4];
                                                        q3 = d2.d();
                                                        if (p10) {
                                                            throw new RuntimeException("Unknown predecesor type !");
                                                        }
                                                    }
                                                    if (n6 >= n5) {
                                                        break;
                                                    }
                                                    n5 = n6;
                                                    if (!p10) {
                                                        if (p10) {
                                                            break Label_0611;
                                                        }
                                                        break;
                                                    }
                                                    while (q3 != q) {
                                                        final int d3 = q3.d();
                                                        if (array[d3] instanceof d) {
                                                            final d d4 = (d)array[d3];
                                                            final int b5 = d4.b();
                                                            q4 = q3;
                                                            d = d4.d();
                                                            if (p10) {
                                                                continue Label_0495;
                                                            }
                                                            if (q4 == d) {
                                                                final int[] f = this.f;
                                                                final int n7 = b5;
                                                                f[n7] += n5;
                                                                final a a5 = this.g[b5];
                                                                a5.d += n5;
                                                                final int[] array3 = array2;
                                                                final int n8 = b5;
                                                                array3[n8] -= n5;
                                                                q3 = d4.c();
                                                                if (!p10) {
                                                                    continue Label_0771_Outer;
                                                                }
                                                            }
                                                            final int[] f2 = this.f;
                                                            final int n9 = b5;
                                                            f2[n9] -= n5;
                                                            final int[] array4 = array2;
                                                            final int n10 = b5;
                                                            array4[n10] += n5;
                                                            q3 = d4.d();
                                                            if (p10) {
                                                                break;
                                                            }
                                                            continue Label_0771_Outer;
                                                        }
                                                    }
                                                    break Label_0755;
                                                }
                                                q3 = q2;
                                                continue;
                                            }
                                        }
                                    }
                                    i -= n5;
                                    this.a();
                                    if (p10) {
                                        break;
                                    }
                                    continue Label_0771_Outer;
                                }
                                break;
                            }
                            continue;
                        }
                    }
                    final e e2 = b;
                    while (e2.f()) {
                        final int b6 = e2.a().b();
                        this.g[b6] = a2;
                        this.b[b6] = a2.a();
                        j = this.b[b6];
                        if (p10) {
                            continue Label_0771_Outer;
                        }
                        if (j < 0) {
                            throw new B("found negative capacity");
                        }
                        e2.g();
                        if (p10) {
                            break;
                        }
                    }
                    ++i;
                }
                break;
            } while (!p10);
            i = n;
            this.a.p();
            continue;
        }
    }
    
    private void a(final q q, final q q2, final int[] array, final int[] array2, final int[] array3, final Object[] array4) {
        final boolean p6 = y.f.f.d.o.p;
        this.k.d();
        int i = 0;
        while (true) {
            while (i < this.i) {
                this.d[i] = Integer.MAX_VALUE;
                array4[i] = null;
                ++i;
                if (p6) {
                    this.k.a(q, 0);
                Label_0691:
                    while (true) {
                    Label_0678:
                        while (!this.k.a()) {
                            final O j = this.j;
                            ++j.b;
                            final q c = this.k.c();
                            final int d = c.d();
                            this.m.add(c);
                            if (q2 == c) {
                                break;
                            }
                            final int n = this.d[d];
                            final int n2 = this.e[d];
                            int n3 = 0;
                            int n7 = 0;
                        Label_0158:
                            while (true) {
                                int n4 = 0;
                                int n5 = 0;
                                n3 = n4 + n5;
                                d d2 = c.f();
                                while (d2 != null) {
                                    final int b = d2.b();
                                    n4 = array2[b];
                                    n5 = 1;
                                    if (p6) {
                                        continue Label_0158;
                                    }
                                    if (n4 >= n5) {
                                        if (this.g[b].d != this.g[b].c) {
                                            final q d3 = d2.d();
                                            final int d4 = d3.d();
                                            final int n6 = n3 - this.e[d4] + array[b];
                                            if (n6 < this.d[d4]) {
                                                Label_0448: {
                                                    if (this.d[d4] == Integer.MAX_VALUE) {
                                                        if (n6 < 0) {
                                                            y.g.o.a((Object)("insert: Out edges smaller 0: " + this.l.b(c) + " -> " + this.l.b(d3) + " : " + n6));
                                                            if (!p6) {
                                                                break Label_0448;
                                                            }
                                                        }
                                                        this.k.a(d3, n6);
                                                        if (!p6) {
                                                            break Label_0448;
                                                        }
                                                    }
                                                    if (n6 < 0) {
                                                        y.g.o.a((Object)("decrease: Out edges smaller 0: " + this.l.b(c) + " -> " + this.l.b(d3) + " : " + n6));
                                                        if (!p6) {
                                                            break Label_0448;
                                                        }
                                                    }
                                                    this.k.b(d3, n6);
                                                }
                                                this.d[d4] = n6;
                                                array4[d4] = d2;
                                            }
                                        }
                                    }
                                    d2 = d2.g();
                                    if (p6) {
                                        break;
                                    }
                                }
                                d d5 = c.g();
                                while (d5 != null) {
                                    final int b2 = d5.b();
                                    n7 = array3[b2];
                                    if (p6) {
                                        break Label_0691;
                                    }
                                    final int n8 = 1;
                                    if (p6) {
                                        continue Label_0158;
                                    }
                                    if (n7 >= n8) {
                                        if (this.g[b2].b().k() <= 1) {
                                            final q c2 = d5.c();
                                            final int d6 = c2.d();
                                            final int n9 = n3 - this.e[d6] - array[b2];
                                            if (n9 < 0) {
                                                y.g.o.a((Object)("In edges smaller 0: " + n9));
                                            }
                                            if (n9 < this.d[d6]) {
                                                Label_0650: {
                                                    if (this.d[d6] == Integer.MAX_VALUE) {
                                                        this.k.a(c2, n9);
                                                        if (!p6) {
                                                            break Label_0650;
                                                        }
                                                    }
                                                    this.k.b(c2, n9);
                                                }
                                                this.d[d6] = n9;
                                                array4[d6] = d5;
                                            }
                                        }
                                    }
                                    d5 = d5.h();
                                    if (p6) {
                                        break Label_0678;
                                    }
                                }
                                continue Label_0691;
                            }
                            if (n7 == 0) {
                                return;
                            }
                            int k = 0;
                            while (k < this.m.size()) {
                                final int d7 = this.m.get(k).d();
                                final int[] e = this.e;
                                final int n10 = d7;
                                e[n10] += this.d[d7] - n3;
                                ++k;
                                if (p6) {
                                    break;
                                }
                            }
                            return;
                        }
                        final int n11;
                        int n3 = n11 = this.d[q2.d()];
                        continue Label_0691;
                    }
                }
                if (p6) {
                    break;
                }
            }
            this.m.clear();
            this.d[q.d()] = 0;
            continue;
        }
    }
    
    public void a() {
        final boolean p = y.f.f.d.o.p;
        int i = 0;
        while (i < this.n.size()) {
            Object value = this.n.get(i);
        Label_0354_Outer:
            while (true) {
                final ArrayList<a> list = (ArrayList<a>)value;
                if (list.size() == 0) {
                    break;
                }
                d a = list.get(0).b().a();
                d a2 = null;
                int n = 0;
                d d = null;
            Label_0069:
                while (true) {
                    if (this.f[a.b()] > 0) {}
                    do {
                        if (d != null && this.f[this.a(a).b()] > 0) {
                            a2 = this.a(a);
                        }
                        a = this.o[a.b()];
                        ++n;
                        if (a2 == null && n < list.size() + 3) {
                            continue Label_0069;
                        }
                        d = a2;
                    } while (p);
                    break;
                }
                if (d == null) {
                    break;
                }
                int n2 = 0;
                this.q[0][0] = a2;
                this.r[0][0] = a2;
                int n3 = 0;
                d d2 = this.p[a2.b()];
                while (true) {
                    while (d2 != a2) {
                        final int n4 = n3;
                        if (!p) {
                            d a3 = null;
                            d a4 = null;
                            Label_0244: {
                                if (n4 == 0) {
                                    a3 = d2;
                                    a4 = this.a(d2);
                                    if (!p) {
                                        break Label_0244;
                                    }
                                }
                                a4 = d2;
                                a3 = this.a(d2);
                            }
                            if (this.f[a3.b()] > 0) {
                                this.r[n3][n2] = a3;
                            }
                            if (this.f[a4.b()] > 0) {
                                n2 += n3;
                                if (n2 > 3) {
                                    throw new RuntimeException("Too many intervals !!!!");
                                }
                                n3 = 1 - n3;
                                this.q[n3][n2] = a4;
                                this.r[n3][n2] = a4;
                            }
                            d2 = this.p[d2.b()];
                            if (p) {
                                break;
                            }
                            continue Label_0354_Outer;
                        }
                        else {
                            if (n4 == 3) {
                                int j = 0;
                                Label_0361:
                                while (j < 4) {
                                    final d d3 = (d)(value = this.q[0][j]);
                                    if (!p) {
                                        d d4 = d3;
                                        while (true) {
                                            while (d4 != this.r[0][j]) {
                                                this.c[this.a(d4).b()] = 10000;
                                                d4 = this.p[d4.b()];
                                                if (p) {
                                                    while (true) {
                                                        while (d4 != this.q[1][j]) {
                                                            this.c[this.a(d4).b()] = 10000;
                                                            d4 = this.o[d4.b()];
                                                            if (!p) {
                                                                if (p) {
                                                                    break;
                                                                }
                                                                continue Label_0354_Outer;
                                                            }
                                                            else {
                                                                if (p) {
                                                                    break Label_0354_Outer;
                                                                }
                                                                continue Label_0361;
                                                            }
                                                        }
                                                        ++j;
                                                        continue;
                                                    }
                                                }
                                                if (p) {
                                                    break;
                                                }
                                            }
                                            d4 = this.r[1][j];
                                            continue;
                                        }
                                    }
                                    continue Label_0354_Outer;
                                }
                                break Label_0354_Outer;
                            }
                            break Label_0354_Outer;
                        }
                    }
                    continue;
                }
            }
            ++i;
            if (p) {
                break;
            }
        }
    }
    
    private d a(final d d) {
        final d[] c = this.g[d.b()].c();
        if (c[0] != d) {
            return c[0];
        }
        return c[1];
    }
}
