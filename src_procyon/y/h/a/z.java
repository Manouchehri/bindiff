package y.h.a;

import y.c.*;

class z
{
    i a;
    q b;
    private final v c;
    
    z(final v c, final i a, final q b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    i a() {
        return (this.b != null) ? this.b.e() : null;
    }
    
    z b() {
        final i a = this.a();
        return (a != null) ? v.a(this.c, a) : null;
    }
    
    i c() {
        return this.a;
    }
    
    q d() {
        return this.b;
    }
    
    y a(final q q) {
        final int a = v.a;
        y y;
        if (q.e() == this.a) {
            y = new y();
            y.a(q);
        }
        else {
            i i = q.e();
            y = new y();
            y.a(q);
            i j = null;
            Label_0110: {
                while (i != this.a) {
                    j = i;
                    if (a != 0 || j == this.c.g()) {
                        break Label_0110;
                    }
                    y.a(this.c.e(i));
                    i = this.c.f(i);
                    if (a != 0) {
                        goto Label_0109;
                    }
                }
                goto Label_0109;
            }
            if (j == null) {
                y = null;
            }
        }
        return y;
    }
    
    void b(final q q) {
        final int a = v.a;
        if (this.c.j(q)) {
            this.c.m(q).j();
            this.c.g(q);
            if (a == 0) {
                return;
            }
        }
        q q2 = this.d();
        z z = this.b();
    Label_0158_Outer:
        while (z != null) {
            final i e = q2.e();
            final e j = q2.j();
            while (true) {
                while (j.f()) {
                    final d d = (d)j.d();
                    final E a2 = v.a(this.c, d);
                    if (a == 0) {
                        if (a2 != null && (a2.a() == q || a2.b() == q)) {
                            e.a(d);
                        }
                        j.g();
                        if (a != 0) {
                            break;
                        }
                        continue Label_0158_Outer;
                    }
                    else {
                        if (a != 0) {
                            break Label_0158_Outer;
                        }
                        continue Label_0158_Outer;
                    }
                }
                q2 = z.d();
                z = z.b();
                continue;
            }
        }
    }
}
