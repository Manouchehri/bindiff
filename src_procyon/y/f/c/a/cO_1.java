package y.f.c.a;

import java.util.*;
import y.c.*;
import y.g.*;

final class cO implements Comparator
{
    final int[] a;
    
    cO(final int[] a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        int n = this.a[((q)o).d()];
        int n2 = this.a[((q)o2).d()];
        if (n < 0) {
            n = -(n + 1);
        }
        if (n2 < 0) {
            n2 = -(n2 + 1);
        }
        return e.a(n, n2);
    }
}
