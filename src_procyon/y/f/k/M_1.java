package y.f.k;

import y.c.*;
import java.util.*;

final class M implements c
{
    private Set a;
    
    M(final Set a) {
        this.a = a;
    }
    
    public Object b(final Object o) {
        throw new UnsupportedOperationException("Objects not supported!");
    }
    
    public boolean d(final Object o) {
        return this.a.contains(o);
    }
    
    public double c(final Object o) {
        throw new UnsupportedOperationException("doubles not supported!");
    }
    
    public int a(final Object o) {
        throw new UnsupportedOperationException("ints not supported!");
    }
}
