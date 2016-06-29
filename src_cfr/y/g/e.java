/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.c.d;
import y.c.h;
import y.c.i;
import y.g.C;
import y.g.F;
import y.g.p;

public class E
extends F {
    private h[] a;
    private h[] b;

    public E(C c2) {
        super(c2);
    }

    @Override
    protected void b(i i2, i i3) {
        boolean bl2 = p.c;
        super.b(i2, i3);
        this.a = i2.w();
        this.b = new h[this.a.length];
        int n2 = 0;
        do {
            if (n2 >= this.a.length) return;
            this.b[n2] = i3.u();
            ++n2;
        } while (!bl2);
    }

    @Override
    protected void a(d d2, d d3) {
        boolean bl2 = p.c;
        super.a(d2, d3);
        int n2 = 0;
        do {
            if (n2 >= this.a.length) return;
            h h2 = this.a[n2];
            h h3 = this.b[n2];
            Object object = this.a(d2, d3, h2.b(d2));
            h3.a((Object)d3, object);
            ++n2;
        } while (!bl2);
    }

    protected Object a(d d2, d d3, Object object) {
        return object;
    }
}

