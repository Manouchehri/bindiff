package y.h;

import y.d.*;

class dV extends gC
{
    private final ev a;
    
    dV(final ev a, final double n, final az az, final boolean b, final double n2, final Object o) {
        super(n, az, b, n2, o);
        this.a = a;
    }
    
    public az a(final e e, final t t) {
        return new ec(this, t.a - e.k().a, t.b - e.k().b);
    }
    
    static ev a(final dV dv) {
        return dv.a;
    }
}
