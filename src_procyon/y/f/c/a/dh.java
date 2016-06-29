package y.f.c.a;

import java.util.*;
import y.c.*;

class dh implements Comparator
{
    private final float[] a;
    private final dg b;
    
    dh(final dg b, final float[] a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final float n = (o instanceof dg) ? dg.a((dg)o) : this.a[((q)o).d()];
        final float n2 = (o2 instanceof dg) ? dg.a((dg)o2) : this.a[((q)o2).d()];
        return (n < n2) ? -1 : (n > n2);
    }
}
