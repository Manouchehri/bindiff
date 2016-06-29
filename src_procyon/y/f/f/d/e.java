package y.f.f.d;

import y.f.*;
import y.f.f.b.*;
import y.d.*;
import y.c.*;

public class e
{
    private X a;
    private int b;
    private A c;
    private h d;
    private h e;
    private h f;
    private h g;
    
    public e(final X a, final int b) {
        this.a = a;
        this.b = b;
        this.d = a.u();
        this.e = a.u();
        this.f = a.u();
        this.g = a.u();
        a.a("MIN_DIST_DP_KEY", this.c = a.t());
    }
    
    public f a(final q q, final double n, final double n2, final double n3, final double n4) {
        if (this.c == null) {
            return null;
        }
        final f f = new f(this, q, n, n2, n3, n4);
        this.c.a(q, f);
        this.a.a(q, f.e());
        return f;
    }
    
    private void b() {
        this.a.a(this.d);
        this.a.a(this.e);
        this.a.a(this.f);
        this.a.a(this.g);
        this.a.d_("MIN_DIST_DP_KEY");
        this.a.a(this.c);
    }
    
    private o a(final d d, final boolean b) {
        final D m = this.a.m(d);
        if (!b) {
            m.n();
        }
        final t t = (t)m.g();
        final t t2 = (t)m.g();
        if (t.a() == t2.a()) {
            if (t.b() < t2.b()) {
                return o.c;
            }
            return o.a;
        }
        else {
            if (t.a() < t2.a()) {
                return o.b;
            }
            return o.d;
        }
    }
    
    public void a() {
        final boolean p = y.f.f.d.o.p;
        if (this.c == null) {
            return;
        }
        final y.c.e p2 = this.a.p();
        while (true) {
            while (p2.f()) {
                final d a = p2.a();
                this.d.a(a, this.a(a, true));
                this.e.a(a, this.a(a, false));
                this.f.a(a, this.a.p(a));
                final e e = this;
                if (p) {
                    final x o = e.a.o();
                    while (o.f()) {
                        final f f = (f)this.c.b(o.e());
                        if (p) {
                            return;
                        }
                        if (f != null) {
                            f.f();
                        }
                        o.g();
                        if (p) {
                            break;
                        }
                    }
                    this.b();
                    return;
                }
                this.g.a(a, this.a.q(a));
                p2.g();
                if (p) {
                    break;
                }
            }
            final e e = this;
            continue;
        }
    }
    
    static int a(final e e) {
        return e.b;
    }
    
    static X b(final e e) {
        return e.a;
    }
    
    static h c(final e e) {
        return e.f;
    }
    
    static h d(final e e) {
        return e.d;
    }
    
    static h e(final e e) {
        return e.g;
    }
    
    static h f(final e e) {
        return e.e;
    }
}
