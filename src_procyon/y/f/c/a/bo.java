package y.f.c.a;

import y.g.*;
import y.c.*;

class bo extends p
{
    private final c a;
    private final bh b;
    private final bn d;
    
    bo(final bn d, final c a, final bh b) {
        this.d = d;
        this.a = a;
        this.b = b;
    }
    
    public Object b(final Object o) {
        if (bn.a(this.d) != null && bn.a(this.d).b(o) != null) {
            return bn.a(this.d).b(o);
        }
        if (this.a == null || !this.a.d(o)) {
            return this.b;
        }
        return null;
    }
}
