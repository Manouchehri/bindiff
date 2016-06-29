/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import java.io.PrintStream;
import y.a.K;
import y.a.P;
import y.a.h;
import y.c.A;
import y.c.B;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;
import y.g.a.g;
import y.g.a.j;

class O {
    private i a;
    private int[] b;
    private int[] c;
    private int[] d;
    private int[] e;
    private int[] f;
    private int[] g;
    private int[] h;
    private int i;
    private int j;
    private int k;
    private P l = new P();
    private boolean m = false;
    private g n;
    private boolean o = true;

    /*
     * Exception decompiling
     */
    public int a(i var1_1, c var2_2, c var3_3, c var4_4, c var5_5, y.c.h var6_6, A var7_7) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [12[DOLOOP]], but top level block is 14[WHILELOOP]
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

    public int a(i i2, c c2, c c3, c c4, y.c.h h2, A a2) {
        y.c.h h3 = i2.u();
        return this.a(i2, h3, c2, c3, c4, h2, a2);
    }

    public int a(i i2, q q2, q q3, c c2, c c3, y.c.h h2, A a2) {
        K k2 = new K();
        int n2 = k2.a(i2, q2, q3, c2, h2);
        A a3 = i2.t();
        a3.a((Object)q2, n2);
        a3.a((Object)q3, - n2);
        return this.a(i2, c2, c3, a3, h2, a2);
    }

    private void a(i i2, c c2, c c3, c c4, c c5) {
        boolean bl2;
        Object object;
        int n2;
        block11 : {
            bl2 = h.a;
            this.a = i2;
            this.i = this.a.h();
            this.j = this.a.f();
            this.b = new int[this.i];
            this.c = new int[this.i];
            this.d = new int[this.i];
            this.e = new int[this.j];
            this.f = new int[this.j];
            if (this.o) {
                this.n = new j(this.a);
            }
            int n3 = 0;
            this.k = 1;
            object = this.a.o();
            while (object.f()) {
                q q2 = object.e();
                int n4 = q2.d();
                this.e[n4] = c5.a(q2);
                n3 += this.e[n4];
                n2 = this.e[n4];
                if (!bl2) {
                    if (n2 > 0) {
                        this.k += this.e[n4];
                    }
                    object.g();
                    if (!bl2) continue;
                }
                break block11;
            }
            n2 = n3;
        }
        if (n2 != 0) {
            System.err.println("Warning: supply constraint broken!");
        }
        e e2 = this.a.p();
        do {
            if (!e2.f()) return;
            object = e2.a();
            int n5 = object.b();
            this.d[n5] = c4.a(object);
            if (c2 != null) {
                this.b[n5] = c2.a(object);
            }
            this.c[n5] = c3.a(object);
            if (this.b[n5] < 0) throw new B("found negative capacity");
            if (this.c[n5] < 0) {
                throw new B("found negative capacity");
            }
            if (this.b[n5] > this.c[n5]) {
                throw new B("found lCap > uCap");
            }
            if (this.c[n5] == Integer.MAX_VALUE) {
                this.c[n5] = this.k;
                if (this.b[n5] == Integer.MAX_VALUE) {
                    throw new B("found infinite lCap");
                }
            }
            e2.g();
        } while (!bl2);
    }

    /*
     * Exception decompiling
     */
    private q a(q var1_1, int var2_2, int[] var3_3, int[] var4_4, int[] var5_5, int[] var6_6, d[] var7_7) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[DOLOOP]], but top level block is 4[FORLOOP]
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

    private boolean a(int n2, int[] arrn) {
        boolean bl2;
        int n3;
        e e2;
        d d2;
        int n4;
        int n5;
        block11 : {
            int n6;
            block10 : {
                bl2 = h.a;
                for (n6 = 0; n6 < this.j; ++n6) {
                    this.f[n6] = Integer.MAX_VALUE;
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block10;
                }
                this.f[n2] = 0;
                arrn[n2] = 1;
            }
            int n7 = 0;
            block1 : do {
                int n8 = n7;
                int n9 = this.a.f() - 1;
                block2 : while (n8 <= n9) {
                    e2 = this.a.p();
                    if (bl2) break block11;
                    e e3 = e2;
                    while (e3.f()) {
                        d2 = e3.a();
                        n3 = d2.b();
                        n5 = d2.c().d();
                        n4 = d2.d().d();
                        n8 = this.h[n3];
                        n9 = this.c[n3];
                        if (bl2) continue block2;
                        if (n8 < n9 && this.f[n5] != Integer.MAX_VALUE && this.f[n4] > (n6 = this.f[n5] + this.d[n3])) {
                            this.f[n4] = n6;
                            arrn[n4] = 1;
                        }
                        if (this.h[n3] > 0 && this.f[n4] != Integer.MAX_VALUE && this.f[n5] > (n6 = this.f[n4] - this.d[n3])) {
                            this.f[n5] = n6;
                            arrn[n5] = 1;
                        }
                        e3.g();
                        if (!bl2) continue;
                    }
                    ++n7;
                    if (!bl2) continue block1;
                }
                break block1;
                break;
            } while (true);
            e2 = this.a.p();
        }
        e e4 = e2;
        do {
            if (!e4.f()) return (boolean)1;
            d2 = e4.a();
            n3 = d2.b();
            n5 = d2.c().d();
            n4 = d2.d().d();
            int n10 = this.f[n5];
            if (bl2) return (boolean)n10;
            if (n10 != Integer.MAX_VALUE && this.h[n3] < this.c[n3] && this.f[n4] > this.f[n5] + this.d[n3]) {
                return false;
            }
            if (this.f[n4] != Integer.MAX_VALUE && this.h[n3] > 0 && this.f[n5] > this.f[n4] - this.d[n3]) {
                return false;
            }
            e4.g();
        } while (!bl2);
        return (boolean)1;
    }
}

