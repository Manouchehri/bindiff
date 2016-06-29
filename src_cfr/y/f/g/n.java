/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import java.util.SortedSet;
import y.c.C;
import y.c.D;
import y.d.f;
import y.d.m;
import y.f.X;
import y.f.b.c;
import y.f.g.d;
import y.f.g.p;
import y.f.g.q;
import y.f.g.r;
import y.f.g.t;
import y.f.g.u;
import y.f.g.w;
import y.f.g.y;

class n {
    private X a;
    private double b = 10.0;
    private int c = Integer.MAX_VALUE;
    private int d = 10;
    private int e = 15;
    private int f = 200;
    private boolean g = false;
    private c h;
    private D i;
    private boolean j = true;
    private boolean k = false;
    private boolean l = false;
    private long m = 1000;
    private long n;
    private boolean o = true;
    private boolean p = false;
    private boolean q = true;
    private boolean r = true;

    n() {
    }

    public void a(boolean bl2) {
        this.r = bl2;
    }

    public void b(boolean bl2) {
        this.q = bl2;
    }

    public void c(boolean bl2) {
        this.p = bl2;
    }

    public void a(int n2) {
        this.f = n2;
    }

    public void d(boolean bl2) {
        this.o = bl2;
    }

    public boolean a() {
        return this.j;
    }

    public void a(long l2) {
        this.m = l2;
    }

    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.l;
    }

    public void b(int n2) {
        this.e = n2;
    }

    public boolean d() {
        return this.g;
    }

    public void c(int n2) {
        this.c = n2;
    }

    private int a(y y2) {
        int n2 = this.c == Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)Math.floor((double)this.c / this.b);
        if (y2 == null) return n2;
        return Math.min(n2, y2.c());
    }

    /*
     * Exception decompiling
     */
    public void a(X var1_1, y.c.c var2_2, y.c.c var3_3, y.c.y var4_4, y var5_5, SortedSet var6_6, boolean var7_7) {
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

    private void a(w w2, q q2) {
        boolean bl2 = d.d;
        y.d.y y2 = w2.a();
        y.d.t t2 = new y.d.t(y2.c + 0.5 * y2.a, y2.d + 0.5 * y2.b);
        if (q2.d.isEmpty()) return;
        C c2 = q2.d.m();
        do {
            block3 : {
                if (!c2.f()) return;
                u u2 = (u)c2.d();
                m m2 = u2.m();
                if (m2.c().a() == m2.d().a()) {
                    w2.a(m2.c().a() - t2.a(), 0.0);
                    if (!bl2) break block3;
                }
                w2.a(0.0, m2.c().b() - t2.b());
            }
            c2.g();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(w var1_1, y var2_2) {
        var7_3 = d.d;
        if (var2_2 == null) return;
        if (var2_2.a == null) return;
        if (var2_2.c) {
            return;
        }
        var3_4 = var2_2.a;
        var4_5 = new y.d.t(var3_4.c + 0.5 * var3_4.a, var3_4.d + 0.5 * var3_4.b);
        var5_6 = var1_1.a();
        var6_7 = new y.d.t(var5_6.c + 0.5 * var5_6.a, var5_6.d + 0.5 * var5_6.b);
        if (var3_4.b(var5_6) != false) return;
        if (var3_4.a() >= var5_6.a()) ** GOTO lbl14
        var1_1.a(var4_5.a - var6_7.a, 0.0);
        if (!var7_3) ** GOTO lbl19
lbl14: // 2 sources:
        if (var3_4.c <= var5_6.c) ** GOTO lbl-1000
        var1_1.a(var3_4.c - var5_6.c, 0.0);
        if (var7_3) lbl-1000: // 2 sources:
        {
            if (var3_4.c + var3_4.a < var5_6.c + var5_6.a) {
                var1_1.a(var3_4.c + var3_4.a - var5_6.c - var5_6.a, 0.0);
            }
        }
lbl19: // 6 sources:
        if (var3_4.b() < var5_6.b()) {
            var1_1.a(0.0, var4_5.b - var6_7.b);
            if (var7_3 == false) return;
        }
        if (var3_4.d > var5_6.d) {
            var1_1.a(0.0, var3_4.d - var5_6.d);
            if (var7_3 == false) return;
        }
        if (var3_4.d + var3_4.b >= var5_6.d + var5_6.b) return;
        var1_1.a(0.0, var3_4.d + var3_4.b - var5_6.d - var5_6.b);
    }

    private boolean e() {
        if (System.currentTimeMillis() - this.n >= this.m) return false;
        return true;
    }

    private q a(w w2, y y2, SortedSet sortedSet, boolean bl2) {
        int n2;
        int n3;
        int n4;
        D[] arrd;
        int n5;
        D d2;
        boolean bl3;
        y.d.y y3 = w2.a();
        double d3 = this.b;
        if (this.q) {
            this.b = (int)Math.ceil(Math.sqrt((y3.b() + (double)(2 * this.e)) * (y3.a() + (double)(2 * this.e)) / 150.0));
        }
        if (y2 != null) {
            y2.a(y3, this.b);
            if (!(this.g || y2 != null && y2.c || !y2.b())) {
                return null;
            }
        }
        y.d.t t2 = new y.d.t(y3.c + 0.5 * y3.a, y3.d + 0.5 * y3.b);
        D d4 = this.a(null, w2);
        r r2 = this.a(d4, false);
        D d5 = this.a(w2);
        r r3 = this.a(d5, true);
        q q2 = r3.a(r2, n2 = (int)Math.floor(t2.a / this.b), n3 = (int)Math.floor(t2.b / this.b), n5 = (int)Math.max(1.0, Math.ceil((double)this.d / this.b)), n4 = this.a(y2), bl3 = !(this.g || y2 != null && y2.c || r3.a * r3.b >= 150 && !this.q), y2, (arrd = this.a(n4, sortedSet, n2, n3))[0], d2 = this.a(arrd[1]), bl2);
        if (q2 != null) {
            w2.a((double)r3.a() * this.b, (double)r3.b() * this.b);
        }
        if (!this.q) return q2;
        this.b = d3;
        return q2;
    }

    /*
     * Exception decompiling
     */
    private D[] a(int var1_1, SortedSet var2_2, int var3_3, int var4_4) {
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

    private D a(D d2) {
        p p2 = new p(this);
        f.a(d2, p2);
        return p2.a();
    }

    /*
     * Unable to fully structure code
     */
    private boolean b(w var1_1, y var2_2) {
        var3_3 = this.b;
        var5_4 = var1_1.a();
        if (this.q) {
            this.b = (int)Math.ceil(Math.sqrt((var5_4.b() + (double)(2 * this.e)) * (var5_4.a() + (double)(2 * this.e)) / 150.0));
        }
        if (var2_2 != null) {
            var2_2.a(var5_4, this.b);
            if (!(this.g || var2_2 != null && var2_2.c || !var2_2.b())) {
                return false;
            }
        }
        var6_5 = new y.d.t(var5_4.c + 0.5 * var5_4.a, var5_4.d + 0.5 * var5_4.b);
        var7_6 = this.a(var2_2, var1_1);
        var8_7 = this.a(var7_6, false);
        var9_8 = this.a(var1_1);
        var10_9 = this.a(var9_8, true);
        var16_15 = var10_9.a(var8_7, var11_10 = (int)Math.floor(var6_5.a / this.b), var12_11 = (int)Math.floor(var6_5.b / this.b), var13_12 = (int)Math.max(1.0, Math.ceil((double)this.d / this.b)), var14_13 = this.a(var2_2), var2_2, var15_14 = !(this.g != false || var2_2 != null && var2_2.c != false || var10_9.a * var10_9.b >= 150 && this.q == false));
        if (!var16_15) ** GOTO lbl-1000
        var1_1.a((double)var10_9.a() * this.b, (double)var10_9.b() * this.b);
        if (d.d) lbl-1000: // 2 sources:
        {
            if (var2_2 != null && (this.g || var2_2.c)) {
                var14_13 = this.a((y)null);
                var7_6 = this.a(null, var1_1);
                var8_7 = this.a(var7_6, false);
                var2_2.a(false);
                var16_15 = var10_9.a(var8_7, var11_10, var12_11, var13_12, var14_13, var2_2, false);
                var2_2.a(true);
                if (var16_15) {
                    var1_1.a((double)var10_9.a() * this.b, (double)var10_9.b() * this.b);
                }
            }
        }
        if (this.q == false) return var16_15;
        this.b = var3_3;
        return var16_15;
    }

    static u a(m m2, double d2) {
        int n2 = m2 instanceof u ? ((u)m2).l() : 100;
        y.d.t t2 = m2.c();
        y.d.t t3 = m2.d();
        y.d.t t4 = new y.d.t((int)Math.floor(t2.a / d2), (int)Math.floor(t2.b / d2));
        y.d.t t5 = new y.d.t((int)Math.floor(t3.a / d2), (int)Math.floor(t3.b / d2));
        return new u(t4, t5, n2, m2);
    }

    /*
     * Exception decompiling
     */
    private D a(y var1_1, w var2_2) {
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
     * Unable to fully structure code
     */
    private D a(w var1_1) {
        var5_2 = d.d;
        var2_3 = new D();
        var3_4 = var1_1.c().m();
        do {
            if (var3_4.f() == false) return var2_3;
            var4_5 = (t)var3_4.d();
            if (this.a() || !var4_5.a()) ** GOTO lbl10
            var2_3.add(var4_5);
            if (!var5_2) ** GOTO lbl15
lbl10: // 2 sources:
            if (this.c() || var4_5.c != 1) ** GOTO lbl-1000
            var2_3.add(var4_5);
            if (var5_2) lbl-1000: // 2 sources:
            {
                if (!this.b() && var4_5.c == 0) {
                    var2_3.add(var4_5);
                }
            }
lbl15: // 6 sources:
            var3_4.g();
        } while (!var5_2);
        return var2_3;
    }

    /*
     * Exception decompiling
     */
    private r a(D var1_1, boolean var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [11[SIMPLE_IF_TAKEN]], but top level block is 1[WHILELOOP]
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

    static void a(r r2, double d2, double d3, double d4, double d5, double d6) {
        int n2;
        int n3;
        int n4;
        int n5;
        block28 : {
            int n6;
            double d7;
            int n7;
            double d8;
            double d9;
            int n8;
            double d10;
            int n9;
            boolean bl2 = d.d;
            double d11 = d4 - d2;
            double d12 = d5 - d3;
            double d13 = 0.1;
            if (d6 > 1.0) {
                for (int i2 = 1 + (int)Math.rint((double)d6); i2 > 0; d13 /= 10.0, i2 /= 10) {
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break;
                }
            } else {
                d13 = Math.min(d13, 1.0E-5);
            }
            double d14 = 0.1;
            if (d6 > 1.0) {
                for (n6 = 1 + (int)Math.rint((double)d6); n6 > 0; d14 /= 10.0, n6 /= 10) {
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break;
                }
            } else {
                d14 = Math.min(d14, 1.0E-5);
                n6 = (int)Math.floor(d2 / d6);
            }
            int n10 = (int)Math.floor(d3 / d6);
            n2 = (int)Math.floor(d4 / d6);
            n5 = (int)Math.floor(d5 / d6);
            int n11 = n2 - n6;
            int n12 = n5 - n10;
            if (n11 == 0 || Math.abs(d11) < d13) {
                r2.a(n6, Math.min(n10, n5), n6 + 1, Math.max(n10, n5) + 1);
                if (!bl2) return;
            }
            if (n12 == 0 || Math.abs(d12) < d14) {
                r2.a(Math.min(n6, n2), n10, Math.max(n6, n2) + 1, n10 + 1);
                if (!bl2) return;
            }
            if (Math.abs(d11) > Math.abs(d12)) {
                int n13;
                int n14;
                block26 : {
                    if (n6 > n2) {
                        int n15;
                        int n16;
                        block25 : {
                            d9 = d12 / d11;
                            d7 = d5;
                            d8 = (Math.floor(d4 / d6) + 1.0 - (double)n2) * d9 + d5;
                            d10 = d6 * d9;
                            for (n8 = n2; n8 < n6; d8 += d10, ++n8) {
                                n7 = (int)Math.floor(d7 / d6);
                                n9 = (int)Math.floor(d8 / d6);
                                r2.a(n8, n7, true);
                                n15 = n7;
                                n16 = n9;
                                if (!bl2) {
                                    if (n15 != n16 && n8 < n6) {
                                        r2.a(n8, n9, true);
                                    }
                                    d7 = d8;
                                    if (!bl2) continue;
                                }
                                break block25;
                            }
                            n8 = (int)Math.floor(d7 / d6);
                            r2.a(n6, n8, true);
                            n15 = n8;
                            n16 = n10;
                        }
                        if (n15 == n16) return;
                        r2.a(n6, n10, true);
                        if (!bl2) return;
                    }
                    d9 = d12 / d11;
                    d7 = d3;
                    d8 = (Math.floor(d2 / d6) + 1.0 - (double)n6) * d9 + d3;
                    d10 = d6 * d9;
                    for (n8 = n6; n8 < n2; d8 += d10, ++n8) {
                        n7 = (int)Math.floor(d7 / d6);
                        n9 = (int)Math.floor(d8 / d6);
                        r2.a(n8, n7, true);
                        n14 = n7;
                        n13 = n9;
                        if (!bl2) {
                            if (n14 != n13) {
                                r2.a(n8, n9, true);
                            }
                            d7 = d8;
                            if (!bl2) continue;
                        }
                        break block26;
                    }
                    n8 = (int)Math.floor(d7 / d6);
                    r2.a(n2, n8, true);
                    n14 = n8;
                    n13 = n5;
                }
                if (n14 == n13) return;
                r2.a(n2, n5, true);
                if (!bl2) return;
            }
            if (n10 > n5) {
                int n17;
                int n18;
                block27 : {
                    d9 = d11 / d12;
                    d7 = d4;
                    d8 = (Math.floor(d5 / d6) + 1.0 - (double)n5) * d9 + d4;
                    d10 = d6 * d9;
                    for (n8 = n5; n8 < n10; d8 += d10, ++n8) {
                        n7 = (int)Math.floor(d7 / d6);
                        n9 = (int)Math.floor(d8 / d6);
                        r2.a(n7, n8, true);
                        n17 = n7;
                        n18 = n9;
                        if (!bl2) {
                            if (n17 != n18) {
                                r2.a(n9, n8, true);
                            }
                            d7 = d8;
                            if (!bl2) continue;
                        }
                        break block27;
                    }
                    n8 = (int)Math.floor(d7 / d6);
                    r2.a(n8, n10, true);
                    n17 = n8;
                    n18 = n6;
                }
                if (n17 == n18) return;
                r2.a(n6, n10, true);
                if (!bl2) return;
            }
            d9 = d11 / d12;
            d7 = d2;
            d8 = (Math.floor(d3 / d6) + 1.0 - (double)n10) * d9 + d2;
            d10 = d6 * d9;
            for (n8 = n10; n8 < n5; d8 += d10, ++n8) {
                n7 = (int)Math.floor(d7 / d6);
                n9 = (int)Math.floor(d8 / d6);
                r2.a(n7, n8, true);
                n4 = n7;
                n3 = n9;
                if (!bl2) {
                    if (n4 != n3) {
                        r2.a(n9, n8, true);
                    }
                    d7 = d8;
                    if (!bl2) continue;
                }
                break block28;
            }
            n8 = (int)Math.floor(d7 / d6);
            r2.a(n8, n5, true);
            n4 = n8;
            n3 = n2;
        }
        if (n4 == n3) return;
        r2.a(n2, n5, true);
    }

    static double a(n n2) {
        return n2.b;
    }

    static X b(n n2) {
        return n2.a;
    }

    static boolean c(n n2) {
        return n2.e();
    }

    static int d(n n2) {
        return n2.f;
    }
}

