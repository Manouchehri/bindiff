package y.f.e;

import y.g.*;
import y.c.*;
import y.f.*;

class B extends p
{
    private c a;
    private c b;
    private X d;
    private final q e;
    
    B(final q e, final X d) {
        this.e = e;
        this.d = d;
        this.a = d.c(q.o);
        this.b = d.c(q.n);
    }
    
    public boolean d(final Object o) {
        final y.c.q q = (y.c.q)o;
        return y.f.e.q.a(this.e, q, this.a, this.d) || y.f.e.q.a(this.e, q, this.a) || (this.b != null && !this.b.d(q));
    }
}
