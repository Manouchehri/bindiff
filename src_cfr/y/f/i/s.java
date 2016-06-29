/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.c.D;
import y.c.p;
import y.d.c;
import y.f.i.T;
import y.f.i.U;
import y.f.i.V;
import y.f.i.v;
import y.g.e;

class S {
    private Map a = new HashMap(11);
    private List b = new ArrayList(62);
    private List c = new ArrayList(62);
    private double d;
    private double e = -1.7976931348623157E308;
    private double f = Double.MAX_VALUE;
    private double g = 10.0;
    private Map h = new HashMap();
    private List i = new ArrayList();
    private Map j = new HashMap();
    private Set k = new HashSet();
    private c l;
    private c m;
    private double n;
    private double o = 10.0;
    private boolean p = true;
    private double q = 1.0;
    private double r = 0.5;
    private double s;
    private double t;
    private Comparator u;
    private double v;
    private double w;
    private Comparator x;
    private U[] y;
    private U[] z;
    private D A;
    private D B;
    private double C;
    private double D;

    public void a(double d2) {
        this.v = d2;
    }

    public void b(double d2) {
        this.w = d2;
    }

    public void a(Comparator comparator) {
        this.u = comparator;
    }

    public void a() {
        this.s = 0.0;
        this.k.clear();
        this.j.clear();
        this.i.clear();
        this.h.clear();
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.t = 0.0;
        this.d = -1.0;
    }

    public void c(double d2) {
        this.n = d2;
    }

    public void a(c c2) {
        this.l = c2;
    }

    public void b(c c2) {
        this.m = c2;
    }

    public U a(Object object, double d2, double d3, double d4, boolean bl2, double d5, boolean bl3, boolean bl4) {
        U u2 = this.a(object, d2, d3, d4, bl2, d5, bl3);
        u2.a(bl4);
        return u2;
    }

    public U a(Object object, double d2, double d3, double d4, boolean bl2, double d5, boolean bl3) {
        U u2;
        block5 : {
            int n2;
            block4 : {
                n2 = v.f;
                if (d4 > d5) {
                    u2 = U.a(object, d2, d3, d5, bl3, d4, bl2);
                    if (n2 == 0) break block4;
                }
                u2 = U.a(object, d2, d3, d4, bl2, d5, bl3);
            }
            this.a.put(object, u2);
            if (U.a(u2) == 3) {
                this.b.add(u2);
                if (n2 == 0) break block5;
            }
            this.c.add(u2);
        }
        this.k.add(object);
        return u2;
    }

    public void b() {
        int n2;
        U u2;
        int n3;
        block4 : {
            n2 = v.f;
            if (this.h.size() > 0) {
                this.f();
            }
            this.y = new U[this.b.size()];
            this.z = new U[this.c.size()];
            this.C = Double.MAX_VALUE;
            this.D = -1.7976931348623157E308;
            for (n3 = this.b.size() - 1; n3 >= 0; --n3) {
                u2 = (U)this.b.get(n3);
                this.D = Math.max(this.D, U.b(u2));
                this.C = Math.min(this.C, U.c(u2));
                this.y[n3] = u2;
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block4;
            }
            n3 = this.c.size() - 1;
        }
        while (n3 >= 0) {
            u2 = (U)this.c.get(n3);
            this.D = Math.max(this.D, U.b(u2));
            this.C = Math.min(this.C, U.c(u2));
            this.z[n3] = u2;
            --n3;
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        this.x = new V(this.u);
        e.a(this.y, this.x);
        e.a(this.z, this.x);
        this.e();
    }

    /*
     * Exception decompiling
     */
    private void e() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:420)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:219)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:619)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:45)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:714)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     */
    private double b(D var1_1, D var2_2) {
        var13_3 = v.f;
        var3_4 = var1_1.k();
        var4_5 = var2_2.k();
        var5_6 = 0.0;
        var7_7 = -1.7976931348623157E308;
        do lbl-1000: // 5 sources:
        {
            if (var3_4 == null) return - var7_7;
            if (var4_5 == null) return - var7_7;
            var9_8 = (T)var3_4.c();
            var10_9 = (T)var4_5.c();
            var11_10 = - var10_9.c + var10_9.d - (var9_8.c + var9_8.d);
            var7_7 = Math.max(var7_7, Math.max(var9_8.e, var10_9.e) - var11_10);
            if (var3_4.a() == null || var4_5.a() == null) ** GOTO lbl19
            if (((T)var3_4.a().c()).b >= ((T)var4_5.a().c()).b) ** GOTO lbl17
            var3_4 = var3_4.a();
            if (var13_3 == 0) ** GOTO lbl-1000
lbl17: // 2 sources:
            var4_5 = var4_5.a();
            if (var13_3 == 0) ** GOTO lbl-1000
lbl19: // 2 sources:
            if (var4_5.a() == null) ** GOTO lbl22
            var4_5 = var4_5.a();
            if (var13_3 == 0) ** GOTO lbl-1000
lbl22: // 2 sources:
            if (var3_4.a() == null) return - var7_7;
            var3_4 = var3_4.a();
        } while (var13_3 == 0);
        return - var7_7;
    }

    public double a(D d2, D d3) {
        double d4 = Math.max(this.s, - this.b(d2, d3));
        if (d4 != -1.7976931348623157E308) return d4;
        return 0.0;
    }

    public void c() {
        double d2;
        int n2;
        double d3;
        D d4;
        U u2;
        double d5;
        int n3;
        block18 : {
            int n4;
            block17 : {
                boolean bl2;
                Object object;
                block16 : {
                    S s2;
                    int n5;
                    block15 : {
                        int n6;
                        block14 : {
                            int n7;
                            n2 = v.f;
                            this.b();
                            for (n6 = 0; n6 < this.y.length; ++n6) {
                                object = this.y[n6];
                                n7 = (int)object.b() ? 1 : 0;
                                if (n2 == 0) {
                                    if (n7 != 0) continue;
                                    double d6 = object.e();
                                    d2 = object.f();
                                    object.c(- d6);
                                    object.b(- d2);
                                    this.a(this.A, (U)object, 0.0, false);
                                    object.a(- object.d());
                                    object.b(d6);
                                    object.c(d2);
                                    if (n2 == 0) continue;
                                }
                                break block14;
                            }
                            n7 = n6 = 0;
                        }
                        while (n6 < this.z.length) {
                            s2 = this;
                            if (n2 == 0) {
                                object = s2.z[n6];
                                if (object.a() == 0 && !object.b()) {
                                    this.a(this.B, (U)object, 0.0, false);
                                }
                                ++n6;
                                if (n2 == 0) continue;
                            }
                            break block15;
                        }
                        s2 = this;
                    }
                    d4 = s2.a(this.A);
                    object = this.a(this.B);
                    for (n3 = 0; n3 < this.z.length; ++n3) {
                        u2 = this.z[n3];
                        n5 = (int)u2.b() ? 1 : 0;
                        if (n2 == 0) {
                            if (n5 == 0) continue;
                            this.a((D)object, u2, 0.0, false);
                            if (n2 == 0) continue;
                        }
                        break block16;
                    }
                    n5 = n3 = this.y.length - 1;
                }
                while (n3 >= 0) {
                    u2 = this.y[n3];
                    bl2 = u2.b();
                    if (n2 == 0) {
                        if (bl2) {
                            this.a((D)object, u2, 0.0, false);
                        }
                        --n3;
                        if (n2 == 0) continue;
                    }
                    break block17;
                }
                this.s = Math.max(this.s, this.a((D)object, this.A));
                bl2 = false;
            }
            for (n3 = (int)(v1855426) ? 1 : 0; n3 < this.y.length; ++n3) {
                u2 = this.y[n3];
                n4 = (int)u2.b() ? 1 : 0;
                if (n2 == 0) {
                    if (n4 == 0) continue;
                    d2 = u2.e();
                    d3 = u2.f();
                    u2.c(- d2);
                    u2.b(- d3);
                    d5 = u2.d();
                    this.a(d4, u2, d5, true);
                    u2.a(- u2.d());
                    u2.a((U.d(u2) + d5) * 0.5);
                    u2.b(d2);
                    u2.c(d3);
                    if (n2 == 0) continue;
                }
                break block18;
            }
            n4 = n3 = this.z.length - 1;
        }
        while (n3 >= 0) {
            u2 = this.z[n3];
            if (n2 != 0) return;
            if (u2.b()) {
                d2 = u2.e();
                d3 = u2.f();
                u2.c(- d2);
                u2.b(- d3);
                d5 = u2.d();
                this.a(d4, u2, d5, true);
                u2.a(- u2.d());
                u2.a((u2.d() + d5) * 0.5);
                u2.b(d2);
                u2.c(d3);
            }
            --n3;
            if (n2 == 0) continue;
        }
        this.s = Math.max(this.s, this.a(this.B, d4));
    }

    private D a(D d2) {
        int n2 = v.f;
        D d3 = new D(d2);
        p p2 = d3.k();
        do {
            if (p2 == null) return d3;
            T t2 = (T)p2.c();
            p2.a(t2.clone());
            p2 = p2.a();
        } while (n2 == 0);
        return d3;
    }

    public double d() {
        return this.s;
    }

    private void f() {
        int n2 = v.f;
        int n3 = this.i.size() - 1;
        do {
            block7 : {
                double d2;
                double d3;
                double d4;
                boolean bl2;
                D d5;
                double d6;
                double d7;
                double d8;
                boolean bl3;
                Object object;
                int n4 = n3;
                block1 : do {
                    if (n4 < 0) return;
                    d4 = Double.MAX_VALUE;
                    d8 = -1.7976931348623157E308;
                    d6 = -1.7976931348623157E308;
                    d3 = Double.MAX_VALUE;
                    bl2 = true;
                    bl3 = true;
                    d5 = (D)this.i.get(n3);
                    d7 = 0.0;
                    d2 = 0.0;
                    for (object = d5.k(); object != null; object = object.a()) {
                        byte by2;
                        U u2 = (U)object.c();
                        d6 = Math.max(d6, u2.e());
                        d3 = Math.min(d3, u2.f());
                        d2 = Math.max(d2, u2.a);
                        d7 = Math.max(d7, U.e(u2));
                        n4 = (int)(U.c(u2) DCMPG d4);
                        if (n2 != 0) continue block1;
                        if (n4 < 0) {
                            d4 = U.c(u2);
                            by2 = u2.a();
                            boolean bl4 = bl2 = by2 == 2 || by2 == 0;
                        }
                        if (U.b(u2) > d8) {
                            d8 = U.b(u2);
                            by2 = u2.a();
                            bl3 = by2 == 1 || by2 == 0;
                        }
                        this.k.add(u2.c());
                        if (n2 == 0) continue;
                    }
                    break;
                } while (true);
                object = U.a(d5, d2 * 2.0, d7, d4, bl2, d8, bl3);
                object.b(d6);
                object.c(d3);
                this.a.put(d5, object);
                if (U.a((U)object) == 3) {
                    this.b.add(object);
                    if (n2 == 0) break block7;
                }
                this.c.add(object);
            }
            --n3;
        } while (n2 == 0);
    }

    public double a(Object object) {
        double d2 = this.b(object).d();
        if (!Double.isNaN(d2)) return d2;
        return this.n;
    }

    /*
     * Unable to fully structure code
     */
    private void a(D var1_1, U var2_2, double var3_3, boolean var5_4) {
        block15 : {
            block14 : {
                var18_5 = v.f;
                if (this.p && Math.abs(U.b(var2_2) - U.c(var2_2)) < this.r) {
                    var2_2.a(Double.NaN);
                    return;
                }
                var7_7 = new T(U.c(var2_2), 0.0, var2_2.a, U.e(var2_2), (var6_6 = var2_2.a()) == 0 || var6_6 == 2);
                var8_8 = new T(U.b(var2_2), 0.0, var2_2.a, U.e(var2_2), var6_6 == 1 || var6_6 == 0);
                var9_9 = var1_1.k();
                var10_10 = (T)var9_9.c();
                var11_11 = var10_10.c + var10_10.d + Math.max(var10_10.e, U.e(var2_2));
                var13_12 = var10_10;
                while (U.c(var2_2) - var2_2.a > var10_10.b + var10_10.d) {
                    var11_11 = var10_10.c + var10_10.d + Math.max(var10_10.e, U.e(var2_2));
                    var13_12 = var10_10;
                    var9_9 = var9_9.a();
                    var10_10 = (T)var9_9.c();
                    if (var18_5 == 0) {
                        if (var18_5 == 0) continue;
                    }
                    break block14;
                }
                var11_11 = Math.max(var11_11, var2_2.e());
            }
            while (var9_9 != null && U.c(var2_2) > var10_10.b) {
                var11_11 = Math.max(var11_11, var10_10.c + var10_10.d + Math.max(var10_10.e, U.e(var2_2)));
                var13_12 = var10_10;
                var9_9 = var9_9.a();
                var10_10 = (T)var9_9.c();
                if (var18_5 == 0) continue;
            }
            var14_13 = var1_1.a(var7_7, var9_9);
            var15_14 = var11_11;
            while (U.b(var2_2) >= var10_10.b) {
                var13_12 = var10_10;
                var15_14 = var10_10.c;
                var11_11 = Math.max(var15_14 + var10_10.d + Math.max(var10_10.e, U.e(var2_2)), var11_11);
                var1_1.h(var9_9);
                v0 = var9_9 = var9_9.a();
                if (var18_5 == 0) {
                    if (v0 == null) break;
                    var10_10 = (T)var9_9.c();
                    if (var18_5 == 0) continue;
                }
                ** GOTO lbl42
            }
            do {
                v0 = var9_9;
lbl42: // 2 sources:
                if (v0 == null) break;
                v1 = U.b(var2_2) + var2_2.a DCMPL var10_10.b - var10_10.d;
                if (var18_5 != 0) break block15;
                if (v1 <= 0) break;
                var11_11 = Math.max(var10_10.c + var10_10.d + Math.max(var10_10.e, U.e(var2_2)), var11_11);
                if ((var9_9 = var9_9.a()) == null) break;
                var10_10 = (T)var9_9.c();
            } while (var18_5 == 0);
            if (var14_13.b() != null) {
                var17_15 = (T)var14_13.b().c();
                if (var17_15.b + this.q > U.c(var2_2) && var17_15.a != var7_7.a && var14_13.b().b() != null) {
                    var17_15 = (T)var14_13.b().b().c();
                    var11_11 = Math.max(var11_11, var17_15.c + var17_15.d + Math.max(var17_15.e, U.e(var2_2)));
                }
            }
            if (var14_13.a() != null) {
                var17_15 = (T)var14_13.a().c();
                if (var17_15.b - this.q < U.b(var2_2) && var17_15.a != var8_8.a) {
                    var11_11 = Math.max(var11_11, var17_15.c + var17_15.d + Math.max(var17_15.e, U.e(var2_2)));
                }
            }
            v1 = this.v DCMPL 0.0;
        }
        if (v1 > 0) {
            var11_11 = Math.ceil((var11_11 - this.w) / this.v) * this.v + this.w;
            if (var5_4 && Math.abs(((var11_11 + var3_3) * 0.5 - this.w) % this.v) > 0.0) {
                var11_11 += this.v;
            }
        }
        var14_13.a(new T(U.c(var2_2), var11_11 += var2_2.a, var2_2.a * 2.0, U.e(var2_2), U.a(var2_2) == 2 || U.a(var2_2) == 0));
        var17_15 = var1_1.b(new T(U.b(var2_2), var13_12.c, var13_12.d * 2.0, var13_12.e, U.a(var2_2) == 0 || U.a(var2_2) == 1), var14_13);
        var2_2.a(var11_11);
        if (var11_11 - var2_2.f() > this.s) {
            this.s = Math.max(this.s, var11_11 - var2_2.f());
        }
        this.d = Math.max(this.d, var11_11);
    }

    private U b(Object object) {
        U u2 = (U)this.a.get(object);
        if (u2 != null) return u2;
        Object v2 = this.j.get(object);
        if (v2 == null) throw new IllegalArgumentException("No such key registered!");
        return (U)this.a.get(v2);
    }
}

