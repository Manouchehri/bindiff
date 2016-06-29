/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import y.c.d;
import y.c.q;
import y.h.a.v;

abstract class G
implements Iterator {
    final d a;
    d b;
    d c;
    q d;
    boolean e;
    private final int f;
    private boolean g;
    private final v h;

    G(v v2, q q2) {
        this.h = v2;
        this.b = this.a = q2.f();
        this.f = v.f(v2);
        this.g = true;
        this.e = false;
    }

    @Override
    public boolean hasNext() {
        this.c();
        return this.b();
    }

    public Object next() {
        this.c();
        if (!this.b()) throw new NoSuchElementException();
        this.g = true;
        return this.d;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private boolean b() {
        if (!this.g) return this.e;
        this.a();
        this.g = false;
        return this.e;
    }

    private void c() {
        if (v.f(this.h) == this.f) return;
        throw new ConcurrentModificationException();
    }

    abstract d a(q var1);

    abstract d a(d var1);

    abstract void a();
}

