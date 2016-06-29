/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.Map;
import y.c.d;
import y.c.i;
import y.c.q;
import y.g.C;

public abstract class F
implements C {
    private final C a;

    protected F(C c2) {
        if (c2 == null) {
            throw new NullPointerException("delegatingFactory");
        }
        this.a = c2;
    }

    @Override
    public void a(i i2, i i3) {
        this.b(i2, i3);
        this.a.a(i2, i3);
    }

    @Override
    public void a(i i2, i i3, Map map, Map map2) {
        this.a.a(i2, i3, map, map2);
        this.b(i2, i3, map, map2);
    }

    @Override
    public q a(i i2, q q2) {
        q q3 = this.a.a(i2, q2);
        if (q2 == null) return q3;
        this.a(q2, q3);
        return q3;
    }

    protected void b(i i2, i i3) {
    }

    protected void b(i i2, i i3, Map map, Map map2) {
    }

    protected void a(q q2, q q3) {
    }

    protected void a(d d2, d d3) {
    }

    @Override
    public d a(i i2, q q2, q q3, d d2) {
        d d3 = this.a.a(i2, q2, q3, d2);
        if (d2 == null) return d3;
        this.a(d2, d3);
        return d3;
    }
}

