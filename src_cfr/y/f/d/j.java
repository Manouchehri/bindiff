/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import y.d.o;
import y.d.y;
import y.f.Q;

class j
implements o {
    private Q a;
    private Object b;
    private o c;
    private byte d;

    j(Object object, o o2, byte by2) {
        this.b = object;
        this.c = o2;
        this.d = by2;
        this.a = null;
    }

    j(Object object, Q q2, byte by2) {
        this.b = object;
        this.a = q2;
        this.c = q2.h();
        this.d = by2;
    }

    public Object a() {
        return this.b;
    }

    public o b() {
        return this.c;
    }

    public byte c() {
        return this.d;
    }

    public Q d() {
        return this.a;
    }

    @Override
    public y h() {
        return this.c.h();
    }
}

