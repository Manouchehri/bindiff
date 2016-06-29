package y.f.c;

import java.util.*;
import y.c.*;
import y.g.*;

class ad implements Comparator
{
    boolean a;
    int[] b;
    
    ad(final int[] b, final boolean a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        if (this.a) {
            return e.a(this.b[((d)o).c().d()], this.b[((d)o2).c().d()]);
        }
        return e.a(this.b[((d)o).d().d()], this.b[((d)o2).d().d()]);
    }
}
