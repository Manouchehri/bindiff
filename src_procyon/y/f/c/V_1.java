package y.f.c;

import y.g.*;
import y.d.*;
import y.c.*;
import y.f.*;
import java.util.*;

public class V extends a
{
    private int[] o;
    private int[] p;
    private int[] q;
    private boolean[] r;
    private int[] s;
    private int[] t;
    private double[][] u;
    private double[] v;
    private int[] w;
    private boolean[] x;
    private double[] y;
    private double[] z;
    private double[] A;
    private double[] B;
    
    protected void a(final y[] array, final c c) {
        final X g = this.g;
        this.a(g, array);
        this.a((i)g, array);
        a(array, M.b(this.r), this.e, this.o);
        this.a(g, this.u[0]);
        this.b(g, array);
        this.a(g, this.u[0], array);
        this.b(array);
        this.a(g, this.u[1]);
        this.b(g, array);
        this.a(g, this.u[1], array);
        this.b(array);
        this.a(this.u[1]);
        this.c(array);
        this.a(g, this.u[2]);
        this.b(g, array);
        this.a(g, this.u[2], array);
        this.b(array);
        this.a(g, this.u[3]);
        this.b(g, array);
        this.a(g, this.u[3], array);
        this.b(array);
        this.a(this.u[3]);
        this.c(array);
        this.a(g);
    }
    
    void a(final double[] array) {
        final boolean i = y.f.c.a.i;
        int j = 0;
        while (j < array.length) {
            array[j] = -array[j];
            ++j;
            if (i) {
                break;
            }
        }
    }
    
    void b(final y[] array) {
        final boolean i = y.f.c.a.i;
        int j = 0;
        while (true) {
        Label_0335_Outer:
            while (j < array.length) {
                array[j].n();
                ++j;
                if (i) {
                Label_0335:
                    while (true) {
                        while (j < array.length) {
                            int n = 0;
                            q q = null;
                            final x a = array[j].a();
                            while (a.f()) {
                                final q e = a.e();
                                final int d = e.d();
                                this.o[d] = n++;
                                final V v = this;
                                if (i) {
                                    break Label_0335;
                                }
                                this.p[d] = ((q != null) ? q.d() : -1);
                                this.q[d] = -1;
                                if (q != null) {
                                    this.q[q.d()] = d;
                                    this.B[q.d()] = this.B[d];
                                }
                                q = e;
                                int k = e.b();
                                Label_0246: {
                                    if (k > 1) {
                                        final d l = e.i();
                                        d d2 = e.g();
                                        while (k > 1) {
                                            final d d3 = d2;
                                            d2 = d2.h();
                                            this.g.a(d3, d3.g(), l, 1, 0);
                                            --k;
                                            if (i) {
                                                break Label_0246;
                                            }
                                            if (i) {
                                                break;
                                            }
                                        }
                                    }
                                    k = e.c();
                                }
                                Label_0321: {
                                    if (k > 1) {
                                        final d h = e.h();
                                        d d4 = e.f();
                                        while (k > 1) {
                                            final d d5 = d4;
                                            d4 = d4.g();
                                            this.g.a(d5, h, d5.h(), 0, 1);
                                            --k;
                                            if (i) {
                                                break Label_0321;
                                            }
                                            if (i) {
                                                break;
                                            }
                                        }
                                    }
                                    a.g();
                                }
                                if (i) {
                                    break;
                                }
                            }
                            ++j;
                            if (i) {
                                break;
                            }
                            continue Label_0335_Outer;
                            V v = null;
                            final e p = v.g.p();
                            while (p.f()) {
                                final d a2 = p.a();
                                final t n2 = this.g.n(a2);
                                this.g.a(a2, new t(-n2.a(), n2.b()));
                                final t o = this.g.o(a2);
                                this.g.b(a2, new t(-o.a(), o.b()));
                                p.g();
                                if (i) {
                                    break;
                                }
                            }
                            return;
                        }
                        final V v = this;
                        continue Label_0335;
                    }
                }
                if (i) {
                    break;
                }
            }
            j = 0;
            continue;
        }
    }
    
    void c(final y[] array) {
        final boolean i = y.f.c.a.i;
        final e p = this.g.p();
        while (p.f()) {
            final d a = p.a();
            this.g.c(a);
            final t n = this.g.n(a);
            final t o = this.g.o(a);
            this.g.b(a, n);
            this.g.a(a, o);
            p.g();
            if (i) {
                break;
            }
        }
        final D d = new D(array);
        int j = 0;
        while (j < array.length) {
            array[j] = (y)d.j();
            ++j;
            if (i) {
                break;
            }
        }
        this.g.a(new aH(this.o, (byte)6), new aH(this.o, (byte)5));
    }
    
    protected void a(final i i, final y[] array) {
        final boolean j = y.f.c.a.i;
        final int f = i.f();
        final int h = i.h();
        this.o = new int[f];
        this.p = new int[f];
        this.q = new int[f];
        this.s = new int[f];
        this.t = new int[f];
        this.w = new int[f];
        this.A = new double[f];
        this.B = new double[f];
        this.u = new double[4][f];
        this.v = new double[f];
        this.y = new double[f];
        this.z = new double[f];
        this.x = new boolean[f];
        this.r = new boolean[h];
        int k = 0;
    Label_0283_Outer:
        while (k < array.length) {
            int n = 0;
            q q = null;
            final x a = array[k].a();
            while (true) {
                while (a.f()) {
                    final q e = a.e();
                    final int d = e.d();
                    this.o[d] = n++;
                    if (!j) {
                        this.p[d] = ((q != null) ? q.d() : -1);
                        this.q[d] = -1;
                        if (q != null) {
                            this.q[q.d()] = d;
                            this.B[q.d()] = this.g(q);
                        }
                        this.A[d] = this.g.p(e);
                        q = e;
                        a.g();
                        if (j) {
                            break;
                        }
                        continue Label_0283_Outer;
                    }
                    else {
                        if (j) {
                            break Label_0283_Outer;
                        }
                        continue Label_0283_Outer;
                    }
                }
                ++k;
                continue;
            }
        }
        i.a(new ad(this.o, true), new ad(this.o, false));
    }
    
    protected void a(final i i, final double[] array) {
        final boolean j = y.f.c.a.i;
        final x o = i.o();
        while (o.f()) {
            final int d = o.e().d();
            this.s[d] = d;
            array[this.t[d] = d] = Double.MAX_VALUE;
            this.w[d] = d;
            this.v[d] = Double.MAX_VALUE;
            this.x[d] = false;
            this.z[d] = (this.y[d] = 0.0);
            o.g();
            if (j) {
                break;
            }
        }
    }
    
    public static void a(final y[] array, final h h, final A a, final int[] array2) {
        final boolean i = a.i;
        final int length = array.length;
        int n = 2;
        do {
            int j = 0;
            int n2 = 0;
        Label_0018:
            while (j < n2) {
                int n3 = -1;
                int n4 = 0;
                int n5 = 0;
                final x a2 = array[n].a();
                final x a3 = array[n].a();
                while (a3.f()) {
                    final q e = a3.e();
                    q c = null;
                    boolean b = false;
                    j = e.b();
                    n2 = 1;
                    if (i) {
                        continue Label_0018;
                    }
                Label_0105:
                    while (true) {
                        Label_0122: {
                            if (j != n2) {
                                break Label_0122;
                            }
                            c = e.g().c();
                            final Object o = a.b(c);
                            if (o != null && a.b(e) != null) {
                                b = true;
                            }
                        }
                        if (n5 == array[n].size() - 1 || b) {
                            final int n6 = b ? array2[c.d()] : array[n - 1].size();
                            do {
                                int k = 0;
                                int n7 = 0;
                            Label_0171:
                                while (k <= n7) {
                                    final Object o;
                                    final e e2 = (e)(o = a2.e().k());
                                    if (i) {
                                        continue Label_0105;
                                    }
                                    final e e3 = e2;
                                    while (e3.f()) {
                                        final int n8 = k = array2[e3.a().c().d()];
                                        n7 = n3;
                                        if (i) {
                                            continue Label_0171;
                                        }
                                        if (k < n7 || n8 > n6) {
                                            h.a(e3.a(), true);
                                        }
                                        e3.g();
                                        if (i) {
                                            break;
                                        }
                                    }
                                    a2.g();
                                    ++n4;
                                }
                                break;
                            } while (!i);
                            n3 = n6;
                        }
                        break;
                    }
                    ++n5;
                    a3.g();
                    if (i) {
                        break;
                    }
                }
                ++n;
            }
            break;
        } while (!i);
    }
    
    public void b(final X x, final y[] array) {
        final boolean i = y.f.c.a.i;
        int n = 1;
        do {
            int j = 0;
        Label_0008:
            while (j < array.length) {
                int n2 = -1;
                p p2 = array[n].k();
                while (p2 != null) {
                    final q q = (q)p2.c();
                    final int d = q.d();
                    final int n3 = j = q.b();
                    if (i) {
                        continue Label_0008;
                    }
                    Label_0326: {
                        if (j != 0) {
                            final int n4 = (int)Math.floor((n3 + 1.0) / 2.0);
                            final int n5 = (int)Math.ceil((n3 + 1.0) / 2.0);
                            int k = 1;
                            d d2 = q.g();
                            while (k < n4) {
                                ++k;
                                d2 = d2.h();
                                if (i) {
                                    break Label_0326;
                                }
                                if (i) {
                                    break;
                                }
                            }
                            boolean b = false;
                            while (k <= n5) {
                                final boolean b2 = b;
                                if (i) {
                                    continue Label_0008;
                                }
                                if (b2) {
                                    break;
                                }
                                final I g = this.g.g(d2);
                                final int d3 = d2.c().d();
                                if (this.t[d] == q.d() && !this.r[d2.b()] && n2 < this.o[d3]) {
                                    n2 = this.o[d3];
                                    this.t[d3] = q.d();
                                    this.s[d] = this.s[d3];
                                    this.t[d] = this.s[d];
                                    b = true;
                                    this.z[d3] = g.getSourcePoint().a();
                                    this.y[d] = g.getTargetPoint().a();
                                }
                                d2 = d2.h();
                                ++k;
                                if (i) {
                                    break;
                                }
                            }
                        }
                        p2 = p2.a();
                    }
                    if (i) {
                        break;
                    }
                }
                ++n;
            }
            break;
        } while (!i);
    }
    
    protected void a(final X x, final double[] array, final y[] array2) {
        final boolean i = y.f.c.a.i;
        int j = array2.length - 1;
        while (true) {
        Label_0114_Outer:
            while (j >= 0) {
                final y y = array2[j];
                x a = null;
                Label_0219: {
                Label_0114:
                    while (true) {
                        Label_0121: {
                            if (i) {
                                break Label_0121;
                            }
                            p p3 = y.k();
                            while (p3 != null) {
                                final int d = ((q)p3.c()).d();
                                final int n = this.s[d];
                                final int n2 = d;
                                if (i) {
                                    break Label_0114;
                                }
                                if (n == n2 && array[d] == Double.MAX_VALUE) {
                                    this.a(d, array);
                                }
                                p3 = p3.a();
                                if (i) {
                                    break;
                                }
                            }
                            --j;
                            if (i) {
                                break;
                            }
                            continue Label_0114_Outer;
                            int n = 0;
                            int n2 = 0;
                            if (n >= n2) {
                                break Label_0114;
                            }
                            final y y2 = array2[j];
                        }
                        a = y.a();
                        if (i) {
                            break Label_0219;
                        }
                        if (a.f()) {
                            final int d2 = array2[j].a().e().d();
                            if (this.w[this.s[d2]] == d2 && !this.x[d2]) {
                                this.x[d2] = true;
                                this.b(d2, array);
                            }
                        }
                        ++j;
                        if (!i) {
                            final int length = array2.length;
                            continue Label_0114;
                        }
                        break;
                    }
                    x.o();
                }
                final x x2 = a;
                while (x2.f()) {
                    final int d3 = x2.e().d();
                    final double n3 = this.v[this.w[this.s[d3]]];
                    if (n3 < Double.MAX_VALUE) {
                        final int n4 = d3;
                        array[n4] += n3;
                    }
                    x2.g();
                    if (i) {
                        break;
                    }
                }
                return;
            }
            j = 0;
            continue;
        }
    }
    
    private void a(final int n, final double[] array) {
        final boolean i = y.f.c.a.i;
        final ArrayList<Object> list = new ArrayList<Object>(50);
        list.add(new y.f.c.X(n));
    Label_0627:
        while (!list.isEmpty()) {
            final y.f.c.X x = list.get(list.size() - 1);
            Label_0224: {
                switch (x.b) {
                    default: {
                        list.remove(list.size() - 1);
                        if (i) {
                            break Label_0224;
                        }
                        continue;
                    }
                    case 0: {
                        array[x.a] = 0.0;
                        x.d = 0.0;
                        x.e = true;
                        x.c = x.a;
                        x.b = 1;
                    }
                    case 1: {
                        if (x.c != x.a) {
                            final y.f.c.X x2 = x;
                            x2.d -= this.y[x.c];
                        }
                        if (this.o[x.c] > 0) {
                            x.b = 2;
                            if (!i) {
                                break Label_0224;
                            }
                        }
                        x.b = 4;
                        if (i) {
                            break Label_0224;
                        }
                        continue;
                    }
                    case 2: {
                        x.f = this.p[x.c];
                        x.g = this.s[x.f];
                        if (array[x.g] == Double.MAX_VALUE) {
                            list.add(new y.f.c.X(x.g));
                            x.b = 3;
                            if (!i) {
                                continue;
                            }
                        }
                        x.b = 3;
                    }
                    case 3: {
                        final int g = x.g;
                        final int a = x.a;
                        final int f = x.f;
                        if (this.w[a] == a) {
                            this.w[a] = this.w[g];
                        }
                        Label_0453: {
                            if (this.w[a] == this.w[g]) {
                                final double n2 = array[f] + 0.5 * (this.A[f] + this.A[x.c]) + this.B[f] - x.d;
                                if (x.e) {
                                    array[a] = n2;
                                    x.e = false;
                                    if (!i) {
                                        break Label_0453;
                                    }
                                }
                                array[a] = Math.max(array[a], n2);
                            }
                        }
                        x.b = 4;
                    }
                    case 4: {
                        final y.f.c.X x3 = x;
                        x3.d += this.z[x.c];
                        x.c = this.t[x.c];
                        if (x.c != x.a) {
                            x.b = 1;
                            if (!i) {
                                continue;
                            }
                        }
                        x.b = 5;
                    }
                    case 5: {
                        final int a2 = x.a;
                        double n3 = 0.0;
                        int j = a2;
                    Block_11:
                        while (true) {
                            if (j != a2) {
                                n3 -= this.y[j];
                            }
                            array[j] = array[a2] + n3;
                            n3 += this.z[j];
                            j = this.t[j];
                            while (j == a2) {
                                x.b = -1;
                                list.remove(list.size() - 1);
                                if (!i) {
                                    break Block_11;
                                }
                            }
                        }
                        if (i) {
                            break Label_0627;
                        }
                        continue;
                    }
                }
            }
        }
    }
    
    private void b(final int n, final double[] array) {
        final boolean i = y.f.c.a.i;
        final ArrayList list = new ArrayList<W>();
        list.add(new W(n));
        while (list.size() > 0) {
            final W w = list.get(list.size() - 1);
            final int b = w.b;
            final int a = w.a;
            w.b = this.t[b];
            if (w.b == a) {
                list.remove(list.size() - 1);
            }
            final int n2 = this.q[b];
            if (n2 >= 0) {
                final int n3 = this.w[this.s[n2]];
                if (n3 != this.w[a]) {
                    double n4 = array[n2] - array[a] - this.B[b] - 0.5 * (this.A[b] + this.A[n2]);
                    if (this.v[n3] != Double.MAX_VALUE) {
                        n4 += this.v[n3];
                    }
                    this.v[this.w[a]] = Math.min(this.v[this.w[a]], n4);
                    if (!i) {
                        continue;
                    }
                }
                final int n5 = this.s[n2];
                if (this.x[n5]) {
                    continue;
                }
                this.x[n5] = true;
                list.add(new W(n5));
                if (i) {
                    break;
                }
                continue;
            }
        }
    }
    
    protected void a(final X x) {
        final boolean i = y.f.c.a.i;
        final double[] array = new double[4];
        final double[] array2 = new double[4];
        final x o = x.o();
        while (true) {
            while (o.f()) {
                final int d = o.e().d();
                final double[] array3 = array2;
                final int n = 0;
                array3[n] += this.u[0][d];
                final double[] array4 = array2;
                final int n2 = 1;
                array4[n2] += this.u[1][d];
                final double[] array5 = array2;
                final int n3 = 2;
                array5[n3] += this.u[2][d];
                final double[] array6 = array2;
                final int n4 = 3;
                array6[n4] += this.u[3][d];
                o.g();
                if (i) {
                    final x o2 = x.o();
                    while (o2.f()) {
                        final q e = o2.e();
                        final int d2 = e.d();
                        final t l = x.l(e);
                        array[0] = this.u[0][d2] - array2[0];
                        array[1] = this.u[1][d2] - array2[1];
                        array[2] = this.u[2][d2] - array2[2];
                        array[3] = this.u[3][d2] - array2[3];
                        Arrays.sort(array);
                        x.a(e, new t((array[1] + array[2]) / 2.0, l.b()));
                        o2.g();
                        if (i) {
                            break;
                        }
                    }
                    return;
                }
                if (i) {
                    break;
                }
            }
            final double[] array7 = array2;
            final int n5 = 0;
            array7[n5] /= x.e();
            final double[] array8 = array2;
            final int n6 = 1;
            array8[n6] /= x.e();
            final double[] array9 = array2;
            final int n7 = 2;
            array9[n7] /= x.e();
            final double[] array10 = array2;
            final int n8 = 3;
            array10[n8] /= x.e();
            continue;
        }
    }
    
    protected void e() {
        super.e();
        this.o = null;
        this.p = null;
        this.A = null;
        this.B = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.y = null;
    }
}
