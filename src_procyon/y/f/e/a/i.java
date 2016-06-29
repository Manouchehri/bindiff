package y.f.e.a;

import java.util.*;

abstract class i implements ax
{
    private a a;
    
    i() {
        this.a = new Z();
    }
    
    public k a(final m m, final l l, final a a) {
        final boolean b = af.b;
        final List a2 = this.a(m, l);
        if (a2 == null || a2.isEmpty()) {
            return a;
        }
        int i = 0;
        while (i < a2.size()) {
            final ax ax = a2.get(i);
            this.a.a();
            final a a3 = a;
            if (b) {
                return a3;
            }
            a.a(ax.a(m, l, this.a));
            ++i;
            if (b) {
                break;
            }
        }
        return a;
    }
    
    protected abstract List a(final m p0, final l p1);
}
