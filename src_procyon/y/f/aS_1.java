package y.f;

import java.util.*;
import y.c.*;

class aS implements Comparator
{
    private final A a;
    
    aS(final A a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final aT at = (aT)this.a.b(o);
        final aT at2 = (aT)this.a.b(o2);
        if (at.a() > at2.a()) {
            return 1;
        }
        if (at.a() < at2.a()) {
            return -1;
        }
        return 0;
    }
}
