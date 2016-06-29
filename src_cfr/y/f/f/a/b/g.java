/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import y.c.i;
import y.f.f.a.a.e;
import y.f.f.a.a.h;
import y.f.f.a.b.E;
import y.f.f.a.b.F;
import y.f.f.a.b.n;

class G
implements h {
    n a;
    boolean b;
    private final E c;

    private G(E e2) {
        this.c = e2;
        this.b = true;
    }

    @Override
    public void a(e e2) {
        this.a = (n)e2;
        if (this.a.d()) {
            return;
        }
        this.a.b(E.a(this.c));
        if (!y.a.h.c(E.a(this.c))) {
            this.b = false;
        }
        this.a.a(E.a(this.c));
    }

    G(E e2, F f2) {
        this(e2);
    }
}

