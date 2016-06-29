package y.f.i;

import java.util.*;
import y.g.*;
import y.d.*;

class L implements Comparator
{
    private final K a;
    
    L(final K a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final Q q = (Q)o;
        final m a = q.a();
        final boolean b = a.c().b() >= a.d().b();
        final Q q2 = (Q)o2;
        final m a2 = q2.a();
        return e.a(b ? K.a(this.a)[Q.a(q).b()] : K.b(this.a)[Q.a(q).b()], (a2.c().b() >= a2.d().b()) ? K.a(this.a)[Q.a(q2).b()] : K.b(this.a)[Q.a(q2).b()]);
    }
}
