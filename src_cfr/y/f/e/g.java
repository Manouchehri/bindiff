/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import y.c.D;
import y.c.q;
import y.d.t;
import y.f.X;
import y.f.e.i;
import y.g.ar;

class g {
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

    g(q q2, double d2, boolean bl2, double d3, int n2, ar ar2, X x2, byte by2) {
        boolean bl3 = i.b;
        this.a = q2;
        this.e = 1.0E-4;
        this.m = bl2;
        this.g = d2;
        this.l = 1.0;
        this.k = (x2.p(q2) + x2.q(q2)) / 4.0;
        this.q = d3;
        switch (by2) {
            case 0: {
                double d4 = 0.45 * d3 * Math.sqrt(n2);
                this.h = ar2.a(- d4, d4);
                this.i = ar2.a(- d4, d4);
                this.j = ar2.a(- d4, d4);
                if (!bl3) return;
            }
            case 1: {
                this.j = 0.0;
                this.i = 0.0;
                this.h = 0.0;
                if (!bl3) return;
            }
        }
        this.h = x2.l(q2).a();
        this.i = x2.l(q2).b();
        if (this.m) {
            this.j = ar2.a((- d3) * 0.3, d3 * 0.3);
            if (!bl3) return;
        }
        this.j = 0.0;
    }
}

