package y.h;

import java.util.*;

final class hL implements Iterator
{
    private final ArrayList a;
    private int b;
    
    hL(final ArrayList a) {
        this.a = a;
        this.b = a.size() - 1;
    }
    
    public boolean hasNext() {
        return this.b > -1;
    }
    
    public Object next() {
        try {
            return this.a.get(this.b--);
        }
        catch (IndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
