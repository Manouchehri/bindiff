package y.g;

import java.util.*;

public final class A implements Iterator
{
    private final Iterator a;
    private z b;
    private boolean c;
    private Object d;
    
    public A(final Iterator a, final z b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean hasNext() {
        if (!this.c) {
            this.a();
        }
        return this.c;
    }
    
    public Object next() {
        if (!this.c) {
            this.a();
        }
        if (this.c) {
            this.c = false;
            return this.d;
        }
        throw new NoSuchElementException();
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    private void a() {
        final boolean c = p.c;
        while (this.a.hasNext() && !this.c) {
            final Object next = this.a.next();
            if (this.b == null || this.b.a(next)) {
                this.d = next;
                this.c = true;
                if (c) {
                    break;
                }
                continue;
            }
        }
    }
}
