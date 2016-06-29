package y.f.f.a;

import y.f.f.a.a.*;
import y.d.*;
import y.c.*;

class j implements h
{
    private final f a;
    
    private j(final f a) {
        this.a = a;
    }
    
    public void a(final e e) {
        final boolean a = f.a;
        if (e.e()) {
            return;
        }
        if (e.d()) {
            return;
        }
        final q b_ = ((b)e).b_();
        final y.c.f b = f.a(this.a).b(b_);
        if (b.size() == 0) {
            return;
        }
        final y.c.f f = new y.c.f();
        final y y = new y();
        final y.c.e a2 = b.a();
        a2.j();
        while (a2.f()) {
            final d a3 = a2.a();
            final d c = y.f.f.a.f.a(this.a).c(a3);
            d d = y.f.f.a.f.a(this.a).i(a3);
            d c2 = null;
            Label_0182: {
                if (d.d() == b_) {
                    c2 = d;
                    d = y.f.f.a.f.a(this.a).c(d);
                    if (!a) {
                        break Label_0182;
                    }
                }
                c2 = y.f.f.a.f.a(this.a).c(d);
            }
            final q d2 = y.f.f.a.f.b(this.a).d();
            y.f.f.a.f.a(this.a).e(d2);
            y.f.f.a.f.b(this.a).a(a3, d2, a3.d());
            y.f.f.a.f.b(this.a).a(d, d2, d.d());
            y.f.f.a.f.b(this.a).a(c, c.c(), d2);
            y.f.f.a.f.b(this.a).a(c2, c2.c(), d2);
            final y.c.f a4 = y.f.f.a.f.a(this.a).a(d2);
            a4.b(a3);
            a4.b(d);
            y.b(d2);
            a2.h();
            if (a) {
                break;
            }
        }
        Object a5 = null;
        if (y.f.f.a.f.c(this.a) != null) {
            a5 = r.a(y.f.f.a.f.c(this.a).b(b_));
        }
        final y.c.f f2 = new y.c.f();
        q c3 = y.c();
        final x a6 = y.a();
        while (true) {
            while (a6.f()) {
                final q e2 = a6.e();
                final d a7 = y.f.f.a.f.b(this.a).a(c3, e2);
                final f a8 = this.a;
                if (a) {
                    y.f.f.a.f.b(a8).c(b_);
                    return;
                }
                if (y.f.f.a.f.c(a8) != null) {
                    y.f.f.a.f.d(this.a).a(a7, a5);
                }
                y.f.f.a.f.a(this.a).u(a7);
                y.f.f.a.f.e(this.a).a(a7, b_);
                final d k = y.f.f.a.f.a(this.a).k(a7);
                y.f.f.a.f.a(this.a).u(k);
                y.f.f.a.f.e(this.a).a(k, b_);
                y.f.f.a.f.a(this.a).c().m(k);
                f2.b(a7);
                y.f.f.a.f.a(this.a).a(c3, y.f.f.a.f.a(this.a).a(c3).c(), a7);
                y.f.f.a.f.a(this.a).a(e2, y.f.f.a.f.a(this.a).a(e2).b(), k);
                c3 = e2;
                a6.g();
                if (a) {
                    break;
                }
            }
            y.f.f.a.f.a(this.a).c(b_, f2);
            final f a9 = this.a;
            continue;
        }
    }
    
    j(final f f, final g g) {
        this(f);
    }
}
