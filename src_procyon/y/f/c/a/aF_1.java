package y.f.c.a;

import java.util.*;
import y.c.*;

final class aF implements Comparator
{
    private c a;
    
    aF(final c a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final int a = this.a.a(o);
        final int a2 = this.a.a(o2);
        if (a > a2) {
            return -1;
        }
        if (a < a2) {
            return 1;
        }
        return 0;
    }
}
