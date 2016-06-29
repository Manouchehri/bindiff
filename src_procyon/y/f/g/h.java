package y.f.g;

import y.g.*;
import y.c.*;

class h extends p
{
    private final c a;
    private final c b;
    private final d d;
    
    h(final d d, final c a, final c b) {
        this.d = d;
        this.a = a;
        this.b = b;
    }
    
    public boolean d(final Object o) {
        final y.c.d d = (y.c.d)o;
        return (this.a == null || (!this.a.d(d.c()) && !this.a.d(d.d()))) && (this.b == null || !this.b.d(d));
    }
}
