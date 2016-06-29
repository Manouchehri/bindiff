/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.f.c.a.Z;
import y.f.c.a.aM;
import y.f.c.a.aY;
import y.f.c.a.as;
import y.f.c.a.bK;

class aJ
extends aM
implements as {
    final byte d;
    final Z e;

    aJ(byte by2, aY aY2, bK bK2, Z z2) {
        super(aY2, bK2);
        this.d = by2;
        this.e = z2 == null ? Z.a : z2;
    }

    @Override
    public Z c() {
        return this.e;
    }

    @Override
    public byte b() {
        return this.d;
    }
}

