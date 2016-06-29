package y.h;

import java.util.*;
import y.c.*;

final class ab implements am
{
    private final Iterator a;
    private final Y b;
    
    ab(final Y b) {
        this.b = b;
        this.a = b.a.i(Y.a(b));
    }
    
    public boolean a() {
        final boolean z = fj.z;
        boolean b = false;
        boolean a = false;
        while (this.a.hasNext() && this.b.f.isEmpty()) {
            final q q = this.a.next();
            final aa aa = new aa(this.b, q);
            final int size = this.b.c.size();
            this.b.c.add(aa);
            if (this.b.a.k(q)) {
                final ac ac = new ac(this.b, q);
                final int size2 = this.b.c.size();
                this.b.c.add(ac);
                b = true;
                if (ac.a()) {
                    this.b.c.remove(size2);
                    b = false;
                }
            }
            if (!b) {
                a = aa.a();
                if (z) {
                    return !a && !b;
                }
                if (!a) {
                    continue;
                }
                this.b.c.remove(size);
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
