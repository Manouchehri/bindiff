package y.g;

import y.c.*;
import java.util.*;

class R extends U implements A, b, h
{
    R(final Map map) {
        super(map);
    }
    
    public void a(final Object o, final Object o2) {
        this.a.put(o, o2);
    }
    
    public void a(final Object o, final int n) {
        this.a.put(o, new Integer(n));
    }
    
    public void a(final Object o, final double n) {
        this.a.put(o, new Double(n));
    }
    
    public void a(final Object o, final boolean b) {
        this.a.put(o, b ? Boolean.TRUE : Boolean.FALSE);
    }
}
