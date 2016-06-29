package y.f.f.a.b;

import y.c.*;
import y.f.f.a.a.*;

public class m
{
    private a a;
    private i b;
    private p c;
    
    public m(final a a) {
        this.a = a;
        this.b = this.a.d();
        this.c = this.a.b();
    }
    
    public static f a(final a a) {
        return new m(a).a();
    }
    
    public f a() {
        final boolean c = y.f.f.a.b.a.c;
        final f f = new f();
        this.a.g();
        final d[] n = this.b.n();
        int i = 0;
        f a = null;
        while (i < n.length) {
            a = this.a(n[i]);
            if (c) {
                return a;
            }
            if (a != null) {
                f.add(n[i]);
            }
            ++i;
            if (c) {
                break;
            }
        }
        this.a.h();
        return a;
    }
    
    public f a(d c) {
        final boolean c2 = y.f.f.a.b.a.c;
        if (!this.b.f(c)) {
            return null;
        }
        if (this.a.a(c)) {
            c = this.a.c(c);
        }
        final d c3 = this.a.c(c);
        b a = this.c.a(c.c());
        b a2 = this.c.a(c.d());
        if (n.a(a, a2)) {
            return null;
        }
        final D d = new D();
        final f f = new f();
        this.a.a(c, f);
        while (a2.b() > a.b()) {
            d.c(a2);
            a2 = (b)a2.c();
            if (c2) {
                break;
            }
        }
        d d2 = null;
        d d3 = null;
        while (true) {
            while (!n.a(a, a2)) {
                final b b = (b)a.c();
                final d a3 = this.b.a(a.b_(), b.b_());
                this.a.k(a3);
                final y.c.p b2 = f.b(a3);
                if (c2) {
                    while (!d.isEmpty()) {
                        final b b3 = (b)d.g();
                        final d a4 = this.b.a(a.b_(), b3.b_());
                        this.a.k(a4);
                        this.a.a(a4, f.b(a4));
                        this.a.b(a4, c);
                        this.a.c(a4, d3);
                        if (c2) {
                            return f;
                        }
                        if (d2 != null && d3 == null) {
                            this.a.c(d2, a4);
                        }
                        d3 = a4;
                        d2 = a4;
                        a = b3;
                        if (c2) {
                            break;
                        }
                    }
                    this.a.c(c.c(), c, f.b());
                    this.a.c(c.d(), c3, this.a.c(f.c()));
                    this.b.d(c);
                    this.b.d(c3);
                    return f;
                }
                this.a.a(a3, b2);
                this.a.b(a3, c);
                if (d2 != null) {
                    this.a.c(d2, a3);
                }
                if (a.b() == a2.b()) {
                    d.c(a2);
                    a2 = (b)a2.c();
                }
                d2 = a3;
                a = b;
                if (c2) {
                    break;
                }
            }
            d.c(a2);
            continue;
        }
    }
}
