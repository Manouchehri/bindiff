/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.f.X;
import y.f.ah;
import y.f.i.K;

class M
implements ah {
    private final byte[] a;
    private final K b;

    M(K k2, byte[] arrby) {
        this.b = k2;
        this.a = arrby;
    }

    @Override
    public void c(X x2) {
        K.a(this.b, 3);
        K.a(this.b, x2, this.a);
    }
}

