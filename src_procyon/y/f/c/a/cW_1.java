package y.f.c.a;

import java.util.*;
import y.c.*;
import y.g.*;

final class cW implements Comparator
{
    final int[] a;
    
    cW(final int[] a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final int n = this.a[((d)o).b()];
        final int n2 = this.a[((d)o2).b()];
        if (n <= 0 || n2 <= 0) {
            return 0;
        }
        return e.a(n, n2);
    }
}
