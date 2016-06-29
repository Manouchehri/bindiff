package y.f.c;

import y.c.*;
import java.util.*;

final class al implements h
{
    private final Set a;
    
    al(final Set a) {
        this.a = a;
    }
    
    public Object b(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    public void a(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    public void a(final Object o, final boolean b) {
        if (b) {
            this.a.add(o);
            if (!y.f.c.a.i) {
                return;
            }
        }
        this.a.remove(o);
    }
    
    public boolean d(final Object o) {
        return this.a.contains(o);
    }
    
    public void a(final Object o, final double n) {
        throw new UnsupportedOperationException();
    }
    
    public double c(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    public void a(final Object o, final int n) {
        throw new UnsupportedOperationException();
    }
    
    public int a(final Object o) {
        throw new UnsupportedOperationException();
    }
}
