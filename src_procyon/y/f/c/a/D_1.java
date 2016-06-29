package y.f.c.a;

import java.util.*;
import y.f.*;

public class D implements bx
{
    private Comparator a;
    
    public D() {
        this(null);
    }
    
    public D(final Comparator comparator) {
        this.a(comparator);
    }
    
    public void a(final Comparator a) {
        this.a = a;
    }
    
    public void a(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        int i = 0;
        while (i < au.b()) {
            final y.c.D d = new y.c.D(au.a(i).d().m());
            d.sort(this.a);
            au.a(i).a(d);
            ++i;
            if (x2) {
                break;
            }
        }
    }
}
