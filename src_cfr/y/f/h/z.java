/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import y.c.d;
import y.c.f;
import y.c.h;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.h.A;
import y.f.h.B;
import y.f.h.C;
import y.f.h.N;
import y.g.e;

public class z {
    private B a;
    private C b;
    private A c;
    private i d;
    private ArrayList[] e;
    private double[] f;
    private ArrayList[] g;
    private double[] h;
    private q[] i;
    private ArrayList[] j;
    private ArrayList[] k;
    private ArrayList l;
    private ArrayList m;
    private f n;
    private h o;

    public z(i i2, h h2) {
        int n2;
        boolean bl2;
        int n3;
        block3 : {
            bl2 = N.d;
            this.d = i2;
            this.o = h2;
            n2 = i2.e();
            int n4 = i2.g() + 1;
            this.e = new ArrayList[n4];
            this.f = new double[n4];
            this.g = new ArrayList[n4];
            this.h = new double[n4];
            for (n3 = 0; n3 < n4; ++n3) {
                this.e[n3] = new ArrayList(n2);
                this.g[n3] = new ArrayList(n2);
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            this.k = new ArrayList[n2];
            this.j = new ArrayList[n2];
        }
        for (n3 = 0; n3 < i2.e(); ++n3) {
            this.k[n3] = new ArrayList(n2);
            this.j[n3] = new ArrayList(n2);
            if (bl2) return;
            if (!bl2) continue;
        }
        this.n = new f();
        this.i = new q[i2.f() + 1];
        this.a = new B();
        this.b = new C();
        this.c = new A();
    }

    public ArrayList a() {
        return this.l;
    }

    public ArrayList b() {
        return this.m;
    }

    public f c() {
        return this.n;
    }

    public void a(y y2, int[] arrn) {
        boolean bl2;
        y.c.e e2;
        block29 : {
            f f2;
            block28 : {
                int n3;
                int n2;
                boolean bl3;
                d d3;
                boolean bl4;
                block27 : {
                    block26 : {
                        block25 : {
                            int n4;
                            block24 : {
                                block23 : {
                                    Object object;
                                    block22 : {
                                        bl2 = N.d;
                                        int n5 = y2.size();
                                        f2 = new f();
                                        int n6 = 0;
                                        object = y2.a();
                                        while (object.f()) {
                                            this.i[++n6] = object.e();
                                            object.g();
                                            if (!bl2) {
                                                if (!bl2) continue;
                                            }
                                            break block22;
                                        }
                                        this.n.clear();
                                    }
                                    object = y2.b();
                                    q q2 = y2.c();
                                    bl3 = false;
                                    d3 = object.b(q2);
                                    if (d3 == null) {
                                        d3 = q2.b((q)object);
                                    }
                                    if (d3 == null) {
                                        bl3 = true;
                                        d3 = this.d.a((q)object, q2);
                                    }
                                    for (n2 = 0; n2 < this.d.g(); ++n2) {
                                        this.e[n2].clear();
                                        this.f[n2] = 0.0;
                                        if (!bl2) {
                                            if (!bl2) continue;
                                        }
                                        break block23;
                                    }
                                    this.a(arrn);
                                }
                                for (n2 = n5 - 1; n2 > 0; --n2) {
                                    q q3 = this.i[n2];
                                    n4 = this.k[q3.d()].isEmpty();
                                    if (!bl2) {
                                        if (n4 != 0) continue;
                                        this.a(q3, this.i, this.e, this.f, arrn);
                                        if (!bl2) continue;
                                    }
                                    break block24;
                                }
                                this.l = new ArrayList(this.e[d3.b()]);
                                n4 = n2 = this.l.indexOf(d3);
                            }
                            if (n4 >= 0) {
                                this.l.remove(n2);
                            }
                            for (n3 = 0; n3 < this.l.size(); ++n3) {
                                d d2 = (d)this.l.get(n3);
                                f2.add(d2);
                                this.d.d(d2);
                                if (!bl2) {
                                    if (!bl2) continue;
                                }
                                break block25;
                            }
                            n3 = 0;
                        }
                        while (n3 < this.d.g()) {
                            this.e[n3].clear();
                            this.f[n3] = 0.0;
                            ++n3;
                            if (!bl2) {
                                if (!bl2) continue;
                            }
                            break block26;
                        }
                        this.a(arrn);
                    }
                    for (n3 = n5 - 1; n3 > 0; --n3) {
                        q q2 = this.i[n3];
                        bl4 = this.k[q2.d()].isEmpty();
                        if (!bl2) {
                            if (bl4) continue;
                            this.a(q2, this.i, this.e, this.f, arrn);
                            if (!bl2) continue;
                        }
                        break block27;
                    }
                    this.m = new ArrayList(this.e[d3.b()]);
                    bl4 = bl3;
                }
                if (bl4 && (n2 = this.m.indexOf(d3)) >= 0) {
                    this.m.remove(n2);
                }
                for (n3 = 0; n3 < this.m.size(); ++n3) {
                    d d2 = (d)this.m.get(n3);
                    f2.add(d2);
                    this.d.d(d2);
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block28;
                }
                if (bl3) {
                    this.d.a(d3);
                }
            }
            e2 = this.d.p();
            while (e2.f()) {
                d d3 = e2.a();
                this.n.add(d3);
                this.d.d(d3);
                e2.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block29;
            }
            e2 = f2.a();
        }
        do {
            if (!e2.f()) return;
            this.d.e(e2.a());
            e2.g();
        } while (!bl2);
    }

    /*
     * Exception decompiling
     */
    private void a(q var1_1, q[] var2_2, ArrayList[] var3_3, double[] var4_4, int[] var5_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[DOLOOP]], but top level block is 7[FORLOOP]
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

    private void a(int[] arrn) {
        boolean bl2 = N.d;
        this.a.a(arrn);
        this.b.a(arrn);
        x x2 = this.d.o();
        do {
            q q2;
            ArrayList arrayList;
            ArrayList arrayList2;
            int n2 = x2.f();
            block1 : do {
                if (n2 == 0) return;
                q2 = x2.e();
                int n3 = q2.d();
                arrayList = this.j[n3];
                arrayList.clear();
                arrayList2 = this.k[n3];
                arrayList2.clear();
                y.c.e e2 = q2.j();
                while (e2.f()) {
                    block5 : {
                        d d2 = e2.a();
                        int n4 = arrn[q2.d()];
                        int n5 = arrn[d2.a(q2).d()];
                        n2 = n4;
                        if (bl2) continue block1;
                        if (n2 < n5) {
                            arrayList2.add(d2);
                            if (!bl2) break block5;
                        }
                        arrayList.add(d2);
                    }
                    e2.g();
                    if (!bl2) continue;
                }
                break block1;
                break;
            } while (true);
            this.a.a(q2);
            e.a(arrayList, (Comparator)this.a);
            this.b.a(q2);
            e.a(arrayList2, (Comparator)this.b);
            x2.g();
        } while (!bl2);
    }
}

