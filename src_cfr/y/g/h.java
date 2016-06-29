/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.c.A;
import y.c.i;
import y.c.q;
import y.g.C;
import y.g.F;
import y.g.p;

public class H
extends F {
    private A[] a;
    private A[] b;

    public H(C c2) {
        super(c2);
    }

    @Override
    protected void b(i i2, i i3) {
        boolean bl2 = p.c;
        super.b(i2, i3);
        this.a = i2.v();
        this.b = new A[this.a.length];
        int n2 = 0;
        do {
            if (n2 >= this.a.length) return;
            this.b[n2] = i3.t();
            ++n2;
        } while (!bl2);
    }

    @Override
    protected void a(q q2, q q3) {
        boolean bl2 = p.c;
        super.a(q2, q3);
        int n2 = 0;
        do {
            if (n2 >= this.a.length) return;
            A a2 = this.a[n2];
            A a3 = this.b[n2];
            Object object = this.a(q2, q3, a2.b(q2));
            a3.a((Object)q3, object);
            ++n2;
        } while (!bl2);
    }

    protected Object a(q q2, q q3, Object object) {
        return object;
    }
}

