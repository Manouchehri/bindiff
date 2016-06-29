package y.f.f.e;

import y.g.*;
import y.f.h.*;
import y.c.*;

class c extends p
{
    r a;
    A b;
    
    c(final r a, final A b) {
        this.a = a;
        this.b = b;
    }
    
    public Object b(final Object o) {
        if (o instanceof y.f.h.p) {
            return this.a.b(o);
        }
        if (o instanceof q) {
            return this.b.b(o);
        }
        throw new IllegalStateException("Illegal Type " + o);
    }
}
