package y.f.c;

import java.util.*;
import y.c.*;
import y.g.*;

class T implements Comparator
{
    private final int[] a;
    private final S b;
    
    T(final S b, final int[] a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(this.a[((d)o).c().d()], this.a[((d)o2).c().d()]);
    }
}
