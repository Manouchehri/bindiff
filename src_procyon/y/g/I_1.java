package y.g;

import y.c.*;

public class I
{
    private i c;
    protected f a;
    protected y b;
    private boolean d;
    
    public I(final i c) {
        this.d = true;
        this.c = c;
        this.a = new f();
        this.b = new y();
    }
    
    public void a() {
        final boolean c = p.c;
        final x o = this.c.o();
        while (o.f()) {
            this.a(o.e());
            o.g();
            if (c) {
                break;
            }
        }
    }
    
    public void b() {
        final boolean c = p.c;
        final e p = this.c.p();
        while (p.f()) {
            this.a(p.a());
            p.g();
            if (c) {
                break;
            }
        }
    }
    
    public void c() {
        final boolean c = p.c;
        final e p = this.c.p();
        while (p.f()) {
            if (p.a().e()) {
                this.a(p.a());
            }
            p.g();
            if (c) {
                break;
            }
        }
    }
    
    public void d() {
        this.c();
        this.e();
    }
    
    public void e() {
        final boolean c = p.c;
        final A t = this.c.t();
        final x o = this.c.o();
    Label_0147_Outer:
        while (o.f()) {
            final q e = o.e();
            if (!c) {
                e e2 = e.j();
                while (true) {
                    while (e2.f()) {
                        final d a = e2.a();
                        final q a2 = a.a(e);
                        final d d2;
                        final d d = d2 = (d)t.b(a2);
                        if (!c) {
                            Label_0129: {
                                if (d2 != a) {
                                    if (d == null) {
                                        t.a(a2, a);
                                        if (!c) {
                                            break Label_0129;
                                        }
                                    }
                                    this.a(a);
                                }
                            }
                            e2.g();
                            if (c) {
                                break;
                            }
                            continue Label_0147_Outer;
                        }
                        else {
                            while (true) {
                                t.a(d2.a(e), null);
                                e2.g();
                                if (!c) {
                                    if (!c) {
                                        if (e2.f()) {
                                            e2.a();
                                            continue Label_0147_Outer;
                                        }
                                    }
                                    o.g();
                                }
                                break;
                            }
                            if (c) {
                                break Label_0147_Outer;
                            }
                            continue Label_0147_Outer;
                        }
                    }
                    e2 = e.j();
                    continue;
                }
            }
            return;
        }
        this.c.a(t);
    }
    
    public void f() {
        this.g();
        this.h();
    }
    
    public void g() {
        final boolean c = p.c;
        while (!this.b.isEmpty()) {
            final q d = this.b.d();
            if (!this.c.f(d)) {
                this.b(d);
                if (c) {
                    break;
                }
                continue;
            }
        }
    }
    
    public void h() {
        final boolean c = p.c;
        while (!this.a.isEmpty()) {
            final d d = this.a.d();
            if (!this.c.f(d)) {
                this.b(d);
                if (c) {
                    break;
                }
                continue;
            }
        }
    }
    
    public void a(final q q) {
        final boolean c = p.c;
        d d = q.g();
    Label_0144:
        while (true) {
            while (d != null) {
                final d d2 = d;
                d = d.h();
                this.a.c(d2);
                final boolean d3 = this.d;
                if (c) {
                    if (d3) {
                        this.c.c(q);
                        if (!c) {
                            return;
                        }
                    }
                    this.c.a(q);
                    return;
                }
                if (d3) {
                    this.c.d(d2);
                    if (!c) {
                        continue;
                    }
                }
                this.c.a(d2);
                if (c) {
                    break;
                }
            }
            d d4 = q.f();
            while (d4 != null) {
                final d d5 = d4;
                d4 = d4.g();
                this.a.c(d5);
                final boolean d6 = this.d;
                if (c) {
                    continue Label_0144;
                }
                if (d6) {
                    this.c.d(d5);
                    if (!c) {
                        continue;
                    }
                }
                this.c.a(d5);
                if (c) {
                    break;
                }
            }
            this.b.c(q);
            final boolean d7 = this.d;
            continue Label_0144;
        }
    }
    
    public void a(final d d) {
        this.a.c(d);
        if (this.d) {
            this.c.d(d);
            if (!p.c) {
                return;
            }
        }
        this.c.a(d);
    }
    
    public void a(final f f) {
        final boolean c = p.c;
        y.c.p p = f.k();
        while (p != null) {
            this.a((d)p.c());
            p = p.a();
            if (c) {
                break;
            }
        }
    }
    
    public void a(final y y) {
        final boolean c = p.c;
        y.c.p p = y.k();
        while (p != null) {
            this.a((q)p.c());
            p = p.a();
            if (c) {
                break;
            }
        }
    }
    
    public void a(final e e) {
        final boolean c = p.c;
        while (e.f()) {
            this.a(e.a());
            e.g();
            if (c) {
                break;
            }
        }
    }
    
    public static void a(final i i, final e e) {
        final boolean c = p.c;
        e.i();
        while (e.f()) {
            final d a = e.a();
            if (!i.f(a.c())) {
                i.d(a.c());
            }
            if (!i.f(a.d())) {
                i.d(a.d());
            }
            if (!i.f(a)) {
                i.e(a);
            }
            e.g();
            if (c) {
                break;
            }
        }
    }
    
    public i i() {
        return this.c;
    }
    
    protected void b(final d d) {
        if (this.d) {
            this.c.e(d);
            if (!p.c) {
                return;
            }
        }
        this.c.b(d);
    }
    
    public void c(final d d) {
        if (d.a() == null) {
            this.b(d);
        }
        this.a.remove(d);
    }
    
    public void a(final y y, final boolean b) {
        final boolean c = p.c;
        final y y2 = new y();
        y.c.p p2 = y.k();
        while (true) {
        Label_0136_Outer:
            while (p2 != null) {
                final q q = (q)p2.c();
                final i e = q.e();
                if (c) {
                    final A a = M.a(new boolean[e.e()]);
                    y.c.p p3 = y2.k();
                    while (true) {
                    Label_0199_Outer:
                        while (p3 != null) {
                            a.a(p3.c(), true);
                            p3 = p3.a();
                            if (!c) {
                                if (c) {
                                    break;
                                }
                                continue Label_0136_Outer;
                            }
                            else {
                                while (true) {
                                    while (p3 != null) {
                                        Object o;
                                        final i i = (i)(o = ((q)p3.c()).e());
                                        if (c) {
                                            while (true) {
                                                final d d = (d)o;
                                                if (d.c().e() == this.c && d.d().e() == this.c && (a.d(d.d()) || a.d(d.c()))) {
                                                    this.a.h(p3);
                                                    this.b(d);
                                                }
                                                p3 = p3.a();
                                                if (!c) {
                                                    if (p3 != null) {
                                                        o = p3.c();
                                                        continue Label_0199_Outer;
                                                    }
                                                }
                                                break;
                                            }
                                            return;
                                        }
                                        if (i == this.c) {
                                            this.b.h(p3);
                                        }
                                        p3 = p3.a();
                                        if (c) {
                                            break;
                                        }
                                    }
                                    if (b) {
                                        p3 = this.a.k();
                                        continue;
                                    }
                                    break;
                                }
                                return;
                            }
                        }
                        p3 = this.b.k();
                        continue;
                    }
                }
                if (e == null) {
                    this.b(q);
                    y2.add(q);
                }
                p2 = p2.a();
                if (c) {
                    break;
                }
            }
            final i c2 = this.c;
            continue;
        }
    }
    
    public void a(final q q, final boolean b) {
        final boolean c = p.c;
        if (q.e() == null) {
            this.b(q);
        }
        this.b.remove(q);
        if (b) {
            y.c.p p2 = this.a.k();
            while (p2 != null) {
                final d d = (d)p2.c();
                if ((d.c() == q && d.d().e() == this.c) || (d.d() == q && d.c().e() == this.c)) {
                    this.a.h(p2);
                    this.b(d);
                }
                p2 = p2.a();
                if (c) {
                    break;
                }
            }
        }
    }
    
    protected void b(final q q) {
        if (this.d) {
            this.c.d(q);
            if (!p.c) {
                return;
            }
        }
        this.c.b(q);
    }
}
