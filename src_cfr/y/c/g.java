/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import y.c.D;
import y.c.p;

final class G
implements ListIterator {
    final D a;
    private int b;
    private int c;
    private p d;
    private p e;

    G(D d2, int n2, p p2) {
        this.a = d2;
        this.b = n2;
        this.e = p2;
        this.c = d2.d;
    }

    private final void a() {
        if (this.c == this.a.d) return;
        throw new ConcurrentModificationException();
    }

    public void set(Object object) {
        this.a();
        if (this.d == null) throw new IllegalStateException();
        this.d.a(object);
        if (!D.e) return;
        throw new IllegalStateException();
    }

    public void add(Object object) {
        block2 : {
            this.a();
            if (this.e != null) {
                this.a.a(object, this.e);
                if (!D.e) break block2;
            }
            this.a.add(object);
        }
        this.c = this.a.d;
        ++this.b;
        this.d = null;
    }

    @Override
    public void remove() {
        this.a();
        if (this.d == null) throw new IllegalStateException();
        if (this.d.a == this.e) {
            --this.b;
        }
        this.a.h(this.d);
        this.d = null;
        this.c = this.a.d;
        if (!D.e) return;
        throw new IllegalStateException();
    }

    @Override
    public int previousIndex() {
        this.a();
        return this.b - 1;
    }

    public Object previous() {
        this.a();
        if (this.e != null) {
            if (this.e.b == null) throw new NoSuchElementException();
            this.d = this.e = this.e.b;
            --this.b;
            return this.e.c;
        }
        this.e = this.a.c;
        if (this.e == null) throw new NoSuchElementException();
        --this.b;
        return this.e.c;
    }

    @Override
    public int nextIndex() {
        this.a();
        return this.b;
    }

    @Override
    public Object next() {
        this.a();
        if (this.e == null) throw new NoSuchElementException();
        Object object = this.e.c();
        this.d = this.e;
        ++this.b;
        this.e = this.e.a();
        return object;
    }

    @Override
    public boolean hasPrevious() {
        this.a();
        if (this.e == null) {
            if (this.a.c != null) return true;
        }
        if (this.e.b != null) return true;
        return false;
    }

    @Override
    public boolean hasNext() {
        this.a();
        if (this.e == null) return false;
        return true;
    }
}

