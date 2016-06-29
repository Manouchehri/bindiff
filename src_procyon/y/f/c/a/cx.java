package y.f.c.a;

import java.util.*;

class cx
{
    private ArrayList a;
    
    cx() {
        this.a = new ArrayList();
    }
    
    void a(final cw cw) {
        this.a.add(cw);
    }
    
    void b(final cw cw) {
        this.a.remove(cw);
    }
    
    cw a(final double n) {
        final boolean x = N.x;
        double max = -1.7976931348623157E308;
        cw cw = null;
        double n2 = -1.7976931348623157E308;
        while (true) {
            for (final cw cw2 : this.a) {
                final double n3 = cw2.c + cw2.d;
                final cw cw3 = cw;
                if (!x) {
                    if (cw3 == null || n3 > n2) {
                        cw = cw2;
                        n2 = n3;
                    }
                    max = Math.max(max, n3 + cw2.e);
                    if (x) {
                        break;
                    }
                    continue;
                }
                else {
                    if (cw3 == null) {
                        return null;
                    }
                    return new cw(n, cw.c, cw.d, max - n2, cw.a);
                }
            }
            continue;
        }
    }
}
