package y.f.c.a;

import java.util.*;

final class dz implements Iterator
{
    private final Object[] a;
    private int b;
    
    dz(final Object[] a) {
        this.a = a;
        this.b = 0;
    }
    
    public boolean hasNext() {
        return this.b < this.a.length;
    }
    
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.a[this.b++];
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
