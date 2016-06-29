/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.c.a;
import y.c.b;
import y.c.c;
import y.g.ap;

class aq
implements b {
    private final ap a;

    aq(ap ap2) {
        this.a = ap2;
    }

    @Override
    public Object b(Object object) {
        c c2 = ap.a(this.a);
        if (c2 == null) return ap.b(this.a).b(object);
        Object object2 = c2.b(object);
        if (object2 == null) return ap.b(this.a).b(object);
        return object2;
    }

    @Override
    public int a(Object object) {
        throw new IllegalStateException("Only get(Object) may be used");
    }

    @Override
    public double c(Object object) {
        throw new IllegalStateException("Only get(Object) may be used");
    }

    @Override
    public boolean d(Object object) {
        throw new IllegalStateException("Only get(Object) may be used");
    }

    @Override
    public void a(Object object, Object object2) {
        ((a)((Object)ap.b(this.a))).a(object, object2);
    }

    @Override
    public void a(Object object, int n2) {
        throw new IllegalStateException("Only set(Object) may be used");
    }

    @Override
    public void a(Object object, double d2) {
        throw new IllegalStateException("Only set(Object) may be used");
    }

    @Override
    public void a(Object object, boolean bl2) {
        throw new IllegalStateException("Only set(Object) may be used");
    }
}

