package y.f.c.a;

import y.f.*;
import y.g.*;
import y.c.*;
import y.a.*;
import java.util.*;

public class r implements bx
{
    private int e;
    private boolean f;
    private boolean g;
    private Comparator h;
    private long i;
    private byte j;
    private float[] k;
    private float[] l;
    private q[] m;
    private int[] n;
    private int[] o;
    private p[] p;
    private D q;
    private D r;
    private D s;
    private D t;
    private byte[] u;
    private byte[] v;
    private int[] w;
    private int[] x;
    private Comparator y;
    private Comparator z;
    private Comparator A;
    private Comparator B;
    private Comparator C;
    private Comparator D;
    private X E;
    private D[] F;
    private int[] G;
    private int[] H;
    int[] a;
    int[] b;
    Comparator c;
    private bR I;
    private E J;
    private aX[] K;
    final int[] d;
    
    public r() {
        this.e = 50;
        this.f = true;
        this.g = false;
        this.i = 10000L;
        this.j = 0;
        this.d = new int[4];
    }
    
    public void a(final long i) {
        this.i = i;
    }
    
    private cF a(final X x, final aU au, final aV av, final int[] array, final int[] array2) {
        this.u = new byte[x.h()];
        this.w = new int[x.h()];
        this.v = new byte[x.h()];
        this.x = new int[x.h()];
        return cF.a(x, au, av, array2, array, this.u, this.w, this.v, this.x, (byte)1, (byte)0);
    }
    
    private cF b(final X x, final aU au, final aV av, final int[] array, final int[] array2) {
        final boolean x2 = N.x;
        final cF a = this.a(x, au, av, array, array2);
        final e p5 = x.p();
        while (p5.f()) {
            final d a2 = p5.a();
            a(a2, this.u, this.v, array2);
            a(a2, this.v, this.u, array2);
            p5.g();
            if (x2) {
                break;
            }
        }
        return a;
    }
    
    private static void a(final d d, final byte[] array, final byte[] array2, final int[] array3) {
        final int b = d.b();
        if (Math.abs(array[b]) != 1) {
            return;
        }
        if (array3[d.d().d()] < 0) {
            final int b2 = ((d.h() == null) ? d.j() : d.h()).b();
            if (array2[b2] == -2) {
                array2[b] = (byte)(-array[b]);
                array2[b2] = array[b];
                array[b2] = (byte)(-array[b]);
            }
        }
    }
    
    private void a(final i i, final ar ar) {
        final boolean x = N.x;
        final x o = i.o();
        while (o.f()) {
            this.k[o.e().d()] = ar.nextInt();
            o.g();
            if (x) {
                return;
            }
            if (x) {
                break;
            }
        }
        i.a(new s(this), new t(this));
    }
    
    private int a() {
        final boolean x = N.x;
        this.a(this.E, this.C, this.D);
        int n = 0;
        int i = this.F.length - 1;
        int n2 = 0;
        while (i > 0) {
            n2 = n + this.a(this.F[i - 1], this.F[i]);
            if (x) {
                return n2;
            }
            n = n2;
            --i;
            if (x) {
                break;
            }
        }
        return n2;
    }
    
    private int a(final D d, final D d2) {
        final boolean x = N.x;
        p p2 = d.k();
        p p3 = d2.k();
        this.q.clear();
        this.r.clear();
        this.s.clear();
        this.t.clear();
        int n = 0;
        p p4 = null;
        Label_0136: {
            while (p2 != null) {
                p4 = p3;
                if (x || p4 == null) {
                    break Label_0136;
                }
                n = n + this.a((q)p2.c(), this.q, this.s, this.r) + this.b((q)p3.c(), this.r, this.t, this.q);
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
            n += this.a((q)p2.c(), this.q, this.s, this.r);
            p2 = p2.a();
            if (x) {
                return n2;
            }
            if (!x) {
                goto Label_0135;
            }
        }
        while (p3 != null) {
            n2 = n + this.b((q)p3.c(), this.r, this.t, this.q);
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
        final boolean x = N.x;
        final int n = this.H[q.d()];
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
            p4 = this.p[b = d8.b()];
            Label_0522: {
                Label_0515: {
                    if (p4.c() == null) {
                        Label_0173: {
                            if (this.G[d8.d().d()] < 0) {
                                d9 = ((d8.h() == null) ? d8.j() : d8.h());
                                p5 = this.p[d9.b()];
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
                            break Label_0515;
                        }
                    }
                    Label_0257: {
                        if (this.G[d8.d().d()] < 0) {
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
                    b3 = this.u[b];
                    p8 = p4.b();
                    while (true) {
                        while (p8 != null) {
                            n8 = this.H[(d11 = (d)p8.c()).c().d()];
                            n9 = n;
                            if (!x) {
                                if (n8 > n9 || (b3 != -2 && this.u[d11.b()] > b3)) {
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
        final boolean x = N.x;
        final int n = this.H[q.d()];
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
            p4 = this.p[b = d8.b()];
            Label_0518: {
                Label_0511: {
                    if (p4.c() == null) {
                        Label_0173: {
                            if (this.G[d8.c().d()] < 0) {
                                d9 = ((d8.g() == null) ? d8.i() : d8.g());
                                p5 = this.p[d9.b()];
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
                        b2 = (byte)(this.v[b] + 2);
                        ++d10[b2];
                        if (!x) {
                            break Label_0511;
                        }
                    }
                    Label_0257: {
                        if (this.G[d8.c().d()] < 0) {
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
                        if (this.x[b] > 0) {
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
                    b3 = this.v[b];
                    p8 = p4.b();
                    while (true) {
                        while (p8 != null) {
                            n8 = this.H[(d11 = (d)p8.c()).d().d()];
                            n9 = n;
                            if (!x) {
                                if (n8 > n9 || (b3 != -2 && this.v[d11.b()] > b3)) {
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
        return this.a(0, this.F.length - 1, array);
    }
    
    private byte a(final int n, final int n2, final int[] array) {
        final boolean x = N.x;
        byte b = 0;
        Label_0119: {
            if (n <= n2) {
                int n3 = 1;
                int n4 = 20;
            Label_0020:
                while (true) {
                    int n5 = n3;
                Label_0022:
                    while (n5 != 0 && --n4 > 0) {
                        n3 = 0;
                        int i = n;
                        while (i <= n2) {
                            final D d = this.F[i];
                            this.a(d, this.B, this.A);
                            final byte a = this.a(d, true, true, array);
                            final byte b3;
                            final byte b2 = (byte)(n5 = (b3 = (byte)(a & 0x4)));
                            if (x) {
                                continue Label_0022;
                            }
                            if (x) {
                                return b3;
                            }
                            n3 = ((b2 != 0) ? 1 : 0);
                            b |= a;
                            ++i;
                            if (x) {
                                break Label_0119;
                            }
                        }
                        continue Label_0020;
                    }
                    return b;
                }
            }
        }
        int n6 = 1;
        int n7 = 20;
    Label_0225:
        while (true) {
            int n8 = n6;
        Label_0128:
            while (n8 != 0 && --n7 > 0) {
                n6 = 0;
                int j = n;
                while (j >= n2) {
                    final D d2 = this.F[j];
                    this.a(d2, this.B, this.A);
                    final byte a2 = this.a(d2, true, true, array);
                    final byte b3;
                    final byte b4 = (byte)(n8 = (b3 = (byte)(a2 & 0x4)));
                    if (x) {
                        continue Label_0128;
                    }
                    if (x) {
                        return b3;
                    }
                    n6 = ((b4 != 0) ? 1 : 0);
                    b |= a2;
                    --j;
                    if (x) {
                        break Label_0225;
                    }
                }
                continue Label_0225;
            }
            break;
        }
        return b;
    }
    
    private byte a(final D d, final boolean b, final boolean b2, final int[] array) {
        return (byte)(this.b(d, b, b2, array) | this.c(d, b, b2, array));
    }
    
    private byte b(final D d, final boolean b, final boolean b2, final int[] array) {
        final boolean x = N.x;
        boolean b3 = false;
        boolean b4 = false;
        boolean b5 = false;
        p p4 = d.k();
        int i = 0;
        while (true) {
            while (i < d.size() - 1) {
                final p p5 = p4;
                p4 = p5.a();
                final q q = (q)p5.c();
                final q q2 = (q)p4.c();
                if (x) {
                    final int n = 0;
                    return (byte)(n | (b5 ? 2 : 0) | (b4 ? 1 : 0));
                }
                Label_0777: {
                    if (this.I != null) {
                        if (this.I.a(this.E, q, q2)) {
                            break Label_0777;
                        }
                    }
                    else if (this.a != null) {
                        final int n2 = this.a[q.d()];
                        final int n3 = this.a[q2.d()];
                        if (n2 >= 0 && n3 >= 0 && n2 != n3) {
                            break Label_0777;
                        }
                    }
                    if (this.J.k()) {
                        if (this.K[q2.d()] == null) {
                            break Label_0777;
                        }
                        if (this.K[q.d()] == null) {
                            break Label_0777;
                        }
                        if (this.K[q.d()].l() != this.K[q2.d()].l()) {
                            break Label_0777;
                        }
                        final byte b6 = this.K[q.d()].b();
                        final byte b7 = this.K[q2.d()].b();
                        if (b6 == 12 || b6 == 13 || b7 == 12) {
                            break Label_0777;
                        }
                        if (b7 == 13) {
                            break Label_0777;
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
                            b3 = true;
                            final int n4 = array[q.d()];
                            array[q.d()] = array[q2.d()];
                            array[q2.d()] = n4;
                            p4.a(q);
                            p5.a(q2);
                            b4 |= (q.c() > 0 || q2.c() > 0);
                            b5 |= (q.b() > 0 || q2.b() > 0);
                            this.a(q, b ? this.B : null, b2 ? this.A : null, true);
                            this.a(q2, b ? this.B : null, b2 ? this.A : null, false);
                            if (!x) {
                                break Label_0777;
                            }
                        }
                        final int a = this.a(q, q2, true, true, array);
                        final int a2 = this.a(q2, q, true, true, array);
                        if (a2 < a || (a2 == a && b && b2)) {
                            final int n5 = array[q.d()];
                            array[q.d()] = array[q2.d()];
                            array[q2.d()] = n5;
                            p4.a(q);
                            p5.a(q2);
                            b4 |= (q.c() > 0 || q2.c() > 0);
                            b5 |= (q.b() > 0 || q2.b() > 0);
                            this.a(q, b ? this.B : null, b2 ? this.A : null, true);
                            this.a(q2, b ? this.B : null, b2 ? this.A : null, false);
                        }
                    }
                }
                ++i;
                if (x) {
                    break;
                }
            }
            if (b3) {
                final int n = 4;
                return (byte)(n | (b5 ? 2 : 0) | (b4 ? 1 : 0));
            }
            continue;
        }
    }
    
    private byte c(final D d, final boolean b, final boolean b2, final int[] array) {
        final boolean x = N.x;
        boolean b3 = false;
        boolean b4 = false;
        boolean b5 = false;
        p p4 = d.l();
        int i = d.size() - 2;
        while (true) {
            while (i >= 0) {
                final p p5 = p4;
                p4 = p4.b();
                final q q = (q)p4.c();
                final q q2 = (q)p5.c();
                if (x) {
                    final int n = 0;
                    return (byte)(n | (b5 ? 2 : 0) | (b4 ? 1 : 0));
                }
                Label_0776: {
                    if (this.I != null) {
                        if (this.I.a(this.E, q, q2)) {
                            break Label_0776;
                        }
                    }
                    else if (this.a != null) {
                        final int n2 = this.a[q.d()];
                        final int n3 = this.a[q2.d()];
                        if (n2 >= 0 && n3 >= 0 && n2 != n3) {
                            break Label_0776;
                        }
                    }
                    if (this.J.k()) {
                        if (this.K[q2.d()] == null) {
                            break Label_0776;
                        }
                        if (this.K[q.d()] == null) {
                            break Label_0776;
                        }
                        if (this.K[q2.d()].l() != this.K[q.d()].l()) {
                            break Label_0776;
                        }
                        final byte b6 = this.K[q.d()].b();
                        final byte b7 = this.K[q2.d()].b();
                        if (b6 == 12 || b6 == 13 || b7 == 12) {
                            break Label_0776;
                        }
                        if (b7 == 13) {
                            break Label_0776;
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
                            b3 = true;
                            final int n4 = array[q.d()];
                            array[q.d()] = array[q2.d()];
                            array[q2.d()] = n4;
                            p5.a(q);
                            p4.a(q2);
                            b4 |= (q.c() > 0 || q2.c() > 0);
                            b5 |= (q.b() > 0 || q2.b() > 0);
                            this.a(q, b ? this.B : null, b2 ? this.A : null, true);
                            this.a(q2, b ? this.B : null, b2 ? this.A : null, false);
                            if (!x) {
                                break Label_0776;
                            }
                        }
                        final int a = this.a(q, q2, true, true, array);
                        final int a2 = this.a(q2, q, true, true, array);
                        if (a2 < a || (a2 == a && b && b2)) {
                            final int n5 = array[q.d()];
                            array[q.d()] = array[q2.d()];
                            array[q2.d()] = n5;
                            p5.a(q);
                            p4.a(q2);
                            b4 |= (q.c() > 0 || q2.c() > 0);
                            b5 |= (q.b() > 0 || q2.b() > 0);
                            this.a(q, b ? this.B : null, b2 ? this.A : null, true);
                            this.a(q2, b ? this.B : null, b2 ? this.A : null, false);
                        }
                    }
                }
                --i;
                if (x) {
                    break;
                }
            }
            if (b3) {
                final int n = 4;
                return (byte)(n | (b5 ? 2 : 0) | (b4 ? 1 : 0));
            }
            continue;
        }
    }
    
    private void a(final q q, final Comparator comparator, final Comparator comparator2, final boolean b) {
        final boolean x = N.x;
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
                                    this.E.a(d2, d2.g(), d, 1, 1);
                                    if (!x) {
                                        break Label_0101;
                                    }
                                }
                                this.E.a(d2, d2.i(), d, 0, 1);
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
                            this.E.a(h, d, h.h(), 1, 1);
                            if (!x) {
                                break Label_0198;
                            }
                        }
                        this.E.a(h, d, h.j(), 1, 0);
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
                            this.E.a(d4, d4.g(), d3, 1, 0);
                            if (!x) {
                                break Label_0300;
                            }
                        }
                        this.E.a(d4, d4.i(), d3, 0, 0);
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
                    this.E.a(f, d3, f.h(), 0, 1);
                    if (!x) {
                        break Label_0397;
                    }
                }
                this.E.a(f, d3, f.j(), 0, 0);
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
        final boolean x = N.x;
        int n = 0;
        final int n2 = array[q.d()];
        d d = q.g();
        int n3 = 0;
        while (d != null) {
            n3 = this.G[d.c().d()];
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
        final boolean x = N.x;
        int n = 0;
        final int n2 = array[q.d()];
        d d = q.f();
        int n3 = 0;
        while (d != null) {
            n3 = this.G[d.d().d()];
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
        final boolean x = N.x;
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
                            n3 = this.G[d.d().d()];
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
                    if (this.G[d.d().d()] < 0) {
                        final d d4 = (d.h() == null) ? d.j() : d.h();
                        final q c = d4.c();
                        if (c == q2) {
                            d = d.g();
                            if (!x) {
                                continue;
                            }
                        }
                        final boolean b = array[c.d()] < array[q.d()];
                        if (this.G[d2.d().d()] < 0) {
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
                                    final byte b2 = this.u[b3 = d4.b()];
                                    final int b5;
                                    final byte b4 = this.u[b5 = d5.b()];
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
                    if (this.G[d2.d().d()] < 0) {
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
                        final byte b6 = this.v[b7 = d.b()];
                        final int b9;
                        final byte b8 = this.v[b9 = d2.b()];
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
                        final int n10 = this.x[b7];
                        final int n11 = this.x[b9];
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
        final boolean x = N.x;
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
                            n3 = this.G[d.c().d()];
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
                    if (this.G[d.c().d()] < 0) {
                        final d d4 = (d.g() == null) ? d.i() : d.g();
                        final q d5 = d4.d();
                        if (d5 == q2) {
                            d = d.h();
                            if (!x) {
                                continue;
                            }
                        }
                        final boolean b = array[d5.d()] < array[q.d()];
                        if (this.G[d2.c().d()] < 0) {
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
                                    final byte b2 = this.v[b3 = d4.b()];
                                    final int b5;
                                    final byte b4 = this.v[b5 = d6.b()];
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
                                    final int n6 = this.x[b3];
                                    final int n7 = this.x[b5];
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
                    if (this.G[d2.c().d()] < 0) {
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
    
    public void a(final X e, final aU au, final aV av, final aP ap) {
        final boolean x = N.x;
        this.J = (E)e.c(N.w).b(e);
        this.I = (bR)e.c(N.v).b(e);
        this.F = new D[au.b()];
        int n = 0;
        final ArrayList list = new ArrayList<q>();
        int n2 = 0;
        final x o = e.o();
        while (true) {
        Label_0732_Outer:
            while (o.f()) {
                n2 += av.a(o.e()).e();
                o.g();
                if (x) {
                    if (this.J.k()) {
                        this.K = new aX[e.e() + n2 / 2];
                        final x o2 = e.o();
                        while (o2.f()) {
                            this.K[o2.e().d()] = av.a(o2.e());
                            o2.g();
                            if (x) {
                                break;
                            }
                        }
                    }
                    int n3 = 0;
                    while (true) {
                        do {
                            int i = 0;
                        Label_0254:
                            while (i < au.b()) {
                                this.F[n3] = new D();
                                int n4 = 0;
                                final D d;
                                final y y = (y)(d = au.a(n3).d());
                                if (x) {
                                    final D d2 = d;
                                    int j = e.g() - 1;
                                    while (true) {
                                    Label_2080_Outer:
                                        while (j >= 0) {
                                            this.p[j] = d2.a((Object)null);
                                            d2.g();
                                            --j;
                                            if (x) {
                                                final cF b = this.b(e, au, av, this.H, this.G);
                                                this.a(e, this.F, this.H);
                                                Label_1088: {
                                                    Label_1027: {
                                                        Label_0954: {
                                                            if (this.I != null) {
                                                                this.n = new int[e.f()];
                                                                this.o = new int[e.f()];
                                                                this.I.a(e, av, false);
                                                                this.I.a(e, this.o, this.n);
                                                                final Comparator a = this.I.a(e, this.F, this.H);
                                                                int k = 0;
                                                                while (k < this.F.length) {
                                                                    this.a(this.F[k], this.H, a);
                                                                    ++k;
                                                                    if (x) {
                                                                        break Label_1088;
                                                                    }
                                                                    if (x) {
                                                                        break Label_0954;
                                                                    }
                                                                }
                                                                break Label_1027;
                                                            }
                                                        }
                                                        if (this.a(e, this.F, av)) {
                                                            this.c = new cP(this.a);
                                                            int l = 0;
                                                            while (l < this.F.length) {
                                                                this.a(this.F[l], this.H, this.c);
                                                                ++l;
                                                                if (x) {
                                                                    break Label_1088;
                                                                }
                                                                if (x) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    this.E = e;
                                                    try {
                                                        this.y = b.b(false);
                                                        this.z = b.b(true);
                                                        this.A = b.c(true);
                                                        this.B = b.c(false);
                                                        this.C = this.y;
                                                        this.D = this.z;
                                                        final long currentTimeMillis = System.currentTimeMillis();
                                                        final ar ar = new ar(666L);
                                                        this.a(e, this.F, this.H, null);
                                                        this.J.a(this.F, this.H, true);
                                                        final int[] array = new int[this.H.length];
                                                        int a2 = this.a(ar);
                                                        this.a(this.H, array);
                                                        int n6 = 0;
                                                        Label_1613: {
                                                            if (System.currentTimeMillis() - currentTimeMillis < this.i && a2 > 0) {
                                                                int n5 = 0;
                                                                while (n5 < this.e) {
                                                                    n6 = a2;
                                                                    if (x) {
                                                                        break Label_1613;
                                                                    }
                                                                    if (n6 <= 0 || System.currentTimeMillis() - currentTimeMillis >= this.i) {
                                                                        break;
                                                                    }
                                                                    int a3 = 0;
                                                                    Label_1574: {
                                                                        Label_1550: {
                                                                            if ((n5 & 0x3) < 2) {
                                                                                this.a(e, this.F, this.H, ar);
                                                                                if (!x) {
                                                                                    break Label_1550;
                                                                                }
                                                                            }
                                                                        Label_1508:
                                                                            while (true) {
                                                                                Label_1505: {
                                                                                    Label_1297: {
                                                                                        if (this.a == null && this.I == null) {
                                                                                            a3 = 0;
                                                                                            while (a3 < this.k.length) {
                                                                                                this.k[a3] = ar.nextFloat();
                                                                                                ++a3;
                                                                                                if (x) {
                                                                                                    break Label_1508;
                                                                                                }
                                                                                                if (x) {
                                                                                                    break Label_1297;
                                                                                                }
                                                                                            }
                                                                                            break Label_1505;
                                                                                        }
                                                                                        break Label_1297;
                                                                                        while (a3 < this.F.length) {
                                                                                            this.a(this.F[a3], this.H, this.h);
                                                                                            ++a3;
                                                                                            if (x) {
                                                                                                break Label_1574;
                                                                                            }
                                                                                            if (x) {
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        break Label_1550;
                                                                                    }
                                                                                    if (this.a != null) {
                                                                                        a3 = 0;
                                                                                        do {
                                                                                            int n7 = 0;
                                                                                        Label_1309:
                                                                                            while (n7 < this.F.length) {
                                                                                                final D d3 = this.F[a3];
                                                                                                if (x) {
                                                                                                    continue Label_1508;
                                                                                                }
                                                                                                p p4 = d3.k();
                                                                                                while (p4 != null) {
                                                                                                    final int d4 = ((q)p4.c()).d();
                                                                                                    final int n8 = n7 = this.a[d4];
                                                                                                    if (x) {
                                                                                                        continue Label_1309;
                                                                                                    }
                                                                                                    Label_1429: {
                                                                                                        if (n7 < 0) {
                                                                                                            this.k[d4] = ar.nextFloat() * (this.b[a3] + 1) * 2.0f;
                                                                                                            if (!x) {
                                                                                                                break Label_1429;
                                                                                                            }
                                                                                                        }
                                                                                                        this.k[d4] = ar.nextFloat() + (n8 + 1) * 2;
                                                                                                    }
                                                                                                    p4 = p4.a();
                                                                                                    if (x) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                ++a3;
                                                                                            }
                                                                                            break Label_1505;
                                                                                        } while (!x);
                                                                                    }
                                                                                    a3 = 0;
                                                                                    while (a3 < this.k.length) {
                                                                                        this.k[a3] = ar.nextFloat() * this.n[a3] + this.o[a3];
                                                                                        ++a3;
                                                                                        if (x) {
                                                                                            continue Label_1508;
                                                                                        }
                                                                                        if (x) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                a3 = 0;
                                                                                continue Label_1508;
                                                                            }
                                                                        }
                                                                        this.J.a(this.F, this.H, true);
                                                                        a3 = this.a(ar);
                                                                    }
                                                                    if (a3 < a2) {
                                                                        this.a(this.H, array);
                                                                        a2 = a3;
                                                                    }
                                                                    ++n5;
                                                                    if (x) {
                                                                        break;
                                                                    }
                                                                }
                                                                this.b(array);
                                                            }
                                                            final boolean f = this.f;
                                                        }
                                                        if (n6 != 0) {
                                                            this.a(this.H);
                                                        }
                                                    }
                                                    finally {
                                                    Label_2080:
                                                        while (true) {
                                                            Label_2077: {
                                                                Label_2025: {
                                                                    if (this.I != null) {
                                                                        final Comparator a4 = this.I.a(e, this.F, this.H);
                                                                        int n9 = 0;
                                                                        while (true) {
                                                                            while (n9 < this.F.length) {
                                                                                this.a(this.F[n9], this.H, a4);
                                                                                ++n9;
                                                                                if (!x) {
                                                                                    if (x) {
                                                                                        break;
                                                                                    }
                                                                                    continue Label_0732_Outer;
                                                                                }
                                                                                else {
                                                                                    if (x) {
                                                                                        break Label_2025;
                                                                                    }
                                                                                    break Label_2077;
                                                                                }
                                                                            }
                                                                            this.I.b(e, av, false);
                                                                            continue Label_2080_Outer;
                                                                        }
                                                                    }
                                                                    break Label_2025;
                                                                    while (true) {
                                                                        int n10 = 0;
                                                                        while (n10 < list.size()) {
                                                                            e.a((q)list.get(n10));
                                                                            ++n10;
                                                                            if (!x) {
                                                                                if (x) {
                                                                                    break;
                                                                                }
                                                                                continue Label_0732_Outer;
                                                                            }
                                                                            else {}
                                                                        }
                                                                        this.E = null;
                                                                        this.H = null;
                                                                        this.G = null;
                                                                        this.s = null;
                                                                        this.t = null;
                                                                        this.q = null;
                                                                        this.r = null;
                                                                        this.k = null;
                                                                        this.p = null;
                                                                        this.l = null;
                                                                        this.m = null;
                                                                        this.u = null;
                                                                        this.v = null;
                                                                        this.h = null;
                                                                        this.w = null;
                                                                        this.x = null;
                                                                        this.y = null;
                                                                        this.z = null;
                                                                        this.A = null;
                                                                        this.B = null;
                                                                        this.C = null;
                                                                        this.D = null;
                                                                        this.c = null;
                                                                        this.a = null;
                                                                        continue;
                                                                    }
                                                                }
                                                                if (this.c != null) {
                                                                    int n10 = 0;
                                                                    while (n10 < this.F.length) {
                                                                        this.a(this.F[n10], this.H, this.c);
                                                                        ++n10;
                                                                        if (x) {
                                                                            continue Label_2080;
                                                                        }
                                                                        if (x) {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            int n10 = 0;
                                                            continue Label_2080;
                                                        }
                                                    }
                                                }
                                                Label_2626: {
                                                    if (this.F != null) {
                                                        int n11 = 0;
                                                        while (n11 < au.b()) {
                                                            au.a(n11).a(this.F[n11]);
                                                            ++n11;
                                                            if (x) {
                                                                break Label_2626;
                                                            }
                                                            if (x) {
                                                                break;
                                                            }
                                                        }
                                                        this.J.g(au);
                                                    }
                                                    this.F = null;
                                                    this.J = null;
                                                }
                                                if (y.c.i.g) {
                                                    N.x = !x;
                                                }
                                                return;
                                            }
                                            if (x) {
                                                break;
                                            }
                                        }
                                        this.l = new float[n + 2];
                                        this.h = new w(this.k);
                                        continue;
                                    }
                                }
                                p p5 = y.k();
                                while (p5 != null) {
                                    final q q = (q)p5.c();
                                    q q2 = null;
                                Label_0316:
                                    while (true) {
                                        q c = null;
                                        q2 = c;
                                        final aX a5 = av.a(q2);
                                        i = a5.e();
                                        if (x) {
                                            continue Label_0254;
                                        }
                                        if (i > 0) {
                                            p p6 = a5.d();
                                            while (p6 != null) {
                                                final d d5 = (d)p6.c();
                                                final A a6 = av.a(d5);
                                                c = d5.c();
                                                if (x) {
                                                    continue Label_0316;
                                                }
                                                if (c == q2) {
                                                    final q d6 = e.d();
                                                    list.add(d6);
                                                    Label_0523: {
                                                        if (a6.j()) {
                                                            ap.b(d6, q2, d5, false, true);
                                                            ap.a(d6, d5.d(), d5, false, true);
                                                            n = Math.max(n, d5.d().b());
                                                            if (!x) {
                                                                break Label_0523;
                                                            }
                                                        }
                                                        ap.a(q2, d6, d5, true, false);
                                                        ap.b(d5.d(), d6, d5, true, false);
                                                        n = Math.max(n, d5.d().c());
                                                    }
                                                    n = Math.max(2, n);
                                                    this.H[d6.d()] = -1;
                                                    this.G[d6.d()] = -(n3 + 1);
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
                                    n = Math.max(n, Math.max(q2.b(), q2.c()));
                                    this.F[n3].b(q2);
                                    this.H[q2.d()] = n4;
                                    this.G[q2.d()] = n3;
                                    ++n4;
                                    p5 = p5.a();
                                    if (x) {
                                        break;
                                    }
                                }
                                ++n3;
                            }
                            break;
                        } while (!x);
                        this.q = new D();
                        this.r = new D();
                        this.s = new D();
                        this.t = new D();
                        this.m = new q[e.f()];
                        this.k = new float[e.f()];
                        this.p = new p[e.g()];
                        D d = new D();
                        continue;
                    }
                }
                if (x) {
                    break;
                }
            }
            this.G = new int[e.e() + n2 / 2];
            this.H = new int[e.e() + n2 / 2];
            continue;
        }
    }
    
    private void a(final X x, final D[] array, final int[] array2) {
        final boolean x2 = N.x;
        final int[] array3 = new int[array2.length];
        final x o = x.o();
        do {
            Label_0017: {
                o.f();
            }
            int i = 0;
            Label_0024:
            while (i != 0) {
                final q e = o.e();
                int n = 0;
                final e j = e.j();
                while (j.f()) {
                    i = n;
                    if (x2) {
                        continue Label_0024;
                    }
                    if (i <= -3) {
                        break;
                    }
                    final d a = j.a();
                    final byte b = (a.c() == e) ? this.u[a.b()] : this.v[a.b()];
                    Label_0157: {
                        if (b == -1) {
                            n = ((n == 1) ? -3 : -1);
                            if (!x2) {
                                break Label_0157;
                            }
                        }
                        if (b == 1) {
                            n = ((n == -1) ? -3 : 1);
                        }
                    }
                    j.g();
                    if (x2) {
                        break;
                    }
                }
                array3[e.d()] = ((n < -1) ? 0 : n);
                o.g();
                continue Label_0017;
            }
            break;
        } while (!x2);
        final u u = new u(this, array3);
        int k = 0;
        while (k < array.length) {
            this.a(array[k], array2, u);
            ++k;
            if (x2) {
                break;
            }
        }
    }
    
    boolean a(final i i, final D[] array, final aV av) {
        final boolean x = N.x;
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
                    if (this.J != null && this.J.k()) {
                        this.J.a(array, a, this.b);
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
        final boolean x = N.x;
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
                final v v = new v(this, array3, array4, array);
                v.a(false);
                v.b(true);
                v.a(i, q);
                Label_0328: {
                    if (this.I != null) {
                        final Comparator a = this.I.a(i, array, array2);
                        int k = 0;
                        while (k < array.length) {
                            this.a(array[k], array2, a);
                            ++k;
                            if (x) {
                                break Label_0328;
                            }
                        }
                        return;
                    }
                }
                Label_0366: {
                    if (this.c != null) {
                        int l = 0;
                        while (l < array.length) {
                            this.a(array[l], array2, this.c);
                            ++l;
                            if (x) {
                                break Label_0366;
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
            i.a(new cX(this.v), new cX(this.u));
            continue;
        }
    }
    
    private int a(final ar ar) {
        final boolean x = N.x;
        y.a.a.a();
        boolean b = false;
        int n = Integer.MAX_VALUE;
        int a = Integer.MAX_VALUE;
        final int[] array = new int[this.H.length];
        int nextInt = ar.nextInt(2);
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
                a = this.a(nextInt, ar);
                Label_0115: {
                    if (a < n) {
                        n = a;
                        b = true;
                        this.a(this.H, array);
                        if (!x) {
                            break Label_0115;
                        }
                    }
                    if (a > n) {
                        ++i;
                        if (!x) {
                            break Label_0115;
                        }
                    }
                    ++n2;
                }
                nextInt = (nextInt + 1) % 2;
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
        final boolean x = N.x;
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
    
    private int a(final int n, final Random random) {
        final boolean x = N.x;
        int nextInt = 0;
        Label_0071: {
            if (n == 0) {
                nextInt = random.nextInt(this.F.length) / 2;
                if (!x) {
                    break Label_0071;
                }
            }
            if (n == 1) {
                nextInt = (this.F.length + random.nextInt(this.F.length)) / 2;
                if (!x) {
                    break Label_0071;
                }
            }
            if (n == 2) {
                nextInt = random.nextInt(this.F.length);
            }
        }
        this.J.a(nextInt);
        int i = nextInt - 1;
        while (true) {
            while (i >= 0) {
                this.b(this.F, i, this.H);
                --i;
                if (!x) {
                    if (x) {
                        break;
                    }
                    continue;
                }
                else {
                    while (i < this.F.length) {
                        this.a(this.F, i, this.H);
                        ++i;
                        if (x) {
                            return this.a();
                        }
                        if (x) {
                            break;
                        }
                    }
                    if (this.f && (!this.J.k() || this.g)) {
                        this.a(this.H);
                        return this.a();
                    }
                    return this.a();
                }
            }
            i = nextInt + 1;
            continue;
        }
    }
    
    void a(final D[] array, final int n, final int[] array2) {
        final boolean x = N.x;
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
                    final byte j = this.j;
                    if (x) {
                        Label_0400: {
                            if (j != 0) {
                                this.J.a(d2, n, this.k, array2, true);
                                if (!x) {
                                    break Label_0400;
                                }
                            }
                            this.a(d2, array2, this.h);
                        }
                        if (this.f && (!this.J.k() || this.g)) {
                            this.a(d2, this.B, null);
                            this.a(d2, true, false, array2);
                            this.a(d, (Comparator)null, this.z);
                        }
                        return;
                    }
                    Label_0124: {
                        switch (j) {
                            case 0: {
                                this.k[d3] = this.b(q, size2, false, size, array2);
                                if (x) {
                                    break Label_0124;
                                }
                                break;
                            }
                            case 1: {
                                this.k[d3] = this.a(q, size2, false, size, array2);
                                break;
                            }
                        }
                    }
                    final float[] k = this.k;
                    final int n3 = d3;
                    k[n3] += array2[d3] / (size * 200);
                    Label_0240: {
                        if (this.a != null) {
                            final int n4 = this.a[d3];
                            if (n4 < 0) {
                                this.k[d3] = 2.0f * this.k[d3] * (this.b[n] + 1);
                                if (!x) {
                                    break Label_0240;
                                }
                            }
                            final float[] i = this.k;
                            final int n5 = d3;
                            i[n5] += (n4 + 1) * ((size + 1) * 2);
                        }
                    }
                    if (n2 < this.k[d3]) {
                        n2 = this.k[d3];
                    }
                    p3 = p3.a();
                    if (x) {
                        break;
                    }
                }
                if (this.I != null) {
                    p p4 = d2.k();
                    while (p4 != null) {
                        final int d4 = ((q)p4.c()).d();
                        this.k[d4] = this.k[d4] / n2 * this.n[d4] + this.o[d4];
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
            this.J.k();
            continue Label_0389_Outer;
        }
    }
    
    void b(final D[] array, final int n, final int[] array2) {
        final boolean x = N.x;
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
                    final byte j = this.j;
                    if (x) {
                        Label_0400: {
                            if (j != 0) {
                                this.J.a(d2, n, this.k, array2, false);
                                if (!x) {
                                    break Label_0400;
                                }
                            }
                            this.a(d2, array2, this.h);
                        }
                        if (this.f && (!this.J.k() || this.g)) {
                            this.a(d2, (Comparator)null, this.A);
                            this.a(d2, false, true, array2);
                            this.a(d, this.y, null);
                        }
                        return;
                    }
                    Label_0124: {
                        switch (j) {
                            case 0: {
                                this.k[d3] = this.b(q, size2, true, size, array2);
                                if (x) {
                                    break Label_0124;
                                }
                                break;
                            }
                            case 1: {
                                this.k[d3] = this.a(q, size2, true, size, array2);
                                break;
                            }
                        }
                    }
                    final float[] k = this.k;
                    final int n3 = d3;
                    k[n3] += array2[d3] / (size * 200);
                    Label_0240: {
                        if (this.a != null) {
                            final int n4 = this.a[d3];
                            if (n4 < 0) {
                                this.k[d3] = 2.0f * this.k[d3] * (this.b[n] + 1);
                                if (!x) {
                                    break Label_0240;
                                }
                            }
                            final float[] i = this.k;
                            final int n5 = d3;
                            i[n5] += (n4 + 1) * ((size + 1) * 2);
                        }
                    }
                    if (n2 < this.k[d3]) {
                        n2 = this.k[d3];
                    }
                    p3 = p3.a();
                    if (x) {
                        break;
                    }
                }
                if (this.I != null) {
                    p p4 = d2.k();
                    while (p4 != null) {
                        final int d4 = ((q)p4.c()).d();
                        this.k[d4] = this.k[d4] / n2 * this.n[d4] + this.o[d4];
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
            this.J.k();
            continue Label_0389_Outer;
        }
    }
    
    private float a(final q q, final int n, final boolean b, final int n2, final int[] array) {
        final boolean x = N.x;
        int n3 = 0;
        r r = null;
        Label_0467: {
            int n5 = 0;
            Label_0442: {
                Label_0150: {
                    if (b) {
                        d d = q.f();
                        while (d != null) {
                            float n4 = array[d.d().d()];
                            r = this;
                            if (x) {
                                break Label_0467;
                            }
                            if (this.v != null) {
                                final int b2;
                                Label_0101: {
                                    switch (this.v[b2 = d.b()]) {
                                        case 1: {
                                            n4 += 0.3f;
                                            if (x) {
                                                break Label_0101;
                                            }
                                            break;
                                        }
                                        case -1: {
                                            n4 -= 0.3f;
                                            break;
                                        }
                                    }
                                }
                                n4 += this.x[b2] * 0.01f;
                            }
                            this.l[n3] = n4;
                            d = d.g();
                            ++n3;
                            if (x) {
                                break Label_0150;
                            }
                        }
                        break Label_0442;
                    }
                }
                d d2 = q.g();
                while (d2 != null) {
                    final int d3 = d2.c().d();
                    n5 = this.G[d3];
                    if (x) {
                        break;
                    }
                    Label_0427: {
                        if (n5 < 0) {
                            float n6 = array[((d2.g() == null) ? d2.i().d() : d2.g().d()).d()];
                            if (this.u != null) {
                                final int b3;
                                Label_0285: {
                                    switch (this.u[b3 = d2.b()]) {
                                        case 1: {
                                            n6 += 0.3f;
                                            if (x) {
                                                break Label_0285;
                                            }
                                            break;
                                        }
                                        case -1: {
                                            n6 -= 0.3f;
                                            break;
                                        }
                                    }
                                }
                                n6 += this.w[b3] * 0.01f;
                            }
                            this.l[n3] = n6;
                            if (!x) {
                                break Label_0427;
                            }
                        }
                        float n7 = array[d3];
                        if (this.u != null) {
                            final int b4;
                            Label_0393: {
                                switch (this.u[b4 = d2.b()]) {
                                    case 1: {
                                        n7 += 0.3f;
                                        if (x) {
                                            break Label_0393;
                                        }
                                        break;
                                    }
                                    case -1: {
                                        n7 -= 0.3f;
                                        break;
                                    }
                                }
                            }
                            n7 += this.w[b4] * 0.01f;
                        }
                        this.l[n3] = n7;
                    }
                    d2 = d2.h();
                    ++n3;
                    if (x) {
                        break;
                    }
                }
            }
            if (n5 == 0) {
                return (n2 - 1) * array[q.d()] / (n - 1);
            }
            r = this;
        }
        Arrays.sort(r.l, 0, n3);
        final int n8 = n3 >> 1;
        if (n3 % 2 == 1) {
            return this.l[n8];
        }
        if (n3 == 2) {
            return (this.l[0] + this.l[1]) * 0.5f;
        }
        final float n9 = this.l[n8 - 1] - this.l[0];
        final float n10 = this.l[n3 - 1] - this.l[n8];
        if (n9 != 0.0f || n10 != 0.0f) {
            return (this.l[n8 - 1] * n10 + this.l[n8] * n9) / (n9 + n10);
        }
        return (this.l[n8 - 1] + this.l[n8]) * 0.5f;
    }
    
    private float b(final q q, final int n, final boolean b, final int n2, final int[] array) {
        final boolean x = N.x;
        float n3 = 0.0f;
        final int n4 = b ? q.c() : q.b();
        if (n4 == 0) {
            n3 = (n2 - 1) * array[q.d()] / (n - 1);
            if (!x) {
                return n3;
            }
        }
        Label_0346: {
            if (b) {
                d d = q.f();
                while (d != null) {
                    final int d2 = d.d().d();
                    if (x) {
                        return n3;
                    }
                    Label_0334: {
                        if (this.G[d2] < 0) {
                            final d d3 = (d.h() == null) ? d.j() : d.h();
                            n3 += (n2 - 1) * array[d3.c().d()] / (n - 1);
                            if (this.u == null) {
                                break Label_0334;
                            }
                            final int b2;
                            Label_0209: {
                                switch (this.u[b2 = d3.b()]) {
                                    case 1: {
                                        n3 -= 0.3f;
                                        if (x) {
                                            break Label_0209;
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
                                break Label_0334;
                            }
                        }
                        n3 += array[d2];
                        if (this.v != null) {
                            final int b3;
                            Label_0309: {
                                switch (this.v[b3 = d.b()]) {
                                    case 1: {
                                        n3 += 0.3f;
                                        if (x) {
                                            break Label_0309;
                                        }
                                        break;
                                    }
                                    case -1: {
                                        n3 -= 0.3f;
                                        break;
                                    }
                                }
                            }
                            n3 += this.x[b3] * 0.01f;
                        }
                    }
                    d = d.g();
                    if (x) {
                        break Label_0346;
                    }
                }
                return n3 / n4;
            }
        }
        d d4 = q.g();
        while (d4 != null) {
            final int d5 = d4.c().d();
            if (x) {
                return n3;
            }
            Label_0622: {
                if (this.G[d5] < 0) {
                    final d d6 = (d4.g() == null) ? d4.i() : d4.g();
                    n3 += (n2 - 1) * array[d6.d().d()] / (n - 1);
                    if (this.v == null) {
                        break Label_0622;
                    }
                    final int b4;
                    Label_0497: {
                        switch (this.v[b4 = d6.b()]) {
                            case 1: {
                                n3 -= 0.3f;
                                if (x) {
                                    break Label_0497;
                                }
                                break;
                            }
                            case -1: {
                                n3 += 0.3f;
                                break;
                            }
                        }
                    }
                    n3 -= this.x[b4] * 0.01f;
                    if (!x) {
                        break Label_0622;
                    }
                }
                n3 += array[d5];
                if (this.u != null) {
                    final int b5;
                    Label_0597: {
                        switch (this.u[b5 = d4.b()]) {
                            case 1: {
                                n3 += 0.3f;
                                if (x) {
                                    break Label_0597;
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
            }
            d4 = d4.h();
            if (x) {
                break;
            }
        }
        n3 /= n4;
        return n3;
    }
    
    private final void a(final D d, final int[] array) {
        final boolean x = N.x;
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
        final boolean x = N.x;
        this.a(array, this.H);
        int i = 0;
        while (i < this.F.length) {
            this.b(this.F[i], this.H);
            ++i;
            if (x) {
                break;
            }
        }
    }
    
    private final void b(final D d, final int[] array) {
        final boolean x = N.x;
        p p2 = d.k();
        while (p2 != null) {
            final q q = (q)p2.c();
            this.m[array[q.d()]] = q;
            p2 = p2.a();
            if (x) {
                break;
            }
        }
        int n = 0;
        p p3 = d.k();
        while (p3 != null) {
            p3.a(this.m[n]);
            p3 = p3.a();
            ++n;
            if (x) {
                break;
            }
        }
    }
    
    private final void a(final D d, final int[] array, final Comparator comparator) {
        final boolean x = N.x;
        int n = 0;
        p p3 = d.k();
        while (true) {
            while (p3 != null) {
                this.m[n] = (q)p3.c();
                p3 = p3.a();
                ++n;
                if (x) {
                    p p4 = d.k();
                    while (p4 != null) {
                        final q q = this.m[n];
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
            y.g.e.a(this.m, 0, d.size(), comparator);
            n = 0;
            continue;
        }
    }
    
    static float[] a(final r r) {
        return r.k;
    }
}
