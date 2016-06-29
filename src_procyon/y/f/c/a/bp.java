package y.f.c.a;

import java.util.*;

final class bp
{
    private final ArrayList a;
    private final Collection b;
    
    bp() {
        this.a = new ArrayList();
        this.b = Collections.unmodifiableCollection((Collection<?>)this.a);
    }
    
    bK a(final l l) {
        final bK bk = new bK(new Integer(this.a.size()));
        this.a.add(bk);
        bk.a(true);
        bk.b(l.b());
        bk.c(l.c());
        bk.d(l.d());
        bk.a(l.i());
        return bk;
    }
}
