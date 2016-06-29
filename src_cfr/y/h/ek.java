/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.AffineTransform;
import y.h.eM;

final class eK
extends eM {
    double a;
    double b;
    double c;
    double d;

    eK() {
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
        return 2;
    }

    @Override
    public int a(float[] arrf) {
        arrf[0] = (float)this.a;
        arrf[1] = (float)this.b;
        arrf[2] = (float)this.c;
        arrf[3] = (float)this.d;
        return 2;
    }

    @Override
    int a(float[] arrf, AffineTransform affineTransform) {
        arrf[0] = (float)this.a;
        arrf[1] = (float)this.b;
        arrf[2] = (float)this.c;
        arrf[3] = (float)this.d;
        affineTransform.transform(arrf, 0, arrf, 0, 2);
        return 2;
    }

    @Override
    int a(double[] arrd, AffineTransform affineTransform) {
        arrd[0] = this.a;
        arrd[1] = this.b;
        arrd[2] = this.c;
        arrd[3] = this.d;
        affineTransform.transform(arrd, 0, arrd, 0, 2);
        return 2;
    }
}

