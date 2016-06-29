package y.f.c;

import java.util.*;
import y.g.*;
import y.f.c.a.*;

class O implements Comparator, g
{
    private O() {
    }
    
    public int compare(final Object o, final Object o2) {
        final bK bk = (bK)o;
        final bK bk2 = (bK)o2;
        if (bk.a()) {
            if (bk2.a()) {
                return 0;
            }
            return 1;
        }
        else {
            if (bk2.a()) {
                return -1;
            }
            return bk.compareTo(o2);
        }
    }
    
    O(final N n) {
        this();
    }
}
