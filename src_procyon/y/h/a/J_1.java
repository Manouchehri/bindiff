package y.h.a;

import y.c.*;

final class J extends G
{
    private final v f;
    
    J(final v f, final q q) {
        super(f, q);
        this.f = f;
        this.c = this.a(q);
    }
    
    d a(final q q) {
        return q.g();
    }
    
    d a(final d d) {
        return d.h();
    }
    
    void a() {
        final int a = v.a;
        while (true) {
            while (this.c == null) {
                final d b = this.b;
                if (a != 0) {
                    final q c = b.c();
                    this.d = (q)v.e(this.f).b(c);
                    this.e = true;
                    if (c.b() > 0 && !this.f.j(this.d)) {
                        this.b = this.c;
                        this.c = this.a(c);
                        if (a == 0) {
                            return;
                        }
                    }
                    this.c = this.a(this.c);
                    return;
                }
                if (b == this.a) {
                    this.d = null;
                    this.e = false;
                    return;
                }
                this.c = this.b;
                this.b = this.c.d().f();
                this.c = this.a(this.c);
                if (a != 0) {
                    break;
                }
            }
            final d c2 = this.c;
            continue;
        }
    }
}
