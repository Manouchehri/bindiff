/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.q;
import y.g.e;

final class bX
implements Comparator {
    final float[] a;

    bX(float[] arrf) {
        this.a = arrf;
    }

    public int compare(Object object, Object object2) {
        return e.a(this.a[((q)object).d()], this.a[((q)object2).d()]);
    }
}

