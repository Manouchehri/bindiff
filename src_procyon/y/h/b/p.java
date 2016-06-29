package y.h.b;

import java.util.*;

final class p
{
    final Map a;
    final Map b;
    
    p() {
        this.a = new HashMap();
        this.b = new HashMap();
    }
    
    int a(final c c) {
        return this.a(((q)c).a);
    }
    
    int a(final Object o) {
        Integer n = this.a.get(o);
        if (n == null) {
            n = new Integer(this.a.size());
            this.a.put(o, n);
        }
        return n;
    }
    
    int a(final f f) {
        return this.b(((q)f).a);
    }
    
    int b(final Object o) {
        Integer n = this.b.get(o);
        if (n == null) {
            n = new Integer(this.b.size());
            this.b.put(o, n);
        }
        return n;
    }
}
