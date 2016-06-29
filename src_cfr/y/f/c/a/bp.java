/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.p;
import y.c.y;
import y.d.c;
import y.d.q;
import y.d.t;
import y.f.I;
import y.f.X;
import y.f.aE;
import y.f.am;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.an;
import y.f.c.a.bs;
import y.f.c.a.cB;
import y.f.c.a.cr;
import y.f.c.a.cy;

class bP {
    private static final double a = Math.sqrt(2.0);
    private f b = new f();
    private aV c;
    private aP d;
    private double e = 10.0;
    private double f = 0.0;

    public bP(aV aV2, aP aP2) {
        this.c = aV2;
        this.d = aP2;
    }

    void a(Map map) {
        Object v2 = map.get("SameLayerEdgeSupport.minimumEdgeDistance");
        if (v2 instanceof Number) {
            this.a(((Number)v2).doubleValue());
        }
        if (!((v2 = map.get("SameLayerEdgeSupport.defaultThickness")) instanceof Number)) return;
        this.f = ((Number)v2).doubleValue();
    }

    public void a(X x2) {
        boolean bl2 = N.x;
        e e2 = x2.p();
        do {
            int n2;
            if (!e2.f()) return;
            d d2 = e2.a();
            int n3 = this.c.a(d2.c()).j();
            if (n3 == (n2 = this.c.a(d2.d()).j())) {
                this.a(x2, d2);
            }
            e2.g();
        } while (!bl2);
    }

    public void a(X x2, d d2) {
        if (x2.f(d2)) {
            x2.d(d2);
        }
        this.d.b(d2);
        this.b.add(d2);
    }

    public void b(X x2, d d2) {
        if (x2.f(d2)) return;
        x2.e(d2);
    }

    public void b(X x2) {
        boolean bl2 = N.x;
        p p2 = this.b.k();
        do {
            if (p2 == null) return;
            this.b.h(p2);
            this.b(x2, (d)p2.c());
            p2 = p2.a();
        } while (!bl2);
    }

    public void a(X x2, aV aV2, c c2, y.c.q q2, am am2, aX aX2, double d2, boolean bl2) {
    }

    /*
     * Unable to fully structure code
     */
    void a(X var1_1, c var2_2, aQ var3_3, aV var4_4, double var5_5, Map var7_6) {
        var30_7 = N.x;
        var8_8 = cB.b(var1_1);
        var9_9 = var3_3.f().iterator();
        do lbl-1000: // 6 sources:
        {
            block12 : {
                block11 : {
                    if (var9_9.hasNext() == false) return;
                    var10_10 = (d)var9_9.next();
                    var11_11 = var4_4.a(var10_10);
                    var12_12 = var1_1.b(var10_10);
                    var13_13 = var12_12.pointCount();
                    if (var11_11.a() != 4) ** GOTO lbl51
                    var14_14 = 0.0;
                    var16_17 = 0.0;
                    if (var7_6.containsKey(var10_10)) {
                        var18_19 = (y.c.q)var7_6.get(var10_10);
                        var19_20 = (an)var4_4.a((y.c.q)var18_19);
                        var20_21 = var1_1.a(var18_19);
                        var14_14 = var20_21.getX() - var19_20.c;
                        var16_17 = var20_21.getY() - var19_20.b;
                    }
                    var18_19 = new ArrayList<E>(var13_13 + 2);
                    var19_20 = var1_1.p(var10_10);
                    var20_21 = var1_1.q(var10_10);
                    var21_23 = var19_20.a();
                    var23_26 = var20_21.a();
                    var25_29 = new double[2];
                    if (var8_8 != null) {
                        var8_8.a(var1_1, var10_10, 0, var25_29, true, var21_23 < var23_26);
                    }
                    var26_30 = var25_29[1];
                    if (var21_23 >= var23_26) ** GOTO lbl-1000
                    var18_19.add(new t(var19_20.a(), var19_20.b() + var26_30 + var5_5));
                    for (var28_32 = 0; var28_32 < var13_13; ++var28_32) {
                        var29_33 = var12_12.getPoint(var28_32);
                        var18_19.add(new t(var14_14 + var29_33.a(), var16_17 + var29_33.b() + var26_30 + var5_5));
                        if (!var30_7) {
                            if (!var30_7) continue;
                        }
                        break block11;
                    }
                    var18_19.add(new t(var20_21.a(), var20_21.b() + var26_30 + var5_5));
                }
                if (var30_7) lbl-1000: // 2 sources:
                {
                    var18_19.add(new t(var20_21.a(), var20_21.b() + var26_30 + var5_5));
                    for (var28_32 = var13_13 - 1; var28_32 >= 0; --var28_32) {
                        var29_33 = var12_12.getPoint(var28_32);
                        var18_19.add(new t(var14_14 + var29_33.a(), var16_17 + var29_33.b() + var26_30 + var5_5));
                        if (!var30_7) {
                            if (!var30_7) continue;
                        }
                        break block12;
                    }
                    var18_19.add(new t(var19_20.a(), var19_20.b() + var26_30 + var5_5));
                }
            }
            var28_31 = this.a((List)var18_19);
            var2_2.a(var28_31);
            if (!var30_7) ** GOTO lbl-1000
lbl51: // 2 sources:
            if (var13_13 < 2) ** GOTO lbl-1000
            var14_15 = new ArrayList<t>(var13_13);
            var15_16 = var12_12.getPoint(0).a();
            var17_18 = var12_12.getPoint(var13_13 - 1).a();
            var19_20 = new double[2];
            if (var8_8 != null) {
                var8_8.a(var1_1, var10_10, 0, var19_20, true, var15_16 < var17_18);
            }
            var20_22 = var19_20[1];
            if (var15_16 >= var17_18) ** GOTO lbl65
            for (var22_24 = 0; var22_24 < var13_13; ++var22_24) {
                var23_27 = var12_12.getPoint(var22_24);
                var14_15.add(new t(var23_27.a(), var23_27.b() + var20_22));
                if (var30_7) ** GOTO lbl-1000
                if (!var30_7) continue;
lbl65: // 3 sources:
                for (var22_24 = var13_13 - 1; var22_24 >= 0; --var22_24) {
                    var23_28 = var12_12.getPoint(var22_24);
                    var14_15.add(new t(var23_28.a(), var23_28.b() + var20_22));
                    if (var30_7) ** GOTO lbl-1000
                    if (!var30_7) continue;
                }
            }
            var22_25 = this.a(var14_15);
            var2_2.a(var22_25);
        } while (!var30_7);
    }

    private c a(List list) {
        boolean bl2 = N.x;
        if (list.isEmpty()) {
            return null;
        }
        c c2 = new c(-1.7976931348623157E308);
        c c3 = new c(-1.7976931348623157E308);
        t t2 = null;
        Iterator iterator = list.iterator();
        do {
            double d2;
            double d3;
            if (!iterator.hasNext()) return c2;
            t t3 = (t)iterator.next();
            if (t2 != null && (d2 = Math.min(t2.a(), t3.a())) != (d3 = Math.max(t2.a(), t3.a()))) {
                double d4 = t2.a() < t3.a() ? t2.b() : t3.b();
                double d5 = t2.a() < t3.a() ? t3.b() : t2.b();
                double d6 = d5 == d4 ? 0.0 : (d5 - d4) / (d3 - d2);
                c3.a(d2, d3, d4, d6);
                c2.a(c3);
                c3.c(-1.7976931348623157E308, Double.MAX_VALUE, -1.7976931348623157E308);
            }
            t2 = t3;
        } while (!bl2);
        return c2;
    }

    /*
     * Exception decompiling
     */
    public int a(X var1_1, aU var2_2, aV var3_3, aP var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:420)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:219)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:619)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:45)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:681)
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
     * Exception decompiling
     */
    public void a(X var1_1, cr var2_2, aQ var3_3, aV var4_4, boolean var5_5, double var6_6) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:420)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:219)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:619)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:45)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:681)
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

    private static final boolean a(aX aX2) {
        if (aX2.b() == 0) return true;
        if (aX2.b() == 5) return true;
        return false;
    }

    private final double a(aV aV2, d d2, boolean bl2) {
        A a2 = aV2.a(d2);
        B b2 = a2.k();
        if (b2 != null) {
            double d3;
            if (bl2) {
                double d4;
                if (a2.i()) {
                    d4 = b2.b();
                    return d4;
                }
                d4 = b2.a();
                return d4;
            }
            if (a2.i()) {
                d3 = b2.a();
                return d3;
            }
            d3 = b2.b();
            return d3;
        }
        if (bl2) {
            if (!a2.i()) return 10.0;
            return 15.0;
        }
        if (!a2.i()) return 15.0;
        return 10.0;
    }

    private q a(i i2) {
        y.c.c c2 = i2.c(N.u);
        if (c2 != null) return (q)c2.b(i2);
        return null;
    }

    protected double a(X x2, aV aV2, d d2) {
        B b2;
        double d3;
        double d4 = 0.0;
        q q2 = this.a((i)x2);
        if (q2 != null) {
            byte by2 = aV2.a(d2.c()).b();
            byte by3 = aV2.a(d2.d()).b();
            if (by2 == 15 || by3 == 15) {
                d4 = q2.b * 0.5;
            }
        }
        if ((b2 = aV2.a(d2).k()) != null) {
            d3 = b2.d();
            return d4 + d3;
        }
        d3 = this.e;
        return d4 + d3;
    }

    /*
     * Unable to fully structure code
     */
    public Rectangle2D.Double a(X var1_1, aV var2_2, y.c.q var3_3, y.c.q var4_4, List var5_5) {
        block15 : {
            var40_6 = N.x;
            if (var5_5.size() <= 0) return null;
            var6_7 = var1_1.a(var3_3);
            var7_8 = var1_1.a(var4_4);
            var8_9 = new cr();
            var9_10 = 0.0;
            var8_9.a(0.0);
            var8_9.a(true);
            var8_9.b(Double.NaN);
            var11_11 = Double.MAX_VALUE;
            var13_12 = -1.7976931348623157E308;
            var15_13 = cB.b(var1_1);
            for (var16_14 = 0; var16_14 < var5_5.size(); ++var16_14) {
                var17_16 = (d)var5_5.get(var16_14);
                var18_17 = var1_1.b(var17_16);
                var18_17.clearPoints();
                var19_19 = this.a(var1_1, var2_2, var17_16);
                var21_20 = this.f;
                var23_22 = new double[2];
                var24_23 = new q(0.0, 0.0);
                var25_26 = new double[2];
                var26_28 = new q(0.0, 0.0);
                if (var40_6) break block15;
                if (var17_16.c() != var3_3) ** GOTO lbl43
                if (var15_13 != null) {
                    var24_23 = var15_13.a(var1_1, var17_16, 0, (double[])var23_22, true, true, 2);
                    var26_29 = var15_13.a(var1_1, var17_16, 0, var25_26, true, true, 1);
                }
                if ((var27_34 = var6_7.getY() + var6_7.getHeight() * 0.5 + var18_17.getSourcePoint().b) < (var29_37 = var7_8.getY() + var7_8.getHeight() * 0.5 + var18_17.getTargetPoint().b)) ** GOTO lbl-1000
                var31_38 = Math.max((double)var23_22[1], var25_26[1] - var27_34 + var29_37);
                var33_39 = - Math.max(var25_26[0], (double)(var23_22[0] - var27_34 + var29_37));
                if (var40_6) lbl-1000: // 2 sources:
                {
                    var31_38 = - Math.max((double)var23_22[0], var25_26[0] - var29_37 + var27_34);
                    var33_39 = Math.max(var25_26[1], (double)(var23_22[1] - var29_37 + var27_34));
                }
                var11_11 = Math.min(var11_11, Math.min(var27_34 + var31_38, var29_37 + var33_39));
                var13_12 = Math.max(var13_12, Math.max(var27_34 + var31_38, var29_37 + var33_39));
                var35_40 = var2_2.a(var17_16).k();
                var36_41 = var35_40.i() / bP.a;
                var38_42 = this.b(var2_2, var17_16) == false ? var36_41 : 0.0;
                var8_9.a((Object)var17_16, var21_20, Math.max(var19_19, var24_23.a) + var38_42, Math.max(var19_19, var26_30.a) + var38_42, var27_34 + var31_38, true, var29_37 + var33_39, false, false, 0.0);
                if (var35_40 == null) continue;
                var9_10 = Math.max(var9_10, var35_40.c() - Math.abs(var27_34 - var29_37));
                if (!var40_6) continue;
lbl43: // 2 sources:
                if (var15_13 != null) {
                    var24_23 = var15_13.a(var1_1, var17_16, 0, (double[])var23_22, true, false, 2);
                    var26_31 = var15_13.a(var1_1, var17_16, 0, var25_26, true, false, 1);
                }
                var27_34 = var6_7.getY() + var6_7.getHeight() * 0.5 + var18_17.getTargetPoint().b;
                var29_37 = var7_8.getY() + var7_8.getHeight() * 0.5 + var18_17.getSourcePoint().b;
                if (var29_37 >= var27_34) ** GOTO lbl-1000
                var31_38 = - Math.max((double)var23_22[0], var25_26[0] - var27_34 + var29_37);
                var33_39 = Math.max(var25_26[1], (double)(var23_22[1] - var27_34 + var29_37));
                if (var40_6) lbl-1000: // 2 sources:
                {
                    var31_38 = Math.max((double)var23_22[1], var25_26[1] - var29_37 + var27_34);
                    var33_39 = - Math.max(var25_26[0], (double)(var23_22[0] - var29_37 + var27_34));
                }
                var11_11 = Math.min(var11_11, Math.min(var29_37 + var31_38, var27_34 + var33_39));
                var13_12 = Math.max(var13_12, Math.max(var29_37 + var31_38, var27_34 + var33_39));
                var35_40 = var2_2.a(var17_16).k();
                var36_41 = var35_40.i() / bP.a;
                var38_42 = this.b(var2_2, var17_16) == false ? var36_41 : 0.0;
                var8_9.a((Object)var17_16, var21_20, Math.max(var19_19, var26_27.a) + var38_42, Math.max(var19_19, var24_23.a) + var38_42, var27_34 + var33_39, true, var29_37 + var31_38, false, false, 0.0);
                if (var35_40 == null) continue;
                var9_10 = Math.max(var9_10, var35_40.c() - Math.abs(var29_37 - var27_34));
                if (!var40_6) continue;
            }
            var8_9.j();
        }
        var16_15 = Double.MAX_VALUE;
        var18_18 = -1.7976931348623157E308;
        for (var20_43 = 0; var20_43 < var5_5.size(); ++var20_43) {
            var21_21 = (d)var5_5.get(var20_43);
            var22_44 = var1_1.b(var21_21);
            var23_22 = var8_9.a(var21_21);
            if (var40_6 != false) return new Rectangle2D.Double(var16_15, var11_11, Math.max(var9_10, var18_18 - var16_15), var13_12 - var11_11);
            if (var23_22 == null || Double.isNaN(var23_22.d)) continue;
            var16_15 = Math.min(var16_15, var23_22.d - var23_22.f);
            var18_18 = Math.max(var18_18, var23_22.d + var23_22.g);
            var24_25 = var23_22.d;
            var26_33 = var22_44.getSourcePoint();
            var27_36 = var22_44.getTargetPoint();
            if (this.b(var2_2, var21_21)) {
                if (var21_21.c() == var3_3) {
                    var22_44.addPoint(var24_25, var6_7.getY() + var6_7.getHeight() * 0.5 + var26_33.b);
                    var22_44.addPoint(var24_25, var7_8.getY() + var7_8.getHeight() * 0.5 + var27_36.b);
                    if (!var40_6) continue;
                }
                var22_44.addPoint(var24_25, var7_8.getY() + var7_8.getHeight() * 0.5 + var26_33.b);
                var22_44.addPoint(var24_25, var6_7.getY() + var6_7.getHeight() * 0.5 + var27_36.b);
                if (!var40_6) continue;
            }
            if (var21_21.c() == var3_3) {
                var28_45 = var6_7.getY() + var6_7.getHeight() * 0.5 + var26_33.b;
                var30_46 = var7_8.getY() + var7_8.getHeight() * 0.5 + var27_36.b;
                var32_47 = var2_2.a(var21_21).k();
                var33_39 = var32_47.i() / bP.a;
                if (var23_22.a() == 2) {
                    if (var30_46 - var28_45 <= 2.0 * var33_39) {
                        var22_44.addPoint(var23_22.d - (var30_46 - var28_45) * 0.5, var28_45);
                        var22_44.addPoint(var23_22.d + (var30_46 - var28_45) * 0.5, var30_46);
                        if (!var40_6) continue;
                    }
                    var22_44.addPoint(var23_22.d - var33_39, var28_45);
                    var22_44.addPoint(var23_22.d, var28_45 + var33_39);
                    var22_44.addPoint(var23_22.d, var30_46 - var33_39);
                    var22_44.addPoint(var23_22.d + var33_39, var30_46);
                    if (!var40_6) continue;
                }
                if (var28_45 - var30_46 <= 2.0 * var33_39) {
                    var22_44.addPoint(var23_22.d - (var28_45 - var30_46) * 0.5, var28_45);
                    var22_44.addPoint(var23_22.d + (var28_45 - var30_46) * 0.5, var30_46);
                    if (!var40_6) continue;
                }
                var22_44.addPoint(var23_22.d - var33_39, var28_45);
                var22_44.addPoint(var23_22.d, var28_45 - var33_39);
                var22_44.addPoint(var23_22.d, var30_46 + var33_39);
                var22_44.addPoint(var23_22.d + var33_39, var30_46);
                if (!var40_6) continue;
            }
            var28_45 = var7_8.getY() + var7_8.getHeight() * 0.5 + var26_33.b;
            var30_46 = var6_7.getY() + var6_7.getHeight() * 0.5 + var27_36.b;
            var32_47 = var2_2.a(var21_21).k();
            var33_39 = var32_47.i() / bP.a;
            if (2 != var23_22.a()) {
                if (var30_46 - var28_45 <= 2.0 * var33_39) {
                    var22_44.addPoint(var23_22.d + (var30_46 - var28_45) * 0.5, var28_45);
                    var22_44.addPoint(var23_22.d - (var30_46 - var28_45) * 0.5, var30_46);
                    if (!var40_6) continue;
                }
                var22_44.addPoint(var23_22.d + var33_39, var28_45);
                var22_44.addPoint(var23_22.d, var28_45 + var33_39);
                var22_44.addPoint(var23_22.d, var30_46 - var33_39);
                var22_44.addPoint(var23_22.d - var33_39, var30_46);
                if (!var40_6) continue;
            }
            if (var28_45 - var30_46 <= 2.0 * var33_39) {
                var22_44.addPoint(var23_22.d + (var28_45 - var30_46) * 0.5, var28_45);
                var22_44.addPoint(var23_22.d - (var28_45 - var30_46) * 0.5, var30_46);
                if (!var40_6) continue;
            }
            var22_44.addPoint(var23_22.d + var33_39, var28_45);
            var22_44.addPoint(var23_22.d, var28_45 - var33_39);
            var22_44.addPoint(var23_22.d, var30_46 + var33_39);
            var22_44.addPoint(var23_22.d - var33_39, var30_46);
            if (!var40_6) continue;
        }
        if (var16_15 <= var18_18) return new Rectangle2D.Double(var16_15, var11_11, Math.max(var9_10, var18_18 - var16_15), var13_12 - var11_11);
        return new Rectangle2D.Double(0.0, var11_11, var9_10, var13_12 - var11_11);
    }

    private boolean b(aV aV2, d d2) {
        if (aV2 == null) return true;
        if (aV2.a(d2) == null) return true;
        if (aV2.a(d2).k() == null) {
            return true;
        }
        bs bs2 = aV2.a(d2).k().h();
        if (bP.b(d2, aV2)) {
            if (bs2.a() != 0) return false;
            return true;
        }
        if (bP.a(d2, aV2)) {
            if (bs2.d() != 0) return false;
            return true;
        }
        if (bs2.c() != 0) return false;
        return true;
    }

    private static boolean a(d d2, aV aV2) {
        d d3 = aV2.a(d2).b();
        aX aX2 = aV2.a(d2.c());
        aX aX3 = aV2.a(d2.d());
        if (d3 == null) {
            if (aX2.j() != aX3.j()) return false;
            return true;
        }
        aX aX4 = aV2.a(d3.c());
        aX aX5 = aV2.a(d3.d());
        if (bP.b(aX2)) return false;
        if (bP.b(aX3)) return false;
        if (bP.b(aX4)) return false;
        if (bP.b(aX5)) return false;
        if (aX4.j() != aX5.j()) return false;
        return true;
    }

    private static boolean b(aX aX2) {
        if (aX2 == null) {
            return false;
        }
        if (aX2.b() != 15) return false;
        return true;
    }

    private static boolean b(d d2, aV aV2) {
        aX aX2 = aV2.a(d2.c());
        aX aX3 = aV2.a(d2.d());
        d d3 = aV2.a(d2).b();
        aX aX4 = d3 == null ? null : aV2.a(d3.c());
        aX aX5 = d3 == null ? null : aV2.a(d3.d());
        if (aX2.b() == 8) return true;
        if (aX2.b() == 9) return true;
        if (aX3.b() == 8) return true;
        if (aX3.b() == 9) return true;
        if (bP.b(aX2)) return true;
        if (bP.b(aX3)) return true;
        if (bP.b(aX4)) return true;
        if (bP.b(aX5)) return true;
        return false;
    }

    /*
     * Unable to fully structure code
     */
    public void b(X var1_1, aU var2_2, aV var3_3, aP var4_4) {
        var22_5 = N.x;
        var5_6 = 0;
        do {
            v0 = var5_6;
            block1 : do {
                v1 = var2_2.b();
                block2 : do {
                    if (v0 >= v1) return;
                    var6_7 = var2_2.a(var5_6);
                    if (var6_7.e() == 1) break block1;
                    var7_8 = 0;
                    var8_9 = var6_7.d();
                    var9_10 = -1;
                    for (var10_11 = var8_9.k(); var10_11 != null; var10_11 = var10_11.a(), ++var7_8) {
                        var11_12 = (y.c.q)var10_11.c();
                        var12_13 = var3_3.a(var11_12);
                        var13_14 = var12_13.b();
                        v0 = var13_14;
                        if (var22_5) continue block1;
                        if (v0 != 0 && var13_14 != 12 && var13_14 != 13 && var13_14 != 15) ** GOTO lbl46
                        for (var14_15 = var12_13.d(); var14_15 != null; var14_15 = var14_15.a()) {
                            var15_16 = (d)var14_15.c();
                            var16_17 = var15_16.a(var11_12);
                            var17_18 = var3_3.a(var16_17);
                            v0 = var17_18.k();
                            v1 = var7_8;
                            if (var22_5) continue block2;
                            if (v0 >= v1 || var9_10 > var17_18.k()) continue;
                            var18_19 = var3_3.a(var15_16);
                            v2 = var21_22 = var15_16.c() == var11_12;
                            if (!var21_22) ** GOTO lbl-1000
                            var19_20 = var18_19.c();
                            var20_21 = var18_19.e();
                            if (var22_5) lbl-1000: // 2 sources:
                            {
                                var19_20 = var18_19.e();
                                var20_21 = var18_19.c();
                            }
                            if (var19_20 != null && !var19_20.g() && !var19_20.f() || var20_21 != null && !var20_21.g() && !var20_21.e()) continue;
                            var4_4.d(var15_16);
                            if (var21_22) {
                                var4_4.a(var15_16, true, aE.a(8, var19_20 != null && var19_20.a() != false));
                                var4_4.a(var15_16, false, aE.a(4, var20_21 != null && var20_21.a() != false));
                                if (!var22_5) continue;
                            }
                            var4_4.a(var15_16, false, aE.a(8, var19_20 != null && var19_20.a() != false));
                            var4_4.a(var15_16, true, aE.a(4, var20_21 != null && var20_21.a() != false));
                            if (!var22_5) continue;
                        }
lbl46: // 3 sources:
                        if (var13_14 != 0) continue;
                        var9_10 = var7_8;
                        if (!var22_5) continue;
                    }
                    break;
                } while (true);
                break;
            } while (true);
            ++var5_6;
        } while (!var22_5);
    }

    /*
     * Unable to fully structure code
     */
    public void b(X var1_1, cr var2_2, aQ var3_3, aV var4_4, boolean var5_5, double var6_6) {
        var42_7 = N.x;
        var8_8 = var3_3.d().k();
        do {
            if (var8_8 == null) return;
            v0 = (y.c.q)var8_8.c();
            block1 : while ((var10_10 = var4_4.a(var9_9 = v0)).e() > 0) {
                for (var11_11 = var10_10.d(); var11_11 != null; var11_11 = var11_11.a()) {
                    block12 : {
                        var12_12 = (d)var11_11.c();
                        v0 = var12_12.c();
                        if (var42_7) continue block1;
                        if (v0 != var9_9 || var5_5 != this.a(var4_4, var12_12)) continue;
                        var1_1.e(var12_12);
                        var13_13 = var1_1.b(var12_12);
                        var14_14 = var4_4.a(var12_12);
                        if (var14_14.a() == 4) {
                            var1_1.d(var12_12);
                            if (!var42_7) continue;
                        }
                        var16_16 = (var15_15 = var14_14.c()) != null && (var15_15.b() == 4 || var15_15.b() == 8);
                        var17_17 = var14_14.e();
                        v1 = var18_18 = var17_17 != null && (var17_17.b() == 4 || var17_17.b() == 8);
                        if (!this.b(var4_4, var12_12)) ** GOTO lbl38
                        if (var16_16) {
                            var19_19 = var13_13.getPoint((int)0).a;
                            var13_13.setPoint(0, var19_19, var1_1.p((d)var12_12).b + var6_6);
                            if (!var42_7) break block12;
                        }
                        var19_19 = var1_1.p((d)var12_12).a;
                    }
                    if (!var18_18) ** GOTO lbl34
                    var21_20 = var13_13.getPoint((int)(var13_13.pointCount() - 1)).a;
                    var13_13.setPoint(var13_13.pointCount() - 1, var19_19, var2_2.d(var12_12));
                    var13_13.addPoint(var21_20, var2_2.d(var12_12));
                    var13_13.addPoint(var21_20, var1_1.q((d)var12_12).b + var6_6);
                    if (!var42_7) ** GOTO lbl82
lbl34: // 2 sources:
                    var21_20 = var1_1.q((d)var12_12).a;
                    var13_13.addPoint(var19_19, var2_2.d(var12_12));
                    var13_13.addPoint(var21_20, var2_2.d(var12_12));
                    if (!var42_7) ** GOTO lbl82
lbl38: // 2 sources:
                    var19_19 = var16_16 != false ? var13_13.getPoint((int)0).a : var1_1.p((d)var12_12).a;
                    var21_20 = var18_18 != false ? var13_13.getPoint((int)(var13_13.pointCount() - 1)).a : var1_1.q((d)var12_12).a;
                    var23_21 = var4_4.a(var12_12).k();
                    var24_22 = var23_21.i() / bP.a;
                    var26_23 = var2_2.a(var12_12);
                    var27_24 = var26_23.a() == 0;
                    var28_25 = var27_24 != false ? var26_23.d - (var26_23.p - var26_23.b) : var26_23.d + (var26_23.p - var26_23.b);
                    var30_26 = var27_24 != false ? var26_23.d - (var26_23.c - var26_23.q) : var26_23.d + (var26_23.c - var26_23.q);
                    var13_13.clearPoints();
                    var32_27 = var19_19 < var21_20;
                    var33_28 = var32_27 != false ? var28_25 : var30_26;
                    v2 = var35_29 = var32_27 != false ? var30_26 : var28_25;
                    if (!var16_16) ** GOTO lbl-1000
                    var37_30 = var1_1.p((d)var12_12).b + var6_6;
                    var39_31 = var15_15.b() == 4;
                    var40_32 = Math.abs(var37_30 - var33_28);
                    if (var40_32 <= var24_22) ** GOTO lbl-1000
                    var13_13.addPoint(var39_31 != false ? var19_19 - var24_22 : var19_19 + var24_22, var37_30);
                    var13_13.addPoint(var19_19, var27_24 != false ? var37_30 + var24_22 : var37_30 - var24_22);
                    var13_13.addPoint(var19_19, var33_28);
                    if (var42_7) lbl-1000: // 2 sources:
                    {
                        var13_13.addPoint(var39_31 != false ? var19_19 - var40_32 : var19_19 + var40_32, var37_30);
                        if (var32_27 != var39_31) {
                            var13_13.addPoint(var19_19, var33_28);
                            ** if (!var42_7) goto lbl65
                        }
                    }
                    ** GOTO lbl65
lbl-1000: // 2 sources:
                    {
                        var13_13.addPoint(var19_19, var33_28);
                    }
lbl65: // 3 sources:
                    var13_13.addPoint(var32_27 != false ? var26_23.p : var26_23.q, var26_23.d);
                    var13_13.addPoint(var32_27 != false ? var26_23.q : var26_23.p, var26_23.d);
                    if (!var18_18) ** GOTO lbl-1000
                    var37_30 = var1_1.q((d)var12_12).b + var6_6;
                    var39_31 = var17_17.b() == 8;
                    var40_32 = Math.abs(var37_30 - var35_29);
                    if (var40_32 <= var24_22) ** GOTO lbl-1000
                    var13_13.addPoint(var21_20, var35_29);
                    var13_13.addPoint(var21_20, var27_24 != false ? var37_30 + var24_22 : var37_30 - var24_22);
                    var13_13.addPoint(var39_31 != false ? var21_20 + var24_22 : var21_20 - var24_22, var37_30);
                    if (var42_7) lbl-1000: // 2 sources:
                    {
                        if (var32_27 != var39_31) {
                            var13_13.addPoint(var21_20, var35_29);
                        }
                        var13_13.addPoint(var39_31 != false ? var21_20 + var40_32 : var21_20 - var40_32, var37_30);
                        ** if (!var42_7) goto lbl82
                    }
                    ** GOTO lbl82
lbl-1000: // 2 sources:
                    {
                        var13_13.addPoint(var21_20, var35_29);
                    }
lbl82: // 5 sources:
                    var1_1.d(var12_12);
                    if (!var42_7) continue;
                }
            }
            var8_8 = var8_8.a();
        } while (!var42_7);
    }

    public boolean a(aV aV2, d d2) {
        A a2 = aV2.a(d2);
        return a2.j();
    }

    public f a() {
        return this.b;
    }

    public void a(double d2) {
        this.e = d2;
    }
}

