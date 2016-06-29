package y.g;

import y.c.*;
import java.util.*;

class U implements c
{
    Map a;
    
    U(final Map a) {
        this.a = a;
    }
    
    public Object b(final Object o) {
        return this.a.get(o);
    }
    
    public int a(final Object o) {
        final Number value = this.a.get(o);
        return (value instanceof Number) ? value.intValue() : 0;
    }
    
    public double c(final Object o) {
        final Number value = this.a.get(o);
        return (value instanceof Number) ? value.doubleValue() : 0.0;
    }
    
    public boolean d(final Object o) {
        return Boolean.TRUE.equals(this.a.get(o));
    }
}
