package y.f.e;

import y.g.*;
import y.c.*;
import y.f.*;

public class k implements ad
{
    private ah h;
    protected X a;
    protected ar b;
    protected double[] c;
    protected double[] d;
    protected double[] e;
    protected double[] f;
    protected q[] g;
    private int i;
    private double n;
    
    public k(ar b, final double n) {
        this.i = 0;
        if (b == null) {
            b = new ar();
        }
        this.b = b;
        this.n = n;
    }
    
    public void c(final X a) {
        final boolean b = y.f.e.i.b;
        if (this.h != null) {
            this.h.c(a);
        }
        if (a.e() < 1) {
            return;
        }
        this.a = a;
        this.g = a.m();
        this.c = new double[this.g.length];
        this.d = new double[this.g.length];
        this.e = new double[this.g.length];
        this.f = new double[this.g.length];
        double n = 0.0;
        double n2 = 0.0;
        double n4;
        double n3 = n4 = Double.MAX_VALUE;
        double n6;
        double n5 = n6 = -1.7976931348623157E308;
        final double n7 = this.n * 2.0;
        int i = this.g.length - 1;
        while (true) {
        Label_0816_Outer:
            while (i >= 0) {
                final am a2 = a.a((Object)this.g[i]);
                final double n8 = this.n;
                final double n9 = 0.0;
                if (b) {
                    double max = Math.max(n8, n9);
                    final l l = new l();
                    l.a(this.n);
                    l.a(false);
                    l.b(true);
                    l.a((byte)2);
                    int n10 = 10;
                Label_0816:
                    while (true) {
                        boolean b2 = false;
                        do {
                            l.c(a);
                            double n11 = 0.0;
                            double max2 = 0.0;
                        Label_0476:
                            while (true) {
                                int j = this.g.length - 1;
                                while (true) {
                                    while (j >= 0) {
                                        final double n12 = this.c[j] - a.j(this.g[j]);
                                        final double n13 = this.d[j] - a.k(this.g[j]);
                                        n11 += n12 * n12 + n13 * n13;
                                        max2 = Math.max(max2, n12 * n12 + n13 * n13);
                                        --j;
                                        if (!b) {
                                            if (b) {
                                                break;
                                            }
                                            continue Label_0816_Outer;
                                        }
                                        else {
                                            final double n14 = Math.sqrt(n11) / (Math.sqrt(max) * 0.025);
                                            b2 = (n14 > 1.01 && n10-- > 0 && Math.sqrt(max2) >= this.n);
                                            if (b2) {
                                                final double n15 = n / this.g.length;
                                                final double n16 = n2 / this.g.length;
                                                n2 = (n = 0.0);
                                                final double min = Math.min(2.0, 1.05 + Math.sqrt(n14) * 0.05);
                                                max *= min * min;
                                                int k = this.g.length - 1;
                                                while (k >= 0) {
                                                    final double n17 = n;
                                                    final double[] c = this.c;
                                                    final int n18 = k;
                                                    final double n19 = n15 + (this.c[k] - n15) * min;
                                                    c[n18] = n19;
                                                    n = n17 + n19;
                                                    final double n20 = n2;
                                                    final double[] d = this.d;
                                                    final int n21 = k;
                                                    final double n22 = n15 + (this.d[k] - n16) * min;
                                                    d[n21] = n22;
                                                    n2 = n20 + n22;
                                                    a.a(this.g[k], this.c[k], this.d[k]);
                                                    --k;
                                                    if (b) {
                                                        continue Label_0476;
                                                    }
                                                    if (b) {
                                                        break;
                                                    }
                                                }
                                                continue Label_0816;
                                            }
                                            continue Label_0816;
                                        }
                                    }
                                    n11 /= this.g.length;
                                    continue;
                                }
                            }
                        } while (b2);
                        break;
                    }
                    return;
                }
                Label_0231: {
                    if (n8 > n9) {
                        this.e[i] = a2.getWidth() + this.n;
                        this.f[i] = a2.getHeight() + this.n;
                        if (!b) {
                            break Label_0231;
                        }
                    }
                    this.e[i] = a2.getWidth();
                    this.f[i] = a2.getHeight();
                }
                final double n23 = a2.getX() + a2.getWidth() / 2.0;
                final double n24 = a2.getY() + a2.getHeight() / 2.0;
                final double n25 = n;
                final double[] c2 = this.c;
                final int n26 = i;
                final double n27 = n23;
                c2[n26] = n27;
                n = n25 + n27;
                final double n28 = n2;
                final double[] d2 = this.d;
                final int n29 = i;
                final double n30 = n24;
                d2[n29] = n30;
                n2 = n28 + n30;
                final double n31 = 0.5 * a2.getWidth();
                final double n32 = 0.5 * a2.getHeight();
                if (n23 + n31 > n6) {
                    n6 = n23 + n31;
                }
                if (n24 + n32 > n5) {
                    n5 = n24 + n32;
                }
                if (n23 - n31 < n4) {
                    n4 = n23 - n31;
                }
                if (n24 - n32 < n3) {
                    n3 = n24 - n32;
                }
                --i;
                if (b) {
                    break;
                }
            }
            continue;
        }
    }
    
    public ah a() {
        return this.h;
    }
    
    public void a(final ah h) {
        this.h = h;
    }
}
