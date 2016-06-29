package y.f.c;

import java.util.*;
import y.c.*;
import y.g.*;
import y.f.*;

final class an implements Comparator
{
    int[] a;
    private final am b;
    
    an(final am b) {
        this.b = b;
        this.a = new int[] { 0, 0, 1, 0 };
    }
    
    public int compare(final Object o, final Object o2) {
        final aE a = this.b.a((d)o);
        final aE a2 = this.b.a((d)o2);
        final aE b = this.b.b((d)o);
        final aE b2 = this.b.b((d)o2);
        final int a3 = x.a(a.b(), 2);
        final int a4 = x.a(a2.b(), 2);
        final int a5 = x.a(b.b(), 0);
        final int a6 = x.a(b2.b(), 0);
        final int n = 4 + a5 - a3 & 0x3;
        final int n2 = 4 + a6 - a4 & 0x3;
        if (n == 2 && n2 == 2) {
            return e.a(Math.min(a4, a6), Math.min(a3, a5));
        }
        final int n3 = this.a[n];
        final int n4 = this.a[n2];
        if (n3 == n4) {
            return e.a(a3, a4);
        }
        return e.a(n3, n4);
    }
}
