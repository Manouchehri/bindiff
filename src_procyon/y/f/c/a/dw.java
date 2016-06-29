package y.f.c.a;

import java.util.*;
import y.c.*;
import y.g.*;

class dw implements Comparator
{
    private final int[] a;
    private final dt b;
    
    dw(final dt b, final int[] a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(this.a[((q)o).d()], this.a[((q)o2).d()]);
    }
}
