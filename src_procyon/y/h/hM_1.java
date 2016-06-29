package y.h;

import java.util.*;

final class hM implements Iterator
{
    private final Iterator a;
    
    hM(final ArrayList list) {
        this.a = list.iterator();
    }
    
    public boolean hasNext() {
        return this.a.hasNext();
    }
    
    public Object next() {
        return this.a.next();
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
