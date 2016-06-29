package y.f.i;

import y.g.*;
import y.c.*;

class j extends p
{
    private final c a;
    private final k b;
    
    j(final k b, final c a) {
        this.b = b;
        this.a = a;
    }
    
    public Object b(final Object o) {
        if (this.a.b(o) == null) {
            return this.b.a.b(o);
        }
        return o;
    }
}
