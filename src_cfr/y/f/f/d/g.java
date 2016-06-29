/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import java.util.ArrayList;
import y.c.A;
import y.c.C;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.x;
import y.f.f.b.h;
import y.f.f.d.D;
import y.f.f.d.H;
import y.f.f.d.a;
import y.f.f.d.o;
import y.f.f.d.v;
import y.f.h.N;
import y.f.h.p;
import y.f.h.q;
import y.f.h.r;
import y.g.al;

public class G
extends o {
    protected static final Integer q = new Integer(2);
    protected A r;
    protected c s;
    protected boolean t;
    private y.c.h u;
    private A v;
    private y.c.h w;
    private y.c.h x;

    public G() {
        this.s = new H(this);
    }

    public void b(y.c.h h2) {
        this.w = h2;
    }

    public void c(y.c.h h2) {
        this.x = h2;
    }

    public void a(c c2) {
        this.s = c2;
    }

    public void a(A a2) {
        this.r = a2;
    }

    public void b(boolean bl2) {
        this.t = bl2;
    }

    @Override
    public void a() {
        block2 : {
            this.a(false);
            this.v = this.a.t();
            if (this.w == null) {
                y.c.h h2 = this.a.u();
                this.a(h2);
                this.b.a(h2, this.a.p().a(), y.f.f.b.o.a);
                this.a.a(h2);
                if (!o.p) break block2;
            }
            this.a(this.w);
        }
        this.a.a(this.v);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected int a(i var1_1, y.c.h var2_2, ArrayList var3_3, y.c.q[] var4_4, A var5_5, ArrayList var6_6) {
        block71 : {
            block65 : {
                block61 : {
                    var40_7 = o.p;
                    this.f = this.a.u();
                    this.g = this.a.u();
                    this.c = this.a.u();
                    this.d = this.a.u();
                    this.e = this.a.u();
                    this.u = this.a.u();
                    var7_8 = this.a.u();
                    var8_9 = this.b.g();
                    this.i = var1_1.u();
                    this.h = var1_1.u();
                    var9_10 = var1_1.d();
                    var5_5.a((Object)var9_10, "S");
                    var10_11 = var1_1.d();
                    var5_5.a((Object)var10_11, "T");
                    var4_4[0] = var9_10;
                    var4_4[1] = var10_11;
                    var11_12 = 0;
                    var12_13 = this.a.u();
                    if (this.x == null) ** GOTO lbl49
                    var13_14 = this.a.p();
                    while (var13_14.f()) {
                        v0 = var13_14.a();
                        block1 : do {
                            var14_16 = v0;
                            v1 = this;
                            if (var40_7) break block61;
                            if (!v1.x.d(var14_16)) break;
                            var15_17 = (y.c.D)this.r.b(var14_16.d());
                            var16_18 = this.b.a((d)var14_16);
                            var17_21 = var15_17.m();
                            while (var17_21.f()) {
                                var18_22 = (D)var17_21.d();
                                v0 = var18_22.c().a();
                                if (var40_7) continue block1;
                                if (v0 != var16_18) ** GOTO lbl45
                                if (var18_22.b() != 0) ** GOTO lbl41
                                var12_13.a(var14_16, 1);
                                if (!var40_7) ** GOTO lbl45
                                v2 = i.g = i.g == false;
lbl41: // 2 sources:
                                if (var18_22.b() != 2) ** GOTO lbl-1000
                                var12_13.a(var14_16, 2);
                                if (var40_7) lbl-1000: // 2 sources:
                                {
                                    var12_13.a(var14_16, 0);
                                }
lbl45: // 5 sources:
                                var17_21.g();
                                if (!var40_7) continue;
                            }
                            break block1;
                            break;
                        } while (true);
                        var13_14.g();
                        if (!var40_7) continue;
                    }
lbl49: // 3 sources:
                    v1 = this;
                }
                var13_14 = v1.a.o();
                while (var13_14.f()) {
                    var14_16 = var13_14.e();
                    v3 = this.b.g((y.c.q)var14_16);
                    if (!var40_7) {
                        block63 : {
                            if (v3) {
                                var15_17 = null;
                                var16_18 = null;
                                var17_21 = (y.c.D)this.r.b(var14_16);
                                var18_22 = var17_21.m();
                                while (var18_22.f()) {
                                    var19_23 = (D)var18_22.d();
                                    v4 = var19_23.b();
                                    if (!var40_7) {
                                        if (v4 == 0) {
                                            var20_30 = var19_23.c();
                                            var16_18 = var20_30.a();
                                            var20_30.j();
                                            var15_17 = var20_30.a();
                                        }
                                        var18_22.g();
                                        if (!var40_7) continue;
                                    }
                                    break block62;
                                }
                                if (var15_17 == null) {
                                    var18_22 = new y.c.q[2];
                                    var19_24 = 0;
                                    var20_30 = var14_16.l();
                                    while (var20_30.f()) {
                                        var21_32 = var20_30.a();
                                        var18_22[var19_24] = var1_1.d();
                                        var22_33 = var1_1.a(var9_10, (y.c.q)var18_22[var19_24]);
                                        var2_2.a((Object)var22_33, G.k);
                                        var3_3.add(new a(var22_33, 1));
                                        ++var11_12;
                                        var7_8.a(var21_32, var18_22[var19_24]);
                                        ++var19_24;
                                        var20_30.g();
                                        if (!var40_7) {
                                            continue;
                                        }
                                        break block63;
                                    }
                                } else {
                                    block64 : {
                                        block62 : {
                                            v4 = 2;
                                        }
                                        var18_22 = new y.c.q[v4];
                                        var19_23 = var15_17;
                                        for (var20_31 = 0; var20_31 < 2; ++var20_31) {
                                            var18_22[var20_31] = var1_1.d();
                                            var7_8.a(var19_23, var18_22[var20_31]);
                                            v5 = var19_23;
                                            if (!var40_7) {
                                                if (v5 == var16_18) {
                                                    var21_32 = var1_1.a(var9_10, (y.c.q)var18_22[var20_31]);
                                                    var2_2.a(var21_32, G.k);
                                                    var3_3.add(new a((d)var21_32, 2));
                                                    var11_12 += 2;
                                                }
                                                var19_23 = this.b.b().j((d)var19_23);
                                                if (!var40_7) continue;
                                            }
                                            break block64;
                                        }
                                        v5 = var1_1.a((y.c.q)var18_22[1], (y.c.q)var18_22[0]);
                                    }
                                    var20_30 = v5;
                                    var3_3.add(new a((d)var20_30, 1));
                                    this.v.a(var14_16, var16_18);
                                }
                            }
                            var13_14.g();
                        }
                        if (!var40_7) continue;
                    }
                    ** GOTO lbl120
                }
                var13_14 = this.a.o();
                do {
                    block66 : {
                        block67 : {
                            v3 = var13_14.f();
lbl120: // 2 sources:
                            if (!v3) break;
                            v6 = var13_14.e();
                            block8 : do {
                                var14_16 = v6;
                                v7 = this.b.g((y.c.q)var14_16);
                                if (var40_7) break block65;
                                if (v7 != 0) break block66;
                                var15_17 = var1_1.d();
                                var5_5.a(var15_17, new StringBuffer().append("V(").append(var14_16).append(")").toString());
                                var16_19 = 4 - var14_16.b();
                                if (this.r == null) ** GOTO lbl168
                                var17_21 = (y.c.D)this.r.b(var14_16);
                                var18_22 = var17_21.m();
                                while (var18_22.f()) {
                                    block68 : {
                                        var19_25 = (D)var18_22.d();
                                        var20_30 = var1_1.d();
                                        var21_32 = var1_1.a((y.c.q)var20_30, (y.c.q)var15_17);
                                        var2_2.a(var21_32, var19_25.a());
                                        var3_3.add(new a((d)var21_32, var14_16.b()));
                                        var22_35 = var1_1.a((y.c.q)var15_17, (y.c.q)var20_30);
                                        var2_2.a((Object)var22_35, var19_25.a());
                                        var3_3.add(new a(var22_35, 3));
                                        var23_45 = var19_25.b() - var19_25.d();
                                        var16_19 -= var23_45;
                                        v8 = var23_45;
                                        if (var40_7) break block67;
                                        if (v8 <= 0) ** GOTO lbl-1000
                                        var24_49 = var1_1.a(var9_10, (y.c.q)var20_30);
                                        var2_2.a(var24_49, G.k);
                                        var3_3.add(new a((d)var24_49, var23_45));
                                        var11_12 += var23_45;
                                        if (var40_7) lbl-1000: // 2 sources:
                                        {
                                            if (var23_45 < 0) {
                                                var24_49 = var1_1.a((y.c.q)var20_30, var10_11);
                                                var2_2.a(var24_49, G.k);
                                                var3_3.add(new a((d)var24_49, - var23_45));
                                            }
                                        }
                                        var24_49 = var19_25.c();
                                        var24_49.g();
                                        while (var24_49.f()) {
                                            var25_50 = var24_49.a();
                                            var7_8.a(var25_50, var20_30);
                                            var24_49.g();
                                            if (!var40_7) {
                                                if (!var40_7) continue;
                                            }
                                            break block68;
                                        }
                                        var18_22.g();
                                    }
                                    if (!var40_7) continue;
                                }
lbl168: // 3 sources:
                                var17_21 = var14_16.l();
                                while (var17_21.f()) {
                                    var18_22 = var17_21.a();
                                    v6 = var19_26 = (y.c.q)var7_8.b(var18_22);
                                    if (var40_7) continue block8;
                                    if (v6 == null) {
                                        var7_8.a(var18_22, var15_17);
                                    }
                                    var17_21.g();
                                    if (!var40_7) continue;
                                }
                                break block8;
                                break;
                            } while (true);
                            if (var16_19 > 0) {
                                var17_21 = var1_1.a(var9_10, (y.c.q)var15_17);
                                var2_2.a(var17_21, G.k);
                                var3_3.add(new a((d)var17_21, var16_19));
                                var11_12 += var16_19;
                            }
                            v8 = var16_19;
                        }
                        if (v8 < 0) {
                            var17_21 = var1_1.a((y.c.q)var15_17, var10_11);
                            var2_2.a(var17_21, G.k);
                            var3_3.add(new a((d)var17_21, - var16_19));
                        }
                    }
                    var13_14.g();
                } while (!var40_7);
                v7 = 0;
            }
            var13_15 = v7;
            var14_16 = this.b.c();
            while (var14_16.f()) {
                var15_17 = var14_16.a();
                var16_18 = var1_1.d();
                var5_5.a(var16_18, new StringBuffer().append("F(").append(var13_15++).append(")").toString());
                v9 = var15_17.a().k();
                if (!var40_7) {
                    if (v9 < 4 && this.b.d() != var15_17) {
                        var17_21 = var1_1.a(var9_10, (y.c.q)var16_18);
                        var2_2.a(var17_21, G.k);
                        var3_3.add(new a((d)var17_21, 4 - var15_17.a().k()));
                        var11_12 += 4 - var15_17.a().k();
                    }
                    if (var15_17.a().k() > 4 && this.b.d() != var15_17) {
                        var17_21 = var1_1.a((y.c.q)var16_18, var10_11);
                        var2_2.a(var17_21, G.k);
                        var3_3.add(new a((d)var17_21, var15_17.a().k() - 4));
                    }
                    if (this.b.d() == var15_17) {
                        var17_21 = var1_1.a((y.c.q)var16_18, var10_11);
                        var2_2.a(var17_21, G.k);
                        var3_3.add(new a((d)var17_21, var15_17.a().k() + 4));
                    }
                    var8_9.a((p)var15_17, var16_18);
                    var14_16.g();
                    if (!var40_7) continue;
                }
                ** GOTO lbl221
            }
            var14_16 = this.b.c();
            block13 : do {
                v9 = var14_16.f();
lbl221: // 3 sources:
                block14 : while (v9 != 0) {
                    var15_17 = var14_16.a();
                    var16_18 = (y.c.q)var8_9.b(var15_17);
                    var17_21 = var15_17.a();
                    while (var17_21.f()) {
                        block69 : {
                            var18_22 = var17_21.a();
                            var19_27 = this.b.b(this.b.a((d)var18_22));
                            var20_30 = (y.c.q)var8_9.b(var19_27);
                            var21_32 = var1_1.a((y.c.q)var16_18, (y.c.q)var20_30);
                            var2_2.a(var21_32, new Integer(this.s.a(var18_22)));
                            this.c.a(var18_22, var21_32);
                            var3_3.add(new a((d)var21_32, Integer.MAX_VALUE));
                            var22_37 = (y.c.q)var7_8.b(var18_22);
                            var23_46 = var1_1.a(var22_37, (y.c.q)var16_18);
                            var2_2.a((Object)var23_46, G.k);
                            v9 = (int)this.b.b(var18_22.c()) ? 1 : 0;
                            if (var40_7) continue block14;
                            if (v9 != 0) {
                                var3_3.add(new a(var23_46, 0));
                                if (!var40_7) break block69;
                            }
                            var3_3.add(new a(var23_46, 3));
                        }
                        this.f.a(var18_22, var23_46);
                        var17_21.g();
                        if (!var40_7) continue;
                    }
                    var14_16.g();
                    if (!var40_7) continue block13;
                }
                break block13;
                break;
            } while (true);
            var14_16 = this.a.u();
            var15_17 = new ArrayList<E>();
            var16_18 = this.a.o();
            while (var16_18.f()) {
                block70 : {
                    var17_21 = var16_18.e();
                    v10 = this.a((y.c.q)var17_21);
                    if (var40_7) ** GOTO lbl354
                    if (v10 != 0 || this.n && var17_21.b() <= 4) ** GOTO lbl349
                    var18_22 = var17_21.l();
                    while (var18_22.f()) {
                        var19_28 = var18_22.a();
                        var20_30 = var1_1.d();
                        var21_32 = (y.c.q)var7_8.b(var19_28);
                        var5_5.a(var20_30, new StringBuffer().append("H(").append(var17_21.d()).append(",").append(var5_5.b(var8_9.b(this.b.b(var19_28)))).append(")").toString());
                        var14_16.a((Object)var19_28, var20_30);
                        var22_40 = var1_1.a((y.c.q)var20_30, (y.c.q)var21_32);
                        var2_2.a((Object)var22_40, G.k);
                        var3_3.add(new a(var22_40, 1));
                        this.g.a((Object)var19_28, var22_40);
                        var18_22.g();
                        if (!var40_7) {
                            if (!var40_7) continue;
                        }
                        break block70;
                    }
                    var18_22.i();
                    var19_28 = var18_22.a();
                }
                var20_30 = null;
                var21_32 = null;
                var22_41 = null;
                var23_47 = null;
                var24_49 = null;
                var25_50 = new ArrayList<E>();
                for (var26_51 = 0; var26_51 < var17_21.c(); ++var26_51) {
                    var18_22.b();
                    var20_30 = var19_28;
                    var19_28 = var18_22.a();
                    var27_52 = this.b.b(var19_28);
                    var28_53 = this.b.b((d)var20_30);
                    var29_54 = var1_1.d();
                    var30_55 = var1_1.d();
                    var15_17.add(var29_54);
                    var15_17.add(var30_55);
                    var5_5.a((Object)var29_54, new StringBuffer().append("NC-L (").append(var20_30.d()).append(",").append(var17_21).append(")").toString());
                    var5_5.a((Object)var30_55, new StringBuffer().append("NC-R (").append(var20_30.d()).append(",").append(var17_21).append(")").toString());
                    var31_56 = this.s.a(var20_30);
                    var32_57 = var1_1.a((y.c.q)var8_9.b(var27_52), var29_54);
                    var2_2.a((Object)var32_57, var31_56);
                    var3_3.add(new a(var32_57, 1));
                    this.e.a(var20_30, var32_57);
                    var33_58 = var1_1.a((y.c.q)var8_9.b(var28_53), var30_55);
                    var2_2.a((Object)var33_58, var31_56);
                    var3_3.add(new a(var33_58, 1));
                    this.d.a(var20_30, var33_58);
                    var34_59 = var1_1.a(var29_54, (y.c.q)var14_16.b(var20_30));
                    var2_2.a((Object)var34_59, G.k);
                    var35_60 = var1_1.a(var30_55, (y.c.q)var14_16.b(var19_28));
                    var2_2.a((Object)var34_59, G.k);
                    v11 = var21_32;
                    if (!var40_7) {
                        if (v11 != null) {
                            this.h.a((Object)var34_59, var21_32);
                            this.i.a(var21_32, var34_59);
                        }
                        if (var22_42 != null) {
                            this.i.a((Object)var35_60, var22_42);
                            this.h.a((Object)var22_42, var35_60);
                        }
                        var22_43 = var35_60;
                        var21_32 = var34_59;
                        if (var24_49 == null) {
                            var24_49 = var22_43;
                        }
                        if (var23_47 == null) {
                            var23_47 = var21_32;
                        }
                        var36_61 = new a(1);
                        var36_61.a(var35_60);
                        var36_61.a(var34_59);
                        var3_3.add(var36_61);
                        var25_50.add(var36_61);
                        if (this.x == null || !this.x.d(var20_30) || !this.b.g(var20_30.d())) continue;
                        var37_62 = null;
                        if (var12_13.a(var20_30) == 2) {
                            var37_62 = var29_54;
                        } else if (var12_13.a(var20_30) == 1) {
                            var37_62 = var30_55;
                        } else {
                            if (var12_13.a(var20_30) != 0) throw new RuntimeException(new StringBuffer().append("Cannot assign kandinsky bend !!!!! ").append(var20_30).toString());
                            var37_62 = null;
                            if (!var40_7) continue;
                            throw new RuntimeException(new StringBuffer().append("Cannot assign kandinsky bend !!!!! ").append(var20_30).toString());
                        }
                        if (var37_62 == null || var20_30 == null || this.v.b(var20_30.d()) == null) continue;
                        var38_63 = (y.c.q)var7_8.b(this.b.b().j((d)this.v.b(var20_30.d())));
                        var39_64 = var1_1.a(var38_63, var37_62);
                        var2_2.a((Object)var39_64, var31_56);
                        var3_3.add(new a(var39_64, 1));
                        this.u.a(var20_30, var39_64);
                        if (!var40_7) continue;
                    }
                    ** GOTO lbl360
                }
                var6_6.add(var25_50);
                this.h.a(var23_47, var21_32);
                this.i.a(var21_32, var23_47);
                this.i.a(var24_49, var22_42);
                this.h.a((Object)var22_42, var24_49);
lbl349: // 2 sources:
                var16_18.g();
                if (!var40_7) continue;
            }
            var16_18 = this.a.o();
            block19 : do {
                v10 = var16_18.f();
lbl354: // 3 sources:
                block20 : while (v10 != 0) {
                    var17_21 = var16_18.e();
                    v12 = (int)this.b.g((y.c.q)var17_21) ? 1 : 0;
                    if (var40_7) break block71;
                    if (v12 != 0) {
                        v11 = this.r.b(var17_21);
lbl360: // 2 sources:
                        block21 : do {
                            var18_22 = (y.c.D)v11;
                            var19_29 = 1073741823;
                            var20_30 = var18_22.m();
                            while (var20_30.f()) {
                                var21_32 = (D)var20_30.d();
                                var22_44 = var21_32.a();
                                var23_48 = var21_32.c();
                                var23_48.g();
                                var24_49 = (d)this.f.b(var23_48.a());
                                var2_2.a(var24_49, var22_44);
                                v10 = var21_32.b();
                                if (var40_7) continue block20;
                                if (v10 == 2) {
                                    var19_29 = var22_44;
                                }
                                var20_30.g();
                                if (!var40_7) continue;
                            }
                            var20_30 = var17_21.l();
                            while (var20_30.f()) {
                                v11 = var21_32 = (d)this.u.b(this.b.a(var20_30.a()));
                                if (var40_7) continue block21;
                                if (v11 != null) {
                                    var2_2.a(var21_32, var19_29);
                                }
                                var20_30.g();
                                if (!var40_7) continue;
                            }
                            break block21;
                            break;
                        } while (true);
                    }
                    var16_18.g();
                    if (!var40_7) continue block19;
                }
                break block19;
                break;
            } while (true);
            v12 = var16_20 = 0;
        }
        while (var16_20 < var15_17.size()) {
            var17_21 = (y.c.q)var15_17.get(var16_20);
            v13 = var17_21.b();
            if (var40_7 != false) return v13;
            if (v13 <= 1 && var17_21.c() <= 1 && var2_2.a(var17_21.g()) > 0 && var2_2.a(var17_21.f()) == 0) {
                var2_2.a((Object)var17_21.f(), var2_2.a(var17_21.g()));
                var2_2.a((Object)var17_21.g(), 0);
            }
            ++var16_20;
            if (!var40_7) continue;
        }
        this.a.a((y.c.h)var14_16);
        this.a.a(var7_8);
        this.a.a(var12_13);
        v13 = var11_12;
        return v13;
    }

    @Override
    protected double a(i i2, int n2, y.c.h h2, y.c.q[] arrq, ArrayList arrayList, ArrayList arrayList2, y.c.h h3, A a2) {
        y.c.h h4;
        double d2;
        block10 : {
            Object object;
            boolean bl2;
            int n3;
            d d3;
            C c2;
            Object object2;
            Object object3;
            G g2;
            Object object4;
            block9 : {
                G g3;
                bl2 = o.p;
                al al2 = new al();
                h4 = i2.u();
                d2 = -1.0;
                d2 = this.o.a(i2, arrq[0], arrq[1], h2, h4, n2, arrayList, arrayList2, this.h, this.i);
                al2.e();
                c2 = this.a.p();
                while (c2.f()) {
                    d3 = c2.a();
                    object4 = this.b.a(c2.a());
                    object = new StringBuffer();
                    object2 = this.e.b(d3);
                    g3 = this;
                    if (!bl2) {
                        object3 = g3.d.b(d3);
                        n3 = object2 == null ? 0 : h4.a(object2);
                        int n4 = object3 == null ? 0 : h4.a(object3);
                        G.a((StringBuffer)object, n4, '<');
                        G.a((StringBuffer)object, n3, '>');
                        int n5 = h4.a(this.c.b(d3));
                        int n6 = h4.a(this.c.b(object4));
                        G.a((StringBuffer)object, n6, '>');
                        G.a((StringBuffer)object, n5, '<');
                        object2 = this.e.b(object4);
                        object3 = this.d.b(object4);
                        int n7 = object2 == null ? 0 : h4.a(object2);
                        int n8 = object3 == null ? 0 : h4.a(object3);
                        G.a((StringBuffer)object, n7, '<');
                        G.a((StringBuffer)object, n8, '>');
                        this.j += object.length();
                        h3.a((Object)d3, object.toString());
                        int n9 = h4.a(this.f.b(d3));
                        int n10 = 0;
                        if (!this.a(d3.c())) {
                            n10 = h4.a(this.g.b(d3));
                        }
                        this.b.a(d3, n9 - n10 + 1);
                        c2.g();
                        if (!bl2) continue;
                    }
                    break block9;
                }
                g3 = this;
            }
            c2 = g3.a.o();
            block1 : do {
                boolean bl3 = c2.f();
                block2 : while (bl3) {
                    d3 = c2.e();
                    g2 = this;
                    if (bl2) break block10;
                    if (g2.b.g((y.c.q)((Object)d3))) {
                        object4 = d3.l();
                        while (object4.f()) {
                            object = this.b.a(object4.a());
                            bl3 = this.x.d(object);
                            if (bl2) continue block2;
                            if (bl3) {
                                object2 = (d)this.v.b(d3);
                                object3 = (d)this.u.b(object);
                                if (object3 != null && (n3 = h4.a(object3)) > 0) {
                                    this.b.a((d)object2, this.b.d((d)object2) + n3);
                                    d d4 = this.b.a((d)object);
                                    String string = (String)h3.b(object);
                                    String string2 = (String)h3.b(d4);
                                    e e2 = d3.a(d4);
                                    e2.b();
                                    d d5 = e2.a();
                                    d d6 = this.b.a(e2.a());
                                    String string3 = (String)h3.b(d5);
                                    String string4 = (String)h3.b(d6);
                                    h3.a((Object)d5, new StringBuffer().append(string).append(string3).toString());
                                    h3.a((Object)d6, new StringBuffer().append(string4).append(string2).toString());
                                    h3.a(object, "");
                                    h3.a((Object)d4, "");
                                }
                            }
                            object4.g();
                            if (!bl2) continue;
                        }
                    }
                    c2.g();
                    if (!bl2) continue block1;
                }
                break block1;
                break;
            } while (true);
            this.j /= 2;
            this.a.a(this.f);
            this.a.a(this.g);
            this.a.a(this.c);
            this.a.a(this.d);
            this.a.a(this.e);
            g2 = this;
        }
        g2.a.a(this.u);
        i2.a(h4);
        return d2;
    }

    private boolean a(y.c.q q2) {
        if (this.b.b(q2)) return true;
        if (this.b.g(q2)) return true;
        return false;
    }
}

