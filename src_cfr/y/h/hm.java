/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.ArrayList;
import java.util.Iterator;

final class hM
implements Iterator {
    private final Iterator a;

    hM(ArrayList arrayList) {
        this.a = arrayList.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.a.hasNext();
    }

    public Object next() {
        return this.a.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

