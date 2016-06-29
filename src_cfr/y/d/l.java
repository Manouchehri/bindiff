/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import y.c.D;
import y.c.p;
import y.d.g;
import y.d.h;
import y.d.j;
import y.d.t;

class l
implements j {
    D[] a;
    p b;
    final double c;
    final double d;
    final double e;
    final int f;

    l(double d2, double d3, int n2) {
        boolean bl2 = t.d;
        this.a = new D[n2];
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = new D();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.c = d2;
        this.d = d3;
        this.e = d3 - d2 + 1.0;
        this.f = this.a.length / 2;
    }

    @Override
    public void a(h h2) {
        int n2;
        block4 : {
            h h3;
            boolean bl2 = t.d;
            n2 = 0;
            double d2 = this.c;
            double d3 = this.d;
            while (n2 < this.f) {
                double d4 = 0.5 * (d3 - d2);
                h3 = h2;
                if (!bl2) {
                    if (h3.b < d4) {
                        n2 = (n2 << 1) + 1;
                        d3 = d4;
                        if (!bl2) continue;
                    }
                    if (h2.a <= d4) break;
                    n2 = (n2 << 1) + 2;
                    d2 = d4;
                    if (!bl2) continue;
                }
                break block4;
            }
            if (this.b != null) {
                p p2 = (p)this.b.c();
                this.b.a(h2);
                this.a[n2].a(this.b);
                h2.e = this.b;
                this.b = p2;
                if (!bl2) return;
            }
            h3 = h2;
        }
        h3.e = this.a[n2].b(h2);
    }

    @Override
    public void b(h h2) {
        block3 : {
            h h3;
            boolean bl2 = t.d;
            int n2 = 0;
            double d2 = this.c;
            double d3 = this.d;
            while (n2 < this.f) {
                double d4 = 0.5 * (d3 - d2);
                h3 = h2;
                if (!bl2) {
                    if (h3.b < d4) {
                        n2 = (n2 << 1) + 1;
                        d3 = d4;
                        if (!bl2) continue;
                    }
                    if (h2.a <= d4) break;
                    n2 = (n2 << 1) + 2;
                    d2 = d4;
                    if (!bl2) continue;
                }
                break block3;
            }
            this.a[n2].h(h2.e);
            h3 = h2;
        }
        h3.e.a(this.b);
        this.b = h2.e;
    }

    void a(h h2, g g2, int n2, double d2, double d3) {
        h h3;
        p p2;
        boolean bl2 = t.d;
        double d4 = 0.5 * (d3 - d2);
        Object object = h2.d;
        if (n2 < this.f) {
            block13 : {
                if (h2.b < d4) {
                    block11 : {
                        for (p2 = this.a[n2].k(); p2 != null; p2 = p2.a()) {
                            h3 = (h)p2.c();
                            if (!bl2) {
                                if (h3.b < h2.a || h3.a > h2.b) continue;
                                g2.a(object, h3.d);
                                if (!bl2) continue;
                            }
                            break block11;
                        }
                        this.a(h2, g2, (n2 << 1) + 1, d2, d4);
                    }
                    if (!bl2) return;
                }
                if (h2.a > d4) {
                    block12 : {
                        for (p2 = this.a[n2].k(); p2 != null; p2 = p2.a()) {
                            h3 = (h)p2.c();
                            if (!bl2) {
                                if (h3.b < h2.a || h3.a > h2.b) continue;
                                g2.a(object, h3.d);
                                if (!bl2) continue;
                            }
                            break block12;
                        }
                        this.a(h2, g2, (n2 << 1) + 2, d4, d3);
                    }
                    if (!bl2) return;
                }
                for (p2 = this.a[n2].k(); p2 != null; p2 = p2.a()) {
                    h3 = (h)p2.c();
                    g2.a(object, h3.d);
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block13;
                }
                this.a(h2, g2, (n2 << 1) + 1, d2, d4);
                this.a(h2, g2, (n2 << 1) + 2, d4, d3);
            }
            if (!bl2) return;
        }
        p2 = this.a[n2].k();
        do {
            if (p2 == null) return;
            h3 = (h)p2.c();
            if (h3.b >= h2.a && h3.a <= h2.b) {
                g2.a(object, h3.d);
            }
            p2 = p2.a();
        } while (!bl2);
    }

    @Override
    public void a(h h2, g g2) {
        this.a(h2, g2, 0, this.c, this.d);
    }
}

