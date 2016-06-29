package y.f.i.a;

import java.util.*;

class bt implements Comparator
{
    private final double[] a;
    private final bs b;
    
    bt(final bs b, final double[] a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final int intValue = (int)o;
        final int intValue2 = (int)o2;
        final double n = this.a[intValue];
        final double n2 = this.a[intValue2];
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        return 0;
    }
}
