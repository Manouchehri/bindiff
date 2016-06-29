package y.f.i;

import java.util.*;
import y.d.*;
import y.c.*;

class ap implements Comparator
{
    private t a;
    private q b;
    private c c;
    
    public ap(final t a, final c c) {
        this.a = a;
        this.c = c;
    }
    
    public void a(final q b) {
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final int f = v.f;
        final d d = (d)o;
        final d d2 = (d)o2;
        final ao ao = (ao)this.c.b(d.a(this.b));
        final ao ao2 = (ao)this.c.b(d2.a(this.b));
        if (ao == null && ao2 == null) {
            return 0;
        }
        if (ao == null) {
            return -1;
        }
        if (ao2 == null) {
            return 1;
        }
        double n = 0.0;
        Label_0136: {
            if (ao.x()) {
                n = Math.abs(ao.r() - this.a.a);
                if (f == 0) {
                    break Label_0136;
                }
            }
            n = Math.abs(ao.s() - this.a.b);
        }
        double n2 = 0.0;
        Label_0185: {
            if (ao2.x()) {
                n2 = Math.abs(ao2.r() - this.a.a);
                if (f == 0) {
                    break Label_0185;
                }
            }
            n2 = Math.abs(ao2.s() - this.a.b);
        }
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        return 0;
    }
}
