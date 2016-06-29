/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import y.c.D;
import y.c.H;
import y.c.I;
import y.c.M;

class L {
    private I a;
    private I b;
    private int c;

    L() {
    }

    public int a() {
        return this.c;
    }

    boolean b() {
        if (this.c != 0) return false;
        return true;
    }

    I c() {
        return this.a;
    }

    I a(I i2) {
        return i2.q();
    }

    public void b(I i2) {
        ++this.c;
        i2.b(this.b);
        i2.a(null);
        if (this.b != null) {
            this.b.a(i2);
            this.b = i2;
            if (!D.e) return;
        }
        this.b = this.a = i2;
    }

    /*
     * Unable to fully structure code
     */
    void a(I var1_1, I var2_2, int var3_3) {
        block6 : {
            var5_4 = D.e;
            if (var2_2 == null) {
                this.b(var1_1);
                return;
            }
            if (var3_3 != 1) ** GOTO lbl-1000
            var4_5 = var2_2.r();
            if (var4_5 != null) {
                var4_5.a(var1_1);
                if (!var5_4) break block6;
            }
            this.a = var1_1;
        }
        var1_1.b(var4_5);
        var1_1.a(var2_2);
        var2_2.b(var1_1);
        if (var5_4) lbl-1000: // 2 sources:
        {
            block7 : {
                if ((var4_5 = var2_2.q()) != null) {
                    var4_5.b(var1_1);
                    if (!var5_4) break block7;
                }
                this.b = var1_1;
            }
            var1_1.a(var4_5);
            var1_1.b(var2_2);
            var2_2.a(var1_1);
        }
        ++this.c;
    }

    void c(I i2) {
        I i3;
        I i4;
        boolean bl2;
        block3 : {
            bl2 = D.e;
            i3 = i2.q();
            i4 = i2.r();
            --this.c;
            if (i3 != null) {
                i3.b(i4);
                if (!bl2) break block3;
            }
            this.b = i4;
        }
        if (i4 != null) {
            i4.a(i3);
            if (!bl2) return;
        }
        this.a = i3;
    }

    I d() {
        return this.a;
    }

    void e() {
        this.a = null;
        this.b = null;
        this.c = 0;
    }

    H f() {
        return new M(this);
    }

    static I a(L l2) {
        return l2.a;
    }

    static I b(L l2) {
        return l2.b;
    }

    static int c(L l2) {
        return l2.c;
    }
}

