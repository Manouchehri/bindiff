/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.AffineTransform;
import y.h.eI;

abstract class eM
implements eI {
    eM g;
    eM h;

    eM() {
    }

    abstract int a(double[] var1, AffineTransform var2);

    abstract int a(float[] var1, AffineTransform var2);

    @Override
    public eI b() {
        return this.g;
    }
}

