package y.f;

import y.g.*;
import y.c.*;

class m extends p
{
    private final c a;
    private final l b;
    
    m(final l b, final c a) {
        this.b = b;
        this.a = a;
    }
    
    public Object b(final Object o) {
        if (o instanceof q) {
            final Object b = l.a(this.b).b(o);
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
