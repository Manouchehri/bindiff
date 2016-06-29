package y.f.i;

import java.util.*;
import y.f.*;
import y.c.*;
import y.g.*;

class aa implements Comparator
{
    X a;
    boolean b;
    
    aa(final X a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final int n = this.b ? e.a(this.a.m((q)o), this.a.m((q)o2)) : e.a(this.a.n((q)o), this.a.n((q)o2));
        if (n != 0) {
            return n;
        }
        return this.b ? e.a(this.a.n((q)o), this.a.n((q)o2)) : e.a(this.a.m((q)o), this.a.m((q)o2));
    }
}
