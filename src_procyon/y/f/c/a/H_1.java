package y.f.c.a;

import y.c.*;
import y.g.*;

class H implements K
{
    private final int[] a;
    private final int[] b;
    private final int[] c;
    private final E d;
    
    H(final E d, final int[] a, final int[] b, final int[] c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int compare(final Object o, final Object o2) {
        final boolean x = N.x;
        int n2 = 0;
        int n = 0;
        boolean b = false;
        Label_0078: {
            if (o instanceof q) {
                n = (n2 = this.a[((q)o).d()]);
                b = false;
                if (!x) {
                    break Label_0078;
                }
            }
            final dg dg = (dg)o;
            n2 = this.b[dg.u];
            n = this.c[dg.u];
            b = (n2 != n);
        }
        int n4 = 0;
        int n3 = 0;
        boolean b2 = false;
        Label_0154: {
            if (o2 instanceof q) {
                n3 = (n4 = this.a[((q)o2).d()]);
                b2 = false;
                if (!x) {
                    break Label_0154;
                }
            }
            final dg dg2 = (dg)o2;
            n4 = this.b[dg2.u];
            n3 = this.c[dg2.u];
            b2 = (n4 != n3);
        }
        if (!b && !b2) {
            return e.a(n, n3);
        }
        if (n < n4) {
            return -1;
        }
        if (n3 < n2) {
            return 1;
        }
        if (b && b2) {
            if (n <= n4) {
                return -1;
            }
            if (n3 <= n2) {
                return 1;
            }
            return 0;
        }
        else if (b) {
            if (n4 >= n) {
                return -1;
            }
            if (n3 <= n2) {
                return 1;
            }
            return 0;
        }
        else {
            if (n2 >= n3) {
                return 1;
            }
            if (n <= n4) {
                return -1;
            }
            return 0;
        }
    }
}
