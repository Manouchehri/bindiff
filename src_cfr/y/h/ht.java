/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.Point2D;
import y.b.d;
import y.g.an;
import y.h.cU;
import y.h.ch;
import y.h.fj;

class hT
implements d {
    private static final double a = Math.log(2.0);
    private final double b;
    private double c;
    private Point2D d;
    private final an e;
    private final ch f;
    private final long g;
    private final cU h;
    private double i;
    private double j;
    private double k;
    private double l;
    private double m;
    private double n;
    private boolean o;

    public hT(ch ch2, double d2, an an2, long l2, cU cU2) {
        this.b = d2;
        this.e = an2;
        this.f = ch2;
        this.g = l2;
        this.h = cU2;
        this.i = Math.log(d2);
        this.j = this.i / a;
    }

    @Override
    public long preferredDuration() {
        return this.g;
    }

    @Override
    public void initAnimation() {
        this.c = this.f.getZoom();
        this.d = this.f.getCenter();
        this.k = Math.log(this.c);
        this.l = this.k / a;
        this.m = this.a(0.0);
        this.n = this.a(1.0) - this.m;
        this.o = Math.abs(this.c - this.b) < 1.0E-8;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void calcFrame(double var1_1) {
        var3_2 = 1.0 - var1_1;
        this.f.setZoom(Math.pow(2.0, var3_2 * this.l + var1_1 * this.j));
        if (!this.o) ** GOTO lbl-1000
        this.f.setCenter(var3_2 * this.d.getX() + var1_1 * this.e.a(), var3_2 * this.d.getY() + var1_1 * this.e.b());
        if (fj.z) lbl-1000: // 2 sources:
        {
            var5_3 = (this.a(var1_1) - this.m) / this.n;
            var7_4 = 1.0 - var5_3;
            this.f.setCenter(var7_4 * this.d.getX() + var5_3 * this.e.a(), var7_4 * this.d.getY() + var5_3 * this.e.b());
        }
        if (this.h == null) return;
        this.h.a();
    }

    @Override
    public void disposeAnimation() {
    }

    private double a(double d2) {
        return Math.pow(2.0, (this.l - this.j) * d2 - this.l) / (this.k - this.i);
    }
}

