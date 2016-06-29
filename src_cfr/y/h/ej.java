/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import y.h.eM;

final class eJ
implements PathIterator {
    private eM a;
    private final AffineTransform b;
    private final int c;

    eJ(eM eM2, AffineTransform affineTransform, int n2) {
        this.a = eM2;
        this.b = affineTransform;
        this.c = n2;
    }

    @Override
    public int currentSegment(float[] arrf) {
        return this.a.a(arrf, this.b);
    }

    @Override
    public int currentSegment(double[] arrd) {
        return this.a.a(arrd, this.b);
    }

    @Override
    public int getWindingRule() {
        return this.c;
    }

    @Override
    public boolean isDone() {
        if (this.a != null) return false;
        return true;
    }

    @Override
    public void next() {
        this.a = this.a.g;
    }
}

