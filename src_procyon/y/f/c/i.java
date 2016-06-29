package y.f.c;

import java.util.*;
import y.c.*;
import y.g.*;

class i implements Comparator
{
    private final h a;
    
    i(final h a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(h.a(this.a)[((q)o).d()], h.a(this.a)[((q)o2).d()]);
    }
}
