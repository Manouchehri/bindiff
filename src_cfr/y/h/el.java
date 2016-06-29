/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.AffineTransform;
import y.h.eM;

final class eL
extends eM {
    double a;
    double b;
    double c;
    double d;
    double e;
    double f;

    eL() {
    }

    @Override
    public int a() {
        return 2;
    }

    @Override
    public int a(double[] arrd) {
        arrd[0] = this.a;
        arrd[1] = this.b;
        arrd[2] = this.c;
        arrd[3] = this.d;
        arrd[4] = this.e;
        arrd[5] = this.f;
        return 3;
    }

    @Override
    public int a(float[] arrf) {
        arrf[0] = (float)this.a;
        arrf[1] = (float)this.b;
        arrf[2] = (float)this.c;
        arrf[3] = (float)this.d;
        arrf[4] = (float)this.e;
        arrf[5] = (float)this.f;
        return 3;
    }

    @Override
    int a(float[] arrf, AffineTransform affineTransform) {
        arrf[0] = (float)this.a;
        arrf[1] = (float)this.b;
        arrf[2] = (float)this.c;
        arrf[3] = (float)this.d;
        arrf[4] = (float)this.e;
        arrf[5] = (float)this.f;
        affineTransform.transform(arrf, 0, arrf, 0, 3);
        return 3;
    }

    @Override
    int a(double[] arrd, AffineTransform affineTransform) {
        arrd[0] = this.a;
        arrd[1] = this.b;
        arrd[2] = this.c;
        arrd[3] = this.d;
        arrd[4] = this.e;
        arrd[5] = this.f;
        affineTransform.transform(arrd, 0, arrd, 0, 3);
        return 3;
    }
}

