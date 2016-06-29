package y.h;

import java.util.*;

final class hN implements Iterator
{
    private final Iterator[] a;
    private int b;
    
    hN(final Iterator iterator, final Iterator iterator2, final boolean b) {
        Label_0046: {
            if (b) {
                this.a = new Iterator[] { iterator, iterator2 };
                if (!fj.z) {
                    break Label_0046;
                }
            }
            this.a = new Iterator[] { iterator2, iterator };
        }
        this.b = 0;
    }
    
    public boolean hasNext() {
        final boolean z = fj.z;
        boolean hasNext = false;
        while (this.b < this.a.length) {
            hasNext = this.a[this.b].hasNext();
            if (z) {
                return hasNext;
            }
            if (hasNext) {
                return true;
            }
            ++this.b;
            if (z) {
                break;
            }
        }
        return hasNext;
    }
    
    public Object next() {
        if (this.hasNext()) {
            return this.a[this.b].next();
        }
        throw new NoSuchElementException();
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
