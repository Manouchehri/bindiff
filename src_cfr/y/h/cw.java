/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.q;
import y.g.A;
import y.g.z;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.cd;
import y.h.cg;
import y.h.ch;
import y.h.eR;
import y.h.eU;
import y.h.fL;
import y.h.fj;
import y.h.ft;
import y.h.gY;
import y.h.x;

public class cW {
    int[] a;
    private D b;
    private D c;
    private D d;
    private D e;
    private D f;
    private D g;
    private D h;
    private D i;

    public cW(bu bu2, double d2, double d3, boolean bl2, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.a(n2, n3, n4, n5, n6, n7, n8);
        this.a(bu2, d2, d3, bl2, true, true, true, true);
    }

    public cW(ch ch2, double d2, double d3, boolean bl2, int n2) {
        this(ch2, d2, d3, bl2, n2, -1, -1, -1, -1, -1, -1);
    }

    public cW(ch ch2, double d2, double d3, boolean bl2, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        boolean bl3 = fj.z;
        this.a(n2, n3, n4, n5, n6, n7, n8);
        if (this.a.length == 0) {
            return;
        }
        int n9 = !Boolean.TRUE.equals(ch2.getClientProperty("Graph2DView.hitTestInvisibleElements")) ? 1 : 0;
        bu bu2 = ch2.getGraph2D();
        cd cd2 = ch2.getGraph2DRenderer();
        if (cd2 instanceof ft) {
            cg cg2;
            int n10;
            int n11;
            int n12;
            block15 : {
                block14 : {
                    if (ch2.getZoom() >= ch2.getPaintDetailThreshold()) {
                        cg2 = ((ft)cd2).getPaintOrder();
                        if (!bl3) break block14;
                    }
                    cg2 = ((ft)cd2).getSloppyPaintOrder();
                }
                n12 = 0;
                block8 : for (n10 = 0; n10 < this.a.length; ++n10) {
                    n11 = this.a[n10];
                    if (!bl3) {
                        switch (n11) {
                            case 0: {
                                n12 |= 4;
                                if (!bl3) continue block8;
                            }
                            case 1: {
                                n12 |= 8;
                                if (!bl3) continue block8;
                            }
                            case 2: {
                                n12 |= 32;
                                if (!bl3) continue block8;
                            }
                            case 3: {
                                n12 |= 2;
                                if (!bl3) continue block8;
                            }
                            case 4: {
                                n12 |= 1;
                                if (!bl3) continue block8;
                            }
                            case 5: {
                                n12 |= 16;
                            }
                        }
                        if (!bl3) continue;
                    }
                    break block15;
                }
                n11 = n9;
            }
            n10 = n11 != 0 ? 1 : -1;
            this.a(bu2, new A(cg2.b(bu2, n12), new gY(bu2, n10, n10, n10, n10)), d2, d3, bl2, this.a.length == 1);
            if (!bl3) return;
        }
        this.a(bu2, d2, d3, bl2, (boolean)n9, (boolean)n9, (boolean)n9, (boolean)n9);
    }

    public cW(ch ch2, double d2, double d3, boolean bl2) {
        bu bu2;
        cg cg2;
        block2 : {
            this.a(-1, -1, -1, -1, -1, -1, -1);
            bu2 = ch2.getGraph2D();
            cd cd2 = ch2.getGraph2DRenderer();
            if (!(cd2 instanceof ft)) return;
            if (ch2.getZoom() >= ch2.getPaintDetailThreshold()) {
                cg2 = ((ft)cd2).getPaintOrder();
                if (!fj.z) break block2;
            }
            cg2 = ((ft)cd2).getSloppyPaintOrder();
        }
        int n2 = !Boolean.TRUE.equals(ch2.getClientProperty("Graph2DView.hitTestInvisibleElements")) ? 1 : -1;
        this.a(bu2, new A(cg2.b(bu2, -1), new gY(bu2, n2, n2, n2, n2)), d2, d3, bl2, true);
    }

    public cW(bu bu2, Iterator iterator, double d2, double d3, boolean bl2) {
        this.a(-1, -1, -1, -1, -1, -1, -1);
        this.a(bu2, iterator, d2, d3, bl2, true);
    }

    protected cW() {
        this.a(-1, -1, -1, -1, -1, -1, -1);
    }

    protected void a(x x2) {
        this.d.add(x2);
        this.i.add(x2);
    }

    protected void a(d d2) {
        this.b.add(d2);
        this.i.add(d2);
    }

    protected void a(aA aA2) {
        this.e.add(aA2);
        this.i.add(aA2);
    }

    protected void a(q q2) {
        this.c.add(q2);
        this.i.add(q2);
    }

    protected void a(eR eR2) {
        this.f.add(eR2);
        this.i.add(eR2);
    }

    protected void a(fL fL2) {
        this.g.add(fL2);
        this.i.add(fL2);
    }

    protected void a(eU eU2) {
        this.h.add(eU2);
        this.i.add(eU2);
    }

    protected boolean a(fj fj2, double d2, double d3) {
        return fj2.contains(d2, d3);
    }

    protected boolean a(eR eR2, double d2, double d3) {
        return eR2.contains(d2, d3);
    }

    protected boolean a(aB aB2, double d2, double d3) {
        return aB2.contains(d2, d3);
    }

    protected boolean a(aA aA2, double d2, double d3) {
        return aA2.contains(d2, d3);
    }

    protected boolean a(x x2, double d2, double d3) {
        return x2.c(d2, d3);
    }

    protected boolean a(fL fL2, double d2, double d3) {
        return fL2.a(d2, d3);
    }

    protected boolean a(eU eU2, double d2, double d3) {
        return eU2.a(d2, d3);
    }

    /*
     * Exception decompiling
     */
    private void a(bu var1_1, double var2_2, double var4_3, boolean var6_4, boolean var7_5, boolean var8_6, boolean var9_7, boolean var10_8) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [16[WHILELOOP]], but top level block is 5[CASE]
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
     * Unable to fully structure code
     */
    private void a(bu var1_1, Iterator var2_2, double var3_3, double var5_4, boolean var7_5, boolean var8_6) {
        block32 : {
            var13_7 = fj.z;
            if (!var7_5) {
                do {
                    if (var2_2.hasNext() == false) return;
                    var9_8 = var2_2.next();
                    this.a(var1_1, var9_8, var3_3, var5_4);
                } while (!var13_7);
            }
            if (var8_6) ** GOTO lbl12
            var9_9 = 0;
            var10_10 = new int[this.a.length];
            ** GOTO lbl42
lbl12: // 1 sources:
            do lbl-1000: // 8 sources:
            {
                if (var2_2.hasNext() == false) return;
                var9_8 = var2_2.next();
                if (!(var9_8 instanceof d)) ** GOTO lbl19
                if (!this.a(var1_1.i((d)var9_8), var3_3, var5_4)) ** GOTO lbl-1000
                this.a((d)var9_8);
                return;
lbl19: // 1 sources:
                if (!(var9_8 instanceof q)) ** GOTO lbl23
                if (!this.a(var1_1.t((q)var9_8), var3_3, var5_4)) ** GOTO lbl-1000
                this.a((q)var9_8);
                return;
lbl23: // 1 sources:
                if (!(var9_8 instanceof fL)) ** GOTO lbl27
                if (!this.a((fL)var9_8, var3_3, var5_4)) ** GOTO lbl-1000
                this.a((fL)var9_8);
                return;
lbl27: // 1 sources:
                if (!(var9_8 instanceof x)) ** GOTO lbl31
                if (!this.a((x)var9_8, var3_3, var5_4)) ** GOTO lbl-1000
                this.a((x)var9_8);
                return;
lbl31: // 1 sources:
                if (!(var9_8 instanceof aA)) ** GOTO lbl35
                if (!this.a((aA)var9_8, var3_3, var5_4)) ** GOTO lbl-1000
                this.a((aA)var9_8);
                return;
lbl35: // 1 sources:
                if (!(var9_8 instanceof eR)) continue;
                if (!this.a((eR)var9_8, var3_3, var5_4)) ** GOTO lbl-1000
                this.a((eR)var9_8);
                return;
            } while (!(var9_8 instanceof eU) || !this.a((eU)var9_8, var3_3, var5_4));
            this.a((eU)var9_8);
            return;
lbl42: // 8 sources:
            block20 : for (var11_11 = 0; var11_11 < this.a.length; ++var11_11) {
                v0 = this.a[var11_11];
                if (!var13_7) {
                    switch (v0) {
                        case 0: {
                            var9_9 |= 4;
                            var10_10[0] = var11_11;
                            if (!var13_7) continue block20;
                        }
                        case 1: {
                            var9_9 |= 8;
                            var10_10[1] = var11_11;
                            if (!var13_7) continue block20;
                        }
                        case 2: {
                            var9_9 |= 32;
                            var10_10[2] = var11_11;
                            if (!var13_7) continue block20;
                        }
                        case 3: {
                            var9_9 |= 2;
                            var10_10[3] = var11_11;
                            if (!var13_7) continue block20;
                        }
                        case 4: {
                            var9_9 |= 1;
                            var10_10[4] = var11_11;
                            if (!var13_7) continue block20;
                        }
                        case 5: {
                            var9_9 |= 16;
                            var10_10[5] = var11_11;
                            if (!var13_7) continue block20;
                        }
                        case 6: {
                            var9_9 |= 64;
                            var10_10[6] = var11_11;
                        }
                    }
                    if (!var13_7) continue;
                }
                break block32;
            }
            v0 = this.a.length;
        }
        var11_12 = new Object[v0];
        while (var2_2.hasNext()) {
            var12_13 = var2_2.next();
            if ((var9_9 & 2) != 0 && var11_12[var10_10[3]] == null && var12_13 instanceof d) {
                if (!this.a(var1_1.i((d)var12_13), var3_3, var5_4)) continue;
                var11_12[var10_10[3]] = var12_13;
                if (var10_10[3] != 0) continue;
                break;
            }
            if ((var9_9 & 1) != 0 && var11_12[var10_10[4]] == null && var12_13 instanceof q) {
                if (!this.a(var1_1.t((q)var12_13), var3_3, var5_4)) continue;
                var11_12[var10_10[4]] = var12_13;
                if (var10_10[4] != 0) continue;
                break;
            }
            if ((var9_9 & 4) != 0 && var11_12[var10_10[0]] == null && var12_13 instanceof fL) {
                if (!this.a((fL)var12_13, var3_3, var5_4)) continue;
                var11_12[var10_10[0]] = var12_13;
                if (var10_10[0] != 0) continue;
                break;
            }
            if ((var9_9 & 8) != 0 && var11_12[var10_10[1]] == null && var12_13 instanceof x) {
                if (!this.a((x)var12_13, var3_3, var5_4)) continue;
                var11_12[var10_10[1]] = var12_13;
                if (var10_10[1] != 0) continue;
                break;
            }
            if ((var9_9 & 32) != 0 && var11_12[var10_10[2]] == null && var12_13 instanceof aA) {
                if (!this.a((aA)var12_13, var3_3, var5_4)) continue;
                var11_12[var10_10[2]] = var12_13;
                if (var10_10[2] != 0) continue;
                break;
            }
            if ((var9_9 & 16) != 0 && var11_12[var10_10[5]] == null && var12_13 instanceof eR) {
                if (!this.a((eR)var12_13, var3_3, var5_4)) continue;
                var11_12[var10_10[5]] = var12_13;
                if (var10_10[5] != 0) continue;
                break;
            }
            if ((var9_9 & 64) == 0 || var11_12[var10_10[6]] != null || !(var12_13 instanceof eU) || !this.a((eU)var12_13, var3_3, var5_4)) continue;
            var11_12[var10_10[6]] = var12_13;
            if (var10_10[6] != 0) continue;
        }
        var12_14 = 0;
        do {
            if (var12_14 >= var11_12.length) return;
            if (var11_12[var12_14] != null) {
                switch (this.a[var12_14]) {
                    case 0: {
                        this.a((fL)var11_12[var12_14]);
                        if (var13_7 == false) return;
                    }
                    case 1: {
                        this.a((x)var11_12[var12_14]);
                        if (var13_7 == false) return;
                    }
                    case 2: {
                        this.a((aA)var11_12[var12_14]);
                        if (var13_7 == false) return;
                    }
                    case 3: {
                        this.a((d)var11_12[var12_14]);
                        if (var13_7 == false) return;
                    }
                    case 4: {
                        this.a((q)var11_12[var12_14]);
                        if (var13_7 == false) return;
                    }
                    case 5: {
                        this.a((eR)var11_12[var12_14]);
                        if (var13_7 == false) return;
                    }
                    case 6: {
                        this.a((eU)var11_12[var12_14]);
                        if (var13_7 == false) return;
                    }
                }
            }
            ++var12_14;
        } while (!var13_7);
    }

    private void a(bu bu2, Object object, double d2, double d3) {
        boolean bl2 = fj.z;
        if (object instanceof d) {
            if (!this.a(bu2.i((d)object), d2, d3)) return;
            this.a((d)object);
            if (!bl2) return;
        }
        if (object instanceof q) {
            if (!this.a(bu2.t((q)object), d2, d3)) return;
            this.a((q)object);
            if (!bl2) return;
        }
        if (object instanceof fL) {
            if (!this.a((fL)object, d2, d3)) return;
            this.a((fL)object);
            if (!bl2) return;
        }
        if (object instanceof x) {
            if (!this.a((x)object, d2, d3)) return;
            this.a((x)object);
            if (!bl2) return;
        }
        if (object instanceof aA) {
            if (!this.a((aA)object, d2, d3)) return;
            this.a((aA)object);
            if (!bl2) return;
        }
        if (object instanceof eR) {
            if (!this.a((eR)object, d2, d3)) return;
            this.a((eR)object);
            if (!bl2) return;
        }
        if (!(object instanceof eU)) return;
        if (!this.a((eU)object, d2, d3)) return;
        this.a((eU)object);
    }

    public boolean a() {
        if (this.i.isEmpty()) return false;
        return true;
    }

    public boolean b() {
        if (this.c() <= 1) return false;
        return true;
    }

    int c() {
        return this.i.size();
    }

    public C d() {
        return this.i.m();
    }

    public C e() {
        return this.c.m();
    }

    public C f() {
        return this.g.m();
    }

    public C g() {
        return this.f.m();
    }

    public Object h() {
        if (!this.i.isEmpty()) return this.i.f();
        return null;
    }

    public q i() {
        if (!this.c.isEmpty()) return (q)this.c.f();
        return null;
    }

    public x j() {
        if (!this.d.isEmpty()) return (x)this.d.f();
        return null;
    }

    public d k() {
        if (!this.b.isEmpty()) return (d)this.b.f();
        return null;
    }

    public eR l() {
        if (!this.f.isEmpty()) return (eR)this.f.f();
        return null;
    }

    public aA m() {
        if (!this.e.isEmpty()) return (aA)this.e.f();
        return null;
    }

    public fL n() {
        if (!this.g.isEmpty()) return (fL)this.g.f();
        return null;
    }

    public eU o() {
        if (!this.h.isEmpty()) return (eU)this.h.f();
        return null;
    }

    public boolean p() {
        if (this.h.isEmpty()) return false;
        return true;
    }

    public boolean q() {
        if (this.g.isEmpty()) return false;
        return true;
    }

    public boolean r() {
        if (this.e.isEmpty()) return false;
        return true;
    }

    public boolean s() {
        if (this.f.isEmpty()) return false;
        return true;
    }

    public boolean t() {
        if (this.c.isEmpty()) return false;
        return true;
    }

    public boolean u() {
        if (this.b.isEmpty()) return false;
        return true;
    }

    public boolean v() {
        if (this.d.isEmpty()) return false;
        return true;
    }

    public cW a(bu bu2, double d2, double d3) {
        if (this.c() <= 1) return this;
        Object object = this.h();
        Iterator iterator = this.i.iterator();
        iterator.next();
        cW cW2 = new cW(bu2, iterator, d2, d3, false);
        cW2.a(bu2, object, d2, d3);
        return cW2;
    }

    public boolean a(cW cW2) {
        if (cW2 == null) {
            return false;
        }
        HashSet hashSet = new HashSet(this.i);
        hashSet.removeAll(cW2.i);
        if (!hashSet.isEmpty()) {
            return false;
        }
        HashSet hashSet2 = new HashSet(cW2.i);
        hashSet2.removeAll(this.i);
        return hashSet2.isEmpty();
    }

    private void a(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9;
        boolean bl2;
        int n10;
        int[] arrn;
        block9 : {
            bl2 = fj.z;
            this.g = new D();
            this.b = new D();
            this.c = new D();
            this.d = new D();
            this.e = new D();
            this.f = new D();
            this.h = new D();
            this.i = new D();
            arrn = new int[]{n2, n3, n4, n5, n6, n7, n8};
            int n11 = 0;
            for (n9 = 0; n9 < arrn.length; ++n9) {
                n10 = arrn[n9];
                if (!bl2) {
                    switch (n10) {
                        case 0: 
                        case 1: 
                        case 2: 
                        case 3: 
                        case 4: 
                        case 5: 
                        case 6: {
                            ++n11;
                        }
                    }
                    if (!bl2) continue;
                }
                break block9;
            }
            this.a = new int[n11];
            n11 = 0;
            n10 = 0;
        }
        n9 = n10;
        do {
            if (n9 >= arrn.length) return;
            switch (arrn[n9]) {
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: {
                    this.a[n11++] = arrn[n9];
                }
            }
            ++n9;
        } while (!bl2);
    }
}

