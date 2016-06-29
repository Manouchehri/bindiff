/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.util.Map;
import y.c.d;
import y.c.q;
import y.d.g;
import y.d.m;
import y.d.o;
import y.d.y;
import y.f.Q;
import y.f.d.a;
import y.f.d.i;
import y.f.d.j;

class l
implements g {
    private final i a;

    l(i i2) {
        this.a = i2;
    }

    @Override
    public void a(Object object, Object object2) {
        int n2 = a.f;
        j j2 = (j)object;
        j j3 = (j)object2;
        j j4 = null;
        j j5 = null;
        if (j2.c() == 2) {
            j4 = j2;
            j5 = j3;
        } else if (j3.c() == 2) {
            j4 = j3;
            j5 = j2;
        }
        if (j4 == null) return;
        Q q2 = j4.d();
        if (j5.c() == 0) {
            if (j4.a() == null) return;
            if (j4.a() == j5.a()) return;
            this.a.a(q2, (q)j5.a(), j5.h());
            if (n2 == 0) return;
        }
        if (j5.c() == 2) {
            Q q3 = j5.d();
            q q4 = (q)this.a.o.get(q2);
            q q5 = (q)this.a.o.get(q3);
            d d2 = this.a.i.a(q4, q5);
            this.a.a(q2, q3, d2);
            if (n2 == 0) return;
        }
        this.a.a(q2, (d)j5.a(), (m)j5.b());
    }
}

