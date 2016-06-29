package y.f.c;

import y.g.*;
import y.f.*;
import y.c.*;
import y.f.c.a.*;

public class D implements R, aT
{
    public static final Object a;
    
    public int a(final i i, final c c, final a a) {
        final boolean j = a.i;
        if (i.i()) {
            return 0;
        }
        final q[] m = i.m();
        e.a(m, e.b(c));
        int a2;
        int n = a2 = c.a(m[0]);
        int k = 0;
        int n2 = 0;
        int n3 = 0;
        while (k < m.length) {
            final int a3 = c.a(m[k]);
            n2 = a3 - n;
            n3 = 1;
            if (j) {
                return n2 + n3;
            }
            if (n2 > n3) {
                a2 += a3 - n - 1;
            }
            a.a(m[k], a3 - a2);
            n = a3;
            ++k;
            if (j) {
                break;
            }
        }
        return n2 + n3;
    }
    
    public int a(final X x, final A a, final f f) {
        if (x.i()) {
            return 0;
        }
        final c c = x.c(D.a);
        if (c == null) {
            throw new IllegalArgumentException("Given graph does not yield LAYER_ID_KEY DataProvider");
        }
        final int a2 = this.a(x, c, a);
        f.a(w.a(x, a));
        return a2;
    }
    
    public void a(final X x, final aU au, final aV av) {
        new ba(this).a(x, au, av);
    }
    
    static {
        a = "y.layout.hierarchic.GivenLayersLayerer.LAYER_ID_KEY";
    }
}
