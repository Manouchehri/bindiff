/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.Iterator;
import y.g.ai;
import y.g.aj;

class ak
implements Iterator {
    private aj a;
    private final ai b;

    public ak(ai ai2, aj aj2) {
        this.b = ai2;
        this.a = ai2.b(aj2);
    }

    @Override
    public boolean hasNext() {
        if (this.a == null) return false;
        return true;
    }

    public Object next() {
        Object object = this.a.e;
        this.a = this.b.b(this.a);
        return object;
    }

    @Override
    public void remove() {
        this.b.a(this.b.c(this.a));
    }
}

