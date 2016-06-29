package y.h.a;

import y.c.*;
import java.util.*;

abstract class G implements Iterator
{
    final d a;
    d b;
    d c;
    q d;
    boolean e;
    private final int f;
    private boolean g;
    private final v h;
    
    G(final v h, final q q) {
        this.h = h;
        this.a = q.f();
        this.b = this.a;
        this.f = v.f(h);
        this.g = true;
        this.e = false;
    }
    
    public boolean hasNext() {
        this.c();
        return this.b();
    }
    
    public Object next() {
        this.c();
        if (this.b()) {
            this.g = true;
            return this.d;
        }
        throw new NoSuchElementException();
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    private boolean b() {
        if (this.g) {
            this.a();
            this.g = false;
        }
        return this.e;
    }
    
    private void c() {
        if (v.f(this.h) != this.f) {
            throw new ConcurrentModificationException();
        }
    }
    
    abstract d a(final q p0);
    
    abstract d a(final d p0);
    
    abstract void a();
}
