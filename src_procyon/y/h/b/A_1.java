package y.h.b;

import java.util.*;
import y.h.*;
import y.g.*;
import y.c.*;

class A implements Comparator
{
    private boolean a;
    private I b;
    private bu c;
    
    A(final boolean a, final I b, final bu c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int compare(final Object o, final Object o2) {
        final q a = this.b.a((i)o);
        final q a2 = this.b.a((i)o2);
        return this.a ? e.a(this.c.j(a), this.c.j(a2)) : e.a(this.c.k(a), this.c.k(a2));
    }
}
