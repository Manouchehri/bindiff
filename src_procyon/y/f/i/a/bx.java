package y.f.i.a;

import y.c.*;
import java.util.*;

class bx
{
    boolean a;
    int b;
    int c;
    final D d;
    final bv[] e;
    
    bx(final bv[] e, final int c, final int b, final boolean a, final D d) {
        this.e = e;
        this.b = b;
        this.a = a;
        this.d = d;
        this.c = c;
    }
    
    public boolean a(final bx bx) {
        return this.c > bx.c || (this.c >= bx.c && (this.b > bx.b || (this.b >= bx.b && this.d.size() < bx.d.size())));
    }
    
    public boolean a() {
        final int a = ab.a;
        final Iterator iterator = this.d.iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            if (iterator.next().a()) {
                b = true;
                if (a == 0) {
                    return b;
                }
                return b;
            }
        }
        return b;
    }
    
    public boolean b() {
        return this.a;
    }
}
