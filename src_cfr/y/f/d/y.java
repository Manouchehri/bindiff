/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import y.d.g;
import y.d.m;
import y.f.d.a;
import y.f.d.u;
import y.f.d.z;

class y
implements g {
    private final u a;

    y(u u2) {
        this.a = u2;
    }

    @Override
    public void a(Object object, Object object2) {
        m m2;
        int n2 = a.f;
        z z2 = (z)object;
        z z3 = (z)object2;
        if (z2.c == 1 && z3.c == 1) {
            m2 = (m)z2.a;
            m m3 = (m)z3.a;
            if (m.a(m2, m3) == null) return;
            ++z2.d;
            ++z3.d;
            if (n2 == 0) return;
        }
        if (z2.c == 1 || z3.c == 1) {
            m2 = (m)(z2.c == 1 ? z2.a : z3.a);
            y.d.y y2 = z2.c != 1 ? z2.h() : z3.h();
            if (!m2.a(y2)) return;
            ++z2.d;
            ++z3.d;
            if (n2 == 0) return;
        }
        if (z2.b == z3.a) return;
        if (z3.b == z2.a) return;
        ++z2.d;
        ++z3.d;
    }
}

