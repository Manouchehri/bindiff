/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import y.d.b.u;
import y.d.b.z;

public abstract class c
implements u {
    public static int a;

    @Override
    public int a(Object object, Object object2) {
        return this.c(this.c(object), this.d(object), object2);
    }

    @Override
    public boolean a(Object object, Object object2, Object object3) {
        if (this.c(object, object2, object3) <= 0) return false;
        return true;
    }

    @Override
    public boolean b(Object object, Object object2, Object object3) {
        if (this.c(object, object2, object3) != 0) return false;
        return true;
    }

    @Override
    public boolean b(Object object, Object object2) {
        if (object2.equals(this.c(object))) {
            return false;
        }
        if (!object2.equals(this.d(object))) return this.e(object, object2);
        return false;
    }

    @Override
    public boolean a(Object object) {
        Object object2 = this.c(object);
        Object object3 = this.d(object);
        return object2.equals(object3);
    }

    @Override
    public z b(Object object) {
        Object object2 = this.c(object);
        Object object3 = this.d(object);
        z z2 = this.k(object2).b(this.k(object3));
        z z3 = this.l(object2).b(this.l(object3));
        return z2.c(z2).a(z3.c(z3));
    }
}

