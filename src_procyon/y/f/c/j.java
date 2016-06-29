package y.f.c;

import java.util.*;
import y.c.*;
import y.g.*;

class j implements Comparator
{
    private final h a;
    
    j(final h a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a((int)h.a(this.a)[((d)o).c().d()], (int)h.a(this.a)[((d)o2).c().d()]);
    }
}
