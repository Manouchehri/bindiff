package y.f.i;

import java.util.*;
import y.f.*;
import y.c.*;

class t implements Comparator
{
    private X a;
    
    t(final X a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final q q = (q)o;
        final q q2 = (q)o2;
        final y.d.t l = this.a.l(q);
        final y.d.t i = this.a.l(q2);
        if (l.a() < i.a()) {
            return -1;
        }
        if (l.a() > i.a()) {
            return 1;
        }
        if (l.b() < i.b()) {
            return -1;
        }
        if (l.b() > i.b()) {
            return 1;
        }
        return 0;
    }
}
