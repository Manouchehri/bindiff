package y.f.h;

import java.util.*;
import y.c.*;

class K implements Comparator
{
    private final J a;
    
    K(final J a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final int k = J.a(this.a).c(d).k();
        final int i = J.a(this.a).c(d2).k();
        if (k == i) {
            return 0;
        }
        if (k > i) {
            return -1;
        }
        return 1;
    }
}
