package y.f.c;

import java.util.*;
import y.c.*;
import y.f.*;
import y.f.c.a.*;

public class e implements R, aT
{
    private double a;
    private double b;
    private double c;
    private double d;
    
    public e() {
        this.a = 1.0;
        this.b = 0.0;
        this.c = Double.MAX_VALUE;
        this.d = 0.0;
    }
    
    public void a(final double c) {
        if (c < 0.0) {
            throw new IllegalArgumentException();
        }
        this.c = c;
    }
    
    public int a(final X x, final A a, final f f) {
        final boolean i = a.i;
        if (x.i()) {
            return 0;
        }
        final q[] m = x.m();
        y.g.e.a(m, new y.f.c.f(this, x));
        int n = 0;
        double b = this.b(x, m[0]);
        a.a(m[0], n);
        int j = 1;
        double n2 = 0.0;
        while (j < m.length) {
            final q q = m[j];
            final double a2 = this.a(x, q);
            final double b2 = this.b(x, q);
            n2 = dcmpl(a2, b);
            if (i) {
                return (int)n2;
            }
            Label_0137: {
                if (n2 > 0) {
                    ++n;
                    b = b2;
                    if (!i) {
                        break Label_0137;
                    }
                }
                if (b2 > b) {
                    b = b2;
                }
            }
            a.a(q, n);
            ++j;
            if (i) {
                break;
            }
        }
        f.a(w.a(x, a));
        return (int)n2;
    }
    
    protected double a(final X x, final q q) {
        final am a = x.a((Object)q);
        return a.getY() + 0.5 * (a.getHeight() - Math.max(this.b, Math.min(this.c, this.d * 2.0 + a.getHeight() * this.a)));
    }
    
    protected double b(final X x, final q q) {
        final am a = x.a((Object)q);
        return a.getY() + 0.5 * (a.getHeight() + Math.max(this.b, Math.min(this.c, this.d * 2.0 + a.getHeight() * this.a)));
    }
    
    public void a(final X x, final aU au, final aV av) {
        new ba(this).a(x, au, av);
    }
}
