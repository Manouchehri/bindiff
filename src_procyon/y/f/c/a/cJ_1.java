package y.f.c.a;

import java.util.*;
import y.c.*;
import y.g.*;

final class cJ implements Comparator
{
    final int[] a;
    
    cJ(final int[] a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final int n = this.a[((d)o).b()];
        final int n2 = this.a[((d)o2).b()];
        if (n <= 0) {
            if (n2 <= 0) {
                return 0;
            }
            return 1;
        }
        else {
            if (n2 <= 0) {
                return -1;
            }
            return e.a(n, n2);
        }
    }
}
