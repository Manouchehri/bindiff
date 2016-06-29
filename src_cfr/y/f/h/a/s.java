/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.Iterator;
import y.c.i;
import y.c.q;

abstract class s {
    i b;

    s() {
    }

    s(i i2) {
        this.a(i2);
    }

    void a(i i2) {
        this.b = i2;
        this.a();
    }

    protected abstract void a();

    abstract Iterator a(q var1);

    abstract Iterator b();
}

