package y.f.i.a;

import java.util.*;
import y.f.*;
import y.c.*;
import y.d.*;

class z implements Comparator
{
    private final X a;
    private final y b;
    
    z(final y b, final X a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final double a = t.a(this.a.l(d.c()), this.a.l(d.d()));
        final d d2 = (d)o2;
        final double a2 = t.a(this.a.l(d2.c()), this.a.l(d2.d()));
        if (a < a2) {
            return -1;
        }
        if (a2 < a) {
            return 1;
        }
        return 0;
    }
}
