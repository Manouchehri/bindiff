package y.f.h.a;

import java.util.*;
import y.c.*;

class l implements Iterator
{
    x a;
    private final j b;
    
    l(final j b) {
        this.b = b;
        this.a = this.b.b.o();
    }
    
    public boolean hasNext() {
        return this.a.f();
    }
    
    public Object next() {
        final q e = this.a.e();
        this.a.g();
        return e;
    }
    
    public void remove() {
        throw new UnsupportedOperationException("You cannot remove an element from a tree ordering!");
    }
}
