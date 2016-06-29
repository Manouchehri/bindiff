package y.f.i.a;

import java.util.*;
import y.c.*;

class aO implements Comparator
{
    private final A a;
    private final aN b;
    
    aO(final aN b, final A a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final int a = this.a.a(o);
        final int a2 = this.a.a(o2);
        if (a < a2) {
            return -1;
        }
        if (a > a2) {
            return 1;
        }
        return 0;
    }
}
