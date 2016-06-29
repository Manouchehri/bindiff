/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import y.c.C;
import y.c.h;
import y.c.x;
import y.c.y;
import y.d.q;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.aG;
import y.f.aI;
import y.f.f.a.a.e;
import y.f.f.a.a.i;
import y.f.f.a.a.p;
import y.f.f.a.b;
import y.f.f.a.b.E;
import y.f.f.a.b.f;
import y.f.f.a.b.w;
import y.f.f.a.b.z;
import y.f.f.a.c;
import y.f.f.a.n;
import y.f.f.b.d;
import y.f.f.d.t;
import y.f.h.o;
import y.g.M;

public class a
extends y.f.c {
    private p n;
    private y.f.f.a.b.a o;
    private X p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private y.c.f u;
    private y v;
    private y.f.f.a w;
    private boolean x;

    public void a(y.f.f.a a2) {
        this.w = a2;
    }

    public int a() {
        return this.q;
    }

    @Override
    public boolean b(X x2) {
        return true;
    }

    @Override
    public void a(X x2) {
        block24 : {
            Object object;
            boolean bl2;
            Object object2;
            Object object3;
            Object object4;
            y.c.c c2;
            Object object5;
            Object object6;
            block23 : {
                Object object7;
                h h2;
                block22 : {
                    block21 : {
                        Object object8;
                        Object object9;
                        block20 : {
                            bl2 = y.f.f.a.f.a;
                            this.p = x2;
                            this.v = new y();
                            this.u = new y.c.f();
                            this.v.a(this.p.o());
                            this.u.a(this.p.p());
                            c2 = this.p.c(y.f.f.b.n);
                            h2 = M.b();
                            object4 = this.p.p();
                            while (object4.f()) {
                                object9 = object4.a();
                                object8 = this.a((y.c.d)object9);
                                if (!bl2) {
                                    if (object8 != null) {
                                        h2.a(object9, object8.d());
                                    }
                                    object4.g();
                                    if (!bl2) continue;
                                    y.c.i.g = !y.c.i.g;
                                    break;
                                }
                                break block20;
                            }
                            this.p.a(y.f.f.b.n, h2);
                        }
                        object4 = this.p.u();
                        object9 = this.p.c(U.a);
                        if (object9 != null) {
                            object8 = x2.p();
                            while (object8.f()) {
                                object7 = object8.a();
                                object = (S[])object9.b(object7);
                                if (!bl2) {
                                    if (object != null) {
                                        object6 = a.a((Object[])object);
                                        y.g.e.a((List)object6, (Comparator)new b());
                                        object4.a(object7, object6);
                                    }
                                    object8.g();
                                    if (!bl2) continue;
                                }
                                break;
                            }
                        } else if (this.n == null) {
                            this.n = i.a(this.p);
                        }
                        if ((object8 = this.p.c(y.f.b.f.f)) != null) {
                            object7 = new y.f.b.c(this.p);
                            object = this.p.o();
                            while (object.f()) {
                                object6 = object.e();
                                object3 = this.n.a((y.c.q)object6);
                                if (!bl2) {
                                    if (object3 != null && object3.d() && object7.d((y.c.q)object6)) {
                                        object5 = (q)object8.b(object6);
                                        object2 = this.p.r((y.c.q)object6);
                                        if (object5 != null) {
                                            this.p.b((y.c.q)object6, Math.max(object2.a, object5.a), Math.max(object2.b, object5.b));
                                        }
                                    }
                                    object.g();
                                    if (!bl2) continue;
                                }
                                break block21;
                            }
                            object7.c();
                        }
                        this.o = new y.f.f.a.b.a(this.p, this.n);
                    }
                    object7 = this.o.d().p();
                    while (object7.f()) {
                        this.o.m(object7.a());
                        object7.g();
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block22;
                    }
                    this.a((h)object4, h2);
                }
                object7 = E.a(this.o.d(), this.o.b());
                object = object7.a();
                while (object.f()) {
                    this.o.s(object.a());
                    object.g();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block23;
                }
                z.a(this.o, (h)object4, h2);
            }
            object = new y.f.f.b.a();
            object.a(this.q);
            object.a(this.w);
            object.e(false);
            object.a(this.o);
            object6 = new w(this.o, this.u);
            object6.a(this.r);
            object6.b(this.t);
            object6.a(this.s);
            object.a((o)object6);
            object.d(false);
            object3 = new y.f.f.a.f(this.o, this.u);
            object.a((d)object3);
            object5 = new c();
            object5.a(this.n);
            object5.a(this.o);
            object.a((y.f.f.b.b)object5);
            object2 = new n();
            object2.b(this.x ? 1 : 3);
            this.p.a(t.a, y.g.q.a(new Integer(5)));
            object.a((y.f.f.b.p)object2);
            object.j(this.p.c(U.b) != null);
            object.i(this.p.c(U.a) != null);
            object.a(new f((h)object4));
            object.g(false);
            object.h(false);
            object.a(false);
            object.c(this.p);
            this.n();
            this.o.a();
            new aI().c(this.p);
            if (c2 != null) {
                this.p.a(y.f.f.b.n, c2);
                if (!bl2) break block24;
            }
            this.p.d_(y.f.f.b.n);
        }
        this.n = null;
        this.o = null;
        this.p = null;
        this.u = null;
        this.v = null;
    }

    private static ArrayList a(Object[] arrobject) {
        ArrayList<Object> arrayList;
        boolean bl2 = y.f.f.a.f.a;
        ArrayList<Object> arrayList2 = new ArrayList<Object>(arrobject.length);
        for (int i2 = 0; i2 < arrobject.length; ++i2) {
            arrayList = arrayList2;
            if (bl2) return arrayList;
            arrayList.add(arrobject[i2]);
            if (!bl2) continue;
        }
        arrayList = arrayList2;
        return arrayList;
    }

    void n() {
        boolean bl2 = y.f.f.a.f.a;
        y.c.e e2 = this.p.p();
        do {
            if (!e2.f()) return;
            y.c.d d2 = e2.a();
            y.c.f f2 = this.o.x(d2);
            if (f2 != null) {
                this.p.a(f2.b().d());
            }
            e2.g();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(h var1_1, h var2_2) {
        var14_3 = y.f.f.a.f.a;
        var3_4 = this.p.p();
        var3_4.j();
        do {
            if (var3_4.f() == false) return;
            var4_5 = var3_4.a();
            if (var4_5.c() == var4_5.d()) ** GOTO lbl41
            var5_6 = this.n.a(var4_5.c());
            var7_8 = (y.f.f.a.a.b)y.f.f.a.a.n.d(var5_6, var6_7 = this.n.a(var4_5.d()));
            if (var7_8 != var5_6) ** GOTO lbl-1000
            var8_9 = (y.f.f.a.a.b)var5_6.c();
            var9_10 = this.p.d();
            this.p.b(var9_10, 0.0, 0.0);
            var10_11 = this.n.a(var8_9, var9_10);
            var8_9.a(var10_11);
            var11_12 = this.p.a(var4_5.c(), var9_10);
            var12_13 = this.p.a(var9_10, var4_5.d());
            var13_14 = new y.c.f();
            var13_14.b(var11_12);
            var13_14.b(var12_13);
            this.a(var4_5, var13_14, var1_1, false);
            this.a(var4_5, var13_14, var2_2);
            this.o.b(var4_5, var13_14);
            this.p.d(var4_5);
            if (var14_3) lbl-1000: // 2 sources:
            {
                if (var7_8 == var6_7) {
                    var8_9 = (y.f.f.a.a.b)var6_7.c();
                    var9_10 = this.p.d();
                    this.p.b(var9_10, 0.0, 0.0);
                    var10_11 = this.n.a(var8_9, var9_10);
                    var8_9.a(var10_11);
                    var11_12 = this.p.a(var4_5.c(), var9_10);
                    var12_13 = this.p.a(var9_10, var4_5.d());
                    var13_14 = new y.c.f();
                    var13_14.b(var11_12);
                    var13_14.b(var12_13);
                    this.a(var4_5, var13_14, var1_1, false);
                    this.a(var4_5, var13_14, var2_2);
                    this.o.b(var4_5, var13_14);
                    this.p.d(var4_5);
                }
            }
lbl41: // 6 sources:
            var3_4.h();
        } while (!var14_3);
    }

    private void a(y.c.d d2, y.c.f f2, h h2, boolean bl2) {
        boolean bl3 = y.f.f.a.f.a;
        ArrayList arrayList = (ArrayList)h2.b(d2);
        if (arrayList == null) return;
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList<S> arrayList2 = new ArrayList<S>();
        ArrayList<S> arrayList3 = new ArrayList<S>();
        for (S s2 : arrayList) {
            aG aG2 = s2.f();
            if (bl3) return;
            if (bl2) {
                if (aG2.i()) {
                    arrayList2.add(s2);
                    if (!bl3) continue;
                }
                arrayList3.add(s2);
                if (!bl3) continue;
            }
            if (!aG2.i() && !aG2.j()) {
                arrayList3.add(s2);
                if (!bl3) continue;
            }
            arrayList2.add(s2);
            if (!bl3) continue;
        }
        h2.a((Object)f2.b(), arrayList2);
        h2.a((Object)f2.c(), arrayList3);
    }

    private y.f.f.a a(y.c.d d2) {
        y.c.c c2 = this.p.c(y.f.f.b.n);
        if (c2 == null) return this.w;
        if (c2.b(d2) == null) return this.w;
        return (y.f.f.a)c2.b(d2);
    }

    /*
     * Exception decompiling
     */
    private void a(y.c.d var1_1, y.c.f var2_2, h var3_3) {
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
}

