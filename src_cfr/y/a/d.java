/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import y.a.E;
import y.a.h;
import y.c.A;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.g.M;

class D {
    private int a;
    private A b;
    private int c;
    private boolean d;

    D() {
        this.a(0);
        this.b(10);
        this.a(false);
    }

    /*
     * Unable to fully structure code
     */
    private void b(i var1_1, y var2_2, y.c.h var3_3) {
        block6 : {
            var8_4 = h.a;
            var4_5 = new Random(1234);
            var5_6 = M.a(new boolean[var1_1.e()]);
            var6_7 = var2_2.a();
            while (var6_7.f()) {
                var5_6.a((Object)var6_7.e(), true);
                var6_7.g();
                if (!var8_4) {
                    if (!var8_4) continue;
                }
                break block6;
            }
            var6_7 = var2_2.a();
        }
        do {
            v0 = var6_7.f();
            block2 : do lbl-1000: // 3 sources:
            {
                if (v0 == false) return;
                for (var7_8 = var6_7.e().g(); var7_8 != null; var7_8 = var7_8.h()) {
                    v0 = var5_6.d(var7_8.c());
                    if (var8_4) ** GOTO lbl-1000
                    if (!v0) continue;
                    var3_3.a((Object)var7_8, var4_5.nextDouble());
                    if (!var8_4) continue;
                }
                for (var7_8 = var6_7.e().f(); var7_8 != null; var7_8 = var7_8.g()) {
                    v0 = var5_6.d(var7_8.d());
                    if (var8_4) continue block2;
                    if (!v0) continue;
                    var3_3.a((Object)var7_8, var4_5.nextDouble());
                    if (!var8_4) continue;
                }
                break;
            } while (true);
            var6_7.g();
        } while (!var8_4);
    }

    /*
     * Unable to fully structure code
     */
    private void c(i var1_1, y var2_2, y.c.h var3_3) {
        var17_4 = h.a;
        var4_5 = new E[var1_1.e()];
        this.a(var2_2, var3_3, 0.0);
        var5_6 = this.a(var2_2).a();
        block0 : do {
            v0 = var5_6.f();
            block1 : do {
                if (v0 == false) return;
                var6_7 = var5_6.e();
                if (!this.a(var6_7)) break;
                var7_8 = new y();
                var8_9 = var2_2.a();
                while (var8_9.f()) {
                    var9_10 = var8_9.e();
                    var4_5[var9_10.d()] = new E((q)var9_10);
                    var8_9.g();
                    if (var17_4) continue block0;
                    if (!var17_4) continue;
                }
                var8_9 = new y();
                var8_9.add(var6_7);
                var9_10 = var4_5[var6_7.d()];
                E.a((E)var9_10, 1.0);
                E.a((E)var9_10, 0);
                block3 : do {
                    v1 = var8_9.isEmpty();
                    block4 : while (!v1) {
                        var10_11 = var8_9.d();
                        var7_8.a(var10_11);
                        var11_12 = var4_5[var10_11.d()];
                        var12_13 = var10_11.j();
                        do {
                            if (!var12_13.f()) continue block3;
                            var13_14 = var12_13.a();
                            var14_15 = var13_14.a(var10_11);
                            v2 = this.a((q)var14_15);
                            if (var17_4) ** GOTO lbl51
                            if (var17_4) continue block4;
                            if (v2) {
                                var15_16 = var4_5[var14_15.d()];
                                if (E.a(var15_16) < 0) {
                                    E.a(var15_16, E.a(var11_12) + 1);
                                    if (this.a() != 2 || E.a(var15_16) <= this.b()) {
                                        var8_9.add(var15_16.a());
                                    }
                                }
                                if (E.a(var15_16) == E.a(var11_12) + 1) {
                                    E.b(var15_16, E.b(var11_12));
                                    E.c(var15_16).add(var13_14);
                                }
                            }
                            var12_13.g();
                        } while (!var17_4);
                    }
                    break block3;
                    break;
                } while (true);
                block6 : do {
                    v2 = var7_8.isEmpty();
lbl51: // 3 sources:
                    block7 : while (!v2) {
                        var10_11 = var7_8.d();
                        var11_12 = var4_5[var10_11.d()];
                        var12_13 = E.c(var11_12).a();
                        do {
                            if (!var12_13.f()) continue block6;
                            var13_14 = var12_13.a();
                            var14_15 = var4_5[var13_14.a(var10_11).d()];
                            v0 = this.c();
                            if (var17_4) continue block1;
                            if (var17_4) continue block7;
                            if (!v0) ** GOTO lbl-1000
                            var15_17 = E.d(var11_12) + 1.0;
                            E.c((E)var14_15, var15_17);
                            var3_3.a((Object)var13_14, var3_3.c(var13_14) + var15_17 * E.b((E)var14_15));
                            if (var17_4) lbl-1000: // 2 sources:
                            {
                                var15_17 = E.b(var11_12) > 0.0 ? (E.d(var11_12) + 1.0) * E.b((E)var14_15) / E.b(var11_12) : 0.0;
                                E.c((E)var14_15, var15_17);
                                var3_3.a((Object)var13_14, var3_3.c(var13_14) + var15_17);
                            }
                            var12_13.g();
                        } while (!var17_4);
                    }
                    break block1;
                    break;
                } while (true);
                break;
            } while (true);
            var5_6.g();
        } while (!var17_4);
    }

    protected boolean a(q q2) {
        if (this.b == null) return true;
        if (this.b.a(q2) > 0) return true;
        return false;
    }

    protected y a(y y2) {
        y y3;
        boolean bl2 = h.a;
        if (this.a() != 1) return y2;
        Random random = new Random(1234);
        y y4 = new y();
        ArrayList arrayList = new ArrayList(y2);
        int n2 = Math.min(y2.size(), (int)Math.round(Math.log(y2.size()) / Math.log(2.0) * 10.0));
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = random.nextInt(arrayList.size());
            y3 = y4;
            if (bl2) return y3;
            y3.add(arrayList.get(n3));
            if (n3 == arrayList.size() - 1) {
                arrayList.remove(arrayList.size() - 1);
                if (!bl2) continue;
            }
            arrayList.set(n3, arrayList.remove(arrayList.size() - 1));
            if (!bl2) continue;
        }
        y3 = y4;
        return y3;
    }

    void a(i i2, y y2, y.c.h h2) {
        if (i2.h() == 0) return;
        if (y2.isEmpty()) {
            return;
        }
        if (this.a() == 3) {
            this.b(i2, y2, h2);
            if (!h.a) return;
        }
        this.c(i2, y2, h2);
    }

    void a(i i2, y y2, A a2, y.c.h h2) {
        if (i2.g() == 0) return;
        if (y2.isEmpty()) {
            return;
        }
        this.b = a2;
        this.a(i2, y2, h2);
        this.b = null;
    }

    /*
     * Unable to fully structure code
     */
    void a(int var1_1) {
        var2_2 = h.a;
        this.c = var1_1;
        switch (var1_1) {
            default: {
                if (var2_2 == false) return;
            }
            case 1: {
                if (var2_2 == false) return;
            }
            case 2: {
                ** break;
            }
lbl10: // 2 sources:
            case 3: 
        }
    }

    int a() {
        return this.c;
    }

    int b() {
        return this.a;
    }

    void b(int n2) {
        if (n2 <= 1) throw new IllegalArgumentException("Maximum path length must be greater than 1.");
        this.a = n2;
        if (!h.a) return;
        throw new IllegalArgumentException("Maximum path length must be greater than 1.");
    }

    boolean c() {
        return this.d;
    }

    void a(boolean bl2) {
        this.d = bl2;
    }

    /*
     * Unable to fully structure code
     */
    protected void a(y var1_1, y.c.h var2_2, double var3_3) {
        var8_4 = h.a;
        var5_5 = var1_1.a();
        do {
            v0 = var5_5.f();
            block1 : do lbl-1000: // 3 sources:
            {
                if (v0 == false) return;
                var6_6 = var5_5.e();
                if (!this.a(var6_6)) break;
                for (var7_7 = var6_6.f(); var7_7 != null; var7_7 = var7_7.g()) {
                    v0 = this.a(var7_7.a(var6_6));
                    if (var8_4) ** GOTO lbl-1000
                    if (!v0) continue;
                    var2_2.a((Object)var7_7, var3_3);
                    if (!var8_4) continue;
                }
                for (var7_7 = var6_6.g(); var7_7 != null; var7_7 = var7_7.h()) {
                    v0 = this.a(var7_7.a(var6_6));
                    if (var8_4) continue block1;
                    if (!v0) continue;
                    var2_2.a((Object)var7_7, var3_3);
                    if (!var8_4) continue;
                }
                break;
            } while (true);
            var5_5.g();
        } while (!var8_4);
    }
}

