/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.List;
import y.c.q;
import y.f.c.a.E;
import y.f.c.a.J;
import y.f.c.a.N;

class G
implements J {
    private final List a;
    private final E b;

    G(E e2, List list) {
        this.b = e2;
        this.a = list;
    }

    @Override
    public void a(q q2, q q3) {
        if (q3 == null) {
            this.a.add(q2);
            if (!N.x) return;
        }
        this.a(q3, this.b.i(q3));
    }
}

