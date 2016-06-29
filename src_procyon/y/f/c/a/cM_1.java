package y.f.c.a;

import java.util.*;
import y.c.*;
import y.g.*;

final class cM implements Comparator, g
{
    final byte[] a;
    
    cM(final byte[] a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final byte b = this.a[((d)o).b()];
        final byte b2 = this.a[((d)o2).b()];
        if (b == -2 || b2 == -2) {
            return 0;
        }
        return e.a(b, b2);
    }
}
