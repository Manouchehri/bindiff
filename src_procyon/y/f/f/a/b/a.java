package y.f.f.a.b;

import y.f.f.a.a.*;
import y.f.*;
import y.f.h.*;
import y.c.*;
import java.util.*;

public class a
{
    i a;
    D b;
    private p d;
    private A e;
    private h f;
    private final l g;
    public static boolean c;
    
    public a(final X a, final p d) {
        this.g = new b(this);
        this.a = a;
        this.d = d;
        this.e = a.t();
        this.f = a.u();
    }
    
    public void a(final D b) {
        this.b = b;
    }
    
    public void a() {
        this.a.a(this.e);
        this.a.a(this.f);
    }
    
    public p b() {
        return this.d;
    }
    
    public D c() {
        return this.b;
    }
    
    public i d() {
        return this.a;
    }
    
    public boolean a(final d d) {
        return this.b.n(d);
    }
    
    public void a(final d d, final boolean b) {
        this.b.a(d, b);
    }
    
    public y.f.h.p b(final d d) {
        return this.b.i(d);
    }
    
    public d c(final d d) {
        return this.b.h(d);
    }
    
    public void a(final d d, final d d2) {
        this.b.b(d, d2);
    }
    
    public q e() {
        return this.b.h();
    }
    
    public void f() {
        this.b.a(this.g);
    }
    
    public void a(final d d, final f a) {
        Label_0022: {
            if (a == null) {
                this.b(d, false);
                if (!a.c) {
                    break Label_0022;
                }
            }
            this.b(d, true);
        }
        this.B(d).a = a;
    }
    
    public f d(d h) {
        if (this.b.n(h)) {
            h = this.b.h(h);
        }
        if (!this.v(h)) {
            return null;
        }
        return (f)this.B(h).a;
    }
    
    public void b(final d d, final d b) {
        this.B(d).b = b;
    }
    
    public d e(d h) {
        if (this.b.n(h)) {
            h = this.b.h(h);
        }
        return this.B(h).b;
    }
    
    public f f(d h) {
        if (this.b.n(h)) {
            h = this.b.h(h);
        }
        final d e = this.e(h);
        if (e != null) {
            return this.d(e);
        }
        return null;
    }
    
    public d g(d h) {
        if (this.b.n(h)) {
            h = this.b.h(h);
        }
        final y.c.p d = this.B(h).d;
        if (d == null) {
            return null;
        }
        final y.c.p b = d.b();
        if (b == null) {
            return null;
        }
        return (d)b.c();
    }
    
    public d h(d h) {
        if (this.b.n(h)) {
            h = this.b.h(h);
        }
        final y.c.p d = this.B(h).d;
        if (d == null) {
            return null;
        }
        final y.c.p a = d.a();
        if (a == null) {
            return null;
        }
        return (d)a.c();
    }
    
    public void c(final d d, final d c) {
        this.B(d).c = c;
    }
    
    public d i(d h) {
        if (this.b.n(h)) {
            h = this.b.h(h);
        }
        return this.B(h).c;
    }
    
    public void a(final d d, final y.c.p d2) {
        this.B(d).d = d2;
    }
    
    public y.c.p j(final d d) {
        return this.B(d).d;
    }
    
    public d k(final d d) {
        this.b.h(d);
        final d a = this.a.a(d.d(), d.c());
        this.b.b(d, a);
        this.b.m(a);
        return a;
    }
    
    public d l(final d d) {
        final y.f.f.a.a.b a = this.d.a(d.d());
        final y.f.f.a.a.b a2 = this.d.a(d.c());
        final d h = this.b.h(d);
        if (a == a2.c()) {
            final f f = this.b(d.d());
            if (!y.f.f.a.b.a.c) {
                return (d)f.e(f.d(h)).c();
            }
        }
        final f f = this.a(d.d());
        return (d)f.e(f.d(h)).c();
    }
    
    public void m(final d d) {
        this.B(d).e = true;
    }
    
    public boolean n(final d d) {
        return this.B(d).e;
    }
    
    public void o(final d d) {
        this.B(d).f = true;
    }
    
    public boolean p(final d d) {
        return this.B(d).f;
    }
    
    public void q(final d d) {
        this.B(d).g = true;
    }
    
    public boolean r(final d d) {
        return this.B(d).g;
    }
    
    public void s(final d d) {
        this.B(d).h = true;
    }
    
    public boolean t(final d d) {
        return this.B(d).h;
    }
    
    public void u(final d d) {
        this.B(d).i = true;
    }
    
    public void b(final d d, final boolean j) {
        this.B(d).j = j;
    }
    
    public boolean v(final d d) {
        return this.B(d).j;
    }
    
    public void d(final d d, final d a) {
        Label_0028: {
            if (a == null) {
                this.B(d).k = false;
                if (!a.c) {
                    break Label_0028;
                }
            }
            this.B(d).k = true;
        }
        this.B(d).a = a;
    }
    
    public d w(final d d) {
        if (!this.B(d).k) {
            return null;
        }
        return (d)this.B(d).a;
    }
    
    public void b(final d d, final f a) {
        Label_0028: {
            if (a == null) {
                this.B(d).l = false;
                if (!a.c) {
                    break Label_0028;
                }
            }
            this.B(d).l = true;
        }
        this.B(d).a = a;
    }
    
    public f x(final d d) {
        if (!this.B(d).l) {
            return null;
        }
        return (f)this.B(d).a;
    }
    
    public void y(final d d) {
        final y.f.f.a.b.d b = this.B(d);
        ++b.m;
    }
    
    public void z(final d d) {
        final y.f.f.a.b.d b = this.B(d);
        --b.m;
    }
    
    public int A(final d d) {
        return this.B(d).m;
    }
    
    private y.f.f.a.b.d B(final d d) {
        y.f.f.a.b.d i = (y.f.f.a.b.d)this.f.b(d);
        if (i == null) {
            i = this.i();
            this.f.a(d, i);
        }
        return i;
    }
    
    private y.f.f.a.b.d i() {
        return new y.f.f.a.b.d(null);
    }
    
    public f a(final y.c.q q) {
        return this.j(q).b;
    }
    
    public void a(final y.c.q q, final f b) {
        this.j(q).b = b;
    }
    
    public void a(final y.c.q q, final d d) {
        this.a(q).remove(d);
    }
    
    public void a(final y.c.q q, final d d, final d d2) {
        final f a = this.a(q);
        a.b(d2, a.d(d));
    }
    
    public void b(final y.c.q q, final d d, final d d2) {
        final f a = this.a(q);
        a.a(d2, a.d(d));
    }
    
    public void c(final y.c.q q, final d d, final d d2) {
        final f a = this.a(q);
        a.b(d2, a.d(d));
        a.remove(d);
    }
    
    public f b(final y.c.q q) {
        return this.j(q).c;
    }
    
    public void b(final y.c.q q, final f c) {
        this.j(q).c = c;
    }
    
    public void b(final y.c.q q, final d d) {
        this.b(q).remove(d);
    }
    
    public void d(final y.c.q q, final d d, final d d2) {
        final f b = this.b(q);
        b.a(d2, b.d(d));
    }
    
    public void e(final y.c.q q, final d d, final d d2) {
        final f b = this.b(q);
        b.b(d2, b.d(d));
        b.remove(d);
    }
    
    public void c(final y.c.q q) {
        this.j(q).a = 1;
    }
    
    public boolean d(final y.c.q q) {
        return this.j(q).a == 1;
    }
    
    public void e(final y.c.q q) {
        this.j(q).a = 2;
    }
    
    public boolean f(final y.c.q q) {
        return this.j(q).a == 2;
    }
    
    public void c(final y.c.q q, final f d) {
        this.j(q).d = d;
    }
    
    public f g(final y.c.q q) {
        return this.j(q).d;
    }
    
    private c j(final y.c.q q) {
        c c = (c)this.e.b(q);
        if (c == null) {
            c = new c(null);
            c.c = new f();
            c.b = new f();
            c.a = 0;
            c.d = null;
            this.e.a(q, c);
        }
        return c;
    }
    
    public void g() {
        final boolean c = y.f.f.a.b.a.c;
        final x o = this.a.o();
        while (o.f()) {
            this.h(o.e());
            o.g();
            if (c) {
                break;
            }
        }
    }
    
    public void h(final y.c.q q) {
        final boolean c = y.f.f.a.b.a.c;
        final f a = this.a(q);
        a.clear();
        final f b = this.b(q);
        b.clear();
        final e l = q.l();
        while (l.f()) {
            Label_0113: {
                if (this.d.a(q) != this.d.a(l.a().d()).c()) {
                    a.b(l.a());
                    if (!c) {
                        break Label_0113;
                    }
                }
                b.b(l.a());
            }
            l.g();
            if (c) {
                break;
            }
        }
    }
    
    public void h() {
        final boolean c = y.f.f.a.b.a.c;
        final x o = this.a.o();
        while (o.f()) {
            this.i(o.e());
            o.g();
            if (c) {
                break;
            }
        }
    }
    
    public void i(final y.c.q q) {
        final f f = new f();
        f.a(this.b(q).a());
        f.a(this.a(q).a());
        q.b(new y.f.f.a.b.e(f));
    }
    
    public y.f.h.p[] a(final y.f.h.p p2, final d d) {
        this.b.b.remove(p2);
        final y.f.h.p[] array = new y.f.h.p[2];
        final boolean[] array2 = new boolean[this.a.g()];
        array[0] = this.b.a(d, this.g, array2);
        array[1] = this.b.a(this.c(d), this.g, array2);
        return array;
    }
    
    public y.f.h.p[] a(final y.f.h.p p3, final d d, final y.c.q q) {
        final boolean c = y.f.f.a.b.a.c;
        d c2 = d;
        if (d.d() == q) {
            c2 = this.c(d);
        }
        final f a = this.a(q);
        final y.c.p e = a.e(a.d(c2));
        final d c3 = this.c((d)e.c());
        final d d2 = (d)a.e(a.e(e)).c();
        d d3 = null;
        final e a2 = p3.a();
        while (true) {
            while (a2.f()) {
                final d a3;
                d3 = (a3 = a2.a());
                if (c) {
                    if (a3 == null) {
                        System.out.println("Error in splitFace!");
                    }
                    final d c4 = this.c(d3);
                    final y.f.h.p b = this.b(c4);
                    b.a(c4, c3, d2);
                    this.b.a(c3, b);
                    this.b.a(d2, b);
                    final y.f.h.p[] a4 = this.a(p3, d);
                    if (i.g) {
                        y.f.f.a.b.a.c = !c;
                    }
                    return a4;
                }
                if (a3.c() == d2.d() && d3.d() == c3.c()) {
                    break;
                }
                a2.g();
                if (c) {
                    break;
                }
            }
            continue;
        }
    }
}
