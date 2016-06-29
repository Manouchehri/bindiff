package y.f.c.a;

import y.f.*;
import java.util.*;
import y.c.*;
import y.a.*;
import y.g.*;

class bT implements bx
{
    private int e;
    private boolean f;
    private Comparator g;
    private long h;
    private byte i;
    private float[] j;
    private float[] k;
    private q[] l;
    private int[] m;
    private int[] n;
    private p[] o;
    private D p;
    private D q;
    private D r;
    private D s;
    private byte[] t;
    private byte[] u;
    private int[] v;
    private int[] w;
    private Comparator x;
    private Comparator y;
    private Comparator z;
    private Comparator A;
    private Comparator B;
    private Comparator C;
    private X D;
    private D[] E;
    private int[] F;
    private int[] G;
    private q[][] H;
    private q[][] I;
    private int J;
    private int K;
    private int L;
    int[] a;
    int[] b;
    Comparator c;
    private bR M;
    private Comparator N;
    private E O;
    final int[] d;
    
    bT() {
        this.e = 250;
        this.f = true;
        this.h = 10000L;
        this.i = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.d = new int[4];
    }
    
    void a(final Map map) {
        final Number value = map.get("SubgraphLayerSequencer.weightHeuristic");
        if (value instanceof Number) {
            this.a(value.byteValue());
        }
        final Number value2 = map.get("SubgraphLayerSequencer.maximalDuration");
        if (value2 instanceof Number) {
            this.a(value2.longValue());
        }
        final Number value3 = map.get("SubgraphLayerSequencer.transpositionEnabled");
        if (value3 instanceof Boolean) {
            this.a((boolean)value3);
        }
        final Number value4 = map.get("SubgraphLayerSequencer.randomizationRounds");
        if (value4 instanceof Number) {
            this.a(value4.intValue());
        }
    }
    
    public void a(final boolean f) {
        this.f = f;
    }
    
    public void a(final byte i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException();
        }
        this.i = i;
    }
    
    public void a(final int e) {
        this.e = e;
    }
    
    public void a(final long h) {
        this.h = h;
    }
    
    private cF a(final X x, final aU au, final aV av, final int[] array, final int[] array2) {
        Arrays.fill(this.t = new byte[x.h()], (byte)(-2));
        this.v = new int[x.h()];
        Arrays.fill(this.u = new byte[x.h()], (byte)(-2));
        this.w = new int[x.h()];
        return cF.a(x, au, av, array2, array, this.t, this.v, this.u, this.w, (byte)1, (byte)0);
    }
    
    private void a(final i i, final ar ar) {
        final boolean x = y.f.c.a.N.x;
        final x o = i.o();
        while (o.f()) {
            this.j[o.e().d()] = ar.nextInt();
            o.g();
            if (x) {
                return;
            }
            if (x) {
                break;
            }
        }
        i.a(new bU(this), new bV(this));
    }
    
    private int a() {
        final boolean x = y.f.c.a.N.x;
        this.a(this.D, this.B, this.C);
        int n = 0;
        int i = this.E.length - 1;
        int l = 0;
        while (i > 0) {
            l = this.L;
            if (x) {
                return l;
            }
            if (l == 0 || this.H[i] != null || this.H[i - 1] != null) {
                n += this.a(this.E[i - 1], this.E[i]);
            }
            --i;
            if (x) {
                break;
            }
        }
        return l;
    }
    
    private int a(final D d, final D d2) {
        final boolean x = y.f.c.a.N.x;
        p p2 = d.k();
        p p3 = d2.k();
        this.p.clear();
        this.q.clear();
        this.r.clear();
        this.s.clear();
        int n = 0;
        p p4 = null;
        Label_0136: {
            while (p2 != null) {
                p4 = p3;
                if (x || p4 == null) {
                    break Label_0136;
                }
                n = n + this.a((q)p2.c(), this.p, this.r, this.q) + this.b((q)p3.c(), this.q, this.s, this.p);
                p2 = p2.a();
                p3 = p3.a();
                if (x) {
                    goto Label_0135;
                }
            }
            goto Label_0135;
        }
        int n2 = 0;
        if (p4 != null) {
            n += this.a((q)p2.c(), this.p, this.r, this.q);
            p2 = p2.a();
            if (x) {
                return n2;
            }
            if (!x) {
                goto Label_0135;
            }
        }
        while (p3 != null) {
            n2 = n + this.b((q)p3.c(), this.q, this.s, this.p);
            if (x) {
                break;
            }
            n = n2;
            p3 = p3.a();
            if (x) {
                break;
            }
        }
        return n2;
    }
    
    private int a(final q q, final D d, final D d2, final D d3) {
        final boolean x = y.f.c.a.N.x;
        final int n = this.G[q.d()];
        final int[] d4 = this.d;
        final int n2 = 0;
        final int[] d5 = this.d;
        final int n3 = 1;
        final int[] d6 = this.d;
        final int n4 = 2;
        final int[] d7 = this.d;
        final int n5 = 3;
        final int n6 = 0;
        d6[n4] = (d7[n5] = n6);
        d4[n2] = (d5[n3] = n6);
        int n7 = n6;
        d d8 = q.f();
        int b;
        p p4;
        d d9;
        p p5;
        int[] d10;
        byte b2;
        p p6;
        p p7;
        byte b3;
        p p8;
        d d11;
        int n8;
        int n9;
        int n10;
        Label_0335_Outer:Label_0442_Outer:
        while (d8 != null) {
            p4 = this.o[b = d8.b()];
            Label_0522: {
                Label_0515: {
                    if (p4.c() == null) {
                        Label_0173: {
                            if (this.F[d8.d().d()] < 0) {
                                d9 = ((d8.h() == null) ? d8.j() : d8.h());
                                p5 = this.o[d9.b()];
                                d2.a(p5);
                                p5.a(d9);
                                if (!x) {
                                    break Label_0173;
                                }
                            }
                            n7 += d2.size();
                            d3.a(p4);
                            p4.a(d8);
                        }
                        d10 = this.d;
                        b2 = (byte)(this.t[b] + 2);
                        ++d10[b2];
                        if (!x) {
                            break Label_0515;
                        }
                    }
                    Label_0257: {
                        if (this.F[d8.d().d()] < 0) {
                            d2.h(p4);
                            p4.a(null);
                            p6 = p4.a();
                            while (p6 != null) {
                                ++n7;
                                p6 = p6.a();
                                if (x) {
                                    break Label_0522;
                                }
                                if (x) {
                                    break Label_0257;
                                }
                            }
                            break Label_0515;
                        }
                    }
                    d.h(p4);
                    p4.a(null);
                    Label_0340: {
                        if (this.v[b] > 0) {
                            p7 = p4.b();
                            while (true) {
                                while (p7 != null) {
                                    ++n7;
                                    p7 = p7.b();
                                    if (!x) {
                                        if (x) {
                                            break;
                                        }
                                        continue Label_0335_Outer;
                                    }
                                    else {
                                        if (x) {
                                            break Label_0340;
                                        }
                                        break Label_0515;
                                    }
                                }
                                n7 = n7 + d3.size() + d2.size();
                                continue Label_0442_Outer;
                            }
                        }
                    }
                    b3 = this.t[b];
                    p8 = p4.b();
                    while (true) {
                        while (p8 != null) {
                            n8 = this.G[(d11 = (d)p8.c()).c().d()];
                            n9 = n;
                            if (!x) {
                                if (n8 > n9 || (b3 != -2 && this.t[d11.b()] > b3)) {
                                    ++n7;
                                }
                                p8 = p8.b();
                                if (x) {
                                    break;
                                }
                                continue Label_0442_Outer;
                            }
                            else {
                                n7 = n8 + n9;
                                Label_0504: {
                                    switch (b3) {
                                        case -1: {
                                            n7 -= this.d[1];
                                            if (x) {
                                                break Label_0504;
                                            }
                                            break Label_0515;
                                        }
                                        case 0: {
                                            n7 -= this.d[2];
                                            if (x) {
                                                break Label_0504;
                                            }
                                            break Label_0515;
                                        }
                                        case 1: {
                                            n7 -= this.d[3];
                                        }
                                        default: {
                                            break Label_0515;
                                        }
                                    }
                                }
                            }
                        }
                        n10 = d3.size() + d2.size();
                        continue;
                    }
                }
                d8 = d8.g();
            }
            if (x) {
                break;
            }
        }
        return n7;
    }
    
    private int b(final q q, final D d, final D d2, final D d3) {
        final boolean x = y.f.c.a.N.x;
        final int n = this.G[q.d()];
        final int[] d4 = this.d;
        final int n2 = 0;
        final int[] d5 = this.d;
        final int n3 = 1;
        final int[] d6 = this.d;
        final int n4 = 2;
        final int[] d7 = this.d;
        final int n5 = 3;
        final int n6 = 0;
        d6[n4] = (d7[n5] = n6);
        d4[n2] = (d5[n3] = n6);
        int n7 = n6;
        d d8 = q.g();
        int b;
        p p4;
        d d9;
        p p5;
        int[] d10;
        byte b2;
        p p6;
        p p7;
        byte b3;
        p p8;
        d d11;
        int n8;
        int n9;
        int n10;
        Label_0331_Outer:Label_0438_Outer:
        while (d8 != null) {
            p4 = this.o[b = d8.b()];
            Label_0518: {
                Label_0511: {
                    if (p4.c() == null) {
                        Label_0173: {
                            if (this.F[d8.c().d()] < 0) {
                                d9 = ((d8.g() == null) ? d8.i() : d8.g());
                                p5 = this.o[d9.b()];
                                d2.a(p5);
                                p5.a(d9);
                                if (!x) {
                                    break Label_0173;
                                }
                            }
                            n7 += d2.size();
                            d3.a(p4);
                            p4.a(d8);
                        }
                        d10 = this.d;
                        b2 = (byte)(this.u[b] + 2);
                        ++d10[b2];
                        if (!x) {
                            break Label_0511;
                        }
                    }
                    Label_0257: {
                        if (this.F[d8.c().d()] < 0) {
                            d2.h(p4);
                            p4.a(null);
                            p6 = p4.a();
                            while (p6 != null) {
                                ++n7;
                                p6 = p6.a();
                                if (x) {
                                    break Label_0518;
                                }
                                if (x) {
                                    break Label_0257;
                                }
                            }
                            break Label_0511;
                        }
                    }
                    d.h(p4);
                    p4.a(null);
                    Label_0336: {
                        if (this.w[b] > 0) {
                            p7 = p4.b();
                            while (true) {
                                while (p7 != null) {
                                    ++n7;
                                    p7 = p7.b();
                                    if (!x) {
                                        if (x) {
                                            break;
                                        }
                                        continue Label_0331_Outer;
                                    }
                                    else {
                                        if (x) {
                                            break Label_0336;
                                        }
                                        break Label_0511;
                                    }
                                }
                                n7 += d3.size() + d2.size();
                                continue Label_0438_Outer;
                            }
                        }
                    }
                    b3 = this.u[b];
                    p8 = p4.b();
                    while (true) {
                        while (p8 != null) {
                            n8 = this.G[(d11 = (d)p8.c()).d().d()];
                            n9 = n;
                            if (!x) {
                                if (n8 > n9 || (b3 != -2 && this.u[d11.b()] > b3)) {
                                    ++n7;
                                }
                                p8 = p8.b();
                                if (x) {
                                    break;
                                }
                                continue Label_0438_Outer;
                            }
                            else {
                                n7 = n8 + n9;
                                Label_0500: {
                                    switch (b3) {
                                        case -1: {
                                            n7 -= this.d[1];
                                            if (x) {
                                                break Label_0500;
                                            }
                                            break Label_0511;
                                        }
                                        case 0: {
                                            n7 -= this.d[2];
                                            if (x) {
                                                break Label_0500;
                                            }
                                            break Label_0511;
                                        }
                                        case 1: {
                                            n7 -= this.d[3];
                                        }
                                        default: {
                                            break Label_0511;
                                        }
                                    }
                                }
                            }
                        }
                        n10 = d3.size() + d2.size();
                        continue;
                    }
                }
                d8 = d8.h();
            }
            if (x) {
                break;
            }
        }
        return n7;
    }
    
    private byte a(final int[] array) {
        return this.a(0, this.E.length - 1, array);
    }
    
    private byte a(final int n, final int n2, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        byte b = 0;
        Label_0121: {
            if (n <= n2) {
                int n3 = 1;
                int n4 = 20;
                while (n3 != 0 && --n4 > 0) {
                    n3 = 0;
                    int i = n;
                    while (i <= n2) {
                        if (this.H[i] != null) {
                            final D d = this.E[i];
                            this.a(d, this.A, this.z);
                            final byte a = this.a(i, d, true, true, array);
                            n3 = (((a & 0x4) != 0x0) ? 1 : 0);
                            b |= a;
                        }
                        ++i;
                        if (x) {
                            break Label_0121;
                        }
                    }
                }
                return b;
            }
        }
        int n5 = 1;
        int n6 = 20;
    Label_0229:
        while (n5 != 0 && --n6 > 0) {
            n5 = 0;
            int j = n;
            while (j >= n2) {
                if (this.H[j] != null) {
                    final D d2 = this.E[j];
                    this.a(d2, this.A, this.z);
                    final byte a2 = this.a(j, d2, true, true, array);
                    n5 = (((a2 & 0x4) != 0x0) ? 1 : 0);
                    b |= a2;
                }
                --j;
                if (x) {
                    break Label_0229;
                }
            }
        }
        return b;
    }
    
    private byte a(final int n, final D d, final boolean b, final boolean b2, final int[] array) {
        if (this.L > 0 && this.H[n] == null) {
            return 0;
        }
        return (byte)(this.a(d, b, b2, array) | this.b(d, b, b2, array));
    }
    
    private byte a(final D d, final boolean b, final boolean b2, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        boolean b3 = false;
        boolean b4 = false;
        p p4 = d.k();
        int i = 0;
        int l = 0;
        while (i < d.size() - 1) {
            final p p5 = p4;
            p4 = p5.a();
            final q q = (q)p5.c();
            final q q2 = (q)p4.c();
            l = this.L;
            if (x) {
                return (byte)(((l != 0) ? 4 : 0) | (b4 ? 2 : 0) | (b3 ? 1 : 0));
            }
            Label_0650: {
                if (l <= 0 || this.a(q) || this.a(q2)) {
                    if (this.M != null) {
                        if (this.M.a(this.D, q, q2)) {
                            break Label_0650;
                        }
                    }
                    else if (this.a != null) {
                        final int n = this.a[q.d()];
                        final int n2 = this.a[q2.d()];
                        if (n >= 0 && n2 >= 0 && n != n2) {
                            break Label_0650;
                        }
                    }
                    int d2 = 0;
                    int d3 = 0;
                    if (b) {
                        d2 = this.d(q, q2, array);
                        if (b2 || d2 > 0) {
                            d3 = this.d(q2, q, array);
                        }
                    }
                    if (b2) {
                        d2 += this.c(q, q2, array);
                        if (b || d2 > 0) {
                            d3 += this.c(q2, q, array);
                        }
                    }
                    if (d2 >= d3) {
                        if (d2 > d3) {
                            final int n3 = array[q.d()];
                            array[q.d()] = array[q2.d()];
                            array[q2.d()] = n3;
                            p4.a(q);
                            p5.a(q2);
                            b3 |= (q.c() > 0 || q2.c() > 0);
                            b4 |= (q.b() > 0 || q2.b() > 0);
                            this.a(q, b ? this.A : null, b2 ? this.z : null, true);
                            this.a(q2, b ? this.A : null, b2 ? this.z : null, false);
                            if (!x) {
                                break Label_0650;
                            }
                        }
                        if (this.a(q2, q, true, true, array) < this.a(q, q2, true, true, array)) {
                            final int n4 = array[q.d()];
                            array[q.d()] = array[q2.d()];
                            array[q2.d()] = n4;
                            p4.a(q);
                            p5.a(q2);
                            b3 |= (q.c() > 0 || q2.c() > 0);
                            b4 |= (q.b() > 0 || q2.b() > 0);
                            this.a(q, b ? this.A : null, b2 ? this.z : null, true);
                            this.a(q2, b ? this.A : null, b2 ? this.z : null, false);
                        }
                    }
                }
            }
            ++i;
            if (x) {
                break;
            }
        }
        return (byte)(((l != 0) ? 4 : 0) | (b4 ? 2 : 0) | (b3 ? 1 : 0));
    }
    
    private byte b(final D d, final boolean b, final boolean b2, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        boolean b3 = false;
        boolean b4 = false;
        p p4 = d.l();
        int i = d.size() - 2;
        int l = 0;
        while (i >= 0) {
            final p p5 = p4;
            p4 = p4.b();
            final q q = (q)p4.c();
            final q q2 = (q)p5.c();
            l = this.L;
            if (x) {
                return (byte)(((l != 0) ? 4 : 0) | (b4 ? 2 : 0) | (b3 ? 1 : 0));
            }
            Label_0664: {
                if (l <= 0 || this.a(q) || this.a(q2)) {
                    if (this.M != null) {
                        if (this.M.a(this.D, q, q2)) {
                            break Label_0664;
                        }
                    }
                    else if (this.a != null) {
                        final int n = this.a[q.d()];
                        final int n2 = this.a[q2.d()];
                        if (n >= 0 && n2 >= 0 && n != n2) {
                            break Label_0664;
                        }
                    }
                    int d2 = 0;
                    int d3 = 0;
                    if (b) {
                        d2 = this.d(q, q2, array);
                        if (b2 || d2 > 0) {
                            d3 = this.d(q2, q, array);
                        }
                    }
                    if (b2) {
                        d2 += this.c(q, q2, array);
                        if (b || d2 > 0) {
                            d3 += this.c(q2, q, array);
                        }
                    }
                    if (d2 >= d3) {
                        if (d2 > d3) {
                            final int n3 = array[q.d()];
                            array[q.d()] = array[q2.d()];
                            array[q2.d()] = n3;
                            p5.a(q);
                            p4.a(q2);
                            b3 |= (q.c() > 0 || q2.c() > 0);
                            b4 |= (q.b() > 0 || q2.b() > 0);
                            this.a(q, b ? this.A : null, b2 ? this.z : null, true);
                            this.a(q2, b ? this.A : null, b2 ? this.z : null, false);
                            if (!x) {
                                break Label_0664;
                            }
                        }
                        final int a = this.a(q, q2, true, true, array);
                        final int a2 = this.a(q2, q, true, true, array);
                        if (a2 < a || (a2 == a && b && b2)) {
                            final int n4 = array[q.d()];
                            array[q.d()] = array[q2.d()];
                            array[q2.d()] = n4;
                            p5.a(q);
                            p4.a(q2);
                            b3 |= (q.c() > 0 || q2.c() > 0);
                            b4 |= (q.b() > 0 || q2.b() > 0);
                            this.a(q, b ? this.A : null, b2 ? this.z : null, true);
                            this.a(q2, b ? this.A : null, b2 ? this.z : null, false);
                        }
                    }
                }
            }
            --i;
            if (x) {
                break;
            }
        }
        return (byte)(((l != 0) ? 4 : 0) | (b4 ? 2 : 0) | (b3 ? 1 : 0));
    }
    
    private void a(final q q, final Comparator comparator, final Comparator comparator2, final boolean b) {
        final boolean x = y.f.c.a.N.x;
        Label_0209: {
            if (b) {
                d d = null;
                d g = null;
                Label_0134: {
                    if (comparator != null && q.b() > 1) {
                        d = q.g();
                        d d2 = q.i();
                        while (comparator.compare(d, d2) > 0) {
                            g = d2.g();
                            if (x) {
                                break Label_0134;
                            }
                            Label_0101: {
                                if (g != null) {
                                    this.D.a(d2, d2.g(), d, 1, 1);
                                    if (!x) {
                                        break Label_0101;
                                    }
                                }
                                this.D.a(d2, d2.i(), d, 0, 1);
                            }
                            d2 = q.i();
                            if (x) {
                                break;
                            }
                        }
                    }
                    if (comparator2 == null || q.c() <= 1) {
                        return;
                    }
                    d = q.f();
                    q.h();
                }
                d h = g;
                while (comparator2.compare(d, h) > 0) {
                    Label_0198: {
                        if (h.h() != null) {
                            this.D.a(h, d, h.h(), 1, 1);
                            if (!x) {
                                break Label_0198;
                            }
                        }
                        this.D.a(h, d, h.j(), 1, 0);
                    }
                    h = q.h();
                    if (x) {
                        break Label_0209;
                    }
                }
                return;
            }
        }
        d d3 = null;
        d g2 = null;
        Label_0333: {
            if (comparator != null && q.b() > 1) {
                d3 = q.i();
                d d4 = q.g();
                while (comparator.compare(d4, d3) > 0) {
                    g2 = d4.g();
                    if (x) {
                        break Label_0333;
                    }
                    Label_0300: {
                        if (g2 != null) {
                            this.D.a(d4, d4.g(), d3, 1, 0);
                            if (!x) {
                                break Label_0300;
                            }
                        }
                        this.D.a(d4, d4.i(), d3, 0, 0);
                    }
                    d4 = q.g();
                    if (x) {
                        break;
                    }
                }
            }
            if (comparator2 == null || q.c() <= 1) {
                return;
            }
            d3 = q.h();
            q.f();
        }
        d f = g2;
        while (comparator2.compare(f, d3) > 0) {
            Label_0397: {
                if (f.h() != null) {
                    this.D.a(f, d3, f.h(), 0, 1);
                    if (!x) {
                        break Label_0397;
                    }
                }
                this.D.a(f, d3, f.j(), 0, 0);
            }
            f = q.f();
            if (x) {
                break;
            }
        }
    }
    
    private int a(final q q, final q q2, final boolean b, final boolean b2, final int[] array) {
        int a = 0;
        if (b) {
            a = this.a(q, q2, array);
        }
        if (b2) {
            a += this.b(q, q2, array);
        }
        return a;
    }
    
    private int a(final q q, final q q2, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        int n = 0;
        final int n2 = array[q.d()];
        d d = q.g();
        int n3 = 0;
        while (d != null) {
            n3 = this.F[d.c().d()];
            if (x) {
                return n3;
            }
            if (n3 < 0) {
                final q q3 = (d.g() == null) ? d.i().d() : d.g().d();
                if (q3 != q2) {
                    final int n4 = array[q3.d()] - n2;
                    n += ((n4 > 0) ? 1 : ((n4 < 0) ? -1 : 0));
                }
            }
            d = d.h();
            if (x) {
                break;
            }
        }
        return n3;
    }
    
    private int b(final q q, final q q2, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        int n = 0;
        final int n2 = array[q.d()];
        d d = q.f();
        int n3 = 0;
        while (d != null) {
            n3 = this.F[d.d().d()];
            if (x) {
                return n3;
            }
            if (n3 < 0) {
                final q q3 = (d.h() == null) ? d.j().c() : d.h().c();
                if (q3 != q2) {
                    final int n4 = array[q3.d()] - n2;
                    n += ((n4 > 0) ? 1 : ((n4 < 0) ? -1 : 0));
                }
            }
            d = d.g();
            if (x) {
                break;
            }
        }
        return n3;
    }
    
    private int c(final q q, final q q2, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        d d = q.f();
        d d2 = q2.f();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            while (d != null) {
                final d d3 = d2;
                if (x) {
                    while (true) {
                        if (d3 != null) {
                            n3 = this.F[d.d().d()];
                            if (!x) {
                                Label_0757: {
                                    if (n3 < 0) {
                                        if (((d.h() == null) ? d.j().c() : d.h().c()) == q2) {
                                            break Label_0757;
                                        }
                                        n2 += n;
                                        if (!x) {
                                            break Label_0757;
                                        }
                                    }
                                    n2 += n;
                                }
                                d = d.g();
                                if (!x) {
                                    continue;
                                }
                            }
                        }
                        break;
                    }
                    return n3;
                }
                if (d3 == null) {
                    break;
                }
                int n4 = 1;
                Label_0633: {
                    if (this.F[d.d().d()] < 0) {
                        final d d4 = (d.h() == null) ? d.j() : d.h();
                        final q c = d4.c();
                        if (c == q2) {
                            d = d.g();
                            if (!x) {
                                continue;
                            }
                        }
                        final boolean b = array[c.d()] < array[q.d()];
                        if (this.F[d2.d().d()] < 0) {
                            final d d5 = (d2.h() == null) ? d2.j() : d2.h();
                            final q c2 = d5.c();
                            if (c2 == q) {
                                d2 = d2.g();
                                if (!x) {
                                    continue;
                                }
                            }
                            if (array[c2.d()] < array[q2.d()] == b) {
                                final int n5 = array[c.d()] - array[c2.d()];
                                if (n5 == 0) {
                                    final int b3;
                                    final byte b2 = this.t[b3 = d4.b()];
                                    final int b5;
                                    final byte b4 = this.t[b5 = d5.b()];
                                    if (b2 == -2 || b4 == -2) {
                                        break Label_0633;
                                    }
                                    if (b2 < b4) {
                                        n4 = 0;
                                        if (!x) {
                                            break Label_0633;
                                        }
                                    }
                                    if (b2 != b4) {
                                        break Label_0633;
                                    }
                                    final int n6 = this.v[b3];
                                    final int n7 = this.v[b5];
                                    if (n6 == 0 || n7 == 0 || n6 >= n7) {
                                        break Label_0633;
                                    }
                                    n4 = 0;
                                    if (!x) {
                                        break Label_0633;
                                    }
                                }
                                n4 = ((n5 > 0) ? 1 : 0);
                                if (!x) {
                                    break Label_0633;
                                }
                            }
                            n4 = (b ? 1 : 0);
                            if (!x) {
                                break Label_0633;
                            }
                        }
                        n4 = (b ? 1 : 0);
                        if (!x) {
                            break Label_0633;
                        }
                    }
                    if (this.F[d2.d().d()] < 0) {
                        final q q3 = (d2.h() == null) ? d2.j().c() : d2.h().c();
                        if (q3 == q) {
                            d2 = d2.g();
                            if (!x) {
                                continue;
                            }
                        }
                        n4 = ((array[q3.d()] >= array[q.d()]) ? 1 : 0);
                        if (!x) {
                            break Label_0633;
                        }
                    }
                    final int n8 = array[d.d().d()];
                    final int n9 = array[d2.d().d()];
                    if (n8 == n9) {
                        final int b7;
                        final byte b6 = this.u[b7 = d.b()];
                        final int b9;
                        final byte b8 = this.u[b9 = d2.b()];
                        if (b6 == -2 || b8 == -2) {
                            break Label_0633;
                        }
                        if (b6 > b8) {
                            n4 = 0;
                            if (!x) {
                                break Label_0633;
                            }
                        }
                        if (b6 != b8) {
                            break Label_0633;
                        }
                        final int n10 = this.w[b7];
                        final int n11 = this.w[b9];
                        if (n10 == 0 || n11 == 0 || n10 <= n11) {
                            break Label_0633;
                        }
                        n4 = 0;
                        if (!x) {
                            break Label_0633;
                        }
                    }
                    n4 = ((n8 < n9) ? 1 : 0);
                }
                if (n4 != 0) {
                    n2 += n;
                    d = d.g();
                    if (!x) {
                        continue;
                    }
                }
                ++n;
                d2 = d2.g();
                if (x) {
                    break;
                }
            }
            if (n > 0) {
                continue;
            }
            break;
        }
        return n3;
    }
    
    private int d(final q q, final q q2, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        d d = q.g();
        d d2 = q2.g();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            while (d != null) {
                final d d3 = d2;
                if (x) {
                    while (true) {
                        if (d3 != null) {
                            n3 = this.F[d.c().d()];
                            if (!x) {
                                Label_0757: {
                                    if (n3 < 0) {
                                        if (((d.g() == null) ? d.i().d() : d.g().d()) == q2) {
                                            break Label_0757;
                                        }
                                        n2 += n;
                                        if (!x) {
                                            break Label_0757;
                                        }
                                    }
                                    n2 += n;
                                }
                                d = d.h();
                                if (!x) {
                                    continue;
                                }
                            }
                        }
                        break;
                    }
                    return n3;
                }
                if (d3 == null) {
                    break;
                }
                int n4 = 1;
                Label_0633: {
                    if (this.F[d.c().d()] < 0) {
                        final d d4 = (d.g() == null) ? d.i() : d.g();
                        final q d5 = d4.d();
                        if (d5 == q2) {
                            d = d.h();
                            if (!x) {
                                continue;
                            }
                        }
                        final boolean b = array[d5.d()] < array[q.d()];
                        if (this.F[d2.c().d()] < 0) {
                            final d d6 = (d2.g() == null) ? d2.i() : d2.g();
                            final q d7 = d6.d();
                            if (d7 == q) {
                                d2 = d2.h();
                                if (!x) {
                                    continue;
                                }
                            }
                            if (array[d7.d()] < array[q2.d()] == b) {
                                final int n5 = array[d5.d()] - array[d7.d()];
                                if (n5 == 0) {
                                    final int b3;
                                    final byte b2 = this.u[b3 = d4.b()];
                                    final int b5;
                                    final byte b4 = this.u[b5 = d6.b()];
                                    if (b2 == -2 || b4 == -2) {
                                        break Label_0633;
                                    }
                                    if (b2 < b4) {
                                        n4 = 0;
                                        if (!x) {
                                            break Label_0633;
                                        }
                                    }
                                    if (b2 != b4) {
                                        break Label_0633;
                                    }
                                    final int n6 = this.w[b3];
                                    final int n7 = this.w[b5];
                                    if (n6 == 0 || n7 == 0 || n6 >= n7) {
                                        break Label_0633;
                                    }
                                    n4 = 0;
                                    if (!x) {
                                        break Label_0633;
                                    }
                                }
                                n4 = ((n5 > 0) ? 1 : 0);
                                if (!x) {
                                    break Label_0633;
                                }
                            }
                            n4 = (b ? 1 : 0);
                            if (!x) {
                                break Label_0633;
                            }
                        }
                        n4 = (b ? 1 : 0);
                        if (!x) {
                            break Label_0633;
                        }
                    }
                    if (this.F[d2.c().d()] < 0) {
                        final q q3 = (d2.g() == null) ? d2.i().d() : d2.g().d();
                        if (q3 == q) {
                            d2 = d2.h();
                            if (!x) {
                                continue;
                            }
                        }
                        n4 = ((array[q3.d()] >= array[q.d()]) ? 1 : 0);
                        if (!x) {
                            break Label_0633;
                        }
                    }
                    final int n8 = array[d.c().d()];
                    final int n9 = array[d2.c().d()];
                    if (n8 == n9) {
                        final int b7;
                        final byte b6 = this.t[b7 = d.b()];
                        final int b9;
                        final byte b8 = this.t[b9 = d2.b()];
                        if (b6 == -2 || b8 == -2) {
                            break Label_0633;
                        }
                        if (b6 > b8) {
                            n4 = 0;
                            if (!x) {
                                break Label_0633;
                            }
                        }
                        if (b6 != b8) {
                            break Label_0633;
                        }
                        final int n10 = this.v[b7];
                        final int n11 = this.v[b9];
                        if (n10 == 0 || n11 == 0 || n10 <= n11) {
                            break Label_0633;
                        }
                        n4 = 0;
                        if (!x) {
                            break Label_0633;
                        }
                    }
                    n4 = ((n8 < n9) ? 1 : 0);
                }
                if (n4 != 0) {
                    n2 += n;
                    d = d.h();
                    if (!x) {
                        continue;
                    }
                }
                ++n;
                d2 = d2.h();
                if (x) {
                    break;
                }
            }
            if (n > 0) {
                continue;
            }
            break;
        }
        return n3;
    }
    
    private boolean a(final X x, final aU au, final c c) {
        final boolean x2 = y.f.c.a.N.x;
        final q[][] h = new q[au.b()][];
        final q[][] i = new q[au.b()][];
        int j = Integer.MAX_VALUE;
        int k = 0;
        int l = 0;
        final ArrayList list = new ArrayList<q>(120);
        final ArrayList list2 = new ArrayList<q>(120);
        int n = 0;
    Label_0192_Outer:
        while (n < au.b()) {
            list.clear();
            list2.clear();
            if (!x2) {
                p p3 = au.a(n).d().k();
                while (true) {
                    while (p3 != null) {
                        final q q = (q)p3.c();
                        final int d = c.d(q) ? 1 : 0;
                        if (!x2) {
                            Label_0173: {
                                if (d != 0) {
                                    list.add(q);
                                    x.e(q);
                                    if (!x2) {
                                        break Label_0173;
                                    }
                                }
                                list2.add(q);
                            }
                            p3 = p3.a();
                            if (x2) {
                                break;
                            }
                            continue Label_0192_Outer;
                        }
                        else {
                            if (d > 0) {
                                if (list2.size() > 0) {
                                    i[n] = (q[])list2.toArray(new q[list2.size()]);
                                }
                                if (n < j) {
                                    j = n;
                                }
                                k = n;
                                final q[] array = list.toArray(new q[list.size()]);
                                h[n] = array;
                                l += array.length;
                            }
                            ++n;
                            if (x2) {
                                break Label_0192_Outer;
                            }
                            continue Label_0192_Outer;
                        }
                    }
                    list.size();
                    continue;
                }
            }
            return true;
        }
        if (l > 0) {
            this.H = h;
            this.L = l;
            this.J = j;
            this.K = k;
            this.I = i;
            return true;
        }
        this.L = 0;
        this.H = null;
        this.I = null;
        return true;
    }
    
    private final boolean a(final q q) {
        return q.d() < this.L;
    }
    
    public void a(final X d, final aU au, final aV av, final aP ap) {
        final boolean x = y.f.c.a.N.x;
        this.O = (E)d.c(y.f.c.a.N.w).b(d);
        this.M = (bR)d.c(y.f.c.a.N.v).b(d);
        int n = this.e;
        if (this.M != null) {
            n = Math.min(this.e, 50);
        }
        final c c = d.c(y.f.c.a.N.t);
        boolean a = false;
        Label_0101: {
            if (c != null) {
                a = this.a(d, au, c);
                if (!x) {
                    break Label_0101;
                }
            }
            a = false;
        }
        if (a && this.L == 0) {
            return;
        }
        this.E = new D[au.b()];
        int n2 = 0;
        final ArrayList<Object> list = new ArrayList<Object>();
        int n3 = 0;
        final x o = d.o();
        while (true) {
        Label_0715_Outer:
            while (o.f()) {
                n3 += av.a(o.e()).e();
                o.g();
                if (x) {
                    int n4 = 0;
                    while (true) {
                        do {
                            int i = 0;
                        Label_0237:
                            while (i < au.b()) {
                                this.E[n4] = new D();
                                int n5 = 0;
                                final D d2;
                                final y y = (y)(d2 = au.a(n4).d());
                                if (x) {
                                    final D d3 = d2;
                                    int j = d.g() - 1;
                                    while (true) {
                                    Label_2311_Outer:
                                        while (j >= 0) {
                                            this.o[j] = d3.a((Object)null);
                                            d3.g();
                                            --j;
                                            if (x) {
                                                Label_0989: {
                                                    Label_0984: {
                                                        Label_0911: {
                                                            if (this.M != null) {
                                                                this.m = new int[d.f()];
                                                                this.n = new int[d.f()];
                                                                this.M.a(d, av, true);
                                                                this.M.a(d, this.n, this.m);
                                                                this.N = this.M.a(d, this.E, this.G);
                                                                int k = 0;
                                                                while (k < this.E.length) {
                                                                    this.a(this.E[k], this.G, this.N);
                                                                    ++k;
                                                                    if (x) {
                                                                        break Label_0989;
                                                                    }
                                                                    if (x) {
                                                                        break Label_0911;
                                                                    }
                                                                }
                                                                break Label_0984;
                                                            }
                                                        }
                                                        if (this.a(d, this.E, av)) {
                                                            this.c = new cP(this.a);
                                                            int l = 0;
                                                            while (l < this.E.length) {
                                                                this.a(this.E[l], this.G, this.c);
                                                                ++l;
                                                                if (x) {
                                                                    break Label_0989;
                                                                }
                                                                if (x) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    this.D = d;
                                                    try {
                                                        final cF a2 = this.a(d, au, av, this.G, this.F);
                                                        this.x = a2.b(false);
                                                        this.y = a2.b(true);
                                                        this.z = a2.c(true);
                                                        this.A = a2.c(false);
                                                        this.B = this.x;
                                                        this.C = this.y;
                                                        final long currentTimeMillis = System.currentTimeMillis();
                                                        final ar ar = new ar(666L);
                                                        this.a(d, this.E, this.G, null);
                                                        this.O.a(this.E, this.G, true);
                                                        final int[] array = new int[this.G.length];
                                                        int a3 = this.a(ar);
                                                        this.a(this.G, array);
                                                        int n7 = 0;
                                                        Label_1828: {
                                                            if (System.currentTimeMillis() - currentTimeMillis < this.h && a3 > 0) {
                                                                int n6 = 0;
                                                                while (n6 < n) {
                                                                    n7 = a3;
                                                                    if (x) {
                                                                        break Label_1828;
                                                                    }
                                                                    if (n7 <= 0 || System.currentTimeMillis() - currentTimeMillis >= this.h) {
                                                                        break;
                                                                    }
                                                                    bT bt = null;
                                                                    Label_1782: {
                                                                        Label_1765: {
                                                                            if ((n6 & 0x3) < 2) {
                                                                                this.a(d, this.E, this.G, ar);
                                                                                if (!x) {
                                                                                    break Label_1765;
                                                                                }
                                                                            }
                                                                            int n8 = 0;
                                                                        Label_1667:
                                                                            while (true) {
                                                                            Label_1663:
                                                                                do {
                                                                                    Label_1655: {
                                                                                    Label_1610:
                                                                                        while (true) {
                                                                                            final int length = this.E.length;
                                                                                            int n9 = 0;
                                                                                            int m = 0;
                                                                                        Label_1227:
                                                                                            while (n9 < m) {
                                                                                                final int l2 = this.L;
                                                                                                if (x) {
                                                                                                    break Label_1667;
                                                                                                }
                                                                                                if (l2 == 0) {
                                                                                                    Label_1466: {
                                                                                                        Label_1447: {
                                                                                                            Label_1294: {
                                                                                                                if (this.a == null && this.M == null) {
                                                                                                                    int n10 = 0;
                                                                                                                    while (n10 < this.j.length) {
                                                                                                                        this.j[n10] = ar.nextFloat();
                                                                                                                        ++n10;
                                                                                                                        if (x) {
                                                                                                                            break Label_1466;
                                                                                                                        }
                                                                                                                        if (x) {
                                                                                                                            break Label_1294;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    break Label_1447;
                                                                                                                }
                                                                                                            }
                                                                                                            Label_1391: {
                                                                                                                if (this.a != null) {
                                                                                                                    int n11 = 0;
                                                                                                                    while (n11 < this.j.length) {
                                                                                                                        final int n12 = n9 = this.a[n11];
                                                                                                                        if (x) {
                                                                                                                            continue Label_1655;
                                                                                                                        }
                                                                                                                        Label_1383: {
                                                                                                                            if (n9 < 0) {
                                                                                                                                this.j[n11] = ar.nextFloat() * (this.b[n8] + 1) * 2.0f;
                                                                                                                                if (!x) {
                                                                                                                                    break Label_1383;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            this.j[n11] = ar.nextFloat() + (n12 + 1) * 2;
                                                                                                                        }
                                                                                                                        ++n11;
                                                                                                                        if (x) {
                                                                                                                            break Label_1391;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    break Label_1447;
                                                                                                                }
                                                                                                            }
                                                                                                            int n13 = 0;
                                                                                                            while (n13 < this.j.length) {
                                                                                                                this.j[n13] = ar.nextFloat() * this.m[n13] + this.n[n13];
                                                                                                                ++n13;
                                                                                                                if (x) {
                                                                                                                    break Label_1466;
                                                                                                                }
                                                                                                                if (x) {
                                                                                                                    break;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        this.a(this.E[n8], this.G, this.g);
                                                                                                    }
                                                                                                    if (!x) {
                                                                                                        break Label_1655;
                                                                                                    }
                                                                                                }
                                                                                                int n14 = 0;
                                                                                                if (this.H[n8] != null && this.H[n8].length > 0) {
                                                                                                    final float n15 = 1.0f / (1 + this.E[n8].size() - this.H[n8].length);
                                                                                                    p p4 = this.E[n8].k();
                                                                                                    while (p4 != null) {
                                                                                                        final int d4;
                                                                                                        final int n16 = d4 = ((q)p4.c()).d();
                                                                                                        m = this.L;
                                                                                                        if (x) {
                                                                                                            continue Label_1227;
                                                                                                        }
                                                                                                        Label_1598: {
                                                                                                            if (d4 < m) {
                                                                                                                this.j[n16] = ar.nextFloat();
                                                                                                                if (!x) {
                                                                                                                    break Label_1598;
                                                                                                                }
                                                                                                            }
                                                                                                            this.j[n16] = n15 * ++n14;
                                                                                                        }
                                                                                                        p4 = p4.a();
                                                                                                        if (x) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    break Label_1610;
                                                                                                }
                                                                                                break Label_1655;
                                                                                            }
                                                                                            break Label_1663;
                                                                                        }
                                                                                        this.a(this.E[n8], this.G, this.g);
                                                                                        if (this.a != null) {
                                                                                            this.a(this.E[n8], this.G, this.c);
                                                                                        }
                                                                                    }
                                                                                    ++n8;
                                                                                    continue Label_0715_Outer;
                                                                                    int l2 = 0;
                                                                                    if (l2 != 0 && this.M != null) {
                                                                                        this.N = this.M.a(d, this.E, this.G);
                                                                                        int n17 = 0;
                                                                                        while (n17 < this.E.length) {
                                                                                            bt = this;
                                                                                            if (x) {
                                                                                                break Label_1782;
                                                                                            }
                                                                                            if (this.H[n17] != null && this.H[n17].length > 0) {
                                                                                                this.a(this.E[n17], this.G, this.N);
                                                                                            }
                                                                                            ++n17;
                                                                                            if (x) {
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    break Label_1765;
                                                                                } while (!x);
                                                                                final int l3 = this.L;
                                                                                continue Label_1667;
                                                                            }
                                                                        }
                                                                        this.O.a(this.E, this.G, true);
                                                                        bt = this;
                                                                    }
                                                                    final int a4 = bt.a(ar);
                                                                    if (a4 < a3) {
                                                                        this.a(this.G, array);
                                                                        a3 = a4;
                                                                    }
                                                                    ++n6;
                                                                    if (x) {
                                                                        break;
                                                                    }
                                                                }
                                                                this.b(array);
                                                            }
                                                            final boolean f = this.f;
                                                        }
                                                        if (n7 != 0 && !this.O.k()) {
                                                            this.a(this.G);
                                                        }
                                                    }
                                                    finally {
                                                    Label_2311:
                                                        while (true) {
                                                            Label_2308: {
                                                                Label_2256: {
                                                                    if (this.M != null) {
                                                                        this.N = this.M.a(d, this.E, this.G);
                                                                        int n18 = 0;
                                                                        while (true) {
                                                                            while (n18 < this.E.length) {
                                                                                this.a(this.E[n18], this.G, this.N);
                                                                                ++n18;
                                                                                if (!x) {
                                                                                    if (x) {
                                                                                        break;
                                                                                    }
                                                                                    continue Label_0715_Outer;
                                                                                }
                                                                                else {
                                                                                    if (x) {
                                                                                        break Label_2256;
                                                                                    }
                                                                                    break Label_2308;
                                                                                }
                                                                            }
                                                                            this.M.b(d, av, false);
                                                                            continue Label_2311_Outer;
                                                                        }
                                                                    }
                                                                    break Label_2256;
                                                                    while (true) {
                                                                        int n19 = 0;
                                                                        while (n19 < list.size()) {
                                                                            d.a(list.get(n19));
                                                                            ++n19;
                                                                            if (!x) {
                                                                                if (x) {
                                                                                    break;
                                                                                }
                                                                                continue Label_0715_Outer;
                                                                            }
                                                                            else {
                                                                                this.g = null;
                                                                                this.v = null;
                                                                                this.w = null;
                                                                                this.x = null;
                                                                                this.y = null;
                                                                                this.z = null;
                                                                                this.A = null;
                                                                                this.B = null;
                                                                                this.C = null;
                                                                                this.c = null;
                                                                                this.a = null;
                                                                            }
                                                                        }
                                                                        this.D = null;
                                                                        this.G = null;
                                                                        this.r = null;
                                                                        this.s = null;
                                                                        this.p = null;
                                                                        this.q = null;
                                                                        this.j = null;
                                                                        this.o = null;
                                                                        this.k = null;
                                                                        this.l = null;
                                                                        this.t = null;
                                                                        this.u = null;
                                                                        continue;
                                                                    }
                                                                }
                                                                if (this.c != null) {
                                                                    int n19 = 0;
                                                                    while (n19 < this.E.length) {
                                                                        this.a(this.E[n19], this.G, this.c);
                                                                        ++n19;
                                                                        if (x) {
                                                                            continue Label_2311;
                                                                        }
                                                                        if (x) {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            int n19 = 0;
                                                            continue Label_2311;
                                                        }
                                                    }
                                                }
                                                if (this.E != null) {
                                                    int n20 = 0;
                                                    while (n20 < au.b()) {
                                                        au.a(n20).a(this.E[n20]);
                                                        ++n20;
                                                        if (x) {
                                                            return;
                                                        }
                                                        if (x) {
                                                            break;
                                                        }
                                                    }
                                                    this.O.g(au);
                                                }
                                                this.E = null;
                                                return;
                                            }
                                            if (x) {
                                                break;
                                            }
                                        }
                                        this.k = new float[n2 + 2];
                                        this.g = new bX(this.j);
                                        continue;
                                    }
                                }
                                p p5 = y.k();
                                while (p5 != null) {
                                    final q q = (q)p5.c();
                                    q q2 = null;
                                Label_0299:
                                    while (true) {
                                        q c2 = null;
                                        q2 = c2;
                                        final aX a5 = av.a(q2);
                                        i = a5.e();
                                        if (x) {
                                            continue Label_0237;
                                        }
                                        if (i > 0) {
                                            p p6 = a5.d();
                                            while (p6 != null) {
                                                final d d5 = (d)p6.c();
                                                final A a6 = av.a(d5);
                                                c2 = d5.c();
                                                if (x) {
                                                    continue Label_0299;
                                                }
                                                if (c2 == q2) {
                                                    final q d6 = d.d();
                                                    list.add(d6);
                                                    Label_0506: {
                                                        if (a6.j()) {
                                                            ap.b(d6, q2, d5, false, true);
                                                            ap.a(d6, d5.d(), d5, false, true);
                                                            n2 = Math.max(n2, d5.d().b());
                                                            if (!x) {
                                                                break Label_0506;
                                                            }
                                                        }
                                                        ap.a(q2, d6, d5, true, false);
                                                        ap.b(d5.d(), d6, d5, true, false);
                                                        n2 = Math.max(n2, d5.d().c());
                                                    }
                                                    n2 = Math.max(2, n2);
                                                    this.G[d6.d()] = -1;
                                                    this.F[d6.d()] = -(n4 + 1);
                                                }
                                                p6 = p6.a();
                                                if (x) {
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    n2 = Math.max(n2, Math.max(q2.b(), q2.c()));
                                    this.E[n4].b(q2);
                                    this.G[q2.d()] = n5;
                                    this.F[q2.d()] = n4;
                                    ++n5;
                                    p5 = p5.a();
                                    if (x) {
                                        break;
                                    }
                                }
                                ++n4;
                            }
                            break;
                        } while (!x);
                        this.p = new D();
                        this.q = new D();
                        this.r = new D();
                        this.s = new D();
                        this.l = new q[d.f()];
                        this.j = new float[d.f()];
                        this.o = new p[d.g()];
                        D d2 = new D();
                        continue;
                    }
                }
                if (x) {
                    break;
                }
            }
            this.F = new int[d.e() + n3 / 2];
            this.G = new int[d.e() + n3 / 2];
            continue;
        }
    }
    
    boolean a(final i i, final D[] array, final aV av) {
        final boolean x = y.f.c.a.N.x;
        final int[] a = new int[i.e()];
        int j = 0;
        while (true) {
            while (j < a.length) {
                a[j] = -1;
                ++j;
                if (!x) {
                    if (x) {
                        break;
                    }
                    continue;
                }
                else {
                    int max = -1;
                    int k = 0;
                Label_0161_Outer:
                    while (k < array.length) {
                        final D d = array[k];
                        if (!x) {
                            p p3 = d.k();
                            while (true) {
                                while (p3 != null) {
                                    final q q = (q)p3.c();
                                    final bK h = av.a(q).h();
                                    if (!x) {
                                        if (h != null) {
                                            ++j;
                                            final int l = h.j();
                                            a[q.d()] = l;
                                            max = Math.max(max, l);
                                        }
                                        p3 = p3.a();
                                        if (x) {
                                            break;
                                        }
                                        continue Label_0161_Outer;
                                    }
                                    else {
                                        if (x) {
                                            break Label_0161_Outer;
                                        }
                                        continue Label_0161_Outer;
                                    }
                                }
                                ++k;
                                continue;
                            }
                        }
                        return false;
                    }
                    if (j <= 0 || max <= 0) {
                        this.a = null;
                        this.b = null;
                        return false;
                    }
                    this.a = a;
                    this.b = new int[array.length];
                    int n = 0;
                    while (n < this.b.length) {
                        this.b[n] = max;
                        ++n;
                        if (x) {
                            return true;
                        }
                        if (x) {
                            break;
                        }
                    }
                    if (this.O != null && this.O.k()) {
                        this.O.a(array, a, this.b);
                        return true;
                    }
                    return true;
                }
            }
            j = 0;
            continue;
        }
    }
    
    void a(final i i, final D[] array, final int[] array2, final ar ar) {
        final boolean x = y.f.c.a.N.x;
        q q = null;
        final p[] array3 = new p[i.e()];
        final int[] array4 = new int[i.e()];
        int j = 0;
    Label_0028:
        while (true) {
        Label_0125_Outer:
            while (j < array.length) {
                final D d = array[j];
                if (!x) {
                    if (q == null) {
                        q = (q)d.f();
                    }
                    p p4 = d.k();
                    while (true) {
                        while (p4 != null) {
                            final q q2 = (q)p4.c();
                            array3[q2.d()] = p4;
                            array4[q2.d()] = j + 1;
                            p4 = p4.a();
                            if (!x) {
                                if (x) {
                                    break;
                                }
                                continue Label_0125_Outer;
                            }
                            else {
                                if (x) {
                                    break Label_0125_Outer;
                                }
                                continue Label_0028;
                            }
                        }
                        ++j;
                        continue;
                    }
                }
                final bW bw = new bW(this, array3, array4, array);
                bw.a(false);
                bw.b(true);
                bw.a(i, q);
                Label_0332: {
                    if (this.M != null) {
                        this.N = this.M.a(i, array, array2);
                        int k = 0;
                        while (k < array.length) {
                            this.a(array[k], array2, this.N);
                            ++k;
                            if (x) {
                                break Label_0332;
                            }
                        }
                        return;
                    }
                }
                Label_0370: {
                    if (this.c != null) {
                        int l = 0;
                        while (l < array.length) {
                            this.a(array[l], array2, this.c);
                            ++l;
                            if (x) {
                                break Label_0370;
                            }
                        }
                        return;
                    }
                }
                int n = 0;
                while (n < array.length) {
                    this.a(array[n], array2);
                    ++n;
                    if (x) {
                        break;
                    }
                }
                return;
            }
            Label_0217: {
                if (ar != null) {
                    int nextInt = ar.nextInt(i.e());
                    final x o = i.o();
                    while (true) {
                        while (o.f()) {
                            final q e = o.e();
                            if (x) {
                                Arrays.fill(array2, 0);
                                break Label_0217;
                            }
                            if (nextInt == 0) {
                                q = e;
                                if (!x) {
                                    break;
                                }
                            }
                            o.g();
                            --nextInt;
                            if (x) {
                                break;
                            }
                        }
                        this.a(i, ar);
                        continue;
                    }
                }
            }
            i.a(new cX(this.u), new cX(this.t));
            continue;
        }
    }
    
    private int a(final ar ar) {
        final boolean x = y.f.c.a.N.x;
        y.a.a.a();
        boolean b = false;
        int n = Integer.MAX_VALUE;
        int b2 = Integer.MAX_VALUE;
        final int[] array = new int[this.G.length];
        boolean nextBoolean = ar.nextBoolean();
        int n2 = 0;
        int i = 0;
        while (true) {
            while (i < 2) {
                final int n3 = n2;
                final int n4 = 6;
                if (x) {
                    if (n3 > n4) {
                        this.b(array);
                    }
                    return n;
                }
                if (n3 >= n4 || n <= 0) {
                    break;
                }
                b2 = this.b(nextBoolean);
                Label_0113: {
                    if (b2 < n) {
                        n = b2;
                        b = true;
                        this.a(this.G, array);
                        if (!x) {
                            break Label_0113;
                        }
                    }
                    if (b2 > n) {
                        ++i;
                        if (!x) {
                            break Label_0113;
                        }
                    }
                    ++n2;
                }
                nextBoolean = !nextBoolean;
                if (x) {
                    break;
                }
            }
            if (b) {
                continue;
            }
            break;
        }
        return n;
    }
    
    private void a(final D d, final Comparator comparator, final Comparator comparator2) {
        final boolean x = y.f.c.a.N.x;
        if (comparator != null || comparator2 != null) {
            p p3 = d.k();
            while (p3 != null) {
                final q q = (q)p3.c();
                if (comparator != null) {
                    q.a(comparator);
                }
                if (comparator2 != null) {
                    q.b(comparator2);
                }
                p3 = p3.a();
                if (x) {
                    break;
                }
            }
        }
    }
    
    private void a(final i i, final Comparator comparator, final Comparator comparator2) {
        if (comparator != null || comparator2 != null) {
            i.a(comparator, comparator2);
        }
    }
    
    private int b(final boolean b) {
        final boolean x = y.f.c.a.N.x;
        bT bt = null;
        Label_0293: {
            Label_0292: {
                Label_0195: {
                    if (this.L > 0) {
                        Label_0099: {
                            if (b) {
                                this.O.a(Math.max(1, this.J) - 1);
                                int i = Math.max(1, this.J);
                                while (i <= this.K) {
                                    bt = this;
                                    if (x) {
                                        break Label_0293;
                                    }
                                    if (this.H[i] != null) {
                                        this.a(true, false, i, this.E[i], this.E[i - 1], null, this.j, this.G);
                                    }
                                    ++i;
                                    if (x) {
                                        break Label_0099;
                                    }
                                }
                                break Label_0292;
                            }
                        }
                        this.O.a(Math.min(this.E.length - 1, this.K));
                        int j = Math.min(this.E.length - 1, this.K) - 1;
                        while (j >= this.J) {
                            bt = this;
                            if (x) {
                                break Label_0293;
                            }
                            if (this.H[j] != null) {
                                this.a(false, true, j, this.E[j], null, this.E[j + 1], this.j, this.G);
                            }
                            --j;
                            if (x) {
                                break Label_0195;
                            }
                        }
                        break Label_0292;
                    }
                }
                Label_0242: {
                    if (b) {
                        this.O.a(0);
                        int k = 1;
                        while (k < this.E.length) {
                            this.a(this.E, k, this.G);
                            ++k;
                            if (x) {
                                return this.a();
                            }
                            if (x) {
                                break Label_0242;
                            }
                        }
                        break Label_0292;
                    }
                }
                this.O.a(this.E.length - 1);
                int l = this.E.length - 2;
                while (l >= 0) {
                    this.b(this.E, l, this.G);
                    --l;
                    if (x) {
                        return this.a();
                    }
                    if (x) {
                        break;
                    }
                }
            }
            bt = this;
        }
        if (bt.f && !this.O.k()) {
            this.a(this.G);
        }
        return this.a();
    }
    
    private void a(final boolean b, final boolean b2, final int n, final D d, final D d2, final D d3, final float[] array, final int[] array2) {
        final boolean x = y.f.c.a.N.x;
        final int size = d.size();
        final int n2 = size * 2;
        float n3 = 1.0f;
        int n4 = 0;
        p p8 = d.k();
        while (true) {
        Label_0921_Outer:
            while (p8 != null) {
                final q q = (q)p8.c();
                array2[q.d()] = n4 + 1;
                array[q.d()] = n4;
                final float n5 = fcmpg(n3, array[q.d()]);
                if (x) {
                    if (n5 != 0) {
                        this.a(d, (Comparator)null, this.z);
                    }
                    if (b) {
                        this.a(d, this.A, null);
                    }
                    final q[] array3 = this.H[n];
                    final q[] array4 = this.I[n];
                    final int n6 = b ? d2.size() : 0;
                    final int n7 = b2 ? d3.size() : 0;
                    int i = 0;
                Label_0921:
                    while (true) {
                        while (i < array3.length) {
                            final q q2 = array3[i];
                            final int d4 = q2.d();
                            int n8 = 0;
                            float n9 = 0.0f;
                            Label_1169: {
                                Label_1155: {
                                    int n23 = 0;
                                    Label_1128: {
                                        if (!x) {
                                            Label_0289: {
                                                if (b) {
                                                    d d5 = q2.g();
                                                    while (d5 != null) {
                                                        n9 += this.a(true, d5, size, n2, this.G);
                                                        d5 = d5.h();
                                                        ++n8;
                                                        if (x) {
                                                            break Label_0289;
                                                        }
                                                        if (x) {
                                                            break;
                                                        }
                                                    }
                                                    n9 /= n6;
                                                }
                                            }
                                            Label_0359: {
                                                if (b2) {
                                                    float n10 = 0.0f;
                                                    d d6 = q2.f();
                                                    while (d6 != null) {
                                                        n10 += this.a(false, d6, size, n2, this.G);
                                                        d6 = d6.g();
                                                        ++n8;
                                                        if (x) {
                                                            break Label_0359;
                                                        }
                                                        if (x) {
                                                            break;
                                                        }
                                                    }
                                                    n9 += n10 / n7;
                                                }
                                            }
                                            float n11 = 0.0f;
                                            Label_0408: {
                                                if (n8 == 0) {
                                                    n11 = this.G[d4];
                                                    if (!x) {
                                                        break Label_0408;
                                                    }
                                                }
                                                n11 = n9 * n2 / n8 + this.G[d4] / 200.0f;
                                            }
                                            int n13;
                                            int n12 = n13 = 0;
                                            int n14 = -1;
                                            Label_0891: {
                                                Label_0884: {
                                                    if (array4 != null && array4.length > 0) {
                                                        int j = 0;
                                                        while (j < array4.length) {
                                                            final q q3 = array4[j];
                                                            final bR m = this.M;
                                                            if (x) {
                                                                break Label_0921;
                                                            }
                                                            Label_0856: {
                                                                if (m != null) {
                                                                    if (this.M.a(q2.e(), q3, q2)) {
                                                                        n13 = n12;
                                                                        n14 = this.G[q3.d()] + 1;
                                                                        if (!x) {
                                                                            break Label_0856;
                                                                        }
                                                                    }
                                                                    if (this.M.a(q2.e(), q2, q3)) {
                                                                        break;
                                                                    }
                                                                }
                                                                else if (this.a != null && this.a[d4] >= 0 && this.a[q3.d()] >= 0) {
                                                                    if (this.a[d4] > this.a[q3.d()]) {
                                                                        n13 = n12;
                                                                        n14 = this.G[q3.d()] + 1;
                                                                        if (!x) {
                                                                            break Label_0856;
                                                                        }
                                                                    }
                                                                    if (this.a[d4] < this.a[q3.d()]) {
                                                                        break;
                                                                    }
                                                                }
                                                                final int n15 = this.G[q3.d()] - 1;
                                                                int n16 = 0;
                                                                if (b) {
                                                                    array2[d4] = n15;
                                                                    this.a(q2, this.A, null, true);
                                                                    final int n17 = n16 - this.d(q2, q3, this.G);
                                                                    final int n18 = d4;
                                                                    array2[n18] += 2;
                                                                    this.a(q2, this.A, null, true);
                                                                    n16 = n17 + this.d(q3, q2, this.G);
                                                                }
                                                                if (b2) {
                                                                    array2[d4] = n15;
                                                                    this.a(q2, null, this.z, true);
                                                                    final int n19 = n16 - this.c(q2, q3, this.G);
                                                                    final int n20 = d4;
                                                                    array2[n20] += 2;
                                                                    this.a(q2, null, this.z, true);
                                                                    n16 = n19 + this.c(q3, q2, this.G);
                                                                }
                                                                n12 += n16;
                                                                if (n12 < n13) {
                                                                    n14 = n15;
                                                                    n13 = n12;
                                                                    if (!x) {
                                                                        break Label_0856;
                                                                    }
                                                                }
                                                                if (n12 == n13 && Math.abs(n15 - n11) < Math.abs(n14 - n11)) {
                                                                    n14 = n15;
                                                                }
                                                            }
                                                            ++j;
                                                            if (x) {
                                                                break;
                                                            }
                                                        }
                                                        array[d4] = n14 + n11 / n2;
                                                        if (x) {
                                                            break Label_0884;
                                                        }
                                                        break Label_0891;
                                                        bR m = null;
                                                        if (m != null) {
                                                            p p9 = d.k();
                                                            while (p9 != null) {
                                                                final int d7 = ((q)p9.c()).d();
                                                                array[d7] = array[d7] / n3 * this.m[d7] + this.n[d7];
                                                                p9 = p9.a();
                                                                if (!x) {
                                                                    continue Label_0921_Outer;
                                                                }
                                                                break Label_1155;
                                                            }
                                                        }
                                                        else if (this.a != null) {
                                                            final float n21 = d.size() * 3;
                                                            p p10 = d.k();
                                                            while (p10 != null) {
                                                                final int d8 = ((q)p10.c()).d();
                                                                final int n22 = n23 = this.a[d8];
                                                                if (x) {
                                                                    break Label_1128;
                                                                }
                                                                Label_1109: {
                                                                    if (n23 >= 0) {
                                                                        array[d8] += (n22 + 1) * n21;
                                                                        if (!x) {
                                                                            break Label_1109;
                                                                        }
                                                                    }
                                                                    array[d8] = array[d8] / (n2 + 1) * (this.b[n] + 1) * n21;
                                                                }
                                                                p10 = p10.a();
                                                                if (x) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        this.O.k();
                                                        break Label_1128;
                                                    }
                                                }
                                                array[d4] = n11;
                                            }
                                            if (n3 < array[d4]) {
                                                n3 = array[d4];
                                            }
                                            ++i;
                                            if (x) {
                                                break;
                                            }
                                            continue Label_0921_Outer;
                                        }
                                    }
                                    if (n23 != 0) {
                                        this.O.a(d, n, this.j, this.G, true);
                                        if (!x) {
                                            break Label_1169;
                                        }
                                    }
                                }
                                this.a(d, this.G, this.g);
                            }
                            if (this.f && !this.O.k()) {
                                if (b) {
                                    this.a(n, d, true, false, this.G);
                                }
                                if (b2) {
                                    this.a(n, d, false, true, this.G);
                                }
                            }
                            return;
                        }
                        final bR k = this.M;
                        continue Label_0921;
                    }
                }
                if (n5 < 0) {
                    n3 = array[q.d()];
                }
                p8 = p8.a();
                n4 += 2;
                if (x) {
                    break;
                }
            }
            continue;
        }
    }
    
    void a(final D[] array, final int n, final int[] array2) {
        final boolean x = y.f.c.a.N.x;
        final D d = array[n - 1];
        final D d2 = array[n];
        final int size = d.size();
        final int size2 = d2.size();
        float n2 = 1.0f;
        p p3 = d2.k();
    Label_0389_Outer:
        while (true) {
        Label_0389:
            while (true) {
                while (p3 != null) {
                    final q q = (q)p3.c();
                    final int d3 = q.d();
                    final byte i = this.i;
                    if (x) {
                        Label_0400: {
                            if (i != 0) {
                                this.O.a(d2, n, this.j, array2, true);
                                if (!x) {
                                    break Label_0400;
                                }
                            }
                            this.a(d2, array2, this.g);
                        }
                        if (this.f && !this.O.k()) {
                            this.a(d2, this.A, null);
                            this.a(n, d2, true, false, array2);
                            this.a(d, (Comparator)null, this.y);
                        }
                        return;
                    }
                    Label_0124: {
                        switch (i) {
                            case 0: {
                                this.j[d3] = this.b(q, size2, false, size, array2);
                                if (x) {
                                    break Label_0124;
                                }
                                break;
                            }
                            case 1: {
                                this.j[d3] = this.a(q, size2, false, size, array2);
                                break;
                            }
                        }
                    }
                    final float[] j = this.j;
                    final int n3 = d3;
                    j[n3] += array2[d3] / (size * 200);
                    Label_0240: {
                        if (this.a != null) {
                            final int n4 = this.a[d3];
                            if (n4 < 0) {
                                this.j[d3] = 2.0f * this.j[d3] * (this.b[n] + 1);
                                if (!x) {
                                    break Label_0240;
                                }
                            }
                            final float[] k = this.j;
                            final int n5 = d3;
                            k[n5] += (n4 + 1) * ((size + 1) * 2);
                        }
                    }
                    if (n2 < this.j[d3]) {
                        n2 = this.j[d3];
                    }
                    p3 = p3.a();
                    if (x) {
                        break;
                    }
                }
                if (this.M != null) {
                    p p4 = d2.k();
                    while (p4 != null) {
                        final int d4 = ((q)p4.c()).d();
                        this.j[d4] = this.j[d4] / n2 * this.m[d4] + this.n[d4];
                        p4 = p4.a();
                        if (x) {
                            continue Label_0389;
                        }
                        if (x) {
                            break;
                        }
                    }
                }
                break;
            }
            this.O.k();
            continue Label_0389_Outer;
        }
    }
    
    void b(final D[] array, final int n, final int[] array2) {
        final boolean x = y.f.c.a.N.x;
        final D d = array[n + 1];
        final D d2 = array[n];
        final int size = d.size();
        final int size2 = d2.size();
        float n2 = 1.0f;
        p p3 = d2.k();
    Label_0389_Outer:
        while (true) {
        Label_0389:
            while (true) {
                while (p3 != null) {
                    final q q = (q)p3.c();
                    final int d3 = q.d();
                    final byte i = this.i;
                    if (x) {
                        Label_0400: {
                            if (i != 0) {
                                this.O.a(d2, n, this.j, array2, false);
                                if (!x) {
                                    break Label_0400;
                                }
                            }
                            this.a(d2, array2, this.g);
                        }
                        if (this.f && !this.O.k()) {
                            this.a(d2, (Comparator)null, this.y);
                            this.a(n, d2, false, true, array2);
                            this.a(d, this.x, null);
                        }
                        return;
                    }
                    Label_0124: {
                        switch (i) {
                            case 0: {
                                this.j[d3] = this.b(q, size2, true, size, array2);
                                if (x) {
                                    break Label_0124;
                                }
                                break;
                            }
                            case 1: {
                                this.j[d3] = this.a(q, size2, true, size, array2);
                                break;
                            }
                        }
                    }
                    final float[] j = this.j;
                    final int n3 = d3;
                    j[n3] += array2[d3] / (size * 200);
                    Label_0240: {
                        if (this.a != null) {
                            final int n4 = this.a[d3];
                            if (n4 < 0) {
                                this.j[d3] = 2.0f * this.j[d3] * (this.b[n] + 1);
                                if (!x) {
                                    break Label_0240;
                                }
                            }
                            final float[] k = this.j;
                            final int n5 = d3;
                            k[n5] += (n4 + 1) * ((size + 1) * 2);
                        }
                    }
                    if (n2 < this.j[d3]) {
                        n2 = this.j[d3];
                    }
                    p3 = p3.a();
                    if (x) {
                        break;
                    }
                }
                if (this.M != null) {
                    p p4 = d2.k();
                    while (p4 != null) {
                        final int d4 = ((q)p4.c()).d();
                        this.j[d4] = this.j[d4] / n2 * this.m[d4] + this.n[d4];
                        p4 = p4.a();
                        if (x) {
                            continue Label_0389;
                        }
                        if (x) {
                            break;
                        }
                    }
                }
                break;
            }
            this.O.k();
            continue Label_0389_Outer;
        }
    }
    
    private float a(final boolean b, final d d, final int n, final int n2, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        if (b) {
            final int d2 = d.c().d();
            if (this.F[d2] < 0) {
                final d d3 = (d.g() == null) ? d.i() : d.g();
                float n3 = (n2 - 1) * array[d3.d().d()] / (n - 1);
                if (this.u == null) {
                    return n3;
                }
                final int b2;
                Label_0137: {
                    switch (this.u[b2 = d3.b()]) {
                        case 1: {
                            n3 -= 0.3f;
                            if (x) {
                                break Label_0137;
                            }
                            break;
                        }
                        case -1: {
                            n3 += 0.3f;
                            break;
                        }
                    }
                }
                n3 -= this.w[b2] * 0.01f;
                if (!x) {
                    return n3;
                }
            }
            float n3 = array[d2];
            if (this.t == null) {
                return n3;
            }
            final int b3;
            Label_0233: {
                switch (this.t[b3 = d.b()]) {
                    case 1: {
                        n3 += 0.3f;
                        if (x) {
                            break Label_0233;
                        }
                        break;
                    }
                    case -1: {
                        n3 -= 0.3f;
                        break;
                    }
                }
            }
            n3 += this.v[b3] * 0.01f;
            if (!x) {
                return n3;
            }
        }
        final int d4 = d.d().d();
        if (this.F[d4] < 0) {
            final d d5 = (d.h() == null) ? d.j() : d.h();
            float n3 = (n2 - 1) * array[d5.c().d()] / (n - 1);
            if (this.t == null) {
                return n3;
            }
            final int b4;
            Label_0389: {
                switch (this.t[b4 = d5.b()]) {
                    case 1: {
                        n3 -= 0.3f;
                        if (x) {
                            break Label_0389;
                        }
                        break;
                    }
                    case -1: {
                        n3 += 0.3f;
                        break;
                    }
                }
            }
            n3 -= this.v[b4] * 0.01f;
            if (!x) {
                return n3;
            }
        }
        float n3 = array[d4];
        if (this.u != null) {
            final int b5;
            Label_0485: {
                switch (this.u[b5 = d.b()]) {
                    case 1: {
                        n3 += 0.3f;
                        if (x) {
                            break Label_0485;
                        }
                        break;
                    }
                    case -1: {
                        n3 -= 0.3f;
                        break;
                    }
                }
            }
            n3 += this.w[b5] * 0.01f;
        }
        return n3;
    }
    
    private float a(final q q, final int n, final boolean b, final int n2, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        int n3 = 0;
        Label_0176: {
            Label_0112: {
                Label_0062: {
                    if (b) {
                        d d = q.f();
                        while (d != null) {
                            this.k[n3] = this.a(false, d, n, n2, array);
                            d = d.g();
                            ++n3;
                            if (x) {
                                break Label_0176;
                            }
                            if (x) {
                                break Label_0062;
                            }
                        }
                        break Label_0112;
                    }
                }
                d d2 = q.g();
                while (d2 != null) {
                    this.k[n3] = this.a(true, d2, n, n2, array);
                    d2 = d2.h();
                    ++n3;
                    if (x) {
                        break Label_0176;
                    }
                    if (x) {
                        break;
                    }
                }
            }
            if (n3 == 0) {
                final int n4 = array[q.d()];
                if (n4 == 0) {
                    return -1.0f;
                }
                if (n4 >= n - 1) {
                    return n2;
                }
                return (n2 - 1) * array[q.d()] / (n - 1);
            }
            else {
                Arrays.sort(this.k, 0, n3);
            }
        }
        final int n5 = n3 >> 1;
        if (n3 % 2 == 1) {
            return this.k[n5];
        }
        if (n3 == 2) {
            return (this.k[0] + this.k[1]) * 0.5f;
        }
        final float n6 = this.k[n5 - 1] - this.k[0];
        final float n7 = this.k[n3 - 1] - this.k[n5];
        if (n6 != 0.0f || n7 != 0.0f) {
            return (this.k[n5 - 1] * n7 + this.k[n5] * n6) / (n6 + n7);
        }
        return (this.k[n5 - 1] + this.k[n5]) * 0.5f;
    }
    
    private float b(final q q, final int n, final boolean b, final int n2, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        float n3 = 0.0f;
        final int n4 = b ? q.c() : q.b();
        if (n4 != 0) {
            Label_0128: {
                if (b) {
                    d d = q.f();
                    while (d != null) {
                        n3 += this.a(false, d, n, n2, array);
                        d = d.g();
                        if (x) {
                            return n3;
                        }
                        if (x) {
                            break Label_0128;
                        }
                    }
                    return n3 / n4;
                }
            }
            d d2 = q.g();
            while (d2 != null) {
                n3 += this.a(true, d2, n, n2, array);
                d2 = d2.h();
                if (x) {
                    return n3;
                }
                if (x) {
                    break;
                }
            }
            n3 /= n4;
            return n3;
        }
        final int n5 = array[q.d()];
        if (n5 == 0) {
            return -1.0f;
        }
        if (n5 >= n - 1) {
            return n2;
        }
        return (n2 - 1) * array[q.d()] / (n - 1);
    }
    
    private final void a(final D d, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        int n = 0;
        p p2 = d.k();
        while (p2 != null) {
            array[((q)p2.c()).d()] = n++;
            p2 = p2.a();
            if (x) {
                break;
            }
        }
    }
    
    private final void a(final int[] array, final int[] array2) {
        System.arraycopy(array, 0, array2, 0, array.length);
    }
    
    private final void b(final int[] array) {
        final boolean x = y.f.c.a.N.x;
        this.a(array, this.G);
        int i = 0;
        while (i < this.E.length) {
            this.b(this.E[i], this.G);
            ++i;
            if (x) {
                break;
            }
        }
    }
    
    private final void b(final D d, final int[] array) {
        final boolean x = y.f.c.a.N.x;
        p p2 = d.k();
        while (p2 != null) {
            final q q = (q)p2.c();
            this.l[array[q.d()]] = q;
            p2 = p2.a();
            if (x) {
                break;
            }
        }
        int n = 0;
        p p3 = d.k();
        while (p3 != null) {
            p3.a(this.l[n]);
            p3 = p3.a();
            ++n;
            if (x) {
                break;
            }
        }
    }
    
    private final void a(final D d, final int[] array, final Comparator comparator) {
        final boolean x = y.f.c.a.N.x;
        int n = 0;
        p p3 = d.k();
        while (true) {
            while (p3 != null) {
                this.l[n] = (q)p3.c();
                p3 = p3.a();
                ++n;
                if (x) {
                    p p4 = d.k();
                    while (p4 != null) {
                        final q q = this.l[n];
                        p4.a(q);
                        array[q.d()] = n;
                        p4 = p4.a();
                        ++n;
                        if (x) {
                            break;
                        }
                    }
                    return;
                }
                if (x) {
                    break;
                }
            }
            y.g.e.a(this.l, 0, d.size(), comparator);
            n = 0;
            continue;
        }
    }
    
    static float[] a(final bT bt) {
        return bt.j;
    }
    
    static boolean a(final bT bt, final q q) {
        return bt.a(q);
    }
}
