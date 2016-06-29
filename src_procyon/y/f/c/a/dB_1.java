package y.f.c.a;

import java.util.*;

final class dB implements Iterator
{
    private final aU a;
    private int b;
    
    dB(final aU a) {
        this.a = a;
        this.b = 0;
    }
    
    public boolean hasNext() {
        return this.b < this.a.b();
    }
    
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.a.a(this.b++).d();
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
