package y.f.f.d;

import y.f.f.b.*;
import y.f.*;
import java.awt.*;
import y.c.*;

class d implements M
{
    private h a;
    private A b;
    private A c;
    private A d;
    private int e;
    private int f;
    
    public d(final int f) {
        this.f = f;
    }
    
    public void a(final h a) {
        final boolean p = o.p;
        y.g.o.a(this, "Prescribed size model !");
        this.a = a;
        final X x = (X)a.a();
        this.b = x.t();
        this.c = x.t();
        this.d = x.t();
        double floor = this.f;
        final c c = x.c(t.a);
        final c c2 = x.c("MIN_DIST_DP_KEY");
        final x o = x.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final double d;
                final boolean b = (d = (a.d(e) ? 1 : 0)) != 0.0;
                if (p) {
                    if (d == 0) {
                        floor = 1.0;
                    }
                    Label_0563: {
                        if (floor > 1.0) {
                            floor = Math.floor(floor);
                            if (!p) {
                                break Label_0563;
                            }
                        }
                        floor = 1.0 / Math.ceil(1.0 / floor);
                    }
                    this.e = (int)Math.ceil(this.f / floor);
                    final double n = this.f / this.e;
                    final x o2 = x.o();
                    while (o2.f()) {
                        final q e2 = o2.e();
                        if (a.d(e2)) {
                            int a2 = 0;
                            if (c != null) {
                                a2 = c.a(e2);
                            }
                            int a3 = 0;
                            int b2 = 0;
                            int c3 = 0;
                            int d2 = 0;
                            if (c2 != null) {
                                final f f = (f)c2.b(e2);
                                if (f != null) {
                                    a3 = f.a();
                                    b2 = f.b();
                                    c3 = f.c();
                                    d2 = f.d();
                                }
                            }
                            final double n2 = x.p(e2) / 2.0;
                            final double n3 = x.q(e2) / 2.0;
                            final int n4 = (int)Math.ceil(n2 / this.f) * 2;
                            final int n5 = (int)Math.ceil(n3 / this.f) * 2;
                            if (a2 > Math.min((2.0 * n2 - c3 - d2) / 2.0, (2.0 * n3 - a3 - b2) / 2.0)) {
                                a2 = (int)Math.floor(Math.min((2.0 * n2 - c3 - d2) / 2.0, (2.0 * n3 - a3 - b2) / 2.0));
                            }
                            this.d.a(e2, new Dimension((int)(n4 * this.e / 2 - Math.floor((n2 - a2) / n)), (int)(n5 * this.e / 2 - Math.floor((n3 - a2) / n))));
                            this.c.a(e2, new Dimension(n4, n5));
                        }
                        o2.g();
                        if (p) {
                            break;
                        }
                    }
                    return;
                }
                Label_0518: {
                    if (b) {
                        this.b.a(e, true);
                        final int[][] i = a.i(e);
                        final int[] array = new int[4];
                        int n6 = 0;
                        do {
                            int j = 0;
                            int n7 = 0;
                            while (j < n7) {
                                final int n8 = i[n6][0];
                                final int n9 = i[n6][2];
                                j = n8;
                                n7 = n9;
                                if (!p) {
                                    Label_0223: {
                                        if (j == n7) {
                                            array[n6] = n8;
                                            if (!p) {
                                                break Label_0223;
                                            }
                                        }
                                        array[n6] = Math.max(0, ((n8 < n9) ? n9 : n8) - (1 - i[n6][1]));
                                    }
                                    ++n6;
                                }
                            }
                            break;
                        } while (!p);
                        int a4 = 0;
                        if (c != null) {
                            a4 = c.a(e);
                        }
                        int a5 = 0;
                        int b3 = 0;
                        int c4 = 0;
                        int d3 = 0;
                        if (c2 != null) {
                            final f f2 = (f)c2.b(e);
                            if (f2 != null) {
                                a5 = f2.a();
                                b3 = f2.b();
                                c4 = f2.c();
                                d3 = f2.d();
                            }
                        }
                        final int n10 = (array[1] > array[3]) ? array[1] : array[3];
                        final int n11 = (array[0] > array[2]) ? array[0] : array[2];
                        final double n12 = (x.p(e) - c4 - d3) / 2.0;
                        final double n13 = (x.q(e) - a5 - b3) / 2.0;
                        if (a4 > Math.min(n12, n13)) {
                            a4 = (int)Math.floor(Math.min(n12, n13));
                        }
                        final double n14 = n12 - a4;
                        final double n15 = n13 - a4;
                        double n16 = 2.147483647E9;
                        double n17 = 2.147483647E9;
                        if (n10 > 0) {
                            n17 = n15 / n10;
                        }
                        if (n17 < floor) {
                            floor = n17;
                        }
                        if (n11 > 0) {
                            n16 = n14 / n11;
                        }
                        if (n16 >= floor) {
                            break Label_0518;
                        }
                        floor = n16;
                        if (!p) {
                            break Label_0518;
                        }
                    }
                    this.b.a(e, false);
                }
                o.g();
                if (p) {
                    break;
                }
            }
            double d = dcmpl(floor, 0.0);
            continue;
        }
    }
    
    public boolean a() {
        return false;
    }
    
    public int e(final q q) {
        return ((Dimension)this.d.b(q)).width;
    }
    
    public int f(final q q) {
        return ((Dimension)this.d.b(q)).height;
    }
    
    public boolean a(final q q) {
        return this.b.d(q);
    }
    
    public int b(final q q) {
        return ((Dimension)this.c.b(q)).width;
    }
    
    public int c(final q q) {
        return ((Dimension)this.c.b(q)).height;
    }
    
    public boolean d(final q q) {
        return this.a(q);
    }
    
    public double b() {
        return this.e;
    }
    
    public boolean c() {
        return true;
    }
    
    public void d() {
        this.a.a().a(this.b);
        this.a.a().a(this.c);
        this.a.a().a(this.d);
    }
}
