/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.util.Comparator;
import y.c.q;
import y.g.e;
import y.h.b.I;
import y.h.b.i;
import y.h.bu;

class A
implements Comparator {
    private boolean a;
    private I b;
    private bu c;

    A(boolean bl2, I i2, bu bu2) {
        this.a = bl2;
        this.b = i2;
        this.c = bu2;
    }

    public int compare(Object object, Object object2) {
        int n2;
        q q2 = this.b.a((i)object);
        q q3 = this.b.a((i)object2);
        if (this.a) {
            n2 = e.a(this.c.j(q2), this.c.j(q3));
            return n2;
        }
        n2 = e.a(this.c.k(q2), this.c.k(q3));
        return n2;
    }
}

