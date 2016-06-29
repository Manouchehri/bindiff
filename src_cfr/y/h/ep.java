/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.PathIterator;
import y.h.eM;

final class eP
implements PathIterator {
    private eM a;
    private final int b;

    eP(eM eM2, int n2) {
        this.b = n2;
        this.a = eM2;
    }

    @Override
    public int currentSegment(float[] arrf) {
        return this.a.a(arrf);
    }

    @Override
    public int currentSegment(double[] arrd) {
        return this.a.a(arrd);
    }

    @Override
    public int getWindingRule() {
        return this.b;
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

