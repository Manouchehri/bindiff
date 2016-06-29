package y.f.f.a.b;

import y.c.*;
import y.f.f.a.a.*;
import java.util.*;

public class u
{
    private a a;
    private i b;
    private p c;
    private d d;
    
    public u(final a a) {
        this.d = null;
        this.a = a;
        this.b = this.a.d();
        this.c = this.a.b();
    }
    
    public void a(final f f) {
        final boolean c = y.f.f.a.b.a.c;
        this.c(f);
        final e a = f.a();
        while (a.f()) {
            this.d = a.a();
            if (!this.a.t(this.d)) {
                if (this.a.A(this.d) >= 1) {
                    final f d = this.a.d(this.d);
                    if (d != null) {
                        if (y.b(this.a, this.d)) {
                            this.b(d);
                            y.a(this.a, this.d);
                        }
                    }
                }
            }
            a.g();
            if (c) {
                break;
            }
        }
    }
    
    public void b(final f f) {
        final boolean c = y.f.f.a.b.a.c;
        final e a = f.a();
        while (a.f()) {
            this.a(a.a());
            a.g();
            if (c) {
                break;
            }
        }
    }
    
    public void a(final d d) {
        final boolean c = y.f.f.a.b.a.c;
        final d c2 = this.a.c(d);
        this.a.g(d);
        this.a.h(d);
        final q c3 = d.c();
        final q d2 = d.d();
        final b a = this.c.a(c3);
        final b a2 = this.c.a(d2);
        if (a == a2.c()) {
            this.a.b(c3, d);
            this.a.a(d2, c2);
            this.b.a(d);
            this.b.a(c2);
            if (!this.a.d(d2)) {
                return;
            }
            this.a(d2);
            if (!c) {
                return;
            }
        }
        if (a2 == a.c()) {
            this.a.b(d2, c2);
            this.a.a(c3, d);
            this.b.a(d);
            this.b.a(c2);
            if (!this.a.d(c3)) {
                return;
            }
            this.a(c3);
            if (!c) {
                return;
            }
        }
        this.a.a(d2, c2);
        this.a.a(c3, d);
        this.b.a(d);
        this.b.a(c2);
        if (this.a.d(c3)) {
            this.a(c3);
        }
        if (this.a.d(d2)) {
            this.a(d2);
        }
    }
    
    private void a(final q q) {
        final boolean c = y.f.f.a.b.a.c;
        if (q.c() == 2) {
            d d = this.a.a(q).b();
            d d2 = null;
            d d3 = null;
            Label_0101: {
                if (this.a.a(d)) {
                    d2 = this.a.c(d);
                    d = this.a.h(d2);
                    d3 = this.a.c(d);
                    if (!c) {
                        break Label_0101;
                    }
                }
                d3 = this.a.c(d);
                d2 = this.a.g(d);
                this.a.c(d2);
            }
            final d e = this.a.e(d2);
            final f f = this.a.f(d2);
            this.a.z(e);
            d a = null;
            d d4 = null;
            Label_0415: {
                if (f.size() == 2) {
                    a = e;
                    d4 = this.a.c(a);
                    this.b.e(a);
                    Label_0193: {
                        if (d4 != null) {
                            this.b.e(d4);
                            if (!c) {
                                break Label_0193;
                            }
                        }
                        d4 = this.a.k(a);
                    }
                    this.a.b(a, false);
                    if (!c) {
                        break Label_0415;
                    }
                }
                final d g = this.a.g(d2);
                final d h = this.a.h(d);
                a = this.b.a(d2.c(), d.d());
                d4 = this.a.k(a);
                this.a.a(a, f.a(a, this.a.j(d2)));
                f.remove(d2);
                f.remove(d);
                if (g != null) {
                    if (this.a.i(d2) == g) {
                        this.a.c(a, g);
                    }
                    if (this.a.i(g) == d2) {
                        this.a.c(g, a);
                    }
                }
                if (h != null) {
                    if (this.a.i(d) == h) {
                        this.a.c(a, h);
                    }
                    if (this.a.i(h) == d) {
                        this.a.c(h, a);
                    }
                }
                this.a.b(a, e);
            }
            final q c2 = a.c();
            final q d5 = a.d();
            final b a2 = this.c.a(c2);
            final b a3 = this.c.a(d5);
            Label_0556: {
                if (a3 == a2.c()) {
                    this.a.c(c2, d2, a);
                    this.a.e(d5, d3, d4);
                    if (!c) {
                        break Label_0556;
                    }
                }
                if (a2 == a3.c()) {
                    this.a.e(c2, d2, a);
                    this.a.c(d5, d3, d4);
                    if (!c) {
                        break Label_0556;
                    }
                }
                this.a.c(c2, d2, a);
                this.a.c(d5, d3, d4);
            }
            this.a.z(this.d);
            this.c.a(this.c.a(q));
            this.b.a(q);
        }
    }
    
    private void c(final f f) {
        f.sort(new v(this));
    }
    
    static a a(final u u) {
        return u.a;
    }
}
