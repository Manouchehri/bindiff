package y.f.d;

import java.util.*;

class v implements Comparator
{
    private final u a;
    
    v(final u a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final z z = (z)o;
        final z z2 = (z)o2;
        if (z.d > z2.d) {
            return -1;
        }
        if (z.d < z2.d) {
            return 1;
        }
        return 0;
    }
}
