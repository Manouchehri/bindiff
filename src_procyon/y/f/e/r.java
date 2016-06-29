package y.f.e;

import y.g.*;
import y.c.*;

class r extends p
{
    private final c a;
    private final q b;
    
    r(final q b, final c a) {
        this.b = b;
        this.a = a;
    }
    
    public Object b(final Object o) {
        if (!this.a.d(o)) {
            return "nonfixed";
        }
        return null;
    }
}
