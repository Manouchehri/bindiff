/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.HashMap;
import java.util.Iterator;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.f.X;
import y.f.i.a.ab;
import y.f.i.a.y;

class F
implements Iterator {
    private final C a;
    private final D b;

    /*
     * Unable to fully structure code
     */
    F(X var1_1) {
        var9_2 = ab.a;
        super();
        this.b = new D();
        var2_3 = var1_1.c(y.a);
        var3_4 = new HashMap<Object, f>();
        var4_5 = var1_1.p();
        while (var4_5.f()) {
            var5_6 = var4_5.a();
            if (var9_2 != 0) return;
            v0 = var6_7 = var2_3 == null ? null : var2_3.b(var5_6);
            if (var6_7 != null) ** GOTO lbl14
            this.b.add(new f(var5_6));
            if (var9_2 == 0) ** GOTO lbl20
lbl14: // 2 sources:
            if ((var7_8 = (f)var3_4.get(var6_7)) != null) ** GOTO lbl-1000
            var8_9 = new f(var5_6);
            var3_4.put(var6_7, var8_9);
            this.b.add(var8_9);
            if (var9_2 != 0) lbl-1000: // 2 sources:
            {
                var7_8.add(var5_6);
            }
lbl20: // 4 sources:
            var4_5.g();
            if (var9_2 == 0) continue;
        }
        this.a = this.b.m();
    }

    @Override
    public boolean hasNext() {
        return this.a.f();
    }

    public Object next() {
        if (!this.a.f()) {
            return null;
        }
        Object object = this.a.d();
        this.a.g();
        return object;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

