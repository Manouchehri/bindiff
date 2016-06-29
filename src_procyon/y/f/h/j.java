package y.f.h;

import java.util.*;
import y.c.*;

class j implements Comparator
{
    private final h a;
    private final i b;
    
    j(final i b, final h a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final int a = this.a.a(d);
        final int a2 = this.a.a(d2);
        if (a == a2) {
            return 0;
        }
        if (a < a2) {
            return 1;
        }
        return -1;
    }
}
