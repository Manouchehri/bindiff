/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.Cursor;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import y.c.q;
import y.c.x;
import y.d.r;
import y.d.y;
import y.h.a.v;
import y.h.az;
import y.h.b.a;
import y.h.b.aa;
import y.h.b.ac;
import y.h.b.ad;
import y.h.b.ae;
import y.h.b.c;
import y.h.b.d;
import y.h.b.f;
import y.h.b.g;
import y.h.b.i;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dw;
import y.h.fj;
import y.h.z;

public class X
extends ae {
    private byte j = 2;
    protected i a = null;
    protected f b = null;
    protected f c = null;
    protected c d = null;
    protected c e = null;
    private byte k = 0;
    private double l = 5.0;
    private double m;
    private double n;
    private Rectangle2D o;
    private Rectangle2D p;
    private Rectangle2D q;
    private double r;
    private double s;
    protected double f;
    protected double g;
    private ad t = new ad();
    private ad u = new ad();
    private ad v = new ad();
    private ac w;
    private ac x;
    private ac y;
    private boolean z = true;
    private boolean A;
    private aa B = new aa();

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean a(double var1_1, double var3_2) {
        block25 : {
            var18_3 = a.H;
            this.l();
            if (this.h == null || this.i == null || (var6_5 = (var5_4 = new cW(this.h, var1_1, var3_2, true)).i()) == null || (var7_6 = this.h.getGraph2D()) == null || X.a(var7_6, var6_5) != this.i) ** GOTO lbl-1000
            var8_7 = this.a(new y(this.i.getX(), this.i.getY(), this.i.getWidth(), this.i.getHeight()), var1_1, var3_2, this.k());
            if (var8_7 == 0) ** GOTO lbl48
            this.k = var8_7;
            this.a = this.i.l();
            switch (var8_7) {
                case 1: {
                    var9_8 = this.i.l().c(0);
                    while (!var9_8.o().isEmpty()) {
                        var9_8 = var9_8.c(0);
                        if (var18_3 == 0) {
                            if (var18_3 == 0) continue;
                        }
                        ** GOTO lbl17
                    }
                    this.b = var9_8;
lbl17: // 2 sources:
                    if (var18_3 == 0) return true;
                }
                case 3: {
                    var10_10 = this.i.l().o();
                    var9_8 = (f)var10_10.get(var10_10.size() - 1);
                    while (!var9_8.o().isEmpty()) {
                        var10_10 = var9_8.o();
                        var9_8 = (f)var10_10.get(var10_10.size() - 1);
                        if (var18_3 == 0) {
                            if (var18_3 == 0) continue;
                        }
                        ** GOTO lbl28
                    }
                    this.b = var9_8;
lbl28: // 2 sources:
                    if (var18_3 == 0) return true;
                }
                case 2: {
                    var11_12 = this.i.l().b(0);
                    while (!var11_12.l().isEmpty()) {
                        var11_12 = var11_12.b(0);
                        if (var18_3 == 0) {
                            if (var18_3 == 0) continue;
                        }
                        ** GOTO lbl37
                    }
                    this.d = var11_12;
lbl37: // 2 sources:
                    if (var18_3 == 0) return true;
                }
                case 4: {
                    var10_10 = this.i.l().l();
                    var11_12 = (c)var10_10.get(var10_10.size() - 1);
                    while (!var11_12.l().isEmpty()) {
                        var10_10 = var11_12.l();
                        var11_12 = (c)var10_10.get(var10_10.size() - 1);
                        if (var18_3 != 0) return true;
                        if (var18_3 == 0) continue;
                    }
                    this.d = var11_12;
                }
            }
            return true;
lbl48: // 1 sources:
            var9_9 = this.i.l().a(var1_1, var3_2);
            if (var9_9 == null || (var11_13 = this.a(new y((var10_11 = var9_9.h()).getX(), var10_11.getY(), var10_11.getWidth(), var10_11.getHeight()), var1_1, var3_2, this.k())) != 3) ** GOTO lbl63
            this.k = 3;
            var12_15 = var9_9;
            while (!var12_15.o().isEmpty()) {
                var13_17 = var12_15.o();
                var12_15 = (f)var13_17.get(var13_17.size() - 1);
                if (var18_3 == 0) {
                    if (var18_3 == 0) continue;
                }
                break block25;
            }
            this.b = var12_15;
        }
        var13_17 = null;
        var14_19 = var12_15;
        ** GOTO lbl80
lbl63: // 1 sources:
        var10_11 = this.i.l().b(var1_1, var3_2);
        if (var10_11 != null && (var12_16 = this.a(new y((var11_14 = var10_11.h()).getX(), var11_14.getY(), var11_14.getWidth(), var11_14.getHeight()), var1_1, var3_2, this.k())) == 4) {
            block26 : {
                this.k = 4;
                var13_18 = var10_11;
                while (!var13_18.l().isEmpty()) {
                    var14_22 = var13_18.l();
                    var13_18 = (c)var14_22.get(var14_22.size() - 1);
                    if (var18_3 == 0) {
                        if (var18_3 == 0) continue;
                    }
                    break block26;
                }
                this.d = var13_18;
            }
            var14_23 = null;
            var15_29 = var13_18;
        } else lbl-1000: // 2 sources:
        {
            this.i();
            return false;
lbl80: // 2 sources:
            while (var14_20 instanceof f) {
                var15_28 = (f)var14_20;
                var16_30 = var15_28.b();
                if (var15_28.a().n() > var16_30 + 1) {
                    var13_17 = var15_28.a().c(var16_30 + 1);
                    break;
                }
                var14_21 = var15_28.a();
            }
            if (var13_17 == null) return true;
            while (var13_17.n() > 0) {
                var13_17 = var13_17.c(0);
                if (var18_3 != 0) return true;
                if (var18_3 == 0) continue;
            }
            this.c = var13_17;
            return true;
        }
        while (var15_29 instanceof c) {
            var16_31 = (c)var15_29;
            var17_32 = var16_31.b();
            if (var16_31.a().k() > var17_32 + 1) {
                var14_24 = var16_31.a().b(var17_32 + 1);
                break;
            }
            var15_29 = var16_31.a();
        }
        if (var14_25 == null) return true;
        while (var14_26.k() > 0) {
            var14_27 = var14_26.b(0);
            if (var18_3 != 0) return true;
            if (var18_3 == 0) continue;
        }
        this.e = var14_26;
        return true;
    }

    protected boolean d(dw dw2) {
        if ((dw2.d() & 64) == 0) return false;
        return true;
    }

    private byte a(y y2, double d2, double d3, double d4) {
        y y3 = new y(y2.c - d4, y2.d - d4, 2.0 * d4, y2.b + 2.0 * d4);
        if (y3.a(d2, d3)) {
            return 2;
        }
        y3 = new y(y2.c + y2.a - d4, y2.d - d4, 2.0 * d4, y2.b + 2.0 * d4);
        if (y3.a(d2, d3)) {
            return 4;
        }
        y3 = new y(y2.c - d4, y2.d - d4, y2.a + 2.0 * d4, 2.0 * d4);
        if (y3.a(d2, d3)) {
            return 1;
        }
        y3 = new y(y2.c - d4, y2.d + y2.b - d4, y2.a + 2.0 * d4, y2.b + 2.0 * d4);
        if (!y3.a(d2, d3)) return 0;
        return 3;
    }

    private void l() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.k = 0;
        this.a = null;
        this.A = false;
    }

    private void a(bu bu2, a a2) {
        int n2 = a.H;
        this.r = -1.7976931348623157E308;
        this.s = Double.MAX_VALUE;
        switch (this.k) {
            case 1: {
                if (this.b == null) return;
                this.s = this.a(bu2, a2, this.b);
                if (n2 == 0) return;
            }
            case 3: {
                if (this.b != null) {
                    this.r = - this.b(bu2, a2, this.b);
                }
                if (!this.A) return;
                if (this.c == null) return;
                this.s = this.a(bu2, a2, this.c);
                if (n2 == 0) return;
            }
            case 2: {
                if (this.d == null) return;
                this.s = this.a(bu2, a2, this.d);
                if (n2 == 0) return;
            }
            case 4: {
                if (this.d != null) {
                    this.r = - this.b(bu2, a2, this.d);
                }
                if (!this.A) return;
                if (this.e == null) return;
                this.s = this.a(bu2, a2, this.e);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private double a(bu var1_1, a var2_2, f var3_3) {
        block9 : {
            var15_4 = a.H;
            var4_5 = var3_3.g() - this.B.a(var3_3);
            var6_6 = var3_3.i();
            if (var1_1 == null || var2_2 == null) ** GOTO lbl45
            var7_7 = var3_3.h();
            var8_8 = var7_7.getMinY();
            if (var6_6 != null) {
                var8_8 += var6_6.a;
            }
            if (3 != (var10_9 = this.h())) ** GOTO lbl28
            var11_10 = true;
            var12_12 = var3_3;
            while (var12_12 instanceof f) {
                var13_13 = var12_12;
                var12_12 = var13_13.a();
                v0 = var11_10;
                if (var15_4 == 0) {
                    var11_10 = v0 & var13_13.b() == 0;
                    if (var15_4 == 0) continue;
                }
                break block9;
            }
            v0 = var11_10;
        }
        if (!v0 || (var13_13 = X.b(var1_1, var2_2)).getWidth() <= 0.0 || var13_13.getHeight() <= 0.0) ** GOTO lbl45
        if (var13_13.getY() < var8_8) {
            return 0.0;
        }
        if (var4_5 <= var13_13.getY() - var8_8) ** GOTO lbl45
        var4_5 = var13_13.getY() - var8_8;
        if (var15_4 == 0) ** GOTO lbl45
lbl28: // 2 sources:
        var11_11 = var3_3.d().a();
        while (var11_11.f()) {
            var12_12 = var1_1.t(var11_11.e());
            v1 = 0.0;
            if (var15_4 != 0) return v1;
            var13_14 = v1;
            if (1 != var10_9) ** GOTO lbl-1000
            var13_14 = var12_12.getCenterY();
            if (var15_4 != 0) lbl-1000: // 2 sources:
            {
                if (2 == var10_9) {
                    var13_14 = var12_12.getY();
                }
            }
            if (var13_14 < var8_8) {
                return 0.0;
            }
            if (var13_14 - var8_8 < var4_5) {
                var4_5 = var13_14 - var8_8;
            }
            var11_11.g();
            if (var15_4 == 0) continue;
        }
lbl45: // 6 sources:
        v1 = var4_5;
        return v1;
    }

    /*
     * Unable to fully structure code
     */
    private double b(bu var1_1, a var2_2, f var3_3) {
        block9 : {
            var15_4 = a.H;
            var4_5 = var3_3.g() - this.B.a(var3_3);
            var6_6 = var3_3.i();
            if (var1_1 == null || var2_2 == null) ** GOTO lbl45
            var7_7 = var3_3.h();
            var8_8 = var7_7.getMaxY();
            if (var6_6 != null) {
                var8_8 -= var6_6.c;
            }
            if (3 != (var10_9 = this.h())) ** GOTO lbl28
            var11_10 = true;
            var12_12 = var3_3;
            while (var12_12 instanceof f) {
                var13_13 = var12_12;
                var12_12 = var13_13.a();
                v0 = var11_10;
                if (var15_4 == 0) {
                    var11_10 = v0 & var13_13.b() == var12_12.n() - 1;
                    if (var15_4 == 0) continue;
                }
                break block9;
            }
            v0 = var11_10;
        }
        if (!v0 || (var13_13 = X.b(var1_1, var2_2)).getWidth() <= 0.0 || var13_13.getHeight() <= 0.0) ** GOTO lbl45
        if (var13_13.getMaxY() > var8_8) {
            return 0.0;
        }
        if (var4_5 <= var8_8 - var13_13.getMaxY()) ** GOTO lbl45
        var4_5 = var8_8 - var13_13.getMaxY();
        if (var15_4 == 0) ** GOTO lbl45
lbl28: // 2 sources:
        var11_11 = var3_3.d().a();
        while (var11_11.f()) {
            var12_12 = var1_1.t(var11_11.e());
            v1 = 0.0;
            if (var15_4 != 0) return v1;
            var13_14 = v1;
            if (var10_9 != 1) ** GOTO lbl-1000
            var13_14 = var12_12.getCenterY();
            if (var15_4 != 0) lbl-1000: // 2 sources:
            {
                if (var10_9 == 2) {
                    var13_14 = var12_12.getY() + var12_12.getHeight();
                }
            }
            if (var13_14 > var8_8) {
                return 0.0;
            }
            if (var8_8 - var13_14 < var4_5) {
                var4_5 = var8_8 - var13_14;
            }
            var11_11.g();
            if (var15_4 == 0) continue;
        }
lbl45: // 6 sources:
        v1 = var4_5;
        return v1;
    }

    /*
     * Unable to fully structure code
     */
    private double a(bu var1_1, a var2_2, c var3_3) {
        block9 : {
            var15_4 = a.H;
            var4_5 = var3_3.g() - this.B.a(var3_3);
            var6_6 = var3_3.i();
            if (var1_1 == null || var2_2 == null) ** GOTO lbl45
            var7_7 = var3_3.h();
            var8_8 = var7_7.getMinX();
            if (var6_6 != null) {
                var8_8 += var6_6.b;
            }
            if (3 != (var10_9 = this.h())) ** GOTO lbl28
            var11_10 = true;
            var12_12 = var3_3;
            while (var12_12 instanceof c) {
                var13_13 = var12_12;
                var12_12 = var13_13.a();
                v0 = var11_10;
                if (var15_4 == 0) {
                    var11_10 = v0 & var13_13.b() == 0;
                    if (var15_4 == 0) continue;
                }
                break block9;
            }
            v0 = var11_10;
        }
        if (!v0 || (var13_13 = X.b(var1_1, var2_2)).getWidth() <= 0.0 || var13_13.getHeight() <= 0.0) ** GOTO lbl45
        if (var13_13.getX() < var8_8) {
            return 0.0;
        }
        if (var4_5 <= var13_13.getX() - var8_8) ** GOTO lbl45
        var4_5 = var13_13.getX() - var8_8;
        if (var15_4 == 0) ** GOTO lbl45
lbl28: // 2 sources:
        var11_11 = var3_3.d().a();
        while (var11_11.f()) {
            var12_12 = var11_11.e();
            v1 = 0.0;
            if (var15_4 != 0) return v1;
            var13_14 = v1;
            if (var10_9 != 1) ** GOTO lbl-1000
            var13_14 = var1_1.t((q)var12_12).getCenterX();
            if (var15_4 != 0) lbl-1000: // 2 sources:
            {
                if (var10_9 == 2) {
                    var13_14 = var1_1.t((q)var12_12).getX();
                }
            }
            if (var13_14 < var8_8) {
                return 0.0;
            }
            if (var13_14 - var8_8 < var4_5) {
                var4_5 = var13_14 - var8_8;
            }
            var11_11.g();
            if (var15_4 == 0) continue;
        }
lbl45: // 6 sources:
        v1 = var4_5;
        return v1;
    }

    /*
     * Unable to fully structure code
     */
    private double b(bu var1_1, a var2_2, c var3_3) {
        block9 : {
            var15_4 = a.H;
            var4_5 = var3_3.g() - this.B.a(var3_3);
            var6_6 = var3_3.i();
            if (var1_1 == null || var2_2 == null) ** GOTO lbl45
            var7_7 = var3_3.h();
            var8_8 = var7_7.getMaxX();
            if (var6_6 != null) {
                var8_8 -= var6_6.d;
            }
            if (3 != (var10_9 = this.h())) ** GOTO lbl28
            var11_10 = true;
            var12_12 = var3_3;
            while (var12_12 instanceof c) {
                var13_13 = var12_12;
                var12_12 = var13_13.a();
                v0 = var11_10;
                if (var15_4 == 0) {
                    var11_10 = v0 & var13_13.b() == var12_12.k() - 1;
                    if (var15_4 == 0) continue;
                }
                break block9;
            }
            v0 = var11_10;
        }
        if (!v0 || (var13_13 = X.b(var1_1, var2_2)).getWidth() <= 0.0 || var13_13.getHeight() <= 0.0) ** GOTO lbl45
        if (var13_13.getMaxX() > var8_8) {
            return 0.0;
        }
        if (var4_5 <= var8_8 - var13_13.getMaxX()) ** GOTO lbl45
        var4_5 = var8_8 - var13_13.getMaxX();
        if (var15_4 == 0) ** GOTO lbl45
lbl28: // 2 sources:
        var11_11 = var3_3.d().a();
        while (var11_11.f()) {
            var12_12 = var11_11.e();
            v1 = 0.0;
            if (var15_4 != 0) return v1;
            var13_14 = v1;
            if (var10_9 != 1) ** GOTO lbl-1000
            var13_14 = var1_1.t((q)var12_12).getCenterX();
            if (var15_4 != 0) lbl-1000: // 2 sources:
            {
                if (var10_9 == 2) {
                    var13_14 = var1_1.t((q)var12_12).getX() + var1_1.t((q)var12_12).getWidth();
                }
            }
            if (var13_14 > var8_8) {
                return 0.0;
            }
            if (var8_8 - var13_14 < var4_5) {
                var4_5 = var8_8 - var13_14;
            }
            var11_11.g();
            if (var15_4 == 0) continue;
        }
lbl45: // 6 sources:
        v1 = var4_5;
        return v1;
    }

    private static Rectangle2D b(bu bu2, a a2) {
        int n2 = a.H;
        Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        v v2 = bu2.C();
        if (v2 == null) return double_;
        q q2 = a2.getNode();
        if (q2 == null) return double_;
        if (q2.e() != bu2) return double_;
        if (!v2.k(q2)) return double_;
        x x2 = v2.p(q2);
        do {
            if (!x2.f()) return double_;
            bu2.t(x2.e()).calcUnionRect(double_);
            x2.g();
        } while (n2 == 0);
        return double_;
    }

    /*
     * Exception decompiling
     */
    protected void a(double var1_1, double var3_2, boolean var5_3) {
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

    protected void b(double d2, double d3) {
        int n2 = a.H;
        this.f = Math.min(Math.max(d2 - this.m, this.r), this.s);
        this.g = Math.min(Math.max(d3 - this.n, this.r), this.s);
        switch (this.k) {
            case 1: {
                this.t.a(this.a(this.b, (Rectangle2D)new Rectangle2D.Double(this.o.getX(), this.o.getY() + this.g, this.o.getWidth(), this.o.getHeight() - this.g)));
                if (!this.j()) break;
                this.v.a(this.a(this.a, (Rectangle2D)new Rectangle2D.Double(this.q.getX(), this.q.getY() + this.g, this.q.getWidth(), this.q.getHeight() - this.g)));
                if (n2 == 0) break;
            }
            case 3: {
                this.t.a(this.a(this.b, (Rectangle2D)new Rectangle2D.Double(this.o.getX(), this.o.getY(), this.o.getWidth(), this.o.getHeight() + this.g)));
                if (this.A) {
                    this.u.a(this.a(this.c, (Rectangle2D)new Rectangle2D.Double(this.p.getX(), this.p.getY() + this.g, this.p.getWidth(), this.p.getHeight() - this.g)));
                    if (n2 == 0) break;
                }
                if (!this.j()) break;
                this.v.a(this.a(this.a, (Rectangle2D)new Rectangle2D.Double(this.q.getX(), this.q.getY(), this.q.getWidth(), this.q.getHeight() + this.g)));
                if (n2 == 0) break;
            }
            case 2: {
                this.t.a(this.a(this.d, (Rectangle2D)new Rectangle2D.Double(this.o.getX() + this.f, this.o.getY(), this.o.getWidth() - this.f, this.o.getHeight())));
                if (!this.j()) break;
                this.v.a(this.a(this.a, (Rectangle2D)new Rectangle2D.Double(this.q.getX() + this.f, this.q.getY(), this.q.getWidth() - this.f, this.q.getHeight())));
                if (n2 == 0) break;
            }
            case 4: {
                this.t.a(this.a(this.d, (Rectangle2D)new Rectangle2D.Double(this.o.getX(), this.o.getY(), this.o.getWidth() + this.f, this.o.getHeight())));
                if (this.A) {
                    this.u.a(this.a(this.e, (Rectangle2D)new Rectangle2D.Double(this.p.getX() + this.f, this.p.getY(), this.p.getWidth() - this.f, this.p.getHeight())));
                    if (n2 == 0) break;
                }
                if (!this.j()) break;
                this.v.a(this.a(this.a, (Rectangle2D)new Rectangle2D.Double(this.q.getX(), this.q.getY(), this.q.getWidth() + this.f, this.q.getHeight())));
            }
        }
        this.h.getGraph2D().T();
    }

    protected void c(double d2, double d3) {
        this.g();
        this.m();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void g() {
        int n2 = a.H;
        if (this.i == null) {
            return;
        }
        q q2 = this.i.getNode();
        bu bu2 = (bu)q2.e();
        if (bu2 == null) return;
        if (this.b == null && this.d == null) {
            return;
        }
        bu2.r();
        try {
            ArrayList arrayList;
            bu2.a(new y.c.y(q2).a());
            fj fj2 = X.a(bu2, q2);
            if (fj2 == this.i) {
                if (this.b != null) {
                    this.a(bu2, this.i, this.b, this.c);
                    if (n2 == 0) return;
                }
                if (this.d == null) return;
                this.a(bu2, this.i, this.d, this.e);
                if (n2 == 0) return;
            }
            if (!(fj2 instanceof a)) return;
            a a2 = (a)fj2;
            if (this.b != null) {
                arrayList = new ArrayList();
                this.a(bu2, a2, aa.a(this.b, a2, arrayList), this.c == null ? null : aa.a(this.c, a2, arrayList));
                if (n2 == 0) return;
            }
            if (this.d == null) return;
            arrayList = new ArrayList();
            this.a(bu2, a2, aa.a(this.d, a2, arrayList), this.e == null ? null : aa.a(this.e, a2, arrayList));
            return;
        }
        finally {
            bu2.s();
        }
    }

    /*
     * Unable to fully structure code
     */
    private void a(bu var1_1, a var2_2, c var3_3, c var4_4) {
        var8_5 = a.H;
        if (3 != this.h()) ** GOTO lbl50
        switch (this.k) {
            case 2: {
                var3_3.b(var3_3.g() - this.f);
                if (var3_3.b() != 0) break;
                var5_6 = true;
                var6_9 = var3_3.a();
                while (var6_9 instanceof c) {
                    var7_10 = (c)var6_9;
                    var7_10.b(var7_10.g() - this.f);
                    var6_9 = var7_10.a();
                    v0 = var5_6;
                    if (var8_5 == 0) {
                        var5_6 = v0 & var7_10.b() == 0;
                        if (var8_5 == 0) continue;
                    }
                    ** GOTO lbl19
                }
                v0 = var5_6;
lbl19: // 2 sources:
                if (!v0) break;
                X.a(var2_2, var2_2.getX() + this.f, var2_2.getY(), var2_2.getWidth() - this.f, var2_2.getHeight());
                if (var8_5 == 0) break;
            }
            case 4: {
                var3_3.b(var3_3.g() + this.f);
                if (var3_3.b() != var3_3.a().k() - 1) ** GOTO lbl39
                var5_6 = true;
                var6_9 = var3_3.a();
                while (var6_9 instanceof c) {
                    var7_10 = (c)var6_9;
                    var7_10.b(var7_10.g() + this.f);
                    var6_9 = var7_10.a();
                    v1 = var5_6;
                    if (var8_5 == 0) {
                        var5_6 = v1 & var7_10.b() == var6_9.k() - 1;
                        if (var8_5 == 0) continue;
                    }
                    ** GOTO lbl37
                }
                v1 = var5_6;
lbl37: // 2 sources:
                if (v1) {
                    X.a(var2_2, var2_2.getX(), var2_2.getY(), var2_2.getWidth() + this.f, var2_2.getHeight());
                }
lbl39: // 4 sources:
                if (!this.A) break;
                var4_4.b(var4_4.g() - this.f);
                if (var4_4.b() != 0) break;
                var5_7 = var4_4.a();
                while (var5_7 instanceof c) {
                    var6_9 = (c)var5_7;
                    var6_9.b(var6_9.g() - this.f);
                    var5_7 = var6_9.a();
                    if (var8_5 != 0) return;
                    if (var8_5 == 0) continue;
                }
                break block0;
            }
        }
        if (var8_5 == 0) return;
lbl50: // 2 sources:
        switch (this.k) {
            case 2: {
                this.B.a(var3_3, var3_3.g() - this.f, true);
                var5_8 = new y.c.y();
                this.B.a(var2_2.getNode(), (Rectangle2D)var2_2.getBoundingBox(), (Collection)var5_8);
                var6_9 = new z();
                this.B.a(var1_1, (Rectangle2D)var2_2.getBoundingBox(), (Collection)var6_9);
                var2_2.setFrame(var2_2.getX() + this.f, var2_2.getY(), var2_2.getWidth(), var2_2.getHeight());
                this.B.a(var1_1, var5_8, (z)var6_9, this.f, 0.0);
                if (var8_5 == 0) return;
            }
            case 4: {
                this.B.a(var3_3, var3_3.g() + this.f, false);
                if (this.A == false) return;
                this.B.a(var4_4, var4_4.g() - this.f, true);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void a(bu var1_1, a var2_2, f var3_3, f var4_4) {
        var8_5 = a.H;
        if (3 != this.h()) ** GOTO lbl50
        switch (this.k) {
            case 1: {
                var3_3.b(var3_3.g() - this.g);
                if (var3_3.b() != 0) break;
                var5_6 = true;
                var6_9 = var3_3.a();
                while (var6_9 instanceof f) {
                    var7_10 = (f)var6_9;
                    var7_10.b(var7_10.g() - this.g);
                    var6_9 = var7_10.a();
                    v0 = var5_6;
                    if (var8_5 == 0) {
                        var5_6 = v0 & var7_10.b() == 0;
                        if (var8_5 == 0) continue;
                    }
                    ** GOTO lbl19
                }
                v0 = var5_6;
lbl19: // 2 sources:
                if (!v0) break;
                X.a(var2_2, var2_2.getX(), var2_2.getY() + this.g, var2_2.getWidth(), var2_2.getHeight() - this.g);
                if (var8_5 == 0) break;
            }
            case 3: {
                var3_3.b(var3_3.g() + this.g);
                if (var3_3.b() != var3_3.a().n() - 1) ** GOTO lbl39
                var5_6 = true;
                var6_9 = var3_3.a();
                while (var6_9 instanceof f) {
                    var7_10 = (f)var6_9;
                    var7_10.b(var7_10.g() + this.g);
                    var6_9 = var7_10.a();
                    v1 = var5_6;
                    if (var8_5 == 0) {
                        var5_6 = v1 & var7_10.b() == var6_9.n() - 1;
                        if (var8_5 == 0) continue;
                    }
                    ** GOTO lbl37
                }
                v1 = var5_6;
lbl37: // 2 sources:
                if (v1) {
                    X.a(var2_2, var2_2.getX(), var2_2.getY(), var2_2.getWidth(), var2_2.getHeight() + this.g);
                }
lbl39: // 4 sources:
                if (!this.A) break;
                var4_4.b(var4_4.g() - this.g);
                if (var4_4.b() != 0) break;
                var5_7 = var4_4.a();
                while (var5_7 instanceof f) {
                    var6_9 = (f)var5_7;
                    var6_9.b(var6_9.g() - this.g);
                    var5_7 = var6_9.a();
                    if (var8_5 != 0) return;
                    if (var8_5 == 0) continue;
                }
                break block0;
            }
        }
        if (var8_5 == 0) return;
lbl50: // 2 sources:
        switch (this.k) {
            case 1: {
                this.B.a(var3_3, var3_3.g() - this.g, true);
                var5_8 = new y.c.y();
                this.B.a(var2_2.getNode(), (Rectangle2D)var2_2.getBoundingBox(), (Collection)var5_8);
                var6_9 = new z();
                this.B.a(var1_1, (Rectangle2D)var2_2.getBoundingBox(), (Collection)var6_9);
                var2_2.setFrame(var2_2.getX(), var2_2.getY() + this.g, var2_2.getWidth(), var2_2.getHeight());
                this.B.a(var1_1, var5_8, (z)var6_9, 0.0, this.g);
                if (var8_5 == 0) return;
            }
            case 3: {
                this.B.a(var3_3, var3_3.g() + this.g, false);
                if (this.A == false) return;
                this.B.a(var4_4, var4_4.g() - this.g, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void a(a a2, double d2, double d3, double d4, double d5) {
        boolean bl2;
        y.h.a.a a3 = a2.getAutoBoundsFeature();
        boolean bl3 = bl2 = a3 != null && a3.isAutoBoundsEnabled();
        if (bl2) {
            a3.setAutoBoundsEnabled(false);
        }
        try {
            boolean bl4 = a2.k();
            if (bl4) {
                a2.c(false);
            }
            try {
                a2.setFrame(d2, d3, d4, d5);
                return;
            }
            finally {
                if (bl4) {
                    a2.c(bl4);
                }
            }
        }
        finally {
            if (bl2) {
                a3.setAutoBoundsEnabled(bl2);
            }
        }
    }

    private void m() {
        this.l();
        if (this.t.a() != null) {
            this.t.a((az)null);
            this.h.removeDrawable(this.t);
        }
        if (this.u.a() != null) {
            this.u.a((az)null);
            this.h.removeDrawable(this.u);
        }
        if (this.v.a() != null) {
            this.v.a((az)null);
            this.h.removeDrawable(this.v);
        }
        this.h.getGraph2D().T();
        this.e();
    }

    /*
     * Unable to fully structure code
     */
    protected az a(i var1_1, Rectangle2D var2_2) {
        if (this.y == null) {
            this.y = new ac();
        }
        if (var1_1 == null) ** GOTO lbl11
        var3_3 = var1_1.d();
        if (var3_3.a <= var3_3.b) ** GOTO lbl-1000
        this.y.a(false);
        this.y.a(var3_3.a);
        if (a.H != 0) lbl-1000: // 2 sources:
        {
            this.y.a(true);
            this.y.a(var3_3.b);
        }
lbl11: // 4 sources:
        this.y.a(var2_2.getX(), var2_2.getY(), var2_2.getWidth(), var2_2.getHeight());
        return this.y;
    }

    /*
     * Unable to fully structure code
     */
    protected az a(f var1_1, Rectangle2D var2_2) {
        var4_3 = a.H;
        if (var1_1 == null || var1_1 != this.b) ** GOTO lbl-1000
        if (this.w == null) {
            this.w = new ac();
        }
        var3_4 = this.w;
        if (var4_3 != 0) lbl-1000: // 2 sources:
        {
            if (var1_1 == null) return null;
            if (var1_1 != this.c) return null;
            if (this.x == null) {
                this.x = new ac();
            }
            var3_4 = this.x;
            if (var4_3 != 0) {
                return null;
            }
        }
        if (var1_1.i() != null) {
            var3_4.a(true);
            var3_4.a(var1_1.i().b);
        }
        var3_4.a(var2_2.getX(), var2_2.getY(), var2_2.getWidth(), var2_2.getHeight());
        return var3_4;
    }

    /*
     * Unable to fully structure code
     */
    protected az a(c var1_1, Rectangle2D var2_2) {
        var4_3 = a.H;
        if (var1_1 == null || var1_1 != this.d) ** GOTO lbl-1000
        if (this.w == null) {
            this.w = new ac();
        }
        var3_4 = this.w;
        if (var4_3 != 0) lbl-1000: // 2 sources:
        {
            if (var1_1 == null) return null;
            if (var1_1 != this.e) return null;
            if (this.x == null) {
                this.x = new ac();
            }
            var3_4 = this.x;
            if (var4_3 != 0) {
                return null;
            }
        }
        if (var1_1.i() != null) {
            var3_4.a(false);
            var3_4.a(var1_1.i().a);
        }
        var3_4.a(var2_2.getX(), var2_2.getY(), var2_2.getWidth(), var2_2.getHeight());
        return var3_4;
    }

    public byte h() {
        return this.j;
    }

    public boolean j() {
        return this.z;
    }

    public double k() {
        return this.l;
    }

    @Override
    public void e() {
        this.h.setViewCursor(Cursor.getPredefinedCursor(13));
        super.e();
    }

    @Override
    public boolean a(dw dw2) {
        if (!this.f(dw2)) return false;
        if (!this.a(dw2.a(), dw2.b())) return false;
        return true;
    }

    @Override
    public void b(dw dw2) {
        int n2 = a.H;
        switch (dw2.c()) {
            case 501: {
                if (!this.e(dw2)) return;
                this.a(dw2.a(), dw2.b(), this.d(dw2));
                if (n2 == 0) return;
            }
            case 506: {
                this.b(dw2.a(), dw2.b());
                if (n2 == 0) return;
            }
            case 502: {
                if (!this.e(dw2)) return;
                this.c(dw2.a(), dw2.b());
                if (n2 == 0) return;
            }
        }
        this.m();
    }

    @Override
    public Cursor c(dw dw2) {
        if (!this.a(dw2.a(), dw2.b())) return null;
        switch (this.k) {
            case 2: 
            case 4: {
                return Cursor.getPredefinedCursor(10);
            }
            case 1: 
            case 3: {
                return Cursor.getPredefinedCursor(8);
            }
        }
        return null;
    }

    @Override
    void i() {
        super.i();
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }
}

