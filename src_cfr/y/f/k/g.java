/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import y.c.b;
import y.c.c;
import y.c.q;
import y.c.y;
import y.f.X;
import y.f.k.A;
import y.f.k.B;
import y.f.k.E;
import y.f.k.F;
import y.f.k.I;
import y.f.k.K;
import y.f.k.P;
import y.f.k.d;
import y.f.k.l;
import y.f.k.x;

class G
implements K {
    private x a;
    private final X b;
    private final q c;
    private double d;
    private y.c.A e;
    private final B f;

    G(B b2, x x2, X x3, q q2) {
        this.f = b2;
        this.a = x2;
        this.b = x3;
        this.c = q2;
    }

    @Override
    public void a(b b2, b b3, b b4) {
        if (this.b.c(B.h) == null) {
            this.e = this.b.t();
            this.b.a(B.h, this.e);
        }
        this.a((y.c.A)this.b.c(B.h), b2);
    }

    /*
     * Unable to fully structure code
     */
    E a(y.c.A var1_1, b var2_2) {
        var12_3 = d.g;
        var3_4 = new E(this.f, this.b);
        var3_4.a(this.d);
        var4_5 = new y();
        var4_5.add(this.c);
        block0 : do lbl-1000: // 3 sources:
        {
            if (var4_5.size() <= 0) return var3_4;
            var5_6 = var4_5.d();
            if (var5_6 != this.c && var5_6.g() != null) ** GOTO lbl-1000
            var6_7 = var3_4.a(0);
            if (var12_3 != 0) lbl-1000: // 2 sources:
            {
                var7_8 = var5_6.g().c();
                var8_9 = (F)var1_1.b(var7_8);
                var6_7 = var8_9.e();
            }
            var7_8 = this.a.f(var5_6);
            var8_9 = new P(this.f.c, (A)var7_8);
            var6_7.a(var5_6, (P)var8_9, this.f.c);
            var1_1.a((Object)var5_6, var6_7);
            var9_10 = (I)var2_2.b(var5_6);
            if (!(var9_10 instanceof B) || !this.f.c().equals(((B)var9_10).c())) ** GOTO lbl-1000
            var10_11 = var5_6.f();
            do {
                if (var10_11 == null) continue block0;
                var11_12 = var10_11.d();
                var4_5.add(var11_12);
                var10_11 = var10_11.g();
                if (var12_3 != 0) return var3_4;
            } while (var12_3 == 0);
            break;
        } while (true);
        return var3_4;
    }

    @Override
    public void a() {
        if (this.e == null) return;
        this.b.a(this.e);
        this.b.d_(B.h);
    }

    public void a(double d2) {
        this.d = d2;
    }
}

