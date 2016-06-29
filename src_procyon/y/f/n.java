package y.f;

import y.g.*;
import y.c.*;

class n extends p
{
    private final c a;
    private final l b;
    
    n(final l b, final c a) {
        this.b = b;
        this.a = a;
    }
    
    public Object b(final Object o) {
        if (o instanceof d) {
            final Object b = l.b(this.b).b(o);
            if (b != null) {
                if (this.a != null) {
                    return this.a.b(b);
                }
                return b;
            }
        }
        return null;
    }
}
