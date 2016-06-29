package y.h.a;

import y.c.*;
import java.util.*;

final class E
{
    q a;
    q b;
    Map c;
    
    E(final q a, final q b) {
        if (a == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (b == null) {
            throw new IllegalArgumentException("target == null");
        }
        this.a = a;
        this.b = b;
    }
    
    q a() {
        return this.a;
    }
    
    q b() {
        return this.b;
    }
    
    Object a(final String s, final Object o) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        return this.c.put(s, o);
    }
    
    Object a(final String s) {
        return (this.c == null) ? null : this.c.get(s);
    }
    
    Object b(final String s) {
        return (this.c == null) ? null : this.c.remove(s);
    }
    
    public String toString() {
        return "source = " + this.a + "  target = " + this.b;
    }
}
