/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import y.c.D;
import y.c.p;

final class F
implements Iterator {
    private p a;
    private final D b;
    private int c;

    F(D d2, p p2) {
        this.a = p2;
        this.b = d2;
        this.c = d2.d;
    }

    private final void a() {
        if (this.c == this.b.d) return;
        throw new ConcurrentModificationException();
    }

    @Override
    public final boolean hasNext() {
        this.a();
        if (this.a == null) return false;
        return true;
    }

    @Override
    public final void remove() {
        boolean bl2 = D.e;
        this.a();
        if (this.a == null) {
            if (this.b.c == null) throw new IllegalStateException();
            this.b.h(this.b.c);
            if (bl2) {
                throw new IllegalStateException();
            }
            this.c = this.b.d;
            if (!bl2) return;
        }
        if (this.a.b == null) throw new IllegalStateException();
        this.b.h(this.a.b);
        this.c = this.b.d;
        if (!bl2) return;
        throw new IllegalStateException();
    }

    public final Object next() {
        this.a();
        if (this.a == null) throw new NoSuchElementException();
        Object object = this.a.c();
        this.a = this.a.a();
        return object;
    }
}

