package y.f.h;

import java.util.*;

class U implements r
{
    private HashMap a;
    
    U() {
        this.a = new HashMap();
    }
    
    public void a(final p p2, final Object o) {
        this.a.put(p2, o);
    }
    
    public Object b(final Object o) {
        return this.a.get(o);
    }
    
    public void a(final p p2, final boolean b) {
        this.a.put(p2, b ? Boolean.TRUE : Boolean.FALSE);
    }
    
    public boolean d(final Object o) {
        final Boolean value = this.a.get(o);
        return value != null && value;
    }
    
    public double c(final Object o) {
        final Double value = this.a.get(o);
        if (value == null) {
            return 0.0;
        }
        return value;
    }
    
    public void a(final p p2, final int n) {
        this.a.put(p2, new Integer(n));
    }
    
    public int a(final Object o) {
        final Integer value = this.a.get(o);
        if (value == null) {
            return 0;
        }
        return value;
    }
    
    public void a() {
        this.a.clear();
    }
}
