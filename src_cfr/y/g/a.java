/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.Iterator;
import java.util.NoSuchElementException;
import y.g.p;
import y.g.z;

public final class A
implements Iterator {
    private final Iterator a;
    private z b;
    private boolean c;
    private Object d;

    public A(Iterator iterator, z z2) {
        this.a = iterator;
        this.b = z2;
    }

    @Override
    public boolean hasNext() {
        if (this.c) return this.c;
        this.a();
        return this.c;
    }

    public Object next() {
        if (!this.c) {
            this.a();
        }
        if (!this.c) throw new NoSuchElementException();
        this.c = false;
        return this.d;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /*
     * Unable to fully structure code
     */
    private void a() {
        var2_1 = p.c;
        do lbl-1000: // 3 sources:
        {
            if (this.a.hasNext() == false) return;
            if (this.c != false) return;
            var1_2 = this.a.next();
            if (this.b != null && !this.b.a(var1_2)) ** GOTO lbl-1000
            this.d = var1_2;
            this.c = true;
        } while (!var2_1);
    }
}

