package y.h.a;

import y.c.*;

final class D extends G
{
    private final v f;
    
    D(final v f, final q q) {
        super(f, q);
        this.f = f;
        this.c = this.a(q);
    }
    
    d a(q q) {
        final int a = v.a;
        d d = null;
        final q q2 = (q)v.e(this.f).b(q);
        if (q.b() > 0) {
            d = q.i();
            q = d.c();
            q q3 = (q)v.e(this.f).b(q);
            while (q.b() > 0 && (q3 == null || !this.f.j(q3))) {
                d = q.i();
                q = d.c();
                q3 = (q)v.e(this.f).b(q);
                if (a != 0) {
                    break;
                }
            }
        }
        return d;
    }
    
    d a(final d d) {
        return d.j();
    }
    
    void a() {
        final int a = v.a;
        if (this.c == null) {
            if (this.b == this.a) {
                this.d = null;
                this.e = false;
                if (a == 0) {
                    return;
                }
            }
            this.c = this.b;
            this.d = (q)v.e(this.f).b(this.c.c());
            this.e = true;
            this.b = this.c.d().h();
            this.c = this.a(this.c);
            if (a == 0) {
                return;
            }
        }
        final q c = this.c.c();
        if (c.b() > 0 && !this.f.j((q)v.e(this.f).b(c))) {
            this.c = this.a(c);
        }
        this.d = (q)v.e(this.f).b(this.c.c());
        this.e = true;
        this.b = this.c.d().h();
        this.c = this.a(this.c);
    }
}
