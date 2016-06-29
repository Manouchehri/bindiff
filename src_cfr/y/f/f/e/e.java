/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import java.io.PrintStream;
import y.c.A;
import y.c.B;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.q;
import y.c.x;
import y.f.f.e.a;
import y.f.f.e.f;
import y.f.f.e.g;
import y.f.f.e.h;

class e {
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
    private g l = new g();
    private boolean m = false;
    private boolean n = true;
    private f o;
    private h[] p;
    private int[] q;
    private int r;

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

    private void a(i i2, c c2, c c3, c c4, c c5) {
        int n2;
        Object object;
        int n3;
        block10 : {
            n2 = a.a;
            this.a = i2;
            this.i = this.a.h();
            this.j = this.a.f();
            this.b = new int[this.i];
            this.c = new int[this.i];
            this.d = new int[this.i];
            this.e = new int[this.j];
            this.f = new int[this.j];
            this.o = new f(this.j);
            this.p = new h[this.j];
            this.q = new int[this.j];
            int n4 = 0;
            this.k = 1;
            object = this.a.o();
            while (object.f()) {
                q q2 = object.e();
                int n5 = q2.d();
                this.p[n5] = new h(q2, n5);
                this.e[n5] = c5.a(q2);
                n4 += this.e[n5];
                n3 = this.e[n5];
                if (n2 == 0) {
                    if (n3 > 0) {
                        this.k += this.e[n5];
                    }
                    object.g();
                    if (n2 == 0) continue;
                }
                break block10;
            }
            n3 = n4;
        }
        if (n3 != 0) {
            System.err.println("Warning: supply constraint broken!");
        }
        y.c.e e2 = this.a.p();
        do {
            if (!e2.f()) return;
            object = e2.a();
            int n6 = object.b();
            this.d[n6] = c4.a(object);
            if (c2 != null) {
                this.b[n6] = c2.a(object);
            }
            this.c[n6] = c3.a(object);
            if (this.b[n6] < 0) throw new B("found negative capacity");
            if (this.c[n6] < 0) {
                throw new B("found negative capacity");
            }
            if (this.b[n6] > this.c[n6]) {
                throw new B("found lCap > uCap");
            }
            if (this.c[n6] == Integer.MAX_VALUE) {
                this.c[n6] = this.k;
                if (this.b[n6] == Integer.MAX_VALUE) {
                    throw new B("found infinite lCap");
                }
            }
            e2.g();
        } while (n2 == 0);
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
        int n3;
        int n4;
        y.c.e e2;
        d d2;
        int n5;
        int n6;
        block11 : {
            int n7;
            block10 : {
                n3 = a.a;
                for (n7 = 0; n7 < this.j; ++n7) {
                    this.f[n7] = Integer.MAX_VALUE;
                    if (n3 == 0) {
                        if (n3 == 0) continue;
                    }
                    break block10;
                }
                this.f[n2] = 0;
                arrn[n2] = 1;
            }
            int n8 = 0;
            block1 : do {
                int n9 = n8;
                int n10 = this.a.f() - 1;
                block2 : while (n9 <= n10) {
                    e2 = this.a.p();
                    if (n3 != 0) break block11;
                    y.c.e e3 = e2;
                    while (e3.f()) {
                        d2 = e3.a();
                        n4 = d2.b();
                        n6 = d2.c().d();
                        n5 = d2.d().d();
                        n9 = this.h[n4];
                        n10 = this.c[n4];
                        if (n3 != 0) continue block2;
                        if (n9 < n10 && this.f[n6] != Integer.MAX_VALUE && this.f[n5] > (n7 = this.f[n6] + this.d[n4])) {
                            this.f[n5] = n7;
                            arrn[n5] = 1;
                        }
                        if (this.h[n4] > 0 && this.f[n5] != Integer.MAX_VALUE && this.f[n6] > (n7 = this.f[n5] - this.d[n4])) {
                            this.f[n6] = n7;
                            arrn[n6] = 1;
                        }
                        e3.g();
                        if (n3 == 0) continue;
                    }
                    ++n8;
                    if (n3 == 0) continue block1;
                }
                break block1;
                break;
            } while (true);
            e2 = this.a.p();
        }
        y.c.e e4 = e2;
        do {
            if (!e4.f()) return (boolean)1;
            d2 = e4.a();
            n4 = d2.b();
            n6 = d2.c().d();
            n5 = d2.d().d();
            int n11 = this.f[n6];
            if (n3 != 0) return (boolean)n11;
            if (n11 != Integer.MAX_VALUE && this.h[n4] < this.c[n4] && this.f[n5] > this.f[n6] + this.d[n4]) {
                return false;
            }
            if (this.f[n5] != Integer.MAX_VALUE && this.h[n4] > 0 && this.f[n6] > this.f[n5] - this.d[n4]) {
                return false;
            }
            e4.g();
        } while (n3 == 0);
        return (boolean)1;
    }
}

