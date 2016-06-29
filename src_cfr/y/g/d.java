/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.c.b;
import y.c.c;
import y.c.i;
import y.g.C;
import y.g.F;
import y.g.p;

public abstract class D
extends F {
    protected final Object a;
    private b b;

    protected D(C c2, Object object) {
        super(c2);
        this.a = object;
    }

    @Override
    protected void b(i i2, i i3) {
        super.b(i2, i3);
        if (i3.c(this.a) != null) {
            this.b = (b)i3.c(this.a);
            if (!p.c) return;
        }
        this.b = this.a(i3);
        i3.a(this.a, this.b);
    }

    protected abstract b a(i var1);

    protected b b(i i2) {
        if (this.b != null) return this.b;
        this.b = this.a(i2);
        return this.b;
    }
}

