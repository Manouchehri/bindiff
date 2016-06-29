/*
 * Decompiled with CFR 0_115.
 */
package y.f.j;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.i;
import y.c.x;
import y.d.e;
import y.d.q;
import y.d.t;
import y.d.u;
import y.d.v;
import y.f.I;
import y.f.X;
import y.f.ad;
import y.f.ae;
import y.f.ah;
import y.f.am;
import y.f.c;

public class a
extends c
implements ad {
    private int o;
    private double p;
    private boolean q;
    private double r;
    private double s;
    private double t;
    private double u;
    private boolean v;
    private double w;
    private double x;
    private ah y;
    public static boolean n;

    public a() {
        boolean bl2 = n;
        this.o = 3;
        this.p = 0.0;
        this.q = false;
        this.r = 1.0;
        this.s = 1.0;
        this.t = 0.0;
        this.u = 0.0;
        this.v = false;
        this.w = 1.41;
        this.x = 1.0;
        this.e(false);
        this.b(false);
        this.f(false);
        this.d(false);
        if (!bl2) return;
        i.g = !i.g;
    }

    @Override
    public void a(ah ah2) {
        this.y = ah2;
    }

    @Override
    public ah a() {
        return this.y;
    }

    public void a(int n2) {
        this.o = n2;
        if (n2 == 2) return;
        this.v = false;
    }

    public void a(double d2) {
        this.p = d2;
    }

    public void g(boolean bl2) {
        this.q = bl2;
    }

    public void b(double d2) {
        this.r = this.s = d2;
    }

    public void a(double d2, double d3) {
        this.r = d2;
        this.s = d3;
    }

    public double n() {
        return this.t;
    }

    public double o() {
        return this.u;
    }

    @Override
    public boolean b(X x2) {
        return true;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void a(X var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 8[WHILELOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
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

    private static void a(X x2, double d2, Rectangle rectangle) {
        Object object;
        boolean bl2 = n;
        AffineTransform affineTransform = new AffineTransform();
        double d3 = rectangle.x + rectangle.width / 2;
        double d4 = rectangle.y + rectangle.height / 2;
        Point2D.Double double_ = new Point2D.Double();
        affineTransform.translate(d3, d4);
        affineTransform.rotate(e.a(d2));
        affineTransform.translate(- d3, - d4);
        Object object2 = x2.o();
        while (object2.f()) {
            object = object2.e();
            double_.setLocation(x2.j((y.c.q)object), x2.k((y.c.q)object));
            affineTransform.transform(double_, double_);
            x2.a((y.c.q)object, double_.getX(), double_.getY());
            object2.g();
            if (!bl2) continue;
        }
        object2 = new ArrayList();
        object = x2.p();
        block1 : do {
            if (!object.f()) return;
            d d5 = object.a();
            object2.clear();
            u u2 = x2.j(d5).b();
            while (u2.f()) {
                t t2 = u2.a();
                double_.setLocation(t2.a(), t2.b());
                affineTransform.transform(double_, double_);
                object2.add(new t(double_.getX(), double_.getY()));
                u2.g();
                if (bl2) continue block1;
                if (!bl2) continue;
            }
            x2.b(d5, new v((List)object2));
            object.g();
        } while (!bl2);
    }

    public static double a(X x2, double d2, double d3) {
        double d4 = a.b(x2, d2, d3);
        a.a(x2, d4, x2.a());
        return d4;
    }

    public static double b(X x2, double d2, double d3) {
        double d4;
        boolean bl2 = n;
        if (x2.f() <= 1) return 0.0;
        D d5 = a.d(x2);
        double d6 = Double.MAX_VALUE;
        double d7 = 0.0;
        for (double d8 = 0.0; d8 < 360.0; d8 += 10.0) {
            double d9;
            q q2 = a.a(d5, d8);
            d4 = d9 = Math.abs(q2.a() * d3 - d2 * q2.b());
            if (bl2) return d4;
            if (d4 >= d6) continue;
            d6 = d9;
            d7 = d8;
            if (!bl2) continue;
        }
        d4 = d7;
        return d4;
    }

    /*
     * Unable to fully structure code
     */
    public static void a(X var0, double var1_1, double var3_2, double var5_3, double var7_4) {
        block7 : {
            var36_5 = a.n;
            var9_6 = new Rectangle2D.Double(var1_1, var3_2, var5_3, var7_4);
            if (var0.e() == 0) {
                return;
            }
            var10_7 = Double.MAX_VALUE;
            var12_8 = Double.MAX_VALUE;
            var14_9 = -1.7976931348623157E308;
            var16_10 = -1.7976931348623157E308;
            var18_11 = var0.o();
            while (var18_11.f()) {
                var19_13 = var18_11.e();
                v0 = var0.p(var19_13);
                v1 = var5_3;
                if (!var36_5) {
                    if (v0 > v1) return;
                    if (var0.q(var19_13) > var7_4) {
                        return;
                    }
                    var10_7 = Math.min(var10_7, var0.j(var19_13));
                    var12_8 = Math.min(var12_8, var0.k(var19_13));
                    var14_9 = Math.max(var14_9, var0.j(var19_13));
                    var16_10 = Math.max(var16_10, var0.k(var19_13));
                    var18_11.g();
                    if (!var36_5) continue;
                }
                break block7;
            }
            v0 = var10_7;
            v1 = (var14_9 - var10_7) / 2.0;
        }
        var18_12 = v0 + v1;
        var20_14 = var12_8 + (var16_10 - var12_8) / 2.0;
        var5_3 /= 2.0;
        var7_4 /= 2.0;
        var22_15 = 1.0;
        var24_16 = 1.0;
        var34_17 = var0.o();
        while (var34_17.f()) {
            var35_19 = var34_17.e();
            var26_20 = Math.abs(var18_12 - var0.j(var35_19));
            var28_21 = Math.abs(var20_14 - var0.k(var35_19));
            var30_22 = var5_3 - var0.p(var35_19) / 2.0;
            var32_18 = var7_4 - var0.q(var35_19) / 2.0;
            var22_15 = Math.min(var22_15, var30_22 / var26_20);
            var24_16 = Math.min(var24_16, var32_18 / var28_21);
            var34_17.g();
            if (!var36_5) {
                if (!var36_5) continue;
            }
            ** GOTO lbl-1000
        }
        if (var22_15 < 1.0 || var24_16 < 1.0) lbl-1000: // 2 sources:
        {
            var34_17 = new a();
            var34_17.a(3);
            var34_17.a(var22_15, var24_16);
            var34_17.g(false);
            var34_17.a(var0);
        }
        if (var9_6.contains((Rectangle2D)(var34_17 = ae.a(var0, var0.o(), var0.p()))) != false) return;
        ae.a(var0, var0.o(), var9_6.getCenterX() - var34_17.getCenterX(), var9_6.getCenterY() - var34_17.getCenterY());
    }

    public static void c(X x2, double d2, double d3) {
        Object object;
        boolean bl2 = n;
        Object object2 = x2.o();
        while (object2.f()) {
            object = object2.e();
            x2.a((y.c.q)object, x2.j((y.c.q)object) + d2, x2.k((y.c.q)object) + d3);
            object2.g();
            if (!bl2) continue;
        }
        object2 = new ArrayList();
        object = x2.p();
        block1 : do {
            if (!object.f()) return;
            d d4 = object.a();
            object2.clear();
            u u2 = x2.j(d4).b();
            while (u2.f()) {
                t t2 = u2.a();
                object2.add(new t(t2.a + d2, t2.b + d3));
                u2.g();
                if (bl2) continue block1;
                if (!bl2) continue;
            }
            x2.b(d4, new v((List)object2));
            object.g();
        } while (!bl2);
    }

    private static t a(t t2, Rectangle rectangle) {
        return new t(t2.a, (double)(2 * rectangle.y + rectangle.height) - t2.b);
    }

    private static t b(t t2, Rectangle rectangle) {
        return new t((double)(2 * rectangle.x + rectangle.width) - t2.a, t2.b);
    }

    private static D d(X x2) {
        x x3;
        D d2;
        Object object;
        boolean bl2;
        X x4;
        block4 : {
            bl2 = n;
            d2 = new D();
            x3 = x2.o();
            while (x3.f()) {
                x4 = x2;
                if (!bl2) {
                    object = x4.h(x3.e());
                    d2.add(new t(object.getX() + object.getWidth() / 2.0, object.getY() + object.getHeight() / 2.0));
                    x3.g();
                    if (!bl2) continue;
                }
                break block4;
            }
            x4 = x2;
        }
        x3 = x4.p();
        block1 : do {
            if (!x3.f()) return e.a(d2);
            object = x2.g(x3.a());
            for (int i2 = 0; i2 < object.pointCount(); ++i2) {
                d2.add(object.getPoint(i2));
                if (bl2) continue block1;
                if (!bl2) continue;
            }
            x3.g();
        } while (!bl2);
        return e.a(d2);
    }

    private static q a(D d2, double d3) {
        boolean bl2 = n;
        d3 = e.a(d3);
        double d4 = Double.MAX_VALUE;
        double d5 = -1.7976931348623157E308;
        double d6 = Double.MAX_VALUE;
        double d7 = -1.7976931348623157E308;
        double d8 = Math.cos(d3);
        double d9 = Math.sin(d3);
        C c2 = d2.m();
        do {
            if (!c2.f()) return new q(d5 - d4, d7 - d6);
            t t2 = (t)c2.d();
            double d10 = t2.a() * d8 - t2.b() * d9;
            double d11 = t2.a() * d9 + t2.b() * d8;
            if (d10 < d4) {
                d4 = d10;
            }
            if (d11 < d6) {
                d6 = d11;
            }
            if (d10 > d5) {
                d5 = d10;
            }
            if (d11 > d7) {
                d7 = d11;
            }
            c2.g();
        } while (!bl2);
        return new q(d5 - d4, d7 - d6);
    }
}

