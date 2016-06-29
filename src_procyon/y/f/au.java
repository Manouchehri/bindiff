package y.f;

import java.util.*;
import y.c.*;

class au implements Comparator
{
    final c a;
    
    private au(final c a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        if (this.a.d(o) && !this.a.d(o2)) {
            return -1;
        }
        if (!this.a.d(o) && this.a.d(o2)) {
            return 1;
        }
        return 0;
    }
    
    au(final c c, final at at) {
        this(c);
    }
}
