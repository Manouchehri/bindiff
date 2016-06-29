package y.f.c.a;

import y.g.*;
import y.f.*;
import java.util.*;

class c implements Comparator, g
{
    private final y.c.c a;
    private final Comparator b;
    private final byte c;
    private final int d;
    
    c(final y.c.c a, final Comparator b, final byte c, final int d) {
        this.a = a;
        this.b = b;
        this.d = d;
        this.c = c;
    }
    
    public int compare(final Object o, final Object o2) {
        final boolean x = N.x;
        if (this.b != null && this.b.compare(o, o2) != 0) {
            return this.b.compare(o, o2);
        }
        if (this.a == null) {
            return 0;
        }
        final Collection collection = (Collection)this.a.b(o);
        final Collection collection2 = (Collection)this.a.b(o2);
        if (collection == null && collection2 == null) {
            return 0;
        }
        if (collection == null) {
            return -1;
        }
        if (collection2 == null) {
            return 1;
        }
        double n = 0.0;
        final Iterator<ax> iterator = collection.iterator();
        while (true) {
            while (iterator.hasNext()) {
                n += iterator.next().a(this.c, this.d);
                if (x) {
                    double n2 = 0.0;
                    final Iterator<ax> iterator2 = collection2.iterator();
                    while (iterator2.hasNext()) {
                        n2 += iterator2.next().a(this.c, this.d);
                        if (x) {
                            return (int)(100.0 * (n - n2));
                        }
                        if (x) {
                            break;
                        }
                    }
                    n2 /= collection2.size();
                    return (int)(100.0 * (n - n2));
                }
                if (x) {
                    break;
                }
            }
            n /= collection.size();
            continue;
        }
    }
}
