/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.c.C;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.a;
import y.f.ah;

public class aQ
extends a {
    Object a = ah.g_;
    f b = new f();
    y c = new y();

    public Object b() {
        return this.a;
    }

    @Override
    public void c(X x2) {
        if (this.a() == null) return;
        this.a(x2);
        this.a(x2);
        this.b(x2);
    }

    private void a(i i2) {
        boolean bl2 = X.j;
        c c2 = i2.c(this.b());
        if (c2 == null) return;
        C c3 = i2.p();
        while (c3.f()) {
            d d2 = c3.a();
            if (bl2) return;
            if (!c2.d(d2.c()) || !c2.d(d2.d())) {
                this.b.c(d2);
                i2.d(d2);
            }
            c3.g();
            if (!bl2) continue;
        }
        c3 = i2.o();
        do {
            if (!c3.f()) return;
            if (!c2.d(c3.e())) {
                this.c.c(c3.e());
                i2.c(c3.e());
            }
            c3.g();
        } while (!bl2);
    }

    private void b(i i2) {
        boolean bl2 = X.j;
        while (!this.c.isEmpty()) {
            i2.d(this.c.d());
            if (bl2) return;
            if (!bl2) continue;
        }
        do {
            if (this.b.isEmpty()) return;
            i2.e(this.b.d());
        } while (!bl2);
    }
}

