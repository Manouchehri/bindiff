package y.f.f.a.b;

import y.c.*;
import y.f.f.a.a.*;

public class y
{
    private a a;
    private i b;
    private p c;
    private A d;
    private d e;
    private d f;
    private d g;
    private boolean h;
    private f i;
    
    public y(final a a) {
        this.h = true;
        this.a = a;
        this.b = this.a.d();
        this.c = this.a.b();
    }
    
    public void a() {
        if (this.d != null) {
            this.d.a();
        }
    }
    
    public void a(final boolean h) {
        this.h = h;
    }
    
    public static void a(final a a, final d d) {
        final y y = new y(a);
        y.h = false;
        y.a(new f(d));
        y.a();
    }
    
    public static boolean b(final a a, final d d) {
        final f f = new f();
        final f d2 = a.d(d);
        final y y = new y(a);
        y.d = new A(a);
        y.h = false;
        final double a2 = y.d.a(d, f);
        y.a();
        return a2 <= d2.size();
    }
    
    public void a(final f f) {
        final boolean c = y.f.f.a.b.a.c;
        final e a = f.a();
        while (a.f()) {
            if (this.d == null) {
                this.d = new A(this.a);
            }
            this.g = a.a();
            Label_0101: {
                if (this.g.e()) {
                    this.a(this.g);
                    if (!c) {
                        break Label_0101;
                    }
                }
                this.b(this.d.a(this.g.c(), this.g.d()));
            }
            if (!this.h) {
                this.d.a();
                this.d = null;
            }
            a.g();
            if (c) {
                break;
            }
        }
    }
    
    private void a(final d d) {
        final q c = d.c();
        final d k = this.a.k(d);
        final f a = this.a.a(c);
        a.a(d);
        a.a(k);
        if (this.h) {
            this.a(this.a.b(a.c()), d);
        }
    }
    
    private void b(final f f) {
        final boolean c = y.f.f.a.b.a.c;
        final e a = f.a();
        while (a.f()) {
            final d a2 = a.a();
            final int a3 = this.d.a(a2);
            d d = null;
            Label_0124: {
                switch (a3) {
                    case 0: {
                        d = this.b(a2);
                        if (c) {
                            break Label_0124;
                        }
                        break;
                    }
                    case 1: {
                        d = this.c(a2);
                        if (c) {
                            break Label_0124;
                        }
                        break;
                    }
                    case 2: {
                        d = this.f(a2);
                        if (c) {
                            break Label_0124;
                        }
                        break;
                    }
                    case 3: {
                        d = this.d(a2);
                        if (c) {
                            break Label_0124;
                        }
                        break;
                    }
                    case 4: {
                        d = this.e(a2);
                        if (c) {
                            throw new RuntimeException("Bad routing edge type!");
                        }
                        break;
                    }
                }
            }
            if (this.h && a3 != 0) {
                this.a(this.d.a(a2.c()), d);
            }
            a.g();
            if (c) {
                break;
            }
        }
    }
    
    private d b(final d d) {
        this.e = this.b.a(this.g.c(), this.g.d());
        this.a.b(this.g.c(), this.a(this.g.c(), d.d()), this.e);
        this.i = new f();
        this.a.a(this.e, this.i.b(this.e));
        this.a.b(this.e, this.g);
        return null;
    }
    
    private d c(final d d) {
        this.f = this.a.k(this.e);
        this.a.b(this.g.d(), this.a(this.g.d(), d.c()), this.f);
        this.a.a(this.g, this.i);
        return this.e;
    }
    
    private d d(final d d) {
        final q b = this.d.b(d);
        this.b.a(this.e, this.e.c(), b);
        this.f = this.a.k(this.e);
        final d a = this.a(b, this.f);
        this.a.d(b, a, this.f);
        final d e = this.e;
        this.e = this.b.a(b, this.g.d());
        d d2 = this.a.i(a);
        if (d2.c() != b) {
            d2 = this.a.c(d2);
        }
        this.a.a(b, d2, this.e);
        this.a.c(e, this.e);
        this.a.a(this.e, this.i.b(this.e));
        this.a.b(this.e, this.g);
        return e;
    }
    
    private d e(final d d) {
        final q b = this.d.b(d);
        this.b.a(this.e, this.e.c(), b);
        this.f = this.a.k(this.e);
        final d a = this.a(b, d.d());
        d d2 = this.a.i(a);
        if (d2.c() != b) {
            d2 = this.a.c(d2);
        }
        this.a.a(b, d2, this.f);
        final d e = this.e;
        this.e = this.b.a(b, this.g.d());
        this.a.d(b, a, this.e);
        this.a.a(this.e, this.i.b(this.e));
        this.a.b(this.e, this.g);
        this.a.c(this.e, e);
        return e;
    }
    
    private d f(final d d) {
        final boolean c = y.f.f.a.b.a.c;
        d c2 = this.d.c(d);
        d c3 = this.a.c(c2);
        q d2 = c2.d();
        q c4 = c2.c();
        b a = this.c.a(d2);
        b a2 = this.c.a(c4);
        boolean b = false;
        if (a2 == a.c()) {
            b = true;
            final q q = d2;
            d2 = c4;
            c4 = q;
            final b b2 = a;
            a = a2;
            a2 = b2;
            final d d3 = c3;
            c3 = c2;
            c2 = d3;
        }
        q q2;
        d d6 = null;
        d d7 = null;
        if (a == a2.c()) {
            q2 = this.b.d();
            this.a.c(q2);
            a.a(this.c.a(a, q2));
            d d5;
            d d8;
            if (!this.a.a(c3)) {
                final d h = this.a.h(c3);
                final d i = this.a.i(c3);
                final d e = this.a.e(c3);
                final f d4 = this.a.d(e);
                this.a.y(e);
                d5 = this.b.a(d2, q2);
                d6 = this.a.k(d5);
                d7 = this.b.a(q2, c4);
                d8 = this.a.k(d7);
                this.a.b(d5, e);
                this.a.b(d7, e);
                this.a.a(d5, d4.a(d5, this.a.j(c3)));
                this.a.a(d7, d4.a(d7, this.a.j(c3)));
                d4.remove(c3);
                this.a.c(d5, i);
                if (h != null && this.a.i(h) != null) {
                    this.a.c(h, d7);
                }
            }
            else {
                final d g = this.a.g(c2);
                final d j = this.a.i(c2);
                final d e2 = this.a.e(c2);
                final f d9 = this.a.d(e2);
                this.a.y(e2);
                d6 = this.b.a(q2, d2);
                d5 = this.a.k(d6);
                d8 = this.b.a(c4, q2);
                d7 = this.a.k(d8);
                this.a.b(d6, e2);
                this.a.b(d8, e2);
                this.a.a(d8, d9.a(d8, this.a.j(c2)));
                this.a.a(d6, d9.a(d6, this.a.j(c2)));
                d9.remove(c2);
                this.a.c(d6, j);
                if (g != null && this.a.i(g) != null) {
                    this.a.c(g, d8);
                }
            }
            this.a.e(d2, c3, d5);
            this.a.a(q2).add(d6);
            this.a.c(c4, c2, d8);
            this.a.a(q2).add(d7);
            this.g(c3);
            this.g(c2);
        }
        else {
            q2 = this.b.d();
            this.a.c(q2);
            final b b3 = (b)a.c();
            b3.a(this.c.a(b3, q2));
            d d10 = null;
            d d11 = null;
            Label_1431: {
                if (!this.a.a(c3)) {
                    d10 = this.b.a(d2, q2);
                    d6 = this.a.k(d10);
                    d7 = this.b.a(q2, c4);
                    d11 = this.a.k(d7);
                    final d e3 = this.a.e(c3);
                    if (e3 == null) {
                        final f f = new f();
                        this.a.a(c3, f);
                        this.a.a(d10, f.b(d10));
                        this.a.a(d7, f.b(d7));
                        this.a.b(d10, c3);
                        this.a.b(d7, c3);
                        this.a.y(c3);
                        if (!c) {
                            break Label_1431;
                        }
                    }
                    this.a.y(e3);
                    final f d12 = this.a.d(e3);
                    final d h2 = this.a.h(c3);
                    final d g2 = this.a.g(c3);
                    this.a.a(d10, d12.a(d10, this.a.j(c3)));
                    this.a.a(d7, d12.a(d7, this.a.j(c3)));
                    d12.remove(c3);
                    this.a.b(d10, e3);
                    this.a.b(d7, e3);
                    if (h2 != null && this.a.i(h2) == c3) {
                        this.a.c(h2, d7);
                    }
                    if (g2 != null && this.a.i(g2) == c3) {
                        this.a.c(g2, d10);
                    }
                }
                else {
                    d11 = this.b.a(c4, q2);
                    d7 = this.a.k(d11);
                    d6 = this.b.a(q2, d2);
                    d10 = this.a.k(d6);
                    final d e4 = this.a.e(c2);
                    if (e4 == null) {
                        final f f2 = new f();
                        this.a.a(c2, f2);
                        this.a.a(d11, f2.b(d11));
                        this.a.a(d6, f2.b(d6));
                        this.a.b(d11, c2);
                        this.a.b(d6, c2);
                        this.a.y(c2);
                        if (!c) {
                            break Label_1431;
                        }
                    }
                    this.a.y(e4);
                    final f d13 = this.a.d(e4);
                    final d h3 = this.a.h(c2);
                    final d g3 = this.a.g(c2);
                    this.a.a(d11, d13.a(d11, this.a.j(c2)));
                    this.a.a(d6, d13.a(d6, this.a.j(c2)));
                    d13.remove(c2);
                    this.a.b(d11, e4);
                    this.a.b(d6, e4);
                    if (h3 != null && this.a.i(h3) == c2) {
                        this.a.c(h3, d6);
                    }
                    if (g3 != null && this.a.i(g3) == c2) {
                        this.a.c(g3, d11);
                    }
                }
            }
            this.a.c(d2, c3, d10);
            this.a.a(q2).add(d6);
            this.a.c(c4, c2, d11);
            this.a.a(q2).add(d7);
            this.g(c3);
            this.g(c2);
        }
        this.a.y(this.g);
        this.b.a(this.e, this.e.c(), q2);
        final d e5 = this.e;
        final d k = this.a.k(e5);
        Label_1579: {
            if (b) {
                this.a.a(q2, d6, k);
                if (!c) {
                    break Label_1579;
                }
            }
            this.a.a(q2, d7, k);
        }
        this.e = this.b.a(q2, this.g.d());
        Label_1639: {
            if (b) {
                this.a.a(q2, d7, this.e);
                if (!c) {
                    break Label_1639;
                }
            }
            this.a.a(q2, d6, this.e);
        }
        this.a.b(this.e, this.g);
        this.a.a(this.e, this.i.b(this.e));
        return e5;
    }
    
    private d a(final q q, final d d) {
        final boolean c = y.f.f.a.b.a.c;
        d l = this.a.l(d);
        d i = null;
        while (l.c() != q) {
            i = this.a.l(l);
            if (c) {
                return i;
            }
            l = i;
            if (c) {
                break;
            }
        }
        return i;
    }
    
    private d a(final q q, final q q2) {
        d a = null;
        final e a2 = this.d.a(q2).a();
        while (a2.f()) {
            if (a2.a().c() == q) {
                a = a2.a();
                break;
            }
            a2.g();
        }
        return a;
    }
    
    private void a(final y.f.h.p p2, final d d) {
        final q d2 = d.d();
        y.f.h.p[] array = null;
        Label_0046: {
            if (this.a.d(d2)) {
                array = this.a.a(p2, d, d2);
                if (!y.f.f.a.b.a.c) {
                    break Label_0046;
                }
            }
            array = this.a.a(p2, d);
        }
        this.d.a(p2, array);
    }
    
    private void g(final d d) {
        if (this.a.n(d)) {
            this.b.a(d);
            if (!y.f.f.a.b.a.c) {
                return;
            }
        }
        this.b.d(d);
    }
}
