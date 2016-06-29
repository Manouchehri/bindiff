/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import y.d.m;
import y.d.o;
import y.d.y;
import y.f.C;
import y.f.aj;
import y.f.am;
import y.f.d.u;

class z
implements o {
    Object a;
    Object b;
    byte c;
    int d;
    boolean e;
    private final u f;

    z(u u2, Object object, Object object2, byte by2, boolean bl2) {
        this.f = u2;
        this.d = 0;
        this.e = false;
        this.a = object;
        this.b = object2;
        this.c = by2;
        this.e = bl2;
    }

    public boolean a() {
        if (this.c == 2) return true;
        if (this.c == 3) return true;
        return false;
    }

    @Override
    public y h() {
        if (this.c == 1) {
            return ((m)this.a).h();
        }
        if (this.c == 3) {
            return u.a(this.f, (C)this.a, this.b);
        }
        if (this.c == 2) {
            return u.a(this.f, (aj)this.a, this.b);
        }
        am am2 = u.a(this.f).a(this.a);
        return new y(am2.getX(), am2.getY(), am2.getWidth(), am2.getHeight());
    }
}

