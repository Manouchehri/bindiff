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

class G
implements Iterator {
    private final C a;
    private final D b;

    /*
     * Unable to fully structure code
     */
    G(f var1_1, X var2_2) {
        var10_3 = ab.a;
        super();
        this.b = new D();
        var3_4 = var2_2.c(y.a);
        var4_5 = new HashMap<Object, f>();
        var5_6 = var1_1.a();
        while (var5_6.f()) {
            var6_7 = var5_6.a();
            if (var10_3 != 0) return;
            v0 = var7_8 = var3_4 == null ? null : var3_4.b(var6_7);
            if (var7_8 != null) ** GOTO lbl14
            this.b.add(new f(var6_7));
            if (var10_3 == 0) ** GOTO lbl20
lbl14: // 2 sources:
            if ((var8_9 = (f)var4_5.get(var7_8)) != null) ** GOTO lbl-1000
            var9_10 = new f(var6_7);
            var4_5.put(var7_8, var9_10);
            this.b.add(var9_10);
            if (var10_3 != 0) lbl-1000: // 2 sources:
            {
                var8_9.add(var6_7);
            }
lbl20: // 4 sources:
            var5_6.g();
            if (var10_3 == 0) continue;
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

