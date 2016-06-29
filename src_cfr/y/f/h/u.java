/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import java.util.HashMap;
import y.f.h.p;
import y.f.h.r;

class U
implements r {
    private HashMap a = new HashMap();

    U() {
    }

    @Override
    public void a(p p2, Object object) {
        this.a.put(p2, object);
    }

    @Override
    public Object b(Object object) {
        return this.a.get(object);
    }

    @Override
    public void a(p p2, boolean bl2) {
        this.a.put(p2, bl2 ? Boolean.TRUE : Boolean.FALSE);
    }

    @Override
    public boolean d(Object object) {
        Object v2 = this.a.get(object);
        if (v2 != null) return (Boolean)v2;
        return false;
    }

    @Override
    public double c(Object object) {
        Object v2 = this.a.get(object);
        if (v2 != null) return (Double)v2;
        return 0.0;
    }

    @Override
    public void a(p p2, int n2) {
        this.a.put(p2, new Integer(n2));
    }

    @Override
    public int a(Object object) {
        Object v2 = this.a.get(object);
        if (v2 != null) return (Integer)v2;
        return 0;
    }

    public void a() {
        this.a.clear();
    }
}

