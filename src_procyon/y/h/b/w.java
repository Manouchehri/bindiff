package y.h.b;

import java.util.*;
import y.g.*;

class w implements Comparator
{
    private final boolean a;
    private final v b;
    
    w(final v b, final boolean a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final i i = (i)o;
        final i j = (i)o2;
        if (this.a) {
            final int n = v.a(this.b).get(i).e.size();
            final int n2 = v.a(this.b).get(j).e.size();
            if (y.h.b.a.H == 0) {
                return e.a(n2, n);
            }
        }
        final int n = v.b(this.b).get(i).e.size();
        final int n2 = v.b(this.b).get(j).e.size();
        return e.a(n2, n);
    }
}
