/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.c.b;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.q;
import y.g.C;
import y.g.D;
import y.g.M;

public class G
extends D {
    public G(C c2, Object object) {
        super(c2, object);
    }

    @Override
    protected b a(i i2) {
        return M.c();
    }

    @Override
    protected void a(q q2, q q3) {
        super.a(q2, q3);
        c c2 = q2.e().c(this.a);
        if (c2 == null) return;
        Object object = this.a(this.a, q2, q3, c2.b(q2));
        if (object == null) return;
        this.b(q3.e()).a((Object)q3, object);
    }

    @Override
    protected void a(d d2, d d3) {
        super.a(d2, d3);
        c c2 = d2.a().c(this.a);
        if (c2 == null) return;
        Object object = this.a(this.a, d2, d3, c2.b(d2));
        if (object == null) return;
        this.b(d3.a()).a((Object)d3, object);
    }

    protected Object a(Object object, q q2, q q3, Object object2) {
        return object2;
    }

    protected Object a(Object object, d d2, d d3, Object object2) {
        return object2;
    }
}

