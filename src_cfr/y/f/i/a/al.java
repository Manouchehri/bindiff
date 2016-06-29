/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.d.g;
import y.d.m;
import y.d.t;
import y.f.i.a.aI;
import y.f.i.a.aJ;
import y.f.i.a.aK;

class aL
implements g {
    private aK a = null;
    private boolean b = false;

    private aL() {
    }

    @Override
    public void a(Object object, Object object2) {
        aJ aJ2 = (aJ)object;
        aJ aJ3 = (aJ)object2;
        t t2 = m.a(aJ2, aJ3);
        if (t2 == null) return;
        int n2 = Math.abs(aJ3.a - aJ2.a);
        if (this.a != null) {
            this.b = true;
        }
        if (this.a != null) {
            if (n2 <= this.a.d) return;
        }
        this.a = new aK(aJ2, aJ3, t2, n2, null);
    }

    aL(aI aI2) {
        this();
    }

    static aK a(aL aL2) {
        return aL2.a;
    }

    static boolean b(aL aL2) {
        return aL2.b;
    }
}

