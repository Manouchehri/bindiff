package y.h;

import java.util.*;
import y.c.*;

final class al implements am
{
    private final Iterator a;
    private final ag b;
    
    al(final ag b) {
        this.b = b;
        this.a = b.a.h(ag.a(b));
    }
    
    public boolean a() {
        final boolean z = fj.z;
        boolean b = false;
        boolean a = false;
        while (this.a.hasNext() && this.b.f.isEmpty()) {
            final q q = this.a.next();
            this.b.b.set(q.d());
            this.b.a(q);
            if (this.b.a.k(q)) {
                final ah ah = new ah(this.b, q);
                final int size = this.b.c.size();
                this.b.c.add(ah);
                b = true;
                a = ah.a();
                if (z) {
                    return !a && !b;
                }
                if (!a) {
                    continue;
                }
                this.b.c.remove(size);
                b = false;
                if (z) {
                    break;
                }
                continue;
            }
        }
        this.a.hasNext();
        return !a && !b;
    }
}
