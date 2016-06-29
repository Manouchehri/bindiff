/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.Comparator;
import y.d.m;
import y.d.t;
import y.f.i.K;
import y.f.i.Q;
import y.g.e;

class L
implements Comparator {
    private final K a;

    L(K k2) {
        this.a = k2;
    }

    public int compare(Object object, Object object2) {
        Q q2 = (Q)object;
        m m2 = q2.a();
        boolean bl2 = m2.c().b() >= m2.d().b();
        Q q3 = (Q)object2;
        m m3 = q3.a();
        boolean bl3 = m3.c().b() >= m3.d().b();
        int n2 = bl2 ? K.a(this.a)[Q.a(q2).b()] : K.b(this.a)[Q.a(q2).b()];
        int n3 = bl3 ? K.a(this.a)[Q.a(q3).b()] : K.b(this.a)[Q.a(q3).b()];
        return e.a(n2, n3);
    }
}

