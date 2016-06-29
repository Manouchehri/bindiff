package y.f.c.a;

import y.c.*;
import y.f.*;
import y.g.*;

class be extends bd
{
    private final c a;
    private final bb b;
    
    be(final bb b, final c a) {
        super(b, 0);
        this.b = b;
        this.a = a;
    }
    
    private ax a(final q q) {
        final Object b = this.a.b(q);
        if (b instanceof aA) {
            return ((aA)b).a();
        }
        return (ax)b;
    }
    
    public int compare(final Object o, final Object o2) {
        final ax a = this.a((q)o);
        final ax a2 = this.a((q)o2);
        if (a == a2) {
            return 0;
        }
        final int a3 = this.b.a(1, 2, 1, 4, 8, 2, a);
        final int a4 = this.b.a(1, 2, 1, 4, 8, 2, a2);
        if (a3 != a4) {
            return e.a(a3, a4);
        }
        return this.a(a, a2, a3);
    }
}
