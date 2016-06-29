/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a;

import y.c.A;
import y.c.C;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.x;
import y.c.y;
import y.d.q;
import y.d.r;
import y.f.X;
import y.f.f.a.f;
import y.f.f.a.o;
import y.f.f.b.h;
import y.f.f.d.t;

public class n
extends t {
    /*
     * Unable to fully structure code
     */
    @Override
    public void a() {
        block14 : {
            var13_1 = f.a;
            var1_2 = this.c.c("y.layout.orthogonal.cluster.NodeSplitter.INSETS_KEY");
            if (var1_2 != null) {
                var2_3 = this.c.p();
                while (var2_3.f()) {
                    var3_4 = var2_3.a();
                    v0 = this;
                    if (!var13_1) {
                        if (!v0.b.c((d)var3_4)) {
                            var4_5 = r.a(var1_2.b(var3_4));
                            var5_6 = this.b.h((d)var3_4);
                            if (var4_5 != null) {
                                var6_7 = 0.0;
                                var8_9 = 0.0;
                                if (var5_6.a(y.f.f.b.o.a)) {
                                    var6_7 = var4_5.b;
                                }
                                if (var5_6.a(y.f.f.b.o.b)) {
                                    var6_7 = var4_5.a;
                                }
                                if (var5_6.a(y.f.f.b.o.c)) {
                                    var8_9 = var4_5.d;
                                }
                                if (var5_6.a(y.f.f.b.o.d)) {
                                    var8_9 = var4_5.c;
                                }
                                var8_9 = Math.ceil(var8_9 / (double)this.f);
                                var6_7 = Math.ceil(var6_7 / (double)this.f);
                                this.b.c((d)var3_4, (int)var8_9);
                                this.b.c(this.b.a((d)var3_4), (int)var8_9);
                                this.b.d((d)var3_4, (int)var6_7);
                                this.b.d(this.b.a((d)var3_4), (int)var6_7);
                            }
                        }
                        var2_3.g();
                        if (!var13_1) continue;
                    }
                    break;
                }
            } else {
                v0 = this;
            }
            var2_3 = v0.c.c(y.f.b.f.f);
            var3_4 = this.c.c("y.layout.orthogonal.cluster.NodeSplitter.BORDER_INFO_KEY");
            if (var2_3 == null || var3_4 == null) ** GOTO lbl69
            var4_5 = new y();
            var5_6 = this.c.t();
            var6_8 = this.c.p();
            while (var6_8.f()) {
                var7_13 = var6_8.a();
                var8_11 = (y.c.q)var3_4.b(var7_13);
                v1 = this;
                if (var13_1) break block14;
                if (v1.b.c(var7_13) || var8_11 == null) ** GOTO lbl52
                var9_16 = (y.c.f)var5_6.b(var8_11);
                if (var9_16 == null) ** GOTO lbl-1000
                var9_16.add(var7_13);
                if (var13_1) lbl-1000: // 2 sources:
                {
                    var9_16 = new y.c.f(var7_13);
                    var5_6.a((Object)var8_11, var9_16);
                    var4_5.add(var8_11);
                }
lbl52: // 4 sources:
                var6_8.g();
                if (!var13_1) continue;
            }
            var6_8 = var4_5.a();
            while (var6_8.f()) {
                var7_15 = var6_8.e();
                var8_12 = (y.c.f)var5_6.b(var7_15);
                var9_16 = (q)var2_3.b(var7_15);
                if (var13_1 != false) return;
                if (var9_16 != null) {
                    var10_17 = (int)Math.ceil(var9_16.a() / (double)this.f);
                    var11_18 = (int)Math.ceil(var9_16.b() / (double)this.f);
                    var12_19 = this.a(var8_12);
                    this.b.a(new y.f.f.b.n(var12_19.a, var12_19.c, var10_17, 1, y.f.f.b.o.b));
                    this.b.a(new y.f.f.b.n(var12_19.a, var12_19.c, var11_18, 1, y.f.f.b.o.c));
                }
                var6_8.g();
                if (!var13_1) continue;
            }
            this.c.a((A)var5_6);
lbl69: // 2 sources:
            v1 = this;
        }
        super.a();
    }

    /*
     * Unable to fully structure code
     */
    private o a(y.c.f var1_1) {
        var10_2 = f.a;
        var2_3 = new o();
        var3_4 = var1_1.a();
        do {
            block5 : {
                if (var3_4.f() == false) return var2_3;
                var4_5 = var3_4.a();
                var5_6 = var4_5.c();
                var6_7 = "";
                var7_8 = var5_6.l();
                while (var7_8.f()) {
                    var8_9 = var7_8.a();
                    var9_10 = this.b.h(var8_9);
                    var6_7 = new StringBuffer().append(var6_7).append(var9_10).toString();
                    var7_8.g();
                    if (!var10_2) {
                        if (!var10_2) continue;
                    }
                    break block5;
                }
                if (!var6_7.equals(">_") && !var6_7.equals("_>")) ** GOTO lbl22
                var2_3.a = var5_6;
            }
            if (!var10_2) ** GOTO lbl30
lbl22: // 2 sources:
            if (!var6_7.equals("<_") && !var6_7.equals("_<")) ** GOTO lbl25
            var2_3.b = var5_6;
            if (!var10_2) ** GOTO lbl30
lbl25: // 2 sources:
            if (!var6_7.equals(">^") && !var6_7.equals("^>")) ** GOTO lbl-1000
            var2_3.d = var5_6;
            if (var10_2) lbl-1000: // 2 sources:
            {
                if (var6_7.equals("<^") || var6_7.equals("^<")) {
                    var2_3.c = var5_6;
                }
            }
lbl30: // 7 sources:
            var3_4.g();
        } while (!var10_2);
        return var2_3;
    }
}

