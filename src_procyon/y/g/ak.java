package y.g;

import java.util.*;

class ak implements Iterator
{
    private aj a;
    private final ai b;
    
    public ak(final ai b, final aj aj) {
        this.b = b;
        this.a = b.b(aj);
    }
    
    public boolean hasNext() {
        return this.a != null;
    }
    
    public Object next() {
        final Object e = this.a.e;
        this.a = this.b.b(this.a);
        return e;
    }
    
    public void remove() {
        this.b.a(this.b.c(this.a));
    }
}
