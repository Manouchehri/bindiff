/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.c.c;
import y.c.e;
import y.f.X;
import y.f.ae;
import y.f.ah;
import y.f.g.d;

public class i
implements ah {
    Object a = ah.h_;

    public Object a() {
        return this.a;
    }

    public void a(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("null");
        }
        this.a = object;
    }

    @Override
    public void c(X x2) {
        boolean bl2 = d.d;
        c c2 = x2.c(this.a());
        e e2 = x2.p();
        do {
            if (!e2.f()) return;
            y.c.d d2 = e2.a();
            if (c2 == null || c2.d(d2)) {
                ae.a(x2, d2);
            }
            e2.g();
        } while (!bl2);
    }
}

