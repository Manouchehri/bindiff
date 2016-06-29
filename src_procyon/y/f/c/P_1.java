package y.f.c;

import y.g.*;
import y.c.*;

final class P extends p
{
    private final c a;
    private final Object b;
    
    public P(final c a, final Object b) {
        this.a = a;
        this.b = b;
    }
    
    public Object b(final Object o) {
        final Object b = this.a.b(o);
        return (b == null) ? this.b : b;
    }
}
