/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import y.c.d;
import y.c.f;
import y.c.i;
import y.f.f.a.a.e;
import y.f.f.a.a.h;
import y.f.f.a.b.E;
import y.f.f.a.b.F;
import y.f.f.a.b.a;
import y.f.f.a.b.n;

class H
implements h {
    n a;
    f b;
    private final E c;

    private H(E e2) {
        this.c = e2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void a(e var1_1) {
        var3_2 = a.c;
        this.a = (n)var1_1;
        if (this.a.d()) {
            return;
        }
        this.a.b(E.a(this.c));
        if (E.b(this.c) != 0) ** GOTO lbl-1000
        this.b = y.a.h.b(E.a(this.c));
        if (var3_2) lbl-1000: // 2 sources:
        {
            if (E.b(this.c) != 1) throw new RuntimeException("Bad connection mode!");
            this.b = y.a.h.e(E.a(this.c));
            if (var3_2) {
                throw new RuntimeException("Bad connection mode!");
            }
        }
        var2_3 = this.b.a();
        while (var2_3.f()) {
            E.c(this.c).add(var2_3.a());
            this.a.a(var2_3.a());
            var2_3.g();
            if (var3_2 != false) return;
            if (!var3_2) continue;
        }
        this.a.a(E.a(this.c));
    }

    H(E e2, F f2) {
        this(e2);
    }
}

