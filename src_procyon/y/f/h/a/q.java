package y.f.h.a;

import java.util.*;

class q implements Iterator
{
    h a;
    private final p b;
    
    q(final p b) {
        this.b = b;
        this.a = this.b.a;
    }
    
    public boolean hasNext() {
        return this.a.b != this.b.a;
    }
    
    public Object next() {
        this.a = this.a.b;
        return this.a.a();
    }
    
    public void remove() {
        final h c = this.a.c;
        this.a.b();
        this.a = c;
    }
}
