package y.f.c.a;

import java.util.*;
import y.c.*;
import y.g.*;

final class cL implements Comparator
{
    final byte[] a;
    
    cL(final byte[] a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final byte b = this.a[((d)o).b()];
        final byte b2 = this.a[((d)o2).b()];
        if (b == -2) {
            if (b2 == -2) {
                return 0;
            }
            return -1;
        }
        else {
            if (b2 == -2) {
                return 1;
            }
            return e.a(b, b2);
        }
    }
}
