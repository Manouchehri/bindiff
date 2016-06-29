/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

import java.util.Comparator;
import y.g.a.d;
import y.g.a.l;

abstract class r {
    private Comparator c;
    protected l a;
    protected int b;

    public r(Comparator comparator) {
        this.c = comparator;
    }

    public void a() {
        this.a = null;
    }

    public boolean b() {
        if (this.a != null) return false;
        return true;
    }

    public Object c() {
        if (this.b()) return null;
        return this.h((l)this.a).d;
    }

    public boolean c(Object object) {
        if (this.d(object) == null) return false;
        return true;
    }

    protected int a(Object object, Object object2) {
        return this.c.compare(object, object2);
    }

    /*
     * Unable to fully structure code
     */
    protected l d(Object var1_1) {
        var3_2 = d.a;
        var2_3 = this.a;
        do lbl-1000: // 3 sources:
        {
            if (var2_3 == null) return var2_3;
            if (this.a(var1_1, var2_3.d) >= 0) ** GOTO lbl8
            var2_3 = var2_3.b;
            if (!var3_2) ** GOTO lbl-1000
lbl8: // 2 sources:
            if (this.a(var1_1, var2_3.d) <= 0) return var2_3;
            var2_3 = var2_3.c;
        } while (!var3_2);
        return var2_3;
    }

    protected static void a(l l2, l l3) {
        Object object = l2.d;
        l2.d = l3.d;
        l3.d = object;
    }

    protected l h(l l2) {
        l l3;
        boolean bl2 = d.a;
        while (l2.b != null) {
            l3 = l2.b;
            if (bl2) return l3;
            l2 = l3;
            if (!bl2) continue;
        }
        l3 = l2;
        return l3;
    }
}

