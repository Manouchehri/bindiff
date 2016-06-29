package y.c;

import java.util.*;

final class G implements ListIterator
{
    final D a;
    private int b;
    private int c;
    private p d;
    private p e;
    
    G(final D a, final int b, final p e) {
        this.a = a;
        this.b = b;
        this.e = e;
        this.c = a.d;
    }
    
    private final void a() {
        if (this.c != this.a.d) {
            throw new ConcurrentModificationException();
        }
    }
    
    public void set(final Object o) {
        this.a();
        if (this.d != null) {
            this.d.a(o);
            if (!D.e) {
                return;
            }
        }
        throw new IllegalStateException();
    }
    
    public void add(final Object o) {
        this.a();
        Label_0039: {
            if (this.e != null) {
                this.a.a(o, this.e);
                if (!D.e) {
                    break Label_0039;
                }
            }
            this.a.add(o);
        }
        this.c = this.a.d;
        ++this.b;
        this.d = null;
    }
    
    public void remove() {
        this.a();
        if (this.d != null) {
            if (this.d.a == this.e) {
                --this.b;
            }
            this.a.h(this.d);
            this.d = null;
            this.c = this.a.d;
            if (!D.e) {
                return;
            }
        }
        throw new IllegalStateException();
    }
    
    public int previousIndex() {
        this.a();
        return this.b - 1;
    }
    
    public Object previous() {
        this.a();
        if (this.e != null) {
            if (this.e.b != null) {
                this.e = this.e.b;
                this.d = this.e;
                --this.b;
                return this.e.c;
            }
            throw new NoSuchElementException();
        }
        else {
            this.e = this.a.c;
            if (this.e != null) {
                --this.b;
                return this.e.c;
            }
            throw new NoSuchElementException();
        }
    }
    
    public int nextIndex() {
        this.a();
        return this.b;
    }
    
    public Object next() {
        this.a();
        if (this.e != null) {
            final Object c = this.e.c();
            this.d = this.e;
            ++this.b;
            this.e = this.e.a();
            return c;
        }
        throw new NoSuchElementException();
    }
    
    public boolean hasPrevious() {
        this.a();
        return (this.e == null && this.a.c != null) || this.e.b != null;
    }
    
    public boolean hasNext() {
        this.a();
        return this.e != null;
    }
}
