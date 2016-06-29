package y.f.i.a;

import y.g.*;

class bJ extends p
{
    private final bF a;
    
    bJ(final bF a) {
        this.a = a;
    }
    
    public Object b(final Object o) {
        if (bF.a(this.a).d(o)) {
            return (bF.e(this.a) != null) ? bF.e(this.a).b(o) : null;
        }
        return (bF.d(this.a) != null) ? bF.d(this.a).b(o) : null;
    }
}
