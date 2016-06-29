/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Iterator;
import java.util.NoSuchElementException;
import y.h.fj;

final class hN
implements Iterator {
    private final Iterator[] a;
    private int b;

    hN(Iterator iterator, Iterator iterator2, boolean bl2) {
        block2 : {
            if (bl2) {
                this.a = new Iterator[]{iterator, iterator2};
                if (!fj.z) break block2;
            }
            this.a = new Iterator[]{iterator2, iterator};
        }
        this.b = 0;
    }

    @Override
    public boolean hasNext() {
        boolean bl2 = fj.z;
        do {
            if (this.b >= this.a.length) return false;
            boolean bl3 = this.a[this.b].hasNext();
            if (bl2) return bl3;
            if (bl3) {
                return true;
            }
            ++this.b;
        } while (!bl2);
        return false;
    }

    public Object next() {
        if (!this.hasNext()) throw new NoSuchElementException();
        return this.a[this.b].next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

