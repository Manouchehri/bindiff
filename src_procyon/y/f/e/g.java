package y.f.e;

import y.c.*;
import y.g.*;
import y.f.*;

class g
{
    public final q a;
    public double b;
    public double c;
    public double d;
    public double e;
    public int f;
    public double g;
    public double h;
    public double i;
    public double j;
    public double k;
    public double l;
    public final boolean m;
    public int n;
    public byte o;
    public g p;
    public double q;
    public double r;
    public D s;
    
    g(final q a, final double g, final boolean m, final double q, final int n, final ar ar, final X x, final byte b) {
        final boolean b2 = y.f.e.i.b;
        this.a = a;
        this.e = 1.0E-4;
        this.m = m;
        this.g = g;
        this.l = 1.0;
        this.k = (x.p(a) + x.q(a)) / 4.0;
        this.q = q;
        Label_0154: {
            switch (b) {
                case 0: {
                    final double n2 = 0.45 * q * Math.sqrt(n);
                    this.h = ar.a(-n2, n2);
                    this.i = ar.a(-n2, n2);
                    this.j = ar.a(-n2, n2);
                    if (b2) {
                        break Label_0154;
                    }
                    return;
                }
                case 1: {
                    final double h = 0.0;
                    this.j = h;
                    this.i = h;
                    this.h = h;
                    if (b2) {
                        break;
                    }
                    return;
                }
            }
        }
        this.h = x.l(a).a();
        this.i = x.l(a).b();
        if (this.m) {
            this.j = ar.a(-q * 0.3, q * 0.3);
            if (!b2) {
                return;
            }
        }
        this.j = 0.0;
    }
}
