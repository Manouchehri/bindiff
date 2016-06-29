package y.f.h.a;

import java.util.*;

class d implements Iterator
{
    int a;
    private final c b;
    
    d(final c b) {
        this.b = b;
        this.a = 0;
    }
    
    public boolean hasNext() {
        return this.a < this.b.a.length;
    }
    
    public Object next() {
        ++this.a;
        return this.b.a[this.a - 1];
    }
    
    public void remove() {
    }
}
