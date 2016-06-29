package y.d;

import java.util.*;

class i implements Comparator
{
    public int compare(final Object o, final Object o2) {
        final k k = (k)o;
        final k i = (k)o2;
        if (k.a < i.a) {
            return -1;
        }
        if (k.a > i.a) {
            return 1;
        }
        if (k.b == 1 && i.b == 0) {
            return 1;
        }
        if (k.b == 0 && i.b == 1) {
            return -1;
        }
        return 0;
    }
    
    public boolean equals(final Object o) {
        return false;
    }
}
