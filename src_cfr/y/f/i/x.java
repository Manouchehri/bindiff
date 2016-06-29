/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.f;
import y.c.h;
import y.c.i;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.a;
import y.f.ad;
import y.f.ae;
import y.f.ah;
import y.f.am;
import y.f.i.aa;
import y.f.i.v;
import y.g.I;
import y.g.J;
import y.g.M;
import y.g.e;
import y.g.q;

public class X
extends a {
    private int a = 1000;

    public X(ah ah2) {
        this.a(ah2);
    }

    public int b() {
        return this.a;
    }

    @Override
    public void c(y.f.X x2) {
        v v2;
        Object object;
        byte by2;
        A a2;
        A a3;
        block25 : {
            Object object22;
            int n2;
            Object object3;
            block24 : {
                Object object4;
                int n3;
                Object object5;
                block23 : {
                    int n4;
                    n2 = v.f;
                    v2 = this.c();
                    if (v2 == null) {
                        throw new IllegalStateException("No OrthogonalEdgeRouter in coreLayouter");
                    }
                    if (!this.a(x2, v2)) {
                        this.a().c(x2);
                        return;
                    }
                    a3 = x2.t();
                    int n5 = Integer.MAX_VALUE;
                    int n6 = n4 = Math.min(this.b() / 4, 200);
                    n3 = n4;
                    while (n3 <= Math.max(n4, 2000)) {
                        int n7 = this.a(x2, a3, n3);
                        int n8 = x2.e() / n7;
                        object5 = object = this.a(x2, a3);
                        if (n2 == 0) {
                            if (object5 != null && object.size() < n5 && n8 < n5) {
                                n5 = object.size();
                                n6 = n3;
                            }
                            n3 = (int)((double)n3 * 2.0);
                            if (n2 == 0) continue;
                        }
                        break block23;
                    }
                    n3 = this.a(x2, a3, n6);
                    object5 = this.a(x2, a3);
                }
                Set set = object5;
                a2 = x2.t();
                object = x2.u();
                f f2 = new f();
                y y2 = new y();
                Object object6 = x2.p();
                while (object6.f()) {
                    object4 = object6.a();
                    if (a3.a(object4.c()) != a3.a(object4.d())) {
                        object.a(object4, true);
                        f2.add(object4);
                        a2.a((Object)object4.c(), true);
                        a2.a((Object)object4.d(), true);
                    }
                    object6.g();
                    if (n2 == 0) continue;
                }
                object6 = new I(x2);
                object4 = x2.p();
                while (object4.f()) {
                    if (!object.d(object4.a())) {
                        object6.a(object4.a());
                    }
                    object4.g();
                    if (n2 == 0) continue;
                }
                object4 = new I(x2);
                Object object7 = x2.o();
                while (object7.f()) {
                    if (!a2.d(object7.e())) {
                        object4.a(object7.e());
                    }
                    object7.g();
                    if (n2 == 0) continue;
                }
                object7 = null;
                if (set != null) {
                    object7 = new ArrayList(set.size());
                    for (Object object22 : set) {
                        object3 = x2.d();
                        object7.add(object3);
                        x2.b((y.c.q)object3, object22.getWidth(), object22.getHeight());
                        x2.c((y.c.q)object3, object22.getX(), object22.getY());
                        if (n2 == 0) {
                            if (n2 == 0) continue;
                        }
                        break;
                    }
                } else {
                    this.a().c(x2);
                }
                if (object7 != null) {
                    Iterator iterator = object7.iterator();
                    while (iterator.hasNext()) {
                        x2.a((y.c.q)iterator.next());
                        if (n2 == 0) {
                            if (n2 == 0) continue;
                        }
                        break;
                    }
                } else {
                    object4.f();
                    object6.f();
                }
                by2 = v2.p();
                object22 = v2.c();
                object3 = x2.c(object22);
                v2.b(2);
                x2.a(object22, q.a((c)object));
                J j2 = new J(x2, a3);
                j2.a();
                y y3 = new y();
                f f3 = new f();
                for (int i2 = 0; i2 < n3; ++i2) {
                    Integer n9 = new Integer(i2);
                    j2.b(n9);
                    this.a(f3, y3, f2, x2);
                    this.a().c(x2);
                    this.a(f3, y3, x2);
                    j2.a(n9);
                    if (n2 == 0) {
                        if (n2 == 0) continue;
                    }
                    break block24;
                }
                j2.b();
            }
            if (object3 != null) {
                x2.a(object22, (c)object3);
                if (n2 == 0) break block25;
            }
            x2.d_(object22);
        }
        v2.b(by2);
        x2.a((h)object);
        x2.a(a2);
        x2.a(a3);
    }

    v c() {
        int n2 = v.f;
        ah ah2 = this.a();
        do {
            if (!(ah2 instanceof ad)) return null;
            if (ah2 instanceof v) {
                return (v)ah2;
            }
            ah2 = ((ad)ah2).a();
        } while (n2 == 0);
        return null;
    }

    void a(f f2, y y2, y.f.X x2) {
        int n2 = v.f;
        while (!f2.isEmpty()) {
            x2.d(f2.d());
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        do {
            if (y2.isEmpty()) return;
            x2.c(y2.d());
        } while (n2 == 0);
    }

    void a(f f2, y y2, f f3, y.f.X x2) {
        int n2 = v.f;
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        f2.clear();
        y2.clear();
        Rectangle2D rectangle2D = ae.a(x2, x2.o());
        rectangle2D.setFrame(rectangle2D.getX() - 10.0, rectangle2D.getY() - 10.0, rectangle2D.getWidth() + 20.0, rectangle2D.getHeight() + 20.0);
        y.c.e e2 = f3.a();
        do {
            Object object;
            d d2;
            Object object2;
            boolean bl2 = e2.f();
            block1 : do {
                if (!bl2) return;
                d2 = e2.a();
                D d3 = x2.m(d2);
                object = d3.m();
                while (object.f()) {
                    object2 = (t)object.d();
                    bl2 = rectangle2D.contains(object2.a, object2.b);
                    if (n2 != 0) continue block1;
                    if (bl2) {
                        f2.add(d2);
                        if (d2.c().e() == null) {
                            x2.d(d2.c());
                            y2.add(d2.c());
                        }
                        if (d2.d().e() == null) {
                            x2.d(d2.d());
                            y2.add(d2.d());
                        }
                        x2.e(d2);
                        if (n2 == 0) break block1;
                    }
                    object.g();
                    if (n2 == 0) continue;
                }
                break block1;
                break;
            } while (true);
            object = x2.h(d2.c());
            double_.setFrame(object.getX(), object.getY(), object.getWidth(), object.getHeight());
            if (d2.c().e() == null && rectangle2D.intersects(double_)) {
                x2.d(d2.c());
                y2.add(d2.c());
            }
            object2 = x2.h(d2.d());
            double_.setFrame(object2.getX(), object2.getY(), object2.getWidth(), object2.getHeight());
            if (d2.d().e() == null && rectangle2D.intersects(double_)) {
                x2.d(d2.d());
                y2.add(d2.d());
            }
            e2.g();
        } while (n2 == 0);
    }

    int a(y.f.X x2, A a2, int n2) {
        y.c.q[] arrq = x2.m();
        aa aa2 = new aa(x2, true);
        aa aa3 = new aa(x2, false);
        return this.a(a2, n2, arrq, 0, arrq.length, aa2, aa3, true, 0);
    }

    int a(A a2, int n2, y.c.q[] arrq, int n3, int n4, Comparator comparator, Comparator comparator2, boolean bl2, int n5) {
        int n6 = v.f;
        int n7 = n4 - n3 - 1;
        if (n7 < n2) {
            block3 : {
                for (int i2 = n3; i2 < n4; ++i2) {
                    a2.a((Object)arrq[i2], n5);
                    if (n6 == 0) {
                        if (n6 == 0) continue;
                    }
                    break block3;
                }
                ++n5;
            }
            if (n6 == 0) return n5;
        }
        Comparator comparator3 = bl2 ? comparator : comparator2;
        e.a(arrq, n3, n4, comparator3);
        n5 = this.a(a2, n2, arrq, n3, n3 + n7 / 2, comparator, comparator2, !bl2, n5);
        return this.a(a2, n2, arrq, n3 + n7 / 2, n4, comparator, comparator2, !bl2, n5);
    }

    double b(y.f.X x2) {
        double d2;
        int n2 = v.f;
        double d3 = 0.0;
        if (x2.i()) {
            return 0.0;
        }
        x x3 = x2.o();
        while (x3.f()) {
            d2 = (d3 += x2.p(x3.e())) + x2.q(x3.e());
            if (n2 != 0) return d2;
            d3 = d2;
            x3.g();
            if (n2 == 0) continue;
        }
        d2 = d3 / (2.0 * (double)x2.e());
        return d2;
    }

    Set a(y.f.X x2, c c2) {
        double d2;
        Object object;
        int n2 = v.f;
        double d3 = this.b(x2);
        A a2 = M.a(new boolean[x2.e()]);
        Object object2 = x2.p();
        while (object2.f()) {
            d d4 = object2.a();
            if (c2.a(d4.c()) != c2.a(d4.d())) {
                a2.a((Object)d4.c(), true);
                a2.a((Object)d4.d(), true);
            }
            object2.g();
            if (n2 == 0) continue;
        }
        if ((object2 = this.a(x2, (c)a2, d3)) == null) {
            return null;
        }
        double d5 = d3;
        double d6 = object2.size();
        for (d2 = d3 / 2.0; d2 > 10.0; d2 /= 2.0) {
            object = object2 = this.a(x2, (c)a2, d2);
            if (n2 != 0) return object;
            if (object == null || (double)object2.size() >= d6) continue;
            d6 = object2.size();
            d5 = d2;
            if (n2 == 0) continue;
        }
        for (d2 = d3 * 2.0; d2 < 1000.0; d2 *= 2.0) {
            object = object2 = this.a(x2, (c)a2, d2);
            if (n2 != 0) return object;
            if (object == null || (double)object2.size() >= d6) continue;
            d6 = object2.size();
            d5 = d2;
            if (n2 == 0) continue;
        }
        object = this.a(x2, (c)a2, d5);
        return object;
    }

    /*
     * Exception decompiling
     */
    Set a(y.f.X var1_1, c var2_2, double var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[DOLOOP], 2[WHILELOOP]], but top level block is 18[SIMPLE_IF_TAKEN]
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

    boolean a(y.f.X x2, v v2) {
        if (v2.p() != 0) {
            return false;
        }
        if (x2.e() + x2.g() >= this.b()) return true;
        return false;
    }
}

