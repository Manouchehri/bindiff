/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import y.d.o;
import y.d.y;
import y.f.a.C;
import y.f.a.z;

class B
implements o {
    private Object a;
    private o b;
    private byte c;
    private int d;
    private y e;
    private boolean f;
    private C g;
    private final z h;

    public B(z z2, Object object, int n2, o o2, y y2, byte by2) {
        this.h = z2;
        this.e = null;
        this.g = null;
        this.d = n2;
        this.a = object;
        this.b = o2;
        this.c = by2;
        if (by2 == 1) return;
        this.e = y2;
    }

    public B(z z2, Object object, int n2, o o2, byte by2) {
        this.h = z2;
        this.e = null;
        this.g = null;
        this.d = n2;
        this.a = object;
        this.b = o2;
        this.c = by2;
    }

    public B(z z2, Object object, int n2, o o2, byte by2, C c2) {
        this.h = z2;
        this.e = null;
        this.g = null;
        this.d = n2;
        this.a = object;
        this.b = o2;
        this.c = by2;
        if (by2 != 1) return;
        this.g = c2;
    }

    public boolean a() {
        if (this.g == null) return false;
        return true;
    }

    public C b() {
        return this.g;
    }

    public void a(boolean bl2) {
        this.f = bl2;
    }

    public boolean c() {
        return this.f;
    }

    public void a(y y2) {
        this.e = y2;
    }

    public void a(o o2) {
        this.b = o2;
    }

    public y d() {
        return this.e;
    }

    public boolean e() {
        if (this.c != 0) return false;
        return true;
    }

    public boolean f() {
        if (this.c != 1) return false;
        return true;
    }

    public boolean g() {
        if (this.c != 2) return false;
        return true;
    }

    public Object i() {
        return this.a;
    }

    public o j() {
        return this.b;
    }

    @Override
    public y h() {
        return this.b.h();
    }

    public boolean equals(Object object) {
        if (!(object instanceof B)) return false;
        B b2 = (B)object;
        if (b2.d != this.d) return false;
        return true;
    }

    public int hashCode() {
        return this.d;
    }

    static int a(B b2) {
        return b2.d;
    }
}

