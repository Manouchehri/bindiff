package y.f.g;

import java.util.*;
import y.a.*;
import y.c.*;
import y.g.*;

class m implements Comparator
{
    int[] a;
    
    m(final i i) {
        if (g.b(i)) {
            throw new RuntimeException("Found cycle in constraint graph!");
        }
        y.a.m.a(i, this.a = new int[i.e()]);
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(this.a[((q)o).d()], this.a[((q)o2).d()]);
    }
}
