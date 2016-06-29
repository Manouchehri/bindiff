package y.f.a;

import y.d.*;
import y.c.*;

class E implements g
{
    private boolean a;
    private boolean b;
    private final z c;
    
    public E(final z c, final boolean b) {
        this.c = c;
        this.b = b;
        this.a = false;
        if (b) {
            z.b(c).clear();
        }
    }
    
    public boolean a() {
        return this.a;
    }
    
    private boolean a(final D d) {
        return !z.b(this.c).containsKey(d);
    }
    
    public void a(final Object o, final Object o2) {
        final int u = f.u;
        final B b = (B)o;
        final B b2 = (B)o2;
        if (!y.a(b.h(), b2.h())) {
            return;
        }
        final D d = new D(this.c, b, b2);
        if (b.g() || b2.g()) {
            if (b.g() && b2.g()) {
                if (this.b) {
                    z.b(this.c).put(d, d);
                    if (u == 0) {
                        return;
                    }
                }
                if (!this.a(d)) {
                    return;
                }
                this.a = true;
                if (u == 0) {
                    return;
                }
            }
            if (b.e() || b2.e()) {
                if (!z.a(this.c, b.e() ? b : b2, b.g() ? b : b2)) {
                    return;
                }
                if (this.b) {
                    z.b(this.c).put(d, d);
                    if (u == 0) {
                        return;
                    }
                }
                if (!this.a(d)) {
                    return;
                }
                this.a = true;
                if (u == 0) {
                    return;
                }
            }
            final B b3 = b.g() ? b : b2;
            final B b4 = b.g() ? b2 : b;
            if ((!z.b(this.c, b, b2) && !this.b) || !((m)b4.j()).a(b3.j().h())) {
                return;
            }
            if (this.b) {
                z.b(this.c).put(d, d);
                if (u == 0) {
                    return;
                }
            }
            if (!this.a(d)) {
                return;
            }
            this.a = true;
            if (u == 0) {
                return;
            }
        }
        if (b.e() && b2.e()) {
            if ((!z.b(this.c, b, b2) && !this.b) || !z.c(this.c, b, b2)) {
                return;
            }
            if (this.b) {
                z.b(this.c).put(d, d);
                if (u == 0) {
                    return;
                }
            }
            if (!this.a(d)) {
                return;
            }
            this.a = true;
            if (u == 0) {
                return;
            }
        }
        if (b.f() && b2.f()) {
            if (b.i() == b2.i() || (!z.b(this.c, b, b2) && !this.b) || m.a((m)b.j(), (m)b2.j()) == null) {
                return;
            }
            if (this.b) {
                z.b(this.c).put(d, d);
                if (u == 0) {
                    return;
                }
            }
            if (!this.a(d)) {
                return;
            }
            this.a = true;
            if (u == 0) {
                return;
            }
        }
        if ((b.e() && b2.f()) || (b.f() && b2.e())) {
            final q q = (q)(b.e() ? b.i() : b2.i());
            final d d2 = (d)(b.f() ? b.i() : b2.i());
            if (d2.c() == q || d2.d() == q || (!z.b(this.c, b, b2) && !this.b) || !z.a(this.c, q, (m)(b.f() ? b.j() : b2.j()))) {
                return;
            }
            if (this.b) {
                z.b(this.c).put(d, d);
                if (u == 0) {
                    return;
                }
            }
            if (!this.a(d)) {
                return;
            }
            this.a = true;
            if (u == 0) {
                return;
            }
        }
        System.out.println("unhandled case detected");
    }
}
