package y.f.k;

import java.util.*;
import y.c.*;
import y.f.*;
import y.g.*;

final class u implements Comparator
{
    private final boolean a;
    private int b;
    
    u(final boolean a) {
        this.b = 1;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final X x = (X)d.a();
        if (this.a) {
            final int n = e.a(x.k(d.d()), x.k(d2.d()));
            if (y.f.k.d.g == 0) {
                return this.b * n;
            }
        }
        final int n = e.a(x.j(d.d()), x.j(d2.d()));
        return this.b * n;
    }
}
