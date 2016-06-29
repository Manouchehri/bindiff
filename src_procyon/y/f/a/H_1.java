package y.f.a;

import java.util.*;
import y.c.*;
import y.d.*;

class H implements Comparator
{
    private final A a;
    private final G b;
    
    H(final G b, final A a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final t t = (t)this.a.b(o);
        final t t2 = (t)this.a.b(o2);
        final double atan2 = Math.atan2(t.b, t.a);
        final double atan3 = Math.atan2(t2.b, t2.a);
        return (atan2 > atan3) ? 1 : ((atan2 < atan3) ? -1 : 0);
    }
}
