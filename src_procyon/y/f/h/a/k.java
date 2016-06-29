package y.f.h.a;

import java.util.*;
import y.c.*;

class k implements Iterator
{
    e a;
    private final q b;
    private final j c;
    
    k(final j c, final q b) {
        this.c = c;
        this.b = b;
        this.a = this.b.j();
    }
    
    public boolean hasNext() {
        return this.a.f();
    }
    
    public Object next() {
        final d a = this.a.a();
        this.a.g();
        return a;
    }
    
    public void remove() {
        throw new UnsupportedOperationException("You cannot remove an element from a tree ordering!");
    }
}
