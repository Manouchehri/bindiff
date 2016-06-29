package y.f.c.a;

import java.util.*;
import y.c.*;
import y.g.*;

class u implements Comparator
{
    private final int[] a;
    private final r b;
    
    u(final r b, final int[] a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(this.a[((q)o2).d()], this.a[((q)o).d()]);
    }
}
