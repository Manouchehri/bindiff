package y.g;

import y.c.*;
import java.util.*;

final class m implements Iterator
{
    private final C a;
    
    public m(final C a) {
        (this.a = a).j();
    }
    
    public boolean hasNext() {
        return this.a.f();
    }
    
    public Object next() {
        if (this.a.f()) {
            final Object d = this.a.d();
            this.a.h();
            return d;
        }
        throw new NoSuchElementException();
    }
    
    public void remove() {
        throw new UnsupportedOperationException("Removal not supported in Cursors!");
    }
}
