package y.f.h.a;

import java.util.*;

class g implements Iterator
{
    o a;
    o b;
    private final f c;
    
    g(final f c) {
        this.c = c;
        this.a = null;
        this.b = f.e(this.c);
    }
    
    public boolean hasNext() {
        return this.b.a(this.a) != f.f(this.c);
    }
    
    public Object next() {
        final o b = this.b;
        this.b = this.b.a(this.a);
        this.a = b;
        return this.b.a();
    }
    
    public void remove() {
        final o a = this.a;
        this.a = this.a.a(this.b);
        this.b = a;
        this.b.a(this.a).b();
    }
}
