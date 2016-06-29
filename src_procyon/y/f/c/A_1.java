package y.f.c;

import java.util.*;
import y.g.*;
import y.c.*;
import y.f.*;

class A implements Comparator, g
{
    Comparator a;
    Comparator b;
    private final x c;
    
    A(final x c, final Comparator a, final Comparator b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final aE b = this.c.b((d)o);
        final aE b2 = this.c.b((d)o2);
        if (b != null && b.a()) {
            if (b2 != null && b2.a()) {
                return this.b.compare(o, o2);
            }
            return -1;
        }
        else {
            if (b2 != null && b2.a()) {
                return 1;
            }
            return this.a.compare(o, o2);
        }
    }
}
