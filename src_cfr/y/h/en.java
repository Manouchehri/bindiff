/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.AffineTransform;
import y.h.eM;

final class eN
extends eM {
    byte a;
    double b;
    double c;

    eN() {
    }

    @Override
    public int a() {
        return this.a;
    }

    @Override
    public int a(double[] arrd) {
        arrd[0] = this.b;
        arrd[1] = this.c;
        return this.a;
    }

    @Override
    public int a(float[] arrf) {
        arrf[0] = (float)this.b;
        arrf[1] = (float)this.c;
        return this.a;
    }

    @Override
    int a(float[] arrf, AffineTransform affineTransform) {
        arrf[0] = (float)this.b;
        arrf[1] = (float)this.c;
        affineTransform.transform(arrf, 0, arrf, 0, 1);
        return this.a;
    }

    @Override
    int a(double[] arrd, AffineTransform affineTransform) {
        arrd[0] = this.b;
        arrd[1] = this.c;
        affineTransform.transform(arrd, 0, arrd, 0, 1);
        return this.a;
    }
}

