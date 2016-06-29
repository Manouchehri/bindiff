package y.f.f.d;

import java.util.*;
import y.c.*;

public class q implements v
{
    protected a[] a;
    private i h;
    private int[] i;
    private int[] j;
    private int[] k;
    private int[] l;
    private int[] m;
    private int n;
    private int o;
    private I p;
    private ArrayList q;
    private d[] r;
    private d[] s;
    private int[] t;
    Object[] b;
    int c;
    y.c.q d;
    y.c.q e;
    h f;
    u[] g;
    
    public int a(final i i, final y.c.q q, final y.c.q q2, final h h, final h h2, final int n, final ArrayList list, final ArrayList list2, final h h3, final h h4) {
        try {
            return this.b(i, q, q2, h, h2, n, list, list2, h3, h4);
        }
        catch (r r) {
            return new N().a(i, q, q2, h, h2, n, list, list2, h3, h4);
        }
    }
    
    protected int b(final i h, final y.c.q d, final y.c.q e, final h f, final h h2, final int c, final ArrayList list, final ArrayList list2, final h h3, final h h4) {
        final boolean p10 = y.f.f.d.o.p;
        this.c = c;
        this.d = d;
        this.e = e;
        this.n = h.h();
        this.o = h.f();
        this.h = h;
        this.i = new int[this.n];
        this.j = new int[this.n];
        this.k = new int[this.o];
        this.l = new int[this.o];
        this.m = new int[this.n];
        this.b = new Object[this.o];
        this.t = new int[this.n];
        this.r = new d[this.n];
        this.s = new d[this.n];
        this.f = f;
        this.a = new a[this.n];
        this.q = new ArrayList(h.f());
        this.p = new I(this.o);
        int n = 0;
        while (true) {
            do {
                int i = 0;
            Label_0187:
                while (i < list.size()) {
                    final a a = list.get(n);
                    final e b = a.b();
                    if (p10) {
                        final e e2 = b;
                        while (true) {
                            while (e2.f()) {
                                final d a2 = e2.a();
                                this.r[a2.b()] = (d)h4.b(a2);
                                this.s[a2.b()] = (d)h3.b(a2);
                                e2.g();
                                if (p10) {
                                    final x o = h.o();
                                    while (true) {
                                    Label_0480:
                                        while (o.f()) {
                                            final y.c.q e3 = o.e();
                                            final q q = this;
                                            if (p10) {
                                                q.a();
                                                int n2 = 0;
                                                int n3 = 0;
                                                e e4 = null;
                                            Block_29:
                                                while (true) {
                                                    list2.size();
                                                Label_0503:
                                                    while (true) {
                                                        while (true) {
                                                            final int n8;
                                                            Label_1001: {
                                                                int n4 = 0;
                                                                int n5 = 0;
                                                                if (n4 >= n5) {
                                                                    break Label_1001;
                                                                }
                                                                final Object o2 = list2.get(n3);
                                                                final ArrayList<a> list3 = (ArrayList<a>)o2;
                                                                boolean b2 = false;
                                                                int n6 = 0;
                                                                int n7 = 0;
                                                                n8 = 0;
                                                                if (!p10) {
                                                                    int j = n8;
                                                                    while (j < list3.size()) {
                                                                        final a a3 = list3.get(j);
                                                                        n4 = this.m[a3.b[0].b()];
                                                                        n5 = 1;
                                                                        if (p10) {
                                                                            continue Label_0503;
                                                                        }
                                                                        Label_0880: {
                                                                            if (n4 == n5 && this.m[a3.b[1].b()] == 1) {
                                                                                ++n2;
                                                                                d d2 = this.s[a3.b[0].b()];
                                                                                int n9 = 0;
                                                                                while (true) {
                                                                                    while (this.m[d2.b()] == 1) {
                                                                                        n9 += f.a(this.a[d2.b()].b(d2));
                                                                                        d2 = this.s[d2.b()];
                                                                                        if (p10) {
                                                                                            int n10 = 0;
                                                                                            d d3 = this.s[a3.b[1].b()];
                                                                                            while (true) {
                                                                                                while (this.m[d3.b()] == 1) {
                                                                                                    n10 += f.a(this.a[d3.b()].b(d3));
                                                                                                    d3 = this.s[d3.b()];
                                                                                                    if (p10) {
                                                                                                        if (n10 > 400 || n9 > 400) {
                                                                                                            Label_0863: {
                                                                                                                if (n10 < n9) {
                                                                                                                    this.a(a3);
                                                                                                                    if (!p10) {
                                                                                                                        break Label_0863;
                                                                                                                    }
                                                                                                                }
                                                                                                                this.b(a3);
                                                                                                            }
                                                                                                            b2 = true;
                                                                                                        }
                                                                                                        n7 += n10;
                                                                                                        n6 += n9;
                                                                                                        break Label_0880;
                                                                                                    }
                                                                                                    if (p10) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                n10 += f.a(this.a[d3.b()].b(d3));
                                                                                                continue;
                                                                                            }
                                                                                        }
                                                                                        if (p10) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    n9 += f.a(this.a[d2.b()].b(d2));
                                                                                    continue;
                                                                                }
                                                                            }
                                                                        }
                                                                        ++j;
                                                                        if (p10) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    if (!b2) {
                                                                        int k = 0;
                                                                        while (k < list3.size()) {
                                                                            final a a4 = list3.get(k);
                                                                            final int n11 = this.m[a4.b[0].b()];
                                                                            final boolean b3 = true;
                                                                            if (p10) {
                                                                                continue Label_0503;
                                                                            }
                                                                            Label_0985: {
                                                                                if (n11 == (b3 ? 1 : 0) && this.m[a4.b[1].b()] == 1) {
                                                                                    if (n7 < n6) {
                                                                                        this.a(a4);
                                                                                        if (!p10) {
                                                                                            break Label_0985;
                                                                                        }
                                                                                    }
                                                                                    this.b(a4);
                                                                                }
                                                                            }
                                                                            ++k;
                                                                            if (p10) {
                                                                                break;
                                                                            }
                                                                        }
                                                                    }
                                                                    ++n3;
                                                                    if (!p10) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            if (n8 > 0) {
                                                                break Label_0480;
                                                            }
                                                            Object o2;
                                                            e4 = (e)(o2 = this.h.p());
                                                            if (!p10) {
                                                                break Block_29;
                                                            }
                                                            continue;
                                                        }
                                                    }
                                                }
                                                final e e5 = e4;
                                                int b4 = 0;
                                                while (e5.f()) {
                                                    final d a5 = e5.a();
                                                    b4 = a5.b();
                                                    if (p10) {
                                                        return b4;
                                                    }
                                                    h2.a(a5, this.m[b4]);
                                                    e5.g();
                                                    if (p10) {
                                                        break;
                                                    }
                                                }
                                                return b4;
                                            }
                                            this.g[e3.d()] = new u(e3, e3.d());
                                            o.g();
                                            if (p10) {
                                                break;
                                            }
                                        }
                                        final q q = this;
                                        continue;
                                    }
                                }
                                if (p10) {
                                    break;
                                }
                            }
                            this.g = new u[this.o];
                            continue;
                        }
                    }
                    final e e6 = b;
                    while (e6.f()) {
                        final d a6 = e6.a();
                        final int b5 = a6.b();
                        this.a[a6.b()] = a;
                        this.i[b5] = a.a();
                        i = this.i[b5];
                        if (p10) {
                            continue Label_0187;
                        }
                        if (i < 0) {
                            throw new B("found negative capacity");
                        }
                        e6.g();
                        if (p10) {
                            break;
                        }
                    }
                    ++n;
                }
                break;
            } while (!p10);
            this.h.p();
            continue;
        }
    }
    
    protected void a(final a a) {
        final boolean p = y.f.f.d.o.p;
        d d = a.b[0];
        while (true) {
            while (this.m[d.b()] == 1) {
                this.i[this.a[d.b()].b(d).b()] = 0;
                d = this.s[d.b()];
                if (p) {
                    while (this.m[this.a[d.b()].b(d).b()] == 1) {
                        this.i[this.a[d.b()].b(d).b()] = 0;
                        d = this.r[d.b()];
                        if (p) {
                            break;
                        }
                    }
                    return;
                }
                if (p) {
                    break;
                }
            }
            d = this.r[a.b[0].b()];
            continue;
        }
    }
    
    protected void b(final a a) {
        final boolean p = y.f.f.d.o.p;
        d d = a.b[1];
        while (true) {
            while (this.m[d.b()] == 1) {
                this.i[this.a[d.b()].b(d).b()] = 0;
                d = this.s[d.b()];
                if (p) {
                    while (this.m[this.a[d.b()].b(d).b()] == 1) {
                        this.i[this.a[d.b()].b(d).b()] = 0;
                        d = this.r[d.b()];
                        if (p) {
                            break;
                        }
                    }
                    return;
                }
                if (p) {
                    break;
                }
            }
            d = this.r[a.b[1].b()];
            continue;
        }
    }
    
    protected int a() {
        final boolean p = y.f.f.d.o.p;
        int i = this.c;
        final e p2 = this.h.p();
        while (true) {
        Label_0424_Outer:
            while (p2.f()) {
                final d a = p2.a();
                final int b = a.b();
                if (p) {
                    int j = b;
                Label_0425_Outer:
                    while (true) {
                    Label_0425:
                        while (true) {
                            while (j < this.o) {
                                this.l[j] = 0;
                                ++j;
                                if (p) {
                                    final q q = this;
                                    final e p3 = q.h.p();
                                    int n = 0;
                                    while (p3.f()) {
                                        final int b2 = p3.a().b();
                                        n = j + this.m[b2] * this.j[b2];
                                        if (p) {
                                            return n;
                                        }
                                        j = n;
                                        p3.g();
                                        if (p) {
                                            break;
                                        }
                                    }
                                    return n;
                                }
                                if (p) {
                                    break;
                                }
                            }
                            while (i >= 1) {
                                this.a(this.d, this.e, this.j, this.t, this.m, this.b);
                                int n2 = i;
                                final q q = this;
                                if (!p) {
                                    y.c.q q2 = this.e;
                                Label_0413:
                                    while (true) {
                                        final y.c.q d = this.d;
                                    Label_0177:
                                        while (true) {
                                            while (true) {
                                                Label_0289: {
                                                    y.c.q q3 = null;
                                                    y.c.q d2 = null;
                                                    if (q3 == d2) {
                                                        break Label_0289;
                                                    }
                                                    final Object o = this.b[q2.d()];
                                                    if (!(o instanceof d)) {
                                                        throw new r();
                                                    }
                                                    final d d3 = (d)o;
                                                    final int b3 = d3.b();
                                                    Label_0272: {
                                                        if (q2 == d3.d()) {
                                                            j = this.t[b3];
                                                            q2 = d3.c();
                                                            if (!p) {
                                                                break Label_0272;
                                                            }
                                                        }
                                                        j = this.m[b3];
                                                        q2 = d3.d();
                                                        if (p) {
                                                            throw new r();
                                                        }
                                                    }
                                                    if (j >= n2) {
                                                        break;
                                                    }
                                                    n2 = j;
                                                    if (!p) {
                                                        if (p) {
                                                            break Label_0289;
                                                        }
                                                        break;
                                                    }
                                                    while (q2 != this.d) {
                                                        final d d4 = (d)this.b[q2.d()];
                                                        final int b4 = d4.b();
                                                        q3 = q2;
                                                        d2 = d4.d();
                                                        if (p) {
                                                            continue Label_0177;
                                                        }
                                                        if (q3 == d2) {
                                                            final int[] m = this.m;
                                                            final int n3 = b4;
                                                            m[n3] += n2;
                                                            final int[] t = this.t;
                                                            final int n4 = b4;
                                                            t[n4] -= n2;
                                                            q2 = d4.c();
                                                            if (!p) {
                                                                continue Label_0424_Outer;
                                                            }
                                                        }
                                                        final int[] k = this.m;
                                                        final int n5 = b4;
                                                        k[n5] -= n2;
                                                        final int[] t2 = this.t;
                                                        final int n6 = b4;
                                                        t2[n6] += n2;
                                                        q2 = d4.d();
                                                        if (p) {
                                                            break;
                                                        }
                                                    }
                                                    break Label_0413;
                                                }
                                                q2 = this.e;
                                                continue;
                                            }
                                        }
                                    }
                                    i -= n2;
                                    if (p) {
                                        break;
                                    }
                                    continue Label_0424_Outer;
                                }
                                continue Label_0425;
                            }
                            break;
                        }
                        j = 0;
                        continue Label_0425_Outer;
                    }
                }
                final int n7 = b;
                this.j[n7] = this.f.a(a);
                this.t[n7] = this.i[n7];
                this.m[n7] = 0;
                p2.g();
                if (p) {
                    break;
                }
            }
            continue;
        }
    }
    
    private void a(final y.c.q q, final y.c.q q2, final int[] array, final int[] array2, final int[] array3, final Object[] array4) {
        final boolean p6 = y.f.f.d.o.p;
        this.p.a();
        int i = 0;
        while (true) {
            while (i < this.o) {
                this.k[i] = Integer.MAX_VALUE;
                array4[i] = null;
                ++i;
                if (p6) {
                    this.p.a(0, this.g[q.d()]);
                Label_0484:
                    while (true) {
                    Label_0475:
                        while (!this.p.c()) {
                            final u b = this.p.b();
                            this.p.a(b);
                            final y.c.q b2 = b.b;
                            final int c = b.c;
                            this.q.add(b2);
                            if (q2 == b2) {
                                break;
                            }
                            final int n = this.k[c];
                            final int n2 = this.l[c];
                            int n7 = 0;
                        Label_0161:
                            while (true) {
                                int n4 = 0;
                                int n5 = 0;
                                final int n3 = n4 + n5;
                                d d = b2.f();
                                while (d != null) {
                                    final int b3 = d.b();
                                    n4 = array2[b3];
                                    n5 = 1;
                                    if (p6) {
                                        continue Label_0161;
                                    }
                                    if (n4 >= n5) {
                                        final int d2 = d.d().d();
                                        final int n6 = n3 - this.l[d2] + array[b3];
                                        if (n6 < this.k[d2]) {
                                            Label_0289: {
                                                if (this.k[d2] == Integer.MAX_VALUE) {
                                                    this.p.a(n6, this.g[d2]);
                                                    if (!p6) {
                                                        break Label_0289;
                                                    }
                                                }
                                                this.p.a(this.g[d2], n6);
                                            }
                                            this.k[d2] = n6;
                                            array4[d2] = d;
                                        }
                                    }
                                    d = d.g();
                                    if (p6) {
                                        break;
                                    }
                                }
                                d d3 = b2.g();
                                while (d3 != null) {
                                    final int b4 = d3.b();
                                    n7 = array3[b4];
                                    if (p6) {
                                        break Label_0484;
                                    }
                                    final int n8 = 1;
                                    if (p6) {
                                        continue Label_0161;
                                    }
                                    if (n7 >= n8) {
                                        final int d4 = d3.c().d();
                                        final int n9 = n3 - this.l[d4] - array[b4];
                                        if (n9 < this.k[d4]) {
                                            Label_0447: {
                                                if (this.k[d4] == Integer.MAX_VALUE) {
                                                    this.p.a(n9, this.g[d4]);
                                                    if (!p6) {
                                                        break Label_0447;
                                                    }
                                                }
                                                this.p.a(this.g[d4], n9);
                                            }
                                            this.k[d4] = n9;
                                            array4[d4] = d3;
                                        }
                                    }
                                    d3 = d3.h();
                                    if (p6) {
                                        break Label_0475;
                                    }
                                }
                                continue Label_0484;
                            }
                            final int n10 = n7;
                            if (n10 == 0) {
                                return;
                            }
                            int j = 0;
                            while (j < this.q.size()) {
                                final int d5 = this.q.get(j).d();
                                final int[] l = this.l;
                                final int n11 = d5;
                                l[n11] += this.k[d5] - n10;
                                ++j;
                                if (p6) {
                                    break;
                                }
                            }
                            return;
                        }
                        final int n12 = this.k[q2.d()];
                        continue Label_0484;
                    }
                }
                if (p6) {
                    break;
                }
            }
            this.q.clear();
            this.k[q.d()] = 0;
            continue;
        }
    }
}
