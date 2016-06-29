package y.f.k;

import y.f.*;
import java.util.*;

class E
{
    private List a;
    private X b;
    private double c;
    private final B d;
    
    E(final B d, final X b) {
        this.d = d;
        this.a = new ArrayList();
        this.b = b;
    }
    
    F a(final int n) {
        if (this.a.size() != n) {
            throw new IllegalStateException("Cannot try to create layer with index " + n + ". First create layer " + this.a.size());
        }
        final F f = new F(n, this);
        f.a(B.a(this.d));
        f.b(B.b(this.d));
        this.a.add(f);
        return f;
    }
    
    F b(final int n) {
        if (this.a.size() > n) {
            return this.a.get(n);
        }
        return null;
    }
    
    private F c(final int n) {
        if (this.a.size() <= n) {
            return this.a(n);
        }
        return this.a.get(n);
    }
    
    X a() {
        return this.b;
    }
    
    void a(final double c) {
        this.c = c;
    }
    
    static F a(final E e, final int n) {
        return e.c(n);
    }
}
