package y.d.a;

import java.util.*;
import y.g.*;

class d implements Comparator, g
{
    Object a;
    Comparator b;
    private final b c;
    
    d(final b c) {
        this.c = c;
        this.b = new f(c);
    }
    
    void a(final Object a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final e e = (e)o;
        final e e2 = (e)o2;
        final int c = y.d.a.b.a(this.c).c(e2.c, e2.d, this.a);
        if (c != 0) {
            return -c;
        }
        return this.b.compare(e, e2);
    }
}
