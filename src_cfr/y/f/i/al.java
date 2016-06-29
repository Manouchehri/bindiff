/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.C;
import y.c.D;
import y.c.q;
import y.f.i.aK;
import y.f.i.aM;
import y.f.i.aN;
import y.f.i.v;

class aL {
    private D a;
    private final aK b;

    public aL(aK aK2) {
        this.b = aK2;
        this.a = new D();
    }

    /*
     * Unable to fully structure code
     */
    public void a(q var1_1) {
        var4_2 = v.f;
        var2_3 = (aM)aK.b(this.b).b(var1_1);
        if (var2_3.a) {
            return;
        }
        var3_4 = false;
        do lbl-1000: // 3 sources:
        {
            if (var3_4 != false) return;
            var1_1 = (q)var2_3.b();
            if (var1_1 == null) break;
            var2_3 = (aM)aK.b(this.b).b(var1_1);
            if (aK.c(this.b).d(var1_1)) ** GOTO lbl-1000
            aK.a(this.b, this.a, aM.a(var2_3));
        } while (var4_2 == 0);
        var3_4 = true;
        if (var4_2 == 0) return;
    }

    /*
     * Unable to fully structure code
     */
    public boolean b(q var1_1) {
        var4_2 = v.f;
        var2_3 = (aM)aK.b(this.b).b(var1_1);
        if (!var2_3.a) {
            return false;
        }
        var3_4 = false;
        do lbl-1000: // 3 sources:
        {
            if (var3_4 != false) return this.a();
            var1_1 = (q)var2_3.b();
            if (var1_1 == null) break;
            var2_3 = (aM)aK.b(this.b).b(var1_1);
            if (aK.c(this.b).d(var1_1)) ** GOTO lbl-1000
            aK.b(this.b, this.a, aM.a(var2_3));
        } while (var4_2 == 0);
        var3_4 = true;
        if (var4_2 == 0) return this.a();
        return this.a();
    }

    private boolean a() {
        boolean bl2;
        int n2 = v.f;
        boolean bl3 = true;
        int n3 = 0;
        C c2 = this.a.m();
        c2.j();
        while (c2.f()) {
            bl2 = bl3;
            if (n2 != 0) return bl2;
            if (!bl2) break;
            aN aN2 = (aN)c2.d();
            if (aN2.c > 0 && aN2.b < (n3 += aN2.c)) {
                bl3 = false;
            }
            if (aN2.b < aN2.c) {
                bl3 = false;
            }
            c2.h();
            if (n2 == 0) continue;
        }
        bl2 = bl3;
        return bl2;
    }
}

