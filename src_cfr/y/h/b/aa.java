/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import y.c.C;
import y.c.e;
import y.c.q;
import y.d.r;
import y.h.a.v;
import y.h.aB;
import y.h.b.a;
import y.h.b.c;
import y.h.b.d;
import y.h.b.f;
import y.h.b.g;
import y.h.b.i;
import y.h.bu;
import y.h.fj;
import y.h.gd;
import y.h.x;
import y.h.y;
import y.h.z;

public class aa {
    private boolean a = true;

    private bu a(a a2) {
        q q2 = a2.getNode();
        if (q2 == null) {
            return null;
        }
        bu bu2 = (bu)q2.e();
        return bu2;
    }

    private boolean b(a a2) {
        y.h.a.a a3 = a2.getAutoBoundsFeature();
        if (a3 == null) return false;
        if (!a3.isAutoBoundsEnabled()) return false;
        return true;
    }

    private void a(a a2, boolean bl2) {
        y.h.a.a a3 = a2.getAutoBoundsFeature();
        if (a3 == null) return;
        a3.setAutoBoundsEnabled(bl2);
    }

    public void a(bu bu2, y.c.y y2, z z2, double d2, double d3) {
        C c2;
        int n2 = a.H;
        if (!y2.isEmpty()) {
            c2 = y2.a();
            while (c2.f()) {
                bu2.t(c2.e()).moveBy(d2, d3);
                c2.g();
                if (n2 != 0) return;
                if (n2 == 0) continue;
            }
        }
        if (z2.isEmpty()) return;
        c2 = z2.b();
        do {
            if (!c2.f()) return;
            x x2 = c2.a();
            x2.a(x2.b() + d2, x2.c() + d3);
            c2.g();
        } while (n2 == 0);
    }

    public void a(q q2, Rectangle2D rectangle2D, Collection collection) {
        if (q2 == null) {
            return;
        }
        bu bu2 = (bu)q2.e();
        bu bu3 = bu2;
        if (bu3 == null) {
            return;
        }
        v v2 = v.a(bu3);
        v v3 = v2;
        if (v3 == null) return;
        if (rectangle2D == null) return;
        if (collection == null) return;
        this.a(v3, q2, rectangle2D, collection);
    }

    public void a(bu bu2, Rectangle2D rectangle2D, Collection collection) {
        int n2 = a.H;
        if (bu2 == null) return;
        if (rectangle2D == null) return;
        if (collection == null) return;
        e e2 = bu2.p();
        do {
            boolean bl2 = e2.f();
            block1 : do {
                if (!bl2) return;
                y.c.d d2 = e2.a();
                y y2 = bu2.i(d2).bends();
                while (y2.f()) {
                    x x2 = y2.a();
                    bl2 = rectangle2D.contains(x2.b(), x2.c());
                    if (n2 != 0) continue block1;
                    if (bl2) {
                        collection.add(x2);
                    }
                    y2.g();
                    if (n2 == 0) continue;
                }
                break block1;
                break;
            } while (true);
            e2.g();
        } while (n2 == 0);
    }

    private void a(q q2, Rectangle2D rectangle2D, Collection collection, Collection collection2) {
        int n2 = a.H;
        this.a(q2, rectangle2D, collection);
        bu bu2 = q2 == null ? null : (bu)q2.e();
        if (!this.a()) return;
        this.a(bu2, rectangle2D, collection2);
        if (n2 == 0) return;
        if (bu2 == null) return;
        if (rectangle2D == null) return;
        if (collection == null) return;
        if (collection2 == null) return;
        HashSet hashSet = new HashSet(collection);
        e e2 = bu2.p();
        do {
            boolean bl2 = e2.f();
            block1 : do {
                if (!bl2) return;
                y.c.d d2 = e2.a();
                if (!hashSet.contains(d2.c()) || !hashSet.contains(d2.d())) break;
                y y2 = bu2.i(d2).bends();
                while (y2.f()) {
                    x x2 = y2.a();
                    bl2 = rectangle2D.contains(x2.b(), x2.c());
                    if (n2 != 0) continue block1;
                    if (bl2) {
                        collection2.add(x2);
                    }
                    y2.g();
                    if (n2 == 0) continue;
                }
                break block1;
                break;
            } while (true);
            e2.g();
        } while (n2 == 0);
    }

    /*
     * Unable to fully structure code
     */
    private void a(v var1_1, q var2_2, Rectangle2D var3_3, Collection var4_4) {
        var11_5 = a.H;
        var5_6 = (bu)var2_2.e();
        var6_7 = var1_1.p(var2_2);
        do {
            block9 : {
                if (var6_7.f() == false) return;
                var7_8 = var6_7.e();
                if (!var1_1.k(var7_8)) ** GOTO lbl-1000
                var8_9 = var1_1.p(var7_8);
                if (!var8_9.f()) ** GOTO lbl-1000
                var9_10 = new LinkedHashSet<E>();
                this.a(var1_1, var7_8, var3_3, (Collection)var9_10);
                var10_11 = true;
                while (var8_9.f()) {
                    v0 = var9_10.contains(var6_7.e());
                    if (var11_5 == 0) {
                        if (!v0) {
                            var10_11 = false;
                            if (var11_5 == 0) break;
                        }
                        var8_9.g();
                        if (var11_5 == 0) continue;
                    }
                    break block9;
                }
                v0 = var10_11;
            }
            if (v0) {
                var4_4.add(var7_8);
            }
            var4_4.addAll(var9_10);
            if (var11_5 != 0) lbl-1000: // 2 sources:
            {
                if (var3_3.contains((var9_10 = var5_6.t(var7_8)).getCenterX(), var9_10.getCenterY())) {
                    var4_4.add(var7_8);
                    ** if (var11_5 == 0) goto lbl34
                }
            }
            ** GOTO lbl34
lbl-1000: // 2 sources:
            {
                if (var3_3.contains((var8_9 = var5_6.t(var7_8)).getCenterX(), var8_9.getCenterY())) {
                    var4_4.add(var7_8);
                }
            }
lbl34: // 5 sources:
            var6_7.g();
        } while (var11_5 == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(c c2, d d2) {
        a a2 = a.a(c2);
        bu bu2 = this.a(a2);
        if (bu2 == null) {
            boolean bl2 = this.b(a2);
            if (bl2) {
                this.a(a2, false);
            }
            try {
                c2.a(d2);
                return;
            }
            finally {
                if (bl2) {
                    this.a(a2, true);
                }
            }
        }
        bu2.r();
        try {
            q q2 = a2.getNode();
            bu2.a(new y.c.y(q2).a());
            fj fj2 = aa.a(bu2, q2);
            if (fj2 == a2) {
                this.a(a2, c2, d2);
                if (a.H == 0) return;
            }
            if (!(fj2 instanceof a)) return;
            a a3 = (a)fj2;
            ArrayList arrayList = new ArrayList();
            this.a(a3, aa.a(c2, a3, arrayList), aa.a(d2, a3, arrayList));
            return;
        }
        finally {
            bu2.s();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void a(a var1_1, c var2_2, d var3_3) {
        var32_4 = a.H;
        var4_5 = this.b(var1_1);
        if (var4_5) {
            this.a(var1_1, false);
        }
        try {
            var5_6 = new y.c.y();
            var6_7 = new z();
            var7_8 = var2_2.h();
            this.a(var1_1.getNode(), var7_8, var5_6, (Collection)var6_7);
            var8_9 = var1_1.t();
            var10_10 = new y.c.y();
            var11_11 = new z();
            this.a(var1_1.getNode(), new Rectangle2D.Double(var1_1.getX(), var1_1.getY() + var8_9, var1_1.getWidth(), var1_1.getHeight() - var8_9), var10_10, (Collection)var11_11);
            var12_12 = var2_2.a();
            var13_13 = 0.0;
            var15_14 = false;
            var16_15 = 0.0;
            if (var12_12 instanceof c) {
                var18_16 = (c)var12_12;
                var13_13 = var18_16.g();
                var15_14 = var18_16.k() == 1;
            }
            var18_16 = var3_3;
            var19_17 = 0.0;
            if (var18_16 instanceof c) {
                var19_17 = ((c)var18_16).g();
            }
            var21_18 = var2_2.g();
            var2_2.a(var18_16);
            var23_19 = var2_2.g();
            if (!(var12_12 instanceof i)) ** GOTO lbl-1000
            var16_15 = var21_18;
            if (var32_4 != 0) lbl-1000: // 2 sources:
            {
                if (var12_12 instanceof c) {
                    var16_15 = var13_13 - ((c)var12_12).g();
                }
            }
            var25_20 = false;
            var26_21 = 0.0;
            if (!(var18_16 instanceof i)) ** GOTO lbl-1000
            var26_21 = var23_19;
            if (var32_4 != 0) lbl-1000: // 2 sources:
            {
                if (var18_16 instanceof c) {
                    var28_22 = (c)var18_16;
                    var26_21 = var28_22.g() - var19_17;
                    var25_20 = var28_22.k() == 1;
                }
            }
            var28_22 = var2_2.h();
            this.a(var1_1, var5_6, var6_7, var18_16, var23_19, var15_14, var25_20, var16_15, var26_21, (Rectangle2D)var28_22, var7_8, true);
            var29_23 = var1_1.t();
            if (var29_23 == var8_9) return;
            this.a(var1_1, var10_10, var11_11, var29_23 - var8_9, false);
            return;
        }
        finally {
            if (var4_5) {
                this.a(var1_1, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(f f2, g g2) {
        a a2 = a.a(f2);
        bu bu2 = this.a(a2);
        if (bu2 == null) {
            boolean bl2 = this.b(a2);
            if (bl2) {
                this.a(a2, false);
            }
            try {
                f2.a(g2);
                return;
            }
            finally {
                if (bl2) {
                    this.a(a2, true);
                }
            }
        }
        bu2.r();
        try {
            q q2 = a2.getNode();
            bu2.a(new y.c.y(q2).a());
            fj fj2 = aa.a(bu2, q2);
            if (fj2 == a2) {
                this.a(a2, f2, g2);
                if (a.H == 0) return;
            }
            if (!(fj2 instanceof a)) return;
            a a3 = (a)fj2;
            ArrayList arrayList = new ArrayList();
            this.a(a3, aa.a(f2, a3, arrayList), aa.a(g2, a3, arrayList));
            return;
        }
        finally {
            bu2.s();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void a(a var1_1, f var2_2, g var3_3) {
        var32_4 = a.H;
        var4_5 = this.b(var1_1);
        if (var4_5) {
            this.a(var1_1, false);
        }
        try {
            var5_6 = new y.c.y();
            var6_7 = new z();
            var7_8 = var2_2.h();
            this.a(var1_1.getNode(), var7_8, var5_6, (Collection)var6_7);
            var8_9 = var1_1.v();
            var10_10 = new y.c.y();
            var11_11 = new z();
            this.a(var1_1.getNode(), new Rectangle2D.Double(var1_1.getX() + var8_9, var1_1.getY(), var1_1.getWidth() - var8_9, var1_1.getHeight()), var10_10, (Collection)var11_11);
            var12_12 = var2_2.a();
            var13_13 = 0.0;
            var15_14 = false;
            var16_15 = 0.0;
            if (var12_12 instanceof f) {
                var18_16 = (f)var12_12;
                var13_13 = var18_16.g();
                var15_14 = var18_16.n() == 1;
            }
            var18_16 = var3_3;
            var19_17 = 0.0;
            if (var18_16 instanceof f) {
                var19_17 = ((f)var18_16).g();
            }
            var21_18 = var2_2.g();
            var2_2.a(var18_16);
            var23_19 = var2_2.g();
            if (!(var12_12 instanceof i)) ** GOTO lbl-1000
            var16_15 = var21_18;
            if (var32_4 != 0) lbl-1000: // 2 sources:
            {
                if (var12_12 instanceof f) {
                    var16_15 = var13_13 - ((f)var12_12).g();
                }
            }
            var25_20 = false;
            var26_21 = 0.0;
            if (!(var18_16 instanceof i)) ** GOTO lbl-1000
            var26_21 = var23_19;
            if (var32_4 != 0) lbl-1000: // 2 sources:
            {
                if (var18_16 instanceof f) {
                    var28_22 = (f)var18_16;
                    var26_21 = var28_22.g() - var19_17;
                    var25_20 = var28_22.n() == 1;
                }
            }
            var28_22 = var2_2.h();
            this.a(var1_1, var5_6, var6_7, var18_16, var23_19, var15_14, var25_20, var16_15, var26_21, (Rectangle2D)var28_22, var7_8, false);
            var29_23 = var1_1.v();
            if (var29_23 == var8_9) return;
            this.a(var1_1, var10_10, var11_11, var29_23 - var8_9, true);
            return;
        }
        finally {
            if (var4_5) {
                this.a(var1_1, true);
            }
        }
    }

    private void a(a a2, y.c.y y2, z z2, Object object, double d2, boolean bl2, boolean bl3, double d3, double d4, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, boolean bl4) {
        z z3;
        z z4;
        y.c.y y3;
        Object object2;
        int n2 = a.H;
        double d5 = aa.a(rectangle2D, bl4);
        double d6 = aa.a(rectangle2D2, bl4);
        double d7 = aa.b(rectangle2D, bl4);
        double d8 = aa.b(rectangle2D2, bl4);
        double d9 = aa.a(a2, bl4);
        if (bl2) {
            if (bl3) {
                object2 = aa.b(aa.a(object, bl4), bl4) - d4;
                if (d5 > d6) {
                    y3 = new y.c.y();
                    z4 = new z();
                    this.a(a2, (double)object2, d9 - object2, y3, z4, bl4);
                    this.a(a2, y3, z4, d4, bl4);
                    this.a(a2, y2, z2, d5 - d6, bl4);
                    if (n2 == 0) return;
                }
                this.a(a2, y2, z2, d5 - d6, bl4);
                y3 = new y.c.y();
                z4 = new z();
                this.a(a2, (double)object2, d9 - object2, y3, z4, bl4);
                this.a(a2, y3, z4, d4, bl4);
                if (n2 == 0) return;
            }
            if (d5 > d6) {
                y.c.y y4 = new y.c.y();
                z3 = new z();
                this.a(a2, d5, d9 - d5, y4, z3, bl4);
                this.a(a2, y4, z3, d2, bl4);
                this.a(a2, y2, z2, d5 - d6, bl4);
                if (n2 == 0) return;
            }
            y.c.y y5 = new y.c.y();
            z3 = new z();
            this.a(a2, d5, d6 - d5, y5, z3, bl4);
            this.a(a2, y2, z2, d5 - d6, bl4);
            this.a(a2, d7, d9 - d7, y5, z3, bl4);
            this.a(a2, y5, z3, d2, bl4);
            if (n2 == 0) return;
        }
        if (bl3) {
            double d10 = aa.b(aa.a(object, bl4), bl4) - d4;
            if (d5 > d6) {
                y3 = new y.c.y();
                z4 = new z();
                this.a(a2, d8, d10 - d8 + d3, y3, z4, bl4);
                this.a(a2, y3, z4, - d3, bl4);
                y3.clear();
                this.a(a2, d10 + d3, d9 - d10, y3, z4, bl4);
                this.a(a2, y3, z4, d4 - d3, bl4);
                this.a(a2, y2, z2, d5 - d6, bl4);
                if (n2 == 0) return;
            }
            y3 = new y.c.y();
            z4 = new z();
            this.a(a2, d10, d6 - d10, y3, z4, bl4);
            this.a(a2, y3, z4, d4, bl4);
            this.a(a2, y2, z2, d5 - d6, bl4);
            y3.clear();
            this.a(a2, d8, d9 + d3 - d4 - d8, y3, z4, bl4);
            this.a(a2, y3, z4, d4 - d3, bl4);
            if (n2 == 0) return;
        }
        if (d5 > d6) {
            object2 = new y.c.y();
            z3 = new z();
            this.a(a2, d8, d7 - d8, (y.c.y)object2, z3, bl4);
            this.a(a2, y2, z2, d5 - d6, bl4);
            this.a(a2, (y.c.y)object2, z3, - d2, bl4);
            if (n2 == 0) return;
        }
        object2 = new y.c.y();
        z3 = new z();
        this.a(a2, d5, d6 - d5, (y.c.y)object2, z3, bl4);
        this.a(a2, (y.c.y)object2, z3, d2, bl4);
        this.a(a2, y2, z2, d5 - d6, bl4);
    }

    private static double a(Rectangle2D rectangle2D, boolean bl2) {
        if (!bl2) return rectangle2D.getY();
        return rectangle2D.getX();
    }

    private static double b(Rectangle2D rectangle2D, boolean bl2) {
        if (!bl2) return rectangle2D.getMaxY();
        return rectangle2D.getMaxX();
    }

    private static double a(fj fj2, boolean bl2) {
        if (!bl2) return fj2.getY() + fj2.getHeight();
        return fj2.getX() + fj2.getWidth();
    }

    private static Rectangle2D a(Object object, boolean bl2) {
        if (!bl2) return ((f)object).h();
        return ((c)object).h();
    }

    private void a(a a2, double d2, double d3, y.c.y y2, z z2, boolean bl2) {
        if (bl2) {
            this.a(a2.getNode(), new Rectangle2D.Double(d2, a2.getY(), d3, a2.getHeight()), y2, (Collection)z2);
            if (a.H == 0) return;
        }
        this.a(a2.getNode(), new Rectangle2D.Double(a2.getX(), d2, a2.getWidth(), d3), y2, (Collection)z2);
    }

    /*
     * Exception decompiling
     */
    private void a(a var1_1, y.c.y var2_2, z var3_3, double var4_4, boolean var6_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK], 4[WHILELOOP], 3[DOLOOP]], but top level block is 9[SIMPLE_IF_TAKEN]
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(c c2, int n2) {
        int n3 = a.H;
        a a2 = a.a(c2);
        bu bu2 = this.a(a2);
        int n4 = c2.b();
        if (n4 == n2) return;
        if (bu2 == null) {
            c2.a(n2);
            if (n3 == 0) return;
        }
        bu2.r();
        try {
            q q2 = a2.getNode();
            bu2.a(new y.c.y(q2).a());
            fj fj2 = aa.a(bu2, q2);
            if (fj2 == a2) {
                this.a(a2, c2, n4, n2);
                if (n3 == 0) return;
            }
            if (!(fj2 instanceof a)) return;
            a a3 = (a)fj2;
            this.a(a3, aa.a(c2, a3), n4, n2);
            return;
        }
        finally {
            bu2.s();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(a a2, c c2, int n2, int n3) {
        boolean bl2 = this.b(a2);
        if (bl2) {
            this.a(a2, false);
        }
        try {
            Rectangle2D rectangle2D = c2.h();
            c2.a(n3);
            this.a(a2, c2.g(), n2, n3, rectangle2D, c2.h(), true);
            return;
        }
        finally {
            if (bl2) {
                this.a(a2, bl2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(f f2, int n2) {
        int n3 = a.H;
        a a2 = a.a(f2);
        bu bu2 = this.a(a2);
        int n4 = f2.b();
        if (n4 == n2) return;
        if (bu2 == null) {
            f2.a(n2);
            if (n3 == 0) return;
        }
        bu2.r();
        try {
            q q2 = a2.getNode();
            bu2.a(new y.c.y(q2).a());
            fj fj2 = aa.a(bu2, q2);
            if (fj2 == a2) {
                this.a(a2, f2, n4, n2);
                if (n3 == 0) return;
            }
            if (!(fj2 instanceof a)) return;
            a a3 = (a)fj2;
            this.a(a3, aa.a(f2, a3), n4, n2);
            return;
        }
        finally {
            bu2.s();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(a a2, f f2, int n2, int n3) {
        boolean bl2 = this.b(a2);
        if (bl2) {
            this.a(a2, false);
        }
        try {
            Rectangle2D rectangle2D = f2.h();
            f2.a(n3);
            this.a(a2, f2.g(), n2, n3, rectangle2D, f2.h(), false);
            return;
        }
        finally {
            if (bl2) {
                this.a(a2, bl2);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void a(a var1_1, double var2_2, int var4_3, int var5_4, Rectangle2D var6_5, Rectangle2D var7_6, boolean var8_7) {
        var9_8 = aa.a(var7_6, var8_7);
        var11_9 = aa.a(var6_5, var8_7);
        var13_10 = aa.b(var6_5, var8_7);
        var15_11 = aa.b(var7_6, var8_7);
        var17_12 = new y.c.y();
        var18_13 = new z();
        this.a(var1_1.getNode(), var6_5, var17_12, (Collection)var18_13);
        if (var5_4 <= var4_3) ** GOTO lbl-1000
        var19_14 = new y.c.y();
        var20_15 = new z();
        this.a(var1_1.getNode(), aa.a(var6_5, var13_10, var15_11 - var13_10, var8_7), var19_14, (Collection)var20_15);
        this.a(var1_1, var19_14, var20_15, - var2_2, var8_7);
        if (a.H != 0) lbl-1000: // 2 sources:
        {
            if (var5_4 < var4_3) {
                var19_14 = new y.c.y();
                var20_15 = new z();
                this.a(var1_1.getNode(), aa.a(var6_5, var9_8, var11_9 - var9_8, var8_7), var19_14, (Collection)var20_15);
                this.a(var1_1, var19_14, var20_15, var2_2, var8_7);
            }
        }
        this.a(var1_1, var17_12, var18_13, var9_8 - var11_9, var8_7);
    }

    private static Rectangle2D a(Rectangle2D rectangle2D, double d2, double d3, boolean bl2) {
        if (!bl2) return new Rectangle2D.Double(rectangle2D.getX(), d2, rectangle2D.getWidth(), d3);
        return new Rectangle2D.Double(d2, rectangle2D.getY(), d3, rectangle2D.getHeight());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean a(f f2, double d2, boolean bl2) {
        int n2 = a.H;
        a a2 = a.a(f2);
        double d3 = this.a(f2);
        if (d3 > d2) {
            return false;
        }
        bu bu2 = this.a(a2);
        if (bu2 == null) {
            this.a(a2, f2, d2, bl2);
            if (n2 == 0) return true;
        }
        bu2.r();
        try {
            q q2 = a2.getNode();
            bu2.a(new y.c.y(q2).a());
            fj fj2 = aa.a(bu2, q2);
            if (fj2 == a2) {
                this.a(a2, f2, d2, bl2);
                if (n2 == 0) return true;
            }
            if (!(fj2 instanceof a)) throw new IllegalStateException();
            a a3 = (a)fj2;
            this.a(a3, aa.a(f2, a3), d2, bl2);
            if (n2 == 0) return true;
            throw new IllegalStateException();
        }
        finally {
            bu2.s();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(a a2, f f2, double d2, boolean bl2) {
        int n2 = a.H;
        boolean bl3 = this.b(a2);
        if (bl3) {
            this.a(a2, false);
        }
        try {
            Object object;
            double d3 = d2 - f2.g();
            Rectangle2D rectangle2D = f2.h();
            g g2 = f2;
            while (g2 instanceof f) {
                object = g2;
                object.b(object.g() + d3);
                g2 = object.a();
                if (n2 == 0) continue;
            }
            object = new y.c.y();
            double d4 = bl2 ? rectangle2D.getY() : rectangle2D.getY() + rectangle2D.getHeight();
            z z2 = new z();
            this.a(a2.getNode(), new Rectangle2D.Double(a2.getX(), d4, a2.getWidth(), a2.getHeight() - d4 + a2.getY()), (Collection)object, (Collection)z2);
            this.a(a2, (y.c.y)object, z2, d3, false);
            boolean bl4 = a2.k();
            a2.c(false);
            a2.setFrame(a2.getX(), a2.getY(), a2.getWidth(), a2.getHeight() + d3);
            a2.c(bl4);
            return;
        }
        finally {
            if (bl3) {
                this.a(a2, bl3);
            }
        }
    }

    double a(f f2) {
        double d2;
        int n2 = a.H;
        double d3 = f2.g() - f2.f();
        g g2 = f2;
        while (g2 instanceof f) {
            double d4;
            f f3;
            block5 : {
                f3 = g2;
                r r2 = f3.i();
                Iterator iterator = f3.o().iterator();
                d2 = 0.0;
                if (n2 != 0) return d2;
                d4 = d2;
                while (iterator.hasNext()) {
                    f f4 = (f)iterator.next();
                    d4 += f4.g();
                    if (n2 == 0) {
                        if (n2 == 0) continue;
                    }
                    break block5;
                }
                if (r2 != null) {
                    d4 += r2.a + r2.c;
                }
            }
            if (f3 != f2) {
                d4 -= d3;
            }
            d4 = Math.max(f3.f(), d4);
            d3 = Math.max(0.0, Math.min(d3, f3.g() - d4));
            g2 = f3.a();
            if (n2 == 0) continue;
        }
        d2 = f2.g() - d3;
        return d2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean a(c c2, double d2, boolean bl2) {
        int n2 = a.H;
        a a2 = a.a(c2);
        double d3 = this.a(c2);
        if (d3 > d2) {
            return false;
        }
        bu bu2 = this.a(a2);
        if (bu2 == null) {
            this.a(a2, c2, d2, bl2);
            if (n2 == 0) return true;
        }
        bu2.r();
        try {
            q q2 = a2.getNode();
            bu2.a(new y.c.y(q2).a());
            fj fj2 = aa.a(bu2, q2);
            if (fj2 == a2) {
                this.a(a2, c2, d2, bl2);
                if (n2 == 0) return true;
            }
            if (!(fj2 instanceof a)) throw new IllegalStateException();
            a a3 = (a)fj2;
            this.a(a3, aa.a(c2, a3), d2, bl2);
            if (n2 == 0) return true;
            throw new IllegalStateException();
        }
        finally {
            bu2.s();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(a a2, c c2, double d2, boolean bl2) {
        int n2 = a.H;
        boolean bl3 = this.b(a2);
        if (bl3) {
            this.a(a2, false);
        }
        try {
            Object object;
            double d3 = d2 - c2.g();
            Rectangle2D rectangle2D = c2.h();
            d d4 = c2;
            while (d4 instanceof c) {
                object = d4;
                object.b(object.g() + d3);
                d4 = object.a();
                if (n2 == 0) continue;
            }
            object = new y.c.y();
            double d5 = bl2 ? rectangle2D.getX() : rectangle2D.getX() + rectangle2D.getWidth();
            z z2 = new z();
            this.a(a2.getNode(), new Rectangle2D.Double(d5, a2.getY(), a2.getWidth() - d5 + a2.getX(), a2.getHeight()), (Collection)object, (Collection)z2);
            this.a(a2, (y.c.y)object, z2, d3, true);
            boolean bl4 = a2.k();
            a2.c(false);
            a2.setFrame(a2.getX(), a2.getY(), a2.getWidth() + d3, a2.getHeight());
            a2.c(bl4);
            return;
        }
        finally {
            if (bl3) {
                this.a(a2, bl3);
            }
        }
    }

    double a(c c2) {
        double d2;
        int n2 = a.H;
        double d3 = c2.g() - c2.f();
        d d4 = c2;
        while (d4 instanceof c) {
            double d5;
            c c3;
            block5 : {
                c3 = d4;
                r r2 = c3.i();
                Iterator iterator = c3.l().iterator();
                d2 = 0.0;
                if (n2 != 0) return d2;
                d5 = d2;
                while (iterator.hasNext()) {
                    c c4 = (c)iterator.next();
                    d5 += c4.g();
                    if (n2 == 0) {
                        if (n2 == 0) continue;
                    }
                    break block5;
                }
                if (r2 != null) {
                    d5 += r2.b + r2.d;
                }
            }
            if (c3 != c2) {
                d5 -= d3;
            }
            d5 = Math.max(c3.f(), d5);
            d3 = Math.max(0.0, Math.min(d3, c3.g() - d5));
            d4 = c3.a();
            if (n2 == 0) continue;
        }
        d2 = c2.g() - d3;
        return d2;
    }

    public boolean a() {
        return this.a;
    }

    static c a(c c2, a a2) {
        return aa.a(c2, a2, new ArrayList());
    }

    static c a(c c2, a a2, List list) {
        c c3;
        int n2 = a.H;
        list.clear();
        list.add(c2);
        d d2 = c2.a();
        while (d2 instanceof c) {
            list.add(d2);
            d2 = ((c)d2).a();
            if (n2 == 0) continue;
        }
        d d3 = a2.l();
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            c c4 = (c)listIterator.previous();
            c3 = d3.b(c4.b());
            if (n2 != 0) return c3;
            d3 = c3;
            if (n2 == 0) continue;
        }
        c3 = (c)d3;
        return c3;
    }

    static d a(d d2, a a2, List list) {
        if (!(d2 instanceof i)) return aa.a((c)d2, a2, list);
        return a2.l();
    }

    static f a(f f2, a a2) {
        return aa.a(f2, a2, new ArrayList());
    }

    static f a(f f2, a a2, List list) {
        f f3;
        int n2 = a.H;
        list.clear();
        list.add(f2);
        g g2 = f2.a();
        while (g2 instanceof f) {
            list.add(g2);
            g2 = ((f)g2).a();
            if (n2 == 0) continue;
        }
        g g3 = a2.l();
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            f f4 = (f)listIterator.previous();
            f3 = g3.c(f4.b());
            if (n2 != 0) return f3;
            g3 = f3;
            if (n2 == 0) continue;
        }
        f3 = (f)g3;
        return f3;
    }

    static g a(g g2, a a2, List list) {
        if (!(g2 instanceof i)) return aa.a((f)g2, a2, list);
        return a2.l();
    }

    static fj a(bu bu2, q q2) {
        fj fj2 = bu2.t(q2);
        if (!(fj2 instanceof gd)) return fj2;
        return ((gd)fj2).e();
    }
}

