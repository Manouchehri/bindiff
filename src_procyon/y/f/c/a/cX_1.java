package y.f.c.a;

import java.util.*;
import y.c.*;
import y.g.*;

final class cX implements Comparator
{
    final byte[] a;
    
    cX(final byte[] a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final byte b = this.a[((d)o).b()];
        final byte b2 = this.a[((d)o2).b()];
        if (b == -2) {
            if (b2 == -2) {
                return 0;
            }
            return e.a(0, b2);
        }
        else {
            if (b2 == -2) {
                return e.a(b, 0);
            }
            return e.a(b, b2);
        }
    }
}
