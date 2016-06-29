package y.f.c;

import y.c.*;
import y.f.*;

public class y
{
    public z[] a;
    public D b;
    private double c;
    private double d;
    
    public y(final am am) {
        this(am.getX(), am.getY(), am.getWidth(), am.getHeight());
    }
    
    public y(final double n, final double n2, final double d, final double c) {
        this.a = new z[12];
        this.b = new D();
        this.a[0] = new z(n, n2, 0, false);
        this.a[1] = new z(n, n2, 0, false);
        this.a[2] = new z(n + d, n2, 0, true);
        this.a[3] = new z(n + d, n2, 1, false);
        this.a[4] = new z(n + d, n2, 1, false);
        this.a[5] = new z(n + d, n2 + c, 1, true);
        this.a[6] = new z(n + d, n2 + c, 2, false);
        this.a[7] = new z(n + d, n2 + c, 2, false);
        this.a[8] = new z(n, n2 + c, 2, true);
        this.a[9] = new z(n, n2 + c, 3, false);
        this.a[10] = new z(n, n2 + c, 3, false);
        this.a[11] = new z(n, n2, 3, true);
        this.d = d;
        this.c = c;
    }
    
    public void a() {
        final boolean i = y.f.c.a.i;
        int j = 11;
        while (j >= 0) {
            this.a[j].c();
            --j;
            if (i) {
                break;
            }
        }
    }
    
    public void a(final am am) {
        final double x = am.getX();
        final double y = am.getY();
        final double n = x + am.getWidth();
        final double n2 = y + am.getHeight();
        this.a[0].d = x;
        this.a[0].c = y;
        this.a[1].d = x;
        this.a[1].c = y;
        this.a[2].d = n;
        this.a[2].c = y;
        this.a[3].d = n;
        this.a[3].c = y;
        this.a[4].d = n;
        this.a[4].c = y;
        this.a[5].d = n;
        this.a[5].c = n2;
        this.a[6].d = n;
        this.a[6].c = n2;
        this.a[7].d = n;
        this.a[7].c = n2;
        this.a[8].d = x;
        this.a[8].c = n2;
        this.a[9].d = x;
        this.a[9].c = n2;
        this.a[10].d = x;
        this.a[10].c = n2;
        this.a[11].d = x;
        this.a[11].c = y;
    }
    
    public z a(final int n) {
        return this.a[(4 + n & 0x3) * 3];
    }
    
    public z b(final int n) {
        return this.a[2 + (4 + n & 0x3) * 3];
    }
    
    public z c(final int n) {
        return this.a[1 + (4 + n & 0x3) * 3];
    }
    
    public double d(int n) {
        n = (4 + n & 0x3);
        return ((n & 0x1) == 0x1) ? this.c : this.d;
    }
    
    public double e(int n) {
        n = (4 + n & 0x3) * 3;
        return Math.max(this.a[n++].d(), Math.max(this.a[n++].d(), this.a[n++].d()));
    }
    
    public double f(int n) {
        n = (4 + n & 0x3) * 3;
        return Math.max(this.a[n++].e(), Math.max(this.a[n++].e(), this.a[n++].e()));
    }
    
    public double g(int n) {
        n = (4 + n & 0x3) * 3;
        final double max = Math.max(this.a[n].k, Math.max(this.a[n + 1].k, this.a[n + 2].k));
        final double max2 = Math.max(this.a[n].f + max, Math.max(this.a[n + 1].f + max, this.a[n + 2].f + max));
        this.a[n++].b(max2);
        this.a[n++].b(max2);
        this.a[n++].b(max2);
        return max2;
    }
}
