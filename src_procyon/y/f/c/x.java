package y.f.c;

import y.d.*;
import y.c.*;
import y.f.i.*;
import java.util.*;
import y.f.*;

class x
{
    private static y a;
    private X b;
    private A c;
    private A d;
    private h e;
    private A f;
    private c g;
    private h h;
    private c i;
    private boolean j;
    private boolean k;
    private boolean l;
    private D m;
    private boolean n;
    private double o;
    private double p;
    private ap q;
    private am r;
    private az s;
    private A t;
    private A u;
    private A v;
    private A w;
    private A x;
    private c y;
    private c z;
    private h A;
    private h B;
    private Map C;
    private h D;
    private h E;
    private A F;
    private A G;
    private h H;
    private h I;
    private D J;
    private boolean K;
    private boolean L;
    private static final aE M;
    private static final aE N;
    private double O;
    private double P;
    
    public x(final X b, final A c, final A d, final h e, final D j) {
        this.j = true;
        this.n = false;
        this.o = 20.0;
        this.p = 0.5;
        this.K = false;
        this.L = true;
        this.b = b;
        this.J = j;
        this.c = c;
        this.d = d;
        this.e = e;
        this.F = y.f.c.K.a((i)b);
        this.k = (b.c(aF.a) != null || b.c(aF.b) != null);
        this.l = (b.c(aF.c) != null || b.c(aF.d) != null);
        if (this.k || this.l) {
            this.g();
        }
        if (this.l) {
            this.D = b.u();
            this.E = b.u();
            this.s = new az(b, c, j, d, this.D, this.E, this.A, this.B);
        }
        (this.q = new ap(b, this.F, c, j, d, e, this.A, this.B)).a(this.L);
        this.r = new am(b, this);
    }
    
    public void a(final boolean k) {
        this.K = k;
    }
    
    public void b(final boolean l) {
        this.L = l;
        this.q.a(l);
    }
    
    public void a(final A f, final c g, final h h, final c i) {
        this.f = f;
        this.h = h;
        this.g = g;
        this.i = i;
        if (this.s != null) {
            this.s.a(f, g, h, i);
        }
        if (this.q != null) {
            this.q.a(f, g, h, i);
        }
    }
    
    public void a(final double o) {
        this.o = o;
        this.q.a(o);
        this.r.a(o);
    }
    
    public double a() {
        return this.o;
    }
    
    public void c(final boolean n) {
        this.n = n;
    }
    
    public void b() {
        final boolean i = y.f.c.a.i;
        Label_0118: {
            Label_0111: {
                if (this.k) {
                    final e p = this.b.p();
                    while (p.f()) {
                        final d a = p.a();
                        final aE a2 = this.a(a);
                        if (i) {
                            return;
                        }
                        if (a2 == null || !a2.a()) {
                            this.b.a(a, y.d.t.c);
                        }
                        final aE b = this.b(a);
                        if (b == null || !b.a()) {
                            this.b.b(a, y.d.t.c);
                        }
                        p.g();
                        if (i) {
                            break Label_0111;
                        }
                    }
                    break Label_0118;
                }
            }
            ae.c(this.b);
        }
        this.r.a();
    }
    
    public int a(final int n, final f f) {
        final boolean i = y.f.c.a.i;
        x x = null;
        Label_0144: {
            if (this.k) {
                p p2 = f.k();
                while (p2 != null) {
                    final d d = (d)p2.c();
                    final t n2 = this.b.n(d);
                    this.b.a(d, this.b.o(d));
                    this.b.b(d, n2);
                    x = this;
                    if (i) {
                        break Label_0144;
                    }
                    if (this.A != null && this.B != null) {
                        this.A.a(d, this.z.b(d));
                        this.B.a(d, this.y.b(d));
                    }
                    p2 = p2.a();
                    if (i) {
                        break;
                    }
                }
            }
            x = this;
        }
        x.q.b();
        return n;
    }
    
    public int a(int d) {
        if (this.s != null) {
            d = this.d(d);
        }
        return d;
    }
    
    public int b(final int n) {
        this.i();
        return n;
    }
    
    public int c(int a) {
        a = this.q.a(a);
        return a;
    }
    
    public y.c.y[] a(final y.c.y[] array) {
        final D d = new D(array);
        this.q.a(d);
        this.r.b();
        this.r.d();
        this.r.a();
        return (y.c.y[])d.toArray(new y.c.y[d.size()]);
    }
    
    public y.c.y[] b(final y.c.y[] array) {
        final D d = new D(array);
        this.i();
        this.q.b(d);
        if (this.s != null) {
            this.s.b(d);
        }
        this.j();
        this.a(d);
        return (y.c.y[])d.toArray(new y.c.y[d.size()]);
    }
    
    public y.c.y[] c(final y.c.y[] array) {
        return array;
    }
    
    public void d(final y.c.y[] array) {
        this.l();
        this.k();
    }
    
    public void c() {
    }
    
    public void d() {
        if (this.s != null && this.s.a()) {
            this.s.b();
        }
    }
    
    public void e() {
        if (this.q != null) {
            this.q.e();
            this.q = null;
        }
        if (this.r != null) {
            this.r.c();
            this.r = null;
        }
        if (this.s != null) {
            this.s.c();
            this.b.a(this.D);
            this.b.a(this.E);
            final h h = null;
            this.E = h;
            this.D = h;
            this.s = null;
        }
        if (this.x != null) {
            this.b.a(this.x);
            this.x = null;
        }
        this.h();
        this.c = null;
        this.J = null;
        this.G = null;
        this.x = null;
        this.H = null;
        this.I = null;
        this.m = null;
        this.b = null;
        this.F = null;
        this.h = null;
        this.i = null;
        this.f = null;
        this.g = null;
    }
    
    private int d(final int n) {
        final boolean i = y.f.c.a.i;
        final c c = this.b.c(aF.c);
        final c c2 = this.b.c(aF.d);
        final e p = this.b.p();
        while (true) {
            while (p.f()) {
                final d a = p.a();
                final int d = this.e.d(a) ? 1 : 0;
                if (!i) {
                    Label_0171: {
                        if (d != 0) {
                            if (c != null) {
                                this.E.a(a, c.b(a));
                            }
                            if (c2 == null) {
                                break Label_0171;
                            }
                            this.D.a(a, c2.b(a));
                            if (!i) {
                                break Label_0171;
                            }
                        }
                        if (c != null) {
                            this.D.a(a, c.b(a));
                        }
                        if (c2 != null) {
                            this.E.a(a, c2.b(a));
                        }
                    }
                    p.g();
                    if (i) {
                        break;
                    }
                    continue;
                }
                else {
                    final y.c.y[] array = new y.c.y[d];
                    int j = array.length - 1;
                    while (j >= 0) {
                        array[j] = new y.c.y();
                        --j;
                        if (i) {
                            break;
                        }
                    }
                    final y.c.x o = this.b.o();
                    while (o.f()) {
                        final q e = o.e();
                        array[this.c.a(e)].add(e);
                        o.g();
                        if (i) {
                            return array.length;
                        }
                        if (i) {
                            break;
                        }
                    }
                    if (this.s != null) {
                        final D d2 = new D(array);
                        this.s.a(d2);
                        return d2.size();
                    }
                    return array.length;
                }
            }
            continue;
        }
    }
    
    private void g() {
        final boolean i = y.f.c.a.i;
        if (this.A == null) {
            this.A = this.b.u();
        }
        if (this.B == null) {
            this.B = this.b.u();
        }
        this.y = this.b.c(aF.a);
        this.z = this.b.c(aF.b);
        this.b.a(aF.a, this.A);
        this.b.a(aF.b, this.B);
        if (this.y != null || this.z != null) {
            final e p = this.b.p();
            while (p.f()) {
                final d a = p.a();
                if (this.y != null) {
                    this.A.a(a, this.y.b(a));
                }
                if (this.z != null) {
                    this.B.a(a, this.z.b(a));
                }
                p.g();
                if (i) {
                    break;
                }
            }
        }
    }
    
    private void h() {
        this.b.d_(aF.a);
        if (this.y != null) {
            this.b.a(aF.a, this.y);
            this.y = null;
        }
        this.b.d_(aF.b);
        if (this.z != null) {
            this.b.a(aF.b, this.z);
            this.z = null;
        }
        if (this.A != null) {
            this.b.a(this.A);
            this.A = null;
        }
        if (this.B != null) {
            this.b.a(this.B);
            this.B = null;
        }
    }
    
    private void i() {
        final boolean i = y.f.c.a.i;
        if (!this.k) {
            return;
        }
        final e p = this.b.p();
        while (p.f()) {
            final d a = p.a();
            final boolean b = this.d.b(a.c()) != null;
            final boolean b2 = this.d.b(a.d()) != null;
            Label_0209: {
                if (b && !b2) {
                    final d d = (d)this.d.b(a.c());
                    if (this.B.b(a) != null) {
                        break Label_0209;
                    }
                    this.B.a(a, this.B.b(d));
                    if (!i) {
                        break Label_0209;
                    }
                }
                if (!b && b2) {
                    final d d2 = (d)this.d.b(a.d());
                    if (this.A.b(a) == null) {
                        this.A.a(a, this.A.b(d2));
                    }
                }
            }
            p.g();
            if (i) {
                break;
            }
        }
    }
    
    private void a(final D d) {
        final boolean i = y.f.c.a.i;
        this.x = this.b.t();
        this.G = this.b.t();
        this.H = this.b.u();
        this.I = this.b.u();
        final f f = new f();
        final f f2 = new f();
        this.m = new D();
        final A t = this.b.t();
        p p = d.k();
    Label_0163_Outer:
        while (p != null) {
            final y.c.y y = (y.c.y)p.c();
            int n = 0;
            p p2 = y.k();
            while (true) {
                while (p2 != null) {
                    t.a(p2.c(), (double)n);
                    p2 = p2.a();
                    ++n;
                    if (!i) {
                        if (i) {
                            break;
                        }
                        continue Label_0163_Outer;
                    }
                    else {
                        if (i) {
                            break Label_0163_Outer;
                        }
                        continue Label_0163_Outer;
                    }
                }
                p = p.a();
                continue;
            }
        }
        final aG ag = new aG(t, (byte)0);
        final aG ag2 = new aG(t, (byte)1);
        final B b = new B(this, ag, new aG(t, (byte)3));
        final y.f.c.A a = new y.f.c.A(this, ag2, new aG(t, (byte)4));
        int n2 = 0;
        p p3 = d.k();
        while (p3 != null) {
            p3.c();
        Label_3997:
            while (true) {
                Object b2 = null;
                final y.c.y y2 = (y.c.y)b2;
                final C c = new C(y2);
                this.m.add(c);
            Label_0280:
                while (!i) {
                    p p4 = y2.k();
                    q q;
                    y.f.am a2;
                    y y3;
                    int n3 = 0;
                    int n4 = 0;
                    d d2;
                    aE b3;
                    d g;
                    aE b4;
                    d d3;
                    aE b5;
                    aE ae2;
                    aE ae;
                    int n5;
                    d h;
                    int n6;
                    d h2;
                    int compare = 0;
                    int n7;
                    d d4;
                    d d5;
                    aE a3;
                    d f3;
                    aE a4;
                    d d6;
                    aE a5;
                    aE ae3;
                    int n8;
                    d g2;
                    int n9;
                    d g3;
                    int compare2;
                    d d7;
                    double c2 = 0.0;
                    aE ae4;
                    d d8;
                    aE ae5;
                    boolean k;
                    int n10;
                    aE a6;
                    d d9;
                    aE ae6 = null;
                    int n11;
                    int n12 = 0;
                    aE ae7;
                    d d10;
                    aE ae8;
                    boolean j;
                    int n13;
                    aE b6;
                    d d11;
                    aE ae9 = null;
                    int n14;
                    int n15 = 0;
                    y y4 = null;
                    y y5;
                    int n16;
                    boolean b7 = false;
                    double a7;
                    int l;
                    z a8;
                    z c3;
                    z a9;
                    z a10;
                    z c4;
                    z c5;
                    z b8;
                    z b9;
                    z b10;
                    int n17;
                    double d12;
                    double a11;
                    double a12;
                    z z;
                    z z2;
                    z z3;
                    double m;
                    int n18;
                    z z4;
                    z z5;
                    z z6;
                    double j2;
                    z z7;
                    z z8;
                    z z9;
                    double j3;
                    double n19;
                    double g4;
                    double n20;
                    double g5;
                    double[] array = null;
                    int n21;
                    z a13;
                    z a14;
                    z a15;
                    z c6;
                    z c7;
                    z c8;
                    z b11;
                    z b12;
                    z b13;
                    ar ar;
                    ar ar2;
                    Object b14;
                    double n22 = 0.0;
                    double n23 = 0.0;
                    p p5 = null;
                    d d13 = null;
                    q q2 = null;
                    q q4;
                    q q3 = null;
                    q q6;
                    q q5 = null;
                    Label_3519_Outer:Label_3732_Outer:
                    while (p4 != null) {
                        q = (q)p4.c();
                        b2 = this.x.b(q);
                        if (i) {
                            continue Label_3997;
                        }
                        Label_3985: {
                            if (b2 == null) {
                                a2 = this.b.a((Object)q);
                                c.f = Math.max(c.f, a2.getHeight());
                                if (this.d.b(q) == null) {
                                    y3 = new y(a2);
                                    this.G.a(q, y3);
                                    q.b(b);
                                    q.a(a);
                                    q.b();
                                Label_2708_Outer:
                                    while (true) {
                                        Label_0958: {
                                            Label_0688: {
                                                if (n3 > n4) {
                                                    d2 = q.i();
                                                    b3 = this.b(d2);
                                                    g = q.g();
                                                    b4 = this.b(g);
                                                    if ((b3 == null || !b3.a()) && b4 != null && b4.a()) {
                                                        d3 = d2.j();
                                                        while (d3 != null) {
                                                            b5 = this.b(d3);
                                                            ae = (ae2 = b5);
                                                            if (i) {
                                                                continue Label_3997;
                                                            }
                                                            if (ae != null && b5.a()) {
                                                                break;
                                                            }
                                                            d2 = d3;
                                                            d3 = d3.j();
                                                            if (i) {
                                                                break;
                                                            }
                                                        }
                                                        while (d2 != null) {
                                                            n5 = 0;
                                                            h = g;
                                                            n6 = 0;
                                                            h2 = g;
                                                            while (h2 != d2) {
                                                                n7 = (compare = ag2.compare(h2, d2));
                                                                if (i) {
                                                                    break Label_0688;
                                                                }
                                                                Label_0618: {
                                                                    if (compare < 0) {
                                                                        if (--n5 >= n6) {
                                                                            break Label_0618;
                                                                        }
                                                                        n6 = n5;
                                                                        h = h2.h();
                                                                        if (!i) {
                                                                            break Label_0618;
                                                                        }
                                                                    }
                                                                    if (n7 > 0) {
                                                                        ++n5;
                                                                    }
                                                                }
                                                                h2 = h2.h();
                                                                if (i) {
                                                                    break;
                                                                }
                                                            }
                                                            d4 = d2;
                                                            d2 = d2.h();
                                                            if (h != d4) {
                                                                this.b.a(d4, d4.c(), d4.i(), 0, q, h, 1);
                                                                if (i) {
                                                                    break Label_0958;
                                                                }
                                                                if (i) {
                                                                    break;
                                                                }
                                                                continue Label_2708_Outer;
                                                            }
                                                        }
                                                    }
                                                }
                                                q.c();
                                            }
                                            if (compare > 1) {
                                                d5 = q.h();
                                                a3 = this.a(d5);
                                                f3 = q.f();
                                                a4 = this.a(f3);
                                                if ((a3 == null || !a3.a()) && a4 != null && a4.a()) {
                                                    d6 = d5.i();
                                                    while (d6 != null) {
                                                        a5 = this.a(d6);
                                                        ae3 = (ae2 = a5);
                                                        if (i) {
                                                            continue Label_3997;
                                                        }
                                                        if (ae3 != null && a5.a()) {
                                                            break;
                                                        }
                                                        d5 = d6;
                                                        d6 = d6.i();
                                                        if (i) {
                                                            break;
                                                        }
                                                    }
                                                    while (d5 != null) {
                                                        n8 = 0;
                                                        g2 = f3;
                                                        n9 = 0;
                                                        g3 = f3;
                                                        while (g3 != d5) {
                                                            compare2 = ag.compare(g3, d5);
                                                            if (i) {
                                                                continue Label_0280;
                                                            }
                                                            Label_0885: {
                                                                if (compare2 < 0) {
                                                                    if (--n8 >= n9) {
                                                                        break Label_0885;
                                                                    }
                                                                    n9 = n8;
                                                                    g2 = g3.g();
                                                                    if (!i) {
                                                                        break Label_0885;
                                                                    }
                                                                }
                                                                if (compare2 > 0) {
                                                                    ++n8;
                                                                }
                                                            }
                                                            g3 = g3.g();
                                                            if (i) {
                                                                break;
                                                            }
                                                        }
                                                        d7 = d5;
                                                        d5 = d5.g();
                                                        if (g2 != d7) {
                                                            this.b.a(d7, q, g2, 1, d7.d(), d7.j(), 0);
                                                            if (i) {
                                                                break Label_0958;
                                                            }
                                                            if (i) {
                                                                break;
                                                            }
                                                            continue Label_2708_Outer;
                                                        }
                                                    }
                                                }
                                            }
                                            f.clear();
                                            f2.clear();
                                        }
                                        c2 = t.c(q);
                                        ae4 = null;
                                        d8 = q.f();
                                        while (d8 != null) {
                                            ae5 = this.a(d8);
                                            k = this.K;
                                            if (i) {
                                                continue Label_0280;
                                            }
                                            Label_1236: {
                                                if (k && (ae5 == null || ae5.g())) {
                                                    n10 = (((ae4 != null) ? a(ae4.b(), 2) : 2) + 3) % 4;
                                                    a6 = null;
                                                    d9 = d8.g();
                                                    Label_1088: {
                                                        while (d9 != null) {
                                                            ae6 = a6;
                                                            if (i || ae6 != null) {
                                                                break Label_1088;
                                                            }
                                                            a6 = this.a(d9);
                                                            d9 = d9.g();
                                                            if (i) {
                                                                goto Label_1086;
                                                            }
                                                        }
                                                        goto Label_1086;
                                                    }
                                                    n11 = (((ae6 != null) ? a(a6.b(), 1) : 1) + 3) % 4;
                                                    Label_1165: {
                                                        if (n10 >= 1 && n11 <= 1) {
                                                            n12 = 1;
                                                            if (!i) {
                                                                break Label_1165;
                                                            }
                                                        }
                                                        if (n10 > 1 && n11 > 1) {
                                                            n12 = Math.min(n10, n11);
                                                            if (!i) {
                                                                break Label_1165;
                                                            }
                                                        }
                                                        n12 = Math.max(n10, n11);
                                                    }
                                                    while (true) {
                                                        Label_1207: {
                                                            switch (n12) {
                                                                case 0: {
                                                                    ae5 = aE.a((byte)4);
                                                                    if (i) {
                                                                        break Label_1207;
                                                                    }
                                                                    break Label_1236;
                                                                }
                                                                case 1: {
                                                                    ae5 = aE.a((byte)2);
                                                                    if (i) {
                                                                        break;
                                                                    }
                                                                    break Label_1236;
                                                                }
                                                                case 3: {
                                                                    ae5 = aE.a((byte)1);
                                                                    break Label_1236;
                                                                }
                                                            }
                                                        }
                                                        ae5 = aE.a((byte)8);
                                                        if (i) {
                                                            continue Label_2708_Outer;
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                            ae4 = ae5;
                                            Label_1381: {
                                                if (ae5 == null || ae5.g() || ae5.d()) {
                                                    y3.c(2).l.a(d8);
                                                    if (!i) {
                                                        break Label_1381;
                                                    }
                                                }
                                                if (ae5.e()) {
                                                    y3.b(1).l.add(d8);
                                                    f2.a(d8);
                                                    if (!i) {
                                                        break Label_1381;
                                                    }
                                                }
                                                if (ae5.f()) {
                                                    y3.a(3).l.a(d8);
                                                    f.add(d8);
                                                    if (!i) {
                                                        break Label_1381;
                                                    }
                                                }
                                                if (ae5.c()) {
                                                    y3.a(0).l.a(d8);
                                                    f.add(d8);
                                                }
                                            }
                                            d8 = d8.g();
                                            if (i) {
                                                break;
                                            }
                                        }
                                        ae7 = null;
                                        d10 = q.g();
                                        while (d10 != null) {
                                            ae8 = this.b(d10);
                                            j = this.K;
                                            if (i) {
                                                continue Label_0280;
                                            }
                                            Label_1660: {
                                                if (j && (ae8 == null || ae8.g())) {
                                                    n13 = (((ae7 != null) ? a(ae7.b(), 2) : 2) + 2) % 4;
                                                    b6 = null;
                                                    d11 = d10.h();
                                                    Label_1512: {
                                                        while (d11 != null) {
                                                            ae9 = b6;
                                                            if (i || ae9 != null) {
                                                                break Label_1512;
                                                            }
                                                            b6 = this.b(d11);
                                                            d11 = d11.h();
                                                            if (i) {
                                                                goto Label_1510;
                                                            }
                                                        }
                                                        goto Label_1510;
                                                    }
                                                    n14 = (((ae9 != null) ? a(b6.b(), 1) : 1) + 2) % 4;
                                                    Label_1589: {
                                                        if (n13 <= 2 && n14 >= 2) {
                                                            n15 = 2;
                                                            if (!i) {
                                                                break Label_1589;
                                                            }
                                                        }
                                                        if (n13 > 2 && n14 > 2) {
                                                            n15 = Math.min(n13, n14);
                                                            if (!i) {
                                                                break Label_1589;
                                                            }
                                                        }
                                                        n15 = Math.max(n13, n14);
                                                    }
                                                    while (true) {
                                                        Label_1631: {
                                                            switch (n15) {
                                                                case 0: {
                                                                    ae8 = aE.a((byte)2);
                                                                    if (i) {
                                                                        break Label_1631;
                                                                    }
                                                                    break Label_1660;
                                                                }
                                                                case 1: {
                                                                    ae8 = aE.a((byte)8);
                                                                    if (i) {
                                                                        break;
                                                                    }
                                                                    break Label_1660;
                                                                }
                                                                case 3: {
                                                                    ae8 = aE.a((byte)4);
                                                                    break Label_1660;
                                                                }
                                                            }
                                                        }
                                                        ae8 = aE.a((byte)1);
                                                        if (i) {
                                                            continue Label_2708_Outer;
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                            ae7 = ae8;
                                            Label_1805: {
                                                if (ae8 == null || ae8.c() || ae8.g()) {
                                                    y3.c(0).l.add(d10);
                                                    if (!i) {
                                                        break Label_1805;
                                                    }
                                                }
                                                if (ae8.e()) {
                                                    y3.a(1).l.add(d10);
                                                    f2.a(d10);
                                                    if (!i) {
                                                        break Label_1805;
                                                    }
                                                }
                                                if (ae8.f()) {
                                                    y3.b(3).l.a(d10);
                                                    f.add(d10);
                                                    if (!i) {
                                                        break Label_1805;
                                                    }
                                                }
                                                if (ae8.d()) {
                                                    y3.b(2).l.a(d10);
                                                    f.add(d10);
                                                }
                                            }
                                            d10 = d10.h();
                                            if (i) {
                                                break;
                                            }
                                        }
                                        y4 = y.f.c.x.a;
                                        y5 = y.f.c.x.a;
                                        if (this.r.b(q)) {
                                            y5 = this.r.a(q);
                                            n16 = 1;
                                        }
                                        else {
                                            n16 = 0;
                                        }
                                        Label_1907: {
                                            if (this.q.a(q)) {
                                                y4 = this.q.b(q);
                                                this.q.a(q, (ar)y4);
                                                b7 = true;
                                                if (!i) {
                                                    break Label_1907;
                                                }
                                            }
                                            b7 = false;
                                        }
                                        a7 = this.a();
                                        l = 3;
                                        while (true) {
                                            while (l >= 0) {
                                                a8 = y5.a(l);
                                                c3 = y5.c(l);
                                                a9 = y4.a(l);
                                                a10 = y3.a(l);
                                                c4 = y3.c(l);
                                                c5 = y4.c(l);
                                                b8 = y4.b(l);
                                                b9 = y3.b(l);
                                                b10 = y5.b(l);
                                                n17 = a8.l.size() + c3.l.size() + a10.l.size() + a9.l.size() + c4.l.size() + c5.l.size() + b8.l.size() + b9.l.size() + b10.l.size();
                                                d12 = y3.d(l);
                                                a11 = this.a(d12, n17);
                                                a12 = this.a(d12, n17, a11);
                                                z = a10;
                                                z2 = c4;
                                                z3 = b9;
                                                m = a11;
                                                z3.j = m;
                                                z2.j = m;
                                                z.j = m;
                                                n18 = n16;
                                                if (!i) {
                                                    if (n18 != 0) {
                                                        z4 = a8;
                                                        z5 = c3;
                                                        z6 = b10;
                                                        j2 = a11;
                                                        z6.j = j2;
                                                        z5.j = j2;
                                                        z4.j = j2;
                                                    }
                                                    if (b7) {
                                                        z7 = a9;
                                                        z8 = c5;
                                                        z9 = b8;
                                                        j3 = a11;
                                                        z9.j = j3;
                                                        z8.j = j3;
                                                        z7.j = j3;
                                                    }
                                                    Label_2272: {
                                                        if ((l & 0x1) == 0x1) {
                                                            a10.a(Math.max(this.O - a7, 0.0), a7);
                                                            c4.a(0.0, 0.0);
                                                            b9.a(Math.max(this.O - a7, 0.0), a7);
                                                            if (!i) {
                                                                break Label_2272;
                                                            }
                                                        }
                                                        a10.a(this.O, a7);
                                                        c4.a(0.0, 0.0);
                                                        b9.a(this.O, a7);
                                                    }
                                                    a8.a(this.O, a7);
                                                    c3.a(this.O, 0.0);
                                                    b10.a(this.O, a7);
                                                    a9.a(this.O, a7);
                                                    Label_2355: {
                                                        if ((l & 0x1) == 0x1) {
                                                            c5.a(Math.max(this.O - a7, 0.0), 0.0);
                                                            if (!i) {
                                                                break Label_2355;
                                                            }
                                                        }
                                                        c5.a(this.O, 0.0);
                                                    }
                                                    b8.a(this.O, a7);
                                                    n19 = a12;
                                                    if (n16 != 0) {
                                                        a8.b(n19, 0.0);
                                                        n19 = a8.g();
                                                    }
                                                    Label_2490: {
                                                        if ((l & 0x1) == 0x1) {
                                                            if (b7) {
                                                                a9.b(n19, 0.0);
                                                                n19 = a9.g();
                                                            }
                                                            a10.a(Math.max(this.O - a7, 0.0), 0.0);
                                                            a10.b(n19, 0.0);
                                                            n19 = a10.g();
                                                            if (!i) {
                                                                break Label_2490;
                                                            }
                                                        }
                                                        a10.b(n19, 0.0);
                                                        n19 = a10.g();
                                                        if (b7) {
                                                            a9.b(n19, 0.0);
                                                            n19 = a9.g();
                                                        }
                                                    }
                                                    if (n16 != 0) {
                                                        c3.b(n19, 0.0);
                                                        n19 = c3.g();
                                                    }
                                                    c4.b(n19, 0.0);
                                                    g4 = c4.g();
                                                    if (b7) {
                                                        c5.b(g4, 0.0);
                                                    }
                                                    n20 = a12;
                                                    if (n16 != 0) {
                                                        b10.b(n20, 0.0);
                                                        n20 = b10.g();
                                                    }
                                                    Label_2662: {
                                                        if ((l & 0x1) == 0x1) {
                                                            if (b7) {
                                                                b8.b(n20, 0.0);
                                                                n20 = b8.g();
                                                            }
                                                            b9.a(Math.max(this.O - a7, 0.0), 0.0);
                                                            b9.b(n20, 0.0);
                                                            n20 = b9.g();
                                                            if (!i) {
                                                                break Label_2662;
                                                            }
                                                        }
                                                        b9.b(n20, 0.0);
                                                        g5 = b9.g();
                                                        if (b7) {
                                                            b8.b(g5, 0.0);
                                                            b8.g();
                                                        }
                                                    }
                                                    if (b7) {
                                                        this.a(a9, q);
                                                        this.a(c5, q);
                                                        this.a(b8, q);
                                                    }
                                                    this.b(c4, q);
                                                    --l;
                                                    if (i) {
                                                        break;
                                                    }
                                                    continue Label_2708_Outer;
                                                }
                                                else {
                                                    array = new double[n18];
                                                    if (n16 != 0 || b7) {
                                                        if (n16 != 0) {
                                                            this.r.c(q);
                                                        }
                                                        n21 = 3;
                                                        while (n21 >= 0) {
                                                            a13 = y5.a(n21);
                                                            a14 = y3.a(n21);
                                                            a15 = y4.a(n21);
                                                            c6 = y3.c(n21);
                                                            c7 = y5.c(n21);
                                                            c8 = y4.c(n21);
                                                            b11 = y4.b(n21);
                                                            b12 = y3.b(n21);
                                                            b13 = y5.b(n21);
                                                            n3 = (n21 & 0x1);
                                                            n4 = 1;
                                                            if (i) {
                                                                continue Label_2708_Outer;
                                                            }
                                                            Label_3191: {
                                                                if (n3 == n4) {
                                                                    Label_2908: {
                                                                        if (b7) {
                                                                            a15.c(a13.f);
                                                                            b11.c(b13.f);
                                                                            a14.c(a15.e());
                                                                            b12.c(b11.e());
                                                                            if (!i) {
                                                                                break Label_2908;
                                                                            }
                                                                        }
                                                                        a14.c(a13.f);
                                                                        b12.c(b13.f);
                                                                    }
                                                                    array[n21] = Math.max(a14.e(), b12.e());
                                                                    if (!i) {
                                                                        break Label_3191;
                                                                    }
                                                                }
                                                                a14.c(a13.f);
                                                                b12.c(b13.f);
                                                                if (b7) {
                                                                    a15.c(a14.e());
                                                                    b11.c(b12.e());
                                                                    ar = (ar)y4;
                                                                    if (n21 == 0) {
                                                                        array[n21] = Math.max(a15.a(ar.d[0]), b11.a(ar.d[1]));
                                                                        if (a15.l.size() <= 0 && b11.l.size() <= 0) {
                                                                            break Label_3191;
                                                                        }
                                                                        array[n21] = Math.max(this.O - this.a(), array[n21]);
                                                                        if (!i) {
                                                                            break Label_3191;
                                                                        }
                                                                    }
                                                                    array[n21] = Math.max(a15.a(ar.d[2]), b11.a(ar.d[3]));
                                                                    if (a15.l.size() <= 0 && b11.l.size() <= 0) {
                                                                        break Label_3191;
                                                                    }
                                                                    array[n21] = Math.max(this.O - this.a(), array[n21]);
                                                                    if (!i) {
                                                                        break Label_3191;
                                                                    }
                                                                }
                                                                array[n21] = Math.max(a14.e(), b12.e());
                                                                if (n16 != 0) {
                                                                    array[n21] = Math.max(array[n21], c7.f);
                                                                }
                                                            }
                                                            if (c7.l.size() > 0) {
                                                                array[n21] = Math.max(array[n21], c7.e() + this.a());
                                                            }
                                                            c6.c(array[n21]);
                                                            if (b7) {
                                                                c8.c(array[n21]);
                                                            }
                                                            --n21;
                                                            if (i) {
                                                                break;
                                                            }
                                                        }
                                                        break Label_2708_Outer;
                                                    }
                                                    break Label_2708_Outer;
                                                }
                                            }
                                            continue Label_3519_Outer;
                                        }
                                    }
                                    Label_3383: {
                                        if (b7) {
                                            ar2 = (ar)y4;
                                            this.a(q, array[0], array[2], y4.f(3) + ar2.c[1] * this.a(), y4.f(1) + ar2.c[0] * this.a());
                                            if (!i) {
                                                break Label_3383;
                                            }
                                        }
                                        this.a(q, y3.e(0), y3.e(2), y3.f(3), y3.f(1));
                                    }
                                    c.f = Math.max(c.f, a2.getHeight());
                                    b14 = this.c.b(q);
                                    while (true) {
                                    Label_3808:
                                        while (true) {
                                            Label_3700: {
                                                if (f.isEmpty()) {
                                                    break Label_3700;
                                                }
                                                n22 = 0.1 / f.size();
                                                n23 = c2 - 0.4;
                                                p5 = f.k();
                                                while (true) {
                                                    if (p5 == null) {
                                                        break Label_3700;
                                                    }
                                                    d13 = (d)p5.c();
                                                    q2 = this.b.d();
                                                    this.F.a(q2, y.f.c.K.q);
                                                    this.b.b(q2, 1.0, 0.5);
                                                    this.c.a(q2, b14);
                                                    q3 = (q4 = d13.c());
                                                    q5 = (q6 = q);
                                                    if (i) {
                                                        break Label_3808;
                                                    }
                                                    Label_3660: {
                                                        if (q4 == q6) {
                                                            this.x.a(q2, d13.c());
                                                            this.H.a(d13, this.b.n(d13));
                                                            this.b.a(d13, y.d.t.c);
                                                            this.b.a(d13, q2, d13.d());
                                                            if (!i) {
                                                                break Label_3660;
                                                            }
                                                        }
                                                        this.x.a(q2, d13.d());
                                                        this.I.a(d13, this.b.o(d13));
                                                        this.b.b(d13, y.d.t.c);
                                                        this.b.a(d13, d13.c(), q2);
                                                    }
                                                    t.a(q2, n23);
                                                    y2.a(q2, p4);
                                                    n23 += n22;
                                                    p5 = p5.a();
                                                    if (!i) {
                                                        continue Label_3519_Outer;
                                                    }
                                                    break;
                                                }
                                            }
                                            if (f2.isEmpty()) {
                                                break Label_3985;
                                            }
                                            n22 = 0.1 / f2.size();
                                            n23 = c2 + 0.1;
                                            p5 = f2.l();
                                            if (p5 == null) {
                                                break Label_3985;
                                            }
                                            d13 = (d)p5.c();
                                            q2 = this.b.d();
                                            this.F.a(q2, y.f.c.K.q);
                                            this.b.b(q2, 1.0, 0.5);
                                            this.c.a(q2, b14);
                                            q3 = (q4 = d13.c());
                                            q5 = (q6 = q);
                                            if (i) {
                                                continue Label_3732_Outer;
                                            }
                                            break;
                                        }
                                        Label_3944: {
                                            if (q3 == q5) {
                                                this.x.a(q2, d13.c());
                                                this.H.a(d13, this.b.n(d13));
                                                this.b.a(d13, y.d.t.c);
                                                this.b.a(d13, q2, d13.d());
                                                if (!i) {
                                                    break Label_3944;
                                                }
                                            }
                                            this.x.a(q2, d13.d());
                                            this.I.a(d13, this.b.o(d13));
                                            this.b.b(d13, y.d.t.c);
                                            this.b.a(d13, d13.c(), q2);
                                        }
                                        t.a(q2, n23);
                                        p4 = y2.b(q2, p4);
                                        n23 += n22;
                                        p5 = p5.b();
                                        if (!i) {
                                            continue;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        p4 = p4.a();
                        if (i) {
                            break;
                        }
                    }
                    break Label_3997;
                }
                return;
            }
            p3 = p3.a();
            ++n2;
            if (i) {
                break;
            }
        }
        this.b.a(t);
    }
    
    private void a(final q q, final double n, final double n2, final double n3, final double n4) {
        if (this.v != null) {
            this.v.a(q, n);
        }
        if (this.w != null) {
            this.w.a(q, n2);
        }
        if (this.t != null) {
            this.t.a(q, n3);
        }
        if (this.t != null) {
            this.t.a(q, n3);
        }
        if (this.u != null) {
            this.u.a(q, n4);
        }
    }
    
    private void j() {
        this.t = this.b.t();
        this.u = this.b.t();
        this.b.a(y.f.c.v.j, this.t);
        this.b.a(y.f.c.v.e_, this.u);
        this.v = this.b.t();
        this.w = this.b.t();
    }
    
    private void k() {
        if (this.t != null) {
            this.b.d_(y.f.c.v.j);
            this.b.a(this.t);
            this.t = null;
        }
        if (this.u != null) {
            this.b.d_(y.f.c.v.e_);
            this.b.a(this.u);
            this.u = null;
        }
        if (this.v != null) {
            this.b.a(this.v);
            this.v = null;
        }
        if (this.w != null) {
            this.b.a(this.w);
            this.w = null;
        }
    }
    
    public double a(final double n, final int n2) {
        if (n2 <= 1) {
            return 0.0;
        }
        return n / (n2 - 1 + 2.0 * this.p);
    }
    
    public double a(final double n, final int n2, final double n3) {
        if (n2 <= 1) {
            return n * 0.5;
        }
        return (n - n3 * (n2 - 1)) * 0.5;
    }
    
    private void l() {
        final boolean i = y.f.c.a.i;
        this.C = new HashMap();
        this.q.c(this.m);
        double n = 0.0;
        final b b = new b(-1000.0, 1000.0);
        int n2 = 0;
        double n3 = 0.0;
        final double a = this.a();
        p p = this.m.k();
    Label_0064:
        while (true) {
            C c;
            y.c.y a2;
            double min;
            double max;
            double max2;
            p k;
            Object o;
            q q;
            y.f.am a3;
            double n5;
            double n4;
            C c2;
            C c3 = null;
            Integer n6;
            int n7 = 0;
            int n8 = 0;
            int n9 = 0;
            int a4 = 0;
            C c4 = null;
            Object a5;
            double n10;
            double o2;
            double o3;
            boolean b2;
            boolean b3;
            boolean b4;
            double min2 = 0.0;
            double min3 = 0.0;
            p p2;
            q q2;
            y.f.am a6;
            double n11;
            double n12;
            p p3;
            d f;
            d d;
            d g;
            t p4;
            t q3;
            double n13;
            int n14;
            double n15;
            Iterator a7;
            d d2;
            t p5;
            t q4;
            double n16;
            D c5;
            int n17;
            p p6;
            int n18;
            d d3;
            double n20;
            double n19;
            p p7;
            q q5;
            Object o4;
            q d4;
            t p8;
            t q6;
            double j;
            t t;
            d d5;
            t p9;
            double n21;
            Object o5;
            d d6;
            q d7;
            t t2;
            int a8;
            int n22;
            Object o6;
            t q7;
            t t3;
            t t4;
            int n23;
            double n24;
            p p10;
            q q8;
            double l;
            int a9;
            int n25;
            Object o7;
            q d8;
            d g2;
            t p11;
            t q9;
            double n26;
            double n27;
            d d9;
            t p12;
            double n28 = 0.0;
            d d10;
            q d11;
            int a10;
            int n29;
            Object o8;
            t q10;
            double n30;
            double m;
            double n31;
            D c6;
            p p13;
            q q11;
            int a11;
            int n32;
            Object o9;
            double j2;
            double n33;
            d d12;
            t q12;
            double n34;
            t t5;
            d d13;
            q c7;
            int a12;
            int n35;
            d g3;
            t p14;
            double n36;
            p p15;
            q q13;
            int a13;
            int n37;
            Object o10;
            double j3;
            t t6;
            d d14;
            t q14;
            double n38;
            t t7;
            Object o11;
            d d15;
            q c8;
            int a14;
            int n39;
            d g4;
            t p16;
            t t8;
            p p17;
            q q15;
            int a15;
            int n40;
            Object o12;
            t p18;
            t q16;
            double j4;
            t t9;
            d d16;
            t p19;
            double n41;
            Object o13;
            d d17;
            t t10;
            t q17;
            double n42;
            t t11;
            int n43;
            double n44;
            p p20;
            q q18;
            int a16;
            int n45;
            Object o14;
            d g5;
            t p21;
            t q19;
            double n46;
            double j5;
            double n47;
            d d18;
            t p22;
            double n48;
            d d19;
            t q20;
            double n49;
            double n50;
            D c9;
            p p23;
            q q21;
            int a17;
            int n51;
            Object o15;
            t p24;
            t q22;
            double j6;
            t t12;
            d d20;
            t q23;
            double n52;
            Object o16;
            d d21;
            t t13;
            t p25;
            double n53;
            t t14;
            int n54;
            double max3;
            double n55;
            p p26;
            q q24;
            int a18;
            int n56;
            Object o17;
            d f2;
            t q25;
            t p27;
            double n57;
            double j7;
            double n58;
            d d22;
            t q26;
            double n59;
            d d23;
            t p28;
            double n60;
            double n61;
            D c10;
            double n62;
            double n63;
            C c11;
            Object b5;
            C c12;
            y.c.y a19;
            double n64;
            double n65;
            p p29;
            q q27;
            y y;
            p p30;
            d d24;
            t q28;
            double n66;
            p p31;
            d d25;
            t p32;
            double n67;
            d d26;
            t q29;
            double n68;
            d d27;
            t p33;
            double n69;
            boolean n70;
            d d28;
            D d29;
            I b6;
            p p34;
            t t15;
            Label_0272_Outer:Label_6036_Outer:
            while (p != null) {
                c = (C)p.c();
                a2 = c.a;
                min = Double.MAX_VALUE;
                max = -1.7976931348623157E308;
                max2 = -1.7976931348623157E308;
                k = a2.k();
                Label_6681: {
                Label_6036:
                    while (true) {
                        if (!i) {
                            o = k;
                            while (true) {
                                while (o != null) {
                                    q = (q)((p)o).c();
                                    a3 = this.b.a((Object)q);
                                    max2 = Math.max(max2, a3.getY() + a3.getHeight());
                                    a3.setLocation(a3.getX(), a3.getY() + n);
                                    min = Math.min(min, a3.getY() - this.v.c(q));
                                    max = Math.max(max, a3.getY() + a3.getHeight() + this.w.c(q));
                                    o = ((p)o).a();
                                    if (!i) {
                                        if (i) {
                                            break;
                                        }
                                        continue Label_0272_Outer;
                                    }
                                    else {
                                        n4 = (n5 = max - (max2 + n) + c.e);
                                        c.b = min;
                                        c.c = max;
                                        Label_5988: {
                                            Label_5960: {
                                                Label_5953: {
                                                    if (p.a() != null) {
                                                        c2 = (C)p.a().c();
                                                        Label_0361: {
                                                            if (p.a().a() != null) {
                                                                c3 = (C)p.a().a().c();
                                                                if (!i) {
                                                                    break Label_0361;
                                                                }
                                                            }
                                                            c3 = null;
                                                        }
                                                        n6 = new Integer(n2 + 1);
                                                        while (true) {
                                                        Label_0481:
                                                            while (true) {
                                                                Label_0485: {
                                                                    if (this.s != null && this.s.e().contains(n6)) {
                                                                        n7 = 1;
                                                                        n8 = ((c3 != null && this.s.d().contains(new Integer(n2 + 2))) ? 1 : 0);
                                                                        if (!i) {
                                                                            break Label_0485;
                                                                        }
                                                                    }
                                                                    if (this.s != null && this.s.d().contains(n6)) {
                                                                        n7 = 0;
                                                                        n8 = 1;
                                                                        if (!i) {
                                                                            break Label_0485;
                                                                        }
                                                                    }
                                                                    n8 = n9;
                                                                    n7 = a4;
                                                                }
                                                                Label_0560: {
                                                                    if (n7 != 0 && n8 != 0) {
                                                                        c4 = (C)p.a().a().a().c();
                                                                        n2 += 2;
                                                                        if (!i) {
                                                                            break Label_0560;
                                                                        }
                                                                    }
                                                                    if (n7 != 0 || n8 != 0) {
                                                                        c4 = (C)p.a().a().c();
                                                                        ++n2;
                                                                        if (!i) {
                                                                            break Label_0560;
                                                                        }
                                                                    }
                                                                    c4 = c2;
                                                                }
                                                                a5 = y.f.c.K.a(c4.a, this.F);
                                                                n10 = 0.0;
                                                                o2 = 0.0;
                                                                o3 = 0.0;
                                                                b2 = true;
                                                                if (o != y.f.c.K.r && a5 != y.f.c.K.r) {
                                                                    if (o == y.f.c.K.p) {
                                                                        n10 = Math.max(this.O, 0.5 * this.P);
                                                                    }
                                                                    if (a5 == y.f.c.K.p) {
                                                                        n10 += Math.max(this.O, 0.5 * this.P);
                                                                        if (o == a5) {
                                                                            n10 = Math.max(this.O, this.P);
                                                                            b2 = false;
                                                                        }
                                                                    }
                                                                }
                                                                Label_0703: {
                                                                    if (o == y.f.c.K.p) {
                                                                        o3 = this.O;
                                                                        b3 = true;
                                                                        if (!i) {
                                                                            break Label_0703;
                                                                        }
                                                                    }
                                                                    b3 = false;
                                                                }
                                                                Label_0728: {
                                                                    if (a5 == y.f.c.K.p) {
                                                                        o2 = this.O;
                                                                        b4 = true;
                                                                        if (!i) {
                                                                            break Label_0728;
                                                                        }
                                                                    }
                                                                    b4 = false;
                                                                }
                                                                min2 = Double.MAX_VALUE;
                                                                min3 = Double.MAX_VALUE;
                                                                p2 = c4.a.k();
                                                                while (p2 != null) {
                                                                    q2 = (q)p2.c();
                                                                    a6 = this.b.a(p2.c());
                                                                    min2 = Math.min(min2, a6.getY());
                                                                    min3 = Math.min(min3, a6.getY() - this.v.c(q2));
                                                                    p2 = p2.a();
                                                                    if (!i) {
                                                                        if (i) {
                                                                            break;
                                                                        }
                                                                        continue Label_0272_Outer;
                                                                    }
                                                                    else {
                                                                        n11 = ((n4 < o3) ? (o3 - n4) : 0.0);
                                                                        n12 = ((n3 < o2) ? (o2 - n3) : 0.0);
                                                                        b.a(-1000.0, 1000.0, (byte)1);
                                                                        Label_5948: {
                                                                            Label_5937: {
                                                                                if (n7 == 0 && n8 == 0) {
                                                                                    Label_1367: {
                                                                                        if (this.n) {
                                                                                            p3 = a2.k();
                                                                                        Label_1079:
                                                                                            while (true) {
                                                                                                while (p3 != null) {
                                                                                                    d = (f = ((q)p3.c()).f());
                                                                                                    if (!i) {
                                                                                                        g = d;
                                                                                                        while (g != null) {
                                                                                                            p4 = this.b.p(g);
                                                                                                            q3 = this.b.q(g);
                                                                                                            n13 = dcmpl(p4.a, q3.a);
                                                                                                            if (i) {
                                                                                                                break Label_1079;
                                                                                                            }
                                                                                                            if (n13 != 0) {
                                                                                                                b.a(g, new t(p4.a, -2000.0), new t(q3.a, 2000.0));
                                                                                                            }
                                                                                                            g = g.g();
                                                                                                            if (i) {
                                                                                                                break;
                                                                                                            }
                                                                                                        }
                                                                                                        p3 = p3.a();
                                                                                                        if (i) {
                                                                                                            break;
                                                                                                        }
                                                                                                        continue Label_0272_Outer;
                                                                                                        n14 = (int)n13;
                                                                                                        Label_1189: {
                                                                                                            if (n14 > 0) {
                                                                                                                n11 = Math.max(n11, b3 ? Math.max(this.O, a) : a);
                                                                                                                n12 = Math.max(n12, b4 ? Math.max(this.O, a) : a);
                                                                                                                n5 += (n14 - 1) * a + n11 + n12;
                                                                                                                if (!i) {
                                                                                                                    break Label_1189;
                                                                                                                }
                                                                                                            }
                                                                                                            n11 = (n12 = 0.0);
                                                                                                            if (n3 > 0.0 || n4 > 0.0) {
                                                                                                                n5 += a;
                                                                                                            }
                                                                                                        }
                                                                                                        Label_1244: {
                                                                                                            if (n5 < n10) {
                                                                                                                n15 = min2 + n + n4 + n11 + (n10 - n5) * 0.5;
                                                                                                                n += n10 - n5;
                                                                                                                if (!i) {
                                                                                                                    break Label_1244;
                                                                                                                }
                                                                                                            }
                                                                                                            n15 = min2 + n + n4 + n11;
                                                                                                        }
                                                                                                        a7 = b.a();
                                                                                                        while (a7.hasNext()) {
                                                                                                            d2 = a7.next();
                                                                                                            p5 = this.b.p(d2);
                                                                                                            q4 = this.b.q(d2);
                                                                                                            n16 = n15 + b.c(d2) * a;
                                                                                                            c5 = this.c(d2);
                                                                                                            c5.add(new t(p5.a, n16));
                                                                                                            c5.add(new t(q4.a, n16));
                                                                                                            if (i) {
                                                                                                                break Label_5948;
                                                                                                            }
                                                                                                            if (i) {
                                                                                                                break Label_1367;
                                                                                                            }
                                                                                                        }
                                                                                                        break Label_5937;
                                                                                                    }
                                                                                                    break Label_6036;
                                                                                                }
                                                                                                b.b();
                                                                                                b.c();
                                                                                                continue Label_1079;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    n17 = 1;
                                                                                    Label_1528: {
                                                                                        Label_1515: {
                                                                                            if (b2) {
                                                                                                p6 = a2.k();
                                                                                            Label_1501:
                                                                                                while (true) {
                                                                                                    while (p6 != null) {
                                                                                                        n18 = n17;
                                                                                                        if (!i) {
                                                                                                            if (n18 != 0) {
                                                                                                                d3 = ((q)p6.c()).f();
                                                                                                                while (d3 != null) {
                                                                                                                    n19 = (n20 = dcmpl(Math.abs(this.b.p(d3).a - this.b.q(d3).a), 2.0));
                                                                                                                    if (i) {
                                                                                                                        break Label_1501;
                                                                                                                    }
                                                                                                                    if (n19 > 0) {
                                                                                                                        n17 = 0;
                                                                                                                        if (!i) {
                                                                                                                            break;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    d3 = d3.g();
                                                                                                                    if (i) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                }
                                                                                                                p6 = p6.a();
                                                                                                                if (!i) {
                                                                                                                    continue Label_0272_Outer;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        if (n18 != 0) {
                                                                                                            break Label_1528;
                                                                                                        }
                                                                                                        n10 = this.P;
                                                                                                        if (i) {
                                                                                                            break Label_1515;
                                                                                                        }
                                                                                                        break Label_1528;
                                                                                                    }
                                                                                                    continue Label_1501;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        n10 = Math.max(this.O, this.P);
                                                                                    }
                                                                                    n5 += n10;
                                                                                    if (!i) {
                                                                                        break Label_5937;
                                                                                    }
                                                                                }
                                                                                Label_3796: {
                                                                                    if (n7 != 0 && n8 != 0) {
                                                                                        this.m.h(p.a().a());
                                                                                        this.m.h(p.a());
                                                                                        p7 = c2.a.k();
                                                                                    Label_2499:
                                                                                        while (true) {
                                                                                            while (p7 != null) {
                                                                                                q5 = (q)p7.c();
                                                                                                a4 = q5.a();
                                                                                                n9 = 2;
                                                                                                if (i) {
                                                                                                    continue Label_0481;
                                                                                                }
                                                                                                o4 = ((a4 == n9) ? null : this.s.a(q5));
                                                                                                Label_2119: {
                                                                                                    if (o4 == null) {
                                                                                                        d4 = q5.f().d();
                                                                                                        if (((d4.a() == 2) ? null : this.s.a(d4)) != null) {
                                                                                                            break Label_2119;
                                                                                                        }
                                                                                                        p8 = this.b.p(q5.g());
                                                                                                        q6 = this.b.q(d4.f());
                                                                                                        if (p8.a == q6.a) {
                                                                                                            break Label_2119;
                                                                                                        }
                                                                                                        b.a(q5.g(), new t(p8.a, -2000.0), new t(q6.a, 2000.0));
                                                                                                        if (!i) {
                                                                                                            break Label_2119;
                                                                                                        }
                                                                                                    }
                                                                                                    j = this.b.j(q5);
                                                                                                    t = new t(j, -2000.0);
                                                                                                    d5 = q5.g();
                                                                                                    while (d5 != null) {
                                                                                                        p9 = this.b.p(d5);
                                                                                                        n21 = dcmpl(p9.a, t.a);
                                                                                                        if (i) {
                                                                                                            break Label_2499;
                                                                                                        }
                                                                                                        if (n21 != 0) {
                                                                                                            b.a(d5, o4, new t(p9.a, -2000.0), t);
                                                                                                        }
                                                                                                        d5 = d5.h();
                                                                                                        if (i) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    o5 = null;
                                                                                                    if (this.j) {
                                                                                                        o5 = new Object();
                                                                                                    }
                                                                                                    d6 = q5.f();
                                                                                                    while (d6 != null) {
                                                                                                        d7 = d6.d();
                                                                                                        t2 = new t(j, -2000.0);
                                                                                                        a8 = d7.a();
                                                                                                        n22 = 2;
                                                                                                        if (i) {
                                                                                                            continue Label_0481;
                                                                                                        }
                                                                                                        o6 = ((a8 == n22) ? null : this.s.a(d7));
                                                                                                        Label_2107: {
                                                                                                            if (o6 == null) {
                                                                                                                q7 = this.b.q(d7.f());
                                                                                                                if (q7.a == t2.a) {
                                                                                                                    break Label_2107;
                                                                                                                }
                                                                                                                t3 = new t(q7.a, 2000.0);
                                                                                                                if (this.j) {
                                                                                                                    b.a(d6, o5, t2, t3);
                                                                                                                    if (!i) {
                                                                                                                        break Label_2107;
                                                                                                                    }
                                                                                                                }
                                                                                                                b.a(d6, t2, t3);
                                                                                                                if (!i) {
                                                                                                                    break Label_2107;
                                                                                                                }
                                                                                                            }
                                                                                                            if (!o6.equals(o4)) {
                                                                                                                t4 = new t(this.b.j(d7), 2000.0);
                                                                                                                if (t2.a != t4.a) {
                                                                                                                    b.a(d6, t2, t4);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        d6 = d6.g();
                                                                                                        if (i) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    break Label_2119;
                                                                                                    n23 = (int)n21;
                                                                                                    Label_2575: {
                                                                                                        if (n23 > 0) {
                                                                                                            n11 = Math.max(n11, a);
                                                                                                            n12 = Math.max(n12, a);
                                                                                                            n5 += (n23 - 1) * a + n11 + n12;
                                                                                                            if (!i) {
                                                                                                                break Label_2575;
                                                                                                            }
                                                                                                        }
                                                                                                        n11 = (n12 = 0.0);
                                                                                                        if (n3 > 0.0 || n4 > 0.0) {
                                                                                                            n5 += a;
                                                                                                        }
                                                                                                    }
                                                                                                    Label_2630: {
                                                                                                        if (n5 < n10) {
                                                                                                            n24 = min2 + n + n4 + n11 + (n10 - n5) * 0.5;
                                                                                                            n += n10 - n5;
                                                                                                            if (!i) {
                                                                                                                break Label_2630;
                                                                                                            }
                                                                                                        }
                                                                                                        n24 = min2 + n + n4 + n11;
                                                                                                    }
                                                                                                    p10 = c2.a.k();
                                                                                                    while (p10 != null) {
                                                                                                        q8 = (q)p10.c();
                                                                                                        l = this.b.j(q8);
                                                                                                        this.b.a(q8, l, n24);
                                                                                                        a9 = q8.a();
                                                                                                        n25 = 2;
                                                                                                        if (i) {
                                                                                                            continue Label_0481;
                                                                                                        }
                                                                                                        o7 = ((a9 == n25) ? null : this.s.a(q8));
                                                                                                        Label_3369: {
                                                                                                            if (o7 == null) {
                                                                                                                d8 = q8.f().d();
                                                                                                                if (((d8.a() == 2) ? null : this.s.a(d8)) != null) {
                                                                                                                    break Label_3369;
                                                                                                                }
                                                                                                                g2 = q8.g();
                                                                                                                p11 = this.b.p(g2);
                                                                                                                q9 = this.b.q(d8.f());
                                                                                                                this.b.a(q8, p11.a, n24);
                                                                                                                this.b.a(d8, q9.a, n24);
                                                                                                                if (p11.a != q9.a) {
                                                                                                                    n26 = n24 + b.c(g2) * a;
                                                                                                                    this.b.d(g2, new t(p11.a, n26));
                                                                                                                    this.b.c(d8.f(), new t(q9.a, n26));
                                                                                                                }
                                                                                                                this.b.c(q8.f(), this.b.q(g2));
                                                                                                                this.b.d(q8.f(), this.b.p(d8.f()));
                                                                                                                if (!i) {
                                                                                                                    break Label_3369;
                                                                                                                }
                                                                                                            }
                                                                                                            if (b.a(o7)) {
                                                                                                                n27 = n24 + b.d(o7) * a;
                                                                                                                this.b.a(q8, l, n27);
                                                                                                                d9 = q8.g();
                                                                                                                while (d9 != null) {
                                                                                                                    p12 = this.b.p(d9);
                                                                                                                    n28 = dcmpl(p12.a, l);
                                                                                                                    if (i) {
                                                                                                                        break Label_5960;
                                                                                                                    }
                                                                                                                    Label_3086: {
                                                                                                                        if (n28 != 0) {
                                                                                                                            this.b.d(d9, new t(p12.a, n24 + b.c(d9) * a));
                                                                                                                            if (!i) {
                                                                                                                                break Label_3086;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        this.b.d(d9, new t(p12.a, n27));
                                                                                                                    }
                                                                                                                    d9 = d9.h();
                                                                                                                    if (i) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                            d10 = q8.f();
                                                                                                            while (d10 != null) {
                                                                                                                d11 = d10.d();
                                                                                                                a10 = d11.a();
                                                                                                                n29 = 2;
                                                                                                                if (i) {
                                                                                                                    continue Label_0481;
                                                                                                                }
                                                                                                                o8 = ((a10 == n29) ? null : this.s.a(d11));
                                                                                                                Label_3357: {
                                                                                                                    if (o8 == null) {
                                                                                                                        q10 = this.b.q(d11.f());
                                                                                                                        this.b.a(d11, l, n24);
                                                                                                                        if (q10.a == l) {
                                                                                                                            break Label_3357;
                                                                                                                        }
                                                                                                                        n30 = n24 + b.c(d10) * a;
                                                                                                                        this.b.d(d10, new t(l, n30));
                                                                                                                        this.b.c(d11.f(), new t(q10.a, n30));
                                                                                                                        if (!i) {
                                                                                                                            break Label_3357;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    m = this.b.j(d11);
                                                                                                                    this.b.a(d11, m, n24);
                                                                                                                    if (!o8.equals(o7)) {
                                                                                                                        if (l != m) {
                                                                                                                            n31 = n24 + b.c(d10) * a;
                                                                                                                            c6 = this.c(d10);
                                                                                                                            c6.add(new t(l, n31));
                                                                                                                            c6.add(new t(m, n31));
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                                d10 = d10.g();
                                                                                                                if (i) {
                                                                                                                    break;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        p10 = p10.a();
                                                                                                        if (i) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    p13 = c3.a.k();
                                                                                                    while (p13 != null) {
                                                                                                        q11 = (q)p13.c();
                                                                                                        a11 = q11.a();
                                                                                                        n32 = 2;
                                                                                                        if (i) {
                                                                                                            continue Label_0481;
                                                                                                        }
                                                                                                        o9 = ((a11 == n32) ? null : this.s.a(q11));
                                                                                                        if (o9 != null) {
                                                                                                            j2 = this.b.j(q11);
                                                                                                            Label_3618: {
                                                                                                                Label_3605: {
                                                                                                                    if (b.a(o9)) {
                                                                                                                        n33 = n24 + b.d(o9) * a;
                                                                                                                        this.b.a(q11, j2, n33);
                                                                                                                        d12 = q11.f();
                                                                                                                        while (d12 != null) {
                                                                                                                            q12 = this.b.q(d12);
                                                                                                                            n34 = dcmpl(q12.a, j2);
                                                                                                                            if (i) {
                                                                                                                                break Label_5960;
                                                                                                                            }
                                                                                                                            Label_3593: {
                                                                                                                                if (n34 != 0) {
                                                                                                                                    this.b.c(d12, new t(q12.a, n24 + b.c(d12) * a));
                                                                                                                                    if (!i) {
                                                                                                                                        break Label_3593;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                this.b.c(d12, new t(q12.a, n33));
                                                                                                                            }
                                                                                                                            d12 = d12.g();
                                                                                                                            if (i) {
                                                                                                                                break Label_3605;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        break Label_3618;
                                                                                                                    }
                                                                                                                }
                                                                                                                this.b.a(q11, j2, n24);
                                                                                                            }
                                                                                                            t5 = new t(j2, 2000.0);
                                                                                                            d13 = q11.g();
                                                                                                            while (d13 != null) {
                                                                                                                c7 = d13.c();
                                                                                                                a12 = c7.a();
                                                                                                                n35 = 2;
                                                                                                                if (i) {
                                                                                                                    continue Label_0481;
                                                                                                                }
                                                                                                                if (((a12 == n35) ? null : this.s.a(c7)) == null) {
                                                                                                                    g3 = c7.g();
                                                                                                                    p14 = this.b.p(g3);
                                                                                                                    if (p14.a != j2) {
                                                                                                                        n36 = n24 + b.c(g3) * a;
                                                                                                                        this.b.d(g3, new t(p14.a, n36));
                                                                                                                        this.b.c(d13, new t(j2, n36));
                                                                                                                    }
                                                                                                                }
                                                                                                                d13 = d13.h();
                                                                                                                if (i) {
                                                                                                                    break;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        p13 = p13.a();
                                                                                                        if (i) {
                                                                                                            break Label_3796;
                                                                                                        }
                                                                                                    }
                                                                                                    break Label_5937;
                                                                                                }
                                                                                                p7 = p7.a();
                                                                                                if (i) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            p15 = c3.a.k();
                                                                                            while (p15 != null) {
                                                                                                q13 = (q)p15.c();
                                                                                                a13 = q13.a();
                                                                                                n37 = 2;
                                                                                                if (i) {
                                                                                                    continue Label_0481;
                                                                                                }
                                                                                                o10 = ((a13 == n37) ? null : this.s.a(q13));
                                                                                                if (o10 != null) {
                                                                                                    j3 = this.b.j(q13);
                                                                                                    t6 = new t(j3, 2000.0);
                                                                                                    d14 = q13.f();
                                                                                                    while (d14 != null) {
                                                                                                        q14 = this.b.q(d14);
                                                                                                        n38 = dcmpl(t6.a, q14.a);
                                                                                                        if (i) {
                                                                                                            continue Label_2499;
                                                                                                        }
                                                                                                        if (n38 != 0) {
                                                                                                            b.a(d14, o10, t6, new t(q14.a, 2000.0));
                                                                                                        }
                                                                                                        d14 = d14.g();
                                                                                                        if (i) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    t7 = new t(j3, 2000.0);
                                                                                                    o11 = null;
                                                                                                    if (this.j) {
                                                                                                        o11 = new Object();
                                                                                                    }
                                                                                                    d15 = q13.g();
                                                                                                    while (d15 != null) {
                                                                                                        c8 = d15.c();
                                                                                                        a14 = c8.a();
                                                                                                        n39 = 2;
                                                                                                        if (i) {
                                                                                                            continue Label_0481;
                                                                                                        }
                                                                                                        Label_2467: {
                                                                                                            if (((a14 == n39) ? null : this.s.a(c8)) == null) {
                                                                                                                g4 = c8.g();
                                                                                                                p16 = this.b.p(g4);
                                                                                                                if (p16.a != t7.a) {
                                                                                                                    t8 = new t(p16.a, -2000.0);
                                                                                                                    if (this.j) {
                                                                                                                        b.a(g4, o11, t8, t7);
                                                                                                                        if (!i) {
                                                                                                                            break Label_2467;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    b.a(g4, t8, t7);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        d15 = d15.h();
                                                                                                        if (i) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                p15 = p15.a();
                                                                                                if (i) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            b.b();
                                                                                            b.c();
                                                                                            continue Label_2499;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                Label_4869: {
                                                                                    if (n7 != 0) {
                                                                                        this.m.h(p.a());
                                                                                        p17 = c2.a.k();
                                                                                    Label_4240:
                                                                                        while (true) {
                                                                                            while (p17 != null) {
                                                                                                q15 = (q)p17.c();
                                                                                                a15 = q15.a();
                                                                                                n40 = 2;
                                                                                                if (i) {
                                                                                                    continue Label_0481;
                                                                                                }
                                                                                                o12 = ((a15 == n40) ? null : this.s.a(q15));
                                                                                                Label_4220: {
                                                                                                    if (o12 == null) {
                                                                                                        p18 = this.b.p(q15.g());
                                                                                                        q16 = this.b.q(q15.f());
                                                                                                        if (p18.a == q16.a) {
                                                                                                            break Label_4220;
                                                                                                        }
                                                                                                        b.a(q15.g(), new t(p18.a, -2000.0), new t(q16.a, 2000.0));
                                                                                                        if (!i) {
                                                                                                            break Label_4220;
                                                                                                        }
                                                                                                    }
                                                                                                    j4 = this.b.j(q15);
                                                                                                    t9 = new t(j4, -2000.0);
                                                                                                    d16 = q15.g();
                                                                                                    while (d16 != null) {
                                                                                                        p19 = this.b.p(d16);
                                                                                                        n41 = dcmpl(p19.a, t9.a);
                                                                                                        if (i) {
                                                                                                            break Label_4240;
                                                                                                        }
                                                                                                        if (n41 != 0) {
                                                                                                            b.a(d16, o12, new t(p19.a, -2000.0), t9);
                                                                                                        }
                                                                                                        d16 = d16.h();
                                                                                                        if (i) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    o13 = null;
                                                                                                    if (this.j) {
                                                                                                        o13 = new Object();
                                                                                                    }
                                                                                                    d17 = q15.f();
                                                                                                    while (d17 != null) {
                                                                                                        d17.d();
                                                                                                        t10 = new t(j4, -2000.0);
                                                                                                        q17 = this.b.q(d17);
                                                                                                        n42 = dcmpl(q17.a, t10.a);
                                                                                                        if (i) {
                                                                                                            break Label_4240;
                                                                                                        }
                                                                                                        Label_4208: {
                                                                                                            if (n42 != 0) {
                                                                                                                t11 = new t(q17.a, 2000.0);
                                                                                                                if (this.j) {
                                                                                                                    b.a(d17, o13, t10, t11);
                                                                                                                    if (!i) {
                                                                                                                        break Label_4208;
                                                                                                                    }
                                                                                                                }
                                                                                                                b.a(d17, t10, t11);
                                                                                                            }
                                                                                                        }
                                                                                                        d17 = d17.g();
                                                                                                        if (i) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    break Label_4220;
                                                                                                    n43 = (int)n41;
                                                                                                    Label_4316: {
                                                                                                        if (n43 > 0) {
                                                                                                            n11 = Math.max(n11, a);
                                                                                                            n12 = Math.max(n12, a);
                                                                                                            n5 += (n43 - 1) * a + n11 + n12;
                                                                                                            if (!i) {
                                                                                                                break Label_4316;
                                                                                                            }
                                                                                                        }
                                                                                                        n11 = (n12 = 0.0);
                                                                                                        if (n3 > 0.0 || n4 > 0.0) {
                                                                                                            n5 += a;
                                                                                                        }
                                                                                                    }
                                                                                                    Label_4371: {
                                                                                                        if (n5 < n10) {
                                                                                                            n44 = min2 + n + n4 + n11 + (n10 - n5) * 0.5;
                                                                                                            n += n10 - n5;
                                                                                                            if (!i) {
                                                                                                                break Label_4371;
                                                                                                            }
                                                                                                        }
                                                                                                        n44 = min2 + n + n4 + n11;
                                                                                                    }
                                                                                                    p20 = c2.a.k();
                                                                                                    while (p20 != null) {
                                                                                                        q18 = (q)p20.c();
                                                                                                        a16 = q18.a();
                                                                                                        n45 = 2;
                                                                                                        if (i) {
                                                                                                            continue Label_0481;
                                                                                                        }
                                                                                                        o14 = ((a16 == n45) ? null : this.s.a(q18));
                                                                                                        Label_4857: {
                                                                                                            if (o14 == null) {
                                                                                                                g5 = q18.g();
                                                                                                                p21 = this.b.p(g5);
                                                                                                                q19 = this.b.q(q18.f());
                                                                                                                this.b.a(q18, p21.a, n44);
                                                                                                                if (p21.a == q19.a) {
                                                                                                                    break Label_4857;
                                                                                                                }
                                                                                                                n46 = n44 + b.c(g5) * a;
                                                                                                                this.b.d(g5, new t(p21.a, n46));
                                                                                                                this.b.c(q18.f(), new t(q19.a, n46));
                                                                                                                if (!i) {
                                                                                                                    break Label_4857;
                                                                                                                }
                                                                                                            }
                                                                                                            j5 = this.b.j(q18);
                                                                                                            Label_4739: {
                                                                                                                Label_4726: {
                                                                                                                    if (b.a(o14)) {
                                                                                                                        n47 = n44 + b.d(o14) * a;
                                                                                                                        this.b.a(q18, j5, n47);
                                                                                                                        d18 = q18.g();
                                                                                                                        while (d18 != null) {
                                                                                                                            p22 = this.b.p(d18);
                                                                                                                            n48 = dcmpl(p22.a, j5);
                                                                                                                            if (i) {
                                                                                                                                break Label_5960;
                                                                                                                            }
                                                                                                                            Label_4714: {
                                                                                                                                if (n48 != 0) {
                                                                                                                                    this.b.d(d18, new t(p22.a, n44 + b.c(d18) * a));
                                                                                                                                    if (!i) {
                                                                                                                                        break Label_4714;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                this.b.d(d18, new t(p22.a, n47));
                                                                                                                            }
                                                                                                                            d18 = d18.h();
                                                                                                                            if (i) {
                                                                                                                                break Label_4726;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        break Label_4739;
                                                                                                                    }
                                                                                                                }
                                                                                                                this.b.a(q18, j5, n44);
                                                                                                            }
                                                                                                            d19 = q18.f();
                                                                                                            while (d19 != null) {
                                                                                                                d19.d();
                                                                                                                q20 = this.b.q(d19);
                                                                                                                n49 = dcmpl(q20.a, j5);
                                                                                                                if (i) {
                                                                                                                    break Label_5960;
                                                                                                                }
                                                                                                                if (n49 != 0) {
                                                                                                                    n50 = n44 + b.c(d19) * a;
                                                                                                                    c9 = this.c(d19);
                                                                                                                    c9.add(new t(j5, n50));
                                                                                                                    c9.add(new t(q20.a, n50));
                                                                                                                }
                                                                                                                d19 = d19.g();
                                                                                                                if (i) {
                                                                                                                    break;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        p20 = p20.a();
                                                                                                        if (i) {
                                                                                                            break Label_4869;
                                                                                                        }
                                                                                                    }
                                                                                                    break Label_5937;
                                                                                                }
                                                                                                p17 = p17.a();
                                                                                                if (i) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            b.b();
                                                                                            b.c();
                                                                                            continue Label_4240;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                this.m.h(p.a());
                                                                                p23 = c2.a.k();
                                                                            Label_5308:
                                                                                while (true) {
                                                                                    while (p23 != null) {
                                                                                        q21 = (q)p23.c();
                                                                                        a17 = q21.a();
                                                                                        n51 = 2;
                                                                                        if (i) {
                                                                                            continue Label_0481;
                                                                                        }
                                                                                        o15 = ((a17 == n51) ? null : this.s.a(q21));
                                                                                        Label_5288: {
                                                                                            if (o15 == null) {
                                                                                                p24 = this.b.p(q21.g());
                                                                                                q22 = this.b.q(q21.f());
                                                                                                if (p24.a == q22.a) {
                                                                                                    break Label_5288;
                                                                                                }
                                                                                                b.a(q21.f(), new t(p24.a, -2000.0), new t(q22.a, 2000.0));
                                                                                                if (!i) {
                                                                                                    break Label_5288;
                                                                                                }
                                                                                            }
                                                                                            j6 = this.b.j(q21);
                                                                                            t12 = new t(j6, 2000.0);
                                                                                            d20 = q21.f();
                                                                                            while (d20 != null) {
                                                                                                q23 = this.b.q(d20);
                                                                                                n52 = dcmpl(t12.a, q23.a);
                                                                                                if (i) {
                                                                                                    break Label_5308;
                                                                                                }
                                                                                                if (n52 != 0) {
                                                                                                    b.a(d20, o15, t12, new t(q23.a, 2000.0));
                                                                                                }
                                                                                                d20 = d20.g();
                                                                                                if (i) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            o16 = null;
                                                                                            if (this.j) {
                                                                                                o16 = new Object();
                                                                                            }
                                                                                            d21 = q21.g();
                                                                                            while (d21 != null) {
                                                                                                d21.c();
                                                                                                t13 = new t(j6, 2000.0);
                                                                                                p25 = this.b.p(d21);
                                                                                                n53 = dcmpl(p25.a, t13.a);
                                                                                                if (i) {
                                                                                                    break Label_5308;
                                                                                                }
                                                                                                Label_5276: {
                                                                                                    if (n53 != 0) {
                                                                                                        t14 = new t(p25.a, -2000.0);
                                                                                                        if (this.j) {
                                                                                                            b.a(d21, o16, t14, t13);
                                                                                                            if (!i) {
                                                                                                                break Label_5276;
                                                                                                            }
                                                                                                        }
                                                                                                        b.a(d21, t14, t13);
                                                                                                    }
                                                                                                }
                                                                                                d21 = d21.h();
                                                                                                if (i) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            break Label_5288;
                                                                                            n54 = (int)n52;
                                                                                            Label_5384: {
                                                                                                if (n54 > 0) {
                                                                                                    max3 = Math.max(n11, a);
                                                                                                    n5 += (n54 - 1) * a + max3 + Math.max(n12, a);
                                                                                                    if (!i) {
                                                                                                        break Label_5384;
                                                                                                    }
                                                                                                }
                                                                                                max3 = 0.0;
                                                                                                if (n3 > 0.0 || n4 > 0.0) {
                                                                                                    n5 += a;
                                                                                                }
                                                                                            }
                                                                                            Label_5439: {
                                                                                                if (n5 < n10) {
                                                                                                    n55 = min2 + n + n4 + max3 + (n10 - n5) * 0.5;
                                                                                                    n += n10 - n5;
                                                                                                    if (!i) {
                                                                                                        break Label_5439;
                                                                                                    }
                                                                                                }
                                                                                                n55 = min2 + n + n4 + max3;
                                                                                            }
                                                                                            p26 = c2.a.k();
                                                                                            while (p26 != null) {
                                                                                                q24 = (q)p26.c();
                                                                                                a18 = q24.a();
                                                                                                n56 = 2;
                                                                                                if (i) {
                                                                                                    continue Label_0481;
                                                                                                }
                                                                                                o17 = ((a18 == n56) ? null : this.s.a(q24));
                                                                                                Label_5925: {
                                                                                                    if (o17 == null) {
                                                                                                        f2 = q24.f();
                                                                                                        q25 = this.b.q(f2);
                                                                                                        p27 = this.b.p(q24.g());
                                                                                                        this.b.a(q24, p27.a, n55);
                                                                                                        if (p27.a == q25.a) {
                                                                                                            break Label_5925;
                                                                                                        }
                                                                                                        n57 = n55 + b.c(f2) * a;
                                                                                                        this.b.d(q24.g(), new t(p27.a, n57));
                                                                                                        this.b.c(f2, new t(q25.a, n57));
                                                                                                        if (!i) {
                                                                                                            break Label_5925;
                                                                                                        }
                                                                                                    }
                                                                                                    j7 = this.b.j(q24);
                                                                                                    Label_5807: {
                                                                                                        Label_5794: {
                                                                                                            if (b.a(o17)) {
                                                                                                                n58 = n55 + b.d(o17) * a;
                                                                                                                this.b.a(q24, j7, n58);
                                                                                                                d22 = q24.f();
                                                                                                                while (d22 != null) {
                                                                                                                    q26 = this.b.q(d22);
                                                                                                                    n59 = dcmpl(q26.a, j7);
                                                                                                                    if (i) {
                                                                                                                        break Label_5960;
                                                                                                                    }
                                                                                                                    Label_5782: {
                                                                                                                        if (n59 != 0) {
                                                                                                                            this.b.c(d22, new t(q26.a, n55 + b.c(d22) * a));
                                                                                                                            if (!i) {
                                                                                                                                break Label_5782;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        this.b.c(d22, new t(q26.a, n58));
                                                                                                                    }
                                                                                                                    d22 = d22.g();
                                                                                                                    if (i) {
                                                                                                                        break Label_5794;
                                                                                                                    }
                                                                                                                }
                                                                                                                break Label_5807;
                                                                                                            }
                                                                                                        }
                                                                                                        this.b.a(q24, j7, n55);
                                                                                                    }
                                                                                                    d23 = q24.g();
                                                                                                    while (d23 != null) {
                                                                                                        d23.c();
                                                                                                        p28 = this.b.p(d23);
                                                                                                        n60 = dcmpl(p28.a, j7);
                                                                                                        if (i) {
                                                                                                            break Label_5960;
                                                                                                        }
                                                                                                        if (n60 != 0) {
                                                                                                            n61 = n55 + b.c(d23) * a;
                                                                                                            c10 = this.c(d23);
                                                                                                            c10.add(new t(p28.a, n61));
                                                                                                            c10.add(new t(j7, n61));
                                                                                                        }
                                                                                                        d23 = d23.h();
                                                                                                        if (i) {
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                p26 = p26.a();
                                                                                                if (i) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            break Label_5937;
                                                                                        }
                                                                                        p23 = p23.a();
                                                                                        if (i) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    b.b();
                                                                                    b.c();
                                                                                    continue Label_5308;
                                                                                }
                                                                            }
                                                                            n += n5 + (min2 - max2);
                                                                        }
                                                                        if (i) {
                                                                            break Label_5953;
                                                                        }
                                                                        break Label_5988;
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                            n3 = min2 - min3 + c4.d;
                                                            n5 += n3;
                                                            continue Label_6036_Outer;
                                                        }
                                                    }
                                                }
                                                n62 = dcmpg(n4, this.O);
                                            }
                                            n63 = ((n28 < 0) ? (this.O - n4) : 0.0);
                                            c11 = c;
                                            c11.c += n63;
                                        }
                                        p = p.a();
                                        ++n2;
                                        if (i) {
                                            break Label_0272_Outer;
                                        }
                                        continue Label_0064;
                                    }
                                }
                                o = y.f.c.K.a(a2, this.F);
                                continue Label_6036_Outer;
                            }
                        }
                        p = k;
                        Label_6026: {
                            break Label_6026;
                            while (true) {
                                c12 = (C)b5;
                                a19 = c12.a;
                                n64 = c12.c + c12.e;
                                n65 = c12.b - c12.d;
                                if (!i) {
                                    p29 = a19.k();
                                    while (p29 != null) {
                                        q27 = (q)p29.c();
                                        b5 = this.x.b(q27);
                                        if (i) {
                                            continue Label_6036;
                                        }
                                        Label_6639: {
                                            if (b5 == null) {
                                                y = (y)this.G.b(q27);
                                            Label_6478:
                                                while (true) {
                                                    Label_6474: {
                                                        if (y == null) {
                                                            break Label_6474;
                                                        }
                                                        y.a(this.b.a((Object)q27));
                                                        if (!this.n) {
                                                            p30 = y.c(0).l.k();
                                                            while (p30 != null) {
                                                                d24 = (d)p30.c();
                                                                q28 = this.b.q(d24);
                                                                n66 = dcmpg(n65 + 12.0, q28.b);
                                                                if (i) {
                                                                    break Label_6478;
                                                                }
                                                                if (n66 < 0) {
                                                                    this.c(d24).b(new t(q28.a, n65));
                                                                }
                                                                p30 = p30.a();
                                                                if (i) {
                                                                    break;
                                                                }
                                                            }
                                                            p31 = y.c(2).l.k();
                                                            while (p31 != null) {
                                                                d25 = (d)p31.c();
                                                                p32 = this.b.p(d25);
                                                                n67 = dcmpl(n64 - 12.0, p32.b);
                                                                if (i) {
                                                                    break Label_6478;
                                                                }
                                                                if (n67 > 0) {
                                                                    this.c(d25).a(new t(p32.a, n64));
                                                                }
                                                                p31 = p31.a();
                                                                if (i) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        this.c(q27, y.a(0), n64);
                                                        this.c(q27, y.b(0), n64);
                                                        this.d(q27, y.a(2), n65);
                                                        this.d(q27, y.b(2), n65);
                                                        this.a(q27, y.b(1), n64);
                                                        this.b(q27, y.a(1), n65);
                                                        this.a(q27, y.a(3), n64);
                                                        this.b(q27, y.b(3), n65);
                                                        if (i) {
                                                            break Label_6474;
                                                        }
                                                        break Label_6639;
                                                        while (n66 == 0) {
                                                            d26 = q27.g();
                                                            while (d26 != null) {
                                                                q29 = this.b.q(d26);
                                                                n68 = dcmpg(n65 + 12.0, q29.b);
                                                                if (i) {
                                                                    continue Label_6478;
                                                                }
                                                                if (n68 < 0) {
                                                                    this.c(d26).b(new t(q29.a, n65));
                                                                }
                                                                d26 = d26.h();
                                                                if (i) {
                                                                    break;
                                                                }
                                                            }
                                                            d27 = q27.f();
                                                            while (d27 != null) {
                                                                p33 = this.b.p(d27);
                                                                n69 = dcmpl(n64 - 12.0, p33.b);
                                                                if (i) {
                                                                    continue Label_6478;
                                                                }
                                                                if (n69 > 0) {
                                                                    this.c(d27).a(new t(p33.a, n64));
                                                                }
                                                                d27 = d27.g();
                                                                if (i) {
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        }
                                                        break Label_6639;
                                                    }
                                                    n70 = this.n;
                                                    continue Label_6478;
                                                }
                                            }
                                        }
                                        p29 = p29.a();
                                        if (i) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                break Label_6681;
                            }
                            p = p.a();
                            if (i) {
                                break Label_6036;
                            }
                        }
                        if (p != null) {
                            p.c();
                            continue Label_6036;
                        }
                        break;
                    }
                    this.q.c();
                    this.q.d(this.m);
                }
            Label_6815:
                for (final Map.Entry<d, V> entry : this.C.entrySet()) {
                    d28 = entry.getKey();
                    d29 = entry.getValue();
                    b6 = this.b.b((Object)d28);
                    p34 = d29.k();
                    while (p34 != null) {
                        t15 = (t)p34.c();
                        b6.addPoint(t15.a, t15.b);
                        p34 = p34.a();
                        if (i || i) {
                            return;
                        }
                        if (i) {
                            break Label_6815;
                        }
                    }
                }
                this.C = null;
                this.b.a(this.G);
                this.b.a(this.H);
                this.b.a(this.I);
                return;
            }
            this.r.b();
            this.r.e();
            this.m.k();
            continue;
        }
    }
    
    private void a(final q q, final z z, final double n) {
        final boolean i = y.f.c.a.i;
        p p3 = z.l.k();
        while (p3 != null) {
            final d d = (d)p3.c();
            final D c = this.c(d);
            final q c2 = d.c();
            final double a = this.b.p(d).a;
            this.b.a(d, q, d.d());
            double n2 = 0.0;
            Label_0153: {
                if (this.d(d)) {
                    this.b.a(d, (t)this.H.b(d));
                    n2 = this.b.p(d).b;
                    if (!i) {
                        break Label_0153;
                    }
                }
                final t c3 = z.c(z.a(), 0.0);
                this.b.c(d, c3);
                n2 = c3.b;
            }
            c.a(new t(a, n));
            c.a(new t(a, n2));
            this.b.a(c2);
            p3 = p3.a();
            if (i) {
                break;
            }
        }
    }
    
    private void b(final q q, final z z, final double n) {
        final boolean i = y.f.c.a.i;
        p p3 = z.l.k();
        while (p3 != null) {
            final d d = (d)p3.c();
            final D c = this.c(d);
            final q d2 = d.d();
            final double a = this.b.q(d).a;
            this.b.a(d, d.c(), q);
            double n2 = 0.0;
            Label_0153: {
                if (this.e(d)) {
                    this.b.b(d, (t)this.I.b(d));
                    n2 = this.b.q(d).b;
                    if (!i) {
                        break Label_0153;
                    }
                }
                final t c2 = z.c(z.a(), 0.0);
                this.b.d(d, c2);
                n2 = c2.b;
            }
            c.b(new t(a, n));
            c.b(new t(a, n2));
            this.b.a(d2);
            p3 = p3.a();
            if (i) {
                break;
            }
        }
    }
    
    private void c(final q q, final z z, final double n) {
        final boolean i = y.f.c.a.i;
        p p3 = z.l.k();
        while (p3 != null) {
            final d d = (d)p3.c();
            final D c = this.c(d);
            final double e = z.e(0.0, z.b());
            final q c2 = d.c();
            final double a = this.b.p(d).a;
            this.b.a(d, q, d.d());
            double n2 = 0.0;
            Label_0164: {
                if (this.d(d)) {
                    this.b.a(d, (t)this.H.b(d));
                    n2 = this.b.p(d).a;
                    if (!i) {
                        break Label_0164;
                    }
                }
                final t c3 = z.c(z.a(), 0.0);
                this.b.c(d, c3);
                n2 = c3.a;
            }
            c.a(new t(a, n));
            c.a(new t(a, e));
            c.a(new t(n2, e));
            this.b.a(c2);
            p3 = p3.a();
            if (i) {
                break;
            }
        }
    }
    
    private void d(final q q, final z z, final double n) {
        final boolean i = y.f.c.a.i;
        p p3 = z.l.k();
        while (p3 != null) {
            final d d = (d)p3.c();
            final D c = this.c(d);
            final double e = z.e(0.0, z.b());
            final q d2 = d.d();
            final double a = this.b.q(d).a;
            this.b.a(d, d.c(), q);
            double n2 = 0.0;
            Label_0164: {
                if (this.e(d)) {
                    this.b.b(d, (t)this.I.b(d));
                    n2 = this.b.q(d).a;
                    if (!i) {
                        break Label_0164;
                    }
                }
                final t c2 = z.c(z.a(), 0.0);
                this.b.d(d, c2);
                n2 = c2.a;
            }
            c.b(new t(a, n));
            c.b(new t(a, e));
            c.b(new t(n2, e));
            this.b.a(d2);
            p3 = p3.a();
            if (i) {
                break;
            }
        }
    }
    
    private D c(final d d) {
        D d2 = this.C.get(d);
        if (d2 == null) {
            d2 = new D();
            this.C.put(d, d2);
        }
        return d2;
    }
    
    private void a(final z z, final q q) {
        final boolean i = y.f.c.a.i;
        int n = 0;
        p p2 = z.l.k();
        while (p2 != null) {
            final d d = (d)p2.c();
            if (!this.b.f(d)) {
                this.b.e(d);
                n = 1;
            }
            Label_0122: {
                if (d.c() == q) {
                    if (this.d(d)) {
                        break Label_0122;
                    }
                    this.b.c(d, z.c(z.a(), 0.0));
                    if (!i) {
                        break Label_0122;
                    }
                }
                if (!this.e(d)) {
                    this.b.d(d, z.c(z.a(), 0.0));
                }
            }
            if (n != 0) {
                n = 0;
                this.b.d(d);
            }
            p2 = p2.a();
            if (i) {
                break;
            }
        }
    }
    
    private void b(final z z, final q q) {
        final boolean i = y.f.c.a.i;
        if (z.l.size() < 1) {
            return;
        }
        final int[] array = { 0 };
        final double[] array2 = new double[2];
        final double g = z.g;
        final double f = z.f();
        final p p2 = null;
        final p a = this.a(z.l.k(), q, array);
        final int n = array[0] - ((a == null) ? 1 : 0);
        array2[0] = g;
        array2[1] = f;
        this.a(p2, a, z, q, array2);
        if (n > 0) {
            z.j = (array2[1] - array2[0]) / n;
        }
        z.d(array2[0]);
        int n2 = 0;
        p p3 = z.l.k();
        while (p3 != null) {
            final d d = (d)p3.c();
            if (!this.b.f(d)) {
                this.b.e(d);
                n2 = 1;
            }
            Label_0465: {
                if (d.c() == q) {
                    if (this.d(d)) {
                        final p p4 = p3;
                        final p a2 = this.a(p3.a(), q, array);
                        final int n3 = array[0] + ((p4 != null) ? 1 : 0) + ((a2 != null) ? 1 : 0) - 1;
                        array2[0] = g;
                        array2[1] = f;
                        this.a(p4, a2, z, q, array2);
                        if (n3 <= 0) {
                            break Label_0465;
                        }
                        z.j = (array2[1] - array2[0]) / n3;
                        z.d(array2[0] + z.j);
                        if (!i) {
                            break Label_0465;
                        }
                    }
                    this.b.c(d, z.c(z.a(), 0.0));
                    if (!i) {
                        break Label_0465;
                    }
                }
                if (this.e(d)) {
                    final p p5 = p3;
                    final p a3 = this.a(p3.a(), q, array);
                    final int n4 = array[0] + ((p5 != null) ? 1 : 0) + ((a3 != null) ? 1 : 0) - 1;
                    array2[0] = g;
                    array2[1] = f;
                    this.a(p5, a3, z, q, array2);
                    if (n4 <= 0) {
                        break Label_0465;
                    }
                    z.j = (array2[1] - array2[0]) / n4;
                    z.d(array2[0] + z.j);
                    if (!i) {
                        break Label_0465;
                    }
                }
                this.b.d(d, z.c(z.a(), 0.0));
            }
            if (n2 != 0) {
                n2 = 0;
                this.b.d(d);
            }
            p3 = p3.a();
            if (i) {
                break;
            }
        }
    }
    
    private void a(final p p5, final p p6, final z z, final q q, final double[] array) {
        if (p6 != null) {
            final d d = (d)p6.c();
            final t t = (q == d.c()) ? this.b.p(d) : this.b.q(d);
            array[1] = z.d(t.a, t.b);
        }
        if (p5 != null) {
            final d d2 = (d)p5.c();
            final t t2 = (q == d2.c()) ? this.b.p(d2) : this.b.q(d2);
            array[0] = z.d(t2.a, t2.b);
        }
    }
    
    private p a(p a, final q q, final int[] array) {
        if (a == null) {
            array[0] = 0;
            return null;
        }
        final d d = (d)a.c();
        boolean b = (d.c() == q) ? this.d(d) : this.e(d);
        if (b) {
            array[0] = 0;
            return a;
        }
        int n = 0;
        while (!b) {
            a = a.a();
            ++n;
            if (a == null) {
                array[0] = n;
                return null;
            }
            final d d2 = (d)a.c();
            b = ((d2.c() == q) ? this.d(d2) : this.e(d2));
            if (b) {
                array[0] = n;
                return a;
            }
        }
        return null;
    }
    
    public f f() {
        return this.q.d();
    }
    
    aE a(final d d) {
        if (this.A == null) {
            return y.f.c.x.M;
        }
        return (aE)this.A.b(d);
    }
    
    aE b(final d d) {
        if (this.B == null) {
            return y.f.c.x.N;
        }
        return (aE)this.B.b(d);
    }
    
    private boolean d(final d d) {
        if (d == null) {
            return false;
        }
        final aE a = this.a(d);
        return a != null && a.a();
    }
    
    private boolean e(final d d) {
        if (d == null) {
            return false;
        }
        final aE b = this.b(d);
        return b != null && b.a();
    }
    
    static int a(final byte b, final int n) {
        switch (b) {
            default: {
                return n;
            }
            case 1: {
                return 0;
            }
            case 4: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 8: {
                return 3;
            }
        }
    }
    
    public void b(final double o) {
        this.O = o;
        this.q.b(o);
        this.r.b(o);
    }
    
    public void c(final double p) {
        this.P = p;
    }
    
    static {
        x.a = new y(0.0, 0.0, 0.0, 0.0);
        M = aE.a((byte)2);
        N = aE.a((byte)1);
    }
}
