package y.f;

import y.g.*;
import y.c.*;
import y.d.*;

class ar extends p
{
    c a;
    private final an b;
    
    ar(final an b, final c a) {
        this.b = b;
        this.a = a;
    }
    
    public Object b(final Object o) {
        Object o2 = this.a.b(o);
        if (o2 instanceof q) {
            o2 = this.b.a((q)o2);
        }
        return o2;
    }
}
