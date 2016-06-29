package y.f.c.a;

import java.util.*;
import y.c.*;
import y.g.*;
import y.f.*;

final class cm implements Comparator
{
    X a;
    aV b;
    static final int[] c;
    
    cm(final X a, final aV b) {
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final aE a = cd.a(this.a, this.b, (d)o);
        final aE a2 = cd.a(this.a, this.b, (d)o2);
        final aE b = cd.b(this.a, this.b, (d)o);
        final aE b2 = cd.b(this.a, this.b, (d)o2);
        final int a3 = bY.a(a.b(), 2);
        final int a4 = bY.a(a2.b(), 2);
        final int a5 = bY.a(b.b(), 0);
        final int a6 = bY.a(b2.b(), 0);
        final int n = 4 + a5 - a3 & 0x3;
        final int n2 = 4 + a6 - a4 & 0x3;
        if (n == 2 && n2 == 2) {
            return e.a(Math.min(a4, a6), Math.min(a3, a5));
        }
        final int n3 = cm.c[n];
        final int n4 = cm.c[n2];
        if (n3 == n4) {
            return e.a(a3, a4);
        }
        return e.a(n3, n4);
    }
    
    static {
        c = new int[] { 0, 0, 1, 0 };
    }
}
