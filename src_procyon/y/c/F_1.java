package y.c;

import java.util.*;

final class F implements Iterator
{
    private p a;
    private final D b;
    private int c;
    
    F(final D b, final p a) {
        this.a = a;
        this.b = b;
        this.c = b.d;
    }
    
    private final void a() {
        if (this.c != this.b.d) {
            throw new ConcurrentModificationException();
        }
    }
    
    public final boolean hasNext() {
        this.a();
        return this.a != null;
    }
    
    public final void remove() {
        final boolean e = D.e;
        this.a();
        Label_0067: {
            if (this.a == null) {
                if (this.b.c != null) {
                    this.b.h(this.b.c);
                    if (!e) {
                        this.c = this.b.d;
                        if (e) {
                            break Label_0067;
                        }
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }
        if (this.a.b != null) {
            this.b.h(this.a.b);
            this.c = this.b.d;
            if (!e) {
                return;
            }
        }
        throw new IllegalStateException();
    }
    
    public final Object next() {
        this.a();
        if (this.a != null) {
            final Object c = this.a.c();
            this.a = this.a.a();
            return c;
        }
        throw new NoSuchElementException();
    }
}
