package y.f.i.a;

import java.util.*;
import y.d.*;

class af implements Comparator
{
    private final ae a;
    
    af(final ae a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final t t = (t)o;
        final t t2 = (t)o2;
        if (t.a() < t2.a() - 1.0E-6) {
            return -1;
        }
        if (t.a() > t2.a() + 1.0E-6) {
            return 1;
        }
        if (t.b() < t2.b() - 1.0E-6) {
            return -1;
        }
        if (t.b() > t2.b() + 1.0E-6) {
            return 1;
        }
        return (int)(t.a() + t.b() - (t2.a() + t2.b()));
    }
}
