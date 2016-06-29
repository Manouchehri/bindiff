/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Set;
import y.c.q;
import y.f.c.a.J;
import y.f.c.a.N;

class T
implements J {
    private final q a;
    private final Set b;
    private final N c;

    T(N n2, q q2, Set set) {
        this.c = n2;
        this.a = q2;
        this.b = set;
    }

    @Override
    public void a(q q2, q q3) {
        if (q3 != null && q3 != this.a) {
            this.b.add(q3);
        }
        this.b.add(q2);
    }
}

