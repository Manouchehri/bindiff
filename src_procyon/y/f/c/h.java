package y.f.c;

import java.util.*;
import y.f.*;
import y.c.*;
import y.g.*;

public class h implements Q
{
    private A n;
    private p[] o;
    int[] a;
    private q[] p;
    private float[] q;
    private float[] r;
    private Comparator s;
    private Comparator t;
    private Comparator u;
    X b;
    int c;
    y[] d;
    private ar v;
    private long w;
    private long x;
    private D y;
    private D z;
    private p[] A;
    private int B;
    private byte C;
    private boolean D;
    private boolean E;
    private boolean F;
    int[] e;
    int[] f;
    int[] g;
    int[] h;
    public static final Object i;
    private boolean G;
    private int[][] H;
    private int[] I;
    Comparator j;
    Comparator k;
    private Comparator J;
    private Comparator K;
    int l;
    final int[] m;
    private int L;
    private int M;
    
    public h() {
        this.w = 1000L;
        this.C = 0;
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = false;
        this.m = new int[4];
        this.L = -1;
        this.M = 40;
    }
    
    public void a(final boolean e) {
        this.E = e;
    }
    
    public boolean a() {
        return this.E;
    }
    
    public void a(final byte c) {
        this.C = c;
    }
    
    public byte b() {
        return this.C;
    }
    
    public void b(final boolean d) {
        this.D = d;
    }
    
    public boolean c() {
        return this.D;
    }
    
    public void a(final long w) {
        this.w = w;
    }
    
    public void a(final Q q) {
        if (q instanceof h) {
            final h h = (h)q;
            this.b(h.c());
            this.a(h.a());
            this.d(h.h());
            this.a(h.i());
            this.a(h.b());
            this.b(h.c());
        }
    }
    
    public y[] a(final X x, final A a, final int n) {
        final boolean i = a.i;
        this.b(x, a, n);
        this.l = 0;
        this.c(false);
        this.d();
        int g = this.g();
        if (this.k() && g > 0) {
            final int[] s = this.s();
            int n2 = 0;
            while (n2 < this.M && g > 0 && this.k()) {
                int j = 0;
                Label_0179: {
                    Label_0173: {
                        if ((n2 & 0x3) < 2) {
                            this.c(true);
                            if (!i) {
                                break Label_0173;
                            }
                        }
                        j = 0;
                        while (true) {
                            while (j < this.q.length) {
                                this.q[j] = this.v.nextFloat();
                                ++j;
                                if (i) {
                                    while (j < this.d.length) {
                                        this.a(this.d[j], this.s);
                                        ++j;
                                        if (i) {
                                            break Label_0179;
                                        }
                                        if (i) {
                                            break;
                                        }
                                    }
                                    break Label_0173;
                                }
                                if (i) {
                                    break;
                                }
                            }
                            j = 0;
                            continue;
                        }
                    }
                    j = this.g();
                }
                if (j < g) {
                    this.a(s);
                    g = j;
                }
                ++n2;
                if (i) {
                    break;
                }
            }
            this.b(s);
            this.u();
        }
        this.B = g;
        return this.e();
    }
    
    void d() {
        final boolean i = y.f.c.a.i;
        if (this.G) {
            this.I = new int[this.b.f()];
            this.H = new int[this.d.length][];
            int j = 0;
        Label_0039:
            while (true) {
                HashSet<Integer> set;
                HashSet<Integer> set2;
                x a;
                x x;
                Object a2;
                int n;
                Integer n2;
                ArrayList list;
                int k;
                x x2;
                q e;
                Object a3;
                int n3;
                Label_0175_Outer:Label_0289_Outer:Label_0272_Outer:
                while (j < this.d.length) {
                    set = new HashSet<Integer>();
                    set2 = new HashSet<Integer>();
                    a = this.d[j].a();
                    if (!i) {
                        x = a;
                        while (true) {
                            while (x.f()) {
                                a2 = this.a(x.e());
                                n = ((a2 instanceof Number) ? 1 : 0);
                                if (!i) {
                                    if (n != 0) {
                                        n2 = new Integer(((Number)a2).intValue());
                                        if (!set.add(n2)) {
                                            set2.add((Object)n2);
                                        }
                                    }
                                    x.g();
                                    if (i) {
                                        break;
                                    }
                                    continue Label_0175_Outer;
                                }
                                else {
                                    Label_0264: {
                                        if (n > 0) {
                                            list = new ArrayList<Integer>(set2);
                                            y.g.e.a(list, null);
                                            this.H[j] = new int[list.size()];
                                            k = 0;
                                            while (k < list.size()) {
                                                this.H[j][k] = (int)list.get(k);
                                                ++k;
                                                if (i) {
                                                    break Label_0264;
                                                }
                                                if (i) {
                                                    break;
                                                }
                                            }
                                        }
                                        ++j;
                                    }
                                    if (i) {
                                        break Label_0175_Outer;
                                    }
                                    continue Label_0039;
                                }
                            }
                            set2.size();
                            continue Label_0289_Outer;
                        }
                    }
                Label_0272:
                    while (true) {
                        Label_0399: {
                            while (true) {
                                x2 = a;
                                while (x2.f()) {
                                    e = x2.e();
                                    a3 = this.a(e);
                                    n3 = ((a3 instanceof Number) ? 1 : 0);
                                    if (i) {
                                        break Label_0272;
                                    }
                                    Label_0388: {
                                        if (n3 != 0) {
                                            if (this.H[j] != null && Arrays.binarySearch(this.H[j], ((Number)a3).intValue()) >= 0) {
                                                this.I[e.d()] = ((Number)a3).intValue();
                                                if (!i) {
                                                    break Label_0388;
                                                }
                                            }
                                            this.I[e.d()] = Integer.MIN_VALUE;
                                        }
                                    }
                                    x2.g();
                                    if (i) {
                                        break;
                                    }
                                }
                                break Label_0399;
                                if (n3 < this.d.length) {
                                    this.d[j].a();
                                    continue Label_0272_Outer;
                                }
                                break;
                            }
                            return;
                        }
                        ++j;
                        if (i) {
                            return;
                        }
                        continue Label_0272;
                    }
                }
                j = 0;
                continue;
            }
        }
    }
    
    private void j() {
        final boolean i = y.f.c.a.i;
        this.f = null;
        this.e = null;
        this.h = null;
        this.g = null;
        final c c = this.b.c(aF.a);
        final c c2 = this.b.c(aF.b);
        if (c != null || c2 != null) {
            final d[] array = new d[this.b.g()];
            final ArrayList<Object> list = new ArrayList<Object>(31);
            final ArrayList<Object> list2 = new ArrayList<Object>(31);
            final ArrayList<Object> list3 = new ArrayList<Object>(31);
            final ArrayList<Object> list4 = new ArrayList<Object>(31);
            this.t = new y.f.c.q(this);
            this.u = new m(this);
        Label_1038_Outer:
            while (true) {
                x x = null;
            Label_1038:
                while (true) {
                    n n = null;
                    n n2 = null;
                    double n19 = 0.0;
                    Label_1465: {
                        Label_1460: {
                        Label_1351:
                            while (true) {
                                d d = null;
                                aE ae2 = null;
                                aE ae = null;
                                Label_1102: {
                                    d f2 = null;
                                    Label_1075: {
                                        if (c != null) {
                                            n = new n(this, true, true);
                                            n2 = new n(this, true, false);
                                            this.e = new int[this.b.h()];
                                            this.g = new int[this.b.h()];
                                            x = this.b.o();
                                            do {
                                                double f = 0.0;
                                                Label_0197: {
                                                    f = (x.f() ? 1 : 0);
                                                }
                                                Label_0204:
                                                while (f != 0) {
                                                    final q e = x.e();
                                                    list.clear();
                                                    list2.clear();
                                                    list3.clear();
                                                    list4.clear();
                                                    f2 = e.f();
                                                    if (!i) {
                                                        d = f2;
                                                        while (d != null) {
                                                            ae = (ae2 = (aE)c.b(d));
                                                            if (i) {
                                                                break Label_1102;
                                                            }
                                                            Label_0510: {
                                                                if (ae2 == null || !ae.a()) {
                                                                    if (ae == null) {
                                                                        this.e[d.b()] = 0;
                                                                        if (!i) {
                                                                            break Label_0510;
                                                                        }
                                                                    }
                                                                    if (ae.e()) {
                                                                        this.e[d.b()] = 1;
                                                                        if (!i) {
                                                                            break Label_0510;
                                                                        }
                                                                    }
                                                                    if (ae.f()) {
                                                                        this.e[d.b()] = -1;
                                                                        if (!i) {
                                                                            break Label_0510;
                                                                        }
                                                                    }
                                                                    if (ae.c()) {
                                                                        this.e[d.b()] = -2;
                                                                        if (!i) {
                                                                            break Label_0510;
                                                                        }
                                                                    }
                                                                    this.e[d.b()] = 0;
                                                                    if (!i) {
                                                                        break Label_0510;
                                                                    }
                                                                }
                                                                if (ae.e()) {
                                                                    this.e[d.b()] = 1;
                                                                    list.add(d);
                                                                    if (!i) {
                                                                        break Label_0510;
                                                                    }
                                                                }
                                                                if (ae.f()) {
                                                                    this.e[d.b()] = -1;
                                                                    list2.add(d);
                                                                    if (!i) {
                                                                        break Label_0510;
                                                                    }
                                                                }
                                                                if (ae.c()) {
                                                                    this.e[d.b()] = -2;
                                                                    list4.add(d);
                                                                    if (!i) {
                                                                        break Label_0510;
                                                                    }
                                                                }
                                                                this.e[d.b()] = 0;
                                                                list3.add(d);
                                                            }
                                                            d = d.g();
                                                            if (i) {
                                                                break;
                                                            }
                                                        }
                                                        double n5 = 0.0;
                                                        Label_0635: {
                                                            if (list.size() > 0) {
                                                                list.toArray(array);
                                                                y.g.e.a(array, 0, list.size(), n2);
                                                                int n3 = 0;
                                                                double n4 = -1.7976931348623157E308;
                                                                int j = 0;
                                                                while (j < list.size()) {
                                                                    final d d2 = array[j];
                                                                    final double b = this.b.n(d2).b;
                                                                    n5 = dcmpl(b, n4);
                                                                    if (i) {
                                                                        break Label_0635;
                                                                    }
                                                                    if (n5 != 0) {
                                                                        n4 = b;
                                                                        ++n3;
                                                                    }
                                                                    this.g[d2.b()] = n3;
                                                                    ++j;
                                                                    if (i) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            list2.size();
                                                        }
                                                        double n8 = 0.0;
                                                        Label_0744: {
                                                            if (n5 > 0) {
                                                                list2.toArray(array);
                                                                y.g.e.a(array, 0, list2.size(), n2);
                                                                int n6 = 0;
                                                                double n7 = -1.7976931348623157E308;
                                                                int k = list2.size() - 1;
                                                                while (k >= 0) {
                                                                    final d d3 = array[k];
                                                                    final double b2 = this.b.n(d3).b;
                                                                    n8 = dcmpl(b2, n7);
                                                                    if (i) {
                                                                        break Label_0744;
                                                                    }
                                                                    if (n8 != 0) {
                                                                        n7 = b2;
                                                                        ++n6;
                                                                    }
                                                                    this.g[d3.b()] = n6;
                                                                    --k;
                                                                    if (i) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            list3.size();
                                                        }
                                                        double n11 = 0.0;
                                                        Label_0853: {
                                                            if (n8 > 0) {
                                                                list3.toArray(array);
                                                                y.g.e.a(array, 0, list3.size(), n);
                                                                int n9 = 0;
                                                                double n10 = -1.7976931348623157E308;
                                                                int l = list3.size() - 1;
                                                                while (l >= 0) {
                                                                    final d d4 = array[l];
                                                                    final double a = this.b.n(d4).a;
                                                                    n11 = dcmpl(a, n10);
                                                                    if (i) {
                                                                        break Label_0853;
                                                                    }
                                                                    if (n11 != 0) {
                                                                        n10 = a;
                                                                        ++n9;
                                                                    }
                                                                    this.g[d4.b()] = n9;
                                                                    --l;
                                                                    if (i) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            list4.size();
                                                        }
                                                        if (n11 > 0) {
                                                            list4.toArray(array);
                                                            y.g.e.a(array, 0, list4.size(), n);
                                                            int n12 = 0;
                                                            double n13 = -1.7976931348623157E308;
                                                            int n14 = 0;
                                                            while (n14 < list4.size()) {
                                                                final d d5 = array[n14];
                                                                final double a2 = this.b.n(d5).a;
                                                                final double n15 = f = dcmpl(a2, n13);
                                                                if (i) {
                                                                    continue Label_0204;
                                                                }
                                                                if (n15 != 0) {
                                                                    n13 = a2;
                                                                    ++n12;
                                                                }
                                                                this.g[d5.b()] = n12;
                                                                ++n14;
                                                                if (i) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        x.g();
                                                        continue Label_0197;
                                                    }
                                                    break Label_1075;
                                                }
                                                break;
                                            } while (!i);
                                        }
                                        if (c2 == null) {
                                            return;
                                        }
                                        n = new n(this, false, true);
                                        n2 = new n(this, false, false);
                                        this.f = new int[this.b.h()];
                                        this.h = new int[this.b.h()];
                                        x = this.b.o();
                                        final double f3 = x.f() ? 1 : 0;
                                        if (f3 == 0) {
                                            return;
                                        }
                                        final q e2 = x.e();
                                        list.clear();
                                        list2.clear();
                                        list3.clear();
                                        list4.clear();
                                        e2.g();
                                    }
                                    d = f2;
                                    if (d == null) {
                                        break Label_1351;
                                    }
                                    ae = (aE)c2.b(d);
                                    if (i) {
                                        break Label_1460;
                                    }
                                }
                                Label_1339: {
                                    if (ae2 == null || !ae.a()) {
                                        if (ae == null) {
                                            this.f[d.b()] = 0;
                                            if (!i) {
                                                break Label_1339;
                                            }
                                        }
                                        if (ae.e()) {
                                            this.f[d.b()] = 1;
                                            if (!i) {
                                                break Label_1339;
                                            }
                                        }
                                        if (ae.f()) {
                                            this.f[d.b()] = -1;
                                            if (!i) {
                                                break Label_1339;
                                            }
                                        }
                                        if (ae.d()) {
                                            this.f[d.b()] = -2;
                                            if (!i) {
                                                break Label_1339;
                                            }
                                        }
                                        this.f[d.b()] = 0;
                                        if (!i) {
                                            break Label_1339;
                                        }
                                    }
                                    if (ae.e()) {
                                        this.f[d.b()] = 1;
                                        list.add(d);
                                        if (!i) {
                                            break Label_1339;
                                        }
                                    }
                                    if (ae.f()) {
                                        this.f[d.b()] = -1;
                                        list2.add(d);
                                        if (!i) {
                                            break Label_1339;
                                        }
                                    }
                                    if (ae.d()) {
                                        this.f[d.b()] = -2;
                                        list4.add(d);
                                        if (!i) {
                                            break Label_1339;
                                        }
                                    }
                                    this.f[d.b()] = 0;
                                    list3.add(d);
                                }
                                d = d.h();
                                if (!i) {
                                    continue;
                                }
                                break;
                            }
                            if (list.size() > 0) {
                                list.toArray(array);
                                y.g.e.a(array, 0, list.size(), n2);
                                int n16 = 0;
                                double n17 = -1.7976931348623157E308;
                                int n18 = list.size() - 1;
                                while (n18 >= 0) {
                                    final d d6 = array[n18];
                                    final double b3 = this.b.o(d6).b;
                                    n19 = dcmpl(b3, n17);
                                    if (i) {
                                        break Label_1465;
                                    }
                                    if (n19 != 0) {
                                        n17 = b3;
                                        ++n16;
                                    }
                                    this.h[d6.b()] = n16;
                                    --n18;
                                    if (i) {
                                        break;
                                    }
                                }
                            }
                        }
                        list2.size();
                    }
                    double n23 = 0.0;
                    Label_1573: {
                        if (n19 > 0) {
                            list2.toArray(array);
                            y.g.e.a(array, 0, list2.size(), n2);
                            int n20 = 0;
                            double n21 = -1.7976931348623157E308;
                            int n22 = 0;
                            while (n22 < list2.size()) {
                                final d d7 = array[n22];
                                final double b4 = this.b.o(d7).b;
                                n23 = dcmpl(b4, n21);
                                if (i) {
                                    break Label_1573;
                                }
                                if (n23 != 0) {
                                    n21 = b4;
                                    ++n20;
                                }
                                this.h[d7.b()] = n20;
                                ++n22;
                                if (i) {
                                    break;
                                }
                            }
                        }
                        list3.size();
                    }
                    double n27 = 0.0;
                    Label_1682: {
                        if (n23 > 0) {
                            list3.toArray(array);
                            y.g.e.a(array, 0, list3.size(), n);
                            int n24 = 0;
                            double n25 = -1.7976931348623157E308;
                            int n26 = list3.size() - 1;
                            while (n26 >= 0) {
                                final d d8 = array[n26];
                                final double a3 = this.b.o(d8).a;
                                n27 = dcmpl(a3, n25);
                                if (i) {
                                    break Label_1682;
                                }
                                if (n27 != 0) {
                                    n25 = a3;
                                    ++n24;
                                }
                                this.h[d8.b()] = n24;
                                --n26;
                                if (i) {
                                    break;
                                }
                            }
                        }
                        list4.size();
                    }
                    if (n27 > 0) {
                        list4.toArray(array);
                        y.g.e.a(array, 0, list4.size(), n);
                        int n28 = 0;
                        double n29 = -1.7976931348623157E308;
                        int n30 = 0;
                        while (n30 < list4.size()) {
                            final d d9 = array[n30];
                            final double a4 = this.b.o(d9).a;
                            final double f3;
                            final double n31 = f3 = dcmpl(a4, n29);
                            if (i) {
                                continue Label_1038;
                            }
                            if (n31 != 0) {
                                n29 = a4;
                                ++n28;
                            }
                            this.h[d9.b()] = n28;
                            ++n30;
                            if (i) {
                                break;
                            }
                        }
                    }
                    break;
                }
                x.g();
                if (!i) {
                    continue Label_1038_Outer;
                }
                break;
            }
        }
    }
    
    void b(final X b, final A n, final int c) {
        final boolean i = y.f.c.a.i;
        this.x = System.currentTimeMillis();
        this.b = b;
        this.n = n;
        this.y = new D();
        this.z = new D();
        this.c = c;
        this.s = new i(this);
        this.v = new ar(666L);
        this.d = new y[c];
        int j = 0;
        while (true) {
            while (j < this.d.length) {
                this.d[j] = new y();
                ++j;
                if (i) {
                    final x o = this.b.o();
                    while (true) {
                        while (o.f()) {
                            final q e = o.e();
                            j = Math.max(j, Math.max(e.b(), e.c()));
                            o.g();
                            if (i) {
                                final D d = new D();
                                final y.c.e p3 = this.b.p();
                                while (true) {
                                    while (p3.f()) {
                                        final d a = p3.a();
                                        final p a2 = d.a(a);
                                        a2.a(null);
                                        this.A[a.b()] = a2;
                                        d.g();
                                        p3.g();
                                        if (i) {
                                            this.G = (this.b.c(y.f.c.h.i) != null);
                                            this.b.a(this.K, this.J);
                                            this.j();
                                            Label_0471: {
                                                if (this.g == null) {
                                                    this.k = new aH(this.a, (byte)1);
                                                    if (!i) {
                                                        break Label_0471;
                                                    }
                                                }
                                                this.k = new y.f.c.p(this);
                                            }
                                            Label_0511: {
                                                if (this.h == null) {
                                                    this.j = new aH(this.a, (byte)0);
                                                    if (!i) {
                                                        break Label_0511;
                                                    }
                                                }
                                                this.j = new o(this);
                                            }
                                            if (y.c.i.g) {
                                                y.f.c.a.i = !i;
                                            }
                                            return;
                                        }
                                        if (i) {
                                            break;
                                        }
                                    }
                                    this.r = new float[j + 2];
                                    this.o = new p[this.b.f()];
                                    this.J = new aH(this.a, (byte)3);
                                    this.K = new aH(this.a, (byte)4);
                                    continue;
                                }
                            }
                            if (i) {
                                break;
                            }
                        }
                        this.A = new p[this.b.g()];
                        continue;
                    }
                }
                if (i) {
                    break;
                }
            }
            this.a = new int[this.b.f()];
            this.p = new q[this.b.f()];
            this.q = new float[this.b.f() + 1];
            j = 0;
            continue;
        }
    }
    
    y[] e() {
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.k = null;
        this.j = null;
        this.b = null;
        final y[] d = this.d;
        this.d = null;
        this.I = null;
        this.y = null;
        this.z = null;
        this.t = null;
        this.u = null;
        return d;
    }
    
    private boolean k() {
        return System.currentTimeMillis() - this.x <= this.w;
    }
    
    private void l() {
        final boolean i = y.f.c.a.i;
        final x o = this.b.o();
        while (o.f()) {
            this.q[o.e().d()] = this.v.nextInt();
            o.g();
            if (i) {
                return;
            }
            if (i) {
                break;
            }
        }
        this.b.a(new j(this), new k(this));
    }
    
    void c(final boolean b) {
        final boolean i = y.f.c.a.i;
        int j = 0;
        while (true) {
            while (j < this.d.length) {
                this.d[j].clear();
                ++j;
                if (i) {
                    q q = this.b.k();
                    final x o = this.b.o();
                    while (o.f()) {
                        if (this.n.a(q) > this.n.a(o.e())) {
                            q = o.e();
                            if (this.n.a(q) == 0) {
                                break;
                            }
                        }
                        o.g();
                        if (i) {
                            break;
                        }
                    }
                    final l l = new l(this);
                    l.a(false);
                    l.b(true);
                    l.a(this.b, q);
                    this.t();
                    return;
                }
                if (i) {
                    break;
                }
            }
            if (b) {
                this.l();
                Arrays.fill(this.a, 0);
                this.b.a(null, this.J);
            }
            continue;
        }
    }
    
    private void m() {
        this.b.a(this.k, this.j);
    }
    
    int f() {
        final boolean i = y.f.c.a.i;
        if (this.e != null && this.f != null) {
            return this.n();
        }
        this.m();
        int n = 0;
        int j = 1;
        while (true) {
            while (j < this.d.length) {
                n += this.a(this.d[j - 1], this.d[j]);
                ++j;
                if (i) {
                    final x o = this.b.o();
                    do {
                        Label_0087: {
                            o.f();
                        }
                        int k = 0;
                        Label_0093:
                        while (k != 0) {
                            final q e = o.e();
                            if (!i) {
                                if (this.e != null) {
                                    int n2 = 0;
                                    int n3 = 0;
                                    int n4 = 0;
                                    d d = e.f();
                                    while (d != null) {
                                        k = this.e[d.b()];
                                        if (i) {
                                            continue Label_0093;
                                        }
                                        Label_0200: {
                                            Label_0213: {
                                                switch (k) {
                                                    case -2:
                                                    case -1: {
                                                        ++n3;
                                                        j += n4 + n2;
                                                        if (i) {
                                                            break Label_0200;
                                                        }
                                                        break;
                                                    }
                                                    case 0: {
                                                        ++n4;
                                                        j += n2;
                                                        if (i) {
                                                            break Label_0213;
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        ++n2;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        d = d.g();
                                        if (i) {
                                            break;
                                        }
                                    }
                                }
                                if (this.f != null) {
                                    int n5 = 0;
                                    int n6 = 0;
                                    int n7 = 0;
                                    d d2 = e.g();
                                    while (d2 != null) {
                                        final int n8 = this.f[d2.b()];
                                        if (i) {
                                            continue Label_0093;
                                        }
                                        Label_0316: {
                                            Label_0329: {
                                                switch (n8) {
                                                    case -2:
                                                    case -1: {
                                                        ++n6;
                                                        j += n7 + n5;
                                                        if (i) {
                                                            break Label_0316;
                                                        }
                                                        break;
                                                    }
                                                    case 0: {
                                                        ++n7;
                                                        j += n5;
                                                        if (i) {
                                                            break Label_0329;
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        ++n5;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        d2 = d2.h();
                                        if (i) {
                                            break;
                                        }
                                    }
                                }
                                o.g();
                                continue Label_0087;
                            }
                            return n;
                        }
                        break;
                    } while (!i);
                    n += j;
                    return n;
                }
                if (i) {
                    break;
                }
            }
            j = 0;
            continue;
        }
    }
    
    private int a(final D d, final D d2) {
        final boolean i = y.f.c.a.i;
        p p2 = d.k();
        p p3 = d2.k();
        this.y.clear();
        this.z.clear();
        int n = 0;
        p p4 = null;
        Label_0116: {
            while (p2 != null) {
                p4 = p3;
                if (i || p4 == null) {
                    break Label_0116;
                }
                n = n + this.a((q)p2.c(), this.y, this.z, true) + this.a((q)p3.c(), this.z, this.y, false);
                p2 = p2.a();
                p3 = p3.a();
                if (i) {
                    goto Label_0115;
                }
            }
            goto Label_0115;
        }
        int n2 = 0;
        if (p4 != null) {
            n += this.a((q)p2.c(), this.y, this.z, true);
            p2 = p2.a();
            if (i) {
                return n2;
            }
            if (!i) {
                goto Label_0115;
            }
        }
        while (p3 != null) {
            n2 = n + this.a((q)p3.c(), this.z, this.y, false);
            if (i) {
                break;
            }
            n = n2;
            p3 = p3.a();
            if (i) {
                break;
            }
        }
        return n2;
    }
    
    private int a(final q q, final D d, final D d2, final boolean b) {
        final boolean i = y.f.c.a.i;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        final int d3;
        final int n4 = this.a[d3 = q.d()];
        if (this.o[d3] != null) {
            final p a = this.o[d3].a();
            p p4 = d.k();
            while (p4 != a) {
                Label_0097: {
                    if (p4.c() == q) {
                        ++n;
                        n3 += n2;
                        d.h(p4);
                        if (!i) {
                            break Label_0097;
                        }
                    }
                    ++n2;
                }
                p4 = p4.a();
                if (i) {
                    break;
                }
            }
            this.o[d3] = null;
        }
        final int n5 = n * d2.size() + n3;
        int n6 = 0;
        Label_0200: {
            if (b) {
                d d4 = q.f();
                while (d4 != null) {
                    final q d6;
                    final int d5 = (d6 = d4.d()).d();
                    n6 = this.a[d5];
                    if (i) {
                        break;
                    }
                    if (n6 >= n4) {
                        this.o[d5] = d2.b(d6);
                    }
                    d4 = d4.g();
                    if (i) {
                        break Label_0200;
                    }
                }
                return n6;
            }
        }
        d d7 = q.g();
        while (d7 != null) {
            final q c;
            final int d8 = (c = d7.c()).d();
            final int n7 = this.a[d8];
            if (i) {
                break;
            }
            if (n7 > n4) {
                this.o[d8] = d2.b(c);
            }
            d7 = d7.h();
            if (i) {
                break;
            }
        }
        return n6;
    }
    
    private int n() {
        final boolean i = y.f.c.a.i;
        this.b.a(this.t, this.u);
        int n = 0;
        int j = this.d.length - 1;
        int n2 = 0;
        while (j > 0) {
            n2 = n + this.b(this.d[j - 1], this.d[j]);
            if (i) {
                return n2;
            }
            n = n2;
            --j;
            if (i) {
                break;
            }
        }
        return n2;
    }
    
    private int b(final D d, final D d2) {
        final boolean i = y.f.c.a.i;
        p p2 = d.k();
        p p3 = d2.k();
        this.y.clear();
        this.z.clear();
        int n = 0;
        p p4 = null;
        Label_0116: {
            while (p2 != null) {
                p4 = p3;
                if (i || p4 == null) {
                    break Label_0116;
                }
                n = n + this.b((q)p2.c(), this.y, this.z, true) + this.b((q)p3.c(), this.z, this.y, false);
                p2 = p2.a();
                p3 = p3.a();
                if (i) {
                    goto Label_0115;
                }
            }
            goto Label_0115;
        }
        int n2 = 0;
        if (p4 != null) {
            n += this.b((q)p2.c(), this.y, this.z, true);
            p2 = p2.a();
            if (i) {
                return n2;
            }
            if (!i) {
                goto Label_0115;
            }
        }
        while (p3 != null) {
            n2 = n + this.b((q)p3.c(), this.z, this.y, false);
            if (i) {
                break;
            }
            n = n2;
            p3 = p3.a();
            if (i) {
                break;
            }
        }
        return n2;
    }
    
    private int b(final q q, final D d, final D d2, final boolean b) {
        final boolean i = y.f.c.a.i;
        final int n = this.a[q.d()];
        final int[] m = this.m;
        final int n2 = 0;
        final int[] j = this.m;
        final int n3 = 1;
        final int[] k = this.m;
        final int n4 = 2;
        final int[] l = this.m;
        final int n5 = 3;
        final int n6 = 0;
        k[n4] = (l[n5] = n6);
        m[n2] = (j[n3] = n6);
        int n7 = n6;
        Label_0403: {
            if (b) {
                d d3 = q.f();
                int b2;
                p p4;
                int[] m2;
                int n8;
                p b3;
                int n9;
                p p5;
                d d4;
                int n10;
                int n11;
                int n12;
                Label_0193_Outer:Label_0325_Outer:
                while (d3 != null) {
                    p4 = this.A[b2 = d3.b()];
                    Label_0391: {
                        if (p4.c() == null) {
                            d2.a(p4);
                            p4.a(d3);
                            m2 = this.m;
                            n8 = this.e[b2] + 2;
                            ++m2[n8];
                            if (!i) {
                                break Label_0391;
                            }
                        }
                        d.h(p4);
                        p4.a(null);
                        Label_0198: {
                            if (this.g[b2] > 0) {
                                b3 = p4;
                                while (true) {
                                    while (b3.b() != null) {
                                        ++n7;
                                        b3 = b3.b();
                                        if (!i) {
                                            if (i) {
                                                break;
                                            }
                                            continue Label_0193_Outer;
                                        }
                                        else {
                                            if (i) {
                                                break Label_0198;
                                            }
                                            break Label_0391;
                                        }
                                    }
                                    n7 += d2.size();
                                    continue Label_0325_Outer;
                                }
                            }
                        }
                        n9 = this.e[b2];
                        p5 = p4.b();
                    Label_0333_Outer:
                        while (true) {
                        Label_0354_Outer:
                            while (true) {
                            Label_0375_Outer:
                                while (true) {
                                    while (true) {
                                        while (p5 != null) {
                                            n10 = this.a[(d4 = (d)p5.c()).c().d()];
                                            n11 = n;
                                            if (!i) {
                                                if (n10 > n11 || this.e[d4.b()] > n9) {
                                                    ++n7;
                                                }
                                                p5 = p5.b();
                                                if (i) {
                                                    break;
                                                }
                                                continue Label_0325_Outer;
                                            }
                                            else {
                                                n7 = n10 + n11;
                                                if (!i) {
                                                    break Label_0391;
                                                }
                                                n7 += d2.size() - this.m[1];
                                                if (!i) {
                                                    break Label_0391;
                                                }
                                                n7 += d2.size() - this.m[2];
                                                if (i) {
                                                    n7 += d2.size() - this.m[3];
                                                }
                                                break Label_0391;
                                            }
                                        }
                                        switch (n9) {
                                            case -2: {
                                                n12 = d2.size() - this.m[0];
                                                continue Label_0333_Outer;
                                            }
                                            case -1: {
                                                continue Label_0354_Outer;
                                            }
                                            case 0: {
                                                continue Label_0375_Outer;
                                            }
                                            case 1: {
                                                continue;
                                            }
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                    }
                    d3 = d3.g();
                    if (i) {
                        break Label_0403;
                    }
                }
                return n7;
            }
        }
        d d5 = q.g();
        int b4;
        p p6;
        int[] m3;
        int n13;
        p b5;
        int n14;
        p p7;
        d d6;
        int n15;
        int n16;
        int n17;
        Label_0541_Outer:Label_0677_Outer:
        while (d5 != null) {
            p6 = this.A[b4 = d5.b()];
            Label_0743: {
                if (p6.c() == null) {
                    d2.a(p6);
                    p6.a(d5);
                    m3 = this.m;
                    n13 = this.f[b4] + 2;
                    ++m3[n13];
                    if (!i) {
                        break Label_0743;
                    }
                }
                d.h(p6);
                p6.a(null);
                Label_0546: {
                    if (this.h[b4] > 0) {
                        b5 = p6;
                        while (true) {
                            while (b5.b() != null) {
                                ++n7;
                                b5 = b5.b();
                                if (!i) {
                                    if (i) {
                                        break;
                                    }
                                    continue Label_0541_Outer;
                                }
                                else {
                                    if (i) {
                                        break Label_0546;
                                    }
                                    break Label_0743;
                                }
                            }
                            n7 += d2.size();
                            continue Label_0677_Outer;
                        }
                    }
                }
                n14 = this.f[b4];
                p7 = p6.b();
            Label_0685_Outer:
                while (true) {
                Label_0706_Outer:
                    while (true) {
                    Label_0727_Outer:
                        while (true) {
                            while (true) {
                                while (p7 != null) {
                                    d6 = (d)p7.c();
                                    n15 = this.a[d6.d().d()];
                                    n16 = n;
                                    if (!i) {
                                        if (n15 > n16 || this.f[d6.b()] > n14) {
                                            ++n7;
                                        }
                                        p7 = p7.b();
                                        if (i) {
                                            break;
                                        }
                                        continue Label_0677_Outer;
                                    }
                                    else {
                                        n7 = n15 + n16;
                                        if (!i) {
                                            break Label_0743;
                                        }
                                        n7 += d2.size() - this.m[1];
                                        if (!i) {
                                            break Label_0743;
                                        }
                                        n7 += d2.size() - this.m[2];
                                        if (i) {
                                            n7 += d2.size() - this.m[3];
                                        }
                                        break Label_0743;
                                    }
                                }
                                switch (n14) {
                                    case -2: {
                                        n17 = d2.size() - this.m[0];
                                        continue Label_0685_Outer;
                                    }
                                    case -1: {
                                        continue Label_0706_Outer;
                                    }
                                    case 0: {
                                        continue Label_0727_Outer;
                                    }
                                    case 1: {
                                        continue;
                                    }
                                }
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    break;
                }
            }
            d5 = d5.h();
            if (i) {
                break;
            }
        }
        return n7;
    }
    
    int g() {
        final boolean i = y.f.c.a.i;
        if (this.G) {
            this.w();
        }
        y.a.a.a();
        final int[] s = this.s();
        int f = this.f();
        boolean b = true;
        int j = 0;
        while (true) {
            while (j < 4) {
                final boolean k = this.k();
                if (i) {
                    int n2 = 0;
                    if (k && f > 0) {
                        int l = 1;
                        int n = 0;
                        while (l == 1) {
                            n2 = f;
                            if (i) {
                                return n2;
                            }
                            if (n2 <= 0) {
                                break;
                            }
                            this.o();
                            this.p();
                            final int f2 = this.f();
                            Label_0181: {
                                if (f2 < f) {
                                    l = 1;
                                    this.a(s);
                                    if (!i) {
                                        break Label_0181;
                                    }
                                }
                                l = -1;
                            }
                            f = f2;
                            ++n;
                            if (i) {
                                break;
                            }
                        }
                        this.b(s);
                        this.u();
                    }
                    return n2;
                }
                if (!k || f <= 0) {
                    break;
                }
                final int e = this.e(b);
                Label_0087: {
                    if (e < f) {
                        this.a(s);
                        f = e;
                        if (!i) {
                            break Label_0087;
                        }
                    }
                    ++j;
                }
                b = !b;
                if (i) {
                    break;
                }
            }
            this.b(s);
            this.u();
            final boolean d = this.D;
            continue;
        }
    }
    
    private void o() {
        final boolean i = y.f.c.a.i;
        final y.c.h q = this.q();
        final int[] s = this.s();
        final D[][] array = new D[this.b.f()][];
        int j = this.d.length - 1;
        while (true) {
        Label_0253_Outer:
            while (j >= 0) {
                final C m = this.d[j].m();
                h h = null;
                Label_0479: {
                Label_0253:
                    while (true) {
                        Label_0271: {
                            if (i) {
                                break Label_0271;
                            }
                            final C c = m;
                            while (c.f()) {
                                final q q2 = (q)c.d();
                                final int b = q2.b();
                                final int n = 1;
                                if (i) {
                                    break Label_0253;
                                }
                                Label_0230: {
                                    if (b == n && q2.c() == 1 && (!this.G || this.I[q2.d()] == Integer.MIN_VALUE)) {
                                        final q q3 = (q)q.b(q2.f());
                                        if (q3 != null && array[q3.d()] == null) {
                                            final int a = this.a(q2, q3);
                                            final int d = q3.d();
                                            final D[][] array2 = array;
                                            final int n2 = d;
                                            final D[] array3 = new D[a + 1];
                                            array2[n2] = array3;
                                            final D[] array4 = array3;
                                            int k = array4.length - 1;
                                            while (k >= 0) {
                                                array4[k] = new D();
                                                --k;
                                                if (i) {
                                                    break Label_0230;
                                                }
                                                if (i) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    c.g();
                                }
                                if (i) {
                                    break;
                                }
                            }
                            --j;
                            if (i) {
                                break;
                            }
                            continue Label_0253_Outer;
                            int b = 0;
                            int n = 0;
                            if (b >= n) {
                                break Label_0253;
                            }
                            h = this;
                            if (i) {
                                break Label_0479;
                            }
                            this.d[j].m();
                        }
                        final C c2 = m;
                        while (c2.f()) {
                            final q q5;
                            final q q4 = q5 = (q)c2.d();
                        Label_0297:
                            while (true) {
                                q q6 = null;
                                final int b2 = q6.b();
                                final boolean b3 = true;
                                if (!i) {
                                    if (b2 == (b3 ? 1 : 0) && q4.c() == 1) {
                                        final q q7 = (q)q.b(q4.f());
                                        if (q7 == null) {
                                            break;
                                        }
                                        array[q7.d()][this.a(q4, q7) - 1].b(q4.g());
                                        if (!i) {
                                            break;
                                        }
                                    }
                                    d d2 = q4.g();
                                    while (d2 != null) {
                                        final q q8 = q6 = (q)q.b(d2);
                                        if (i) {
                                            continue Label_0297;
                                        }
                                        if (q6 != null) {
                                            array[q8.d()][this.a(q4, q8) - 1].b(d2);
                                        }
                                        d2 = d2.h();
                                        if (i) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                continue Label_0253;
                            }
                            c2.g();
                            if (i) {
                                break;
                            }
                        }
                        ++j;
                        if (!i) {
                            final int length = this.d.length;
                            continue Label_0253;
                        }
                        break;
                    }
                    h = this;
                }
                final x o = h.b.o();
                while (o.f()) {
                    o.e();
                Label_0504:
                    while (true) {
                        q q10 = null;
                        final q q9 = q10;
                        if (i) {
                            return;
                        }
                        if (array[q9.d()] == null) {
                            break;
                        }
                        d d3 = q9.f();
                        while (d3 != null) {
                            final q q11 = q10 = (q)q.b(d3);
                            if (i) {
                                continue Label_0504;
                            }
                            Label_0780: {
                                Label_0773: {
                                    if (q10 != null) {
                                        final D[] array5 = array[q11.d()];
                                    Label_0571:
                                        while (true) {
                                            while (array5[0].size() > 0) {
                                                int l = 0;
                                                while (true) {
                                                    d d4 = (d)array5[l].f();
                                                    q q12 = d4.d();
                                                    q12.b();
                                                Label_0610:
                                                    while (true) {
                                                        final int c3;
                                                        int n3 = 0;
                                                        if (c3 == n3) {
                                                            c3 = q12.c();
                                                            final boolean b5;
                                                            final boolean b4 = b5 = true;
                                                            if (i) {
                                                                continue Label_0253_Outer;
                                                            }
                                                            if (c3 == (b4 ? 1 : 0)) {
                                                                ++l;
                                                                if (!i) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        ((d)array5[l].g()).d();
                                                        --l;
                                                        q q13 = d4.c();
                                                        d4 = (d)array5[l].g();
                                                        q12 = d4.d();
                                                        while (l >= 0) {
                                                            final int n4 = s[q13.d()];
                                                            n3 = s[q12.d()];
                                                            if (i) {
                                                                continue Label_0610;
                                                            }
                                                            if (n4 != n3) {
                                                                this.a[q13.d()] = s[q12.d()];
                                                            }
                                                            q13 = q13.g().c();
                                                            if (--l < 0) {
                                                                continue Label_0253_Outer;
                                                            }
                                                            d4 = (d)array5[l].g();
                                                            q12 = d4.d();
                                                            if (i) {
                                                                break Label_0780;
                                                            }
                                                            if (i) {
                                                                break Label_0773;
                                                            }
                                                        }
                                                        continue Label_0571;
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                                d3 = d3.g();
                            }
                            if (i) {
                                break;
                            }
                        }
                        break;
                    }
                    o.g();
                    if (i) {
                        break;
                    }
                }
                this.u();
                this.b.a(q);
                return;
            }
            j = 0;
            continue;
        }
    }
    
    private void p() {
        final boolean i = y.f.c.a.i;
        final y.c.h r = this.r();
        final int[] s = this.s();
        final D[][] array = new D[this.b.f()][];
        int n = 0;
        while (true) {
            do {
                Label_0029: {
                    final int length = this.d.length;
                }
                int j = 0;
                int n2 = 0;
                C m;
                C c;
                q q;
                q q2;
                int a;
                int d;
                D[][] array2;
                int n3;
                D[] array3;
                D[] array4;
                int k;
                C c2;
                q q4;
                q q3;
                q q5 = null;
                int b;
                q q6;
                d d2;
                q q7;
                h h = null;
                x o;
                q q9 = null;
                q q8;
                d d3;
                q q10;
                D[] array5;
                int l;
                d d4;
                q q11;
                int c3 = 0;
                int n4 = 0;
                boolean b3;
                boolean b2;
                q q12;
                int n5;
                Label_0036:
                Label_0271_Outer:Label_0253_Outer:
                while (j < n2) {
                    m = this.d[n].m();
                    if (!i) {
                        c = m;
                        while (c.f()) {
                            q = (q)c.d();
                            j = q.b();
                            n2 = 1;
                            if (i) {
                                continue Label_0036;
                            }
                            Label_0229: {
                                if (j == n2 && q.c() == 1 && (!this.G || this.I[q.d()] == Integer.MIN_VALUE)) {
                                    q2 = (q)r.b(q.g());
                                    if (q2 != null && array[q2.d()] == null) {
                                        a = this.a(q2, q);
                                        d = q2.d();
                                        array2 = array;
                                        n3 = d;
                                        array3 = new D[a + 1];
                                        array2[n3] = array3;
                                        array4 = array3;
                                        k = array4.length - 1;
                                        while (k >= 0) {
                                            array4[k] = new D();
                                            --k;
                                            if (i) {
                                                break Label_0229;
                                            }
                                            if (i) {
                                                break;
                                            }
                                        }
                                    }
                                }
                                c.g();
                            }
                            if (i) {
                                break;
                            }
                        }
                        ++n;
                        continue Label_0029;
                    }
                    Label_0479: {
                        Label_0478: {
                        Label_0253:
                            while (true) {
                                Label_0470: {
                                    while (true) {
                                        c2 = m;
                                        while (c2.f()) {
                                            q3 = (q4 = (q)c2.d());
                                            Label_0297:
                                            while (true) {
                                                b = q5.b();
                                                if (!i) {
                                                    if (b == 1 && q3.c() == 1) {
                                                        q6 = (q)r.b(q3.g());
                                                        if (q6 == null) {
                                                            break;
                                                        }
                                                        array[q6.d()][this.a(q6, q3) - 1].b(q3.f());
                                                        if (!i) {
                                                            break;
                                                        }
                                                    }
                                                    d2 = q3.f();
                                                    while (d2 != null) {
                                                        q7 = (q5 = (q)r.b(d2));
                                                        if (i) {
                                                            continue Label_0297;
                                                        }
                                                        if (q5 != null) {
                                                            array[q7.d()][this.a(q7, q3) - 1].b(d2);
                                                        }
                                                        d2 = d2.g();
                                                        if (i) {
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                break Label_0253;
                                            }
                                            c2.g();
                                            if (i) {
                                                break;
                                            }
                                        }
                                        break Label_0470;
                                        if (b < 0) {
                                            break Label_0478;
                                        }
                                        h = this;
                                        if (!i) {
                                            this.d[n].m();
                                            continue Label_0253_Outer;
                                        }
                                        break;
                                    }
                                    break Label_0479;
                                }
                                --n;
                                if (!i) {
                                    continue Label_0253;
                                }
                                break;
                            }
                        }
                        h = this;
                    }
                    o = h.b.o();
                    while (o.f()) {
                        o.e();
                        Label_0504:
                        while (true) {
                            q8 = q9;
                            if (i) {
                                return;
                            }
                            if (array[q8.d()] == null) {
                                break;
                            }
                            d3 = q8.g();
                            while (d3 != null) {
                                q10 = (q9 = (q)r.b(d3));
                                if (i) {
                                    continue Label_0504;
                                }
                                Label_0780: {
                                    Label_0773: {
                                        if (q9 != null) {
                                            array5 = array[q10.d()];
                                        Label_0571:
                                            while (true) {
                                                while (array5[0].size() > 0) {
                                                    l = 0;
                                                    while (true) {
                                                        d4 = (d)array5[l].f();
                                                        q11 = d4.c();
                                                        q11.b();
                                                        Label_0610:
                                                        while (true) {
                                                            if (c3 == n4) {
                                                                c3 = q11.c();
                                                                b2 = (b3 = true);
                                                                if (i) {
                                                                    continue Label_0271_Outer;
                                                                }
                                                                if (c3 == (b2 ? 1 : 0)) {
                                                                    ++l;
                                                                    if (!i) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            ((d)array5[l].g()).c();
                                                            --l;
                                                            q12 = d4.d();
                                                            d4 = (d)array5[l].g();
                                                            q11 = d4.c();
                                                            while (l >= 0) {
                                                                n5 = s[q12.d()];
                                                                n4 = s[q11.d()];
                                                                if (i) {
                                                                    continue Label_0610;
                                                                }
                                                                if (n5 != n4) {
                                                                    this.a[q12.d()] = s[q11.d()];
                                                                }
                                                                q12 = q12.f().d();
                                                                if (--l < 0) {
                                                                    continue Label_0271_Outer;
                                                                }
                                                                d4 = (d)array5[l].g();
                                                                q11 = d4.c();
                                                                if (i) {
                                                                    break Label_0780;
                                                                }
                                                                if (i) {
                                                                    break Label_0773;
                                                                }
                                                            }
                                                            continue Label_0571;
                                                        }
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    d3 = d3.h();
                                }
                                if (i) {
                                    break;
                                }
                            }
                            break;
                        }
                        o.g();
                        if (i) {
                            break;
                        }
                    }
                    this.u();
                    return;
                }
                break;
            } while (!i);
            n = this.d.length - 1;
            continue;
        }
    }
    
    private int a(final q q, final q q2) {
        return this.n.a(q) - this.n.a(q2);
    }
    
    private y.c.h q() {
        final boolean i = y.f.c.a.i;
        final y.c.h b = y.g.M.b(new q[this.b.h()]);
        final x o = this.b.o();
        while (o.f()) {
            final q e = o.e();
            e.c();
            int j = 0;
            int n = 0;
        Label_0135_Outer:
            while (j > n) {
                int n2 = 0;
                d d = e.f();
                while (true) {
                    while (d != null) {
                        final q d2 = d.d();
                        final int b2 = d2.b();
                        final int n3 = 1;
                        if (!i) {
                            if (b2 == n3 && d2.c() == 1 && (!this.G || this.I[d2.d()] == Integer.MIN_VALUE)) {
                                ++n2;
                            }
                            d = d.g();
                            if (i) {
                                break;
                            }
                            continue Label_0135_Outer;
                        }
                        else {
                            if (b2 <= n3) {
                                break Label_0135_Outer;
                            }
                            d d3 = e.f();
                            while (d3 != null) {
                                d f = d3;
                                q q = f.d();
                                j = q.b();
                                n = 1;
                                if (i) {
                                    continue Label_0135_Outer;
                                }
                                if (j == n && q.c() == 1) {
                                    while (q.b() == 1) {
                                        final int c = q.c();
                                        final boolean b3 = true;
                                        if (i) {
                                            continue Label_0135_Outer;
                                        }
                                        if (c != (b3 ? 1 : 0)) {
                                            break;
                                        }
                                        b.a(f, e);
                                        f = q.f();
                                        q = f.d();
                                        if (i) {
                                            break;
                                        }
                                    }
                                    b.a(f, e);
                                }
                                d3 = d3.g();
                                if (i) {
                                    break;
                                }
                            }
                            break Label_0135_Outer;
                        }
                    }
                    continue;
                }
            }
            o.g();
            if (i) {
                break;
            }
        }
        return b;
    }
    
    private y.c.h r() {
        final boolean i = y.f.c.a.i;
        final y.c.h b = y.g.M.b(new q[this.b.h()]);
        final x o = this.b.o();
        while (o.f()) {
            final q e = o.e();
            e.b();
            int j = 0;
            int n = 0;
        Label_0135_Outer:
            while (j > n) {
                int n2 = 0;
                d d = e.g();
                while (true) {
                    while (d != null) {
                        final q c = d.c();
                        final int b2 = c.b();
                        final int n3 = 1;
                        if (!i) {
                            if (b2 == n3 && c.c() == 1 && (!this.G || this.I[c.d()] == Integer.MIN_VALUE)) {
                                ++n2;
                            }
                            d = d.h();
                            if (i) {
                                break;
                            }
                            continue Label_0135_Outer;
                        }
                        else {
                            if (b2 <= n3) {
                                break Label_0135_Outer;
                            }
                            d d2 = e.g();
                            while (d2 != null) {
                                d g = d2;
                                q q = g.c();
                                j = q.b();
                                n = 1;
                                if (i) {
                                    continue Label_0135_Outer;
                                }
                                if (j == n && q.c() == 1) {
                                    while (q.b() == 1) {
                                        final int c2 = q.c();
                                        final boolean b3 = true;
                                        if (i) {
                                            continue Label_0135_Outer;
                                        }
                                        if (c2 != (b3 ? 1 : 0)) {
                                            break;
                                        }
                                        b.a(g, e);
                                        g = q.g();
                                        q = g.c();
                                        if (i) {
                                            break;
                                        }
                                    }
                                    b.a(g, e);
                                }
                                d2 = d2.h();
                                if (i) {
                                    break;
                                }
                            }
                            break Label_0135_Outer;
                        }
                    }
                    continue;
                }
            }
            o.g();
            if (i) {
                break;
            }
        }
        return b;
    }
    
    private int e(final boolean b) {
        final boolean i = y.f.c.a.i;
        Label_0063: {
            Label_0035: {
                if (b) {
                    int j = 1;
                    while (j < this.d.length) {
                        this.a(j);
                        ++j;
                        if (i) {
                            return this.f();
                        }
                        if (i) {
                            break Label_0035;
                        }
                    }
                    break Label_0063;
                }
            }
            int k = this.d.length - 2;
            while (k >= 0) {
                this.b(k);
                --k;
                if (i) {
                    return this.f();
                }
                if (i) {
                    break;
                }
            }
        }
        if (this.E) {
            this.v();
        }
        return this.f();
    }
    
    void a(final int n) {
        final boolean i = y.f.c.a.i;
        final y y = this.d[n - 1];
        final y y2 = this.d[n];
        final int size = y.size();
        final int size2 = y2.size();
        p p = y2.k();
        while (true) {
            while (p != null) {
                final q q = (q)p.c();
                final int d = q.d();
                final byte c = this.C;
                if (i) {
                    if (c != 0) {
                        this.b(y2, true, false);
                        this.a(y2, true, false);
                        this.b(y, false, true);
                    }
                    if (this.G) {
                        this.a(n, true, false);
                    }
                    return;
                }
                Label_0119: {
                    switch (c) {
                        case 0: {
                            this.q[d] = this.b(q, size2, false, size);
                            if (i) {
                                break Label_0119;
                            }
                            break;
                        }
                        case 1: {
                            this.q[d] = this.a(q, size2, false, size);
                            break;
                        }
                    }
                }
                final float[] q2 = this.q;
                final int n2 = d;
                q2[n2] += this.a[d] / (size * 200);
                p = p.a();
                if (i) {
                    break;
                }
            }
            this.a(y2, this.s);
            final boolean e = this.E;
            continue;
        }
    }
    
    void b(final int n) {
        final boolean i = y.f.c.a.i;
        final y y = this.d[n + 1];
        final y y2 = this.d[n];
        final int size = y.size();
        final int size2 = y2.size();
        p p = y2.k();
        while (true) {
            while (p != null) {
                final q q = (q)p.c();
                final int d = q.d();
                final byte c = this.C;
                if (i) {
                    if (c != 0) {
                        this.b(y2, false, true);
                        this.a(y2, false, true);
                        this.b(y, true, false);
                    }
                    if (this.G) {
                        this.a(n, false, true);
                    }
                    return;
                }
                Label_0119: {
                    switch (c) {
                        case 0: {
                            this.q[d] = this.b(q, size2, true, size);
                            if (i) {
                                break Label_0119;
                            }
                            break;
                        }
                        case 1: {
                            this.q[d] = this.a(q, size2, true, size);
                            break;
                        }
                    }
                }
                final float[] q2 = this.q;
                final int n2 = d;
                q2[n2] += this.a[d] / (size * 200);
                p = p.a();
                if (i) {
                    break;
                }
            }
            this.a(y2, this.s);
            final boolean e = this.E;
            continue;
        }
    }
    
    private float a(final q q, final int n, final boolean b, final int n2) {
        final boolean i = y.f.c.a.i;
        int n3 = 0;
        h h = null;
        Label_0328: {
            Label_0327: {
                Label_0171: {
                    if (b) {
                        d d = q.f();
                        while (d != null) {
                            float n4 = this.a[d.d().d()];
                            h = this;
                            if (i) {
                                break Label_0328;
                            }
                            if (this.f != null) {
                                final int b2;
                                Label_0122: {
                                    switch (this.f[b2 = d.b()]) {
                                        case 1: {
                                            n4 += 0.3f;
                                            if (i) {
                                                break Label_0122;
                                            }
                                            break;
                                        }
                                        case -1: {
                                            n4 -= 0.3f;
                                            if (i) {
                                                break Label_0122;
                                            }
                                            break;
                                        }
                                        case -2: {
                                            n4 -= 0.31f;
                                            break;
                                        }
                                    }
                                }
                                n4 += this.h[b2] * 0.01f;
                            }
                            this.r[n3] = n4;
                            d = d.g();
                            ++n3;
                            if (i) {
                                break Label_0171;
                            }
                        }
                        break Label_0327;
                    }
                }
                d d2 = q.g();
                while (d2 != null) {
                    float n5 = this.a[d2.c().d()];
                    h = this;
                    if (i) {
                        break Label_0328;
                    }
                    if (this.e != null) {
                        final int b3;
                        Label_0278: {
                            switch (this.e[b3 = d2.b()]) {
                                case 1: {
                                    n5 += 0.3f;
                                    if (i) {
                                        break Label_0278;
                                    }
                                    break;
                                }
                                case -1: {
                                    n5 -= 0.3f;
                                    if (i) {
                                        break Label_0278;
                                    }
                                    break;
                                }
                                case -2: {
                                    n5 -= 0.31f;
                                    break;
                                }
                            }
                        }
                        n5 += this.g[b3] * 0.01f;
                    }
                    this.r[n3] = n5;
                    d2 = d2.h();
                    ++n3;
                    if (i) {
                        break;
                    }
                }
            }
            h = this;
        }
        Arrays.sort(h.r, 0, n3);
        final int n6 = n3 >> 1;
        if (n3 == 0) {
            return (n2 - 1) * this.a[q.d()] / (n - 1);
        }
        if (n3 % 2 == 1) {
            return this.r[n6];
        }
        if (n3 == 2) {
            return (this.r[0] + this.r[1]) * 0.5f;
        }
        final float n7 = this.r[n6 - 1] - this.r[0];
        final float n8 = this.r[n3 - 1] - this.r[n6];
        if (n7 != 0.0f || n8 != 0.0f) {
            return (this.r[n6 - 1] * n8 + this.r[n6] * n7) / (n7 + n8);
        }
        return (this.r[n6 - 1] + this.r[n6]) * 0.5f;
    }
    
    private float b(final q q, final int n, final boolean b, final int n2) {
        final boolean i = y.f.c.a.i;
        float n3 = 0.0f;
        final int n4 = b ? q.c() : q.b();
        if (n4 == 0) {
            n3 = (n2 - 1) * this.a[q.d()] / (n - 1);
            if (!i) {
                return n3;
            }
        }
        Label_0211: {
            if (b) {
                d d = q.f();
                while (d != null) {
                    n3 += this.a[d.d().d()];
                    if (i) {
                        return n3;
                    }
                    if (this.f != null) {
                        final int b2;
                        Label_0174: {
                            switch (this.f[b2 = d.b()]) {
                                case 1: {
                                    n3 += 0.3f;
                                    if (i) {
                                        break Label_0174;
                                    }
                                    break;
                                }
                                case -1: {
                                    n3 -= 0.3f;
                                    if (i) {
                                        break Label_0174;
                                    }
                                    break;
                                }
                                case -2: {
                                    n3 -= 0.31f;
                                    break;
                                }
                            }
                        }
                        n3 += this.h[b2] * 0.01f;
                    }
                    d = d.g();
                    if (i) {
                        break Label_0211;
                    }
                }
                return n3 / n4;
            }
        }
        d d2 = q.g();
        while (d2 != null) {
            n3 += this.a[d2.c().d()];
            if (i) {
                return n3;
            }
            if (this.e != null) {
                final int b3;
                Label_0322: {
                    switch (this.e[b3 = d2.b()]) {
                        case 1: {
                            n3 += 0.3f;
                            if (i) {
                                break Label_0322;
                            }
                            break;
                        }
                        case -1: {
                            n3 -= 0.3f;
                            if (i) {
                                break Label_0322;
                            }
                            break;
                        }
                        case -2: {
                            n3 -= 0.31f;
                            break;
                        }
                    }
                }
                n3 += this.g[b3] * 0.01f;
            }
            d2 = d2.h();
            if (i) {
                break;
            }
        }
        n3 /= n4;
        return n3;
    }
    
    private void a(final int[] array) {
        System.arraycopy(this.a, 0, array, 0, array.length);
    }
    
    private void b(final int[] array) {
        System.arraycopy(array, 0, this.a, 0, array.length);
    }
    
    private int[] s() {
        final int[] array = new int[this.a.length];
        this.a(array);
        return array;
    }
    
    private void t() {
        final boolean i = y.f.c.a.i;
        int j = 0;
    Label_0069_Outer:
        while (j < this.d.length) {
            int n = 0;
            p p = this.d[j].k();
            while (true) {
                while (p != null) {
                    this.a[((q)p.c()).d()] = n;
                    p = p.a();
                    ++n;
                    if (!i) {
                        if (i) {
                            break;
                        }
                        continue Label_0069_Outer;
                    }
                    else {
                        if (i) {
                            break Label_0069_Outer;
                        }
                        continue Label_0069_Outer;
                    }
                }
                ++j;
                continue;
            }
        }
    }
    
    private void u() {
        final boolean i = y.f.c.a.i;
        int j = 0;
    Label_0120_Outer:
        while (j < this.d.length) {
            final y y = this.d[j];
            p p = y.k();
            while (p != null) {
                final q q = (q)p.c();
                this.p[this.a[q.d()]] = q;
                p = p.a();
                if (i) {
                    continue Label_0120_Outer;
                }
                if (i) {
                    break;
                }
            }
            int n = 0;
            p p2 = y.k();
            while (true) {
                while (p2 != null) {
                    p2.a(this.p[n]);
                    p2 = p2.a();
                    ++n;
                    if (!i) {
                        if (i) {
                            break;
                        }
                        continue Label_0120_Outer;
                    }
                    else {
                        if (i) {
                            break Label_0120_Outer;
                        }
                        continue Label_0120_Outer;
                    }
                }
                ++j;
                continue;
            }
        }
    }
    
    private void a(final D d, final Comparator comparator) {
        final boolean i = y.f.c.a.i;
        final C m = d.m();
        int j = 0;
        while (true) {
            while (j < d.size()) {
                this.p[j] = (q)m.d();
                ++j;
                m.g();
                if (i) {
                    p p2 = d.k();
                    while (p2 != null) {
                        p2.a(this.p[j]);
                        this.a[this.p[j].d()] = j;
                        p2 = p2.a();
                        ++j;
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
            y.g.e.a(this.p, 0, d.size(), comparator);
            j = 0;
            continue;
        }
    }
    
    private void v() {
        this.a(0, this.d.length - 1);
    }
    
    void a(final int n, final int n2) {
        final boolean i = y.f.c.a.i;
        Label_0118: {
            Label_0064: {
                if (n <= n2) {
                    int j = 1;
                    while (j != 0) {
                        j = 0;
                        int k = n;
                        while (k <= n2) {
                            final y y = this.d[k];
                            this.a(y);
                            j = (this.a(y, true, true) ? 1 : 0);
                            ++k;
                            if (i) {
                                break Label_0118;
                            }
                            if (i) {
                                break Label_0064;
                            }
                        }
                    }
                    return;
                }
            }
            int l = 1;
            while (l != 0) {
                l = 0;
                int n3 = n;
                while (n3 >= n2) {
                    final y y2 = this.d[n3];
                    this.a(y2);
                    l = (this.a(y2, true, true) ? 1 : 0);
                    --n3;
                    if (i || i) {
                        break Label_0118;
                    }
                }
            }
        }
    }
    
    private void a(final y y) {
        final boolean i = y.f.c.a.i;
        final x a = y.a();
        while (a.f()) {
            a.e().b(this.j);
            a.e().a(this.k);
            a.g();
            if (i) {
                break;
            }
        }
    }
    
    private void b(final y y, final boolean b, final boolean b2) {
        final boolean i = y.f.c.a.i;
        final x a = y.a();
        while (a.f()) {
            if (b2) {
                a.e().b(this.j);
            }
            if (b) {
                a.e().a(this.k);
            }
            a.g();
            if (i) {
                break;
            }
        }
    }
    
    boolean a(final y y, final boolean b, final boolean b2) {
        final boolean i = y.f.c.a.i;
        p p3 = y.k();
        int j = 0;
        while (true) {
            while (j < y.size() - 1) {
                final p p4 = p3;
                p3 = p4.a();
                final q q = (q)p4.c();
                final p p5 = p3;
                if (i) {
                    p b3 = p5;
                    int k = y.size() - 1;
                    boolean g = false;
                    while (k > 0) {
                        final p p6 = b3;
                        b3 = p6.b();
                        final q q2 = (q)b3.c();
                        final q q3 = (q)p6.c();
                        g = this.G;
                        if (i) {
                            return g;
                        }
                        Label_0635: {
                            if (g) {
                                final int n = this.I[q2.d()];
                                final int n2 = this.I[q3.d()];
                                if ((n != Integer.MIN_VALUE || n2 != Integer.MIN_VALUE) && n != n2) {
                                    break Label_0635;
                                }
                            }
                            int b4 = 0;
                            int b5 = 0;
                            if (b) {
                                b4 = this.b(q2, q2.g(), q3, q3.g());
                                b5 = this.b(q3, q3.g(), q2, q2.g());
                            }
                            if (b2) {
                                b4 += this.a(q2, q2.f(), q3, q3.f());
                                b5 += this.a(q3, q3.f(), q2, q2.f());
                            }
                            if (b4 > b5 || (b && b2 && b5 == b4)) {
                                if (b4 > b5) {}
                                final int n3 = this.a[q2.d()];
                                this.a[q2.d()] = this.a[q3.d()];
                                this.a[q3.d()] = n3;
                                p6.a(q2);
                                b3.a(q3);
                            }
                        }
                        --k;
                        if (i) {
                            break;
                        }
                    }
                    return g;
                }
                final q q4 = (q)p5.c();
                Label_0327: {
                    if (this.G) {
                        final int n4 = this.I[q.d()];
                        final int n5 = this.I[q4.d()];
                        if ((n4 != Integer.MIN_VALUE || n5 != Integer.MIN_VALUE) && n4 != n5) {
                            break Label_0327;
                        }
                    }
                    int b6 = 0;
                    int b7 = 0;
                    if (b) {
                        b6 = this.b(q, q.g(), q4, q4.g());
                        if (b2 || b6 > 0) {
                            b7 = this.b(q4, q4.g(), q, q.g());
                        }
                    }
                    if (b2) {
                        b6 += this.a(q, q.f(), q4, q4.f());
                        if (b || b6 > 0) {
                            b7 += this.a(q4, q4.f(), q, q.f());
                        }
                    }
                    if (b6 > b7 || (b && b2 && b7 == b6)) {
                        if (b6 > b7) {}
                        final int n6 = this.a[q.d()];
                        this.a[q.d()] = this.a[q4.d()];
                        this.a[q4.d()] = n6;
                        p3.a(q);
                        p4.a(q4);
                    }
                }
                ++j;
                if (i) {
                    break;
                }
            }
            y.l();
            continue;
        }
    }
    
    private void w() {
        final boolean i = y.f.c.a.i;
        int j = 0;
        while (j < this.d.length) {
            this.a(j, false, false);
            ++j;
            if (i) {
                break;
            }
        }
    }
    
    private void a(final int n, final boolean b, final boolean b2) {
        final boolean i = y.f.c.a.i;
        final int[] array = this.H[n];
        if (array == null) {
            return;
        }
        final y y = this.d[n];
        final D d = new D();
        final D d2 = new D();
        int n2 = 0;
    Label_1152:
        do {
            int j = 0;
        Label_0287_Outer:
            while (j < array.length) {
                final int n3 = array[n2];
                p p3 = null;
                p p4 = null;
                d.clear();
                d2.clear();
                for (p p5 = y.k(); p5 != null; p5 = p5.a()) {
                    j = (this.a(n3, (q)p5.c()) ? 1 : 0);
                    if (i) {
                        continue Label_0287_Outer;
                    }
                    if (j != 0) {
                        p4 = (p3 = p5);
                        for (p p6 = p5.a(); p6 != null; p6 = p6.a()) {
                            final boolean a = this.a(n3, (q)p6.c());
                            if (i) {
                                continue Label_0287_Outer;
                            }
                            if (a) {
                                p4 = p6;
                            }
                        }
                        break;
                    }
                }
                Label_1149: {
                    if (p3 != p4) {
                        final p p7 = p3;
                        d.a((Object)p7);
                        p p8 = p7.a();
                        while (true) {
                            int a2;
                            p[] array2;
                            int[] array3;
                            int a3;
                            boolean b3;
                            int k = 0;
                            int n4;
                            boolean b4;
                            boolean b5;
                            int n5;
                            int n6;
                            int n7;
                            int n8;
                            boolean b6 = false;
                            int n9;
                            int a4;
                            boolean b7;
                            int n10;
                            int l;
                            int a5 = 0;
                            int a6;
                            boolean b8;
                            int n11;
                            int n12;
                            int a7 = 0;
                            int n13;
                            Label_0906_Outer:Label_1100_Outer:
                            while (p8 != p4) {
                                a2 = (this.a(n3, (q)p8.c()) ? 1 : 0);
                                if (!i) {
                                    Label_0262: {
                                        if (a2 != 0) {
                                            d.b((Object)p8);
                                            if (!i) {
                                                break Label_0262;
                                            }
                                        }
                                        d2.b((Object)p8);
                                    }
                                    p8 = p8.a();
                                    if (i) {
                                        break;
                                    }
                                    continue Label_0287_Outer;
                                }
                                else {
                                    if (a2 > 0) {
                                        array2 = new p[d2.size()];
                                        d2.toArray(array2);
                                        array3 = new int[array2.length];
                                        Arrays.fill(array3, Integer.MAX_VALUE);
                                        b3 = ((a3 = this.a(n3, y, d, array2[array2.length - 1], b, b2)) < 0);
                                        array3[array2.length - 1] = a3;
                                        Label_1047: {
                                            if (array2.length == 1) {
                                                k = (b3 ? 0 : 1);
                                                if (!i) {
                                                    break Label_1047;
                                                }
                                            }
                                            if (b3) {
                                                k = array2.length;
                                                if (!i) {
                                                    break Label_1047;
                                                }
                                            }
                                            b4 = ((n4 = this.a(n3, y, d, array2[0], b, b2)) < 0);
                                            array3[0] = n4;
                                            b5 = (array3[0] == 0 && array3[array2.length - 1] == 0);
                                            if (!b4 && !b5) {
                                                k = 0;
                                                if (!i) {
                                                    break Label_1047;
                                                }
                                            }
                                            Label_0628: {
                                                if (b5) {
                                                    k = array2.length / 2;
                                                    if (!i) {
                                                        break Label_0628;
                                                    }
                                                }
                                                n5 = array2.length - 1;
                                                n6 = 0;
                                                while (true) {
                                                    while (n5 - n6 > 1) {
                                                        n7 = n6 + (n5 - n6) / 2;
                                                        n4 = this.a(n3, y, d, array2[n7], b, b2);
                                                        array3[n7] = n4;
                                                        n8 = n4;
                                                        if (i) {
                                                            k = n8;
                                                            break Label_0628;
                                                        }
                                                        Label_0601: {
                                                            if (n8 == 0) {
                                                                b6 = (n7 < array2.length / 2);
                                                                if (!i) {
                                                                    break Label_0601;
                                                                }
                                                            }
                                                            b6 = (n4 < 0);
                                                        }
                                                        if (b6) {
                                                            n6 = n7;
                                                            if (!i) {
                                                                continue Label_0287_Outer;
                                                            }
                                                        }
                                                        n5 = n7;
                                                        if (i) {
                                                            break;
                                                        }
                                                    }
                                                    continue Label_1100_Outer;
                                                }
                                            }
                                            n9 = this.I[((q)array2[k].c()).d()];
                                            if (n9 != Integer.MIN_VALUE && n9 < n3) {
                                                Label_0858: {
                                                    if (n4 > 0) {
                                                        while (true) {
                                                            while (k > 0) {
                                                                b7 = ((a4 = (this.a(n9, (q)array2[k - 1].c()) ? 1 : 0)) != 0);
                                                                if (!i) {
                                                                    if (!b7) {
                                                                        break;
                                                                    }
                                                                    --k;
                                                                    if (i) {
                                                                        break;
                                                                    }
                                                                    continue Label_0287_Outer;
                                                                }
                                                                else {
                                                                    if (a4 == Integer.MAX_VALUE) {
                                                                        array3[k] = this.a(n3, y, d, array2[k], b, b2);
                                                                    }
                                                                    if (array3[k] >= 0) {
                                                                        break Label_1047;
                                                                    }
                                                                    n10 = 0;
                                                                    l = k;
                                                                    Label_0846: {
                                                                        while (l < array2.length) {
                                                                            a5 = (this.a(n9, (q)array2[l].c()) ? 1 : 0);
                                                                            if (i || a5 == 0) {
                                                                                break Label_0846;
                                                                            }
                                                                            if (array3[l] == Integer.MAX_VALUE) {
                                                                                array3[l] = this.a(n3, y, d, array2[l], b, b2);
                                                                            }
                                                                            n10 += array3[l];
                                                                            ++l;
                                                                            if (i) {
                                                                                goto Label_0844;
                                                                            }
                                                                        }
                                                                        goto Label_0844;
                                                                    }
                                                                    if (a5 >= 0) {
                                                                        break Label_1047;
                                                                    }
                                                                    k = l;
                                                                    if (i) {
                                                                        break Label_0858;
                                                                    }
                                                                    break Label_1047;
                                                                }
                                                            }
                                                            a4 = array3[k];
                                                            continue Label_0906_Outer;
                                                        }
                                                    }
                                                }
                                                while (true) {
                                                    while (k < array2.length) {
                                                        b8 = ((a6 = (this.a(n9, (q)array2[k].c()) ? 1 : 0)) != 0);
                                                        if (!i) {
                                                            if (!b8) {
                                                                break;
                                                            }
                                                            ++k;
                                                            if (i) {
                                                                break;
                                                            }
                                                            continue Label_0287_Outer;
                                                        }
                                                        else {
                                                            if (a6 == Integer.MAX_VALUE) {
                                                                array3[k - 1] = this.a(n3, y, d, array2[k], b, b2);
                                                            }
                                                            if (array3[k - 1] < 0) {
                                                                break Label_1047;
                                                            }
                                                            n11 = 0;
                                                            n12 = k - 1;
                                                            Label_1038: {
                                                                while (n12 >= 0) {
                                                                    a7 = (this.a(n9, (q)array2[n12].c()) ? 1 : 0);
                                                                    if (i || a7 == 0) {
                                                                        break Label_1038;
                                                                    }
                                                                    if (array3[n12] == Integer.MAX_VALUE) {
                                                                        array3[n12] = this.a(n3, y, d, array2[n12], b, b2);
                                                                    }
                                                                    n11 += array3[n12];
                                                                    --n12;
                                                                    if (i) {
                                                                        goto Label_1036;
                                                                    }
                                                                }
                                                                goto Label_1036;
                                                            }
                                                            if (a7 > 0) {
                                                                k = n12 + 1;
                                                            }
                                                            break Label_1047;
                                                        }
                                                    }
                                                    a6 = array3[k - 1];
                                                    continue Label_1100_Outer;
                                                }
                                            }
                                        }
                                        n13 = 0;
                                        while (true) {
                                            while (n13 < k) {
                                                y.h(array2[n13]);
                                                y.a(array2[n13], p3);
                                                ++n13;
                                                if (i) {
                                                    while (n13 >= k) {
                                                        y.h(array2[n13]);
                                                        y.b(array2[n13], p4);
                                                        --n13;
                                                        if (i) {
                                                            continue Label_1152;
                                                        }
                                                        if (i) {
                                                            break;
                                                        }
                                                    }
                                                    this.a((D)y);
                                                    break Label_1149;
                                                }
                                                if (i) {
                                                    break;
                                                }
                                            }
                                            n13 = array2.length - 1;
                                            continue;
                                        }
                                    }
                                    break Label_1149;
                                }
                            }
                            d.b((Object)p8);
                            d2.size();
                            continue;
                        }
                    }
                }
                ++n2;
            }
            break;
        } while (!i);
    }
    
    private int a(final int n, final D d, final D d2, final p p6, final boolean b, final boolean b2) {
        final boolean i = y.f.c.a.i;
        if (!b && !b2) {
            return 0;
        }
        int n2 = 0;
        int n3 = 0;
        final q q = (q)p6.c();
        p6.b();
        final p a = p6.a();
        final int n4 = this.a[((q)p6.c()).d()] + 1;
        d.h(p6);
        d.a(p6, (p)d2.f());
        this.a(d);
        this.a(q, b, b2);
        p p7 = d2.k();
        while (this.a[((q)((p)p7.c()).c()).d()] < n4) {
            final q q2 = (q)((p)p7.c()).c();
            final int n5;
            final boolean b3 = (n5 = (this.a(n, q2) ? 1 : 0)) != 0;
            if (i) {
                return n5;
            }
            if (b3) {
                if (b) {
                    n2 += this.b(q, q.g(), q2, q2.g());
                }
                if (b2) {
                    n2 += this.a(q, q.f(), q2, q2.f());
                }
            }
            p7 = p7.a();
            if (i) {
                break;
            }
        }
        d.h(p6);
        d.b(p6, (p)d2.i());
        this.a(d);
        this.a(q, b, b2);
        while (p7 != null) {
            final q q3 = (q)((p)p7.c()).c();
            final int n5;
            final boolean b4 = (n5 = (this.a(n, q3) ? 1 : 0)) != 0;
            if (i) {
                return n5;
            }
            if (b4) {
                if (b) {
                    n3 += this.b(q3, q3.g(), q, q.g());
                }
                if (b2) {
                    n3 += this.a(q3, q3.f(), q, q.f());
                }
            }
            p7 = p7.a();
            if (i) {
                break;
            }
        }
        d.h(p6);
        d.a(p6, a);
        this.a(d);
        this.a(q, b, b2);
        return n2 - n3;
    }
    
    private void a(final q q, final boolean b, final boolean b2) {
        final boolean i = y.f.c.a.i;
        if (b) {
            final y.c.e k = q.k();
            while (k.f()) {
                k.a().c().b(this.j);
                k.g();
                if (i) {
                    return;
                }
                if (i) {
                    break;
                }
            }
        }
        if (b2) {
            final y.c.e l = q.l();
            while (l.f()) {
                l.a().d().a(this.k);
                l.g();
                if (i) {
                    break;
                }
            }
        }
    }
    
    private void a(final D d) {
        final boolean i = y.f.c.a.i;
        int n = 0;
        p p = d.k();
        while (p != null) {
            this.a[((q)p.c()).d()] = n++;
            p = p.a();
            if (i) {
                break;
            }
        }
    }
    
    private boolean a(final int n, final q q) {
        return n != Integer.MIN_VALUE && this.I[q.d()] == n;
    }
    
    private Object a(final q q) {
        final c c = this.b.c(y.f.c.h.i);
        if (c != null) {
            return c.b(q);
        }
        return null;
    }
    
    private int a(final q q, d d, final q q2, d g) {
        final boolean i = y.f.c.a.i;
        int n = 0;
        int n2 = 0;
        int n9 = 0;
        while (d != null && g != null) {
            final int n3 = this.a[d.d().d()];
            final int n4 = this.a[g.d().d()];
            Label_0150: {
                if (this.f != null && n3 == n4) {
                    final int b;
                    final int n5 = this.f[b = d.b()];
                    final int b2;
                    final int n6;
                    if (n5 > (n6 = this.f[b2 = g.b()])) {
                        ++n2;
                        if (!i) {
                            break Label_0150;
                        }
                    }
                    if (n5 == n6) {
                        final int n7 = this.h[b];
                        final int n8 = this.h[b2];
                        if (n7 != 0 && n8 != 0 && n7 > n8) {
                            ++n2;
                        }
                    }
                }
            }
            if (n3 <= n4) {
                n2 += n;
                d = d.g();
                if (!i) {
                    continue;
                }
            }
            if (n3 >= n4) {
                ++n;
                g = g.g();
                if (i) {
                    return n9;
                }
                if (i) {
                    break;
                }
                continue;
            }
        }
        while (d != null) {
            n9 = n2 + n;
            if (i) {
                break;
            }
            n2 = n9;
            d = d.g();
            if (i) {
                break;
            }
        }
        return n9;
    }
    
    private int b(final q q, d d, final q q2, d h) {
        final boolean i = y.f.c.a.i;
        int n = 0;
        int n2 = 0;
        int n9 = 0;
        while (d != null && h != null) {
            final int n3 = this.a[d.c().d()];
            final int n4 = this.a[h.c().d()];
            Label_0150: {
                if (this.e != null && n3 == n4) {
                    final int b;
                    final int n5 = this.e[b = d.b()];
                    final int b2;
                    final int n6;
                    if (n5 > (n6 = this.e[b2 = h.b()])) {
                        ++n2;
                        if (!i) {
                            break Label_0150;
                        }
                    }
                    if (n5 == n6) {
                        final int n7 = this.g[b];
                        final int n8 = this.g[b2];
                        if (n7 != 0 && n8 != 0 && n7 > n8) {
                            ++n2;
                        }
                    }
                }
            }
            if (n3 <= n4) {
                n2 += n;
                d = d.h();
                if (!i) {
                    continue;
                }
            }
            if (n3 >= n4) {
                ++n;
                h = h.h();
                if (i) {
                    return n9;
                }
                if (i) {
                    break;
                }
                continue;
            }
        }
        while (d != null) {
            n9 = n2 + n;
            if (i) {
                break;
            }
            n2 = n9;
            d = d.h();
            if (i) {
                break;
            }
        }
        return n9;
    }
    
    public boolean h() {
        return this.G;
    }
    
    public void d(final boolean g) {
        this.G = g;
    }
    
    public long i() {
        return this.w;
    }
    
    static float[] a(final h h) {
        return h.q;
    }
    
    static A b(final h h) {
        return h.n;
    }
    
    static {
        i = "y.layout.hierarchic.ClassicLayerSequencer.GROUP_KEY";
    }
}
