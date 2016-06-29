/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class hL
implements Iterator {
    private final ArrayList a;
    private int b;

    hL(ArrayList arrayList) {
        this.a = arrayList;
        this.b = arrayList.size() - 1;
    }

    @Override
    public boolean hasNext() {
        if (this.b <= -1) return false;
        return true;
    }

    public Object next() {
        try {
            return this.a.get(this.b--);
        }
        catch (IndexOutOfBoundsException var1_1) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

