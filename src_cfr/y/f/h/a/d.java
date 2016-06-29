/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.Iterator;
import y.c.q;
import y.f.h.a.c;

class d
implements Iterator {
    int a;
    private final c b;

    d(c c2) {
        this.b = c2;
        this.a = 0;
    }

    @Override
    public boolean hasNext() {
        if (this.a >= this.b.a.length) return false;
        return true;
    }

    public Object next() {
        ++this.a;
        return this.b.a[this.a - 1];
    }

    @Override
    public void remove() {
    }
}

