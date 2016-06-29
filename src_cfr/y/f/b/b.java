/*
 * Decompiled with CFR 0_115.
 */
package y.f.b;

import java.util.HashSet;
import y.c.i;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.ah;
import y.f.b.a;
import y.f.b.c;
import y.f.b.f;
import y.f.b.j;
import y.g.I;

public class b
extends y.f.a {
    private I a;
    private y.c.c b;
    private y.c.c c;
    private y.c.c d;
    private j e = new j();

    public b() {
        this.e.a(true);
    }

    public b(ah ah2) {
        this();
        this.a(ah2);
    }

    public boolean b() {
        return this.e.b();
    }

    public void a(boolean bl2) {
        this.e.a(bl2);
    }

    public void b(X x2) {
        this.a(x2);
        this.b((i)x2);
    }

    public void d(X x2) {
        this.c((i)x2);
        this.c();
    }

    void a(i i2) {
        x x2;
        y.c.c c2;
        int n2 = c.a;
        y.c.c c3 = i2.c(f.d);
        if (c3 == null) return;
        boolean bl2 = this.b();
        HashSet<Object> hashSet = new HashSet<Object>();
        if (!bl2) {
            c2 = i2.c(f.c);
            x2 = i2.o();
            while (x2.f()) {
                hashSet.add(c2.b(x2.e()));
                x2.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break;
            }
        } else {
            this.a = new I(i2);
            c2 = i2.c(f.b);
        }
        x2 = i2.o();
        do {
            if (!x2.f()) return;
            q q2 = x2.e();
            if (c3.d(q2) && (bl2 || hashSet.contains(c2.b(q2)))) {
                this.a.a(q2);
            }
            x2.g();
        } while (n2 == 0);
    }

    void c() {
        if (this.a == null) return;
        this.a.f();
        this.e.c((X)this.a.i());
        this.a = null;
    }

    public void a(a a2) {
        this.e.a(a2);
    }

    void b(i i2) {
        this.b = i2.c(f.d);
        this.c = i2.c(f.b);
        this.d = i2.c(f.c);
        if (this.b != null) {
            i2.d_(f.d);
        }
        if (this.c != null) {
            i2.d_(f.b);
        }
        if (this.d == null) return;
        i2.d_(f.c);
    }

    void c(i i2) {
        if (this.b != null) {
            i2.a(f.d, this.b);
        }
        if (this.c != null) {
            i2.a(f.b, this.c);
        }
        if (this.d != null) {
            i2.a(f.c, this.d);
        }
        this.b = null;
        this.c = null;
        this.d = null;
    }

    @Override
    public void c(X x2) {
        if (this.a() == null) {
            return;
        }
        this.a(x2);
        this.b((i)x2);
        this.a().c(x2);
        this.c((i)x2);
        this.c();
    }
}

