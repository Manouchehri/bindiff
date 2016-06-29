package y.f.c;

import java.util.*;
import y.g.*;
import y.c.*;
import y.f.*;

class B implements Comparator, g
{
    Comparator a;
    Comparator b;
    private final x c;
    
    B(final x c, final Comparator a, final Comparator b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final aE a = this.c.a((d)o);
        final aE a2 = this.c.a((d)o2);
        if (a != null && a.a()) {
            if (a2 != null && a2.a()) {
                return this.b.compare(o, o2);
            }
            return -1;
        }
        else {
            if (a2 != null && a2.a()) {
                return 1;
            }
            return this.a.compare(o, o2);
        }
    }
}
