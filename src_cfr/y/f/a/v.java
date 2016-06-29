/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import y.c.A;
import y.c.q;
import y.c.x;
import y.f.a.f;
import y.g.p;

class v
extends p {
    A a;

    v(A a2) {
        this.a = a2;
    }

    @Override
    public int a(Object object) {
        int n2 = f.u;
        int n3 = 0;
        x x2 = ((q)object).m();
        do {
            if (!x2.f()) return n3;
            if (this.a.b(x2.e()) != null) {
                ++n3;
            }
            x2.g();
        } while (n2 == 0);
        return n3;
    }

    @Override
    public boolean d(Object object) {
        if (this.a.b((q)object) != null) return false;
        return true;
    }
}

