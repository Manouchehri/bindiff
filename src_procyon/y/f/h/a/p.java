package y.f.h.a;

import java.util.*;

class p
{
    h a;
    
    p() {
        (this.a = new h(null, null, null)).a(this.a);
        this.a.b(this.a);
    }
    
    public Iterator a() {
        return new q(this);
    }
    
    h a(final i i) {
        return this.a.c.a(i);
    }
    
    i b() {
        return this.a.b.a();
    }
    
    i c() {
        return this.a.c.a();
    }
    
    public String toString() {
        final boolean g = b.g;
        String s = "[";
        final Iterator a = this.a();
        String s2 = null;
        while (a.hasNext()) {
            s2 = s;
            if (g) {
                return s2;
            }
            if (s2 != "[") {
                s += ", ";
            }
            s = s + "(" + a.next().toString() + ")";
            if (g) {
                break;
            }
        }
        new StringBuffer().append(s).append("]").toString();
        return s2;
    }
}
