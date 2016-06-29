package y.d.a;

import java.util.*;
import y.c.*;

class g implements Comparator, y.g.g
{
    private h a;
    private f b;
    private final b c;
    
    public g(final b c, final h a) {
        this.c = c;
        this.a = a;
        this.b = new f(c);
    }
    
    public int compare(final Object o, final Object o2) {
        if (o == o2) {
            return 0;
        }
        final int compare = this.b.compare(this.a.b(o), this.a.b(o2));
        if (compare != 0) {
            return compare;
        }
        return y.g.e.a(((e)this.a.b(o2)).b(), ((e)this.a.b(o)).b());
    }
}
