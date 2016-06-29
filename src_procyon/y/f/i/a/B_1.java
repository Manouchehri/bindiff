package y.f.i.a;

import y.c.*;
import y.d.*;

class B implements g
{
    private final h a;
    private final h b;
    private final h c;
    private final f d;
    private final y e;
    
    B(final y e, final h a, final h b, final h c, final f d) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public void a(final Object o, final Object o2) {
        final E e = (E)o;
        final E e2 = (E)o2;
        if (m.a(E.a(e), E.a(e2)) != null) {
            if (E.b(e) == E.b(e2)) {
                this.a.a(E.b(e), this.a.a(E.b(e)) + 1);
                if (!this.b.d(E.b(e)) || y.a(this.e, E.b(e)) || this.c.d(E.b(e))) {
                    return;
                }
                this.d.add(E.b(e));
                this.c.a(E.b(e), true);
                if (ab.a == 0) {
                    return;
                }
            }
            this.a.a(E.b(e), this.a.a(E.b(e)) + 1);
            this.a.a(E.b(e2), this.a.a(E.b(e2)) + 1);
        }
    }
}
